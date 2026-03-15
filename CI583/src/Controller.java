import java.util.ArrayList;

public class Controller extends Thread {

    private String processID;
    private int burstTime;
    private int priority;

    public Controller(String processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public String getProcessID() {
        return processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

//    @Override
//    public int getPriority() {
//        return priority;
//    }
//
//    @Override
//    public void RoundRobin() {
//
//        ArrayList<Controller> waitingQueue = new ArrayList<>();
//
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(Thread.currentThread().getName() + " printing: " + i);
//            try {
//                Thread.sleep(500); // Simulate work with a delay
//            } catch (InterruptedException e) {
//                System.out.println("Thread interrupted: " + e.getMessage());
//            }
//        }
//
//
//    }
}
