package sorting;

/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

public class FirstLastElementSorted {
    public static void main(String[] args) {
        int[] inp = {1,2,3,3,3,3,4,5,9};

        System.out.println(searchRange(inp,3));

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];

        if(nums.length==1 && nums[0]==target) {
            output[0]=0;
            output[1]=0;
            return output;
        }
        if(nums.length==1 && nums[0]!=target) {
            output[0]=-1;
            output[1]=-1;
            return output;
        }


        int left=0;
        int right = nums.length-1;
        int startIndex=-1;
        int rightIndex =-1;

        //calculate left index
        while(left<=right) {
            int mid = left+(right-left)/2;
            if(left==right && right ==mid && nums[mid]==target) {
                startIndex = mid;
                break;
            }
            if(nums[mid]==target && mid==0) {
                startIndex=mid;
                break;
            }

            if(nums[mid]==target && (mid-1)>=0 && nums[mid-1]!=target) {
                startIndex = mid;
                break;
            }
            else if (nums[mid]<target) {
                left = mid+1;
            }
            else if(nums[mid]>target) {
                right = mid-1;
            }
            else if(nums[mid]==target && (mid-1)>=0 && nums[mid-1]==target)
            {
                right = mid-1;
            }
        }

        //calculare right index
        left =0;
        right = nums.length-1;

        while(left<=right) {
            int mid = left+(right-left)/2;
            if(left==right && right ==mid && nums[mid]==target) {
                rightIndex = mid;
                break;
            }
            if(nums[mid]==target && mid==nums.length-1) {
                rightIndex=mid;
                break;
            }

            if(nums[mid]<target) {
                left = mid+1;
            }
            else if(nums[mid]>target) {
                right = mid-1;
            }
            else if(nums[mid]==target && (mid+1)<=nums.length-1 && nums[mid+1]!=target) {
                rightIndex = mid;
                break;
            }
            else if(nums[mid]==target && (mid+1)<=nums.length-1 && nums[mid+1]==target) {
                left=mid+1;
            }
        }


        output[0]=startIndex;
        output[1]=rightIndex;
        return output;

    }
}
