package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private @NonNull  int newsLetterId;
    private @NonNull String name;

    public NewsLetter(int newsLetterId, String name) {
        this.newsLetterId = newsLetterId;
        this.name = name;
    }
}
