package Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cmd;

        Scanner scanner = new Scanner(System.in);

        Room room = new Room("DARK DUNGEON", "An old, damp room with brick walls.");

        Enemy enemy = new Enemy("Gobling");

        room.setMonsters(enemy);

        Player player = new Player("Hero", room);

        Weapon weapon = new Weapon("Rusty Sword.");

        Potion potion=new Potion("Angle Fly Regen");

        room.addItem(weapon);

        BattleSystem battleSystem = new BattleSystem(player, enemy);

        Room secondRoom = new Room("Prison Room", "Abandoned Prison Room");
        room.setExit("north", secondRoom);

        secondRoom.setExit("south", room);


        System.out.println("==============================");
        System.out.println("LOCATION: THE DARK DUNGEON");
        System.out.println("==============================");

        System.out.println("မင်းဟာ အုတ်နံရံဟောင်းတွေနဲ့ စိုစွတ်တဲ့ အခန်းကျဉ်းတစ်ခုထဲကို ရောက်နေတယ်။ \n" +
                "အခန်းရဲ့ မြောက်ဘက် [North] မှာ တံခါးအိုကြီးတစ်ခု ရှိပြီး၊ အရှေ့ဘက် [East] မှာ လမ်းကျဉ်းတစ်ခု ရှိတယ်။\n" +
                "ကြမ်းပြင်ပေါ်မှာ သံချေးတက်နေတဲ့ [Rusty Sword] တစ်ချောင်းကို တွေ့ရတယ်။");

        boolean playing = true;

        while (playing) {


            System.out.print("How do you command ? fight  flee quit go-->room  : ");
            cmd = scanner.nextLine();


            if (cmd.equalsIgnoreCase("fight")) {

                Room currentRoom3 = player.getCurrentRoom();

                if (!currentRoom3.hasMonsters()) {

                    System.out.println("Monster have been dead.");


                } else {


                    battleSystem.turnBased();

                    if (!enemy.isAlive()) {

                        currentRoom3.removeMonsters();

                    }

                }


            } else if (cmd.equalsIgnoreCase("flee")) {


                Room currentRoom4 = player.getCurrentRoom();

                if (currentRoom4.hasMonsters()) {

                    battleSystem.fleeFromEnemy();


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

                        System.out.println("You are already have in this room.");
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
