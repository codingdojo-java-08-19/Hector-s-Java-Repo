package com.rotech.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get triggerd");
		HttpSession session = request.getSession();
		if(session.getAttribute("tooLow") == null) {
			session.setAttribute("tooHigh", false);
			session.setAttribute("tooLow", false);
			session.setAttribute("correct", false);
		}
		request.setAttribute("tooHigh", session.getAttribute("tooHigh"));
		request.setAttribute("tooLow", session.getAttribute("tooLow"));
		request.setAttribute("correct", session.getAttribute("correct"));
		
		Random random = new Random();
		
		
		if(session.getAttribute("answer") == null ) {
			session.setAttribute("answer", random.nextInt(100));
		}else if(session.getAttribute("correct")=="true") {
			session.setAttribute("answer", random.nextInt(100));
		}
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post triggerd");
		HttpSession session = request.getSession();
		Integer guess = Integer.parseInt(request.getParameter("guess"));
		Integer answer = (Integer) session.getAttribute("answer");
		if(guess > answer) {
			System.out.println("if triggerd");
			session.setAttribute("tooHigh", true);
			session.setAttribute("tooLow", false);
		}else if(guess < answer) {
			System.out.println("else if triggerd");
			session.setAttribute("tooHigh", false);
			session.setAttribute("tooLow", true);
		}else {
			System.out.println("else triggerd");
			session.setAttribute("correct", true);
			session.setAttribute("tooHigh", false);
			session.setAttribute("tooLow", false);
		}
		
		response.sendRedirect("/GreatNumberGame/Game");
	}

}
