/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.eri.afrosell.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Trinhlbk
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserListRequestModel {
    @JsonProperty("searchKey")
    public String searchKey;
    @JsonProperty("sortCase")
    public int sortCase;
    @JsonProperty("ascSort")
    public Boolean ascSort;
    @JsonProperty("pageNumber")
    public int pageNumber;
    @JsonProperty("pageSize")
    public int pageSize;

    public String getSearchKey() {
        return searchKey;
    }

    public int getSortCase() {
        return sortCase;
    }

    public Boolean getAscSort() {
        return ascSort;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public void setSortCase(int sortCase) {
        this.sortCase = sortCase;
    }

    public void setAscSort(Boolean ascSort) {
        this.ascSort = ascSort;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
