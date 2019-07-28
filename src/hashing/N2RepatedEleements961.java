package hashing;

public class N2RepatedEleements961 {

    public static void main(String[] args) {
        int [] input = {2,1,2,5,3,2};
        System.out.println(repeatedNTimes(input));
    }


    public static int repeatedNTimes(int[] A) {
        if(A[0]==A[A.length-1]) {
            return A[0];
        }
        int result=-1;
        for(int i=0;i<A.length-1;i++) {
            if(A[i] == A[i+1] || A[i]==A[i+2]) {
                 result=i;
                break;
            }

        }
         if(result!=-1) {
             return A[result];
         }
         return -1;

    }
}
