public class NotFunction implements IGateFunction{
    @Override
    public boolean gateFunction(boolean[] inputArray) {
        return !inputArray[0];
    }
}
