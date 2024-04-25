package com.synechron.wordcounter.config;

import com.synechron.wordcounter.util.WordCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfig {

    @Bean
    public WordCounter wordCounter() {
        return WordCounter.getInstance();
    }
}
