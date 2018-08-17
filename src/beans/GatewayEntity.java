package beans;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "gateway", schema = "smart_parcel_box_server", catalog = "")
public class GatewayEntity {
    private int idgateway;
    private Integer socket;
    private Collection<DeviceEntity> devicesByIdgateway;

    @Id
    @Column(name = "idgateway", nullable = false)
    public int getIdgateway() {
        return idgateway;
    }

    public void setIdgateway(int idgateway) {
        this.idgateway = idgateway;
    }

    @Basic
    @Column(name = "socket", nullable = true)
    public Integer getSocket() {
        return socket;
    }

    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GatewayEntity that = (GatewayEntity) o;
        return idgateway == that.idgateway &&
                Objects.equals(socket, that.socket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idgateway, socket);
    }

    @OneToMany(mappedBy = "gatewayByIdgateway")
    public Collection<DeviceEntity> getDevicesByIdgateway() {
        return devicesByIdgateway;
    }

    public void setDevicesByIdgateway(Collection<DeviceEntity> devicesByIdgateway) {
        this.devicesByIdgateway = devicesByIdgateway;
    }
}
