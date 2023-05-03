public class MaxSubarraySum {
    public static int maxSubarraySum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        
        int mid = arr.length / 2;
        int leftSum = maxSubarraySum(Arrays.copyOfRange(arr, 0, mid));
        int rightSum = maxSubarraySum(Arrays.copyOfRange(arr, mid, arr.length));
        
        int crossingSum = maxCrossingSum(arr, mid);
        
        return Math.max(Math.max(leftSum, rightSum), crossingSum);
    }
    
    public static int maxCrossingSum(int[] arr, int mid) {
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid - 1; i >= 0; i--) {
            currentSum += arr[i];
            leftSum = Math.max(leftSum, currentSum);
        }
        
        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid; i < arr.length; i++) {
            currentSum += arr[i];
            rightSum = Math.max(rightSum, currentSum);
        }
        
        return leftSum + rightSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarraySum(arr));
    }
}
