package com.example.web_login.controller;

import com.example.web_login.dto.request.ApiResponse;
import com.example.web_login.dto.request.UserCreationRequest;
import com.example.web_login.dto.request.UserUpdateRequest;
import com.example.web_login.dto.response.UserResponse;
import com.example.web_login.entity.User;
import com.example.web_login.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(userCreationRequest));

        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    UserResponse getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUser(userId, userUpdateRequest);
    }
    @DeleteMapping("{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "Delete sucessfully";
    }
}
