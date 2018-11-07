package com.eri.afrosell.repositories;


import com.eri.afrosell.model.UserAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<UserAddress, String> {
    UserAddress findByUserIdAndStatus(String userId, int status);
    
    UserAddress findByAdressIdAndStatus(Long adressId, int status);
}
