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
public class Category {
    
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "category_Id", nullable=false)
    private long categoryID; 

    private String categoryName;
    private String serialNo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
