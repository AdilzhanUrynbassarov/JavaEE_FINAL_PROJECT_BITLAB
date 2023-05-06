package final_project_servlets;

import final_project.Comment;
import final_project.DBConnection;
import final_project.News;
import final_project.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-comment")
public class ToAddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("currentUser");

        if (user != null) {

            String commentText = request.getParameter("comment");
            int newsId = Integer.parseInt(request.getParameter("news_id"));

            News news = DBConnection.getNewsById(newsId);

            if (news != null) {

                Comment comment = new Comment();
                comment.setNews(news);
                comment.setUser(user);
                comment.setComment(commentText);

                DBConnection.addComment(comment);

                response.sendRedirect("/news-details?id="+newsId);

            }else{
                response.sendRedirect("/");
            }

        } else {
            response.sendRedirect("/login");
        }
    }
}
