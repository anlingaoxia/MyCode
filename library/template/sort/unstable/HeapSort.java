package sort.unstable;

import java.util.Arrays;

//堆排序要点
//1.last从1到length-1
//2.已知last的情况下,从last的父节点前向遍历到根节点.
//3.每次遍历进行f和c(2*f+1)的判断.(需要将以f为根节点的整个树都规整,因此如果有一个节点的f和c进行互换,需要对真个子树都进行规整)
public class HeapSort {
    public static void sort(int[] nums) {
        for (int last = nums.length - 1; last > 0; last--) {
            sortOnce(nums, last);
            swap(nums, 0, last);
        }
    }

    public static void sortOnce(int[] nums, int last) {
        for (int f = (last - 1) / 2; f >= 0; f--) {
            sortSubOnce(nums, f, 2 * f + 1, last);
        }
    }

    public static void sortSubOnce(int[] nums, int f, int c, int last) {
        while (c <= last) {
            if (c < last && nums[c] < nums[c + 1]) {
                c++;
            }
            if (nums[c] > nums[f]) {
                swap(nums, c, f);
                f = c;
                c = 2 * f + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 8, 9, 4, 5, 1, 2, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
