package external_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cay {
    static int[] solution(int[] arr) {
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            if(arr[i]!=-1)
                list.add(arr[i]);
        }
        Collections.sort(list);
        for (int i=0;i<arr.length;i++) {
            if(arr[i]==-1){
                list.add(i,-1);
            }
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 150, 190, 170, -1, -1, 160, 180};

        System.out.println(Arrays.toString(solution(arr)));
    }
}
