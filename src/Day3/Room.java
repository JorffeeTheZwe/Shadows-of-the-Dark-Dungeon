package Day3;

import java.util.*;

public class Room {

    private String name;

    private String description;

    private Enemy monsters;

    Map<String, Room> exit;

    List<Item> itemInRoom;

    Room(String name, String description) {

        this.name = name;

        this.description = description;

        this.monsters = null;

        this.exit = new HashMap<>();

        this.itemInRoom=new LinkedList<>();


    }

    public void setMonsters(Enemy monsters){
        this.monsters=monsters;
    }

    public Enemy getMonsters(){

        return this.monsters;

    }


    public void removeMonsters(){

        this.monsters=null;

    }


    public boolean hasMonsters(){

      return  this.monsters != null;

    }


    public void setExit(String direction,Room neighbour) {
        exit.put(direction.toLowerCase(),neighbour);
    }

    public Room getExit(String direction){

        return exit.get(direction.toLowerCase());

    }




    public String getName() {
        return name;
    }

    public String getDescription(){

        return description+"\n Optional directions :"+exit.keySet().toString();
    }
}
