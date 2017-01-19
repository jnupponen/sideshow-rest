package fi.antientropy.sideshow.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.antientropy.sideshow.rest.domain.Location;
import fi.antientropy.sideshow.rest.service.LocationService;

@Controller
public class Locations {

    @Autowired
    private LocationService locationService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getLocation(@PathVariable String id) {

        try {
            return new ResponseEntity<Location>(locationService.getLocation(id), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Unable to fetch location", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
