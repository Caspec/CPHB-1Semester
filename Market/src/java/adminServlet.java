
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.Alert;
import javafx.scene.web.WebEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns =
{
    "/adminServlet"
})
public class adminServlet extends HttpServlet
{

    DAO d = new DAO();
    private int item_id = 0;
    private String item_name = "";
    private String item_info = "";
    private double item_price = 0.0;
    private String item_img = "";
    private int fk_cat = 0;
    private String insert = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int action = Integer.parseInt(request.getParameter("action"));
        int vare_id = Integer.parseInt(request.getParameter("vare_id"));

       
        
        if (request.getParameter("item_id") != null && request.getParameter("item_name") != null && request.getParameter("item_info") != null && request.getParameter("item_price") != null && request.getParameter("item_img") != null && request.getParameter("fk_cat") != null && action == 2)
        {
            this.item_id = Integer.parseInt(request.getParameter("item_id"));
            this.item_name = request.getParameter("item_name");
            this.item_info = request.getParameter("item_info");
            this.item_price = Double.parseDouble(request.getParameter("item_price"));
            this.item_img = request.getParameter("item_img");
            this.fk_cat = Integer.parseInt(request.getParameter("fk_cat"));
            d.updateItem(item_id, item_name, item_info, item_price, item_img, fk_cat);
            insert = "Du har nu Redigeret din vare... Tillykke med det Lone !";
            response.sendRedirect("..\\Market\\adminServlet?action=0&vare_id=0");

        }
        
         if (request.getParameter("item_id") != null && request.getParameter("item_name") != null && request.getParameter("item_info") != null && request.getParameter("item_price") != null && request.getParameter("item_img") != null && request.getParameter("fk_cat") != null && action == 0)
        {
            this.item_id = Integer.parseInt(request.getParameter("item_id"));
            this.item_name = request.getParameter("item_name");
            this.item_info = request.getParameter("item_info");
            this.item_price = Double.parseDouble(request.getParameter("item_price"));
            this.item_img = request.getParameter("item_img");
            this.fk_cat = Integer.parseInt(request.getParameter("fk_cat"));
            d.insertItem(item_id, item_name, item_info, item_price, item_img, fk_cat);
            insert = "Du har nu oprettet en ny vare... Tillykke med det Lone !";

        }
        
