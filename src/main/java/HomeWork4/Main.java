package HomeWork4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Apple", "Orange", "Potato", "Apple"};
        HashMap<String, Integer> wordsUniqueWithRepeats = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (wordsUniqueWithRepeats.containsKey(words[i])) {
                wordsUniqueWithRepeats.put(words[i], wordsUniqueWithRepeats.get(words[i]) + 1);
            } else {
                wordsUniqueWithRepeats.put(words[i], 1);
            }
        }

        System.out.println(wordsUniqueWithRepeats);

    }
}
