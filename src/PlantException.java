import java.time.LocalDate;

public class PlantException  extends Exception {
    public PlantException(String message) {
        super(message);
    }

    public boolean getMessage(String s) {
        return false;
    }


    public static class Request {
        // ... další atributy
        long period;
        LocalDate watering;
        int frequencyOfWatering;
        LocalDate planted;

        public Request(long period, LocalDate watering, LocalDate planted) {
            this.period = period;
            this.watering = watering;
            this.planted = planted;

        }

        public LocalDate getWatering() {
            return watering;
        }

        public void setWatering(LocalDate watering) {
            this.watering = watering;
        }

        public long getPeriod() {
            return period;
        }

        public void setPeriod(long period) {
            this.period = period;
        }

        public LocalDate getPlanted() {
            return planted;
        }

        public void setPlanted(LocalDate planted) {
            this.planted = planted;
        }

        public void setFrequencyOfWatering(long period)
                throws PlantException {
            if (period < 1) {
                throw new PlantException(
                        "Frekvence zálivky nesmí mít zápornou hodnotu nižší než 1" +
                                " (zadal jsi : " + period + ")");
            }

            // Další kód se provede jen pokud je vše v pořádku:

        }

        public long getFrequencyOfWatering() {
            return frequencyOfWatering;
        }

        public void validateDate(LocalDate watering) throws PlantException{


            if (watering.isBefore(planted)) {
                throw new PlantException("Datum je starší než datum zasazení rostliny.");
            }
        }



    }

}


