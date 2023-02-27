import java.util.*;

public class OrFunction implements IGateFunction{
    @Override
    public boolean gateFunction(boolean[] inputArray) {
        for (boolean i : inputArray) {
            if (i) return true;
        }
        return false;
    }
}
