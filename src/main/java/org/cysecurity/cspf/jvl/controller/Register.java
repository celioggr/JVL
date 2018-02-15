/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cysecurity.cspf.jvl.controller;
import qses.extra.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cysecurity.cspf.jvl.model.DBConnect;

/**
 *
 * @author breakthesec
 */
public class Register extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   * @throws ServletException
   *           if a servlet-specific error occurs
   * @throws IOException
   *           if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
    	
      //PasswordChecker pc = new PasswordChecker();
      
      PrintWriter out = response.getWriter();
      Connection con = new DBConnect().connect(
      getServletContext().getRealPath("/WEB-INF/config.properties"));
      String user = request.getParameter("username");
      String pass = request.getParameter("password");
      String email = request.getParameter("email");
      String about = request.getParameter("About");
      String secret = request.getParameter("secret");
      if (secret == null || secret.equals("")) {
        secret = "nosecret";
      }
      if(PasswordChecker.isValid(pass)) {
	      try {
	    	 
	    	if (con != null && !con.isClosed() ) {
	        		
	        
	        String var1 = "default.jpg";
	        String var2 = "user";
	        String var3 = "1";
	        
	        PreparedStatement pstmt1 = con.prepareStatement("INSERT into users(username, password, email, About,avatar,privilege,secretquestion,secret) values"
	        		+"(?,?,?,?,?,?,?,?)" );
	        pstmt1.setString(1, user);
	        pstmt1.setString(2, pass);
	        pstmt1.setString(3, email);
	        pstmt1.setString(4, about);
	        pstmt1.setString(5, var1);
	        pstmt1.setString(6, var2);
	        pstmt1.setString(7, var3);
	        pstmt1.setString(8, secret);
	        pstmt1.executeUpdate();
	        
	          /*
	          pstmt1.executeUpdate(
	              "INSERT into users(username, password, email, About,avatar,privilege,secretquestion,secret) values ('"
	                  + user + "','" + pass + "','" + email + "','" + about
	                  + "','default.jpg','user',1,'" + secret + "')");
	          */
	        
	        String var4 = "admin";
	        String var5 = "Hi";
	        String var6 = "Hi<br/> This is admin of this page. <br/> Welcome to Our Forum";
	        
	        PreparedStatement pstmt2 = con.prepareStatement("INSERT into UserMessages(recipient, sender, subject, msg) values"
	        		+ "(?,?,?,?)");
	        
	        pstmt2.setString(1, user);
	        pstmt2.setString(2, var4);
	        pstmt2.setString(3, var5);
	        pstmt2.setString(4, var6);
	        pstmt2.executeUpdate();
	        
	        /*
	          stmt.executeUpdate(
	              "INSERT into UserMessages(recipient, sender, subject, msg) values ('"
	                  + user
	                  + "','admin','Hi','Hi<br/> This is admin of this page. <br/> Welcome to Our Forum')");
	        */
	         
	        response.sendRedirect("index.jsp");
	
	        } else {
	          response.sendRedirect("Register.jsp");
	        }
	      } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	        System.out.println("SQLState: " + ex.getSQLState());
	        System.out.println("VendorError: " + ex.getErrorCode());
	
	      }
      }else {
    	  //Redirect since provided Password does not meet with the Policy
    	  response.sendRedirect("Register.jsp");
      }
   
    } catch (Exception e) {

    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
  // the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   * @throws ServletException
   *           if a servlet-specific error occurs
   * @throws IOException
   *           if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request
   *          servlet request
   * @param response
   *          servlet response
   * @throws ServletException
   *           if a servlet-specific error occurs
   * @throws IOException
   *           if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
