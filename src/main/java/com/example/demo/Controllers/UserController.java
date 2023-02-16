package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Core.Utilities.results.DataResult;


import com.example.demo.Services.UserService;
import com.example.demo.Core.Entities.User;
import java.util.List;


@RequestMapping("/api/users")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.add(user));
    }

    @GetMapping("/getByEmail")
    public DataResult<User> getByEmail(@RequestParam String email) {
        return this.userService.getByEmail(email);
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }
}
