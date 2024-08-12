package com.example.movies.dto.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class MovieDTO {
    @NonNull
    @Min(value = 1,message = "Number must more than 1")
    private Integer id;

    private String title;
}
