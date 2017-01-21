package fi.antientropy.sideshow.rest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "location")
@JsonInclude(Include.NON_NULL)
public class SharedLocation {

    @Id
    @JsonProperty("id")
    private String id;

    @Column(name = "location")
    @JsonProperty("location")
    private String location;

    @JsonIgnore
    @Column(name = "secret")
    private String secret;

    @Column(name = "location_date")
    private Date locationDate;

    public String getId() {
        return id;
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

    @JsonProperty("modified_date")
    public String getOutputDateTime() {
        return new DateTime(locationDate).toString();
    }

}