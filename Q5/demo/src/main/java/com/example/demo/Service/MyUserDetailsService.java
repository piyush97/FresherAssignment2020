package com.example.demo.Service;

import com.example.demo.Model.MyUserDetails;
import com.example.demo.Model.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmailId(emailId);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + emailId));

        return user.map(MyUserDetails::new).get();
    }
}
