package com.i2i.userandrole.mapper;

import com.i2i.userandrole.dto.UserDto;
import com.i2i.userandrole.dto.UserRequest;
import com.i2i.userandrole.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

   User userDtoToUser(UserDto userDto);

   UserDto userToUserDto(User user);

   User userRequestToUser(UserRequest userRequest);

   List<User> userDtoListToUserList(List<UserDto> userDtoList);

   List<UserDto> userListToUserDtoList(List<User> userList);

   @BeanMapping(nullValuePropertyMappingStrategy= NullValuePropertyMappingStrategy.IGNORE)
   void updateToUser(UserRequest userRequest, @MappingTarget User user);

   void updateAllToUser(UserRequest userRequest, @MappingTarget User user);

   default Page<UserDto> pageUserToPageUserDto(Page<User> pageUsers){
      var userDtoList = userListToUserDtoList(pageUsers.getContent());
      return new PageImpl<>(userDtoList,pageUsers.getPageable(),pageUsers.getTotalElements());
   }
}
