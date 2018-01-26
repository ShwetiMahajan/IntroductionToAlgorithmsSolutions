package cormenbooksolutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shwetimahajan on 12/4/17.
 */
public class CountingSort {
    public static void main(String[] args) throws IOException {
        int input[] = InsertionSortDescending.getArray();
        // Here elements should all be integers and in some range 0 to k.
        // The elements may not be distict as Counting sort is a stable algorithm.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "abc";
        String s1 = "abc";
        System.out.println(s==s1);
    }
}
