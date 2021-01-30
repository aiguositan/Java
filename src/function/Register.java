package function;

import entity.User;
import service.impl.UserServiceImpl;

public class Register {
    private UserService userService = new UserServiceImpl();
    /**
     * password
     * username
     * @param user
     */
    public boolean registerByUsername(User user){
        boolean bol = userService.registerUser(user);

        return false;
    }
}