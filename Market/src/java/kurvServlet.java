/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author auron
 */
@WebServlet(urlPatterns =
{
    "/kurvServlet"
})
public class kurvServlet extends HttpServlet
{

    DAO d = new DAO();
//    ArrayList<Item> kurv = new ArrayList<>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {

        List<Item> kurv = (List<Item>) request.getSession().getAttribute("kurv");
        //request.getSession().removeAttribute("kurv");
        
        int slet_vare = Integer.parseInt(request.getParameter("slet_vare"));
        double totalPris = 0.0;
        
         if (slet_vare != 0)
        {
            for (int i = 0; i < kurv.size(); i++)
            {
                if(slet_vare == kurv.get(i).getItem_id())
                {
                    kurv.remove(i);
                }
            }
            response.sendRedirect("..\\Market\\kurvServlet?slet_vare=0");
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
            out.println("<div style=\"margin-left: 25%; margin-top: 25px;\">Menu: <a href=\"..\\Market\\vareServlet?id=1&vare_id=0&slet_vare=0\">Menneskehandel</a> - &nbsp<a href=\"..\\Market\\vareServlet?id=2&vare_id=0&slet_vare=0\">Narkotikum</a> - &nbsp<a href=\"..\\Market\\vareServlet?id=3&vare_id=0&slet_vare=0\">Våben</a> - &nbsp<a href=\"..\\Market\\vareServlet?id=4&vare_id=0&slet_vare=0\">Hælervarer</a></div>");
            out.println("<h1>Kassen</h1>");

            out.println("<table class=\"varetable\">");
            out.println("<tr>");
            out.println("<th>Vare ID</th>");
            out.println("<th>Vare Navn</th>");
            out.println("<th>Vare Pris</th>");
            out.println("</tr>");

            if (kurv.isEmpty())
            {
                out.println("<tr><td>Der er ikke noget du har lagt i kurven...</td></tr>");
            } 
            else
            {
                for (int i = 0; i < kurv.size(); i++)
                {
                    out.println("<tr>");
                    out.println("<td>" + kurv.get(i).getItem_id() + "</td><td>" + kurv.get(i).getItem_name() + "</td><td>" + kurv.get(i).getItem_price() + "</td><td><a href='..\\Market\\kurvServlet?slet_vare="+ kurv.get(i).getItem_id() +"'>X</a></td>");
                    out.println("</tr>");
                    totalPris += kurv.get(i).getItem_price();
                }
            }
            out.println("<tr>");
            out.println("<td><br />TotalPris: " + totalPris + "<br /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><br /><a href=\"..\\Market\\joke.html\" style=\"margin-left: 20px;\">Betal</a><br /><br /></td>");
            out.println("</tr>");
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
