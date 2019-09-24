package me.gsix.spoisy.test;

import java.io.Serializable;

public class HolidayModel implements Serializable {
    public Long date;
    public Long monthNumber;
    public Long year;
    public String day;
    public String month;
    public String destination;
    public String name;
    public String religion;
    public boolean selected;

    public HolidayModel() {
    }

    public HolidayModel(Long date, Long monthNumber, Long year, String day, String month, String destination, String name, String religion, boolean selected) {
        this.date = date;
        this.monthNumber = monthNumber;
        this.year = year;
        this.day = day;
        this.month = month;
        this.destination = destination;
        this.name = name;
        this.religion = religion;
        this.selected = selected;
    }

    public Object getDate() {
        return date;
    }

    public Object getMonthNumber() {
        return monthNumber;
    }

    public Object getYear() {
        return year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public String getReligion() {
        return religion;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setMonthNumber(Long monthNumber) {
        this.monthNumber = monthNumber;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
