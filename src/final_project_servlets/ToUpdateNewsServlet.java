package final_project_servlets;

import final_project.Category;
import final_project.DBConnection;
import final_project.News;
import final_project.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/save-news")
public class ToUpdateNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int id = Integer.parseInt(request.getParameter("id"));
            int category_id = Integer.parseInt(request.getParameter("category"));

            News news = DBConnection.getNewsById(id);
            Category c = DBConnection.getCategory(category_id);

            if(news!=null) {
                news.setTitle(title);
                news.setContent(content);
                news.setCategory(c);

                DBConnection.updateNews(news);

                response.sendRedirect("/news-details?id="+id);

            }else{
                response.sendRedirect("/");
            }

        }else{
            response.sendRedirect("/login");
        }
    }
}
