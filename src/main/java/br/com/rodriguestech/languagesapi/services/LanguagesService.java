package br.com.rodriguestech.languagesapi.services;

import org.springframework.stereotype.Service;

import br.com.rodriguestech.languagesapi.domain.dto.CreateLanguageRequest;
import br.com.rodriguestech.languagesapi.domain.dto.LanguageResponse;
import br.com.rodriguestech.languagesapi.domain.dto.UpdateLanguageRequest;
import br.com.rodriguestech.languagesapi.domain.entity.Language;
import br.com.rodriguestech.languagesapi.exceptions.LanguageNotFoundException;
import br.com.rodriguestech.languagesapi.repositories.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguagesService {
    private final LanguageRepository repository;

    public LanguagesService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<LanguageResponse> listAll() {
        var result = repository.findAll();
        return result.stream().map(language -> new LanguageResponse(
            language.getId(),
            language.getName(),
            language.getLogo(),
            language.getRanking()
        )).collect(Collectors.toList());
    }

    public LanguageResponse createLanguage(CreateLanguageRequest request) {
        var newLanguage = new Language();
        newLanguage.setName(request.getName());
        newLanguage.setLogo(request.getLogo());
        newLanguage.setRanking(request.getRanking());
        var saveLanguage = repository.save(newLanguage);

        return new LanguageResponse(
                saveLanguage.getId(),
                saveLanguage.getName(),
                saveLanguage.getLogo(),
                saveLanguage.getRanking()
        );
    }

    public LanguageResponse updateLanguage(String id, UpdateLanguageRequest request) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new LanguageNotFoundException();
        }

        var language = result.get();
        language.setLogo(request.getLogo());
        language.setRanking(request.getRanking());
        var saveLanguage = repository.save(language);

        return new LanguageResponse(
                saveLanguage.getId(),
                saveLanguage.getName(),
                saveLanguage.getLogo(),
                saveLanguage.getRanking()
        );
    }

    public LanguageResponse delete(String id) {
        var result = repository.findById(id);

        if(result.isEmpty()) {
            throw new LanguageNotFoundException();
        }

        Language language = result.get();
        repository.delete(language);

        return new LanguageResponse(
                language.getId(),
                language.getName(),
                language.getLogo(),
                language.getRanking()
        );
    }
}
