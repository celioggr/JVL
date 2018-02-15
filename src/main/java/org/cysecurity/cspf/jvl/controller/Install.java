package org.cysecurity.cspf.jvl.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author breakthesec
 */
public class Install extends HttpServlet {

  private static final long   serialVersionUID = 1L;
  private static final String PROPERTIES_PATH  = "/WEB-INF/config.properties";
  static String               dburl;
  static String               jdbcdriver;
  static String               dbuser;
  static String               dbpass;
  static String               dbname;
  static String               siteTitle;
  static String               adminuser;
  static String               adminpass;

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

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    System.out.println("Initialization");
    readConfig();
    performSetup();
  }

  private void readConfig() throws ServletException {
    String configPath = getServletContext().getRealPath(PROPERTIES_PATH);
    try (FileInputStream in = new FileInputStream(configPath)) {
      Properties config = new Properties();
      config.load(in);
      dburl = config.getProperty("dburl");
      jdbcdriver = config.getProperty("jdbcdriver");
      dbuser = config.getProperty("dbuser");
      dbpass = config.getProperty("dbpass");
      dbname = config.getProperty("dbname");
    } catch (IOException e) {
      throw new ServletException(e);
    }
  }

  protected void processRequest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
      PrintWriter out = response.getWriter();
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet install</title>");
      out.println("</head>");
      out.println("<body>");
      if (performSetup()) {
        out.print("successfully installed");
      } else {
        out.print("Something went wrong. Unable to install");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {

    }
  }

  private boolean performSetup() {
    try {
      Class.forName(jdbcdriver);
      String fullURL = dburl + dbname;
      System.out.println("Database URL: " + fullURL);
      Connection con = DriverManager.getConnection(fullURL); // ,dbuser,dbpass);
      // User Table creation
      Statement stmt = con.createStatement();
      doSetup(stmt, "Drop table if exists users");
      doSetup(stmt,
          "Create table users(ID int NOT NULL AUTO_INCREMENT, username varchar(30),email varchar(60), password varchar(60), about varchar(50),privilege varchar(20),avatar TEXT,secretquestion int,secret varchar(30),primary key (id))");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('admin','admin','admin@localhost','I am the admin of this application','default.jpg','admin',1,'rocky')");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('victim','victim','victim@localhost','I am the victim of this application','default.jpg','user',1,'max')");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('attacker','attacker','attacker@localhost','I am the attacker of this application','default.jpg','user',1,'bella')");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('NEO','trinity','neo@matrix','I am the NEO','default.jpg','user',1,'sentinel')");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('trinity','NEO','trinity@matrix','it is Trinity','default.jpg','user',1,'sentinel')");
      doSetup(stmt,
          "INSERT into users(username, password, email,About,avatar, privilege,secretquestion,secret) values ('Anderson','java','anderson@1999','I am computer programmer','default.jpg','user',1,'C++')");

      // Posts table creation
      doSetup(stmt, "Drop table if exists posts");
      doSetup(stmt,
          "create table posts(postid int NOT NULL AUTO_INCREMENT, content TEXT,title varchar(100), user varchar(30), primary key (postid))");
      doSetup(stmt,
          "INSERT into posts(content,title, user) values ('Feel free to ask any questions about Java Vulnerable Lab','First Post', 'admin')");
      doSetup(stmt,
          "INSERT into posts(content,title, user) values ('Hello Guys, this is victim','Second Post', 'victim')");
      doSetup(stmt,
          "INSERT into posts(content,title, user) values ('Hello This is attacker','Third Post', 'attacker')");
      doSetup(stmt,
          "INSERT into posts(content,title, user) values ('Trinity! Help!','Help','neo')");

      doSetup(stmt, "Drop table if exists tdata");
      doSetup(stmt, "create table tdata(id int, page varchar(30))");
      doSetup(stmt, "Insert into tdata values(1,'ext1.html')");
      doSetup(stmt, "Insert into tdata values(2,'ext2.html')");

      // Messages Table Creation
      doSetup(stmt, "Drop table if exists Messages");
      doSetup(stmt,
          "Create table Messages(msgid int NOT NULL AUTO_INCREMENT,name varchar(30),email varchar(60), msg varchar(500),primary key (msgid))");
      doSetup(stmt,
          "INSERT into Messages(name,email, msg) values ('TestUser','Test@localhost', 'Hi admin, how are you')");

      // User Messages Table Creation recipient, sender, email, msg
      doSetup(stmt, "Drop table if exists UserMessages");
      doSetup(stmt,
          "Create table UserMessages(msgid int NOT NULL AUTO_INCREMENT,recipient varchar(30),sender varchar(30),subject varchar(60), msg varchar(500),primary key (msgid))");
      doSetup(stmt,
          "INSERT into UserMessages(recipient, sender, subject, msg) values ('attacker','admin','Hi','Hi<br/> This is admin of this page. <br/> Welcome to Our Forum')");
      doSetup(stmt,
          "INSERT into UserMessages(recipient, sender, subject, msg) values ('victim','admin','Hi','Hi<br/> This is admin of this page. <br/> Welcome to Our Forum')");

      // Credit Card Table Creation
      doSetup(stmt, "Drop table if exists cards");
      doSetup(stmt,
          "Create table cards(id int,cardno varchar(80), cvv varchar(6),expirydate varchar(15))");
      doSetup(stmt,
          "INSERT into cards(id,cardno, cvv,expirydate) values ('1','4000123456789010','123','12/2014')");
      doSetup(stmt,
          "INSERT into cards(id,cardno, cvv,expirydate) values ('2','4111111111111111 ','321','7/2015')");
      doSetup(stmt,
          "INSERT into cards(id,cardno, cvv,expirydate) values ('3','5111111111111118','111','1/2017')");

      // Files List Table Creation
      doSetup(stmt, "Drop table if exists FilesList");
      doSetup(stmt,
          "Create table FilesList(fileid int NOT NULL AUTO_INCREMENT,path text,primary key (fileid))");
      doSetup(stmt, "INSERT into FilesList(path) values ('/docs/doc1.pdf')");
      doSetup(stmt,
          "INSERT into FilesList(path) values ('/docs/exampledoc.pdf')");

      return true;
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      ex.printStackTrace(System.out);
    } catch (ClassNotFoundException ex) {
      System.out.print("JDBC Driver Missing:<br/>" + ex);

    }
    return false;
  }

  private void doSetup(Statement stmt, String sql) throws SQLException {
    System.out.printf("SQL: '%s'\n", sql);
    stmt.executeUpdate(sql);
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