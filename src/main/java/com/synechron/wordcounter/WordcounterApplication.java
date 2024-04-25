package com.synechron.wordcounter;

import com.synechron.wordcounter.service.WordCounterService;
import com.synechron.wordcounter.util.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordcounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordcounterApplication.class, args);
	}
}
