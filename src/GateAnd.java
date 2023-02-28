public class GateAnd extends Gate {
//    public GateAnd() {
//        this.gateFunction = new AndFunction();
//        this.output = this.gateFunction.gateFunction(input);
//    }
//    @Override
//    public void setInput(boolean[] input) {
//        this.input = input;
//    }

    @Override
    public void startFunction() {
        this.gateFunction = new AndFunction();
        this.output = this.gateFunction.gateFunction(input);
    }
}
