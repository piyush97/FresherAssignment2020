package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull int  userId;
    private @NonNull String emailId;

    public User(int userId, String emailId) {
        this.userId = userId;
        this.emailId = emailId;
    }
}
