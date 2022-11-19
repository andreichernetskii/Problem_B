/**
 * for creating all elements of task: circuit and tests via data from class Task
 */
public class Creator {
    Circuit circuit;
    Test test;

    // here creating the Circuit
    public Circuit creatingCircuit(int[] circuitSize, String[][] gates, int[] outputsConnectTo) {
        circuit = new Circuit();
        circuit.inputs = new GateWithConnections[circuitSize[0]];
        for (int i = 0; i < circuit.inputs.length; i++) {
            circuit.inputs[i] = new GateWithConnections();
            circuit.inputs[i].gate = new GateInput();
        }

        circuit.gates = new GateWithConnections[circuitSize[1]];
        for (int i = 0; i < circuit.gates.length; i++) {
            circuit.gates[i] = new GateWithConnections();
            circuit.gates[i].gate = gateCreating(gates[i][0]); // gate's type contains inside first index of array
            circuit.gates[i].gates = new GateWithConnections[circuit.gates.length - 1];

            // connecting gates to another gates
            for (int j = 0; j < circuit.gates.length - 1; j++) {
                // index of gate connected to. example: g1 - 1 it's a number of gate. index = 1 - 1;
                int connectedToInfo = Integer.parseInt(gates[i][j + 1].substring(1)) - 1;
                if (gates[i][j + 1].charAt(0) == 'i')   // ???
                    circuit.gates[i].gates[j] = circuit.inputs[connectedToInfo];
                else
                    circuit.gates[i].gates[j] = circuit.gates[connectedToInfo];
            }
        }

        circuit.outputs = new boolean[circuitSize[2]]; // just an array it will be enough

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

    // creating the gate
    private Gate gateCreating(String data) {
        switch (data){
            case "o": return new GateOr();
            case "a": return new GateAnd();
            case "n": return new GateNot();
            case "x": return new GateXor();
            default: return null;
        }
    }
}
