package transform.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Most_Frequent_Subtree_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        String out = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                out += "%20";
                continue;
            }
            out += chars[i];
        }
        return out;
        
        
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        String string = "";
        string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer("123");
        stringBuffer.append('c');
        stringBuffer.toString().toCharArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        get(map, root);
        ArrayList<Integer> list = new ArrayList<>();
        int currentCount = 0;
        Set<Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            if (list.isEmpty()) {
                currentCount = entry.getValue();
                list.add(entry.getKey());
            } else if (entry.getValue() == currentCount) {
                list.add(entry.getKey());
            } else if (entry.getValue() > currentCount) {
                list.clear();
                currentCount = entry.getValue();
                list.add(entry.getKey());
            }
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }

        return temp;
    }

    public int get(HashMap<Integer, Integer> map, TreeNode node) {
        if (node == null) return 0;
        int left = get(map, node.left);
        int right = get(map, node.right);
        int val = left + right + node.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }

}
