package com.org.user.service.UserService.repositories;

import com.org.user.service.UserService.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, String> {
}
