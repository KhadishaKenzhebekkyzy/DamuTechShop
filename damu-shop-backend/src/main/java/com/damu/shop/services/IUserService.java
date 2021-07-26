package com.damu.shop.services;


import com.damu.shop.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
