public class Date {

    int month;
    int day;
    int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int month() {

        return this.month;
    }

    public int day() {

        return this.day;
    }

    public int year() {

        return this.year;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public boolean before(Date other) {
        if (year == other.year && month == other.month && day < other.day)
            return true;

        if (year < other.year)
            return true;

        if (year == other.year && month < other.month)
            return true;

        else
            return false;
    }

    public boolean isLeapYear() {

        return year % 4 == 0;

    }

    public int daysInMonth(int month) {

        if(month == 2) {
            if (isLeapYear())
                return 29;
            else
                return 28;
        }

        if(month % 2 != 0 && month <= 7) {
            return 31;
        }

        else if(month >= 8 && month % 2 == 0) {
            return 31;
        }

        else
            return 30;
    }

    public int daysSinceBeginYear() {
        int countDays = 0;
        for(int i = 1; i < month; i++) {
            countDays += daysInMonth(i);
        }
        return countDays + day;
    }

    public int daysUntilEndYear() {
        int total = 365;
        if(isLeapYear()) {
            total ++;
        }
        return total - daysSinceBeginYear();


    }

    public int daysBetween(Date other) {
        if (before(other))

        else
            return (365 * year + 31 * month + day - 365 * other.year + 31 * other.month + other.day) * -1;
    }


    public static void main(String[] args) {
        Date c = new Date(8, 10, 2024);
        int test =  c.daysUntilEndYear();
        System.out.println(test);
    }

}

