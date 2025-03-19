
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Plantwatering {
    public static void run(String[] args) {


        try (ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1)) {

            Runnable task = new Runnable() {
                public void run() {
                    System.out.println("Je čas zalévat květiny");
                    // Zde můžeš přidat kód, který chceš spustit každých 7 dní
                }
            };

            long initialDelay = 0;
            long period = 7 * 24 * 60 * 60; // 7 dní v sekundách

            scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
        }
    }

}