package Day3;

import java.util.*;

public class Player {

    private int hp;

    private String name;

    private int attackPower;

    private String inventory;

    private Room currentRoom;

    int baseAttackPower = 20;


    Player(String name, Room startingRoom,String inventory) {

        this.name = name;

        this.hp = 100;

        this.currentRoom = startingRoom;

        this.inventory=inventory;


    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;

    }

    public int getAttackPower() {

        return attackPowerDamage();
    }


    public String getInventory() {
        return inventory;
    }

    public void moveToRoom(Room nextRoom) {

        this.currentRoom = nextRoom;

    }

    public Room getCurrentRoom() {

        return this.currentRoom;


    }

    public void takeDamage(int damage) {

        hp = hp - damage;

        if (hp < 0) {

            hp = 0;

        }


    }

    public boolean isAlive() {

        return hp > 0;

    }


    public int attackPowerDamage() {

        Random random = new Random();

        int bonusRandomDamage = random.nextInt(7);


        return baseAttackPower + bonusRandomDamage;


    }

    public void setInventory(String item){

        this.inventory=item;

    }


}
