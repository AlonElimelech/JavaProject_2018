package com.jct.oshri.project_01.model.entities;

public class ride {

    public optionOfTrip status;
    public String source;
    public String dest;
    public String startTime;
    public String finishTime;
    public String nameOfClient;
    public String phoneNumberOfClient;
    public String emailOfClient;

    public ride(optionOfTrip oft, String source, String dest, String startTime, String finishTime, String nameOfClient, String phoneNumberOfClient, String emailOfClient) {
        this.status = oft;
        this.source = source;
        this.dest = dest;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.nameOfClient = nameOfClient;
        this.phoneNumberOfClient = phoneNumberOfClient;
        this.emailOfClient = emailOfClient;
    }

    public ride() {

    }

    public optionOfTrip getStatus() {
        return status;
    }

    public void setStatus(optionOfTrip stat) {
        this.status = stat;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public String getPhoneNumberOfClient() {
        return phoneNumberOfClient;
    }

    public void setPhoneNumberOfClient(String phoneNumberOfClient) {
        this.phoneNumberOfClient = phoneNumberOfClient;
    }

    public String getEmailOfClient() {
        return emailOfClient;
    }

    public void setEmailOfClient(String emailOfClient) {
        this.emailOfClient = emailOfClient;
    }
}
