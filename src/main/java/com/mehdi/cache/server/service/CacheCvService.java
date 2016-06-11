package com.mehdi.cache.server.service;


import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.PersonBiometricCache;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:54 AM
 */
public class CacheCvService extends CacheService {
    private static CacheCvService instance;

    private CacheCvService(PersonBiometricCache personBiometricCache) {
        this.personBiometricCache = personBiometricCache;
    }

    static CacheCvService getInstance(PersonBiometricCache personBiometricCache) {
        if (instance == null)
            instance = new CacheCvService(personBiometricCache);
        return instance;
    }


    @Override
    public PersonBioMetric getBioMetric(long id) {
        return personBiometricCache.getCvPersonBioMetric(id);
    }

    @Override
    public long getModifiedTimestamp(long id) {
        return personBiometricCache.getCvPersonNistModifiedTimestamp(id);
    }
}
