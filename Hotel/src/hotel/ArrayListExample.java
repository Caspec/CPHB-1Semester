
package hotel;

/**
 *
 * @author pelo
 */
public class ArrayListExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hotel california = new Hotel();
        california.printListOfAvailableRooms();
        System.out.println("Cost of 4: "+california.getRoomPrice(4) );
    }
    
}
