package com.example.demo.Product.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
        private Integer id;
        private String title;
        private Integer price;
}
