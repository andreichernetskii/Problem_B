public class AndFunction implements IGateFunction{
    @Override
    public boolean gateFunction(boolean[] inputArray) {
        for (boolean i : inputArray) {
            if (i == false) return false;
        }
        return true;
    }
}