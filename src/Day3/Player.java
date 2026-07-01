package Day3;

import java.util.*;

public class Player {

    private Weapon equippedWeapon;

    List<Item> inventory;

    private int hp;

    private String name;


    private Room currentRoom;

    private int baseAttackPower = 20;


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

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void addItem(Item item) {

        this.inventory.add(item);

        System.out.println(item.getName() + "that you pick up.");

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


        if (equippedWeapon != null) {

            int weaponDamage=equippedWeapon.getBonusDamage();


            return baseAttackPower + bonusRandomDamage + weaponDamage;

        } else {

            return bonusRandomDamage + baseAttackPower;
        }


    }


    public void heal(int healingAmount) {

        this.hp = this.hp + healingAmount;

        if (this.hp > 100) {

            this.hp = 100;
        }

        System.out.println("Healed " + healingAmount + " HP. Current HP: " + this.hp);
    }

    public void equipWeapon(Weapon weapon) {

        this.equippedWeapon = weapon;

        System.out.println(this.getName() + "is " + weapon.getName() + "have been equipped.");


    }


}
