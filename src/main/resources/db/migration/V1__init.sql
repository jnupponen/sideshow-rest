-- Initial Schema

CREATE TABLE location
 (
        id varchar(100) NOT NULL CONSTRAINT location_key PRIMARY KEY,
        location varchar(2000) NOT NULL,
        owner_secret    varchar(1000) NOT NULL,
        secret    varchar(1000) NOT NULL,
        location_date       timestamp NOT NULL
);