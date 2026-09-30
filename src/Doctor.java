import java.util.List;

public class Doctor {
    private Long id;
    private String name;
    private Specialzation specialzation;
    private Double fees;
    private List<Slot> slots;

    public Doctor(Long id, String name, Specialzation specialzation, Double fees, List<Slot> slots) {
        this.id = id;
        this.name = name;
        this.specialzation = specialzation;
        this.fees = fees;
        this.slots = slots;
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

    public Specialzation getSpecialzation() {
        return specialzation;
    }

    public void setSpecialzation(Specialzation specialzation) {
        this.specialzation = specialzation;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialzation=" + specialzation +
                ", fees=" + fees +
                ", slots=" + slots +
                '}';
    }
}
