package com.mehdi.cache.server.service;


import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.PersonBiometricCache;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:54 AM
 */
public class CacheRequestService extends CacheService {
    private static CacheRequestService instance;

    private CacheRequestService(PersonBiometricCache personBiometricCache) {
        this.personBiometricCache = personBiometricCache;
    }

    static CacheRequestService getInstance(PersonBiometricCache personBiometricCache) {
        if (instance == null)
            instance = new CacheRequestService(personBiometricCache);
        return instance;
    }

    @Override
    public PersonBioMetric getBioMetric(long id) {
        PersonBioMetric personBioMetric = personBiometricCache.getRequestPersonBioMetric(id);
        //FPCEditorDescriptor fpcEditorDescriptor = FPCEditorDescriptorFactory.openNist(personBioMetric.getNistFile());
        return personBioMetric;
    }

    @Override
    public long getModifiedTimestamp(long id) {
        return personBiometricCache.getRequestPersonNistModifiedTimestamp(id);
    }
}
