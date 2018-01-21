
package hotel;

/**
 *
 * @author pelo
 */
public class MiniBar {
 
    private int numberOfBeers;
    private int numberOfColas;
    private double beerPrice;
    private double colaPrice;

    public MiniBar(int numberOfBeers, int numberOfColas, double beerPrice, double colaPrice) {
        this.numberOfBeers = numberOfBeers;
        this.numberOfColas = numberOfColas;
        this.beerPrice = beerPrice;
        this.colaPrice = colaPrice;
    }

    public int getNumberOfBeers() {
        return numberOfBeers;
    }

    public void setNumberOfBeers(int numberOfBeers) {
        this.numberOfBeers = numberOfBeers;
    }

    public int getNumberOfColas() {
        return numberOfColas;
    }

    public void setNumberOfColas(int numberOfColas) {
        this.numberOfColas = numberOfColas;
    }

    public double getBeerPrice() {
        return beerPrice;
    }

    public void setBeerPrice(double beerPrice) {
        this.beerPrice = beerPrice;
    }

    public double getColaPrice() {
        return colaPrice;
    }

    public void setColaPrice(double colaPrice) {
        this.colaPrice = colaPrice;
    }
    
    
}
