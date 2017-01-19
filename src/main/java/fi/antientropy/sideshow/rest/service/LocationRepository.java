package fi.antientropy.sideshow.rest.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fi.antientropy.sideshow.rest.domain.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Optional<Location> findByIdAllIgnoringCase(String id);

}