package practice_052321;

public class BinarySearchPractice {
    private boolean binarySearch(int[] a, int target){
        int low = 0, high = a.length-1,mid;
        while(low<=high){
            mid = (low+high)/2;
            if(a[mid] == target) return true;
            if(target < a[mid]){
                high  = mid -1;
            }
            else{
                low = mid +1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,8};
        boolean isFound = new BinarySearchPractice ().binarySearch (a, 4);
        System.out.println (isFound);

    }
}
