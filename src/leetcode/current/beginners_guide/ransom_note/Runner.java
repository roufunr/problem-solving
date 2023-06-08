package leetcode.current.beginners_guide.ransom_note;

public class Runner {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";
        System.out.println(new Solution().canConstruct(ransomNote, magazine));

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(new Solution().canConstruct(ransomNote, magazine));
    }
}
