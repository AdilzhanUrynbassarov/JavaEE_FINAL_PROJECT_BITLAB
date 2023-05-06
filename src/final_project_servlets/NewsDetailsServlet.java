package final_project_servlets;

import final_project.Category;
import final_project.Comment;
import final_project.DBConnection;
import final_project.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/news-details")
public class NewsDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        News news = DBConnection.getNewsById(id);
        request.setAttribute("news", news);

        ArrayList<Category> categories = DBConnection.getCategories();
        request.setAttribute("cats", categories);

        if (news != null) {
            ArrayList<Comment> comments = DBConnection.getComments(news.getId());
            request.setAttribute("comments", comments);
        }
        request.getRequestDispatcher("/newsdetails.jsp").forward(request, response);
    }
}
