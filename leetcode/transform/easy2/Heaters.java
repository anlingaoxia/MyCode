package transform.easy2;

public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        
        
        
        
        
        
        
        
        
        return 0;
    }

    public static boolean check(int[] temp, int[] houses) {
        for (int i : houses) {
            if (temp[i -1] == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] houses = { 1, 2, 3 };
        int[] heaters = { 2 };
        System.out.println(findRadius(houses, heaters));
        
        
    }

}
