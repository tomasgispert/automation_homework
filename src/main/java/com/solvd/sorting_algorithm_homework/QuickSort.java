package main.java.com.solvd.sorting_algorithm_homework;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private static final int LENGTH = 6;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args){
        int[] array = new int[LENGTH];
        generateNumbers(array);
        bubbleSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort(int[] arr, int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
    }

    public static void generateNumbers(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_NUMBER);
        }
    }
}
