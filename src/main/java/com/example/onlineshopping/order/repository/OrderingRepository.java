package com.example.onlineshopping.order.repository;

import com.example.onlineshopping.order.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderingRepository extends JpaRepository <Ordering, Long> {


}
