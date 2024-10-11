package kr.ac.kku.cs.wp.hyuk.aaa;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/jsp/user/*", "/jsp/admin/*", "/logout" }, initParams = {
		@WebInitParam(name = "valve", value = "on") })
public class AuthenticationFilter extends BaseFilter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (valve) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession hs = req.getSession();
			User user = (User) hs.getAttribute("user");

			if (user != null) {
				log(user.getId() + " has logged in");
				chain.doFilter(request, response);
			} else {
				HttpServletResponse res = (HttpServletResponse) response;
				res.getWriter().println("Please log in");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean valve = true;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);

		String sValve = filterConfig.getInitParameter("valve");

		if (sValve != null) {

			if (sValve.equals("on")) {

				valve = false;

			} else if (sValve.equals("off")) {

				valve = true;

			}

		}

		log("init AuthenticationFilter (" + sValve + ")");
	}

}
