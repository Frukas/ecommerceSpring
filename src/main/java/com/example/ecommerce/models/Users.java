package com.example.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_Id", nullable=false)
    private long userId;

    private String firstName;
    private String lastName;
    private String mail;
    private String phone;
    private String password;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
