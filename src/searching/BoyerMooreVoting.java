package searching;

import java.io.IOException;
import java.util.Scanner;

public class BoyerMooreVoting {
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-- > 0)
            {
                int n =sc.nextInt();
                int arr[] = new int[n];

                for(int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();

                System.out.println(BoyerMooreVoting.majorityElement(arr, n));
            }
        }

    static int majorityElement(int a[], int size)
    {
        int count=1;
        int majorityElement=a[0];
        for(int i=1;i<size;i++) {
            if(a[i]==majorityElement) {
                count++;
            }
            else if(a[i]!=majorityElement) {
                count--;
            }
            if(count==0) {
                majorityElement=a[i];
                count=1;
            }
        }
        
        if(checkIsMajority(majorityElement,a)) {
            return majorityElement;
        }
        else
            return -1;
    }

    private static boolean checkIsMajority(int majorityElement, int[] a) {
        int count=0;
        int desiredCount=a.length/2+1;
       for(int i=0;i<a.length;i++) {
            if(a[i]==majorityElement) {
                count++;
            }
        }
        return count==desiredCount? true: false;
    }


}
