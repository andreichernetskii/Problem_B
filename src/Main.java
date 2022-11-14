import java.io.File;
import java.io.FileNotFoundException;

/**
 * INPUT LEGEND:
 *
 * 1. A line containing three positive integers giving the number of inputs (N ≤ 8), the number of gates (G ≤ 19),
 * and the number of outputs (U ≤ 19) in the circuit.
 *
 * 2. One line of input for each gate. The first line describes gate g1. If there are several gates, the next line
 * describes gate g2, and so on. Each of these lines contains the gate type (a = and, n = not, o = or, and
 * x = exclusive or), and identification of the input(s) to the gate. Gate input comes from the circuit inputs
 * (i1, i2, …) or the output of another gate (g1, g2, …).
 *
 * 3. A line containing the numbers of the gates connected to the U outputs u1, u2, …. For example, if there are
 * three outputs, and u1 comes from g5, u2 from g1, and u3 from g4, then the line would contain: 5 1 4
 *
 * 4. A line containing an integer which is the number of observations of the circuit’s behavior (B).
 *
 * 5. Finally B lines, each containing N values (ones and zeros) giving the observed input values and U values
 * giving the corresponding observed output values. No two observations have the same input values.
 */

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("src/dataSet");
            Task task = new Task();
            task.Analysis(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}