package leetcode.daily_challenge.word_break_II;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        new Solution().wordBreak(s, wordDict);
    }
}
