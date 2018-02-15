/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspC/ApacheTomcat8
 * Generated at: 2017-12-26 00:22:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.File;

public final class AddPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1513853022000L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1513853022000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Properties");
    _jspx_imports_classes.add("java.io.FileInputStream");
    _jspx_imports_classes.add("java.io.File");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(' ');
      out.write(" \n\n\n");

   String path = request.getContextPath();
   String configPath=getServletContext().getRealPath("/WEB-INF/config.properties");
   
    Properties properties=new Properties();
    properties.load(new FileInputStream(configPath));
    String siteTitle=properties.getProperty("siteTitle");
     
      out.write("\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\n\t<title>");
      out.print(siteTitle);
      out.write("</title>\n\t<link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/style.css\" type=\"text/css\" charset=\"utf-8\" />\n           ");
 out.print("<script src=\""+path+"/jquery.min.js\" type=\"text/javascript\"></script>"); 
      out.write("\n</head>\n\n<body>\n<div id=\"container\" >\n\n     <div id=\"Menu\">\n\t\t<ul id=\"menu-bar\" style=\"margin-left: auto ;  margin-right: auto ;\" >\n\t\t\t<li class=\"current\"><a href=\"");
      out.print(path);
      out.write("\">Home</a></li>\n\t\t\t\n\t\t\t<li><a href=\"#\">Vulnerability</a>\n\t\t\t\t<ul><li><a href=\"#\">A1- Injection</a>\n\t\t\t\t\t<ul><li><a href=\"#\">SQL Injection</a>\n\t\t\t\t\t\t<ul>\n\t\t\t\t\t\t  <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/forumposts.jsp?postid=1\">Sql Injection 1</a></li>\n\t\t\t\t\t\t  <li><a href=\"");
      out.print(path);
      out.write("/login.jsp\">Authentication Bypass</a></li>\n\t\t\t\t\t\t  <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/sqli/download.jsp\">Blind SQLi 1</a></li>\n                                                   <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/sqli/union2.jsp\">Union 2</a></li>\n                                                </ul>\n                                            </li>\n                                                <li><a href=\"#\">XPath Injection</a>\n                                                 <ul>\n\t\t\t\t\t\t  <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/Injection/xpath_login.jsp\">Login Bypass</a></li>\n                                                 </ul>\n                                                </li>\n                                                  <li><a href=\"#\">XML Injection</a>\n                                                 <ul>\n\t\t\t\t\t\t  <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/Injection/xxe.jsp\">External Entity</a></li>\n                                                  <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/Injection/xslt.jsp?style=1.xsl\">XSLT Injection</a></li>\n                                                 \n                                                 </ul>\n                                                </li>\n                                           <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/Injection/orm.jsp?id=1\">ORM Injection</a></li>\n                                                 \n\t\t\t\t\t</ul>\n                                     </li>\n                                   \n                                    <li><a href=\"#\">A2- Broken Authentication & Session Management</a>\n                                       <ul>\n                                           <li><a href=\"");
      out.print(path);
      out.write("/ForgotPassword.jsp\">UserName Enumeration</a></li>\n                                           <li><a href=\"");
      out.print(path);
      out.write("/login.jsp\">Brute Foce Login Page</a></li>\n                                           <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/baasm/URLRewriting.jsp;jsessionid=");
      out.print(session.getId());
      out.write("\">Session ID in URL</a></li>\n                                           <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/baasm/SiteTitle.jsp\">Improper Authentication: Privilege Escalation</a></li>\n                                       \n                                       </ul>\n                                     </li>\n                                        \n\t\t\t   \t       <li><a href=\"#\">A3- XSS</a>\n\t\t\t\t             <ul>\n\t\t\t\t\t       <li><a href=\"#\">Reflected(GET)</a>\n\t\t\t\t\t \t <ul>\n\t\t\t\t\t\t\t<li> <a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/search.jsp\">Challenge 1</a></li>\n\t\t\t\t\t\t\t<li> <a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/xss2.jsp\">Challenge 2</a></li>\n\t\t\t\t\t\t\t<li> <a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/xss3.jsp\">Challenge 3</a></li>\n\t\t\t\t\t\t\t<li> <a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/xss4.jsp\">Challenge 4</a></li>\n\t\t\t\t\t       \t </ul>\n\t\t\t\t\t       </li>\n\t\t\t\t\t\t\n\t\t\t\t\t       <li><a href=\"#\">Flash Based</a>\n\t\t\t\t\t\t <ul>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/flash/xss1.swf?vuln=");
      out.print(path);
      out.write("\">Challenge 1</a></li>\n\t\t\t\t\t\t \t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/xss/flash/exss.jsp\">Challenge 2</a></li>\n\t\t\t\t\t\t </ul>\n\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/forum.jsp\">Stored XSS(Persistent)</a></li>\n\t\t\t\t  \t    </ul>\n\t\t\t\t\t\t\n\t\t\t\t\t</li>\n\t\t\t\t\t<li><a href=\"#\">A4-Insecure Direct Object References</a>\n\t\t\t\t\t<ul>\n                                            <li><a href=\"");
      out.print(path);
      out.write("/myprofile.jsp?id=");
 if(session.getAttribute("userid")!=null){ out.print(session.getAttribute("userid"));} 
      out.write("\" title=\"Make sure you have logged in \">Viewing Details</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/idor/change-email.jsp\" title=\"Make sure you have logged in \">Modifying email ID</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/idor/download.jsp\">Download Document</a>\n\t\t\t\t\t\t</li>\n\t\t\t\t\t</ul>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li><a href=\"#\">A5-Security Misconfiguration</a>\n\t\t\t\t\t\t<ul>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/install.jsp\">Setup Page not removed</a></li>\t\t\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/admin/\">Default Admin Credentials not changed</a></li>\n                                                        <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/securitymisconfig/pages.jsp?id=1\">Error Handling</a></li>\n\n\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t</li>\n                                        <li><a href=\"#\">A6-Sensitive Data Exposure</a>\n\t\t\t\t\t\t<ul>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/changeCardDetails.jsp\">Cleartext Transmission of Sensitive Information</a></li>\t\t\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/ForgotPassword.jsp\">Storing Login Credentials in Plain Text</a></li>\t\n                                                        <li><a href=\"");
      out.print(path);
      out.write("/login.jsp\">Storing Login Credentials in Plain Text in a cookie</a></li>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/sde/hash.jsp\">Hashed Credentials</a></li>\n\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t</li>\n                                        <li><a href=\"#\">A7- Missing Function Level Access Control</a>\n\t\t\t\t\t\t<ul>                \n                                                    <li> <a href=\"");
      out.print(path);
      out.write("/admin/\" title=\"Hint: Forced Browsing\">Challenge 1:Bypass Admin Login</a></li>\n                                                    <li> <a href=\"");
      out.print(path);
      out.write("/admin/AddPage.jsp\"> Challenge 2: Add Page</a></li>\n                                                    <li> <a href=\"");
      out.print(path);
      out.write("/admin/Configure.jsp\"> Configure</a></li>\n                                                     <li> <a href=\"");
      out.print(path);
      out.write("/vulnerability/mfac/SearchEngines.jsp\"> Crawlers</a></li>                                             \n                                                </ul>\n                                        </li>\n\t\t\t\t\t<li><a href=\"#\">A8- CSRF</a>\n\t\t\t\t\t\t<ul>\n                                                    <li><a href=\"");
      out.print(path);
      out.write("/vulnerability/csrf/change-info.jsp\">CSRF 1(GET): Change Info</a></li>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/csrf/changepassword.jsp\">CSRF 2(POST): Change Password</a></li>\n\t\t\t\t\t\t</ul>\n\t\t\t\t\t</li>\n                                        <li><a href=\"#\">A9- Using components with known vulnerabilities</a>\n\t\t\t\t\t\t<ul>\n                                                    <li><a href=\"/VulnerableSpring/error.htm?msg=error.c403\">Web Application using Spring Framework</a></li>\n                                                </ul>\n\t\t\t\t\t</li>\n\t\t\t\t\t<li><a href=\"#\">A10. Unvalidated Redirect & Forward..</a>\n\t\t\t\t\t\t<ul>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/unvalidated/OpenURL.jsp\">Open Redirect</a>\n\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/unvalidated/OpenForward.jsp\">Open Forward</a>\n\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t</ul>\n\t\t\t\t\t</li>\n\t\t\t\t\t \n\t\t\t</ul></li>\n\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/vulnerability/forum.jsp\">Forum</a></li>\n\t\t\t\t");
 
                                if(session.getAttribute("isLoggedIn")!=null && session.getAttribute("isLoggedIn").equals("1"))
                                {
                                    if(session.getAttribute("privilege")!=null && session.getAttribute("privilege").equals("admin"))
                                    {
                                       out.print("<li><a href='"+path+"/admin/admin.jsp'>Admin Panel</a></li>"); 
                                    }
                                    out.print("<li><a href='"+path+"/myprofile.jsp?id="+session.getAttribute("userid")+"'>My Profile</a></li>");
                                     out.print("<li><a href='"+path+"/Logout'>Logout</a></li>");
                                }
                                else
                                {
                                   out.print("<li><a href='"+path+"/login.jsp'>LogIn</a></li>");
                                    out.print("<li><a href='"+path+"/Register.jsp'>Register</a></li>");
                                }
                                
      out.write("\n\t\t\t<li><a href=\"");
      out.print(path);
      out.write("/contact.jsp\">Contact</a></li>\n\t\t</ul>\n\t</div>\n\n\t<div id=\"Main-Container\">\n\t<br/>\n\t<div id=\"logo\">\n\n<h1>");
      out.print(siteTitle);
      out.write("</h1>\n</div>\n<br/>\n\t\n\t\t\n\t\t<div id=\"Main\">\n\t\t");
      out.write('\n');
      out.write(' ');

 if(session.getAttribute("privilege")!=null && session.getAttribute("privilege").equals("admin"))
{
 
      out.write(" \n \n <form action=\"AddPage.do\" method=\"POST\">\n<table> \n    <tr><td>File Name:</td> <td><input type=\"text\" name=\"filename\" value=\"\"/></td></tr>\n    <tr><td>Content :</td><td><textarea name=\"content\" cols=\"50\" rows=\"10\"></textarea></td></tr>\n    <tr><td></td><td><input type=\"submit\" name=\"Create\" value=\"Create\"/></td></tr>\n</table>  \n</form>\n ");

  }
 else
 {
     out.print("<b class='fail'> x You Are not Authorized to view this Page x </b>");
 }
 
      out.write('\n');
      out.write(' ');
      out.write("</div>\n\t\n\t\t<div class=\"clear\"></div>\n\t</div>\n\t\t\n\t<center>\t<p>Copyrights &copy; <b><a href=\"http://www.cysecurity.org\">Cyber Security & Privacy Foundation </a> </p></b></center>\n\t\t\n\t\n\n</div>\n</body>\n</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
