package org;

import static org.ViewResult.resultMessage;

/**
 * Created by dmytro on 27.02.16.
 */
public class DataProcess {
    /**
     * Counts factorial of input number
     * @param number
     * @return factorial value of number
     */
    private int countFactorial(int number) {
        if (number == 0)
            return 1;
        return number*countFactorial(--number);
    }

    public int process(int number) {
        int result = countFactorial(number);
        resultMessage(number, result);
        return result;
    }
}
