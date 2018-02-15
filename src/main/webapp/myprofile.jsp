 <%@ include file="/header.jsp" %>
 <%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.SQLException"%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page import="org.cysecurity.cspf.jvl.model.DBConnect"%>
<%@ page import="org.apache.commons.text.StringEscapeUtils"%>

<%

response.setHeader("X-Frame-Options", "DENY"); 
response.setHeader("X-Content-Type-Options","nosniff");
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma" ,"no-cache");
response.setHeader("X-XSS-Protection","1");

if(session.getAttribute("isLoggedIn")!=null)
{
 Connection con=new DBConnect().connect(getServletContext().getRealPath("/WEB-INF/config.properties"));
         
   String id=request.getParameter("id");
   if(id!=null && !id.equals(""))
   {
        //Statement stmt = con.createStatement();
          	PreparedStatement pstmt = con.prepareStatement("select * from users where id=?");
          
        	ResultSet rs =null;
            pstmt.setString(1, id);
          	rs = pstmt.executeQuery();   
             //rs=stmt.executeQuery("select * from users where id="+id);
              if(rs != null && rs.next())
              {
            	String username = StringEscapeUtils.escapeHtml4(rs.getString("username"));
            	String email = StringEscapeUtils.escapeHtml4(rs.getString("email"));
            	String about = StringEscapeUtils.escapeHtml4(rs.getString("about"));
            
            	
            	out.print("UserName : "+username+"<br>"); 
                out.print("Email : "+email+"<br>"); 
                out.print("About : "+about+"<br>"); 
                 
                //Getting Card Details:
                	
                PreparedStatement pstmt1 = con.prepareStatement("select * from cards where id=?");	
                pstmt1.setString(1, id);
                //ResultSet rs1=stmt.executeQuery("select * from cards where id="+id);
                ResultSet rs1 = pstmt1.executeQuery(); 
                
                if(rs1 != null && rs1.next())
                {
                	
                	String cardno = StringEscapeUtils.escapeHtml4(rs1.getString("cardno"));
                	String cvv = StringEscapeUtils.escapeHtml4(rs1.getString("cvv"));
                	String expirydate = StringEscapeUtils.escapeHtml4(rs1.getString("expirydate"));
                	
                   out.print("<br/>-------------------<br/>Card Details:<br/>-------------------<br/>");
                   out.print("Card Number: "+cardno+"<br/>");
                   out.print("CVV: "+cvv+"<br/>");
                   out.print("Expiry Date: "+expirydate+"<br/>");
                }
                 else
                 {
                     out.print("<br/>No Card Details Found: <a href='changeCardDetails.jsp'>Add Card</a><br/>");
                 }
              }
   }
   else
   {
       out.print("ID Parameter is Missing");
   }
     
   out.print("<br/><ul type='square'>");
   out.print("<li><a href='"+path+"/vulnerability/csrf/change-info.jsp'>Change Description</a></li>");
    out.print("<li><a href='"+path+"/vulnerability/csrf/changepassword.jsp'>Change Password</a></li>");
     out.print("<li><a href='"+path+"/vulnerability/idor/change-email.jsp'>Change Email</a></li>");
      out.print("<li><a href='"+path+"/vulnerability/Messages.jsp'>Messages </a></li>"); 
         out.print("<li><a href='"+path+"/vulnerability/SendMessage.jsp'>Send Message </a></li>"); 
         out.print("</ul><br/>");
    out.print("<br/><a href='"+path+"/vulnerability/forum.jsp'>Return to Forum &gt;&gt;</a>");     
    
}
else
{
    out.print("Please login to see Your Profile");
}

%>
  
 <%@ include file="/footer.jsp" %>