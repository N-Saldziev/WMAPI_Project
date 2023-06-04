package com.example.wmapi.repositories;

import com.example.wmapi.models.Product;
//import org.hibernate.boot.jaxb.internal.stax.JpaOrmXmlEventReader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findall();
}
