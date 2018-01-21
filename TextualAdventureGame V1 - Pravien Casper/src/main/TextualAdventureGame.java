/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.sound.midi.Soundbank;
import m2.textio.ISimpleTextIO;
import m2.textio.ITextIO;
import m2.textio.SysTextIO;
import m2.textio.TextIO;
import m2.textio.TextIOFactory;

/**
 *
 * @author Pravien
 */
public class TextualAdventureGame
{

    private Room currentRoom;
    private Room monsterCurrentRoom;
    private final Scanner scan = new Scanner(System.in);
    private Boolean gameQuit = true;
    private Boolean availableDirection = true;
    private FileReader newFileReader = new FileReader();
    ITextIO io = TextIOFactory.getSysTextIO();
    ArrayList<Item> tempItemArray = new ArrayList<>();

    // this method shows which rooms are connectec to the current room.
    public void availableDirections(Room currentRoom)
    {

        io.put("These are the available directions\n");

        if (currentRoom.getEast() != null)
        {

            io.put("    You can go east(E) to Room " + currentRoom.getEast().getName());
        }
        if (currentRoom.getWest() != null)
        {
            io.put("    You can go west(W) to Room " + currentRoom.getWest().getName());
        }
        if (currentRoom.getNorth() != null)
        {
            io.put("    You can go north(N) to Room " + currentRoom.getNorth().getName());
        }
        if (currentRoom.getSouth() != null)
        {
            io.put("    You can go south(S) to Room " + currentRoom.getSouth().getName());
        }

    }

    //This method is used to create a player.
    public Player makePlayer()
    {

        io.put("Hey there please enter your name: ");
        String text = io.get();
        Player newplayer = new Player(text);
        io.put("The Sword Coast has entered a difficult time: iron production has virtually halted, with metal products quickly rotting, tools and weapons breaking easily\nAs a result (except magical weapons), while bandits scour the countryside seeking iron over any other treasure.\n" + text + " is 30 years old and already has white hair and black eyes…\nIn his childhood " + text + " was a foster child and a mage named Gorion took him as his son.\nGorion sensing trouble, decides to leave Applekeep with " + text + " (known as Gorion's Ward).\nExplaining nothing of importance other than to move on; during this time, Gorion's Ward finds himself attacked by a couple of men seeking his death.\nThe night after leaving Applekeep, a group of bandits led by a mysterious armored figure ambushes the pair.\nGorion refuses to hand over his ward and is attacked by the bandits.\nGorion defeats most of them but dies in doing so at the hands of the armored figure, yet he does enough to allow his son to escape.\nIn the morning," + text + " encounters Smix who had followed in secret after reading a note on Gorion's desk about the journey. \n" + text + " find this note but learns little except that Gorion had known that his son was in danger. Now its payback TIME!");
        
        return newplayer;
    }

    // this method defines the starting room and displays information about your game name and gold.
    //this method also start the game when N is pressed
    public String startingRoom(Player newPlayer, Dungeon newDungeon)
    {

        io.put("\nThis is your starting room. ");
        io.put("Your name: " + newPlayer.getName());
        io.put("Your amount of gold: " + newPlayer.getGold());
        io.put("Move North (N) to start the game. ");
        //String input = scan.nextLine();

        if (io.get().equals("N"))
        {
            currentRoom = newDungeon.getRoomContainer().get(0);
            return "N";
        } else
        {
            return "F";
        }

    }

    //This metod update our current room, so it moves the player arround.
    public void goToRoom(String input, Room currentRoom)
    {

        if (input.equals("N") && currentRoom.getNorth() != null)
        {
            this.currentRoom = currentRoom.getNorth();
            availableDirection = false;
        } else if (input.equals("S") && currentRoom.getSouth() != null)
        {
            this.currentRoom = currentRoom.getSouth();
            availableDirection = false;
        } else if (input.equals("E") && currentRoom.getEast() != null)
        {
            this.currentRoom = currentRoom.getEast();
            availableDirection = false;
        } else if (input.equals("W") && currentRoom.getWest() != null)
        {
            this.currentRoom = currentRoom.getWest();
            availableDirection = false;
        } else
        {
            io.put("Your input is incorrect");
        }

    }

    //this method updates playergold and set the currentrooms gold to 0.
    public void updatePlayerGoldAndResetRoomGold(Player newPlayer)
    {
        newPlayer.setGold(currentRoom.getGold());
        this.currentRoom.setGold(0);
    }

