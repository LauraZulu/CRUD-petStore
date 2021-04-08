# CRUD-petStore

Create Docker container with Postgres database:

docker create --name postgres-demo -e POSTGRES_PASSWORD=Welcome -p 5432:5432 postgres:11.5-alpine

Start container:

docker start postgres-demo

Stop container:

docker stop postgres-demo

Connection Info:

Username: "postgres"

Password: "Welcome"

Create database: "petstore"

execute SQL

CREATE TABLE categories 
(
    id  SERIAL PRIMARY KEY,
    name   varchar(30) NOT NULL

);
CREATE TABLE pets
(
    id  SERIAL PRIMARY KEY,
    name   varchar(30) NOT NULL,
    category_id  integer NOT null REFERENCES categories (id),
    status        varchar(40) NULL

);

Insert data into categories

INSERT INTO categories (name)
VALUES ("Gatos"),
       ("Perros"),
       ("Aves");
