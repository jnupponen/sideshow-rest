package fi.antientropy.sideshow.rest.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fi.antientropy.sideshow.rest.domain.PrivateLocation;

public interface LocationRepository extends CrudRepository<PrivateLocation, Long> {

    Optional<PrivateLocation> findById(String id);

}