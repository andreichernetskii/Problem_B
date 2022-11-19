public class GateInput extends Gate {
    public GateInput() {
        this.gateFunction = new AndFunction();
        this.output = this.gateFunction.gateFunction(input);
    }
}
