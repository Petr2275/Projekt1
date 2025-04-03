import java.time.LocalDate;



public class Plant extends HousePlants {
    private String name;
    private LocalDate planted;
    private LocalDate watering;
    private String notes;
    private int frequencyOfWatering;
    private String wateringInfo;
    private LocalDate nextWatering;




    /*public Plant(String name, String notes,
                 LocalDate planted, LocalDate watering,
                 int frequencyOfWatering) {
        super();

    }*/


    public Plant(String name, LocalDate planted,
                 LocalDate watering, String notes,int  frequencyOfWatering) {
        this.name = name;
        this.planted = planted;
        this.watering = watering;
        this.notes = notes;
        this.frequencyOfWatering = frequencyOfWatering;



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



    public void doWatering(LocalDate watering) {
        this.watering = LocalDate.now();
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
        return "Plant{" +
                "frequencyOfWatering=" + frequencyOfWatering +
                ", notes='" + notes + '\'' +
                ", watering=" + watering +
                ", planted=" + planted +
                ", name='" + name + '\'' +
                '}';
    }
}


