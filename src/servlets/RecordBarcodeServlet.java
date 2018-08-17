package servlets;

import beans.DeviceEntity;
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

@WebServlet(name = "RecordBarcodeServlet" , urlPatterns = "/RecordBarcode")
public class RecordBarcodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String iddevice = request.getParameter("box-number");
        String barcode = request.getParameter("barcode");
        System.out.println(iddevice);
        System.out.println(barcode);
        ParcelEntity parcelEntity = new ParcelEntity();
        List<Object> devices;
        List<Object> parcels;
        try {
            devices = DatabaseService.selectAll("DeviceEntity", "iddevice", "=", Integer.valueOf(iddevice), "");
            if (devices.size() > 0){
                parcels = DatabaseService.selectAll("ParcelEntity", null, "", null, "");
                parcelEntity.setBarcode(barcode);
                parcelEntity.setIdparcel(parcels.size() + 1);
                parcelEntity.setDeviceByIddevice((DeviceEntity) devices.get(0));
                parcelEntity.setRecorddate(new Timestamp(System.currentTimeMillis()));
                parcelEntity.setRecievedate(null);
                DatabaseService.insertObject(parcelEntity);
                System.out.println("barcode saved");
               // SocketServerConfig.print("receive barcode PARCELID:" + (parcels.size() + 1) + ":DEVICEID:" + iddevice + ":BARCODE:" + barcode);
                SocketServerConfig.print("receive barcode\n" + parcelEntity+"\n");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/management.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
