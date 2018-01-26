package cormenbooksolutions;

import java.io.IOException;

/**
 * Created by shwetimahajan on 11/30/17.
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        int []input = InsertionSortDescending.getArray();
        System.out.println("The sorted array is : ");
        if(input.length == 1) InsertionSortDescending.printArray(input);
        else {
            int result[] = mergeSort(input, 0, input.length - 1);
            InsertionSortDescending.printArray(result);
        }
    }

    public static int[] mergeSort(int[] A, int beg, int end) {
        if((end - beg) < 0) return null;
        int result[] = new int[end - beg + 1];
        if(beg == end) {
            result[0] = A[beg];
            return result;
        }
        int mid = (beg + end)/2;
        int []left = mergeSort(A, beg, mid);
        int []right = mergeSort(A, mid+1, end);
        result = merge(left, right);
        return result;
    }

    public static int[] merge(int[] left, int []right) {
        int []result = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        boolean flag = false;
        if(left == null || right == null) flag = true;
        if(flag == true) {
            if(right == null) {
                while(l < left.length) {
                    result[i] = left[l];
                    l++;
                    i++;
                }
            }
            else {
                while(r < right.length) {
                    result[i] = right[r];
                    r++;
                    i++;
                }
            }
        }
        else {
            while(l < left.length && r < right.length) {
                if(left[l] <= right[r]) {
                    result[i] = left[l];
                    l++;
                    i++;
                }
                else {
                    result[i] = right[r];
                    r++;
                    i++;
                }
            }
            while(l < left.length) {
                result[i] = left[l];
                l++;
                i++;
            }
            while(r < right.length) {
                result[i] = right[r];
                r++;
                i++;
            }
        }

        return result;
    }
}
