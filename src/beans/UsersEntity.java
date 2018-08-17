package beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "smart_parcel_box_server", catalog = "")
public class UsersEntity {
    private String username;
    private String password;
    private String email;
    private DeviceEntity deviceByIddevice;

    @Id
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, email);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "iddevice", referencedColumnName = "iddevice")
    public DeviceEntity getDeviceByIddevice() {
        return deviceByIddevice;
    }

    public void setDeviceByIddevice(DeviceEntity deviceByIddevice) {
        this.deviceByIddevice = deviceByIddevice;
    }
}
