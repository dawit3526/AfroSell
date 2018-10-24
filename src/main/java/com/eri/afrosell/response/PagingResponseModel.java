/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eri.afrosell.response;
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
public class PagingResponseModel {
    private List<?> data;
    private long totalResult;
    private int totalPage;
    private int currentPage;



    public void setData(List<?> data) {
        this.data = data;
    }

    public void setTotalResult(long totalResult) {
        this.totalResult = totalResult;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<?> getData() {
        return data;
    }

    public long getTotalResult() {
        return totalResult;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
