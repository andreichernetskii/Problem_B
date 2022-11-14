public abstract class Gate {
    boolean[] input;
    IGateFunction gateFunction;
    public Gate() {}

    public void performFunction() {
        gateFunction.gateFunction(input);
    }
}

