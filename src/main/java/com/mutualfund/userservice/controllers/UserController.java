package com.mutualfund.userservice.controllers;

import com.mutualfund.commonentity.dtos.UsersDto;
import com.mutualfund.commonentity.model.ResponseModel;
import com.mutualfund.userservice.services.serviceinterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET User by ID
    @GetMapping("/{userId}")
    public ResponseModel getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }

    // GET All Users With Pagination
    @GetMapping("/")
    public ResponseModel getAllUsers(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "5") int size){
        return userService.getAllUsers(page, size);
    }

    // Update Users Details
    @PutMapping("/{userId}")
    public ResponseModel updateUser(@RequestBody UsersDto usersDto){
        return userService.updateUser(usersDto);
    }

    // Block Users Details
    @PatchMapping("/{userId}")
    public ResponseModel blockUser(@PathVariable long userId){
        return userService.blockUser(userId);
    }
}
