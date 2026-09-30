import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Slot {
    private LocalDate date;
    private LocalTime time;
    private DayOfWeek day;


    public Slot(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
        this.day = date.getDayOfWeek();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return Objects.equals(date, slot.date) && Objects.equals(time, slot.time) && day == slot.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, time, day);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "date=" + date +
                ", time=" + time +
                ", day=" + day +
                '}';
    }
}
