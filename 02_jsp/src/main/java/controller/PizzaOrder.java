package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaOrder
 */
@WebServlet("/order.do")
public class PizzaOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaOrder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청시 전달값 뽑기

		request.setCharacterEncoding("utf-8");

		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String message = request.getParameter("message");

		String pizza = request.getParameter("pizza");
		String[] toppings = request.getParameterValues("topping");
		String[] sides = request.getParameterValues("side");
		String payment = request.getParameter("payment");

		response.setContentType("text/html; charset=utf-8");

		System.out.println(userName + phone);
		PrintWriter out = response.getWriter();

//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<title>피자주문정보페이지</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<script>alert('주문완료!')</script>");
//		out.println("<h2>반갑습니다. " + userName + " 주문자님 !</h2>");
//		out.println("<h2>전화번호 : " + phone + "</h2>");
//		out.println("<h2>주소 : " + address + "</h2>");
//		out.println("<h2>요청사항 : " + message + "</h2>");
//
//		out.println("피자 : " + pizza + "<br><br>"); 
//		out.println("토핑 : " + Arrays.toString(toppings) + "<br><br>");
//		out.println("사이드 : " + Arrays.toString(sides) + "<br><br>");
//		out.println("결제방식 : " + payment);
//
//		out.println("</body>");
//		out.println("</html>");
//		out.flush();
//		out.close();

		// 2. 요청처리 (주로 JDBC)
		String orderNo = "20240828-1239451";

		// 3. 돌려받은 결과를 가지고 응답페이지
		//    응답페이지 : 주문결과페이지.jsp
		//    응답페이지 제작하는 과정을 jsp로 이동(forward)해서 진행
		/*
		 * 단, forward(이동) 되는 응답 jsp 상에 필요한 데이터는 request에 담아서 전달해야됨
		 * 
		 * * HttpServletRequest 응답데이터 처리 메소드
		 * 	 1) setAttribute(String 속성, Object 값)	: forward 하는 jsp에서 사용할 데이터를 담는 메소드
		 *   2) setAttribute(String 속성)				: 해당 데이터를 Object 타입으로 반환
		 *   3) removeAttribute(String 속성)			: 해당 데이터를 제거하는 메소
		 */
		request.setAttribute("userName", userName);
		request.setAttribute("orderNo", orderNo);
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sides", sides);
		request.setAttribute("payment", payment);
		
		request.getRequestDispatcher("/d_pizza/pizzaOrderResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
