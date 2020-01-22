package com.example.demo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Subscription")
@Getter @Setter @NoArgsConstructor
public class Subscription {
    @Id
    private @NonNull int  subscriptionId;
    private @NonNull int userId;
    private @NonNull String userName;
    private @NonNull int newsLetterId;
    private @NonNull String newsLetterName;

    public Subscription(int subscriptionId, int userId, String userName, int newsLetterId, String newsLetterName) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.userName = userName;
        this.newsLetterId = newsLetterId;
        this.newsLetterName = newsLetterName;
    }



}
