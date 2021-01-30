package enitty;

import lombok.Data;

import java.util.Date;
import java.util.UUID;


/**
 * lombok
 * 预编译器的过程
 */
@Data
public class Record {

    private String game_ID;

    private Date game_begintime;

    private Date game_exittime;

    private Integer game_user1ID;

    private Integer game_user2ID;

    private Integer game_winner_ID;

    private String game_user1cards;

    private String game_user2cards;

    public Record() {
    }

    /**
     * UUID 会根据你当前CPU，内存，计算机运行的状态来创建一组字符串
     * 多线程
     * 永远不会重复的字符串
     * 作为索引，唯一标识
     * 123456
     *
     * @param game_ID
     * @param game_begintime
     * @param game_exittime
     * @param game_user1ID
     * @param game_user2ID
     * @param game_winner_ID
     * @param game_user1cards
     * @param game_user2cards
     */
    public Record(String game_ID, Date game_begintime, Date game_exittime, Integer game_user1ID, Integer game_user2ID, Integer game_winner_ID, String game_user1cards, String game_user2cards) {
        this.game_ID = UUID.randomUUID().toString().replace("-","");
        this.game_begintime = game_begintime;
        this.game_exittime = game_exittime;
        this.game_user1ID = game_user1ID;
        this.game_user2ID = game_user2ID;
        this.game_winner_ID = game_winner_ID;
        this.game_user1cards = game_user1cards;
        this.game_user2cards = game_user2cards;
    }
}
