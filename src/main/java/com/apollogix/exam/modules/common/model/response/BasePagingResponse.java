package com.apollogix.exam.modules.common.model.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Paging response
 *
 * @param <T> type content
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasePagingResponse<T extends Serializable> implements Serializable {

    private ArrayList<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    BasePagingResponse(List<T> content, int pageNumber, int pageSize, long totalElements) {
        this.content = new ArrayList<>(content);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
    }

    public static <T extends Serializable> BasePagingResponseBuilder<T> builder() {
        return new BasePagingResponseBuilder<>();
    }

    public List<T> getContent() {
        return this.content;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getTotalElements() {
        return this.totalElements;
    }

    public static class BasePagingResponseBuilder<T extends Serializable> {
        private List<T> content;
        private int pageNumber;
        private int pageSize;
        private long totalElements;

        BasePagingResponseBuilder() {
        }

        public BasePagingResponseBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public BasePagingResponseBuilder<T> pageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public BasePagingResponseBuilder<T> pageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public BasePagingResponseBuilder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public BasePagingResponse<T> build() {
            return new BasePagingResponse<>(this.content, this.pageNumber, this.pageSize, this.totalElements);
        }

    }
}
