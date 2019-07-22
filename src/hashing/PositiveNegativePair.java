package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PositiveNegativePair {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(in.readLine());
        while(t-->0){
            int n= Integer.parseInt(in.readLine());
            int[] arr = new int [n];
            String[] temp1 = in.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(temp1[i]);

            positiveNegativePair(arr,n);
            System.out.println();
        }

    }

    private static void positiveNegativePair(int[] arr, int n) {
        List<Integer> outputArray = new ArrayList<>();
        Map<Integer,Integer> integerMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            int valueSearch = Math.abs(arr[i]);
            if(!integerMap.containsKey(valueSearch)) {
                integerMap.put(valueSearch,1);
            }
            else {
                integerMap.put(valueSearch,integerMap.get(valueSearch)+1);
                int count = integerMap.get(valueSearch);
                if(count ==2) {
                    outputArray.add(valueSearch);
                }
            }
        }
        Collections.sort(outputArray);
        outputArray.stream().forEach(x -> System.out.print(x+" "+(-1*x)+" "));
    }
}
