package fi.antientropy.sideshow.rest.service;

import fi.antientropy.sideshow.rest.domain.Location;

public interface LocationService {

    Location getLocation(String id) throws Exception;

    Location createLocation(Location location) throws Exception;

    Location updateLocation(String id, Location event) throws Exception;

    Location deleteLocation(String id) throws Exception;

}