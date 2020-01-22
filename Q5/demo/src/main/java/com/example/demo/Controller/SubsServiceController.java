package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import com.example.demo.Model.NewsLetter;
import com.example.demo.Repositories.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubsServiceController {

    @Autowired
     NewsLetterRepository newsLetterRepository;

    @GetMapping("/subscriptions")
    public List<NewsLetter> index() {
        return newsLetterRepository.findAll();
    }

    @GetMapping("/subscriptions/{id}")
    public NewsLetter show(@PathVariable String id) throws Exception{
        int newsLetterId = Integer.parseInt(id);
        return newsLetterRepository.findById(newsLetterId).orElseThrow(Exception::new);
    }

    @PostMapping("/subscriptions")
    public NewsLetter create(@RequestBody NewsLetter newsLetter){
//        String name = newsLetter.get("name");
        return newsLetterRepository.save(newsLetter);
    }

    @PutMapping("/subscriptions/{id}")
    public NewsLetter update(@PathVariable String id, @RequestBody Map<String, String> body) throws Exception{
        int newsLetterId = Integer.parseInt(id);
        // getting newsletter
        NewsLetter newsLetter = newsLetterRepository.findById(newsLetterId).orElseThrow(Exception::new);
        newsLetter.setName(body.get("name"));
        return newsLetterRepository.save(newsLetter);
    }

    @DeleteMapping("subscriptions/{id}")
    public String delete(@PathVariable String id){
        int newsLetterId = Integer.parseInt(id);
        newsLetterRepository.deleteById(newsLetterId);
        return "Subscription Deleted";
    }



}
