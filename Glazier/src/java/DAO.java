
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author auron
 */
public class DAO
{
//    public static void main(String[] args)
//    {
//        System.out.println(new DAO().getType("glass"));
//    }

    /**
     *
     * @param type
     * @return
     */

    public int getFrameType(int type)
    {
        int price = 0;

        try
        {
            String query = "SELECT price FROM glazier.pris WHERE id=" + type + ";";
            System.out.println(query);
            Statement stmt = new DBConnector().getConnection().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next())
            {
                price = res.getInt("price");

                return price;
            }
            return price;

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
    }

}
