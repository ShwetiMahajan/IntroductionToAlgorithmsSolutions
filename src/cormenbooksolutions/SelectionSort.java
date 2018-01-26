package cormenbooksolutions;

import java.io.IOException;

/**
 * Created by shwetimahajan on 11/29/17.
 */
public class SelectionSort {
    public static void main(String[] args) throws IOException {
        int []input = InsertionSortDescending.getArray();
        for(int i = 0; i < input.length - 1; i++) {
            int beg = i;
            int min = findMin(input, beg, input.length);
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
        System.out.println("The final sorted array is : ");
        InsertionSortDescending.printArray(input);
    }

    public static int findMin(int []in, int begin, int end) {
        int min = begin;
        int minVal = in[begin];
        for(int i = begin + 1; i < end; i++) {
            if(in[i] < minVal) min = i;
        }
        return min;
    }
}
