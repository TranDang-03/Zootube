package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import domainModel.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.UserRepo;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/user/login", "/user/user-register", "/user/user-update", "/user/forgotpassword", "/user/home",
		"/admin/adminHome" })

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
			Cookie[] cook = request.getCookies();
			if(cook != null) {
				for (Cookie cookie : cook) {
					if(cookie.getName().equalsIgnoreCase("Email")) {
						request.setAttribute("email", cookie.getValue());
					}					
					if(cookie.getName().equalsIgnoreCase("Pass")) {
						request.setAttribute("password", cookie.getValue());
					}
				}
			}
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else if (uri.contains("forgotpassword")) {
			request.getRequestDispatcher("/views/user/forgotpassword.jsp").forward(request, response);
		} else if (uri.contains("user-update")) {

		} else if (uri.contains("user-register")) {
			request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
		} else if (uri.contains("home")) {
			request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
		} else if (uri.contains("adminHome")) {
			request.getRequestDispatcher("/views/admin/homeAdmin.jsp").forward(request, response);
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

		} else if (uri.contains("login")) {
			this.login(request, response);
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession message = request.getSession();
		String check = request.getParameter("check");

//		message.removeAttribute("message");

		if (email.isBlank()) {
			message.setAttribute("message", "Email không được để trống!");
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else if (password.isEmpty()) {
			message.setAttribute("message", "Mật khẩu không được để trống!");
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else if (!password.matches("^[a-zA-Z0-9]+$")) {
			message.setAttribute("message", "Mật khẩu không hợp lệ!");
			request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
		} else {

			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(password.getBytes());
				byte[] hashedPasswordBytes = md.digest();
				String hashedPassword = bytesToHex(hashedPasswordBytes);
				User us = user.checkLogin(email, hashedPassword);

				if (us == null) {
					message.setAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
//					response.sendRedirect("/Zootube/user/login");
					request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
				} else {

					if (us.isIsadmin() == true) {

						Cookie mail = new Cookie("Email", email);
						Cookie pass = new Cookie("Pass", password);
						
						if (check != null) {
							mail.setMaxAge(20 * 60);
							pass.setMaxAge(20 * 60);
						} else {
							mail.setMaxAge(0);
							pass.setMaxAge(0);
						}
						response.addCookie(mail);
						response.addCookie(pass);
						response.sendRedirect("/Zootube/admin/adminHome");
					} else {

						Cookie mail = new Cookie("Email", email);
						Cookie pass = new Cookie("Pass", password);
						
						if (check != null) {
							mail.setMaxAge(20 * 60);
							pass.setMaxAge(20 * 60);
						} else {
							mail.setMaxAge(0);
							pass.setMaxAge(0);
						}
						response.addCookie(mail);
						response.addCookie(pass);
						response.sendRedirect("/Zootube/user/home");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				message.setAttribute("message", "Đăng nhập thất bại!!");
				request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
			}
		}
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
