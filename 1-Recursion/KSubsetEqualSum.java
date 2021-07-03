public class KSubsetEqualSum {

    public static ArrayList<Integer> kSubset(int[] arr, int[] k, int idx, int kIdx) {
        if(idx == arr.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> al = new ArrayList<>();

        for
    }

    public static ArrayList<Integer> kSubset(int[] arr,int k) {
        int[] Karr = new int[k]
        return kSubset(arr,Karr,0,0);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80};
        System.out.println(kSubset(arr,k));
    }
}