package leetcode.daily_challenge.october_24.remove_sub_folders_from_the_filesystem_25;
import java.util.*;
class TrieNode {
    public String c;
    public Map<String, TrieNode> children;
    public String currentString;
    public boolean isEnd;
    public TrieNode(String c) {
        this.c = c;
        this.children = new HashMap<>();
        this.currentString = "";
        this.isEnd = false;
    }
}

public class Solution {
    private void insert(TrieNode root, String str) {
        if(str == null || str.isEmpty()) {
            return;
        }
        TrieNode itr = root;
        for(String c : str.split("/")) {
            if(c.isEmpty()) {
                continue;
            }
            if(!itr.children.containsKey(c)) {
                itr.children.put(c, new TrieNode(c));
            }
            itr.children.get(c).currentString = itr.currentString + "/" + c;
            itr = itr.children.get(c);
        }
        itr.isEnd = true;
        return;
    }
    private void traverse(TrieNode node, Set<String> folders) {
        if(node.isEnd) {
            folders.add(node.currentString);
            return;
        } else {
            for(String cKey: node.children.keySet()) {
                traverse(node.children.get(cKey), folders);
            }
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode("*");
        for(String fl : folder) {
            insert(root, fl);
        }
        Set<String> ans = new HashSet<>();
        traverse(root, ans);
        return new ArrayList<>(ans);
    }
}
