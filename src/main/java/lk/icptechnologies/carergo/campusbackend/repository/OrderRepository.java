package lk.icptechnologies.carergo.campusbackend.repository;

import lk.icptechnologies.carergo.campusbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
