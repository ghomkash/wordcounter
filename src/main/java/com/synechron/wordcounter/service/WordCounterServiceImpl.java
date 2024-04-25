package com.synechron.wordcounter.service;

import com.synechron.wordcounter.util.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordCounterServiceImpl implements WordCounterService {

    private WordCounter wordCounter;

    @Autowired
    public WordCounterServiceImpl(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }


    @Override
    public void addWords(String... words) {
        wordCounter.addWord(words);
    }

    @Override
    public int getCount(String word) {
        return wordCounter.getCount(word);
    }
}
