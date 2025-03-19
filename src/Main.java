


public class Main {
    public static void main(String[] args) {

        Plants plants = new Plants();
        try {
            plants.readPlantsFromFile("C:\\Users\\AVATAR\\IdeaProjects\\Projekt1\\PlantsList\\kvetiny.txt", "\t");
        } catch (PlantException e) {
            System.err.println(e.getMessage("Soubor nenalezen: " + e.getMessage()));
        }

    }

}