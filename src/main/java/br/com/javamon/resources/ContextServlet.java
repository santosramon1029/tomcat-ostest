package br.com.javamon.resources;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContextServlet extends HttpServlet {
	
	public static ServletContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	
	
}
