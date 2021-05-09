package kz.iitu.FinProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "contact", nullable = true, columnDefinition = "TEXT")
    private String contact;

    @Column(name = "address", nullable = true, columnDefinition = "TEXT")
    private String address;

    @Column(name = "city_id", nullable = false, columnDefinition = "NUMERIC")
    private long cityId;

    @Column(name = "change_date", nullable = false, insertable = false, columnDefinition = "DATE")
    private Date changeDate;

    public Branch() {
        changeDate = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        changeDate = new Date(System.currentTimeMillis());
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
        changeDate = new Date(System.currentTimeMillis());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        changeDate = new Date(System.currentTimeMillis());
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
        changeDate = new Date(System.currentTimeMillis());
    }
}