    //this metod is used to get the players input on which direction he or she wants to move.
    public String moveDirection()
    {
        availableDirections(currentRoom);
        io.put("\nInsert direction ");
        //String k = scan.next();
        //return k;
        return io.get();
    }

    //this method shows the menu. and exits this menu if player selct 3,4 or 5
    public void showPlayerOptions(Room room, Player newPlayer) throws InterruptedException
    {

        outerloop:
        while (true)
        {
            TimeUnit.SECONDS.sleep(3);
            io.put("\n-------- Menu --------");
            io.put("You have the following options\n");
            io.put("    1. View Player gold");
            io.put("    2. Help");
            io.put("    3. View directions");
            io.put("    4. Quit game");
            io.put("    5. Quit menu\n");

            io.put("Insert your choice\n ");
            //String text = scan.next();
            //switch (text)
            switch (io.get())
            {
                case "1":
                    io.put("\nYour gold amount is " + newPlayer.getGold());
                    break;
                case "2":
                    io.put("No help to get here");
                    break;
                case "3":
                    goToRoom(moveDirection(), currentRoom);
                    break outerloop;
                case "4":
                    gameQuit = false;
                    break outerloop;
                case "5":
                    break outerloop;
                default:
                    io.put("Wrong input, enter number");
                    break;
            }

        }
    }

    // this method checks if the room contain Monster
    public void roomHasMonster(Player newPlayer, Dungeon newDungeon) throws InterruptedException
    {
        if (currentRoom.getHasMonster())
        {
            // this method find the monster which belongs in this currentroom
            Combat newCombat = new Combat();
            Monster currenMonster = findMonsterForCurrentRoom(currentRoom, newDungeon);

            io.put("You bumped into the moster with name " + currenMonster.getName() + " this monster has "
                    + currenMonster.getHealth() + " HP");

            io.put("You fight the monster\n");
            // here we call the battle method and the battle start
            //battle(newPlayer, currenMonster, playerBag);
            newCombat.battle(newPlayer, currenMonster, newPlayer.getPlayerBag());
            // this if makes sure to remove the monster if it dies.
            if (currenMonster.getHealth() == 0)
            {
                currentRoom.setHasMonster(false);
            }
        }

    }

    // this methos is used to serach through the array which contain all the mosnters
    // and match the current room with the moster that belongs in that room.
    public Monster findMonsterForCurrentRoom(Room currentRoom, Dungeon newDungeon)
    {
        Monster tempMonster = new Monster("yolo", 5);
        outloop:
        for (int i = 0; i < newDungeon.getMonsterContainer().size(); i++)
        {
            if (newDungeon.getMonsterContainer().get(i).getRoomID() == currentRoom.getRoomID())
            {
                tempMonster = newDungeon.getMonsterContainer().get(i);
                break outloop;
            }

        }

        return tempMonster;
    }

    // this method is used when the player choose to add an item to the bag.
    // this method will remove the added item from the game.
    public void removeItemsForCurrentRoom(Item kk, Dungeon newDungeon)
    {

        for (int i = 0; i < newDungeon.getItemContainer().size(); i++)
        {
            if (newDungeon.getItemContainer().get(i).getRoomID() == kk.getRoomID())
            {

                if (newDungeon.getItemContainer().get(i) instanceof HpPotion && kk instanceof HpPotion)
                {
                    HpPotion k1 = (HpPotion) kk;
                    HpPotion k2 = (HpPotion) newDungeon.getItemContainer().get(i);

                    if (k1.getHealStat() == k2.getHealStat())
                    {
                        newDungeon.getItemContainer().remove(i);
                    }

                } else if (newDungeon.getItemContainer().get(i) instanceof Sword && kk instanceof Sword)
                {

                    Sword k1 = (Sword) kk;
                    Sword k2 = (Sword) newDungeon.getItemContainer().get(i);

                    if (k1.getBonusAttackDamage() == k2.getBonusAttackDamage())
                    {
                        newDungeon.getItemContainer().remove(i);
                    }

                }

            }

        }

    }

    // this methos is used to serach through the array which contain alle items in the dungon
    // and match the current room with the items that belongs in that room.
    public ArrayList<Item> findItemForCurrentRoom(Dungeon newDungeon)
    {
        //This is just a temp variable
        ArrayList<Item> itemTemp = new ArrayList<>();

        for (int i = 0; i < newDungeon.getItemContainer().size(); i++)
        {
            // Here we check if the room ID and item ID match

            if (newDungeon.getItemContainer().get(i).getRoomID() == currentRoom.getRoomID())
            {
                itemTemp.add(newDungeon.getItemContainer().get(i));

            }

        }

        return itemTemp;
    }

