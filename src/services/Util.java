package services;

import beans.DeviceEntity;
import beans.NotificationEntity;
import beans.ParcelEntity;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static ArrayList<NewsPair> getNews(){
        ArrayList<NewsPair> list = new ArrayList<>();
        List<Object> notifs = null ,parcels = null;
        try {
            DeviceEntity d = new DeviceEntity();

            notifs = DatabaseService.selectAll("NotificationEntity",null,"",null,"");
            parcels = DatabaseService.selectAll("ParcelEntity",null,"",null,"");
        } catch (Exception e) {
            System.out.println("DB Connection Error! Utils!");
            e.printStackTrace();
        }
        for (Object o: parcels){
            list.add(new NewsPair(((ParcelEntity)o).getRecorddate(),"بارکد جدید در تاریخ "+((ParcelEntity)o).getRecorddate()+" ثبت شد. "));
            if(((ParcelEntity)o).getRecievedate()!=null)
                list.add(new NewsPair(((ParcelEntity)o).getRecievedate(),"بسته جدید در تاریخ "+((ParcelEntity)o).getRecievedate()+" دریافت شد. "));

        }

        for (Object o: notifs){
            if(((NotificationEntity)o).getNotificationText().equals("door opened"))
                list.add(new NewsPair(((NotificationEntity)o).getRecorddate(),"درب جعبه هوشمند در تاریخ "+((NotificationEntity)o).getRecorddate()+" برای شما باز شد. "));
            else if(((NotificationEntity)o).getNotificationText().equals("robbery"))
                list.add(new NewsPair(((NotificationEntity)o).getRecorddate(),"احتمال دزدی محتویات داخل جعبه هوشمند در تاریخ "+((NotificationEntity)o).getRecorddate()+" ثبت شد. لطفا در اسرع وقت بررسی فرمایید."));

        }

        list.sort((e1, e2) -> e1.compareTo(e2));
        return  list;
    }
}
