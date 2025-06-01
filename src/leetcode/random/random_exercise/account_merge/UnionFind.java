package leetcode.random.random_exercise.account_merge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {
    private Map<String, String> parent;
    public UnionFind(List<String> emails) {
        parent = new HashMap<>();
        for(String email : emails) {
            parent.put(email, email);
        }
    }
    public String find(String email) {
        if(!parent.get(email).equals(email)) {
            parent.put(email, find(parent.get(email)));
        }
        return parent.get(email);
    }
    public void union(String email1, String email2) {
        String repEmail1 = find(email1);
        String repEmail2 = find(email2);
        if(!repEmail1.equals(repEmail2)) {
            parent.put(repEmail1, repEmail2);
        }
    }
}