import java.time.LocalDate;
import java.util.Comparator;


public class Plant extends HousePlants {
    private String name;
    private LocalDate planted;
    private LocalDate watering;
    private String notes;
    private int frequencyOfWatering;
    private String wateringInfo;
    private LocalDate nextWatering;







    public Plant(String name, String notes,
                 int  frequencyOfWatering,LocalDate watering ,LocalDate planted) {
        this.name = name;
        this.notes = notes;
        this.frequencyOfWatering = frequencyOfWatering;
        this.watering = watering;
        this.planted = planted;






    }


    public Plant(String notes, LocalDate watering, LocalDate planted) {

        this.notes = null;
        this.watering = LocalDate.now();
        this.planted = LocalDate.now();
    }

    public Plant(LocalDate planted, LocalDate watering, int frequencyOfWatering, String notes) {
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.notes = null;
        this.frequencyOfWatering = 7;
    }

    public static void sort(Comparator<Plant> comparing) {
    }



    public void doWatering(LocalDate watering) {
        this.watering = LocalDate.now();
    }



    public LocalDate getNextWatering() {
        return nextWatering;
    }

    public void setNextWatering(LocalDate nextWatering) {
        this.nextWatering = nextWatering;
    }

    public  String getName() {
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

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Override
    public String toString() {
        return "Plant" +
                "name = '" + name + '\'' +
                ", notes = '" + notes + '\'' +
                " frequencyOfWatering = " + frequencyOfWatering +
                ", watering = " + watering +
                ", planted = " + planted
                ;
    }
}


