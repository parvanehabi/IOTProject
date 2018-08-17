package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.AdminsEntity;
import beans.UsersEntity;
import services.DatabaseService;

@WebServlet(urlPatterns = "/index")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("user"));
        System.out.println(request.getParameter("password"));
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        List<Object> list = null;
        try {
            list = DatabaseService.selectAllWithJoin("UsersEntity","username","=",username,"deviceByIddevice");
        } catch (Exception e) {
            System.out.println("DB Connection Error! LoginServlet!");
            e.printStackTrace();
        }
        if(list.size()==0){
            try {
                list = DatabaseService.selectAll("AdminsEntity","adminName","=",username,"");
            } catch (Exception e) {
                System.out.println("DB Connection Error! LoginServlet!");
                e.printStackTrace();
            }
            if(((AdminsEntity)list.get(0)).getPassword().equals(password)){
                request.getSession().setAttribute("user",(AdminsEntity)list.get(0));
                request.getRequestDispatcher("/management.jsp").forward(request, response);
                return;
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if(((UsersEntity)list.get(0)).getPassword().equals(password)){
            request.getSession().setAttribute("user",(UsersEntity)list.get(0));
            request.getRequestDispatcher("/index1.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
