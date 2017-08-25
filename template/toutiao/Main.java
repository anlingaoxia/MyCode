package toutiao;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int maxX = 0, maxY = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > maxX && y > maxY) {
                maxX = x;
                maxY = y;
            }
            if (y > map.getOrDefault(x, -1)) {
                map.put(x, y);
            }
        }

        Set<Integer> keyset = new HashSet<>(map.keySet());
        List<Integer> list = new ArrayList<>(keyset);
        Collections.sort(list);
        Collections.reverse(list);
        int mY = -1;
        for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
            int x = iter.next();
            int y = map.get(x);
            if (y > mY) {
                mY = y;
            } else {
                iter.remove();
            }
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            System.out.println(x + " " + map.get(x));
        }
    }
}
