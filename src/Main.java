import java.io.IOException;


import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        HousePlants plants = new HousePlants();
        List<Plant> plant = plants.getPlant();





        try {

            plants.readPlantsFromFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\novySeznam.txt", "\t");
            /*plants.addPlant(new Plant("Lilie Zlatohlavá", "Pěkná",7, LocalDate.of(2021,5,12),LocalDate.of(2021,5,10)));
            plants.writePlantsToFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");
            for (int i = 1; i <= 10; i++) {
                plants.addPlant(new Plant("Tulipán","Na prodej",14,LocalDate.now(),LocalDate.now()));

            }*/

            //plants.remove(3);



            plants.writePlantsToFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\novySeznam.txt", "\t");



            plant.forEach(System.out::println);








        } catch (PlantException e) {
            System.err.println(e.getMessage("Soubor nenalezen: " + e.getMessage()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}

