package transform.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Binary_Watch {
    public static class TempString implements Comparable<TempString> {
        int h;
        int m;

        TempString(int h, int m) {
            this.h = h;
            this.m = m;
        }

        @Override
        public int compareTo(TempString o) {
            return this.h == o.h ? this.m - o.m : this.h - o.h;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TempString && this.h == ((TempString) obj).h && this.m == ((TempString) obj).m) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            String hString = String.valueOf(h);
            String mString = m < 10 ? "0" + String.valueOf(m) : String.valueOf(m);
            return hString + ":" + mString;
        }

    }

    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        List<TempString> sort = new ArrayList<>();
        if (num < 0 || num > 10) {
            return result;
        }
        int hAll = 4;
        int mAll = 6;
        for (int i = 0; i <= mAll && i <= num; i++) {
            int hNum = i;
            int mNum = num - i;
            List<int[]> hList = new ArrayList<>();
            List<int[]> mList = new ArrayList<>();
            getCombinations(hList, new int[hAll], hAll, hNum, 0, hNum);
            getCombinations(mList, new int[mAll], mAll, mNum, 0, mNum);
            for (int[] hTemp : hList) {
                int hMult = 0;
                for (int j = 0; j < hTemp.length; j++) {
                    hMult += hTemp[j] * Math.pow(2, j);
                }
                for (int[] mTemp : mList) {
                    int mMult = 0;
                    for (int k = 0; k < mTemp.length; k++) {
                        mMult += mTemp[k] * Math.pow(2, k);
                    }
                    if(hMult < 12 && mMult < 60) {
                        sort.add(new TempString(hMult, mMult));
                    }
                }
            }
        }
        Collections.sort(sort);
        for (TempString tempString : sort) {
            result.add(tempString.toString());
        }
        return result;
    }

    public static void getCombinations(List<int[]> list, int[] array, int n, int k, int start, int last) {
        if (last-- > 0) {
            for (int i = start; i < n - last; i++) {
                int[] temp = new int[n];
                System.arraycopy(array, 0, temp, 0, array.length);
                temp[i] = 1;
                getCombinations(list, temp, n, k, i + 1, last);
            }
        } else {
            list.add(array);
        }
    }

    public static int countMult(int n, int k) {
        double up = 1;
        double down = 1;
        for (int i = n, j = 1; i > n - k; i--, j++) {
            up *= i;
            down *= j;
        }
        return (int) (up / down);
    }

    public static void main(String[] args) {
//        int mAll = 4;
//        int mNum = 2;
//        List<int[]> mList = new ArrayList<>();
//        getCombinations(mList, new int[mAll], mAll, mNum, 0, mNum);
//        System.out.println(mList.size());
//        for (int i = 0; i < mList.size(); i++) {
//            int[] temp = mList.get(i);
//            System.out.println(Arrays.toString(temp));
//        }
         System.out.println(readBinaryWatch(2));
    }

}
