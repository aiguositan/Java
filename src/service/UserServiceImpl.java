package service;

import entity.User;
import service.UserService;
import util.JdbcUtil;
import util.SqlUtil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HaiPeng Wang
 * @date 2021/1/25 15:41
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private JdbcUtil jdbcUtil = new JdbcUtil();
    private SqlUtil sqlUtil = new SqlUtil();

    @Override
    public User selectUser(User user) {
        PreparedStatement ppst = null;
        ResultSet rs = null;
        User user1 = new User();
        try {
            ppst = JdbcUtil.getPrepareStatement(sqlUtil.selectUserByUserName);
            ppst.setString(1,user.getPlayer_username());
            rs = ppst.executeQuery();
            if (rs.next()){
                user1.setID(rs.getInt("ID"));
                user1.setPlayer_username(rs.getString("player_username"));
                user1.setPlay_createtime(rs.getDate("player_createtime"));
                user1.setPlayer_password(rs.getString("player_password"));
            }else {
                user1 = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(ppst);
            JdbcUtil.close();
        }
        return user1;
    }

    @Override
    public boolean registerUser(User user) {
        PreparedStatement ppst = null;
        ResultSet rs = null;
        Date date = new Date(System.currentTimeMillis());
        Boolean bol = null;
        try {
            ppst = JdbcUtil.getPrepareStatement(sqlUtil.registerUserByUsername);
            ppst.setString(1,user.getPlayer_username());
            ppst.setString(2,user.getPlayer_password());
            ppst.setDate(3, date);
            ppst.execute();
            bol = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            bol = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            bol = false;
        }finally {
            JdbcUtil.close(ppst);
            JdbcUtil.close();
            return bol;
        }
    }
}