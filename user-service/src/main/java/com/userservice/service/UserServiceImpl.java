package com.userservice.service;

import com.userservice.dto.UserDto;
import com.userservice.jpa.UserEntity;
import com.userservice.jpa.UserRepository;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    Environment env;

    UserRepository userRepository;

    public UserServiceImpl(Environment env, UserRepository userRepository) {
        this.env = env;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userDto.toUserEntity();
        return  userRepository.save(userEntity).toUserDto();
    }
}