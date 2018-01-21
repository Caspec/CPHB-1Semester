
package hotel;

/**
 *
 * @author pelo
 */
public class Room {
    
    private int number;
    private double price;
    private boolean isAvailable;

    public MiniBar getMini() {
        return mini;
    }
    private MiniBar mini;
    
    public Room(){
    }

    public Room(int number, double price, MiniBar mini) {
        this.number = number;
        this.price = price;
        this.isAvailable = true;
        //Creating the minibar:
//        mini = new MiniBar(2, 3, 55, 35); 
        this.mini = mini;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    
    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
