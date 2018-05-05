DROP TABLE IF EXISTS kontakts;
CREATE TABLE kontakts(id serial PRIMARY KEY,
                      name VARCHAR(100),
                      phone_number VARCHAR(100),
                      email VARCHAR(100),
                      address_line_one VARCHAR(100),
                      address_line_two VARCHAR(100),
                      state VARCHAR(100),
                      country VARCHAR(100),
                      zipcode VARCHAR(100));