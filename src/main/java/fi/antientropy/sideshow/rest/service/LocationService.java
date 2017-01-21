package fi.antientropy.sideshow.rest.service;

import fi.antientropy.sideshow.rest.domain.PrivateLocation;
import fi.antientropy.sideshow.rest.domain.SharedLocation;

public interface LocationService {

    public SharedLocation getSharedLocation(String id) throws Exception;

    public SharedLocation createLocation(PrivateLocation location) throws Exception;

    public SharedLocation updateLocation(SharedLocation location) throws Exception;

    public SharedLocation deleteLocation(String id) throws Exception;

    public Boolean checkReadAccess(String id, String token);

    public Boolean checkModifyAccess(String id, String token, String ownerToken);

}