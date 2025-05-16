import java.time.LocalDate;




public class Plant  extends HousePlants  implements Comparable<Plant> {
    private String name;
    private LocalDate planted;
    private LocalDate watering;
    private String notes;
    private int frequencyOfWatering;
    private LocalDate nextWatering;



    public Plant(String name, String notes,
                 int frequencyOfWatering, LocalDate watering, LocalDate planted) throws PlantException {
          if (watering.isBefore(planted)) {
              throw new PlantException(
                      "Datum poslední zálivky nemůže býtj starší než datum zasazení rostliny " + " (zadal jsi : " + watering + ")");
          }
          if (frequencyOfWatering < 1) {
             throw new PlantException(
                    "Frekvence zálivky nesmí mít zápornou hodnotu nižší než 1" +
                            " (zadal jsi : " + frequencyOfWatering + ")");
          }

        this.name = name;
        this.notes = notes;
        this.frequencyOfWatering = frequencyOfWatering;
        this.watering = watering;
        this.planted = planted;
    }


    public Plant() throws PlantException {
        this("", "",0, LocalDate.now(), LocalDate.now() );

    }

    public Plant(String name) throws PlantException {
        this(name,"",7,LocalDate.now(), LocalDate.now());


    }
    //konstruktor pro vypsani doporucene dalsi zalivky
    public Plant(String name, LocalDate watering, LocalDate nextWatering , String notes)
           {
        this.name = name;
        this.watering = watering;
        this.nextWatering = nextWatering;
        this.notes = notes;
    }

    public Plant getWatering(Plant t) {
        return null;
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
        return "Název: " + name +
                ", Datum poslední zálivky: " + watering +
                ", Doporučené datum další zálivky: " + nextWatering +
                "---" + notes;


    }

    public void doWateringNow() {
        watering = LocalDate.now();
        nextWatering = watering.plusDays(frequencyOfWatering);


    }
    public void get(int index) {

        Plant result = plants.get(index);


    }
    @Override
    public String toString() {
        return " Plant : " +
                " name = '" + name + '\'' +
                ", notes = '" + notes + '\'' +
                ", frequencyOfWatering = " + frequencyOfWatering +
                ", watering = " + watering +
                ", planted = " + planted + "\n"
                ;
    }

    @Override
    public int compareTo(Plant other) {
        return this.name.compareTo(other.name);


    }
    public boolean needsWatering() {
        return LocalDate.now().isAfter(watering.plusDays(frequencyOfWatering));
    }




}



