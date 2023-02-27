public abstract class Gate {
    boolean[] input; // data from previous gates (inputs like a gates too)
    boolean output; // result of gate function ??
    IGateFunction gateFunction;

    public void performFunction() {
        gateFunction.gateFunction(input);
    }
}

