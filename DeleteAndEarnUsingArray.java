public class DeleteAndEarnUsingArray {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length ==0) return 0;
        int max =0;
        for(int num:nums){
            max = Math.max(max, num);
        }
        //consolidated array length will be max + 1 (we will start from 0)
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }
        int[] dp= new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        //Now, this arr is a house robber array
        for(int i=2; i<arr.length; i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }
}
