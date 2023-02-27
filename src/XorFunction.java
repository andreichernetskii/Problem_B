/**
 *  in 2 size array of booleans:
 *  -- if one of elements of array == true => return true
 *  -- if two elements are equal => return false
 *  in more than 2 size:
 *  -- return false if number of true elements is even
 *  -- return true in another variants
 */

public class XorFunction implements IGateFunction{
    @Override
    public boolean gateFunction(boolean[] inputArray) {
        if (inputArray.length <= 2 && inputArray.length != 0) {
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] == inputArray[i + 1]) return false;
            }
        }
        else {
            int countingEvenNumbers = 0;
            for (boolean i : inputArray) if (i) countingEvenNumbers++;
            if (countingEvenNumbers % 2 == 0) return false;
        }
        return true;
    }
}
