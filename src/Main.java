import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

         HousePlants housePlants = new HousePlants();
        ArrayList<String> notes = new ArrayList<String>();
        notes.add("pekna");

        try {
            housePlants.readPlantsFromFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");
            HousePlants.addPlant(new Plant("Lilie", LocalDate.of(2021, 04,15), LocalDate.of(2021, 05, 12), notes, 5));
            housePlants.writeHousePlantsToFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");

        } catch (PlantException e) {
            System.err.println(e.getMessage("Soubor nenalezen: " + e.getMessage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<HousePlants> plants = housePlants.getPlant();
        plants.forEach(System.out::println);

    }

}