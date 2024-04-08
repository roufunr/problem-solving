package leetcode.two_thousand_24.trie.trie;

public class Runner {
    // ["Trie","insert","search","search","startsWith","insert","search"]
    // [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}
