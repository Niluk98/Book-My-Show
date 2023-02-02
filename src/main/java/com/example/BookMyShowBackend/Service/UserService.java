package com.example.BookMyShowBackend.Service;

import com.example.BookMyShowBackend.DTO.UserRequestDTO;
import com.example.BookMyShowBackend.Model.User;
import com.example.BookMyShowBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    public  String createUser(UserRequestDTO userRequestDTO){

        User user=User.builder().name(userRequestDTO.getName()).mobileNo(userRequestDTO.getMobileNo()).build();
        try {
            userRepository.save(user);
        }catch (Exception e){
            return "user could'nt be added";
        }
        return "user added successfully";

    }
}
