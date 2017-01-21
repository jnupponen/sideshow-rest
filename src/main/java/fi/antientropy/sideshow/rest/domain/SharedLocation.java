package fi.antientropy.sideshow.rest.domain;

import java.util.Date;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class SharedLocation {

    public SharedLocation() {}
    public SharedLocation(PrivateLocation privateLocation) {
        this.id = privateLocation.getId();
        this.location = privateLocation.getLocation();
        this.locationDate = privateLocation.getLocationDate();
    }

    @JsonProperty("id")
    private String id;

    @JsonProperty("location")
    private String location;

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
    public void setOutputDateTime(String dateTime) {
        this.locationDate = DateTime.parse(dateTime).toDate();
    }
}