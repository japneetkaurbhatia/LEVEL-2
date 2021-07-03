public class TwoSubsetEqualSum {

    public static int TwoSubset(int[] arr, int idx, int sum1, String str1, int sum2, String str2){
        if(idx == arr.length) {
            if(sum1 == sum2) {
                System.out.println(str1 + " = " + str2);
                return 1;
            }
            return 0;
        }
        int count = 0;
        count += TwoSubset(arr,idx+1,sum1 + arr[idx], str1 + arr[idx] + " ", sum2, str2);
        count += TwoSubset(arr,idx+1,sum1, str1 , sum2 + arr[idx], str2 + arr[idx] + " ");
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80};
        System.out.println(TwoSubset(arr,0,0," ",0," "));
    }
}