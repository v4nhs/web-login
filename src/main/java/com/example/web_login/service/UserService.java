package com.example.web_login.service;

import com.example.web_login.dto.request.UserCreationRequest;
import com.example.web_login.dto.request.UserUpdateRequest;
import com.example.web_login.dto.response.UserResponse;
import com.example.web_login.entity.User;
import com.example.web_login.exception.AppException;
import com.example.web_login.exception.ErrorCode;
import com.example.web_login.mapper.UserMapper;
import com.example.web_login.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;
    public User createUser(UserCreationRequest userCreationRequest){

        if(userRepository.existsByUsername(userCreationRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(userCreationRequest);

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user not found")));
    }
    public UserResponse updateUser(String userId, UserUpdateRequest userUpdateRequest){

        User user= userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("user not found"));

        userMapper.updateUser(user, userUpdateRequest);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

}
