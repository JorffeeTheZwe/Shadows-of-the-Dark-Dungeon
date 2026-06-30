package Day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        Room room=new Room("DARK DUNGEON","An old, damp room with brick walls.");

        Enemy enemy=new Enemy("Gobling");

        room.setMonsters(enemy);



        Player player=new Player("Hero",room," ");






        System.out.println("==============================");
        System.out.println("LOCATION: THE DARK DUNGEON");
        System.out.println("==============================");

        System.out.println("မင်းဟာ အုတ်နံရံဟောင်းတွေနဲ့ စိုစွတ်တဲ့ အခန်းကျဉ်းတစ်ခုထဲကို ရောက်နေတယ်။ \n"+
                "အခန်းရဲ့ မြောက်ဘက် [North] မှာ တံခါးအိုကြီးတစ်ခု ရှိပြီး၊ အရှေ့ဘက် [East] မှာ လမ်းကျဉ်းတစ်ခု ရှိတယ်။\n" +
                "ကြမ်းပြင်ပေါ်မှာ သံချေးတက်နေတဲ့ [Rusty Sword] တစ်ချောင်းကို တွေ့ရတယ်။");

        boolean playing = true;

        while(playing){

            System.out.println("How do you command ?");
            String cmd=scanner.nextLine();



        System.out.println("[အခြေအနေ]  ");


    }


    }



}
