import java.util.Arrays;

public class Circuit {
    GateWithConnections[] gates;    // gates are inside with information about their connections
    GateWithConnections[] inputs;   // inputs with input information
    GateWithConnections[] outputs;  // circuits work result

    // filling circuits gates of data and returning result of its work
    public boolean[] start(Circuit circuit, boolean[] inputData) {
        boolean[] result = new boolean[circuit.outputs.length];
        // putting input data to the input gate
        for (int i = 0; i < inputData.length; i++) {
            ((GateInput)circuit.inputs[i].gate).castToArray(inputData[i]);
        }

        //
        for (int i = 0; i < circuit.outputs.length; i++) {
            result[i] = gatesWork(circuit.outputs[i]);
        }
        return null;
    }

    private boolean gatesWork(GateWithConnections gwc) {
//        gwc.gates
        while (gwc.gates.length < 2 || !gwc.gates[0].gate.gateFunctionDone) {
            return gatesWork(gwc.gates[0]);
        }
        gwc.gate.input = gwc.gates[0].gate.startFunction();
        gwc.gate.gateFunctionDone = true;

        return gwc.gate.gateFunction(gwc.gates[0].gate.output); // here is no output definition
    }
}
