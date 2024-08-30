package org.spring.interview.Service;


import com.cloudinary.Cloudinary;
import org.spring.interview.Entity.Product;
import org.spring.interview.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProduct(String keyWord) {
        return productRepository.findByNameContainingIgnoreCase(keyWord);
    }

    @Override
    public Product addProduct(Product product, MultipartFile file) throws IOException{
        if (!file.isEmpty()&&file!=null){
            product.setImageURL((String) imageUpload(file).get("secure_url"));
        }
        return productRepository.save(product);
    }

    @Autowired
    private Cloudinary cloudinary;

    public Map imageUpload(MultipartFile file){
        try {
            return this.cloudinary.uploader().upload(file.getBytes(), Map.of());
        } catch (IOException e) {
            throw new RuntimeException(e+"Image Uploading failed!!!");
        }
    }
}
