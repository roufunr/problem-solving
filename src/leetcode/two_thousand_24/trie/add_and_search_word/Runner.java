package leetcode.two_thousand_24.trie.add_and_search_word;

public class Runner {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}

// ["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
// [[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
// [null,null,null,true,true,false,true,false,false]