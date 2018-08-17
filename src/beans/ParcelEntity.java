package beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "parcel", schema = "smart_parcel_box_server", catalog = "")
public class ParcelEntity {
    private int idparcel;
    private String barcode;
    private Timestamp recievedate;
    private Timestamp recorddate;
    private DeviceEntity deviceByIddevice;

    @Id
    @Column(name = "idparcel", nullable = false)
    public int getIdparcel() {
        return idparcel;
    }

    public void setIdparcel(int idparcel) {
        this.idparcel = idparcel;
    }

    @Basic
    @Column(name = "barcode", nullable = true, length = 45)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "recievedate", nullable = true)
    public Timestamp getRecievedate() {
        return recievedate;
    }

    public void setRecievedate(Timestamp recievedate) {
        this.recievedate = recievedate;
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
        ParcelEntity that = (ParcelEntity) o;
        return idparcel == that.idparcel &&
                Objects.equals(barcode, that.barcode) &&
                Objects.equals(recievedate, that.recievedate) &&
                Objects.equals(recorddate, that.recorddate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idparcel, barcode, recievedate, recorddate);
    }

    @ManyToOne
    @JoinColumn(name = "iddevice", referencedColumnName = "iddevice")
    public DeviceEntity getDeviceByIddevice() {
        return deviceByIddevice;
    }

    public void setDeviceByIddevice(DeviceEntity deviceByIddevice) {
        this.deviceByIddevice = deviceByIddevice;
    }

    public String toString(){
        return String.format("{\"idparcel\":\"%s\",\"iddevice\":\"%s\",\"barcode\":\"%s\"}", idparcel,deviceByIddevice.getIddevice() , barcode);
    }
}
