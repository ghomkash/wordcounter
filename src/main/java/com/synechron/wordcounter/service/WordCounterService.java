package com.synechron.wordcounter.service;

public interface WordCounterService {
    void addWords(String... words);
    int getCount(String word);
}
