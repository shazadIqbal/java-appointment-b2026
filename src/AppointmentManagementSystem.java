import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class AppointmentManagementSystem {

    private List<Patient> patientList = new ArrayList<>();
    private List<Doctor> doctorList = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();


    AppointmentManagementSystem(){
        initPatients();
        initDoctors();
    }

    private void initPatients(){
        PatientHistory patientHistory = initPatientHistory();

        Patient patient1 = new Patient(1L,"TAHA",
                "M1001",
                22,
                Gender.MALE,
                "0332208901",
                patientHistory);

        Patient patient2 = new Patient(2L,"ALI",
                "M1022",
                32,
                Gender.MALE,
                "0332208001",
                null);

        Patient patient3 = new Patient(3L,"FATIMA",
                "M1023",
                22,
                Gender.FEMALE,
                "0332208331",
                null);

        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);

    }

    private PatientHistory initPatientHistory() {

        PatientHistory patientHistory = new PatientHistory();

        Map<String,String> map = new HashMap<>();
        map.put("Prescription","med panadol having 103 fever");
        map.put("remarks","take next appointment with ENT");

        patientHistory.setRecordList(List.of(map));
        return patientHistory;
    }

    private void initDoctors(){

        Doctor doctor1 = new Doctor(1L,"DR-ASIM",
                Specialzation.ENT,
                5000.0,
                initSlots(5));


        Doctor doctor2 = new Doctor(2L,"DR-TAHA",
                Specialzation.GENERAL,
                2500.0,
                initSlots(10));


        doctorList.add(doctor1);
        doctorList.add(doctor2);

    }

    private List<Slot> initSlots(int numberOfSlots){
        Set<Slot> slotList = new HashSet<>();

        for (int i = 1; i <= numberOfSlots; i++) {
            slotList.add(getRandomSlot());
        }

        return new ArrayList<>(slotList);

    }

    private Slot getRandomSlot(){
        Random random = new Random();
        int month = random.nextInt(12) + 1;
        int dayOfMonth = random.nextInt(30) +1;
        int hour = random.nextInt(12) + 12;
        int minute = random.nextInt(60);

        LocalDate localDate = LocalDate.of(2026,month,dayOfMonth);
        LocalTime localTime = LocalTime.of(hour,minute);
        Slot slot = new Slot(localDate,localTime);
        return slot;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
