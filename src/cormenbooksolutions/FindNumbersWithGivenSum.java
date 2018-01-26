package cormenbooksolutions;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by shwetimahajan on 11/30/17.
 */
public class FindNumbersWithGivenSum {
    public static void main(String[] args) throws IOException {
        int input[] = InsertionSortDescending.getArray();
        int key = 27;
        boolean flag = false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < input.length; i++) {
            hm.put(input[i], i);
        }
        for(int i = 0; i < input.length; i++) {
            int temp = Math.abs(input[i] - key);
            if(hm.containsKey(temp)) {
                if(hm.get(temp) != i) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
