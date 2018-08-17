package beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "device", schema = "smart_parcel_box_server", catalog = "")
public class DeviceEntity {
    private int iddevice;
    private String name;
    private String information;
    private GatewayEntity gatewayByIdgateway;
    private Collection<NotificationEntity> notificationsByIddevice;
    private Collection<ParcelEntity> parcelsByIddevice;
    private Collection<UsersEntity> usersByIddevice;

    @Id
    @Column(name = "iddevice", nullable = false)
    public int getIddevice() {
        return iddevice;
    }

    public void setIddevice(int iddevice) {
        this.iddevice = iddevice;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "information", nullable = true, length = 45)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceEntity that = (DeviceEntity) o;
        return iddevice == that.iddevice &&
                Objects.equals(name, that.name) &&
                Objects.equals(information, that.information);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iddevice, name, information);
    }

    @ManyToOne
    @JoinColumn(name = "idgateway", referencedColumnName = "idgateway")
    public GatewayEntity getGatewayByIdgateway() {
        return gatewayByIdgateway;
    }

    public void setGatewayByIdgateway(GatewayEntity gatewayByIdgateway) {
        this.gatewayByIdgateway = gatewayByIdgateway;
    }

    @OneToMany(mappedBy = "deviceByIddevice")
    public Collection<NotificationEntity> getNotificationsByIddevice() {
        return notificationsByIddevice;
    }

    public void setNotificationsByIddevice(Collection<NotificationEntity> notificationsByIddevice) {
        this.notificationsByIddevice = notificationsByIddevice;
    }

    @OneToMany(mappedBy = "deviceByIddevice")
    public Collection<ParcelEntity> getParcelsByIddevice() {
        return parcelsByIddevice;
    }

    public void setParcelsByIddevice(Collection<ParcelEntity> parcelsByIddevice) {
        this.parcelsByIddevice = parcelsByIddevice;
    }

    @OneToMany(mappedBy = "deviceByIddevice",fetch = FetchType.EAGER)
    public Collection<UsersEntity> getUsersByIddevice() {
        return usersByIddevice;
    }

    public void setUsersByIddevice(Collection<UsersEntity> usersByIddevice) {
        this.usersByIddevice = usersByIddevice;
    }

    public String toString(){
        return String.format("{\"iddevice\":\"%s\",\"name\":\"%s\"}", iddevice , name);
    }
}
