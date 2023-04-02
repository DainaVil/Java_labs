package com.example.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity(name="schedule")
@Table
public class Schedule {
    @Id
    @Column(name="row_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="test_id")
    private Long testID;

    @Column(name="group_id")
    private Long groupID;

    @Column(name="duration")
    private Long duration;

    @Column(name="start_dt")
    private Date startDT;

    @Column(name="start_time")
    private Time startTime;

    @Column(name="end_dt")
    private Date endDT;

    @Column(name="end_time")
    private Time endTime;

    @Column(name="active")
    private Boolean active;

    public Schedule() {
    }

    public Schedule(Long id, Long testID, Long groupID, Long duration, Date startDT, Time startTime, Date endDT, Time endTime, Boolean active) {
        this.id = id;
        this.testID = testID;
        this.groupID = groupID;
        this.duration = duration;
        this.startDT = startDT;
        this.startTime = startTime;
        this.endDT = endDT;
        this.endTime = endTime;
        this.active = active;
    }

    public Long getRowID() {
        return id;
    }

    public void setRowID(Long rowID) {
        this.id = rowID;
    }

    public Long getTestID() {
        return testID;
    }

    public void setTestID(Long testID) {
        this.testID = testID;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Date getStartDT() {
        return startDT;
    }

    public void setStartDT(Date startDT) {
        this.startDT = startDT;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getEndDT() {
        return endDT;
    }

    public void setEndDT(Date endDT) {
        this.endDT = endDT;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
