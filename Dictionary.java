package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Dictionary {

    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();

        add("car", "عربة");
    }

    public String get(String foreignWord) {
        return this.translations.get(foreignWord);
    }

    public void add(String foreignword, String translation) {
        if (!this.translations.containsKey(foreignword)) {
            this.words.add(foreignword);
        }

        this.translations.put(foreignword, translation);
    }

    public String getRandomWords() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
    public boolean correct(String foreignWord , String userWord){
        if(translations.get(foreignWord).equals(userWord)){
            return true;
        }
        return false;
    }


}