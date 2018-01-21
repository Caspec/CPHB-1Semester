/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Pravien
 */
public class Room
{

    private int gold,roomID;
    private String name, story;
    private Room west, east, south, north;
    private Boolean winningRoom,hasMonster,hasItem;
    

    public Room(String name)
    {
        this.name = name;
        setWinningRoom(false);
        setHasMonster(false);
        setHasItem(false);
        
        //generates random gold amount for each rooom created.
        setGold(generateGoldAmout());
        
    }

    @Override

    public String toString()
    {
        return "Room{" + "gold=" + gold + ", name=" + name + '}';
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    // generates random gold amount.
    private int generateGoldAmout()
    {
        return (int) Math.floor((Math.random() * 200) + 0);
    }

    public Room getWest()
    {
        return west;
    }

    public void setWest(Room West)
    {
        this.west = West;
    }

    public Room getEast()
    {
        return east;
    }

    public void setEast(Room East)
    {
        this.east = East;
    }

    public Room getSouth()
    {
        return south;
    }

    public void setSouth(Room South)
    {
        this.south = South;
    }

    public Room getNorth()
    {
        return north;
    }

    public void setNorth(Room North)
    {
        this.north = North;
    }

    public Boolean getWinningRoom()
    {
        return winningRoom;
    }

    public void setWinningRoom(Boolean winningRoom)
    {
        this.winningRoom = winningRoom;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStory()
    {
        return story;
    }

    public void setStory(String story)
    {
        this.story = story;
    }

    public Boolean getHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(Boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int monsterID) {
        this.roomID = monsterID;
    }

    public Boolean getHasItem() {
        return hasItem;
    }

    public void setHasItem(Boolean hasItem) {
        this.hasItem = hasItem;
    }

   
}
