package com.rest.API.repository;
import com.rest.API.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}