package com.synechron.wordcounter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to store word count.
 * Using Singleton design pattern so that consistency is maintained for word count map.
 */
@Component
public class WordCounter {

    Logger logger = LoggerFactory.getLogger(WordCounter.class);
    private static WordCounter instance;
    //Making wordcount map as final so that its original values aren't updated.
    private final Map<String, Integer> wordCounterMap;
    private Translater translater;

    private WordCounter() {
        wordCounterMap = new HashMap<>();
    }

    public Map<String, Integer> getWordCounterMap() {
        return wordCounterMap;
    }

    public static WordCounter getInstance() {
        if (instance == null) {
            // To make WordCounter class as thread-safe
            synchronized (WordCounter.class) {
                if (instance == null) {
                    instance = new WordCounter();
                }
            }
        }
        return instance;
    }

    public void addWord(String... words) {
        for(String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                String englishWord = translator.translate(word);
                wordCounterMap.put(englishWord, wordCounterMap.getOrDefault(englishWord, 0) + 1);
            } else {
                logger.error(word + "is contains characters other than alphabets, hence it is not added to the word counter");
            }
        }
    }

    public int getCount(String word) {
        String englishWord = translator.translate(word);
        return wordCounterMap.getOrDefault(englishWord, 0);
    }
}


