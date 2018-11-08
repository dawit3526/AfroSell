package com.eri.afrosell.model.orders;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersRequestModel {
    @JsonProperty("searchKey")
    private String searchKey;
    @JsonProperty("sortCase")
    private int sortCase;
    @JsonProperty("ascSort")
    private boolean ascSort;
    @JsonProperty("pageNumber")
    private int pageNumber;
    @JsonProperty("pageSize")
    private int pageSize;
    @JsonProperty("status")
    private int status;
}
