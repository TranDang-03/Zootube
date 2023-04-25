package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import domainModel.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.UserRepo;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/user/login", "/user/user-register", "/user/user-update", "/user/forgotpassword" })

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRepo user;

	public UserController() {
		user = new UserRepo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else if (uri.contains("forgotpassword")) {
			request.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(request, response);
		} else if (uri.contains("user-update")) {

		} else if (uri.contains("user-register")) {
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("user-register")) {
			this.register(request, response);
		} else if (uri.contains("forgotpassword")) {

		} else if (uri.contains("user-update")) {

		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> list = user.findAll();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		
		HttpSession message = request.getSession();
		message.removeAttribute("message");

		if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
			message.setAttribute("message", "Thông tin đăng ký không được để trống!");
//			response.sendRedirect("/Zootube/user/user-register");
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
		} else {
			if (!username.matches("^[a-zA-Z0-9]+$")) {
				message.setAttribute("message",
						"Sai định dạng username (username bắt buộc phải có số và chữ và không chứa kí tự đặc biệt!!!)");
//				response.sendRedirect("/Zootube/user/user-register");
				request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			} else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
				message.setAttribute("message", "Sai định dạng email");
//				response.sendRedirect("/Zootube/user/user-register");
				request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			} else if (!password.matches("^[a-zA-Z0-9]+$") || !confirmPassword.matches("^[a-zA-Z0-9]+$")) {
				message.setAttribute("message", "Sai định dạng mật khẩu");
//				response.sendRedirect("/Zootube/user/user-register");
				request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			} else if (user.checkTrungEmail(email) != null) {
				message.setAttribute("message", "Email đã đăng ký");
//				response.sendRedirect("/Zootube/user/user-register");
				request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
			} else {
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-256");
					md.update(password.getBytes());
					byte[] hashedPasswordBytes = md.digest();
					String hashedPassword = bytesToHex(hashedPasswordBytes);
					User us = new User(username, hashedPassword, email, false, true);
					user.insertUser(us);
					message.setAttribute("message", "Đăng ký thành công!!");
					response.sendRedirect("/Zootube/user/login");
				} catch (Exception e) {
					e.printStackTrace();
					message.setAttribute("message", "Đăng ký không thành công, hãy thử lại!!");
					request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
				}
			}
		}
	}

	public String bytesToHex(byte[] bytes) {
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
