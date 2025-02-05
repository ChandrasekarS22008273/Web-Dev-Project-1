/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author dinesh
 */
public class customer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       int i=Integer.parseInt(request.getParameter("cid"));
       String s=request.getParameter("n");
       Connection con;
        try{
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
          PreparedStatement stmt=con.prepareStatement("insert into customer values(?,?)");
          stmt.setInt(1,i);
          stmt.setString(2,s);
          int r=stmt.executeUpdate();
         out.println("<h1>Add Customer Details</h1>");
          out.println("<hr>");
          out.println("Customer Details Inserted Sucessfully");
          out.println("<a href='c.html'>Back</a>");
      }
      catch(Exception e){
          out.println(e);
      }
      
    }

   
}
