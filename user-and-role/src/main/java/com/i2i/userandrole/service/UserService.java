package com.i2i.userandrole.service;

import com.i2i.userandrole.dto.UserDto;
import com.i2i.userandrole.dto.UserRequest;
import com.i2i.userandrole.entity.User;
import com.i2i.userandrole.mapper.UserMapper;
import com.i2i.userandrole.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    private final PlatformTransactionManager platformTransactionManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto getUserById(long id){
       var user= userRepository.findById(id);
       return userMapper.userToUserDto(user.orElseThrow());

    }
    public List<UserDto> getUsers(){
        var users= userRepository.findAll();
        return userMapper.userListToUserDtoList(users);

    }

    public UserDto create(UserRequest userRequest) {
        log.info("create new user {} started",userRequest.getUsername());
       var trx = platformTransactionManager.getTransaction(TransactionDefinition.withDefaults());
        var user = userMapper.userRequestToUser(userRequest);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        var saved = userRepository.save(user);
        platformTransactionManager.commit(trx);
        log.info("user {} created",userRequest.getUsername());
        return userMapper.userToUserDto(saved);
    }

    public Page<UserDto> getUsersByPagination(Pageable pageable) {
        var users = userRepository.findAll(pageable);
        return userMapper.pageUserToPageUserDto(users) ;
    }


    public void deleteById(long id) {
        log.info("deleting user {}",id);
        entityManager.createNativeQuery("delete from users where id=:id")
                .setParameter("id",id)
                .executeUpdate();
        log.info("user {} removed",id);
    }

    public UserDto update(long id,UserRequest userRequest) {
        var user = userRepository.findById(id).orElseThrow();
        userMapper.updateToUser(userRequest,user);
        log.info("updated details for user {}",id);
        return userMapper.userToUserDto(userRepository.save(user));
    }

    public UserDto updateAll(long id,UserRequest userRequest) {
        var user = userRepository.findById(id).orElseThrow();
        userMapper.updateAllToUser(userRequest,user);
        return userMapper.userToUserDto(userRepository.save(user));
    }

    public List<UserDto> searchByUserName(String name){
        return userMapper.userListToUserDtoList( entityManager.createQuery("select u from user u where u.username= :name", User.class)
                .setParameter("name", name)
                .getResultList());
    }

    public List<UserDto> searchByName(String name){
        return userMapper.userListToUserDtoList( entityManager.createNamedQuery("User.name",User.class)
                .setParameter("name", name)
                .getResultList());
    }
}
