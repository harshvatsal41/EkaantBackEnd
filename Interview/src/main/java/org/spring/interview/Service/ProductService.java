package org.spring.interview.Service;

import org.spring.interview.Entity.Product;
import org.spring.interview.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    public List<Product> searchProduct(String keyWord);
    public Product addProduct(Product product, MultipartFile file) throws IOException;
    public List<Product> getAllProduct();
}
