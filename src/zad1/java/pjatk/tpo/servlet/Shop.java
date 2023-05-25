package pjatk.tpo.servlet;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.sql.*;


import static pjatk.tpo.servlet.MySQL.initializeDatabase;

@WebServlet(name = "shop", value = "/shop1")
public class Shop extends HttpServlet {
    private String message;
    Connection con;

    public void init() {
        message = "Hello " + System.getProperty("user.name");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = 0;

        String cost = request.getParameter("cost");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String quare = "";
        ResultSet rs;
        if (cost.isEmpty() && author.isEmpty() && !name.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookname =" + "\'" + name + "\'";
        } else if (!cost.isEmpty() && !author.isEmpty() && !name.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookcost <= " + cost + " AND books.book.bookauthor =" + "\'" + author + "\'" + " AND books.book.bookname =" + "\'" + name + "\'";
        } else if (author.isEmpty() && name.isEmpty() && !cost.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookcost <= " + cost;
        } else if (cost.isEmpty() && !name.isEmpty() && !author.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookname =" + "\'" + name + "\'" + " AND books.book.bookauthor = " + "\'" + author + "\'";
        } else if (!author.isEmpty() && cost.isEmpty() && !name.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookauthor =" + "\'" + author + "\'";
        } else if (!cost.isEmpty() && !author.isEmpty() && name.isEmpty()) {
            quare = "SELECT * FROM books.book WHERE books.book.bookcost <= " + cost + " AND books.book.bookauthor =" + "\'" + author + "\'";
        } else {
            quare = "SELECT * FROM books.book";
        }
        try {
            Connection con = null;

            con = initializeDatabase();
            PreparedStatement st = con
                    .prepareStatement(quare);
            st.executeQuery();
            rs = st.executeQuery();
            out.println("<html><body>");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>ID</th><th>Name</th><th>Author</th><th>Cost</th><tr>");
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                author = rs.getString(3);
                cost = rs.getString(4);

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + author + "</td><td>" + cost + "</td></tr>");
            }
            out.println("</table>");

            out.println("<input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">");
            out.println("</html></body>");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void destroy() {
    }
}


