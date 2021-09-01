package com.example.myProject.user.service;

import com.example.myProject.user.model.entity.MyUserDetails;
import com.example.myProject.user.model.entity.User;
import com.example.myProject.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      User user = userRepository.getUserByUsername(userName);

      if(user == null) {
          throw new UsernameNotFoundException("Could not find user");
      }
        return new MyUserDetails(user);
    }
}
