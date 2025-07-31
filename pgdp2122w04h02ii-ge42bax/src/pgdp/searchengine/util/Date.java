package pgdp.searchengine.util;

public class Date {
    private final int day;
    private final int month;
    private final int year;


    // Attribute ...

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



    // Getter ...

    public int yearsUntil(Date other) {
        if (!isValidDate(other.getDay(), other.getMonth(), other.getYear()))
            return 0;
        if (other.year > this.year) {
            if (other.daysPassedThisYear() >= this.daysPassedThisYear())
                return other.year - this.year;
            else return other.year - this.year - 1;
        }
        else if (other.year==this.year)
            return 0;
        else{
            if (other.daysPassedThisYear()>= this.daysPassedThisYear())
                return this.year- other.year;
            else return this.year - other.year-1;
        }

    }

    public int daysUntil(Date other) {
        int total =0;
        if(other.year>this.year){
            total =other.daysPassedThisYear()+this.daysLeftThisYear();
            for(int i=this.year+1; i<other.year;i++){
                total=total + daysInYear(i);
            }
            return total;
        }
        else if (other.year==this.year) {
            if (other.daysPassedThisYear() > this.daysLeftThisYear())
                return other.daysPassedThisYear() - this.daysPassedThisYear();
        }
            else if (other.year==this.year){
            if (other.daysPassedThisYear() > this.daysLeftThisYear())
                return other.daysPassedThisYear() - this.daysPassedThisYear();
            else if (other.daysPassedThisYear()==this.daysPassedThisYear())
                return 0;
            else return other.daysPassedThisYear()-this.daysPassedThisYear();


        }
            else{
                total=other.daysLeftThisYear()+this.daysLeftThisYear();
                for(int i=other.year+1; i<this.year;i++)
                    total=total+daysInYear(i);
        }

        return total +(-1);
    }

    public boolean equals(Date other) {
        return false;
    }

    public String toString() {
        return "";
    }

    public static Date today() {
        return null;
    }

    // <|================ HILFSMETHODEN ================|>

    public static Date dateMillisecondsAfterNewYear1970(long millis) {
        return null;
    }

    public int daysLeftThisYear() {
        int days=daysInMonth(this.month,this.year);
        int total=days-this.day;
        for(int i=this.month+1;i<13;i++){
            days=daysInMonth(i, this.year);
            total=total+days;
        }
        return total;
    }

    public int daysPassedThisYear() {
        int total=this.day;
        int  days=0;
        for (int i=1;i<this.month;i++){
            days=daysInMonth(i,this.year);
            total=total+days;
        }

        return total;
    }

    public static boolean isLeapYear(int year) {
        if (year%4==0 && year %100 !=0 && year%400==0){
            return true;
        }
        return false;
    }

    public static int daysInMonth(int month, int year) {

         if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 ||month==12){
            return 31;
        }
       else if (month==4 || month==6||month==9||month==11){
            return 30;
        }
       else if (month==2 && isLeapYear(year)){
           return 29;
         }
         else if (month==2 ) {
             return 28;
         }
        else return -1;
    }

    public static int daysInYear(int year) {
        if (isLeapYear(year)){
            return 366;
        }
        else if (!isLeapYear(year)){
            return 365;//xchange
        }
        return 1;
    }

    public static boolean isValidDate(int day, int month, int year) {
        int days = daysInMonth(month, year);
        if (month < 0 || month > 12 || year < 0 || day <= 0 || day > days) {


            return false;
        }
        return true;
    }
}
