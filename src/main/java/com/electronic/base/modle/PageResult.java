package com.electronic.base.modle;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private int pageNum = 1;
    private int pageSize = 10;
    private List<T> result;
    private long count = 0L;
    private long pageCount;
    private long startRowIndex;
    private long endRowIndex;

    public PageResult() {
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getStartRowIndex() {
        this.startRowIndex = (long)((this.getPageNum() - 1) * this.getPageSize());
        return this.startRowIndex;
    }

    public long getEndRowIndex() {
        this.endRowIndex = (long)(this.getPageNum() * this.getPageSize());
        return this.endRowIndex;
    }

    public long getPageCount() {
        long quotient = this.getCount() / (long)this.getPageSize();
        long remainder = this.getCount() % (long)this.getPageSize();
        this.pageCount = quotient;
        if (remainder > 0L) {
            ++this.pageCount;
        }

        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = (long)pageCount;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
