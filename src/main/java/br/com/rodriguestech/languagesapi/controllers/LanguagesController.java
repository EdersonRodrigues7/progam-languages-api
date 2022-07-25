package br.com.rodriguestech.languagesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodriguestech.languagesapi.domain.entity.Language;
import br.com.rodriguestech.languagesapi.repositories.LanguageRepository;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Language addLanguage(@RequestBody Language language){
        var newLanguage = repository.save(language);
        return newLanguage;
    }
}
