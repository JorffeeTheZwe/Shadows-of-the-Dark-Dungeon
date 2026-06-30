package Day3;

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

    private int bonusDamage;





    Weapon(String name,int bonusDamage){

        super(name);

        this.bonusDamage=bonusDamage;
    }

     @Override
     public void useItem(Player player) {

         

     }

     public int getBonusDamage(){

        return this.bonusDamage;
     }
 }


class Potion extends Item{

    private int healingHp;

    Potion(String name,int healingHp){

        super(name);

        this.healingHp=healingHp;
    }


    @Override
    public void useItem(Player player) {





    }

    public int getHealingHp(){

        return this.healingHp;
    }


}


