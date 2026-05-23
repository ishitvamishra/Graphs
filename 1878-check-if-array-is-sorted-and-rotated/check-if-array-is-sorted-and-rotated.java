class Solution {
    public boolean check(int[] nums) {
        int pivot =-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                pivot=i;
                break;
            }
        }
        int[] arr= new int[nums.length];
        int j=0;
        for(int i=pivot+1;i<nums.length;i++){
            arr[j]=nums[i];
            j++;
        }
        for(int k=0;k<=pivot;k++){
            arr[j]=nums[k];
            j++;
        }
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}