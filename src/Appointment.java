import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private Status status;
    private LocalDateTime localDateTime;
    private DayOfWeek day;

    public Appointment(Patient patient, Doctor doctor, Status status, LocalDateTime localDateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.status = status;
        this.localDateTime = localDateTime;
        this.day = localDateTime.getDayOfWeek();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }
}