    // this method displayes all the items the room contains
    public void displayRoomItems(ArrayList<Item> kk)
    {

        for (int i = 0; i < kk.size(); i++)
        {

            io.put("\nThis Room contain " + (i + 1) + ". " + kk.get(i).getName());
            io.put("    - " + kk.get(i).getDescription());
        }
    }

    public Boolean roomHasItem(Dungeon newDungeon, Player newPlayer) throws InterruptedException
    {

        if (currentRoom.getHasItem())
        {
            if (newPlayer.getPlayerBag().getBagSize() == 6)
            {
                removeItemFromFullBag(newPlayer.getPlayerBag());
            }
            chooseItemToAdd(findItemForCurrentRoom(newDungeon), newDungeon, newPlayer);

            // this displays the item the room has
            //this part add the found item to your bag
            //playerBag.addItemToPlayerInventory(findItemForCurrentRoom());
            if (findItemForCurrentRoom(newDungeon).size() == 0)
            {
                currentRoom.setHasItem(false);
            }
            return true;

        } else
        {
            return false;
        }
    }

    // this Method will gives you the option to remove items from your
    // full bag.
    public void removeItemFromFullBag(Bag playerBag)
    {
        Boolean continueWhile = true;
        while (continueWhile && playerBag.getBagSize() != 0)
        {
            io.put("\nYour bag is full remove a item");
            io.put("Your bag contain");
            playerBag.ListPlayerInventoryItems();
            io.put("Choose one of following items to delete.");
            io.put("if you don't want to delete any items then press 0");
            int choice = io.getInteger(0, playerBag.getBagSize());

            switch (choice)
            {
                case 0:
                    continueWhile = false;
                    break;
                case 1:
                    playerBag.removeInventory(1);
                    break;
                case 2:
                    playerBag.removeInventory(2);
                    break;
                case 3:
                    playerBag.removeInventory(3);
                    break;
                case 4:
                    playerBag.removeInventory(4);
                    break;
                case 5:
                    playerBag.removeInventory(5);
                    break;
                case 6:
                    playerBag.removeInventory(6);
                    break;
                default:
                    break;
            }

        }

    }

    public void addPotionOrSword(int choice, Player newPlayer, Dungeon newDungeon)
    {

        // vi checker hvor vidt om det choice vi vælger er en Hp potion
        if (tempItemArray.get(choice - 1) instanceof HpPotion)
        {
            newPlayer.getPlayerBag().addItemToPlayerInventory(tempItemArray.get(choice - 1), newPlayer);
            removeItemsForCurrentRoom(tempItemArray.get(choice - 1), newDungeon);
            tempItemArray.remove(choice - 1);
        } //vi checker hvor vidt om det choice vi vælger er et sværd
        else if (tempItemArray.get(choice - 1) instanceof Sword)
        {

            Sword tempSword = (Sword) tempItemArray.get(choice - 1);
            //checker om spilleren har et sværd (t)
            if (newPlayer.getHasSword())
            {
                // Udskifter det nye sværd hvis det er bedre end det gamle
                if (newPlayer.getSword().getBonusAttackDamage() < tempSword.getBonusAttackDamage())
                {
                    // Det updater sværdet
                    Sword oldSword = newPlayer.removeSword(tempSword);
                    

                    if (newPlayer.getPlayerBag().getBagSize() != 6)
                    {
                        newPlayer.getPlayerBag().addItemToPlayerInventory(oldSword, newPlayer);
                        removeItemsForCurrentRoom(tempItemArray.get(choice - 1), newDungeon);
                        tempItemArray.remove(choice - 1);
                    } else
                    {

                        // Det bliver brugt til at fjerne sværdet fra rummet
                        removeItemsForCurrentRoom(tempItemArray.get(choice - 1), newDungeon);
                        tempItemArray.remove(choice - 1);
                    }
                } else
                {
                    // Hvis det nye sværd er dårligere end det gamle
                    // Så gemmes det i tasken
                    newPlayer.getPlayerBag().addItemToPlayerInventory(tempItemArray.get(choice - 1), newPlayer);
                    removeItemsForCurrentRoom(tempItemArray.get(choice - 1), newDungeon);
                    tempItemArray.remove(choice - 1);
                }
            } else
            {
                // Det er i tilfælde af at han ikke har noget sværd på sig
                newPlayer.addSword(tempSword);
                removeItemsForCurrentRoom(tempItemArray.get(choice - 1), newDungeon);
                tempItemArray.remove(choice - 1);
                newPlayer.setHasSword(true);
            }
        }
    }

