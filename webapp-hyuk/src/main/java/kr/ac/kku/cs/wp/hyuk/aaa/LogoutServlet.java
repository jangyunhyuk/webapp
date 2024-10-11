package kr.ac.kku.cs.wp.hyuk.aaa;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LogoutServlet
 */
// @WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = req.getSession(false);
    	session.setMaxInactiveInterval(900);
    	if(session != null) {
    		session.invalidate();
    	}
    	res.getWriter().println("Logged out");
	}

}
