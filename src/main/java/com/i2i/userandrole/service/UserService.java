package com.i2i.userandrole.service;

import com.i2i.userandrole.dto.UserDto;
import com.i2i.userandrole.dto.UserRequest;
import com.i2i.userandrole.mapper.UserMapper;
import com.i2i.userandrole.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto getUserById(long id){
       var user= userRepository.findById(id);
       return userMapper.userToUserDto(user.orElseThrow());

    }
    public List<UserDto> getUsers(){
        var users= userRepository.findAll();
        return userMapper.userListToUserDtoList(users);

    }

    public UserDto create(UserRequest userRequest) {
        var user = userMapper.userRequestToUser(userRequest);
        var saved = userRepository.save(user);
        return userMapper.userToUserDto(saved);
    }

    public Page<UserDto> getUsersByPagination(Pageable pageable) {
        var users = userRepository.findAll(pageable);
        return userMapper.pageUserToPageUserDto(users) ;
    }


    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public UserDto update(long id,UserRequest userRequest) {
        var user = userRepository.findById(id).orElseThrow();
        userMapper.updateToUser(userRequest,user);
        return userMapper.userToUserDto(userRepository.save(user));
    }

    public UserDto updateAll(long id,UserRequest userRequest) {
        var user = userRepository.findById(id).orElseThrow();
        userMapper.updateAllToUser(userRequest,user);
        return userMapper.userToUserDto(userRepository.save(user));
    }
}
