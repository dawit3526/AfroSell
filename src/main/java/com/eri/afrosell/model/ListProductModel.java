/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author acer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductModel {
    @JsonProperty("categoryId")
    private long categoryId;
    @JsonProperty("attributeId")
    private long attributeId;
    @JsonProperty("companyId")
    private long companyId;
    @JsonProperty("searchKey")
    private String searchKey;
    @JsonProperty("minPrice")
    private Double minPrice;
    @JsonProperty("maxPrice")
    private Double maxPrice;
    @JsonProperty("minRank")
    private int minRank;
    @JsonProperty("maxRank")
    private int maxRank;
    @JsonProperty("sortCase")
    private int sortCase;
    @JsonProperty("ascSort")
    private Boolean ascSort;
    @JsonProperty("pageNumber")
    private int pageNumber;
    @JsonProperty("pageSize")
    private int pageSize;



}
