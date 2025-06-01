package leetcode.random.random_exercise.account_merge;
import java.util.*;

public class SolutionV2 {
    private List<List<String>> getMergedList(List<List<String>> emailsSet) {
        Set<String> set = new HashSet<>();
        for(List<String> emailSet : emailsSet) {
            for(String email : emailSet) {
                set.add(email);
            }
        }
        List<String> emailList = new ArrayList<>(set);
        UnionFind uf = new UnionFind(emailList);
        for(List<String> emailSet : emailsSet) {
            for(int i = 0; i < emailSet.size(); i++) {
                for(int j = i + 1; j < emailSet.size(); j++) {
                    uf.union(emailSet.get(i), emailSet.get(j));
                }
            }
        }
        Map<String, Set<String>> allDisjointSets = new HashMap<>();
        for(String email : emailList) {
            String emailRep = uf.find(email);
            if(!allDisjointSets.containsKey(emailRep)) {
                allDisjointSets.put(emailRep, new HashSet<>());
            }
            allDisjointSets.get(emailRep).add(email);
        }
        List<List<String>> disjointEmailList = new ArrayList<>();
        for(String key : allDisjointSets.keySet()) {
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