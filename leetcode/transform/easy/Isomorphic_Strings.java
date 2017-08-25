package transform.easy;

import java.util.*;

public class Isomorphic_Strings {
    public static boolean isIsomorphic2(String s, String t) {
        HashMap<Integer, List<Integer>> sMap = new HashMap<>();
        HashMap<Integer, List<Integer>> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> sList = sMap.getOrDefault((int) s.charAt(i), new ArrayList<Integer>());
            List<Integer> tList = tMap.getOrDefault((int) t.charAt(i), new ArrayList<Integer>());
            sList.add(i);
            tList.add(i);
            sMap.put((int) s.charAt(i), sList);
            tMap.put((int) t.charAt(i), tList);
        }
        for (Iterator<Map.Entry<Integer, List<Integer>>> i = sMap.entrySet().iterator(); i.hasNext();) {
            List<Integer> sList = i.next().getValue();
            if (sList.size() > 1) {
                boolean hasSame = false;
                tag: for (Iterator<Map.Entry<Integer, List<Integer>>> j = tMap.entrySet().iterator(); j.hasNext();) {
                    List<Integer> tList = j.next().getValue();
                    if (tList.size() == sList.size()) {
                        for (int k = 0; k < sList.size(); k++) {
                            if (tList.get(k) != sList.get(k)) {
                                continue tag;
                            }
                        }
                        hasSame = true;
                        i.remove();
                        j.remove();
                        break;
                    }
                }
                if (!hasSame) return false;
            }
        }
        for (List<Integer> tList : tMap.values()) {
            if (tList.size() > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] sHash = new int[128];
        int[] tHash = new int[128];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(sHash));
            System.out.println(Arrays.toString(tHash));
            System.out.println(sHash[(int) sChars[i]]);
            System.out.println(tHash[(int) tChars[i]]);
            System.out.println();
            if (sHash[sChars[i]] != tHash[tChars[i]]) {
                return false;
            }
            sHash[sChars[i]] += i + 1;
            tHash[tChars[i]] += i + 1;
        }
        return true;
    }

    public static boolean get(HashMap<Integer, List<Integer>> sMap, HashMap<Integer, List<Integer>> tMap, char[] sChars, char[] tChars, int n) {
        if (n == sChars.length) {
            return true;
        }
        List<Integer> sList = sMap.getOrDefault((int) sChars[n], new ArrayList<>());
        List<Integer> tList = tMap.getOrDefault((int) tChars[n], new ArrayList<>());
        if (sList.size() != tList.size()) {
            return false;
        } else if (sList.size() != 0) {
            for (int i = 0; i < sList.size(); i++) {
                if ((int) sList.get(i) != (int) tList.get(i)) {
                    return false;
                }
            }
        }
        sList.add(n);
        tList.add(n);
        sMap.put((int) sChars[n], sList);
        tMap.put((int) tChars[n], tList);
        return get(sMap, tMap, sChars, tChars, n + 1);
    }

    public static void main(String[] args) {

        // System.out.println(s1.length());
        System.out.println(isIsomorphic("abc", "cde"));
    }

}
