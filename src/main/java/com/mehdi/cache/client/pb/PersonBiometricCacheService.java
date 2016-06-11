package com.mehdi.cache.client.pb;

import com.mehdi.cache.client.CacheConfig;
import com.mehdi.cache.model.PersonBioMetric;
import com.mehdi.cache.server.Cacheable;
import com.mehdi.cache.server.PersonBiometricCache;
import com.mehdi.cache.server.service.CacheServiceFactory;
import com.mehdi.cache.server.service.CacheServicesType;
import net.sf.ehcache.Element;

/**
 * User: Mehdi Afsari
 * Date: 1/28/16
 * Time: 11:59 AM
 */
public class PersonBiometricCacheService extends com.mehdi.cache.client.CacheService {
    private static PersonBiometricCacheService INSTANCE;
    private PersonBiometricCache cacheable;

    private PersonBiometricCacheService() {
    }

    public static PersonBiometricCacheService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PersonBiometricCacheService();
        return INSTANCE;
    }

    public void configure(Cacheable cacheable, CacheConfig config) {
        super.configure(config);
        this.cacheable = (PersonBiometricCache) cacheable;
    }

    public PersonBioMetric getRequestPersonNist(PersonBiometricCompoundKey key) {
        PersonBioMetric bioMetric = fetch(key, CacheServicesType.REQUEST_NIST);
        return bioMetric;
    }

    public PersonBioMetric getCvPersonNist(PersonBiometricCompoundKey key) {
        PersonBioMetric bioMetric = fetch(key, CacheServicesType.CV_NIST);
        return bioMetric;
    }

    public PersonBioMetric getCrPersonNist(PersonBiometricCompoundKey key) {
        PersonBioMetric bioMetric = fetch(key, CacheServicesType.CR_NIST);
        return bioMetric;
    }


    private PersonBioMetric fetch(PersonBiometricCompoundKey key, CacheServicesType servicesType) {
        PersonBioMetric bioMetric = null;
        if (cache != null) {
            Element foundElement = cache.get(key);
            if (foundElement == null) {
                bioMetric = getBioMetricFromServer(key, servicesType);
            } else {
                PersonBiometricCompoundValue value = (PersonBiometricCompoundValue) foundElement.getObjectValue();
                if (System.currentTimeMillis() - foundElement.getLastUpdateTime() >= config.getCacheReCheckingTime() * 1000) {
                    // Get modified timestamp from server
                    long modifiedTimestamp = CacheServiceFactory.getCacheService(servicesType, cacheable).getModifiedTimestamp(key.getId());

                    if (value.getModifiedTimestamp() == modifiedTimestamp) {
                        // change LastUpdateTime of element to current timestamp
                        cache.put(foundElement);
                        bioMetric = getBioMetricFromCache(value);
                    } else {
                        bioMetric = getBioMetricFromServer(key, servicesType);
                    }
                } else {
                    bioMetric = getBioMetricFromCache(value);
                }
            }
        }
        return bioMetric;
    }

    private PersonBioMetric getBioMetricFromServer(PersonBiometricCompoundKey key, CacheServicesType servicesType) {
        // get Blob From Server
        PersonBioMetric bioMetric = CacheServiceFactory.getCacheService(servicesType, cacheable).getBioMetric(key.getId());

        // Cache data
        cache.put(new Element(key, new PersonBiometricCompoundValue(bioMetric, System.currentTimeMillis())));
        return bioMetric;
    }

    private PersonBioMetric getBioMetricFromCache(PersonBiometricCompoundValue value) {
        return value.getBioMetric();
    }
}
