package com.medicare.controller;

import com.medicare.entity.ImageEntity;
import com.medicare.entity.Product;
import com.medicare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile") MultipartFile[] file) {
        try {
            Set<ImageEntity> images = uploadImage(file);
            product.setProductImages(images);
            return productService.addNewProduct(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Set<ImageEntity> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageEntity> imageEntities = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            ImageEntity imageEntity = new ImageEntity(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageEntities.add(imageEntity);
        }
        return imageEntities;
    }


    @GetMapping({"/getAllProducts"})
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping({"/getProductDetailsById/{productId}"})
    public Product getProductDetailsById(@PathVariable("productId") Integer productId) {
        return productService.getProductDetailsById(productId);
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping({"/deleteProduct/{productId}"})
    public void deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping("/getProductDetails/{isSingleProductCheckout}/{productId}")
    public List<Product> getProductDetails(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
                                           @PathVariable(name = "productId") Integer productId) {
        return productService.getProductDetails(isSingleProductCheckout, productId);

    }
}
