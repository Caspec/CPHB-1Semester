
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author auron
 */
public class PriceCalc
{
    
    private double height;
    private double length;
    private int price;
    private int glassPrice = 300;

    /**
     *
     * @param height
     * @param length
     * @param price
     */
    public PriceCalc(double height, double length, int price)
    {
        this.height = height;
        this.length = length;
        this.price = price;
    }
    
    //CALCULATE SQUAREMETERS

    /**
     *
     * @return
     */
    public double squareMeters(){
        // højde gange bredde / 100
        double res = (height/ 100 * length/ 100);
        return res;
    }
    //CALCULATE FRAMEMETERS

    /**
     *
     * @return
     */
    public double frameMeters(){
        // 2 bredder, 2 højder / 100
        double res = (2*height/ 100)+(2*length/ 100);
        return res;
    }
    //GLASS PRICE

    /**
     *
     * @return
     */
    public double glassPrice(){
        //CALLS, squareMeters() * glassPrice
       double res = squareMeters() * glassPrice;
       return res;
    }
    //FRAME PRICE

    /**
     *
     * @return
     */
    public double framePrice(){
        //CALLS, frameMeters() * typePrice
        double res = frameMeters() * price;
        return res;
    }
    //TOTAL PRICE

    /**
     *
     * @return
     */
    public double totalPrice(){
        //CALLS, glassprice ADDITIONS framePrice
        double res = glassPrice() + framePrice();
        return res;
    }
    

}
