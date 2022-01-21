package com.gmfp.service;


import com.gmfp.model.UserModel;
import com.gmfp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel registerUser(String username, String password)
    {
        if(username == null && password == null) {
            return null;
        }
        else
        {
            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);
            return userRepository.save(userModel);
        }
    }

    public UserModel authenticate(String username, String password)
    {
        return userRepository.findByUsernameAndPassword(username,password).orElse(null);
    }
}
