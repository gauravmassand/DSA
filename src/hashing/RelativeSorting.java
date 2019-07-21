package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RelativeSorting {

    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String[] temp = sc.readLine().trim().split("\\s+");
            int a1Size = Integer.parseInt(temp[0]);
            int a2Size = Integer.parseInt(temp[1]);
            int arrA1[] = new int[a1Size];
            int arrA2[] = new int[a2Size];
            String[] temp1 = sc.readLine().trim().split("\\s+");
            String[] temp2 = sc.readLine().trim().split("\\s+");
            for(int i = 0; i < a1Size; i++)
                arrA1[i] = Integer.parseInt(temp1[i]);
            for(int i = 0; i < a2Size; i++)
                arrA2[i] = Integer.parseInt(temp2[i]);
            
            relativeSort(a1Size,a2Size,arrA1,arrA2);
            System.out.println();
            n--;
        }


        }

    private static void relativeSort(int a1Size, int a2Size, int[] arrA1, int[] arrA2) {
        Map<Integer,Integer> a1Map = new HashMap<>();
        for(int i=0;i<a1Size;i++) {
            if(a1Map.containsKey(arrA1[i])) {
                a1Map.put(arrA1[i],a1Map.get(arrA1[i])+1);
            }
            else {
                a1Map.put(arrA1[i],1);
            }
        }
        List<Integer> outputList = new ArrayList<>();

        for(int i =0;i<a2Size;i++) {
            if(a1Map.containsKey(arrA2[i])) {
                int count = a1Map.get(arrA2[i]);
                while(count >0) {
                    outputList.add(arrA2[i]);
                    count--;
                }

            }
            a1Map.remove(arrA2[i]);
        }
        Map<Integer,Integer> sortedMap = new TreeMap<>(a1Map);

        for(Map.Entry mapElement : sortedMap.entrySet()) {
            int key = (int)mapElement.getKey();
            int value = (int)mapElement.getValue();
            while (value>0) {
                outputList.add(key);
                value--;
            }

        }

        outputList.stream().forEach(x -> System.out.print(x+" "));

        
    }
}