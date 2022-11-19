public class GateXor extends Gate {
    public GateXor() {
        this.gateFunction = new XorFunction();
        this.output = this.gateFunction.gateFunction(input);
    }
}
