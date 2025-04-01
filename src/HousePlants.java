

import java.io.*;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HousePlants {

    static List<HousePlants> plants = new ArrayList<>();




    /*List<Plant> plants = new ArrayList<>();

   

    public List<Plant> getPlants() {
        return new ArrayList<>(plants);
    }


    Plants plants = new plant();
    listOfPlants.add(plant);
    listOfPlants.add(new plant("Lilie Zlatohlavá"));

    List<Plants> copyOfList = new ArrayList<Plants>(listOfPlants);


    public List<HousePlants> getHousePlants() {
        return new ArrayList<>(HousePlants);
    }
    }

    public void setHousePlants(List<HousePlants> plants) {
        this.HousePlants = plants;
    }*/


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
                Plant newPlant = parseHousePlants(parts);
                plants.add(newPlant);


            }
            scanner.close();

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

    private Plant parseHousePlants(String[] parts) {
        String name = parts[0].trim();
        String notes = parts[1].trim();
        int run = Integer.parseInt(parts[2]);
        LocalDate watering = LocalDate.parse(parts[3].trim());
        LocalDate planted = LocalDate.parse(parts[4].trim());
        return new Plant(name, notes, planted, watering, run);

    }

    public void writeHousePlantsToFile(String filename, String delimiter) throws PlantException, IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (HousePlants plant : plants) {
                exportHousePlants((Plant) plant, writer, delimiter);
            }
        } catch (IOException e) {
            throw new PlantException("Chyba při zápisu do souboru" + filename + ": " + e.getLocalizedMessage());
        }
    }

    private void exportHousePlants(Plant plant, PrintWriter writer, String delimiter) {
        writer.print(plant.getName());
        writer.print(delimiter);
        writer.print(plant.getNotes());
        writer.print(delimiter);
        writer.print(plant.getFrequencyOfWatering());
        writer.print(delimiter);
        writer.print(plant.getWatering());
        writer.print(delimiter);
        writer.print(plant.getPlanted());

    }
    public static void addPlant(HousePlants housePlants) {
        plants.add(housePlants);
    }

    public List<HousePlants> getPlant() {
        return plants;

    }
}









