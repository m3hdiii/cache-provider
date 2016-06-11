package com.mehdi.cache.server;


import com.mehdi.cache.model.PersonBioMetric;

/**
 * User: Mehdi Afsari
 * Date: 1/30/16
 * Time: 8:26 AM
 */
public interface PersonBiometricCache extends Cacheable{
    PersonBioMetric getRequestPersonBioMetric(long inquiryId);

    PersonBioMetric getCvPersonBioMetric(long recordNo);

    PersonBioMetric getCrPersonBioMetric(long recordNo);

    long getRequestPersonNistModifiedTimestamp(long inquiryId);

    long getCvPersonNistModifiedTimestamp(long recordNo);

    long getCrPersonNistModifiedTimestamp(long recordNo);
}
