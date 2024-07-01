USE record_company;
CREATE TABLE test(
test_column INT
);
ALTER TABLE test
ADD another_col VARCHAR(255);
DROP TABLE test;
CREATE TABLE bands(
id INT NOT NULL auto_increment,
name VARCHAR(255) NOT NULL,
PRIMARY KEY(id)
);
CREATE TABLE albums(
id INT NOT NULL auto_increment,
name VARCHAR(255) NOT NULL,
release_year INT,
band_id INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(band_id) REFERENCES bands(id)
);
INSERT INTO bands(name)
VALUES ('Iron Maiden');

INSERT INTO bands(name)
VALUES ('Deuce'),('Avenged sevenfold'),('Ankor');

SELECT * FROM bands;
SELECT * FROM bands LIMIT 2;

SELECT name FROM bands;

SELECT name AS 'band_name' , id AS 'ID'
FROM bands;

SELECT * FROM bands ORDER BY name;

INSERT INTO albums(name, release_year, band_id)
VALUES('The number of beasts', 1985 , 1),
	  ('Power slave',1984,2),
      ('nightmare', 2018,2),
      ('nightmare',2010,3),
      ('kadharalazz', NULL, 3);
      
SELECT * FROM albums;

SELECT DISTINCT name FROM albums; 
    
UPDATE albums
SET release_year = 1982
WHERE id = 1;

SELECT * FROM albums;
 
 SELECT * FROM albums
 WHERE release_year<2000;
 
 SELECT * FROM albums
 WHERE name LIKE '%er%' AND band_id = 2;
 
 SELECT * FROM albums
 WHERE release_year = 1984 OR band_id = 1;
 
 SELECT * FROM albums
 WHERE release_year BETWEEN 2000 AND 2018;
 
 SELECT * FROM albums
 WHERE release_year IS NULL;
 
 DELETE FROM albums WHERE id = 5;
 SELECT * FROM albums;
 
 SELECT * FROM bands
 INNER JOIN albums ON bands.id = albums.band_id;
 
 SELECT * FROM bands
 LEFT JOIN albums ON bands.id = albums.band_id;
 
 
 
 
 
