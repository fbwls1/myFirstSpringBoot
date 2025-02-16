package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoffeeDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}
