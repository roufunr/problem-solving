package leetcode.random.random_exercise.account_merge;
import java.util.*;
class UnionFind {
    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int i) { // it should return the representative
        if(parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }
    public void union(int i, int j) {
        int irep = find(i);
        parent[i] = irep;
        int jrep = find(j);
        parent[j] = jrep;
        parent[irep] = jrep;
    }
}


public class Solution {
    private List<List<String>> getMergedList(List<List<String>> emailsSet) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> emailIdxMap = new HashMap<>();
        for(List<String> emailSet : emailsSet) {
            for(String email : emailSet) {
                set.add(email);
            }
        }
        List<String> emailList = new ArrayList<>(set);
        for(int i = 0; i < emailList.size(); i++) {
            emailIdxMap.put(emailList.get(i), i);
        }
        UnionFind uf = new UnionFind(emailList.size());
        for(List<String> emailSet : emailsSet) {
            for(int i = 0; i < emailSet.size(); i++) {
                for(int j = i + 1; j < emailSet.size(); j++) {
                    uf.union(emailIdxMap.get(emailSet.get(i)), emailIdxMap.get(emailSet.get(j)));
                    // uf.union(emailIdxMap.get(emailSet.get(j)), emailIdxMap.get(emailSet.get(i)));
                }
            }
        }
        Map<Integer, Set<String>> allDisjointSets = new HashMap<>();
        for(int i = 0; i < emailList.size(); i++) {
            int irep = uf.find(i);
            if(!allDisjointSets.containsKey(irep)) {
                allDisjointSets.put(irep, new HashSet<>());
            }
            allDisjointSets.get(irep).add(emailList.get(i));
        }
        List<List<String>> disjointEmailList = new ArrayList<>();
        for(Integer key : allDisjointSets.keySet()) {
            List<String> emails = new ArrayList<>(allDisjointSets.get(key));
            Collections.sort(emails);
            disjointEmailList.add(emails);
        }
        return disjointEmailList;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> maps = new HashMap<>();
        for(List<String> account : accounts) {
            String name = account.get(0);
            List<String> emails = new ArrayList<>();
            for(int i = 1; i < account.size(); i++) {
                emails.add(account.get(i));
            }
            if(!maps.containsKey(name)) {
                maps.put(name, new ArrayList<>());
            }
            maps.get(name).add(emails);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String name : maps.keySet()) {
            List<List<String>> disjointEmailLists = getMergedList(maps.get(name));
            for(List<String> emailList : disjointEmailLists) {
                List<String> newList = new ArrayList<>();
                newList.add(name);
                newList.addAll(emailList);
                ans.add(newList);
            }
        }
        return ans;
    }
}