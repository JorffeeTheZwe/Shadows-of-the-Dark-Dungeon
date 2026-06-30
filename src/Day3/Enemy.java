package Day3;

import java.util.*;

public class Enemy {

    private int hp;

    private String name;

  //  private String inventory;

    private int attackPower;

    int baseAttackPower=10;

 //   List<String> arr = new ArrayList<>();

    Enemy( String name /*String inventory, */) {

        this.hp = 102;
        this.name = name;
    //    this.inventory = inventory;
     //   this.attackPower = attackPower;

    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

//    public String getInventory() {
//        return inventory;
//    }

    public int getAttackPower() {
        return attackPowerDamage();
    }

    public void takeDamage(int damage) {

        hp = hp - damage;

        if (hp < 0) {

            hp = 0;

        }
    }

    public boolean isAlive(){

        return hp > 0;
    }

    public int attackPowerDamage(){

        Random random=new Random();

        int bonusRandomDamage=random.nextInt(10);

        return baseAttackPower+bonusRandomDamage;

    }
}