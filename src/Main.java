import java.util.*;

public class Main {
    // Ants simulation class take 1
    private final static Map<Integer, int[]> NEIGHBORS = new HashMap<>() {{
            put(1, new int[]{2, 5, 4});
            put(2, new int[]{1, 6, 3});
            put(3, new int[]{2, 4, 7});
            put(4, new int[]{1, 3, 8});
            put(5, new int[]{1, 6, 8});
            put(6, new int[]{2, 5, 7});
            put(8, new int[]{5, 4, 7});
    }};
    private static final Random rand = new Random(1233998L);

    private static final int START_NODE = 1;
    private static final int TARGET_NODE = 7;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of iterations you want to run it for: ");
        int nSimulations = Integer.parseInt(in.nextLine());

        int totalSteps = 0;
        for (int i = 0; i < nSimulations; i++)
            totalSteps += runSimulation();
        double average = totalSteps / nSimulations;

        // System.out.println("Simulation time: " + run_simulation());
        System.out.println("Average time to absorption : " + average);
    }

    private static int getRandomNeighbor(int[] array) {
        int rnd = rand.nextInt(array.length);
        return array[rnd];
    }

    private static int runSimulation() {
        int node = START_NODE;
        int steps = 0;
        while (node != TARGET_NODE) {
            node = getRandomNeighbor(NEIGHBORS.get(node));
            steps = steps + 1;
        }
        return steps;
    }

}
