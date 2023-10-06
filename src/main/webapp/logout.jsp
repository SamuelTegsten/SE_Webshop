<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    // Get the user's session
    session = request.getSession(false);

    // Check if a session exists
    if (session != null) {
        // Invalidate the session to log the user out
        session.invalidate();
    }

    // Redirect the user to a login page or another appropriate page
    response.sendRedirect("account.jsp");
%>
