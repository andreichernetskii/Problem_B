public class GateInput extends Gate {
//    public GateInput() {
//        this.gateFunction = new InputFunction();
//        this.output = this.gateFunction.gateFunction(input);
//    }

//    @Override
//    public void setInput(boolean[] input) {
//        this.input = input;
//    }

    @Override
    public boolean startFunction() {
        this.gateFunction = new InputFunction();
        return this.gateFunction.gateFunction(input);
    }

    public void castToArray(boolean val) {
        this.input[0] = val;
    }
}
