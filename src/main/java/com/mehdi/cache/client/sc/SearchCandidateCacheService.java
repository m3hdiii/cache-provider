package com.mehdi.cache.client.sc;


import com.mehdi.cache.client.CacheConfig;
import com.mehdi.cache.client.CacheService;
import com.mehdi.cache.model.DataBank;
import com.mehdi.cache.server.Cacheable;
import com.mehdi.cache.server.SearchCandidateCache;
import net.sf.ehcache.Element;


/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 11:59 AM
 */
public class SearchCandidateCacheService extends CacheService {
    private static SearchCandidateCacheService INSTANCE;
    private SearchCandidateCache cacheable;

    private SearchCandidateCacheService() {
    }

    public static SearchCandidateCacheService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SearchCandidateCacheService();
        return INSTANCE;
    }

    public void configure(Cacheable cacheable, CacheConfig config) {
        super.configure(config);
        this.cacheable = (SearchCandidateCache) cacheable;
    }

    public byte[] getCandidate(DataBank db, long recNo, SearchCandidateCacheType cacheType) {
        SearchCandidateCompoundKey key = new SearchCandidateCompoundKey(recNo, db, cacheType);
        Element element = cache.get(key);
        return element != null ? (byte[]) element.getObjectValue() : null;
    }

    public byte[] putCandidate(DataBank db, long recNo, SearchCandidateCacheType cacheType) {
        byte[] searchCandidate = new byte[0];
        switch (cacheType) {
            case NIST:
                searchCandidate = cacheable.findCandidateNist(db, recNo);
                break;
            case FEATURE:
                searchCandidate = cacheable.findCandidateFeature(db, recNo);
                break;
        }
        cache.put(new Element(new SearchCandidateCompoundKey(recNo, db, cacheType), searchCandidate));
        return searchCandidate;
    }
}
