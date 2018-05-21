package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N022 {
    public static List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> h0 = new ArrayList<>();
        List<String> h1 = new ArrayList<>();
        h0.add("");
        h1.add("()");
        map.put(0, h0);
        map.put(1, h1);
        if (n < 2) return map.getOrDefault(n, null);
        for (int i = 2; i <= n; i++) {
            generateNext(map, i);
        }
        return map.get(n);
    }

    public static void generateNext(Map<Integer, List<String>> map, int n) {
        List<String> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> a = map.get(i);
            List<String> b = map.get(n - 1 - i);
            for (String sp : a) {
                String s1 = "(" + sp + ")";
                for (String s2 : b) {
                    nList.add(s1 + s2);
                }
            }
        }
        map.put(n, nList);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<String>();
//        char[] arr = new char[2*n];
//        arr[0] = '('; arr[arr.length-1] = ')';
//
//        helper(arr, 1, 1, 1, n, res);
//
//        return res;
//    }
//
//    private void helper(char[] arr, int index, int pairCount, int leftCount,int n, List<String> res) {
//        if(index == arr.length - 1) {
//            res.add(new String(arr));
//            return;
//        }
//
//        if(leftCount < n) {
//            arr[index] = '(';
//            helper(arr, index+1, pairCount+1, leftCount+1, n, res);
//        }
//
//        if(pairCount != 0){
//            arr[index] = ')';
//            helper(arr, index+1, pairCount-1, leftCount, n, res);
//        }
//    }

}
