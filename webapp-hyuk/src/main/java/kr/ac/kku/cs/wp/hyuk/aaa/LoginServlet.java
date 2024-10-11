package kr.ac.kku.cs.wp.hyuk.aaa;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = req.getSession();
		User sUser = (User) hs.getAttribute("user");
		
		if (sUser == null) {
			String id = req.getParameter("id");
			String role = req.getParameter("role");
			
			User user = new User();
			user.setId(id);
			user.setRole(role);
			hs.setAttribute("user", user);
			
			log(user.getId());
			log(user.getRole());
			
			res.getWriter().println("Login successful.");
			
		} else {
			res.getWriter().println(sUser.getId() + "! please log out first");
		}
		
		
	}

}
