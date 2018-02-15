/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cysecurity.cspf.jvl.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.cysecurity.cspf.jvl.model.DBConnect;
import org.apache.commons.text.StringEscapeUtils;

/**
 *
 * @author breakthesec
 */
public class LoginValidator extends HttpServlet {

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

    String user = request.getParameter("username").trim();
    String pass = request.getParameter("password").trim();
    try {
      Connection con = new DBConnect().connect(
          getServletContext().getRealPath("/WEB-INF/config.properties"));
      if (con != null && !con.isClosed()) {
        ResultSet rs = null;
        
        //Statement stmt = con.createStatement();
        PreparedStatement pstmt = con.prepareStatement("select * from users where username=? and password=?"); 
        //rs = stmt.executeQuery("select * from users where username='" + user + "' and password='" + pass + "'");
        
        //Set Parameters
        pstmt.setString(1, user);
        pstmt.setString(2, pass);
        
        // Execute SQL query
        rs = pstmt.executeQuery();
        
        if (rs != null && rs.next()) {
          HttpSession session = request.getSession();
          session.setAttribute("isLoggedIn", "1");
          session.setAttribute("userid", rs.getString("id"));
          session.setAttribute("user", rs.getString("username"));
          session.setAttribute("avatar", rs.getString("avatar"));
          
          Cookie privilege = new Cookie("privilege", "user");
          privilege.setHttpOnly(true);
          privilege.setSecure(true); 
          
          response.addCookie(privilege);
          
          if (request.getParameter("RememberMe") != null) {
        	  
            Cookie username = new Cookie("username", StringEscapeUtils.escapeJava(user));
            username.setSecure(true);
            username.setHttpOnly(true); //HttpOnly flag
            
      
            Cookie password = new Cookie("password", StringEscapeUtils.escapeJava(pass));
            password.setSecure(true);
            password.setHttpOnly(true); //HttpOnly flag
           
            response.addCookie(username);
            response.addCookie(password);
          }
          response.sendRedirect(
              response.encodeURL("ForwardMe?location=/index.jsp"));
          
        } else {
          response.sendRedirect(
              "ForwardMe?location=/login.jsp&err=Invalid Username or Password");
        }

      }
    } catch (Exception ex) {
      response.sendRedirect("login.jsp?err=something went wrong");
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
