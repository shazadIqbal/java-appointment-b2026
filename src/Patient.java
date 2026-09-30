import java.util.List;

public class Patient {

    private Long id;
    private String name;
    private String mrNumber;
    private Integer age;
    private Gender gender;
    private String phone;
    private PatientHistory patientHistory;

    public Patient(Long id, String name, String mrNumber, Integer age, Gender gender, String phone, PatientHistory patientHistory) {
        this.id = id;
        this.name = name;
        this.mrNumber = mrNumber;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.patientHistory = patientHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMrNumber() {
        return mrNumber;
    }

    public void setMrNumber(String mrNumber) {
        this.mrNumber = mrNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PatientHistory getPatientHistoryList() {
        return patientHistory;
    }

    public void setPatientHistoryList(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mrNumber='" + mrNumber + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", patientHistory=" + patientHistory +
                '}';
    }
}
