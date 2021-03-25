/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webshop.security;

import com.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.webshop.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByEmail(username);

        if (user == null) {

            throw new UsernameNotFoundException("User not found");
        }

        CustomUserDetails customUser = new CustomUserDetails(user);

        return customUser;
    }

}
