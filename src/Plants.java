

import java.io.File;
import java.io.FileNotFoundException;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plants {

    List<HousePlants> plants = new ArrayList<>();

public void addPlant(HousePlants plant) {
    plants.add(plant);
}

    /*Plants plants = new plant();
    listOfPlants.add(plant);
    listOfPlants.add(new plant("Lilie Zlatohlavá"));

    List<Plants> copyOfList = new ArrayList<Plants>(listOfPlants);*/


    public List<HousePlants> getPlants() {
        return new ArrayList<>(plants);
    }

    public void setPlants(List<HousePlants> plants) {
        this.plants = plants;
    }


    public void readPlantsFromFile(String filename, String delimiter) throws PlantException {

        plants.clear();
        int lineNumber = 0;
        try {
            File fileName = new File("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt");
            Scanner scanner = new Scanner(fileName);

            while (scanner.hasNextLine()) {
                lineNumber++;
                String oneLine = scanner.nextLine();
                System.out.println(oneLine);
                String[] parts = oneLine.split(delimiter);
                System.out.println(parts.length);
                HousePlants newHousePlant = parsePlant(parts);
                plants.add(newHousePlant);


            }


        //} catch (FileNotFoundException e) {
            //throw new RuntimeException(e);

        } catch (FileNotFoundException e) {

            throw new PlantException("Nepodařilo se najít soubor " + filename + ": " + e.getLocalizedMessage());


        } catch (NumberFormatException e) {
            throw new PlantException("Špatně zadaná frekvence zálivky " + filename + "na řádku" + lineNumber + ": " + e.getLocalizedMessage());

        } catch (DateTimeParseException e) {
            throw new PlantException("Špatně zadané datum zálivky,nebo zasazení " + filename + "na řádku" + lineNumber + ": " + e.getLocalizedMessage());


        }

    }

    private HousePlants parsePlant(String[] parts) {
        String name = parts[0].trim();
        String notes = parts[1].trim();
        int run = Integer.parseInt(parts[2]);
        LocalDate watering = LocalDate.parse(parts[3].trim());
        LocalDate planted = LocalDate.parse(parts[4].trim());
        return new HousePlants(name, notes, planted, watering, run);

    }

}









