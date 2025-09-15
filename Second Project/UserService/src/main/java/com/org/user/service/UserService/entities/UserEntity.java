package com.org.user.service.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="User_Details")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="Name")
    private  String name;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;
    @Column(name="About")
    private String about;
}
