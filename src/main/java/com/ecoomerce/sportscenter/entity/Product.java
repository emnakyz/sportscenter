package com.ecoomerce.sportscenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name="Description")
    private String description;
    @Column(name = "Price")
    private Long price;
    @Column(name = "PictureUrl")
    private String pictureUrl;
}
