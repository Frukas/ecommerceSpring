package com.example.ecommerce.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId", nullable=false)
    private long orderId;

    @OneToOne
    @JoinColumn( name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn( name = "productId")
    private Products product;

    private long quantity;
    private float price;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
