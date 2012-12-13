package com.toto.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet implements Servlet {

   private static final long serialVersionUID = 1L;

   public void doGet(HttpServletRequest request, HttpServletResponse response) {
      String name = request.getParameter("name");
      try {
	 response.setContentType("text/html");
	 response.setHeader("Cache-Control", "no-cache");
	 response.setHeader("Access-Control-Allow-Origin", "*");
	 PrintWriter wr = response.getWriter();
	 if (name != null && !name.isEmpty()) {
	    wr.write("<p>Hello " + name + " ! Welcome !</p>");
	 } else {
	    wr.write("");
	 }
	 wr.flush();
	 wr.close();
      } catch (IOException e) {
	 e.printStackTrace();
      }
   }
}
