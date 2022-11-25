package com.example.demo2.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventModel {
    @Id
    private int eventId;
    private String venueName;
    private String eventName;
    private String applicantName;
    private String applicantMobile;
    private String applicantEmail;
    private String eventAddress;
    private Date eventDate;
    private Time eventTime;

    public int getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(int teamMembers) {
        this.teamMembers = teamMembers;
    }

    private int teamMembers;

    public EventModel() {
    }

    public EventModel(String venueName, String eventName, String applicantName, String applicantMobile,
            String applicantEmail, String eventAddress, Date eventDate, Time eventTime, int teamMembers) {
        this.venueName = venueName;
        this.eventName = eventName;
        this.applicantName = applicantName;
        this.applicantMobile = applicantMobile;
        this.applicantEmail = applicantEmail;
        this.eventAddress = eventAddress;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "EventModel [eventId=" + eventId + ", venueName=" + venueName + ", eventName=" + eventName
                + ", applicantName=" + applicantName + ", applicantMobile=" + applicantMobile + ", applicantEmail="
                + applicantEmail + ", eventAddress=" + eventAddress + ", eventDate=" + eventDate + ", eventTime="
                + eventTime + "teamMembers=" + teamMembers + "]";
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }
}
