package util;

public class SqlUtil {

    public final String selectUserByUserName = "SELECT * FROM user WHERE player_username = ?";

    public final String SelectUserById = "SELECT * FROM user WHERE ID = ?";

    public final String registerUserByUsername = "INSERT (player_username,player_password,player_createtime) INTO user VALUES(?,?,?) ";

    public String test = "SELECT * FROM user WHERE id = 1 AND player_createtime between '2013-1-24 16:00' and '2013-1-24 18:00' ";


}