package hashing;

import java.util.*;

public class KeyBoardRow500 {
    public static void main(String[] args) {
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        findWords(input);
        Arrays.stream(findWords(input)).forEach(x -> System.out.println(x));

    }

    public static String[] findWords(String[] words) {
        Map<Character,Integer> characterIntegerMap = new HashMap<>();
        String row1="qwertyuiop".toUpperCase();
        String row2="asdfghjkl".toUpperCase();
        String row3="zxcvbnm".toUpperCase();

        populateData(row1,characterIntegerMap,1);
        populateData(row2,characterIntegerMap,2);
        populateData(row3,characterIntegerMap,3);
        List<String> outPutList = new ArrayList<>();

        for(int i=0;i<words.length;i++) {
            boolean validWord =true;
            String unformattedInput = words[i];
            String input = words[i].toUpperCase();
            int firstValue = characterIntegerMap.get(input.charAt(0));
            for(int k=1;k<input.length();k++) {
                Character character = input.charAt(k);
                int currentValue = characterIntegerMap.get(character);
                if(currentValue!=firstValue) {
                    validWord =false;
                }
            }
            if(validWord) {
                outPutList.add(unformattedInput);
            }

        }
        return outPutList.stream()
                .toArray(String[]::new);
    }

    public static void populateData(String row, Map characterIntegerMap, int value) {
        for(int i=0;i<row.length();i++) {
            Character c = row.charAt(i);
            characterIntegerMap.put(c,value);
        }

    }
}