        if(action == 3)
        {
            d.deleteOneItem(vare_id);
            response.sendRedirect("..\\Market\\adminServlet?action=0&vare_id=0");
        }
        

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lone's Kriminelle Loppemarked</title>");
            out.println("<link rel=\"stylesheet\" href=\"../Market/css.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"wrapper\">");
            out.println("<header>");
            out.println("<a href=\"index.html\"><img src=\"logo.png\" alt=\"logo\" /></a>");
            out.println("</header>");
            out.println("<div id=\"content\">");
            out.println("<h1>Lone's Store CMS</h1>");
            if(action == 0)
            {
            out.println("<form name='insert_into' action='..\\Market\\adminServlet?action=0&vare_id=0' method='post'>");
            out.println("<table class=\"varetable\">");
            out.println(" <tr>");
            out.println(" <td> <label for='item_id'>Item ID:</label></td>");
            out.println(" <td><input type='number' id='item_id' name='item_id'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_name'>Item Navn:</label></td>");
            out.println(" <td><input type='text' id='item_name' name='item_name'><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println("   <td><label for='item_info'>Item Info:</label></td>");
            out.println("   <td><input type='text' id='item_info' name='item_info'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_price'>Item Pris:</label></td>");
            out.println(" <td> <input type='number' id='item_price' name='item_price'><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println(" <td><label for='item_img'>Item Img:</label></td>");
            out.println(" <td><input type='text' id='item_img' name='item_img'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_cat'>Item Kategori:</label></td>");
            out.println("  <td><input type='number' id='item_cat' name='fk_cat'><br><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println("    <td><input type='submit' id='submit_insert' name='submit_insert' value='Opret Ny Vare'></td>");
            out.println(" </tr>");
            out.println("<tr><td colspan=\"4\"><h4>" + insert + "</h4></td></tr>");
            out.println(" </table>");
            out.println(" </form>");
            }
             if(action == 2)
            {
                
            out.println("<form name='insert_into' action='..\\Market\\adminServlet?action=2&vare_id=0' method='post'>");
            out.println("<table class=\"varetable\">");
            out.println(" <tr>");
            out.println(" <td> <label for='item_id'>Item ID:</label></td>");
            out.println(" <td><input type='number' id='item_id' name='item_id' value='"+ d.getOneItem(vare_id).getItem_id() +"'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_name'>Item Navn:</label></td>");
            out.println(" <td><input type='text' id='item_name' name='item_name' value='"+ d.getOneItem(vare_id).getItem_name() +"'><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println("   <td><label for='item_info'>Item Info:</label></td>");
            out.println("   <td><input type='text' id='item_info' name='item_info' value='"+ d.getOneItem(vare_id).getItemInfo() +"'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_price'>Item Pris:</label></td>");
            out.println(" <td> <input type='number' id='item_price' name='item_price' value='"+ d.getOneItem(vare_id).getPrice() +"'><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println(" <td><label for='item_img'>Item Img:</label></td>");
            out.println(" <td><input type='text' id='item_img' name='item_img' value='"+ d.getOneItem(vare_id).getItem_img() +"'><br></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='item_cat'>Item Kategori:</label></td>");
            out.println("  <td><input type='number' id='item_cat' name='fk_cat' value='"+ d.getOneItem(vare_id).getFk_cat() +"'><br><br></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println("    <td><input type='submit' id='submit_update' name='submit_update' value='Rediger Vare'></td>");
            out.println(" </tr>");
            out.println("<tr><td colspan=\"4\"><h4>" + insert + "</h4></td></tr>");
            out.println(" </table>");
            out.println(" </form>");
            
            }
            out.println("<table class=\"varetable\">");
            out.println("<tr colspan=\"4\" style=\"border: 1 px solid red; color: red;\"><th>Menneskehandel</th></tr>");
            for (int i = 0; i < d.getItem(1).size(); i++)
            {
                out.println("<tr>");
                out.println("<td><img src=\"img/" + d.getItem(1).get(i).getItem_img() + "\"></td><td>" + d.getItem(1).get(i).getItem_name() + "</td><td>" + d.getItem(1).get(i).getItem_info() + "</td><td>" + d.getItem(1).get(i).getItem_price() + "</td><td><a href='..\\Market\\adminServlet?action=3&vare_id=" + d.getItem(1).get(i).getItem_id() + "'>Slet vare<a></td><td><a href='..\\Market\\adminServlet?action=2&vare_id=" + d.getItem(1).get(i).getItem_id() + "' style=\"color: yellow;\">Rediger vare<a></td>");
                out.println("</tr>");

            }
            out.println("<tr colspan=\"4\" style=\"border: 1 px solid red; color: red;\"><th>Narkotikum</th></tr>");
            for (int i = 0; i < d.getItem(2).size(); i++)
            {
                out.println("<tr>");
                out.println("<td><img src=\"img/" + d.getItem(2).get(i).getItem_img() + "\"></td><td>" + d.getItem(2).get(i).getItem_name() + "</td><td>" + d.getItem(2).get(i).getItem_info() + "</td><td>" + d.getItem(2).get(i).getItem_price() + "</td><td><a href='..\\Market\\adminServlet?action=3&vare_id=" + d.getItem(2).get(i).getItem_id() + "'>Slet vare<a></td><td><a href='..\\Market\\adminServlet?action=2&vare_id=" + d.getItem(2).get(i).getItem_id() + "' style=\"color: yellow;\">Rediger vare<a></td>");
                out.println("</tr>");

            }
            out.println("<tr colspan=\"4\" style=\"border: 1 px solid red; color: red;\"><th>Våben</th></tr>");
            for (int i = 0; i < d.getItem(3).size(); i++)
            {
                out.println("<tr>");
                out.println("<td><img src=\"img/" + d.getItem(3).get(i).getItem_img() + "\"></td><td>" + d.getItem(3).get(i).getItem_name() + "</td><td>" + d.getItem(3).get(i).getItem_info() + "</td><td>" + d.getItem(3).get(i).getItem_price() + "</td><td><a href='..\\Market\\adminServlet?action=3&vare_id=" + d.getItem(3).get(i).getItem_id() + "'>Slet vare<a></td><td><a href='..\\Market\\adminServlet?action=2&vare_id=" + d.getItem(3).get(i).getItem_id() + "' style=\"color: yellow;\">Rediger vare<a></td>");
                out.println("</tr>");

            }
            out.println("<tr colspan=\"4\" style=\"border: 1 px solid red; color: red;\"><th>Hælervarer</th></tr>");
            for (int i = 0; i < d.getItem(4).size(); i++)
            {
                out.println("<tr>");
                out.println("<td><img src=\"img/" + d.getItem(4).get(i).getItem_img() + "\"></td><td>" + d.getItem(4).get(i).getItem_name() + "</td><td>" + d.getItem(4).get(i).getItem_info() + "</td><td>" + d.getItem(4).get(i).getItem_price() + "</td><td><a href='..\\Market\\adminServlet?action=3&vare_id=" + d.getItem(4).get(i).getItem_id() + "'>Slet vare<a></td><td><a href='..\\Market\\adminServlet?action=2&vare_id=" + d.getItem(4).get(i).getItem_id() + "' style=\"color: yellow;\">Rediger vare<a></td>");
                out.println("</tr>");

            }
            out.println("</table>");

            out.println("</div>");
            out.println("<footer>");
            out.println("<address>Et produkt af CPH Business Lyngby <img src=\"parrot.png\" alt=\"parrot\" /></address>");
            out.println("</footer>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
