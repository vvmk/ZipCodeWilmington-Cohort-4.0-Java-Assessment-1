package com.zipcodewilmington.assessment1.part2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 2/16/18.
 */
public class ArrayUtils {
    /**
     * @param objectArray   an array of any type of Object
     * @param objectToCount any non-primitive value
     * @return the number of times the specified `value` occurs in the specified `objectArray`
     * Given an array of objects, named `objectArray`, and an object `objectToCount`, return the number of times the `objectToCount` appears in the `objectArray`
     */
    public static Integer getNumberOfOccurrences(Object[] objectArray, Object objectToCount) {
        int sum = 0;
        for (Object o : objectArray)
            sum = (o.equals(objectToCount)) ? sum+1 : sum;
        return sum;
    }

    /**
     * @param objectArray    an array of any type of Object
     * @param objectToRemove a value to be removed from the `objectArray`
     * @return an array with identical content excluding the specified `objectToRemove`
     * Given an array of objects, name `objectArray`, and an object `objectToRemove`, return an array of objects with identical contents excluding `objectToRemove`
     */
    public static <T> T[] removeValue(T[] objectArray, T objectToRemove) {
        T[] ret = objectArray;
        for (int i=0;i<objectArray.length;i++) {
            if (objectArray[i].equals(objectToRemove)) {
                ret = Arrays.copyOf(Arrays.copyOfRange(objectArray, 0, i), objectArray.length - 1);
                System.arraycopy(objectArray, i + 1, ret, i, objectArray.length - i - 1);
                objectArray = ret;
            }
        }
        return ret;
    }

    /**
     * @param objectArray an array of any type of Object
     * @return the most frequently occurring object in the array
     * given an array of objects, named `objectArray` return the most frequently occuring object in the array
     */
    public static Object getMostCommon(Object[] objectArray) {
        Object mostCommon = null;
        int record = 0;
        for (Object o : objectArray) {
            int challenger = getNumberOfOccurrences(objectArray, o);
            if (challenger > record) {
                mostCommon = o;
                record = challenger;
            }
        }
        return mostCommon;
    }


    /**
     * @param objectArray an array of any type of Object
     * @return the least frequently occurring object in the array
     * given an array of objects, named `objectArray` return the least frequently occuring object in the array
     */
    public static Object getLeastCommon(Object[] objectArray) {
        Object leastCommon = null;
        int record = Integer.MAX_VALUE;
        for (Object o : objectArray) {
            int challenger = getNumberOfOccurrences(objectArray, o);
            if (challenger < record) {
                leastCommon = o;
                record = challenger;
            }
        }
        return leastCommon;
    }

    /**
     * @param objectArray      an array of any type of Object
     * @param objectArrayToAdd an array of Objects to add to the first argument
     * @return an array containing all elements in `objectArray` and `objectArrayToAdd`
     * given two arrays `objectArray` and `objectArrayToAdd`, return an array containing all elements in `objectArray` and `objectArrayToAdd`
     * NOTE: Arrays.copyOf() forces the type of the src array elements onto the returned array. System.arraycopy does not.
     */
    public static <T> T[] mergeArrays(T[] objectArray, T[] objectArrayToAdd) {
        T[] ret = Arrays.copyOf(objectArray, (objectArray.length + objectArrayToAdd.length));
        System.arraycopy(objectArrayToAdd, 0, ret, objectArray.length, objectArrayToAdd.length);
        return ret;
    }
}
