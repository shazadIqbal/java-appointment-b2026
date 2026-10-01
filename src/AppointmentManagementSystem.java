import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

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
                initSlots(50));


        Doctor doctor2 = new Doctor(2L,"DR-TAHA",
                Specialzation.GENERAL,
                2500.0,
                initSlots(100));


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
        int dayOfMonth = random.nextInt(28) + 1;
        int hour = random.nextInt(12) + 9;
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

    public Optional<Patient> findPatientByMrNumber(String mrNumber) {

        for(Patient patient : patientList){
            if(mrNumber.equalsIgnoreCase(patient.getMrNumber())){
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }

    public Optional<Doctor> findDoctorByName(String name) {

        for(Doctor doctor : doctorList){
            if(name.equalsIgnoreCase(doctor.getName())){
                return Optional.of(doctor);
            }
        }

        return Optional.empty();
    }

    public Map<String,Set<Slot>> findDoctorByDate(LocalDate localDate) {
       Map<String,Set<Slot>> map = new HashMap<>();

        for(Doctor doctor : doctorList){
            map.put(doctor.getName(),new HashSet<>());
        }

        // DR-TAHA - > [] avaialble slots
        // DR-ASIM ->  []
        // DR-S -> []
        // DR-A -> []


       for(Doctor doctor : doctorList){

           for(Slot slot : doctor.getSlots()){
               // slots dates is always after the given date
               if(slot.getDate().isAfter(localDate)){
                  Set<Slot> slotSet = map.get(doctor.getName());
                  slotSet.add(slot);
               }
           }
       }

        return map;
    }

    public Patient getPatientByInput(Scanner sc) {

        Random random = new Random();
        String mrNumber;
        Long id;

        while(true){
            id = (long) random.nextInt(1000);
            mrNumber = "M" + id;
            Optional<Patient> patient = findPatientByMrNumber(mrNumber);
            if(patient.isEmpty()){
                break;
            }
        }

        System.out.println("Please enter name :");
        String name = sc.next();

        System.out.println("Please enter the age");
        Integer age = sc.nextInt();
        System.out.println("Please enter gender");
        Gender gender = sc.next().equalsIgnoreCase("MALE") ? Gender.MALE : Gender.FEMALE;
        System.out.println("Please enter the phone number");
        String phone = sc.next();

        Patient patient = new Patient(id,name,mrNumber,age,gender,phone,null);

        return patient;

    }

    public void addNewPatient(Patient newPatient) {
        patientList.add(newPatient);
        System.out.println("Added succesfully with MrNumber"+ newPatient.getMrNumber());
    }

    public Map<String, Set<Slot>> findDoctorAvailbleSlotsBySpec(String specialzation) {


        Map<String,Set<Slot>> map = new HashMap<>();

        List<Doctor> doctors = doctorList.stream()
                .filter(d-> d.getSpecialzation().toString()
                        .equalsIgnoreCase(specialzation))
                .collect(Collectors.toList());

        LocalDate today = LocalDate.now();

        for(Doctor doctor : doctors){
            for(Slot slot : doctor.getSlots()){
                if(slot.getDate().isAfter(today)){
                    if(map.containsKey(doctor.getName())){
                        Set<Slot> slotSet = map.get(doctor.getName());
                        slotSet.add(slot);
                    }else{

                        map.put(doctor.getName(), new HashSet<>());
                        map.get(doctor.getName()).add(slot);
                    }
                }
            }
        }
        return map;
    }

    public boolean validateSpecialization(String input) {
        for(Specialzation specialzation : Specialzation.values()){
            if(input.equalsIgnoreCase(specialzation.toString())){
                return true;
            }
        }


        return false;
    }
}
