<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css">
        <title>Lone's JSP CMS </title>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <a href="admin.jsp"><img src="logo.png" alt="logo" /></a>
            </header>
            <h1>Velkommen til Lone's STØRSTE CMS</h1>
            <div id="content">
           
                <form name="insert_into" action="admin.jsp" method="POST">
                    <table>
                        <tr>
                            <td> <label for="item_id">Item ID:</label></td>
                            <td><input type="number" id="item_id"><br></td>

                        </tr>
                        <tr>
                            <td><label for="item_name">Item Navn:</label></td>
                            <td><input type="text" id="item_name"><br></td>
                        </tr>
                        <tr>
                            <td><label for="item_info">Item Info:</label></td>
                            <td><input type="text" id="item_info"><br></td>
                        </tr>
                        <tr>
                            <td><label for="item_price">Item Pris:</label></td>
                            <td> <input type="number" id="item_price"><br></td>
                        </tr>
                        <tr>
                            <td><label for="item_img">Item Img:</label></td>
                            <td><input type="text" id="item_img"><br></td>
                        </tr>
                        <tr>
                            <td><label for="item_cat">Item Kategori:</label></td>
                            <td><input type="number" id="item_cat"><br><br></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name='Submit' onclick="insertItem()" value="Opret Ny Vare"></td>
                        </tr>
                    </table>
                </form>

                <table id="admin_table">
                    <tr>
                        <th>ID</th>
                        <th>Navn</th>
                        <th>Info</th>
                        <th>Pris</th>
                        <th>Img</th>
                        <th>Kat</th>
                    </tr>

                </table>

            </div>
            <footer>
                <address>Et produkt af CPH Business Lyngby <img src="parrot.png" alt="parrot" /></address>
            </footer>
        </div>
    </body>
</html>
