/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.eri.afrosell.service.auth;
import com.eri.afrosell.exceptions.ApplicationException;
import com.eri.afrosell.model.AuthUser;
import com.eri.afrosell.model.User;
import com.eri.afrosell.model.UserToken;
import com.eri.afrosell.repositories.UserRepository;
import com.eri.afrosell.repositories.UserTokenRepository;
import com.eri.afrosell.response.util.APIStatus;
import com.eri.afrosell.service.AbstractBaseService;
import com.eri.afrosell.util.Constant;
import com.eri.afrosell.util.DateUtil;
import com.eri.afrosell.util.UniqueID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * @author Quy Duong
 */
@Component
public class AuthServiceImpl extends AbstractBaseService implements AuthService{
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private UserTokenRepository userTokenRepository;
    
    @Autowired
    AuthUserFactory authUserFactory;
    
    @Override
    public UserToken createUserToken (User userLogin, boolean keepMeLogin){
        try {
            UserToken userToken = new UserToken();
            userToken.setToken(UniqueID.getUUID());
            userToken.setCompanyId(userLogin.getCompanyId());
            userToken.setUserId(userLogin.getUserId());
            Date currentDate = new Date();
            userToken.setLoginDate(DateUtil.convertToUTC(currentDate));
            Date expirationDate = keepMeLogin ? new Date(currentDate.getTime() + Constant.DEFAULT_REMEMBER_LOGIN_MILISECONDS) : new Date(currentDate.getTime() + Constant.DEFAULT_SESSION_TIME_OUT);
            userToken.setExpirationDate(DateUtil.convertToUTC(expirationDate));
            AuthUser authUser = authUserFactory.createAuthUser(userLogin);
            // Set authUser to session data...
            userToken.setSessionData(gson.toJson(authUser));
            userTokenRepository.save(userToken);
            return userToken;
        } catch (Exception e) {
            LOGGER.error("Error create User token ", e);
            throw new ApplicationException(APIStatus.SQL_ERROR);
        }
    }

    @Override
    public User getUserByEmailAndCompanyIdAndStatus(String email, Long companyId, int status) {
        return userRepository.findByEmailAndCompanyIdAndStatus(email, companyId, Constant.USER_STATUS.ACTIVE.getStatus());
    }

    @Override
    public User getUserByUserIdAndCompanyIdAndStatus(String userId, Long companyId, int status) {
        return userRepository.findByUserIdAndCompanyIdAndStatus(userId ,companyId, Constant.USER_STATUS.ACTIVE.getStatus());
    }

    @Override
    public UserToken getUserTokenById(String id) {
        return userTokenRepository.findOne(id);
    }

    @Override
    public void deleteUserToken(UserToken userToken) {
        userTokenRepository.delete(userToken);
    }
    
}
