package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount811 {

    public static void main(String[] args) {
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List outPutList = subdomainVisits(input);
        outPutList.forEach(i -> System.out.println(i));

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> domainMap = new HashMap<>();
        for(String s:cpdomains) {
            String splittedString[] = s.split("\\s+");
            int value = Integer.parseInt(splittedString[0]);
            String domain = splittedString[1];
            String[] splitDomain = domain.split("\\.");

            for(int i=splitDomain.length-1;i>=0;i--) {

                String domainValue="";
                if(i==splitDomain.length-1) {
                    domainValue = splitDomain[i];
                }
                else {
                    for(int j=i;j<=splitDomain.length-1;j++) {
                        domainValue = domainValue+splitDomain[j] + ".";
                    }
                    domainValue = domainValue.substring(0,domainValue.length()-1);
                }
                    if(domainMap.containsKey(domainValue)) {
                        domainMap.put(domainValue,domainMap.get(domainValue)+value);
                    }
                    else {
                        domainMap.put(domainValue,value);
                    }

            }


        }
        List<String> outputList = new ArrayList<>();

        domainMap.forEach((k,v) ->
                outputList.add(v +" "+k));
        return outputList;

    }
}
