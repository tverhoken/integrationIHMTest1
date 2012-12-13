package com.toto.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessService extends HttpServlet implements Servlet {

   private static final long serialVersionUID = 1L;
   private static final Map<String, String> table = new HashMap<>(1);
   static {
      table.put("toto", "password");
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response) {
      doPost(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) {
      String id = request.getParameter("ident");
      String pwd = request.getParameter("pwd");
      try {
	 PrintWriter wr = response.getWriter();
	 wr.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>TEST !</title></head><body><center>");
	 if (table.containsKey(id) && table.get(id).equals(pwd)) {
	    wr.write("<p>Congratulations " + id
		  + "! you are now connected to this wonderful web site ! Hope you enjoy this experience :-D</p>");
	 } else {
	    wr.write("<H2><font color=\"red\">Sorry, your password is wrong or you are not registered on this web site.</font></H2>");
	 }
	 wr.write("</center></body></html>");
	 wr.flush();
	 wr.close();
      } catch (IOException e) {
	 e.printStackTrace();
      }
   }
}
