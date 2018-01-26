/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cormenbooksolutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author shwetimahajan
 */
public class InsertionSortDescending {
    public static void main(String[] args) throws IOException {
        int []input = getArray();
        System.out.println("The input is : ");
        printArray(input);
        for(int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;
            while(j >= 0 && input[j] < key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        System.out.println("The sorted output is : ");
        printArray(input);
    }
    
    public static void printArray(int in[]) {
        for(int i = 0; i < in.length; i++) {
            System.out.println(in[i]);
        }
    }
    
    public static int[] getArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of elements in the list to be sorted : ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the elements, each on a separate line: ");
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        return input;
    }
}
