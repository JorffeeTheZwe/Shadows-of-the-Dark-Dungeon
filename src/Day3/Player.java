package Day3;

import java.util.*;

public class Player {

    List<Item> inventory;

    private int hp;

    private String name;

    private int attackPower;


    private Room currentRoom;

    int baseAttackPower = 20;


    Player(String name, Room startingRoom) {

        this.name = name;

        this.hp = 100;

        this.currentRoom = startingRoom;

        this.inventory = new ArrayList<>();


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


    public void heal(int healingAmount) {

        this.hp = this.hp + healingAmount;

        if (this.hp > 100) {

            this.hp = 100;
        }

        System.out.println("Healed " + healingAmount + " HP. Current HP: " + this.hp);
    }


}
