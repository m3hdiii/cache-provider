package com.mehdi.cache.client.sc;

import com.mehdi.cache.model.DataBank;

import java.io.Serializable;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 3:00 PM
 */
public class SearchCandidateCompoundKey implements Serializable {
    private Long recordNo;
    private DataBank dataBank;
    private SearchCandidateCacheType cacheType;

    public SearchCandidateCompoundKey(Long recordNo, DataBank dataBank, SearchCandidateCacheType cacheType) {
        this.recordNo = recordNo;
        this.dataBank = dataBank;
        this.cacheType = cacheType;
    }

    public Long getRecordNo() {
        return recordNo;
    }

    public DataBank getDataBank() {
        return dataBank;
    }

    public SearchCandidateCacheType getCacheType() {
        return cacheType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchCandidateCompoundKey)) return false;

        SearchCandidateCompoundKey that = (SearchCandidateCompoundKey) o;

        if (recordNo != null ? !recordNo.equals(that.recordNo) : that.recordNo != null) return false;
        if (dataBank != that.dataBank) return false;
        return cacheType == that.cacheType;

    }

    @Override
    public int hashCode() {
        int result = recordNo != null ? recordNo.hashCode() : 0;
        result = 31 * result + (dataBank != null ? dataBank.hashCode() : 0);
        result = 31 * result + (cacheType != null ? cacheType.hashCode() : 0);
        return result;
    }
}
