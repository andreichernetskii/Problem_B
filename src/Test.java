/**
 * Testing Circuit's work:
 * starts circuit and test results
 */

public class Test {
    boolean[] inputs;
    boolean[] outputsSample;

    public Test(boolean[] inputs, boolean[] outputsSample) {
        this.inputs = inputs;
        this.outputsSample = outputsSample;
    }

    public void startTest(Circuit circuit) {
        for (int i = 0; i < 100; i++) {
        }
        circuit.gates[2].gate.startFunction();
        checkingResult();
    }

    // what the result of circuit work
    private void checkingResult(boolean[] result) {

//        if good -> calling responseFunction();
//        if not -> calling changingGateLogicFunction();
    }

    private void changingGateLogicFunction() {

    }

    // shows is everything ok or which gate is broken
    private void responseFunction() {

    }
}
