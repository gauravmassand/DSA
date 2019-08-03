package sorting;
/*
*238. Product of Array Except Self
* Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }


    public static int[] productExceptSelf(int[] nums) {

        if(nums.length==1) {
            return nums;
        }
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int answer[] = new int[nums.length];
        left[0]=1;

        for(int i=1;i<nums.length;i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--) {
            right[i]=right[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++) {
            answer[i] = left[i]*right[i];
        }
        return answer;

    }
}
