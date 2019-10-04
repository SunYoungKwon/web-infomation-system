package webinfo.hw3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webinfo.hw3.model.Calculate;

@WebServlet("/doCalcul")
public class doCalcul extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public doCalcul() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String n1 = request.getParameter("num1");
		String n2 = request.getParameter("num2");
		String sign = request.getParameter("sign");
		String result;
		
		Calculate cal = new Calculate(n1, n2, sign);
		result = cal.getResultStr();
		
		request.setAttribute("resultStr", result);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
