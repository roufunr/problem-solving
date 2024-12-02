package leetcode.daily_challenge.december_24.check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence_02;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // List to store the words from the sentence
        List<String> wordsList = new ArrayList<>();
        // StringBuilder to build the current word
        StringBuilder currentWord = new StringBuilder();

        // Iterate through each character in the sentence
        for (char character : sentence.toCharArray()) {
            if (character != ' ') {
                // Append the character to the current word
                currentWord.append(character);
            } else {
                // If we encounter a space, add the current word to the list
                if (currentWord.length() > 0) {
                    wordsList.add(currentWord.toString());
                    currentWord.setLength(0); // Reset the StringBuilder
                }
            }
        }
        // Add the last word if the sentence doesn't end with a space
        if (currentWord.length() > 0) {
            wordsList.add(currentWord.toString());
        }

        // Iterate through the list of words to find the prefix match
        for (int wordIndex = 0; wordIndex < wordsList.size(); ++wordIndex) {
            String word = wordsList.get(wordIndex);
            if (word.length() >= searchWord.length()) {
                boolean isMatch = true;
                for (
                    int charIndex = 0;
                    charIndex < searchWord.length();
                    ++charIndex
                ) {
                    if (
                        word.charAt(charIndex) != searchWord.charAt(charIndex)
                    ) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return wordIndex + 1; // Return 1-based index
                }
            }
        }
        return -1; // Return -1 if no match is found
    }
}
