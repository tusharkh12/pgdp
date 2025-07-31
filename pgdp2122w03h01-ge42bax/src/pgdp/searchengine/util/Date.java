package pgdp.searchengine.util;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }



    public boolean equals(Date date) {
        if (this.day == (date.day) && this.month == (date.month) && this.year == (date.year)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return day + "/" +
                month + "/" +
                year;
    }

}