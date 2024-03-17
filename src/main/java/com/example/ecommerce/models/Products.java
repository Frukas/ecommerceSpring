package com.example.ecommerce.models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {
    
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="productId", nullable=false)
    private long productId;

    private String productName;
    
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    private float price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Products(String productName, Category category, float price,LocalDateTime createdAt, LocalDateTime updatedAt ){
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
