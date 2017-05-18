package fibonacci;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static fibonacci.GetFibonacciElement.fibonacciLoop;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Created by renata on 16-May-17.
 */
public class GetFibonacciElementTest {

    @Test
    void fibonacciNthElement() throws Exception {
        assertEquals(BigInteger.valueOf(5), fibonacciLoop(5));
    }

    @Test
    void fibonacci10elements() throws Exception {
        int[] bases = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        BigInteger[] expected = new BigInteger[bases.length];

        int j = 0;
        for (int basis : bases) {
            expected[j++] = BigInteger.valueOf(basis);
        }
//        BigInteger[] expected = {BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(8),
//                BigInteger.valueOf(13), BigInteger.valueOf(21), BigInteger.valueOf(34), BigInteger.valueOf(55)};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], fibonacciLoop(i+1));
        }
    }

    @Test
    void fibonacci1000elements() throws Exception {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(fibonacciLoop(i));
            assertEquals(fibonacciLoop(i+1), fibonacciLoop(i).add(fibonacciLoop(i-1)));
        }
    }

    /*@Test - tale test sam sebe preverja, to ni ok :)
    void fibonacci1000elements() throws Exception {
        int[] expected = new int[1000];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = fibonacciLoop(i+1);
        }
        for (int i = 2; i < expected.length; i++) {
            assertEquals(expected[i], fibonacciLoop(i+1));
        }
    }*/

    @Test
    void fibonacciNegativeIntFail() throws Exception {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> fibonacciLoop(-15));
        assertEquals("number must be >= 0", ex.getMessage());
    }

    @Test
    void fibonacciExceptionCompareMessage() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("number must be >= 0");
        });
        assertEquals("number must be >= 0", exception.getMessage());
    }

}