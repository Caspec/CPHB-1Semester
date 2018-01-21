/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author auron
 */
public class Item implements IItem
{
    private int item_id;
    private String item_name;
    private String item_info;
    private double item_price;
    private String item_img;
    private int fk_cat;

    public Item(int item_id, String item_name, String item_info, double item_price, String item_img, int fk_cat)
    {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_info = item_info;
        this.item_price = item_price;
        this.item_img = item_img;
        this.fk_cat = fk_cat;
    }

    public int getItem_id()
    {
        return item_id;
    }

    public String getItem_name()
    {
        return item_name;
    }

    public String getItem_info()
    {
        return item_info;
    }

    public double getItem_price()
    {
        return item_price;
    }

    public String getItem_img()
    {
        return item_img;
    }

    public int getFk_cat()
    {
        return fk_cat;
    }

    @Override
    public String getName()
    {
       return item_name;
    }

    @Override
    public double getPrice()
    {
        return item_price;
    }

    @Override
    public int getItemId()
    {
        return item_id;
    }

    @Override
    public String getItemInfo()
    {
         return item_info;
    }

    @Override
    public String getItemImg()
    {
        return item_img;
    }

    @Override
    public int getFkCat()
    {
        return fk_cat;
    }
    
    
}
