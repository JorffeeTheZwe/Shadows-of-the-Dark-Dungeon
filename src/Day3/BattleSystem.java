package Day3;

import java.util.Scanner;

public class BattleSystem {

    private Player player;

    private Enemy enemy;

    private Scanner scanner;

    BattleSystem(Player player, Enemy enemy) {

        this.player = player;
        this.enemy = enemy;
        this.scanner = new Scanner(System.in);


    }


    public void attackToEnemy() {

        int damageToEnemy = player.getAttackPower();

        enemy.takeDamage(damageToEnemy);



        System.out.println("You give  " + enemy.getName() + damageToEnemy + " With A Sword.");


        if (enemy.isAlive()) {

            int damageTakenFromEnemy = enemy.getAttackPower();

            player.takeDamage(damageTakenFromEnemy);



            System.out.println(enemy.getName() + " give" + damageTakenFromEnemy + "damage to you.");

        }


    }


    public void fleeFromEnemy() {

        System.out.println("You Run From Enemy.");


    }

    public void turnBased() {

        System.out.println("You face with a " + enemy.getName() + " and " + enemy.getName() + " fight you.");

        while (enemy.isAlive() && player.isAlive()) {

            System.out.println("Player [HP] : " + player.getHp() + " " + enemy.getName() + "HP :" + enemy.getHp());

            System.out.println("(1) Fight  | (2) Flee :");
            String chNum = scanner.nextLine();

            if (chNum.equals("1")) {

                attackToEnemy();

                if (!enemy.isAlive()) {

                    System.out.println("Victory you win " + enemy.getName());
                    break;


                }

                if (!player.isAlive()) {

                    System.out.println("You Defeat to " + enemy.getName());

                    break;
                }


            } else if (chNum.equals("2")) {

                fleeFromEnemy();

                break;

            }else{

                System.out.println("Wrong input.");

            }


        }




    }
}
