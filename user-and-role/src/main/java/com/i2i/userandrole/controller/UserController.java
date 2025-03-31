package com.i2i.userandrole.controller;

import com.i2i.userandrole.LogExecutionTime;
import com.i2i.userandrole.dto.UserDto;
import com.i2i.userandrole.dto.UserRequest;
import com.i2i.userandrole.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.create(userRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.update(id, userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateAll(@PathVariable long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateAll(id, userRequest));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));

    }

    @GetMapping("/validate")
    public boolean validate() {
        return true;
    }

    @GetMapping("/search")
    public List<UserDto> searchByUserName(@RequestParam(name = "name") String name) {
        return userService.searchByName(name);
    }

    @GetMapping
    @LogExecutionTime
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/paginated")
    public Page<UserDto> getUsersByPagination(Pageable pageable) {
        return userService.getUsersByPagination(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");

    }
}
