package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
@WebServlet({ "/admin/register", "/admin/delete", "/admin/detail", "/admin/update", "/admin/home" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		if(uri.contains("home")) {
			
		}else if(uri.contains("register")) {
			
		}else if(uri.contains("detail")) {
			
		}else if(uri.contains("update")) {
			
		}else if(uri.contains("delete")) {
			
		}else {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}
}
