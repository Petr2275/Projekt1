


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        HousePlants plants = new HousePlants();

        try {

            plants.readPlantsFromFile("PlantsList\\novySeznam.txt", "\t");
             /*plants.addPlant(new Plant("Lilie Zlatohlavá", "Pěkná",7, LocalDate.of(2021,5,12),LocalDate.of(2021,5,10)));
            plants.writePlantsToFile("PlantsList\\kvetiny.txt", "\t");
            for (int i = 1; i <= 10; i++) {
                plants.addPlant(new Plant("Tulipán","Na prodej",14, LocalDate.now(),LocalDate.now()));

            }
*/
            //plants.remove(3);
            List<Plant> plant = plants.getPlant();

            Collections.sort(plant);


            System.out.println("\nVýchozí řazení rostlin podle nazvu : " + "\n" + plants + "\n");

            plant.forEach( c -> System.out.print(c.getName()+"), \n"));

            System.out.println("\nRostliny podle data poslední zálivky : ");

            plant.forEach(c -> System.out.print(c.getName()+" ("+c.getWatering()+"), \n"));

            System.out.println("\nInformace o další zálivce před zaleváním : ");

            plant.forEach(c -> System.out.print (c.getWateringInfo()+"), \n"));

            System.out.println("\nZalevání květin : ");

            plant.forEach(Plant::doWateringNow);

            System.out.println("\nInformace po zalévání : ");

            plant.forEach(c -> System.out.print (c.getWateringInfo()+"), \n"));



            plants.writePlantsToFile("PlantsList\\novySeznam.txt", "\t");


            plant.forEach(System.out::print);



        } catch (PlantException e) {
            System.err.println(e.getMessage("Soubor nenalezen: " + e.getMessage()));


        }


    }


}

