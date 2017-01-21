package fi.antientropy.sideshow.rest.service;

import fi.antientropy.sideshow.rest.domain.SharedLocation;
import fi.antientropy.sideshow.rest.domain.PrivateLocation;

public interface LocationService {

    SharedLocation getLocation(String id) throws Exception;

    PrivateLocation postLocation(PrivateLocation location) throws Exception;

    PrivateLocation createLocation(PrivateLocation location) throws Exception;

    PrivateLocation updateLocation(String id, PrivateLocation event) throws Exception;

    PrivateLocation deleteLocation(String id) throws Exception;

}