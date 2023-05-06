package final_project_servlets;

import final_project.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-news")
public class ToAddNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String category = request.getParameter("category");

            News news = new News();
            news.setTitle(title);
            news.setContent(content);

            Category c = new Category();
            c.setName(category);

            news.setCategory(c);

            DBConnection.addNews(news);

            response.sendRedirect("/add-news-page");

        }else{
            response.sendRedirect("/login");
        }
    }
}
