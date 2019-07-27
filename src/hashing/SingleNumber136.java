package hashing;

public class SingleNumber136 {

    public static void main(String[] args) {
        int[] n={4,1,2,1,2};
        System.out.println(singleNumber(n));

    }

    public static int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++) {
            result= result^nums[i];
        }
        return result;

    }

}
