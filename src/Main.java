import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

       AppointmentManagementSystem ams = new AppointmentManagementSystem();
       System.out.println(ams.getPatientList());

       ams.getDoctorList().forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println(" press 1 for find Patient By MrNumber");
            System.out.println(" press 2 for find Doctor By Name");
            System.out.println(" press 3 for find Doctor By Slot");
            System.out.println(" press 4 add new patient");
            System.out.println(" Press 5 find Doctor Available Slots by Specilazation");
            System.out.println(" press 6 exit");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.println("Please Enter MR Number");
                    String mrNumber = sc.next();
                    Optional<Patient> patient = ams.findPatientByMrNumber(mrNumber);
                    System.out.println(patient.isPresent() ? patient.get() : ErrorUtil.NO_PATIENT_FOUND);
                    break;

                case 2:
                    System.out.println("Please Enter Doctor Name");
                    String name = sc.next();
                    Optional<Doctor> doctor = ams.findDoctorByName(name);
                    System.out.println(doctor.isPresent() ? doctor.get() : ErrorUtil.NO_PATIENT_FOUND);
                    break;

                case 3:
                    System.out.println("Please Enter Date time DD/MM/YYY");
                    String date = sc.next();
                   // "10/10/2026"
                    LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Map<String, Set<Slot>> doctorList = ams.findDoctorByDate(localDate);
                    doctorList.forEach((k,v)->{
                        System.out.println(k);
                        v.forEach(System.out::println);
                    });

                    break;

                case 4:
                    Patient newPatient = ams.getPatientByInput(sc);
                    ams.addNewPatient(newPatient);
                    break;
                case 5:
                    System.out.println("Enter the specilization");
                    String input = sc.next();
                    if(ams.validateSpecialization(input)){
                        Map<String,Set<Slot>> map = ams.findDoctorAvailbleSlotsBySpec(input);
                        map.forEach((k,v)->{
                            System.out.println(k);
                            v.forEach(System.out::println);
                        });

                    }else{
                        System.out.println("Specialzation not valid");
                    }
                    break;



                    case 6:
                    run = false;


            }



        }


    }


}