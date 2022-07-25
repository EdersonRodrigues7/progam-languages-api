package br.com.rodriguestech.languagesapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateLanguageRequest {
    @NotEmpty(message = "Language name cannot be empty")
    private String name;

    @NotEmpty(message = "Language logo cannot be empty")
    private String logo;

    private int ranking;
}
