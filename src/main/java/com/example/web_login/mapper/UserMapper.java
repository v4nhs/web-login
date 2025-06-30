package com.example.web_login.mapper;

import com.example.web_login.dto.request.UserCreationRequest;
import com.example.web_login.dto.request.UserUpdateRequest;
import com.example.web_login.dto.response.UserResponse;
import com.example.web_login.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
