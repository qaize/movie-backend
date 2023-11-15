package com.example.movies.DTO.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PaginationDTO {

    @Min(value = 1,message = "Minimal 1")
    private Integer page;
    @Min(value = 9,message = "Minimal 9")
    private Integer totalData;
}
