



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Main {
    public static void main(String[] args) {



        HousePlants plants = new HousePlants();







        try {

            plants.readPlantsFromFile("PlantsList\\kvetiny.txt", "\t");
            //pridani nove kvetiny
            plants.addPlant(new Plant("Lilie Zlatohlavá", "Pěkná",7, LocalDate.of(2021,5,15),LocalDate.of(2021,5,10)));
            //pridani 10 rostlin s popisem
            for (int i = 1; i <= 10; i++) {
                plants.addPlant(new Plant("Tulipán","Na prodej",14, LocalDate.now(),LocalDate.now()));

            }
            plants.writePlantsToFile("PlantsList\\kvetiny.txt", "\t");

            List<Plant> plant = plants.getPlant();


            //razeni rostlin podle ruznych kriterii


            System.out.println("\n" + "Výchozí řazení rostlin podle nazvu : " );
            Collections.sort(plant);
            plant.forEach( c -> System.out.print( c.getName()+ ", \n" ));

            System.out.println("\nRostliny podle data poslední zálivky : ");
            plant.sort(Comparator.comparing(Plant::getWatering));
            plant.forEach(c -> System.out.print( c.getName()+" ("+c.getWatering()+"), \n"));

            //odebrani kvetiny na treti pozici
            plants.remove(2);

            //informace o zalivce pro vsechny kvetiny ze seznamu
            System.out.println("\nInformace před zaleváním : ");

            //plant.forEach(c -> System.out.print (c.getWateringInfo()+"), \n"));
            plant.forEach(System.out::print);

            //kvetiny ktere je treba hned zalit
            System.out.println("\nZalít květiny !!!"+ plants.getPlantsToWater());

            System.out.println("\nZalevání květin -> a nastavení datumu poslední zálivky na dnešní ! ");

            plant.forEach(Plant::doWateringNow);

            System.out.println("\nInformace po zalévání : ");

            plant.forEach(c -> System.out.print (c.getWateringInfo()+"), \n"));
            //konec info



            //vypis kvetiny na zadanem indexu

            System.out.println("\nKvětina na indexu : ");

            System.out.println(plant.get(1));






           plants.writePlantsToFile("PlantsList\\novySeznam.txt", "\t");



        } catch (IndexOutOfBoundsException e) {
            try {
                throw new PlantException("Špatně zadany index !");
            } catch (PlantException ex) {
                throw new RuntimeException(ex);
            }

        } catch (PlantException e) {
        System.err.println(e.getMessage());

        }




    }


}

