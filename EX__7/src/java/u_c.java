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
public class u_c extends HttpServlet {
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
          PreparedStatement stmt=con.prepareStatement("update customer set cname=? where cid=?");
          stmt.setString(1,s);
          stmt.setInt(2,i);
          int r=stmt.executeUpdate();
         out.println("<center><h1>Update Customer Details</h1></center>");
          out.println("<hr>");
          out.println("Customer Details Updated Sucessfully<br><br>");
          out.println("<a href='edit.html'>Back</a>");
      }
      catch(Exception e){
          out.println("error");
      }
      
    }

   
}
