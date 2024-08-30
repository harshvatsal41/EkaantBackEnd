package org.spring.interview.Controller;

import org.spring.interview.Entity.Product;
import org.spring.interview.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts(Model model) {
        return productService.getAllProduct();
    }

//    @PostMapping("/product/search")
//    public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
//        List<Product> products = productService.searchProduct(keyword);
//        model.addAttribute("products", products);
//        return "products";
//    }

//    @GetMapping("/product/add")
//    public String addProductForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "add-product";
//    }

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestPart("product") Product product, @RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(productService.addProduct(product,file),HttpStatus.CREATED);
    }
}