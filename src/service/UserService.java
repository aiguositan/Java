package service;

import entity.User;


public interface UserService {

    public User selectUser(User user);

    public boolean registerUser(User user);
}