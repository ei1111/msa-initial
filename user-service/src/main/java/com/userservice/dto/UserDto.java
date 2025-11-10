package com.userservice.dto;

import com.userservice.jpa.UserEntity;
import com.userservice.vo.ResponseUser;
import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    public UserEntity toUserEntity() {
        return UserEntity.builder()
                .email(this.email)
                .name(this.name)
                .userId(UUID.randomUUID().toString())
                .encryptedPwd("encrypted_password")
                .build();
    }

    public ResponseUser toResponseUser() {
        return ResponseUser.builder()
                .email(this.email)
                .name(this.name)
                .userId(this.userId)
                .build();
    }
}
