/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author dinesh
 */
public class c_d extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      Connection con;
      
      try{
       Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
          PreparedStatement stmt=con.prepareStatement("select * from customer");
          ResultSet rs=stmt.executeQuery();
         out.println("<center><h1>View All Customer Details</h1></center>");
         out.println("<hr>");
          out.println("<style> table,td{ border: 1px solid black;}</style>");
          out.println("<table>");
          out.println("<tr>");
            out.println("<td>Customer Id</td>"); 
            out.println("<td>Customer Name</td>"); 
            out.println("<td>Edit</td>"); 
            out.println("<td>Delete</td>"); 
            out.println("</tr>");
            int id=0;
          while(rs.next()){
              id=rs.getInt(1);
              out.println("<tr>");
            out.println("<td>"+rs.getInt(1)+"</td>"); 
            out.println("<td>"+rs.getString(2)+"</td>"); 
            out.println("<td><a href='edit.html'>Edit</a></td>");
            out.println("<form><input type='hidden' value="+id+"></form> ");
            out.println("<td><a href='delete.html'>Delete</a></td>"); 
            out.println("</tr>");
          }
        out.println("</table><br><br>");
        out.println("<a href='c.html'>Back</a>"); 
      }
      catch(Exception e){
          out.println("error");
      }
           }

  
}
