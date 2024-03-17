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
public class OrderDetailsDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;  

    private long orderId;
    private long userID;
    private String status;
    private long productId;
    private long quantity;
    
    public LocalDateTime getLocalDateTime(){
        return date.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }   
    
}
