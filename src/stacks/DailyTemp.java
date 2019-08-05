package stacks;
/*
739. Daily Temperatures
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].


 */
import java.util.Stack;

class Temp {
    int temp;
    int index;
    Temp(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }
}


public class DailyTemp {
    public static void main(String[] args) {
        int [] ip= {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(ip);

    }

    public static int[] dailyTemperatures(int[] T) {
        Stack<Temp> stackMap = new Stack<>();
        int [] output = new int[T.length];

        for(int i=0;i<T.length;i++) {
            Temp temp = new Temp(T[i],i);
            if(stackMap.isEmpty()) {
                stackMap.push(temp);
            }
            else {
                int topElement = stackMap.peek().temp;
                if(topElement > T[i]) {
                    stackMap.push(temp);
                }
                else {
                    while(!stackMap.isEmpty() && stackMap.peek().temp<T[i]) {
                        topElement = stackMap.peek().temp;
                        if(topElement < T[i]) {
                            Temp tempElement =stackMap.pop();
                            output[tempElement.index] =i-tempElement.index;
                        }
                    }
                    stackMap.push(temp);
                }
            }

        }
        for(int i=0;i<stackMap.size();i++) {
            Temp tempElement = stackMap.pop();
            output[tempElement.index]=0;
        }
        return output;

    }
}
