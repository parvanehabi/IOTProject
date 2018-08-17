package servlets;

import beans.DeviceEntity;
import beans.GatewayEntity;
import beans.ParcelEntity;
import services.DatabaseService;
import services.SocketServerConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "RecordDeviceServlet",urlPatterns = "/RecordDevice")
public class RecordDeviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String iddevice = request.getParameter("iddevice");
        String idgateway = request.getParameter("idgateway");
        String name = request.getParameter("devicename");
        System.out.println(iddevice);
        System.out.println(idgateway);
        System.out.println(name);
        DeviceEntity deviceEntity = new DeviceEntity();
        List<Object> gateways;
        try {
            gateways = DatabaseService.selectAll("GatewayEntity","idgateway","=",Integer.valueOf(idgateway),"");
            if(gateways.size()>0){
                deviceEntity.setIddevice(Integer.valueOf(iddevice));
                deviceEntity.setGatewayByIdgateway((GatewayEntity) gateways.get(0));
                deviceEntity.setName(name);
                deviceEntity.setInformation("");
                DatabaseService.insertObject(deviceEntity);
                System.out.println("device saved");
               // SocketServerConfig.print("add new device DEVICEID:"+iddevice+":DEVICENAME:"+name);
                SocketServerConfig.print("add new device\n" + deviceEntity +"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/management.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
