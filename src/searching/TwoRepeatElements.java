package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoRepeatElements {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            String l = br.readLine();
            String[] sarr = l.split(" ");
            int[] arr = new int[sarr.length];
            for(int i1=0;i1<arr.length;i1++){
                arr[i1] = Integer.parseInt(sarr[i1]);
            }

            TwoRepeatElements obj = new TwoRepeatElements();

            obj.twoRepeated(arr, n);
            System.out.println();


        }
    }

    private void twoRepeated(int[] arr, int n) {
        StringBuilder output= new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            if(arr[Math.abs(arr[i])-1]>=0) {
                arr[Math.abs(arr[i]) - 1] = (-1) * arr[Math.abs(arr[i]) - 1];
            }
            else {
                output.append(Math.abs(arr[i])+" ");
            }

        }
        System.out.print(output.toString().trim());
    }

}
