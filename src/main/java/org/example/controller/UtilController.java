package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/util")
public class UtilController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hash/{password}")
    public String hashPassword(@PathVariable String password) {
        return passwordEncoder.encode(password);
    }
}
