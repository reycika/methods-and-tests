package fibonacci;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Created by renata on 16-May-17.
 */
public class GetFibonacciElement {

    public static BigInteger fibonacciLoop(int number) throws Exception {

        if (number < 0) {
            throw new IllegalArgumentException("number must be >= 0");
        }

        if (number == 0) {
            return ZERO;
        }

        if (number == 1 || number == 2) {
            return ONE;
        }

        BigInteger firstInSeq = ONE, secondInSeq = ONE, fibonacci = ONE;
        for (int i = 3; i <= number; i++) {
            fibonacci = firstInSeq.add(secondInSeq);
            firstInSeq = secondInSeq;
            secondInSeq = fibonacci;
            /*if (i == 44) {
                throw new Exception("This exception isn't needed");
            }*/
        }
        //return BigInteger.valueOf(42);
        //return fibonacci.add(ONE);
        return fibonacci;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(fibonacciLoop(5));
    }
}
