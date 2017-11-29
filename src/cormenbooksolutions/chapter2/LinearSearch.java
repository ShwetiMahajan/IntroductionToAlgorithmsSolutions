package cormenbooksolutions.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shwetimahajan on 11/29/17.
 */
public class LinearSearch {
    public static void main(String args[]) throws IOException {
        int input[] = InsertionSortDescending.getArray();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number to search : ");
        int key = Integer.parseInt(br.readLine());
        int index = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == key) {
                index = i + 1;
                break;
            }
        }
        if(index > 0) System.out.println("Number found at index " + index);
        else System.out.println("Number not found.");
    }
}
