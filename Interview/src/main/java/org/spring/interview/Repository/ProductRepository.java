package org.spring.interview.Repository;


import org.spring.interview.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository< Product,Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
