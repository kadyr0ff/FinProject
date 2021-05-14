package kz.iitu.FinProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "description")
    private String description;
    @Column(name = "assignee_id")
    private long assigneeId;
    @Column(name = "origin_branch_id")
    private long originBranchId;
    @Column(name = "destination_branch_id")
    private long destinationBranchId;
    @Column(name = "origin_city_id")
    private long originCityId;
    @Column(name = "destination_city_id")
    private long destinationCityId;
    @Column(name = "change_date")
    private Date changeDate;

    public Task() {
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setDescription(String description) {
        this.description = description;
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setAssigneeId(long assigneeId) {
        this.assigneeId = assigneeId;
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setOriginBranchId(long originBranchId) {
        this.originBranchId = originBranchId;
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setDestinationBranchId(long destinationBranchId) {
        this.destinationBranchId = destinationBranchId;
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setOriginCityId(long originCityId) {
        this.originCityId = originCityId;
        changeDate = new Date(System.currentTimeMillis());
    }

    public void setDestinationCityId(long destinationCityId) {
        this.destinationCityId = destinationCityId;
        changeDate = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getAssigneeId() {
        return assigneeId;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOriginBranchId() {
        return originBranchId;
    }

    public long getDestinationBranchId() {
        return destinationBranchId;
    }

    public long getOriginCityId() {
        return originCityId;
    }

    public long getDestinationCityId() {
        return destinationCityId;
    }

    public Date getChangeDate() {
        return changeDate;
    }
}
