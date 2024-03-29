/**
 * for creating all elements of task: circuit and tests via data from class Task
 */
public class Creator {
    Circuit circuit;
    Test test;

    // here creating the Circuit
    public Circuit creatingCircuit(int[] circuitSize, String[][] gates, int[] outputsConnectTo) {
        // String[][] gates -> information about gates connections - [number of gate][types of gate]

        circuit = new Circuit();
        circuit.inputs = new GateWithConnections[circuitSize[0]];

        // creating gates with connections and putting inside info about gate (input in this contest)
        for (int i = 0; i < circuit.inputs.length; i++) {
            circuit.inputs[i] = new GateWithConnections();
            circuit.inputs[i].gate = new GateInput();
        }

        // here is creating gates, what looks like an array with information about gate
        // and subarray to which gate it's connected
        circuit.gates = new GateWithConnections[circuitSize[1]];
        for (int i = 0; i < circuit.gates.length; i++) {
            circuit.gates[i] = new GateWithConnections();
            circuit.gates[i].gate = gateCreating(gates[i][0]); // gate's type contains inside first index of array
            circuit.gates[i].gates = new GateWithConnections[circuit.gates.length];

            // connecting gates to another gates
            for (int j = 0; j < gates[i].length - 1; j++) {
                // index of gate connected to. example: g1 -> 1 it's a number of gate. index = 1 - 1;
                int connectedToInfo = Integer.parseInt(gates[i][j + 1].substring(1)) - 1;
                if (gates[i][j + 1].charAt(0) == 'i')   // in case if gate has connected to input gate
                    circuit.gates[i].gates[j] = circuit.inputs[connectedToInfo];
                else    // other cases
                    circuit.gates[i].gates[j] = circuit.gates[connectedToInfo];
            }
        }
//        circuit.outputs = new boolean[circuitSize[2]]; // just an array it will be enough

        // connecting outputs to gates from dataSet
        circuit.outputs = new GateWithConnections[circuitSize[2]];
        for (int i = 0; i < outputsConnectTo.length; i++) {
            circuit.outputs[i] = circuit.gates[outputsConnectTo[i] - 1];
        }

        return circuit;
    }

    // creating the gate
    private Gate gateCreating(String data) {
        return switch (data) {
            case "o" -> new GateOr();
            case "a" -> new GateAnd();
            case "n" -> new GateNot();
            case "x" -> new GateXor();
            default -> null;
        };
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

        // calling test constructor
        test = new Test(inputsToTestConstructor, outputsToTestConstructor);
        return test;
    }
}
