package com.example.demo.Product.Service;

import com.example.demo.Product.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductById(Integer id);
    Product createNewProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(Integer id);
}
