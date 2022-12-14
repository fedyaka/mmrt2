package org.example;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

@Component
public class DictionaryLatin extends Dictionary<String, String>{

    public DictionaryLatin(String pathToDictionary) throws FileNotFoundException {
        super(pathToDictionary);
    }


    public String findByKey(String key) throws IllegalArgumentException{
        checkEntryRules(key);
        return super.findByKey(key);

    }

    public String putWord(String key, String value) throws IllegalArgumentException{
        checkEntryRules(key);
        checkEntryRules(value);
        return super.putWord(key, value);
    }

    public String deleteByKey(String key) throws IllegalArgumentException{
        checkEntryRules(key);
        return super.deleteByKey(key);
    }


    private boolean checkEntryRules(String wordTested) throws IllegalArgumentException{
        String pattern = "^[a-zA-Z]{4}$";
        if (Pattern.matches(pattern, wordTested)){
            return true;
        }
        throw new IllegalArgumentException("Введи слово по правилам, будь человеком :)");
    }
}
