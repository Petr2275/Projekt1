import java.time.LocalDate;
import java.util.ArrayList;


public class HousePlants extends Plants {
    private String name;
    private LocalDate planted;
    private LocalDate watering;
    private ArrayList<String> notes;
    private Runnable run;
    private String wateringInfo;
    private LocalDate nextWatering;



    public HousePlants(String plantName, String notes,
                       LocalDate planted, LocalDate watering,
                       int run) {
        super();
    }
    public HousePlants(String name, ArrayList<String> notes,
                       LocalDate planted, LocalDate watering ) {
        this.name = name;
        this.planted = planted;
        this.watering = watering;
        this.notes = notes;



    }

    public HousePlants(String notes, LocalDate watering, LocalDate planted) {
        this.notes = null;
        this.watering = LocalDate.now();
        this.planted = LocalDate.now();
    }

    public HousePlants(LocalDate planted, LocalDate watering, Runnable run, String notes) {
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.notes = null;
        this.run = run;
    }

    public String getWateringInfo() {
        return wateringInfo;
    }

    public void setWateringInfo(String wateringInfo, String name,
                                LocalDate watering, LocalDate nextWatering) {
        this.wateringInfo = wateringInfo;
        this.name = name;
        this.watering = watering;
        this.nextWatering = nextWatering;
    }

    public LocalDate getNextWatering() {
        return nextWatering;
    }

    public void setNextWatering(LocalDate nextWatering) {
        this.nextWatering = nextWatering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }


    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public Runnable getRun() {
        return run;
    }

    public void setRun(Runnable run) {
        this.run = run;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "HousePlants{" +
                "name='" + name + '\t' +
                ", planted=" + planted +
                ", watering=" + watering +
                ", notes=" + notes +
                ", run=" + run +
                '}';
    }
}


