package com.example.movies.dto.response;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class MovieDTO {
    private Integer id;
    private String title;
}
