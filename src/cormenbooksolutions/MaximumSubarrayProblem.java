package cormenbooksolutions;

/**
 * Created by shwetimahajan on 12/4/17.
 */
public class MaximumSubarrayProblem {
    public static void main(String[] args) {
        int A[] = {1, -3, 5, 7, -3, 0, -5, 6, 2, -1, 8};
        int max_subarray[] = maximumSubarray(A, 0, A.length-1);
        System.out.println("begin " + max_subarray[0] + " end " + max_subarray[1] + " sum " + max_subarray[2]);
    }
    public static int[] maximumSubarray(int []A, int low, int high) {
        System.out.println("low " + low + " high " + high);
        if(high < low ) return null;
        if(low == high) {
            int result[] = new int[3];
            result[0] = low;
            result[1] = low;
            result[2] = A[low];
            return result;
        }
        int mid = ((high - low)/2) + low;
        int left_max_subarray[] = maximumSubarray(A, low, mid);
        int right_max_subarray[] = maximumSubarray(A, mid+1, high);
        int max_crossing_subarray[] = maximumCrossingSubarray(A, low, mid, high);
        if(left_max_subarray[2] >= right_max_subarray[2] && left_max_subarray[2] >= max_crossing_subarray[2]) return left_max_subarray;
        else if(right_max_subarray[2] >= left_max_subarray[2] && right_max_subarray[2] >= max_crossing_subarray[2]) return right_max_subarray;
        else return max_crossing_subarray;
    }
    public static int[] maximumCrossingSubarray(int []A, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int max_left = -1;
        int max_right = -1;
        int right_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= 0; i-- ) {
            sum+=A[i];
            if(sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        sum = 0;
        for(int i = mid+1; i <= high; i++ ) {
            sum+=A[i];
            if(sum > right_sum) {
                right_sum = sum;
                max_right = i;
            }
        }
        int result[] = new int[3];
        result[0] = max_left;
        result[1] = max_right;
        result[2] = right_sum + left_sum;
        return result;
    }
}
