package kr.ac.kku.cs.wp.hyuk.aaa;

import java.io.IOException;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/jsp/admin/*")
public class AuthorityFilter extends BaseFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession hs = req.getSession(false);
		User user = (User) hs.getAttribute("user");
		String role = user.getRole();
		if (!role.equals("admin")) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.getWriter().print("Adminaccessonly");
		} else {
			chain.doFilter(request, response);
		}

	}

}
