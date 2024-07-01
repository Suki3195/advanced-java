package codingQuestions;

import java.util.ArrayList;
import java.util.List;

public class MissingIntInArray {
    public static void main(String[] args) {

        int [] num_arr = {1,2,4,7,8,9};
        int count = num_arr[0];
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < num_arr.length ; i++) {
            if (count!=num_arr[i]){
                newList.add(count);
                i--;
            }
            count++;
        }
        System.out.println(newList);


    }
}
