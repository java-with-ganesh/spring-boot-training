package com.i2i.userandrole.controller;

import com.i2i.userandrole.dto.AuthRequest;
import com.i2i.userandrole.service.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request){
        if(request.getUsername().equals("admin") && request.getPassword().equals("nimda")){

            var token = jwtUtil.generateToken(request.getUsername(), List.of("ADMIN"));
            return ResponseEntity.ok(Map.of("token",token));
        } else{
            return ResponseEntity.status(401).body(Map.of("Error","Invalid Username/Password"));
        }
    }


}
