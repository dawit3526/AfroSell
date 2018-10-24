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

import java.util.List;

/**
 *
 * @author acer
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductModel {
    @JsonProperty("productId")
    private long productId;
    @JsonProperty("companyId")
    private long companyId;
    @JsonProperty("listCategoriesId")
    private List<Long> listCategoriesId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("browsingName")
    private String browsingName;
    @JsonProperty("salePrice")
    private double salePrice;
    @JsonProperty("listPrice")
    private double listPrice;
    @JsonProperty("defaultImage")
    private String defaultImage;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("isStockControlled")
    private Boolean isStockControlled;
    @JsonProperty("description")
    private String description;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("sku")
    private String sku;
}
