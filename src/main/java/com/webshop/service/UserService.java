package com.webshop.service;

import com.webshop.model.User;

public interface UserService {

    public void save(User user);

    public String enCryptedPassword(User user);

}
