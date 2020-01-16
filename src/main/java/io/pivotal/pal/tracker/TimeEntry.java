package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {


    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(){

    }
    public TimeEntry( long projid, long userid ,LocalDate date, int hours){

        //this.id =id;
        this.projectId= projid;
        this.userId=userid;
        this.date= date;
        this.hours=hours;

    }
    //TimeEntry(timeEntryId, projectId, userId, LocalDate.parse("2017-01-08"), 8);
    public TimeEntry( long id, long projid, long userid ,LocalDate date, int hours){
        this.id =id;
        this.projectId= projid;
        this.userId=userid;
        this.date= date;
        this.hours=hours;

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            System.out.println(" in equals this == o");
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            System.out.println(" in equals o == null");
            return false;
        }

        System.out.println(" equals always true");

       // return true;
        TimeEntry simpson = (TimeEntry) o;

        System.out.println("in TimeEntry Equala projectId "+projectId +"    simpson.projectId "+simpson.projectId + " userId "+ userId + " simpson.userId "+simpson.userId +" date " +date +" simpson.date "+simpson.date +" hours "+hours + " simpson.hours "+simpson.hours);
        return projectId == simpson.projectId &&
                userId == simpson.userId &&
                //date == simpson.date &&
                hours == simpson.hours &&
                date.equals(simpson.date);
    }
}
