package enitty;

import lombok.Data;
import Exception.PokerCreateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Poker {

    private String flower;

    private String number;

    /**
     * 花色的权重
     * 黑桃 红桃 梅花 方片
     *  4  3    2   1
     */
    private Integer flowerWeight;

    /**
     * 2~10 JQKJ
     * 2~10 11 12 13 14
     */
    private Integer numberWeight;

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getFlowerWeight() {
        return flowerWeight;
    }

    public void setFlowerWeight(Integer flowerWeight) {
        this.flowerWeight = flowerWeight;
    }

    public Integer getNumberWeight() {
        return numberWeight;
    }

    public void setNumberWeight(Integer numberWeight) {
        this.numberWeight = numberWeight;
    }




    @Override
    public String toString() {
        return "Poker{" +
                "flower='" + flower + '\'' +
                ", number='" + number + '\'' +
                '}'+'\n';
    }

    public Poker() {
    }

    public Poker(Integer flowerWeight, Integer numberWeight) throws PokerCreateException {
        this.flowerWeight = flowerWeight;
        this.numberWeight = numberWeight;
        setShow(flowerWeight,numberWeight);
    }


    /**
     * 通过权重去设置花色和数字
     * @param flowerWeight
     * @param numberWeight
     * @throws PokerCreateException
     */
    private void setShow(Integer flowerWeight,Integer numberWeight) throws PokerCreateException {
        switch (flowerWeight){
            case 4:this.flower = "黑桃"; break;
            case 3:this.flower = "红桃"; break;
            case 2:this.flower = "梅花"; break;
            case 1:this.flower = "方片"; break;
            default: throw new PokerCreateException("Create poker error");
        }
        switch (numberWeight){
            case 2: this.number = numberWeight.toString(); break;
            case 3: this.number = numberWeight.toString(); break;
            case 4: this.number = numberWeight.toString(); break;
            case 5: this.number = numberWeight.toString(); break;
            case 6: this.number = numberWeight.toString(); break;
            case 7: this.number = numberWeight.toString(); break;
            case 8: this.number = numberWeight.toString(); break;
            case 9: this.number = numberWeight.toString(); break;
            case 10: this.number = numberWeight.toString(); break;
            case 11: this.number = "J"; break;
            case 12: this.number = "Q"; break;
            case 13: this.number = "K"; break;
            case 14: this.number = "A"; break;
            default: throw new PokerCreateException("Create poker error");
        }
    }

    public String toBinary(){
        StringBuilder stringBuilder = new StringBuilder();
        String flower = Integer.toBinaryString(flowerWeight);
        System.out.println(flower);
        String number = Integer.toBinaryString(numberWeight);
        System.out.println(number);
        stringBuilder.append(flower);
        stringBuilder.append(number);
        return stringBuilder.toString();
    }

    /**
     * 如果 poker1 > 2   1
     *            <     -1
     *            =     0
     * @param poker1
     * @param poker2
     * @return
     * @Description 比较两张扑克牌的类方法
     */
    public static Integer compare(Poker poker1,Poker poker2){
        if (poker1.getNumberWeight() > poker2.getNumberWeight()){
            return 1;
        }else {
            // < =
            if (poker1.getNumberWeight().equals(poker2.getNumberWeight())){
                //数字相等
                if (poker1.getFlowerWeight() > poker2.getFlowerWeight()){
                    return 1;
                }else if (poker1.getFlowerWeight() < poker2.getFlowerWeight()){
                    return -1;
                }else{
                    return 0;
                }
            }
            return -1;
        }
    }

    public static List<Poker> initPokerList() throws PokerCreateException {
        List<Poker> list = new ArrayList<>();
        for (int j = 1; j< 5; j++){
            for (int i =2 ; i< 15 ; i++){
                Poker tempPoker = new Poker(j,i);
                list.add(tempPoker);
            }
        }
        return list;
    }

    public static void shufflePokerArray(List<Poker> pokerList){
        Collections.shuffle(pokerList);
    }


}
