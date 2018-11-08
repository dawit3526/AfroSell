package com.eri.afrosell.service.adressService;

import com.eri.afrosell.model.UserAddress;
import com.eri.afrosell.repositories.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    public UserAddress save(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    public UserAddress getAddressByUserIdAndStatus(String userId, int status) {
        return userAddressRepository.findByUserIdAndStatus(userId, status);
    }

}
