package com.mehdi.cache.server.service;


import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.PersonBiometricCache;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:54 AM
 */
public class CacheCrService extends CacheService {
    private static CacheCrService instance;

    private CacheCrService(PersonBiometricCache personBiometricCache) {
        this.personBiometricCache = personBiometricCache;
    }

    static CacheCrService getInstance(PersonBiometricCache personBiometricCache) {
        if (instance == null)
            instance = new CacheCrService(personBiometricCache);
        return instance;
    }

    @Override
    public PersonBioMetric getBioMetric(long id) {
        return personBiometricCache.getCrPersonBioMetric(id);
    }

    @Override
    public long getModifiedTimestamp(long id) {
        return personBiometricCache.getCrPersonNistModifiedTimestamp(id);
    }
}
