package enitty;


import lombok.Data;
import util.Md5Util;

import java.util.Date;


@Data
public class User {
    private Integer ID;

    private String player_username;

    private String player_password;

    private Date player_createtime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPlayer_username() {
        return player_username;
    }

    public void setPlayer_username(String player_username) {
        this.player_username = player_username;
    }

    public String getPlayer_password() {
        return player_password;
    }

    public void setPlayer_password(String player_password) {
        this.player_password = player_password;
    }

    public Date getPlay_createtime() {
        return player_createtime;
    }

    public void setPlay_createtime(Date play_createtime) {
        this.player_createtime = play_createtime;
    }

    /**
     * username password construction
     * @param player_username
     * @param player_password
     *
     * 用于注册的时候，和登录的时候
     */
    public User(String player_username, String player_password) {
        this.player_username = player_username;
        this.player_password = Md5Util.stringToMD5(player_password);
    }

    /**
     * 无参构造
     */
    public User() {
    }
}