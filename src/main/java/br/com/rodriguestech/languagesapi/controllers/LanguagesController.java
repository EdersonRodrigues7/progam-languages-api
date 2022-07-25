package br.com.rodriguestech.languagesapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import br.com.rodriguestech.languagesapi.domain.dto.CreateLanguageRequest;
import br.com.rodriguestech.languagesapi.domain.dto.LanguageResponse;
import br.com.rodriguestech.languagesapi.domain.dto.UpdateLanguageRequest;
import br.com.rodriguestech.languagesapi.services.LanguagesService;

@RestController
public class LanguagesController {
    private final LanguagesService service;

    public LanguagesController(LanguagesService service) {
        this.service = service;
    }

    public ResponseEntity<List<LanguageResponse>>  getAll() {
        var result = service.listAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping(value="/languages")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LanguageResponse> create(@RequestBody @Valid CreateLanguageRequest request) {
        var result = service.createLanguage(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/languages/{id}")
    public ResponseEntity<LanguageResponse> update(
            @PathVariable("id") String id,
            @RequestBody @Valid UpdateLanguageRequest updateRequest) {
        var language = service.updateLanguage(id, updateRequest);
        return ResponseEntity.ok(language);
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<LanguageResponse> delete(@PathVariable("id") String id) {
        var language = service.delete(id);
        return ResponseEntity.ok(language);
    }
}
