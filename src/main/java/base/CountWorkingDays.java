package base;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CountWorkingDays {

    public long calculateApplicationPrice(LocalDate startDate, LocalDate endDate) {
        long workingDays = 0;
        LocalDate date = startDate;

        while (!date.isAfter(endDate)) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays++;
            }
            date = date.plusDays(1);
        }   
        return workingDays;
    }

    public static void main(String[] args) {
        CountWorkingDays counter = new CountWorkingDays(); // Create an instance of the class
        LocalDate startDate = LocalDate.of(2024, 5, 1);
        LocalDate endDate = LocalDate.of(2024, 5, 14);
        long workingDays = counter.calculateApplicationPrice(startDate, endDate); // Call the method on the instance
        System.out.println("Working days: " + workingDays);
    }
}
