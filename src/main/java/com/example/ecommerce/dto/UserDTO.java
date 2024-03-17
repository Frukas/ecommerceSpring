package com.example.ecommerce.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long userId;

    private String firstName;
    private String mail;
    private String phone;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;  
    
        public LocalDateTime getLocalDateTime(){
        return date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }    
}
