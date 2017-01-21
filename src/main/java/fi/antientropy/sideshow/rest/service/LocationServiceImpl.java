package fi.antientropy.sideshow.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.antientropy.sideshow.rest.domain.SharedLocation;
import fi.antientropy.sideshow.rest.domain.PrivateLocation;

@Component("locationService")
@Transactional
class LocationServiceImpl implements LocationService {


    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public SharedLocation getLocation(String id) throws Exception {
        return locationRepository.findByIdAllIgnoringCase(id).get();
    }

    @Override
    public PrivateLocation postLocation(PrivateLocation location) throws Exception {
        return locationRepository.save(location);
    }

    @Override
    public PrivateLocation createLocation(PrivateLocation location) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrivateLocation updateLocation(String id, PrivateLocation event) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrivateLocation deleteLocation(String id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}
