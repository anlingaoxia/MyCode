package transform.easy;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        get(list, 0, numRows);
        return list;
    }

    public static void get(List<List<Integer>> list, int ceil, int numRows) {
        if (ceil > numRows - 1) {
            return;
        }
        if (ceil == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        List<Integer> temp = list.get(ceil);
        temp.add(1);
        if (ceil > 1) {
            List<Integer> last = list.get(ceil - 1);
            for (int i = 0; i < ceil - 1; i++) {
                temp.add(last.get(i) + last.get(i + 1));
            }
        }
        if (ceil >= 1) {
            temp.add(1);
        }

        get(list, ceil + 1, numRows);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        get(list, 0, 2);
        System.out.println(list);

    }
}
