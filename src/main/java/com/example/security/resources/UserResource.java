package com.example.security.resources;

import com.example.security.domain.User;
import com.example.security.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<String> post(){
        return ResponseEntity.ok("oiiiiiiiiiiiiiii");
    }

    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok().body("deletou");
    }
}
