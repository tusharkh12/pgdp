package pgdp.searchengine.util;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Date other) {
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }
}
