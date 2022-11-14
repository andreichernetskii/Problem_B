/**
 * for creating a circuit via data from class Task
 */
public class Creator {
    public Circuit creatingCircuit(int[] circuitSize, String[][] gates, int[] outputsConnectTo) {
        gatesInfoToData(gates);
        Circuit circuit = new Circuit();

        return circuit;
    }

    // analysis info about gates to data useful for creating gate
    private Gate gatesInfoToData(String[][] array) {
        return null;
    }
}
