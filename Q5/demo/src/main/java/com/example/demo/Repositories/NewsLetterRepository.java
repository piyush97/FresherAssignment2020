package com.example.demo.Repositories;

import com.example.demo.Model.NewsLetter;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Integer> {
//    List<NewsLetter> findByTitleContaingOrContentContaining(String text, String textAgain);
}
