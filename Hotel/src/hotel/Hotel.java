package hotel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pelo
 */
public class Hotel
{

    private ArrayList<Room> roomList; //points to null

    public Hotel()
    {
        roomList = new ArrayList<Room>();
        createRooms(); //Opretter listen af alle room i hotellet       
    }

    public void createRooms()
    {
        //Opretter minibar:
        MiniBar b0 = new MiniBar(2, 2, 55, 35);
        MiniBar b1 = new MiniBar(2, 2, 55, 35);
        MiniBar b2 = new MiniBar(2, 2, 55, 35);
        MiniBar b3 = new MiniBar(2, 2, 55, 35);
        MiniBar b4 = new MiniBar(2, 2, 4, 3);

        //Opretter jeg rum & 
        Room r0 = new Room(0, 1800.0, b0);
        Room r1 = new Room(1, 1800.0, b1);
        Room r2 = new Room(2, 1800.0, b2);
        Room r3 = new Room(3, 1800.0, b3);
        Room r4 = new Room(4, 2200.0, b4);
        //Ændre dette!!! Kun til test!!:
        r3.setIsAvailable(false);
        //tilføjer til arraylist af rooms:
        roomList.add(r0);
        roomList.add(r1);
        roomList.add(r2);
        roomList.add(r3);
        roomList.add(r4);
    }

    public double getRoomPrice(int roomNumber)
    {
        Room customerRoom = roomList.get(roomNumber);
        double price = customerRoom.getPrice();
        return price;
    }

    public void printListOfAvailableRooms()
    {

        for (Room currentRoom : roomList)
        {
            if (currentRoom.isIsAvailable())
            {
                System.out.println("Available: " + currentRoom.getNumber());
            }
        }

    }

    public void drinkCola(int roomNumber)
    {
        Room guestRoom = roomList.get(roomNumber);
        //Gettin current number of colas:
        int currentCola = guestRoom.getMini().getNumberOfColas();
        //Setting new number of colas to 1 less:
        int newColaNumber = currentCola - 1;
        //Setting = overwriting new number of colas:
        guestRoom.getMini().setNumberOfColas(newColaNumber);
    }

    public void register()
    {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String name = "";
        String password = "";
        Boolean logged = false;
        System.out.println("Du skal register dig...");
        System.out.println("Navn:");
        name = scan.nextLine();
        System.out.println("Password:");
        password = scan2.nextLine();

        //Arraylist
    }

    public void login()
    {
        Scanner scanlog = new Scanner(System.in);
        Scanner scanlog2 = new Scanner(System.in);
        String name = "";
        String password = "";
        Boolean logged = false;

        System.out.println("Du skal indtaste Brugernavn og Password for login.");

        if (scanlog.nextLine().equals(name) && scanlog2.nextLine().equals(password))
        {
            System.out.println("Velkommen i hotellets booking system.");
            logged = true;
        } else if (scanlog.nextLine().equals(name) && scanlog2.nextLine().equals(password))
        {
            System.out.println("Brugernavn eller password er forkert.");
        } else
        {
            System.out.println("Du har indtastet forkert.. prøv igen om 5 min.");
        }
    }

}
