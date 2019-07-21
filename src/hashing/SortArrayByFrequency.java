package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortArrayByFrequency {
    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while(n != 0)
        {
            int size = Integer.parseInt(sc.readLine());
            int arr[] = new int[size];
            String[] temp = sc.readLine().trim().split("\\s+");

            for(int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(temp[i]);

            sortByFreq(arr, size);
            System.out.println();
            n--;
        }
    }

    static void sortByFreq(int arr[], int n)
    {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i],frequencyMap.get(arr[i])+1);
            }
            else {
                frequencyMap.put(arr[i],0);
            }
        }

        List<Map.Entry<Integer,Integer>> set = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(set,new comparator());

        for(int i = 0;i<frequencyMap.size();i++)
        {
            int count = set.get(i).getValue();
            while(count >= 0)
            {
                System.out.print(set.get(i).getKey() + " ");
                count -- ;
            }
        }


    }
}

class comparator implements Comparator<Map.Entry<Integer,Integer>>
{

    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
    {
        if(o1.getValue() > o2.getValue())
            return -1;
        else if(o1.getValue() == o2.getValue())
            return 0;
        else if(o1.getValue() < o2.getValue())
            return 1;

        return Integer.MIN_VALUE;
    }

}

