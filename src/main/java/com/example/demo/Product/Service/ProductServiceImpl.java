package com.example.demo.Product.Service;

import com.example.demo.Product.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

     List<Product> products;

    public ProductServiceImpl(){
        products = new ArrayList<>();
        products.add( new Product(1, "ip5", 5));
        products.add( new Product(2, "ip6", 10));
        products.add( new Product(3, "ip7", 15));
        products.add( new Product(4,  "ip8", 20));

    }

    @Override
    public List<Product> getAllProduct() {

        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "We dont have any products");
        } else {
            return products;
        }
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> foundObject = products.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst();

        if (foundObject.isPresent()) {
            return foundObject.get();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "We dont have product with id " + id);
        }
    }

    @Override
    public Product createNewProduct(Product product) {
        Integer id = product.getId();
        if (id == null) {
             throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Required id");
        }

        Optional<Product> foundObject = products.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst();

        if (foundObject.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "We already have product id " + id);

        } else {
            products.add(product);
            return product;
        }
    }

    @Override
    public Product updateProduct(Product product){
        Integer id = product.getId();
        Integer price = product.getPrice();
        String title = product.getTitle();

        if (id == null) {
           throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "Required id");
        }

        Optional<Product> foundObject = products.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst();

        if (foundObject.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Product doesnt not exist with id  " + id);

        } else {
            Product updatingProduct = foundObject.get();
            if(title != null) updatingProduct.setTitle(title);
            if(price != null) updatingProduct.setPrice(price);

            products.add(updatingProduct);
            return updatingProduct;
        }
    }

    @Override
    public String deleteProduct(Integer id){
        Optional<Product> foundObject = products.stream()
                .filter(obj -> obj.getId().equals(id))
                .findFirst();

        if (foundObject.isPresent()) {
            products.remove(foundObject.get());
            return "Deleted product id " + id;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "We dont have product with id " + id);
        }
    }
}


