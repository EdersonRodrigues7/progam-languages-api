package br.com.rodriguestech.languagesapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateLanguageRequest {
    @NotEmpty(message = "Por favor, informe a url da imagem")
    private String logo;

    private Integer ranking;
}

