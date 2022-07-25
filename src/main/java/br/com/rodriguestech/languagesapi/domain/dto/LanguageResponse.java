package br.com.rodriguestech.languagesapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LanguageResponse {
    private String id;
    private String name;
    private String logo;
    private Integer ranking;
}
