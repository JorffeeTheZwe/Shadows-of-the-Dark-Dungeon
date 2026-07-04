package Day3;

import java.util.List;

public abstract class Item {



    protected String name;

    public Item(String name){

        this.name=name;
    }

    public String getName(){

        return this.name;

    }






    public abstract  void useItem(Player player);


}


 class Weapon extends Item {

    private int bonusDamage=5;





    Weapon(String name){

        super(name);


    }

     @Override
     public void useItem(Player player) {

        player.equipWeapon(this);

         System.out.println(this.getName()+" is equipped. (Bonus Damage :)"+this.getBonusDamage());



         

     }

     public int getBonusDamage(){

        return this.bonusDamage;
     }
 }


class Potion extends Item{

    private int healingHp=5;

    Potion(String name){

        super(name);

       // this.healingHp=healingHp;
    }


    @Override
    public void useItem(Player player) {

        player.heal(this.getHealingHp());





    }

    public int getHealingHp(){

        return this.healingHp;
    }


}


