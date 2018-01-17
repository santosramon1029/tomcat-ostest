package servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PathTest")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		String sPath = context.getRealPath("WEB-INF");
		try(InputStream in = new FileInputStream( new File(sPath + "/dbconfig.properties") ) ){
			Properties props = new Properties();
			props.load(in);
			System.out.println(props.get("br.com.stm.db.databaseClass"));
			PrintWriter writer = resp.getWriter();
			writer.write(props.get("br.com.stm.db.databaseClass").toString());
		}
	}
}
