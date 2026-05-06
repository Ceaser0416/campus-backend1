package lk.icptechnologies.carergo.campusbackend.repository;

import lk.icptechnologies.carergo.campusbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds all products where the stock quantity is less than the specified threshold.
     * This is useful for generating low-stock alerts.
     *
     * @param stockQuantity The threshold for stock quantity.
     * @return A list of products with low stock.
     */
    List<Product> findByStockQuantityLessThan(Integer stockQuantity);
}
