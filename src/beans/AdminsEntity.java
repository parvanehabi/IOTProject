package beans;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins", schema = "smart_parcel_box_server", catalog = "")
public class AdminsEntity {
    private String adminName;
    private String password;

    @Id
    @Column(name = "admin_name", nullable = false, length = 45)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminsEntity that = (AdminsEntity) o;
        return Objects.equals(adminName, that.adminName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(adminName, password);
    }
}
