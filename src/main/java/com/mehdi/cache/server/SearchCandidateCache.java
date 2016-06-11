package com.mehdi.cache.server;


import com.mehdi.cache.model.DataBank;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:26 AM
 */
public interface SearchCandidateCache extends Cacheable{

    byte[] findCandidateNist(DataBank db, long recordId);

    byte[] findCandidateFeature(DataBank db, long recordId);
}
