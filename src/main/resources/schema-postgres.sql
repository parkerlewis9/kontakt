CREATE TABLE kontakt( id serial PRIMARY KEY,
                      name VARCHAR(100),
                      phone_number VARCHAR(100),
                      email_address VARCHAR(100),
                      address_line_one VARCHAR(100),
                      address_line_two VARCHAR(100),
                      state VARCHAR(100),
                      country VARCHAR(100),
                      zipcode VARCHAR(100));

CREATE SEQUENCE hibernate_sequence START 1; 