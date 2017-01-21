package fi.antientropy.sideshow.rest.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fi.antientropy.sideshow.rest.domain.PrivateLocation;
import fi.antientropy.sideshow.rest.domain.SharedLocation;

@Component("locationService")
@Transactional
class LocationServiceImpl implements LocationService {


    public static final String FAIL = "fail";
    public static final String SUCCESS = "success";

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public SharedLocation getSharedLocation(String id) throws Exception {
        return locationRepository.findById(id)
                .map(SharedLocation::new)
                .orElseThrow(() -> new Exception("not found"));
    }


    @Override
    public SharedLocation createLocation(PrivateLocation location) throws Exception {
        return new SharedLocation(locationRepository.save(location));
    }

    @Override
    public SharedLocation updateLocation(SharedLocation sharedLocation) throws Exception {
       Optional<PrivateLocation> old = locationRepository.findById(sharedLocation.getId());
       PrivateLocation oldLocation = old.orElseThrow(() -> new Exception("Not found"));

       oldLocation.setLocation(sharedLocation.getLocation());
       oldLocation.setLocationDate(sharedLocation.getLocationDate());

       return new SharedLocation(locationRepository.save(oldLocation));
    }

    @Override
    public SharedLocation deleteLocation(String id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean checkAccess(String id, String token) {
        if(id == null || token == null) {
            return false;
        }
        else {
            return locationRepository.findById(id)
                .filter(location -> id.equals(location.getId()))
                .filter(location -> DigestUtils.sha512Hex(token).equals(location.getSecret()))
                .isPresent();
        }
    }

}
