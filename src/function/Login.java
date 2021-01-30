package function;

import entity.User;
import service.impl.UserServiceImpl;


public class Login {

    /**
     *
     * @param user
     * @return
     */
    public boolean loginByUsername(User user){
        UserService userService = new UserServiceImpl();
        User resultUser = userService.selectUser(user);
        if (user == null){
            return false;
        }else {
            if (resultUser.getPlayer_password().equals(user.getPlayer_password())){
                return true;
            }
            return false;
        }
    }
}