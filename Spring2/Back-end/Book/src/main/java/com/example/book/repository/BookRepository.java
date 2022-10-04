package com.example.book.repository;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Integer> {
//    @Query(value = "select * from book where status = 0 and `name` like :name and idCategory like :category_id", nativeQuery = true)
//    Page<Book> ListBook(@Param("name") String name,
//                        @Param("idCategory") Integer idCategory,
//                        Pageable pageable);

    @Query(value = "select * from book where category_id = :idCategory or name like :name",nativeQuery = true)
    Page<Book> findAll(@Param("idCategory") Integer idCategory,@Param("name") String name, Pageable pageable);

}
