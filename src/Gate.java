public abstract class Gate {
    protected boolean[] input; // data from previous gates (inputs like a gates too)
    protected boolean output; // result of gate function ??
    IGateFunction gateFunction;

//    public void performFunction() {
//        gateFunction.gateFunction(input);
//    }
//    public abstract void setInput(boolean[] input);
    public abstract void startFunction();

}

