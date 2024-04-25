package com.synechron.wordcounter.controller;

import com.synechron.wordcounter.service.WordCounterService;
import com.synechron.wordcounter.service.WordCounterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordCounterController {

    @Autowired
    private WordCounterServiceImpl wordCounterServiceimpl;

//    @Autowired
//    WordCounterController(WordCounterServiceImpl wordCounterServiceimpl) {
//        this.wordCounterServiceimpl = wordCounterServiceimpl;
//    }

    @PostMapping("/words")
    public void addWords(@RequestBody String[] words) {
        wordCounterServiceimpl.addWords(words);
    }

    @GetMapping("/words/count/{word}")
    public int getCount(@PathVariable String word) {
        return wordCounterServiceimpl.getCount(word);
    }


}
