package others.random;

public class JavaString {
    public static void main(String[] args) {
        System.out.println(getSpecialString("xxf"));
    }

    public static String getSpecialString(String str) {
        int len = str.length();
        String ans = "";
        for(int i = 0; i < len; i++) {
            if(i == 0) {
                if(str.charAt(i) == 'a') {
                    ans = ans + "a";
                }
            } else if(i == 1) {
                if(str.charAt(i) == 'b') {
                    ans = ans + "b";
                }
            } else {
                ans = ans + str.charAt(i);
            }
        }
        return ans;
    }
}
