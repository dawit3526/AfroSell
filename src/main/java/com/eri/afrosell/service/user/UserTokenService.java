package com.eri.afrosell.service.user;

import com.eri.afrosell.model.UserToken;
import com.eri.afrosell.repositories.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;

    public UserToken save(UserToken userToken) {
        return userTokenRepository.save(userToken);
    }

    public UserToken getTokenById(String token) {
        return userTokenRepository.findOne(token);
    }

    public void invalidateToken(UserToken userToken) {
        userTokenRepository.delete(userToken);
    }

}