    // this method adds the selected item to the currentplayers bag
    public Boolean addSelectedItem(int choice, Dungeon newDungeon, Player newPlayer)
    {
        if (choice == 1)
        {
            io.put("\n You chooce item 1\n");
            addPotionOrSword(choice, newPlayer, newDungeon);

        } else if (choice == 2)
        {
            io.put("\n You chooce item 2\n");
            addPotionOrSword(choice, newPlayer, newDungeon);

        } else if (choice == 3)
        {
            io.put("\n You chooce item 3\n");
            addPotionOrSword(choice, newPlayer, newDungeon);

        } else if (choice == 0)
        {
            io.put("\n You chooce to exit the menu\n");
            return false;
        } else
        {
            io.put("\nYou did not enter a valid input");
        }
        return true;
    }

    // This method is used to add items to the bag
    public void chooseItemToAdd(ArrayList<Item> kk, Dungeon newDungeon, Player newPlayer) throws InterruptedException
    {

        tempItemArray = kk;

        Boolean continueWhile = true;

        while (continueWhile && newPlayer.getPlayerBag().getBagSize() != 6 && tempItemArray.size() != 0)
        {

            System.out.println("\n This room contain one or more items\n");
            int TempChoice = io.select("Choose the number of the item you want to add ", tempItemArray, "If you dont want to add anymore items press 0");
            continueWhile = addSelectedItem(TempChoice, newDungeon, newPlayer);

            TimeUnit.SECONDS.sleep(2);

            
//            for (int i = 0; i < newPlayer.getPlayerBag().getPlayerInventory().size(); i++)
//            {
//                io.put(newPlayer.getPlayerBag().getPlayerInventory().get(i).toString());
//
//            }

            

            TimeUnit.SECONDS.sleep(1);
            if (newPlayer.getPlayerBag().getBagSize() == 6)
            {
                removeItemFromFullBag(newPlayer.getPlayerBag());
            }
        }

    }

    // this methos is the overall game method , this contains all the methods that make the game run
    public void runGame() throws InterruptedException
    {
        //here we generate the dungon,create a new player and add storie 

        newFileReader.openFile();
        newFileReader.disPlayHighScore();
        newFileReader.closeFile();
        //we generate a new player
        Player newPlayer = makePlayer();
        

        Dungeon newDungeon = new Dungeon(newPlayer);
        //We generate his bag
        //Bag playerBag = new Bag();
        //here we add stories to each room

        // This while loop keeps showing the room from starting room until
        //The player choose to go North
        while (!"N".equals(startingRoom(newPlayer, newDungeon)))
        {
            startingRoom(newPlayer, newDungeon);
        }
        outermaingame:
        // this loop runs while we havent reached the end room or the player hasnt selected quit game.
        while (currentRoom.getWinningRoom() == false || !gameQuit)
        {
            io.put("\n----- CurrentRoom " + currentRoom.getName() + " -----\n");
            io.put("You enter room " + currentRoom.getName());
            io.put(currentRoom.getStory());
            // here we update the room gold and player gold
            updatePlayerGoldAndResetRoomGold(newPlayer);

            // checks if the room contain one or more items and will then add it to your bag
            roomHasItem(newDungeon, newPlayer);

            roomHasMonster(newPlayer, newDungeon);

            if (newPlayer.getHealth() == 0)
            {

                break outermaingame;
            }

            //showPlayerOptions(currentRoom, newPlayer);
            //availableDirections(currentRoom);
            io.put("\nWould you like to see the menu?\n");
            io.put("Type (Y) for yes else press anything for No");
            String k = scan.next();
            if (k.equals("Y"))
            {
                io.put("You choose yes");
                showPlayerOptions(currentRoom, newPlayer);

                if (gameQuit == false)
                {
                    break outermaingame;
                }

            }

            while (availableDirection)
            {

                goToRoom(moveDirection(), currentRoom);

            }
            availableDirection = true;

        }

        if (gameQuit == false)
        {
            io.put("You quited the game");
        } else if (newPlayer.getHealth() == 0)
        {
            io.put("\n You died , you lost the game, the monsters won..");
        } else
        {
            io.put(newDungeon.getRoomContainer().get(9).getStory());
            // Here we update the highscores.
            newFileReader.openFile();
            newFileReader.updateTextInFile(newPlayer);
            newFileReader.sortTextFile();
            newFileReader.disPlayHighScore();
            newFileReader.closeFile();
        }
    }

}
