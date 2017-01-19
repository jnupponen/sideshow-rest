package fi.antientropy.sideshow.rest.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Location {

    @Id
    private String id;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "secret", nullable = true)
    private String secret;

    @Column(name = "owner_secret", nullable = true)
    private String ownerSecret;

    @Column(name = "location_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date locationDate;

    public String getId() {
        return id;
    }

    public String generateId() {
        String generated = UUID.randomUUID().toString();
        this.id = generated;
        return generated;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getOwnerSecret() {
        return ownerSecret;
    }

    public void setOwnerSecret(String ownerSecret) {
        this.ownerSecret = ownerSecret;
    }

    @JsonIgnore
    public Date getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Date locationDate) {
        this.locationDate = locationDate;
    }

    @JsonIgnore
    public DateTime getDateTime() {
        return new DateTime(locationDate);
    }

    public String getOutputDateTime() {
        return new DateTime(locationDate).toString();
    }

}