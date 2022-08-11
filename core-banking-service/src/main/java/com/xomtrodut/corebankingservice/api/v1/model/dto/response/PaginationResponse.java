package com.xomtrodut.corebankingservice.api.v1.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaginationResponse<T> {
    private List<T> data;
    private Integer currentPage;
    private Integer totalItems;
    private Integer totalPages;
}
