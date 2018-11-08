package com.eri.afrosell.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyModel {
    @JsonProperty("companyId")
    private Long companyId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private int status;
}
