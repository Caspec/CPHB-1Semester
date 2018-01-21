/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Pravien
 */
public class Dungeon
{
    private final ArrayList<Room> roomContainer = new ArrayList<>();
    private final ArrayList<Monster> monsterContainer = new ArrayList<>();
    private final ArrayList<Item> itemContainer = new ArrayList<>();
    
    public Dungeon (Player currentPlayer){
        generateRooms();
        generateDungeon();
        addRoomStorie(currentPlayer);
        
        
    }
    
    public void generateRooms()
    {
        Room newRoom;
        Monster newMonster;
        Item newItem;

        for (int i = 0; i < 10; i++)
        {
            switch (i)
            {   case 0:
                    newRoom = new Room("R" + i);
                    newRoom.setRoomID(i);
                    roomContainer.add(newRoom);
                    newRoom.setHasItem(true);
                    newItem = new Sword(i);
                    itemContainer.add(newItem);
                    break;
                case 2:
                case 4:
                    newRoom = new Room("R" + i);
                    newRoom.setRoomID(i);
                    roomContainer.add(newRoom);
                    // koden nedunder her er til monster.
                   newRoom.setHasMonster(true);
                    newMonster = new Monster("Monster" + i, i);
                    monsterContainer.add(newMonster);
                    newRoom.setHasItem(true);
                    newItem = new HpPotion(i);
                    itemContainer.add(newItem);
                    newItem = new HpPotion(i);
                    itemContainer.add(newItem);
                    
                    
                    
                    newItem = new Sword(i);
                    itemContainer.add(newItem);
                    break;
                case 1:
                case 3:
                    newRoom = new Room("R" + i);
                    newRoom.setRoomID(i);
                    roomContainer.add(newRoom);
                    newRoom.setHasItem(true);
                    newItem = new HpPotion(i);
                    itemContainer.add(newItem);
                    newItem = new HpPotion(i);
                    itemContainer.add(newItem);
                    newItem = new HpPotion(i);
                    itemContainer.add(newItem);
                    
                    
                    break;
                default:
                    newRoom = new Room("R" + i);
                    roomContainer.add(newRoom);
                    break;
            }

        }
    }
    public void generateDungeon()
    {
        

        // room0 available directions
        roomContainer.get(0).setEast(roomContainer.get(3));
        roomContainer.get(0).setWest(roomContainer.get(1));
        roomContainer.get(0).setNorth(roomContainer.get(2));

        // room1 available directions
        roomContainer.get(1).setEast(roomContainer.get(0));
        roomContainer.get(1).setWest(roomContainer.get(4));

        // room2 available directions
        roomContainer.get(2).setSouth(roomContainer.get(0));

        // room3 available directions
        roomContainer.get(3).setWest(roomContainer.get(0));

        // room4 available directions
        roomContainer.get(4).setEast(roomContainer.get(1));
        roomContainer.get(4).setWest(roomContainer.get(6));
        roomContainer.get(4).setNorth(roomContainer.get(5));
        roomContainer.get(4).setSouth(roomContainer.get(7));

        // room5 available directions
        roomContainer.get(5).setSouth(roomContainer.get(4));

        // room6 available directions
        roomContainer.get(6).setEast(roomContainer.get(4));
        roomContainer.get(6).setWest(roomContainer.get(8));

        // room7 available directions
        roomContainer.get(7).setNorth(roomContainer.get(4));

        // room8 available directions
        roomContainer.get(8).setNorth(roomContainer.get(9));
        roomContainer.get(8).setEast(roomContainer.get(6));

        // room9 available directions
        roomContainer.get(9).setNorth(roomContainer.get(8));
        roomContainer.get(9).setWinningRoom(Boolean.TRUE);

    }
    public void addRoomStorie(Player newPlayer)
    {

        roomContainer.get(0).setStory("You look around… Its dark but you can slightly see around the room. You look on the floor and find: " + roomContainer.get(0).getGold() + " It is strange that gold is down here… but you do not mind… Let’s go for the gold!... " + newPlayer.getName() + " “I’m a greedy bastard he thought for himself but who else is going to use it… no one has been here for years");
        roomContainer.get(1).setStory("You look around… The floor is sticky and wet. Your half-brother told you before you left that web-spiders are particularly dangerous… On the right wall, there is a picture of a woman dressed in black… crying… She looks like your half-brothers sister but you cannot really tell because half of the picture has disappeared of mugging. You try to take the picture down but it smash down on the floor… There is a giant hole in the wall…  You touch the hole and stick your hand inside of it… You feel something… It is coins… " + roomContainer.get(1).getGold());
        roomContainer.get(2).setStory("You look around… It is quiet cold at this room. The legend says that ice dragons once lived in these dungeons and caves. Maybe some are alive somehow but no one have seen one in a 1000 years!... You look down on the floor… there is a light frozen chest marked “Dragon gold”… You open it and find: " + roomContainer.get(2).getGold() + ". " + newPlayer.getName() + " :“Maybe I shouldn’t be down here… but okay”");
        roomContainer.get(3).setStory("You look around… It is slightly smelly at this room. You look down on the floor at the corner… there is a golden chest marked “Smelly gold”… You open it and find:" + roomContainer.get(0).getGold() + "s" + newPlayer.getName() + ": “It is going great he thought to himself”");
        roomContainer.get(4).setStory("You enter the room… Someone has been here recently… Wood from the campfire is still warm… Who other than you are in this dungeon…? There is a neckless hanging on a small dagger on the floor right next to the campfire… There is a sticky note on the neckless with the words “We cannot get out… We cannot get out… they are coming!” " + newPlayer.getName() + ": “*Gasp*… I am not alone anymore… I need to be awake from now on… he thought”. You found " + roomContainer.get(4).getGold() + " gold");
        roomContainer.get(5).setStory("You enter the room… Someone has been here just a few hours ago… Someone has dropped a chicken bone at the door when you open it but the demon or whatever it was has disappeared like a lightning bolt… It is getting close to this demon or whatever it is. " + newPlayer.getName() + ": “Maybe I need a stiff drink but where is the bartender when you need him! He murmured to himself and took a small bottle of liquor from his inner pocket”. You found " + roomContainer.get(5).getGold() + " gold");
        roomContainer.get(6).setStory("You enter the room… " + newPlayer.getName() + "“Dragon and demons smell yurk…” A running chicken is flapping around and chirping… “You need to be careful… demons are nearby! Guarkkk”. You found" + roomContainer.get(6).getGold() + " gold");
        roomContainer.get(7).setStory("You enter the room… " + newPlayer.getName() + " “Maybe I should have killed that chicken but ok whatever…” You found");
        roomContainer.get(8).setStory("You enter the room… Sun shafts is slightly penetration a brick in the wall… Old flames has been spitted out... maybe from a dragon or who knows… " + roomContainer.get(7).getGold() + " gold");
        roomContainer.get(9).setStory("You enter the room… The smell is away and real air are coming to the room… Light is near… You exited the dungeon HuRRAHY!... Maybe next time you do not get out of the dungeon… Who knows… But wait.. You did not get your revenge for your father… We need to get back! Something is very wrong! The dungeon has fuzzy my mind…!! ... " + newPlayer.getGold() + "Finish credits… Creators: Pravien and Casper. See you in part 2.. !!.");

    }

    public ArrayList<Room> getRoomContainer()
    {
        return roomContainer;
    }

    public ArrayList<Monster> getMonsterContainer()
    {
        return monsterContainer;
    }

    public ArrayList<Item> getItemContainer()
    {
        return itemContainer;
    }
    
    
}
