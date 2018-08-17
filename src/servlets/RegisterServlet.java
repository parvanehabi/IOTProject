package servlets;

import beans.DeviceEntity;
import beans.UsersEntity;
import services.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("Name"));
        System.out.println(request.getParameter("IDDevice"));
        System.out.println(request.getParameter("Email"));
        System.out.println(request.getParameter("Password"));
        String username = request.getParameter("Name");
        String idDevice = request.getParameter("IDDevice");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        List<Object> list = null;
        try {
            list = DatabaseService.selectAll("DeviceEntity","iddevice","=",Integer.valueOf(idDevice),"");
        } catch (Exception e) {
            System.out.println("DB Connection Error! RegisterServlet!");
            e.printStackTrace();
        }
        if(list.size()==0){
            System.out.println("device not found!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setDeviceByIddevice((DeviceEntity) list.get(0));
        usersEntity.setEmail(email);
        usersEntity.setPassword(password);
        usersEntity.setUsername(username);
        DatabaseService.insertObject(usersEntity);
        System.out.println("user registered!");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
