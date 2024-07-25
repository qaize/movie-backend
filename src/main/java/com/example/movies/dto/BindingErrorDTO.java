package com.example.movies.dto;

import lombok.*;


@NoArgsConstructor
@Getter @Setter
public class BindingErrorDTO {

    private String property;
    private String message;

    @Builder
    public BindingErrorDTO(String property,String message){
        this.property = property;
        this.message = message;
    }

}
