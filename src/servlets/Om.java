package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Dbatis.*;
import bean.Item1;
import tools.*;

/**
 * Servlet implementation class Om
 */
@WebServlet("/Om")
public class Om extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Om() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("id");
		String b = request.getParameter("value");
		Item1 adding = new Item1();
		adding.setID(Integer.parseInt(a));
		adding.setValue(b);
		DB_operation.insert(adding);
		ArrayList<Item1> result = new ArrayList<Item1>();
		result = DB_operation.selectAll();
		for(int i = 0; i < result.size(); i++) {
			response.getWriter().append("ID = " + result.get(i).getID() + " Value = " + result.get(i).getValue() + "<br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	    
	
}
