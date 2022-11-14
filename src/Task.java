import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
    Creator creator;
    Circuit circuit;
    String[][] gates;   // information about gates connections - [number of gates][types of gates]
    String[][] tests;   // information about tests - [number of tests][values]
    int[] circuitSize;    // first line of task what describing a circuit in data set
    int[] outputsConnectTo; // information about outputs connections
    int numberOfTests;

    public void Analysis (File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file.getAbsoluteFile());
        String[] dataString;

        // it works until end of file
        // gathering data for sending to circuit creating
        while (scanner.hasNextLine()) {
            dataString = scanner.nextLine().split(" ");

            circuitSize = new int[dataString.length];
            for (int i = 0; i < dataString.length; i++) circuitSize[i] = Integer.parseInt(dataString[i]);

            gates = new String[circuitSize[1]][];
            for (int i = 0; i < circuitSize[1]; i++) gates[i] = scanner.nextLine().split(" ");

            dataString = scanner.nextLine().split(" ");
            outputsConnectTo = new int[dataString.length];
            for (int i = 0; i < dataString.length; i++) outputsConnectTo[i] = Integer.parseInt(dataString[i]);

            numberOfTests = Integer.parseInt(scanner.nextLine());
            tests = new String[numberOfTests][];
            for (int i = 0; i < numberOfTests; i++) tests[i] = scanner.nextLine().split(" ");
        }
    }

//    private void CreateSystem(int[] systemDescription, ) {
//
//    }


}
