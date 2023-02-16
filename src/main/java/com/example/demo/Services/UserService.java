package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repositories.UserRepository;


import com.example.demo.Core.Entities.User;
import com.example.demo.Core.Utilities.results.DataResult;
import com.example.demo.Core.Utilities.results.Result;
import com.example.demo.Core.Utilities.results.SuccessDataResult;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessDataResult<User>("Kullanıcı eklendi");
    }

    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.findByEmail(email),"Kullanıcı bulundu");
    }

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(),"Kullanıcılar listelendi");
    }
}
