package leetcode.random.random_exercise.account_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        
        data.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        data.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        data.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        data.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        data.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));
        
        new Solution().accountsMerge(data);
    }
}
