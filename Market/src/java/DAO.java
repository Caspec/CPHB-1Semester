
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO
{

    public DAO()
    {
        try
        {
            db = new DBConnector();
        } catch (Exception ex)
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DBConnector db;

    public ArrayList<Item> getItem(int cat_id)
    {
        ArrayList<Item> al = new ArrayList<>();
        try
        {
            String query = "SELECT * FROM item WHERE fk_cat=" + cat_id + ";";
            //System.out.println(query);
            Statement stmt = db.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next())
            {
                int item_id = res.getInt("item_id");
                String item_name = res.getString("item_name");
                String item_info = res.getString("item_info");
                double item_price = res.getDouble("item_price");
                String item_img = res.getString("item_img");
                int fk_cat = res.getInt("fk_cat");

                Item item = new Item(item_id, item_name, item_info, item_price, item_img, fk_cat);
                al.add(item);

            }
            return al;

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return al;
        }
    }

    public String getCatName(int cat_id)
    {
        String cat_name = "";
        try
        {
            String query = "SELECT cat_name FROM categori WHERE cat_id=" + cat_id + ";";
            System.out.println(query);
            Statement stmt = db.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next())
            {
                cat_name = res.getString("cat_name");

            }
            return cat_name;

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return cat_name;
        }
    }

    public Item getOneItem(int item_id)
    {
        Item item = new Item(0, "", "", 0, "", 0);
        try
        {
            String query = "SELECT * FROM item WHERE item_id=" + item_id + ";";
            //System.out.println(query);
            Statement stmt = db.getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next())
            {
                String item_name = res.getString("item_name");
                String item_info = res.getString("item_info");
                double item_price = res.getDouble("item_price");
                String item_img = res.getString("item_img");
                int fk_cat = res.getInt("fk_cat");

                item = new Item(item_id, item_name, item_info, item_price, item_img, fk_cat);

            }

            return item;

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return item;
        }
    }

    public void insertItem(int item_id, String item_name, String item_info, double item_price, String item_img, int fk_cat)
    {
        
        try
        {
            String query = "INSERT INTO item (item_id, item_name, item_info, item_price, item_img, fk_cat)"
                    + "VALUES('"+item_id+"', '"+item_name+"', '"+item_info+"', '"+item_price+"', '"+item_img+"', '"+fk_cat+"')";
            Statement stmt = db.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void updateItem(int item_id, String item_name, String item_info, double item_price, String item_img, int fk_cat)
    {
        
        try
        {
            String query = "UPDATE item SET item_id="+item_id+", item_name='"+item_name+"', item_info='"+item_info+"', item_price="+item_price+", item_img='"+item_img+"', fk_cat="+fk_cat+" WHERE item_id="+item_id+";";
                 System.out.println(query);
            Statement stmt = db.getConnection().createStatement();
            stmt.executeUpdate(query);
            stmt.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void deleteOneItem(int item_id)
    {

        try
        {
            String query = "DELETE FROM item WHERE item_id=" + item_id + ";";
            Statement stmt = db.getConnection().createStatement();
//            stmt.executeQuery(query);
            stmt.executeUpdate(query);
            stmt.close();


        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
