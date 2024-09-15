package solutions;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToTheEnd implements ISolution{
    @Override
    public void solve() {
        System.out.println(moveElementToEnd(List.of(1,2,1), 2));
    }

    public static List<Integer> moveElementToEnd(
            List<Integer> array, int toMove
    ) {
        int left = 0;
        array = new ArrayList<>(array);
        for (int i = 0 ; i < array.size() ; i++) {
            if (array.get(i) != toMove) {
                int temp = array.get(i);
                array.set(i, array.get(left));
                array.set(left, temp);
                left++;
            }
        }
        return array;
    }
}
