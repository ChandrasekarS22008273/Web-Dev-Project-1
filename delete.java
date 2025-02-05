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
public class delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out=response.getWriter();
       int i=Integer.parseInt(request.getParameter("d"));
        Connection con;
       
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
          PreparedStatement stmt=con.prepareStatement("Delete from customer where cid=?");
          stmt.setInt(1,i);
          int r=stmt.executeUpdate();
         out.println("<center><h1>Delete Customer Details</h1></center>");
          out.println("<hr>");
          out.println("Customer Details Updated Sucessfully<br><br>");
          out.println("<a href='c_d'>Back</a>");
      }
      catch(Exception e){
          out.println("error");
      }
      
    }

   
}
