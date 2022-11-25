package com.medicare.service;

import com.medicare.dao.ProductDao;
import com.medicare.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product) {
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productDao.findAll();
    }

    public Product getProductDetailsById(Integer productId) {
        return productDao.findById(productId).get();
    }

    public void deleteProduct(Integer productId) {
        productDao.deleteById(productId);
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout) {
            //single product
            List<Product> productList = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            productList.add(product);
            return productList;
        } else {
            System.out.println("No Cart");
        }
        return new ArrayList<>();
    }

}
