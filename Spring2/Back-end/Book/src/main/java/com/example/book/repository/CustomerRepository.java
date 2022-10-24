package com.example.book.repository;

import com.example.book.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select customer.*, app_user.* from customer join app_user on customer.app_user_id = app_user.id where app_user.username = :username", nativeQuery = true)
    Customer findByUsername(@Param("username") String username);

}
