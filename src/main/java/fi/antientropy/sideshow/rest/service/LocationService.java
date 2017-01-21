package fi.antientropy.sideshow.rest.service;

import fi.antientropy.sideshow.rest.domain.PrivateLocation;
import fi.antientropy.sideshow.rest.domain.SharedLocation;

public interface LocationService {

    public SharedLocation getLocation(String id) throws Exception;

    public PrivateLocation postLocation(PrivateLocation location) throws Exception;

    public PrivateLocation createLocation(PrivateLocation location) throws Exception;

    public PrivateLocation updateLocation(String id, PrivateLocation event) throws Exception;

    public PrivateLocation deleteLocation(String id) throws Exception;

    public Boolean checkAccess(String id, String token);

}