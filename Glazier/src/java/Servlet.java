
import java.io.IOException;
import java.io.PrintWriter;
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
    "/Servlet"
})
public class Servlet extends HttpServlet
{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        double height = Integer.parseInt(request.getParameter("hig"));
        double length = Integer.parseInt(request.getParameter("len"));
        int frametype = Integer.parseInt(request.getParameter("frametype"));
        
        
        // Ny instance af DAO for at få prisen ind til vores PriceCalc
        DAO dao = new DAO();
        int price = dao.getFrameType(frametype);
        
        // CONSTRUCTOR CALL
        PriceCalc c = new PriceCalc(height, length, price);

        try (PrintWriter out = response.getWriter())
        {
            if (height > 0 && length > 0)
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ServletOrder</title>");
                out.println("<style>body {\n" + "background-color:bisque;\n" + "} .csharp {\n" + " color: maroon;\n" + " font-family:monospace;\n" + " font-weight:bold;\n" + " font-size:x-large;" + "} </style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<img src='thincheck1.png' alt='test' />" + "<br />");
                out.println("<span class='csharp'>Din valgte højde i cm: " + height + "</span><br />");
                out.println("<span class='csharp'>Din valgte længde i cm: " + length + "</span><br />");
                out.println("<span class='csharp'>Totale Pris: " + c.totalPrice() + " kr." + "</span><br />");
                out.println("<span class='csharp'>---------------------------------------" + "</span><br /><br />");
                out.println("<a href='order.html'>Lav en ny order</a>");
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                response.sendRedirect("error.html");
            }

        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
