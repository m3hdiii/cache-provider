package com.mehdi.cache.server.service;


import com.mehdi.cache.server.PersonBiometricCache;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:56 AM
 */
public class CacheServiceFactory {
    public static CacheService getCacheService(CacheServicesType cacheServices, PersonBiometricCache personBiometricCache) {
        switch (cacheServices) {
            case CV_NIST:
                return CacheCvService.getInstance(personBiometricCache);
            case CR_NIST:
                return CacheCrService.getInstance(personBiometricCache);
            case REQUEST_NIST:
                return CacheRequestService.getInstance(personBiometricCache);
        }
        return null;
    }
}
