package br.com.karloskelvin.repositories;

import br.com.karloskelvin.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductByCategoryId(@Param("categoryId") long categoryId);

    Optional<Product> findByProductIdentifier(String productIdentifier);
}
