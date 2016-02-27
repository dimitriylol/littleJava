package org;

/**
 * Created by dmytro on 27.02.16.
 */
public class ViewResult {
    public static void errorMessage(String[] arrStr) {
        System.out.print("Input parameter(s) ");
        for (String str : arrStr)
            System.out.print(str + " ");
        System.out.println("is incorrect!");
    }
    public static void resultMessage(int factorial) {
        System.out.println("Factorial is " + factorial);
    }
}
