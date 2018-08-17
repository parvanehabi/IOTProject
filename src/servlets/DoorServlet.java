package servlets;

import beans.NotificationEntity;
import beans.UsersEntity;
import services.DatabaseService;
import services.SocketServerConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "OpenDoor" , urlPatterns = "/openDoor")
public class DoorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersEntity user = (UsersEntity)request.getSession().getAttribute("user");
        System.out.print("open door\n"+user.getDeviceByIddevice()+"\n");
        SocketServerConfig.print("open door\n"+user.getDeviceByIddevice()+"\n");
   //     SocketServerConfig.print("open door :"+user.getDeviceByIddevice().getIddevice());
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setDeviceByIddevice(((UsersEntity)request.getSession().getAttribute("user")).getDeviceByIddevice());
        notificationEntity.setNotificationText("door opened");
        notificationEntity.setRecorddate(new Timestamp(System.currentTimeMillis()));
        DatabaseService.insertObject(notificationEntity);
        System.out.println("saved door notification");
        request.getRequestDispatcher("/index1.jsp").forward(request, response);
    }
}
