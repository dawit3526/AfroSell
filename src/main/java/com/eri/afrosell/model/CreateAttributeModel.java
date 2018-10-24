package com.eri.afrosell.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAttributeModel {


    @JsonProperty("attributeId")
    private Long attributeId;
    @JsonProperty("companyId")
    private int companyId;
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("valueNumberic")
    private double valueNumberic;
    @JsonProperty("valueString")
    private String valueString;


}
