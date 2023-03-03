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
            ((GateInput)circuit.inputs[i].gate).castToArray(inputData[i]); // а что я тут сделал вообще? ПРОАНАЛИЗИРОВАТЬ. однако, вроде, норм
        }

        //
        for (int i = 0; i < circuit.outputs.length; i++) {
            result[i] = gatesWork(circuit.outputs[i]);
        }
        return null;
    }

    private boolean gatesWork(GateWithConnections gwc) {
        boolean result = false;

        // тут у нас односвязный список и надо использвать if а не while
        GateWithConnections startPoint = gwc; // start gate from which we are starting step up
        GateWithConnections nowGate = gwc;  // gate where we are
        GateWithConnections nextGate = gwc.gates[0]; // next gate
        // берем выход с предыдущей брамки и пихаем в функцию текущей

        while (nowGate.gates.length < 2 || !nextGate.gate.gateFunctionDone) {
            nowGate = nextGate;
        }

        for (int i = 0; i < nowGate.gates.length; i++) {
            nowGate.gate.input[i] = nextGate.gate.startFunction();
            nextGate.gate.gateFunctionDone = true;
        }

        if (nowGate.gate.gateFunction == null) return result = nowGate.gate.input[0];
        return gatesWork(startPoint);
    }
}
