package br.com.rodriguestech.languagesapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.rodriguestech.languagesapi.domain.entity.Language;

public interface LanguageRepository extends MongoRepository<Language, String>{
    
}
