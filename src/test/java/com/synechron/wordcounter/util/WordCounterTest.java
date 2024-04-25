package com.synechron.wordcounter.util;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class WordCounterTest {

    @Mock
    private Translator translator;
    @Mock
    private Logger logger;
    private WordCounter wordCounter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        wordCounter = WordCounter.getInstance();
        wordCounter.getWordCounterMap().put("apple", 3);
        wordCounter.getWordCounterMap().put("banana", 2);
        wordCounter.getWordCounterMap().put("orange", 0);
    }

    @Test
    public void testAddWord_ValidWord() {
        String word = "apple";
        when(translator.translate(word)).thenReturn(word);
        wordCounter.addWord(word);
        verify(logger, never()).error(anyString());
        assertEquals(1, wordCounter.getCount(word));
    }

    @Test
    public void testAddWord_NonAlphabeticWord() {
        String word = "123word";
        wordCounter.addWord(word);
        verify(logger).error(word + " contains characters other than alphabets, hence it is not added to the word counter");
        assertEquals(0, wordCounter.getCount(word));
    }

    @Test
    public void testGetCount_ExistingWord() {
        String word = "apple";
        when(translator.translate(word)).thenReturn(word);
        int count = wordCounter.getCount(word);
        assertEquals(3, count);
    }

    @Test
    public void testGetCount_NonExistingWord() {
        String word = "orange"; // Non-existent word
        int count = wordCounter.getCount(word);
        assertEquals(0, count);
    }
}
