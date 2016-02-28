package org.Util;

/**
 * Created by dmytro on 29.02.16.
 */
public class Predicate {
    public static boolean checkEqualArr(char[][] arr1, char[][] arr2) {
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; ++i) {
                if (arr1[i].length != arr2[i].length)
                    return false;
                for (int j = 0; j < arr1[i].length; ++j)
                    if (arr1[i][j] != arr2[i][j])
                        return false;
            }
        }
        else
            return false;
        return true;
    }

}
