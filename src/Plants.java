
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plants {

    List<Plants> plants = new ArrayList<>();



    /*Plants plants = new plant();
    listOfPlants.add(plant);
    listOfPlants.add(new plant("Lilie Zlatohlavá"));

    List<Plants> copyOfList = new ArrayList<Plants>(listOfPlants);*/


    public List<Plants> getPlants() {
        return new ArrayList<>(plants);
    }

    public void setPlants(List<Plants> plants) {
        this.plants = plants;
    }

    public void readPlantsFromFile(String filename, String delimiter) throws PlantException {

        plants.clear();
        int lineNumber = 0;
        try  {
            Scanner scanner = new Scanner((new File("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt")));
            while (scanner.hasNextLine()) {
                lineNumber = 0;
                lineNumber++;
                String line = scanner.nextLine();
                System.out.println(line);
                String[] parts = line.split(delimiter);
                if (parts.length != 4) {
                    throw new PlantException("Chybný počet položek na řádku " + lineNumber);
                }
                HousePlants newHousePlant = parsePlant(parts);
                plants.add(newHousePlant);


            }
            scanner.close();

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



