package nani;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
				PrintWriter pw=resp.getWriter();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "root");
				String sql="select * from login where email=? and password=?";
				PreparedStatement pmst=conn.prepareStatement(sql);
				pmst.setString(1,req.getParameter("email"));
				pmst.setString(2, req.getParameter("password"));
				ResultSet rs=pmst.executeQuery();
				if(rs.next()) {
					resp.sendRedirect("welcome.jsp");
					
				}
				else {
					pw.print("error");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
