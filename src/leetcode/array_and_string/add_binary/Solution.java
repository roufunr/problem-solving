package leetcode.array_and_string.add_binary;

public class Solution {
    //https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
    public String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int aLen =  aArr.length;
        int bLen = bArr.length;
        int maxPossibleLen = aLen > bLen ? aLen + 1 : bLen + 1;
        char[] sum = new char[maxPossibleLen];
        maxPossibleLen--;
        aLen--;
        bLen--;
        int carryIn = 0;
        do {
            int aBit = 0;
            int bBit = 0;
            if(aLen >= 0) {
                aBit = aArr[aLen] - '0';
                aLen--;
            }
            if(bLen >= 0) {
                bBit = bArr[bLen] - '0';
                bLen--;
            }
            int s = aBit + bBit + carryIn;

            int so = s == 0? 0 : s % 2;
            carryIn = s == 0? 0 : s / 2;
            sum[maxPossibleLen] = (char)('0' + so);
            maxPossibleLen--;
        }while(maxPossibleLen >= 0);
        String output = null;
        if(sum[0] == '0') {
            output = new String(sum);
            output = output.substring(1);

        } else {
            output = new String(sum);
        }
//        System.out.println(Integer.parseInt(a, 2));
//        System.out.println(Integer.parseInt(b, 2));
//        System.out.println(Integer.parseInt(output, 2));
        return output;
    }
}
