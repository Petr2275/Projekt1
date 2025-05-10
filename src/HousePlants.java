

import java.io.*;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;




public class HousePlants {

    List<Plant> plants = new ArrayList<>();



    public List<Plant> getPlant() {
        return new ArrayList<>(plants);

    }


    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void remove(int index) {
        plants.remove(index);

    }

    public void replacePlant(List<Plant> newPlants) {
        plants = new ArrayList<>(newPlants);
    }


    public void readPlantsFromFile(String filename, String delimiter) throws PlantException {

        plants.clear();
        int lineNumber = 0;
        try {
            Scanner scanner = new Scanner(
                    new BufferedReader(new FileReader("PlantsList\\kvetiny.txt")));


            while (scanner.hasNextLine()) {


                lineNumber++;
                String oneLine = scanner.nextLine();
                System.out.println(oneLine);
                String[] parts = oneLine.split(delimiter);
                Plant newPlant = parsePlants(parts);
                plants.add(newPlant);

            }

        } catch (IOException e) {
            throw new PlantException("Chyba při čtení souboru: " + filename + "na řádku" + lineNumber + ": " + e.getLocalizedMessage());


        } catch (NumberFormatException e) {
            throw new PlantException("Špatně zadaná frekvence zálivky " + filename + "na řádku" + lineNumber + ": " + e.getLocalizedMessage());

        } catch (DateTimeParseException e) {
            throw new PlantException("Špatně zadané datum zálivky,nebo zasazení " + filename + "na řádku" + lineNumber + ": " + e.getLocalizedMessage());

        }

    }


    public static Plant parsePlants(String[] parts) throws PlantException {
        String name = parts[0].trim();
        String notes = parts[1].trim();
        int frequencyOfWatering = Integer.parseInt(parts[2].trim());
        LocalDate watering = LocalDate.parse(parts[3].trim());
        LocalDate planted = LocalDate.parse(parts[4].trim());
        return new Plant(name, notes, frequencyOfWatering, watering, planted);


    }

    public void writePlantsToFile(String filename, String delimiter) throws PlantException {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Plant plant : plants) exportPlants(plant, writer, delimiter);

        } catch (IOException e) {
            throw new PlantException("Chyba při zápisu do souboru" + filename + ": " + e.getLocalizedMessage());
        }
    }


    public void exportPlants(Plant plant, PrintWriter writer, String delimiter) {
        String output = plant.getName() + delimiter
                + plant.getNotes() + delimiter
                + plant.getFrequencyOfWatering() + delimiter
                + plant.getWatering() + delimiter
                + plant.getPlanted();
        writer.println(output);


    }


    public List<Plant> getPourNow(List<Plant> plants) {
        List<Plant> pourNow = new ArrayList<>();
        LocalDate toDay = LocalDate.now();

        for (Plant plant : plants) {
            LocalDate nextPour = plant.getWatering().plusDays(plant.getFrequencyOfWatering());
            if (toDay.isAfter(nextPour) || toDay.isEqual(nextPour)) {
                pourNow.add((Plant) plant);
            }
        }

        return pourNow;
    }


    public void get(int index) {
        if (index >= plants.size()) {
            throw new IndexOutOfBoundsException();


        }



    }



}









