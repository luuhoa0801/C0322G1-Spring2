package com.example.book.repository;

import com.example.book.entity.AppUser;
import com.example.book.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
