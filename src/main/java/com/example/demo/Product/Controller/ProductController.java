package com.example.demo.Product.Controller;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAllProDuct() {

        return this.productService.getAllProduct();
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {

        return this.productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product createNewProduct(@RequestBody Product product) {
        return this.productService.createNewProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        return this.productService.deleteProduct(id);
    }
}



