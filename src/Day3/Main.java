package Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cmd;

        Scanner scanner = new Scanner(System.in);

        // အခန်း ကို စီမံရန် ၁

        Room room = new Room("DARK DUNGEON", "An old, damp room with brick walls.");

        Room secondRoom = new Room("Prison Room", "Abandoned Prison Room");

        Room thirdRoom = new Room("The Abyss Room", "In the deepest area of the east , there is a room know as The Abyss.");

        Room fourthRoom = new Room("The Dragon Room", "The room have dragon shpae.");


        // Enemy အကြောင်း စီမံရန်
        Enemy enemy = new Enemy("Gobling");

        Enemy enemy1 = new Enemy("Skeleton");

        Enemy enemy3 = new Enemy("Uchiha Madara");

        Enemy enemy4 = new Enemy("Hinata Hyuga");


        // ကစား သူ ကို စီမံရန်
        Player player = new Player("Hero", room);

        //Item တွေ အကြောင်းစီမံ ရန်

        Weapon weapon = new Weapon("Rusty Sword.");

        Potion potion = new Potion("Angle Fly Regen");


        // အခန်းကို စီမံရန် ၂

        room.setExit("north", room);

        room.setExit("south", secondRoom);

        room.setExit("east", thirdRoom);

        secondRoom.setExit("east", thirdRoom);

        secondRoom.setExit("north", room);

        secondRoom.setExit("west", fourthRoom);

        thirdRoom.setExit("south", secondRoom);

        thirdRoom.setExit("north", room);

        thirdRoom.setExit("west", fourthRoom);

        room.setExit("west", fourthRoom);

        fourthRoom.setExit("north", room);

        fourthRoom.setExit("south", secondRoom);

        fourthRoom.setExit("east", thirdRoom);


        //Item ကို စီမံရန် ၂

        room.addItem(weapon);

        secondRoom.addItem(potion);


        thirdRoom.addItem(weapon);

        fourthRoom.addItem(potion);


        //ရန်သူကို စီမံရန် ၂

        room.setMonsters(enemy);


        secondRoom.setMonsters(enemy1);


        thirdRoom.setMonsters(enemy3);

        fourthRoom.setMonsters(enemy4);


        System.out.println("==============================");
        System.out.println("LOCATION: THE DARK DUNGEON");
        System.out.println("==============================");

        System.out.println("မင်းဟာ အုတ်နံရံဟောင်းတွေနဲ့ စိုစွတ်တဲ့  အရပ်လေး မျက်နှာ အခန်းရှိတဲ့ နေရာတစ်ခုထဲကို ရောက်နေတယ်။");

        boolean playing = true;

        while (playing) {


            System.out.print("How do you command ? | fight | flee | pick up  | quit go-->room | : ");
            cmd = scanner.nextLine();


            if (cmd.equalsIgnoreCase("fight")) {

                Room currentRoom3 = player.getCurrentRoom();

                if (!currentRoom3.hasMonsters()) {

                    System.out.println("Monster have been dead.");


                } else {

                    Enemy currentEnemy = currentRoom3.getMonsters();

                    BattleSystem currentFight = new BattleSystem(player, currentEnemy);


                    currentFight.turnBased();

                    if (!currentEnemy.isAlive()) {

                        currentRoom3.removeMonsters();

                    }

                }


            } else if (cmd.equalsIgnoreCase("flee")) {


                Room currentRoom4 = player.getCurrentRoom();


                if (currentRoom4.hasMonsters()) {

                    Enemy currentEnemy = currentRoom4.getMonsters();

                    BattleSystem currentFlee = new BattleSystem(player, currentEnemy);

                    currentFlee.fleeFromEnemy();


                } else {

                    System.out.println("No enemy from run.");

                }

            } else if (cmd.equalsIgnoreCase("pick up")) {

                Room currentRoom = player.getCurrentRoom();

                if (currentRoom.hasItem()) {

                    Item foundItem = currentRoom.getItemInRoom();


                    System.out.println("You pick up :" + foundItem.getName());


                    player.addItem(foundItem);

                    foundItem.useItem(player);


                    currentRoom.removeItem(foundItem);


                } else {

                    System.out.println("No item in room for pick up.");

                }


            } else if (cmd.equalsIgnoreCase("quit")) {

                System.out.println("Exit from the game.");

                playing = false;

            } else if (cmd.toLowerCase().startsWith("go")) {

                Scanner scanner2 = new Scanner(cmd);
                scanner2.next(); //ပထမ element ကျော်

                if (scanner2.hasNext()) {

                    String direction = scanner2.next(); // ဒုတိယ element ယူ


                    Room currentRoom2 = player.getCurrentRoom();
                    Room nextRoom2 = currentRoom2.getExit(direction);


                    if (nextRoom2 != null) {


                        player.moveToRoom(nextRoom2);


                        System.out.println(player.getName() + " reach the " + nextRoom2.getName());


                    } else {

                        System.out.println("There is no room for you go");
                    }

                } else {

                    System.out.println("Enter direction you want to go.");

                }


            } else {

                System.out.println("Wrong Command");

            }


        }


    }


}
