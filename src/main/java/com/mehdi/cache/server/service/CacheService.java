package com.mehdi.cache.server.service;


import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.PersonBiometricCache;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:54 AM
 */
public abstract class CacheService {
    protected PersonBiometricCache personBiometricCache;

    public abstract PersonBioMetric getBioMetric(long id);

    public abstract long getModifiedTimestamp(long id);
}
