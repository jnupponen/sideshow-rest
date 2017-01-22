package fi.antientropy.sideshow.rest.controller;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.antientropy.sideshow.rest.domain.PrivateLocation;
import fi.antientropy.sideshow.rest.domain.SharedLocation;
import fi.antientropy.sideshow.rest.service.LocationService;

@Controller
public class Locations {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/api/example-request", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExample() {

        try {
            SharedLocation location = new SharedLocation();
            location.setId("example");
            location.setLocation(DigestUtils.sha256Hex("test"));
            location.setLocationDate(new Date());
            return new ResponseEntity<SharedLocation>(location, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/locations/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getLocation(@PathVariable String id) {

        try {
            return new ResponseEntity<SharedLocation>(locationService.getSharedLocation(id), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/locations", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createLocation(
            @RequestBody SharedLocation location,
            @RequestHeader("token") String token,
            @RequestHeader("owner_token") String ownerToken) {

        try {
            location.setLocationDate(Optional.ofNullable(location.getDateTime().toDate()).orElse(DateTime.now().toDate()));
            PrivateLocation privateLocation = new PrivateLocation(location);
            privateLocation.setId(privateLocation.generateId());
            privateLocation.setOwnerSecret(DigestUtils.sha512Hex(ownerToken));
            privateLocation.setSecret(DigestUtils.sha512Hex(token));
            return new ResponseEntity<SharedLocation>(locationService.createLocation(privateLocation), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/locations/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateLocation(@PathVariable String id, @RequestBody SharedLocation location) {

        try {
            location.setId(id);
            location.setLocationDate(Optional.ofNullable(location.getDateTime().toDate()).orElse(DateTime.now().toDate()));
            return new ResponseEntity<SharedLocation>(locationService.updateLocation(location), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
