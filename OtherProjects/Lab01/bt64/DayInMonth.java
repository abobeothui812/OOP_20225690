package bt64;
import java.util.Arrays;
import java.util.Scanner;
public class DayInMonth {
    public static void main(String[] args) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        String[] Abbreviation = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.",
                "Nov.", "Dec."};
        String[] in3leters = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
                "Nov", "Dec"};
        String[] inNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isLeapYear = false;
            while(true){
                System.out.println("Enter the year: ");
                int year = scanner.nextInt();
                if(year%4==0 && year%100!=0 || year%400==0){
                    isLeapYear = true;
                }
                System.out.println("Enter the month: ");
                String month = scanner.next();
                
                if (Arrays.asList(monthNames).contains(month)) {
                    int monthIndex = Arrays.asList(monthNames).indexOf(month);
                    int days = daysInMonth[monthIndex];
                    if (isLeapYear && month.equals("February")) {
                        days = 29;
                    }
                    System.out.println(month + " " + year + " has " + days + " days.");
                    break;
                } else if (Arrays.asList(Abbreviation).contains(month)) {
                    int monthIndex = Arrays.asList(Abbreviation).indexOf(month);
                    int days = daysInMonth[monthIndex];
                    if (isLeapYear && month.equals("Feb.")) {
                        days = 29;
                    }
                    System.out.println(month + " " + year + " has " + days + " days.");
                    break;
                } else if (Arrays.asList(in3leters).contains(month)) {
                    int monthIndex = Arrays.asList(in3leters).indexOf(month);
                    int days = daysInMonth[monthIndex];
                    if (isLeapYear && month.equals("Feb")) {
                        days = 29;
                    }
                    System.out.println(month + " " + year + " has " + days + " days.");
                    break;
                } else if (Arrays.asList(inNumbers).contains(month)) {
                    int monthIndex = Arrays.asList(inNumbers).indexOf(month);
                    int days = daysInMonth[monthIndex];
                    if (isLeapYear && month.equals("2")) {
                        days = 29;
                    }
                    System.out.println(month + "/" + year + " has " + days + " days.");
                    break;
                } else {
                    System.out.println("Invalid month, please try again.");
                }
                
            }
        }
        
    }
}
