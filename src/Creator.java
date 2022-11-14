/**
 * for creating a circuit via data from class Task
 */
public class Creator {
    Circuit circuit;
    Test test;

    // here creating the Circuit
    public Circuit creatingCircuit(int[] circuitSize, String[][] gates, int[] outputsConnectTo) {
//        gatesInfoInterpreter(gates);
        circuit = new Circuit();

        return circuit;
    }

    // here creating the Test
    public Test creatingTest(String[] testsData, int[] circuitSize) {
        int inputsAmount = circuitSize[0];
        int outputsAmount = circuitSize[2];
        boolean[] inputsToTestConstructor = new boolean[inputsAmount];
        boolean[] outputsToTestConstructor = new boolean[outputsAmount];

        // getting elements from array with information about tests "testData"
        // and casting it to boolean array
        // and sending it to Test constructor
        for (int i = 0; i < inputsToTestConstructor.length; i++) {
            inputsToTestConstructor[i] = (testsData[i].equals("0")) ? false : true;
        }
        for (int i = 0; i < outputsToTestConstructor.length; i++) {
            outputsToTestConstructor[i] = (testsData[i + inputsAmount].equals("0")) ? false : true;
        }

        test = new Test(inputsToTestConstructor, outputsToTestConstructor);
        return test;
    }

    // analysis info about gates to data useful for creating gate
//    private Gate gatesInfoInterpreter(String[][] array) {
//        String gateType = array[0];
//        for (int i = 0; i < array.length; i++) {
//
//        }
//        return null;
//    }
}
