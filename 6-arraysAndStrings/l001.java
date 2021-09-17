import java.util.*;

public class l001 {

    //LC: long pressed key [925]
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if(i-1 >= 0 && name.charAt(i-1) == typed.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        
        while(j < typed.length()) {
            if(i-1 >= 0 && name.charAt(i-1) != typed.charAt(j)) 
                return false;
            j++;
        }
        return i == name.length();    
    }

    // LC: container with most water [11]
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;
        
        while(i < j) {
            int h = Math.min(height[i], height[j]);
            int l = j - i;
            int water = l * h;
            
            maxWater = Math.max(water, maxWater);
            
            if(height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxWater;
    }

    // 977. Squares of a Sorted Array

    public int[] sortedSquares(int[] nums) {
         // o(n) time, O(n) space
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        
        for(int k = n - 1; k >= 0; k--) {
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];

            if(val1 > val2) {
                res[k] = val1;
                i++;
            } else {
                res[k] = val2;
                j--;
            }
        }
        return res;
    }
    
    // 556. Next Greater Element III
    public int nextGreaterElement(int n) {
        if(n < 10) return -1;
        String nextNum = nextGreaterElement_("" + n);
        long num = Long.parseLong(nextNum);
        if(num <= Integer.MAX_VALUE) {
            return (int)num;
        } else {
            return -1;
        }
    }

    // next greater for portal
    private static int dipIndex(char[] arr) {
        int indx = -1;
        for(int i = arr.length - 1; i > 0; i--) {
            if(arr[i - 1] < arr[i]) {
                indx = i - 1;
                break;
            }
        }
        return indx;
    }

    private static int ceilIndex(char[] arr, int indx) {
        // indx -> dip indx
        int dipVal = arr[indx];
        int i = arr.length - 1;
        while(dipVal >= arr[i]) {
            i--;
        }
        return i;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int left, int right) {
        while(left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static String nextGreaterElement_(String str) {
        char[] arr = str.toCharArray();
        int dipIndx = dipIndex(arr);
        if(dipIndx == -1) {
            return "-1";
        }
        int ceilIndx = ceilIndex(arr, dipIndx);
        swap(arr, dipIndx, ceilIndx);
        reverse(arr, dipIndx + 1, arr.length - 1);
        return String.valueOf(arr);
    }

    // 905. Sort Array By Parity
    public int[] sortArrayByParity(int[] nums) {
        int i = 0; // first unsolved
        int j = 0; // first odd

        while(i < nums.length) {
            if(nums[i] % 2 != 0) {
                // odd
                i++;
            } else {
                // even
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
        }
        return nums;
    }
}