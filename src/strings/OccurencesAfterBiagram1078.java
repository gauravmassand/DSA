package strings;

import java.util.ArrayList;
import java.util.List;

public class OccurencesAfterBiagram1078 {


    public static void main(String[] args) {
        String[] output = findOcurrences("we will we will rock you","we","will");
        System.out.println(output);

    }


    public static String[] findOcurrences(String text, String first, String second) {
        List<String> outputList = new ArrayList<>();
        String[] splitText= text.split("\\s+");
        for(int i=0;i<splitText.length-2;i++) {
            if(splitText[i].equals(first) && splitText[i+1].equals(second)) {
                outputList.add(splitText[i+2]);
                i++;
            }
        }
        return outputList.toArray(new String[0]);


    }


}
