package beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "notification", schema = "smart_parcel_box_server", catalog = "")
public class NotificationEntity {
    private int idnotification;
    private String notificationText;
    private Timestamp recorddate;
    private DeviceEntity deviceByIddevice;

    @Id
    @Column(name = "idnotification", nullable = false)
    public int getIdnotification() {
        return idnotification;
    }

    public void setIdnotification(int idnotification) {
        this.idnotification = idnotification;
    }

    @Basic
    @Column(name = "notification_text", nullable = true, length = 45)
    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    @Basic
    @Column(name = "recorddate", nullable = true)
    public Timestamp getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Timestamp recorddate) {
        this.recorddate = recorddate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return idnotification == that.idnotification &&
                Objects.equals(notificationText, that.notificationText) &&
                Objects.equals(recorddate, that.recorddate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idnotification, notificationText, recorddate);
    }

    @ManyToOne
    @JoinColumn(name = "iddevice", referencedColumnName = "iddevice")
    public DeviceEntity getDeviceByIddevice() {
        return deviceByIddevice;
    }

    public void setDeviceByIddevice(DeviceEntity deviceByIddevice) {
        this.deviceByIddevice = deviceByIddevice;
    }
}
