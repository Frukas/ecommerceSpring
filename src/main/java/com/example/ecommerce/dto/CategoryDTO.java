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
public class CategoryDTO {
    private long categoryID;
    private String categoryName;
    private String serialNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    public LocalDateTime getLocalDateTime(){
        return createdAt.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    }
    
}
