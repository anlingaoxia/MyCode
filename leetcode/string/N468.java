package string;

import java.util.Arrays;

public class N468 {
    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
    }

    public static String validIPAddress(String IP) {
        int mode = checkStr(IP);
        System.out.println(mode);
        if (mode == 1 && isIPV4(IP)) {
            return "IPv4";
        } else if (mode == 2 && isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    //split对于最后一个regex来说，如果后边没有除了regex的内容，则舍去所有之后对regex的匹配结果如果“：：：”那么这三个’：‘等于会被全部舍弃
    public static int checkStr(String str) {
        if (str.length() < 7) return -1;
        int mode = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 70 || c >= 97 && c <= 102) {
                if (mode == 0) mode = 2;
            } else if (c == '.') {
                if (mode == 0) mode = 1;
                else if (mode == 2) mode = -1;
            } else if (c == ':') {
                if (mode == 0) mode = 2;
                else if (mode == 1) mode = -1;
            } else if (c < 48 || c > 57) {
                mode = -1;
            }
            if (mode == -1) return mode;
        }
        char c = str.charAt(str.length() - 1);
        if (c == '.' || c == ':') mode = -1;
        return mode == 0 ? -1 : mode;
    }

    public static boolean isIPV4(String str) {
        String[] segments = str.split("\\.");
        if (segments.length != 4) return false;
        for (String s : segments) {
            if (s.equals("")) return false;
            if (s.length() > 3 || Integer.parseInt(s) > 255) return false;
            if (s.length() > 1 && s.startsWith("0")) return false;
        }
        return true;
    }

    public static boolean isIPV6(String str) {
        String[] segments = str.split(":");
        if (segments.length != 8) return false;
        for (String s : segments) {
            if (s.equals("")) return false;
            if (s.length() > 4) return false;
        }
        return true;
    }


}
