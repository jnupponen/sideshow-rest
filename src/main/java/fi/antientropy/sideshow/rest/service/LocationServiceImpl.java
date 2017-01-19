package fi.antientropy.sideshow.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.antientropy.sideshow.rest.domain.Location;

@Component("locationService")
@Transactional
class LocationServiceImpl implements LocationService {


    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location getLocation(String id) throws Exception {
        return locationRepository.findByIdAllIgnoringCase(id).get();
    }

    @Override
    public Location createLocation(Location location) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Location updateLocation(String id, Location event) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Location deleteLocation(String id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}
