package br.com.rodriguestech.languages.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping(value="/languages")

    public List<Language> getLanguages(){
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping(value="/languages")
    public Language addLanguage(@RequestBody Language language){
        var newLanguage = repository.save(language);
        return newLanguage;
    }
}
