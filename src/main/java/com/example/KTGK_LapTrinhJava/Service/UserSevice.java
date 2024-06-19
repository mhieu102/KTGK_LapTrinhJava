package com.example.KTGK_LapTrinhJava.Service;

import com.example.KTGK_LapTrinhJava.Model.User;
import com.example.KTGK_LapTrinhJava.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
