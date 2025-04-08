
import java.io.IOException;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

         HousePlants plants = new HousePlants();
         try {
             plants.readPlantsFromFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");
             HousePlants.addPlant(new Plant("Lilie Zlatohlavá", LocalDate.of(2021,4,15), LocalDate.of(2021,5,5),"Pěkná", 7));
             plants.writePlantsToFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");

        } catch (PlantException e) {
            System.err.println(e.getMessage("Soubor nenalezen: " + e.getMessage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<HousePlants> plant = plants.getPlant();
        plant.forEach(System.out::println);

    }

}