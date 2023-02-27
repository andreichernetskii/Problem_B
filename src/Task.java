import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    Creator creator;
    Circuit circuit;
    Test[] tests;
    String[][] gates;   // information about gates connections - [number of gates][types of gates]
    String[][] testsData;   // information about tests - [number of tests][values]
    int[] circuitSize;    // first line of task what describing a circuit in data set
    int[] outputsConnectedTo; // information about outputs connections
    int numberOfTests;

    public void analysis(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file.getAbsoluteFile());
        String[] dataString;

        // it works until end of file
        // gathering data for sending to circuit creating
        while (true) {
            dataString = scanner.nextLine().split(" ");
            if (!scanner.hasNextLine()) break;

            circuitSize = new int[dataString.length];
            for (int i = 0; i < dataString.length; i++) circuitSize[i] = Integer.parseInt(dataString[i]);

            gates = new String[circuitSize[1]][];
            for (int i = 0; i < circuitSize[1]; i++) gates[i] = scanner.nextLine().split(" ");

            dataString = scanner.nextLine().split(" ");
            outputsConnectedTo = new int[dataString.length];
            for (int i = 0; i < dataString.length; i++) outputsConnectedTo[i] = Integer.parseInt(dataString[i]);

            numberOfTests = Integer.parseInt(scanner.nextLine());
            testsData = new String[numberOfTests][];
            for (int i = 0; i < numberOfTests; i++) testsData[i] = scanner.nextLine().split(" ");

            creatingTask();
        }
    }

    private void creatingTask() {
        creator = new Creator();
        // creating circuit
        circuit = creator.creatingCircuit(circuitSize, gates, outputsConnectedTo);
        // creating tests
        tests = new Test[numberOfTests];
        for (int i = 0; i < tests.length; i++) {
            tests[i] = creator.creatingTest(testsData[i], circuitSize);
        }
    }
}
