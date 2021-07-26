package com.damu.shop.services;

import com.damu.shop.entities.User;
import com.damu.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(){
    }

    public User findUserById(Long userid) {
        Optional<User> user = userRepository.findById(userid);
        return user.orElse(new User());
    }

    public List<User> getUsers() {
        return this.findAll();
    }

    public User saveUser(User user) {
//        User newuser = userRepository.findByEmail(user.getUseremail());
        user.setUserpassword(bCryptPasswordEncoder.encode(user.getUserpassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
