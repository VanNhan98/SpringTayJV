package com.demojava.controller;

import com.demojava.dto.request.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO user) {
        return "User added";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,@Valid @RequestBody UserRequestDTO user) {
        System.out.println("Request update userId ="+id);
        return "User updated";
    }

    @PatchMapping("/{id}")
    public String changeStatus(@PathVariable int id, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user ="+id);
        return "User status changed";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("Request delete user ="+id);
        return "User deleted";
    }

    @GetMapping("/{id}")
    public UserRequestDTO getUserById(@PathVariable int id) {
        System.out.println("Request get user by id ="+id);
        return new UserRequestDTO("mai", "nhan", "0123","nhan@gmail.com" );
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "20") int pageSize) {
        System.out.println("Request get user list");
        return List.of(new UserRequestDTO("mai", "nhan", "0123","nhan@gmail.com" ),
                new UserRequestDTO("thanh", "quoc", "0456","thanh@gmail.com" ));

    }
}
