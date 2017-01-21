package fi.antientropy.sideshow.rest.controller;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.antientropy.sideshow.rest.domain.SharedLocation;
import fi.antientropy.sideshow.rest.domain.PrivateLocation;
import fi.antientropy.sideshow.rest.service.LocationService;

@Controller
public class Locations {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/api/example-post", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> postExample() {

        try {
            PrivateLocation location = new PrivateLocation();
            location.setId("example");
            location.setLocationDate(new Date());
            location.setLocation(DigestUtils.sha256Hex("test"));
            location.setOwnerSecret("abc");
            location.setSecret("efg");
            return new ResponseEntity<PrivateLocation>(location, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/example-get", method = RequestMethod.GET)
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
            return new ResponseEntity<SharedLocation>(locationService.getLocation(id), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
