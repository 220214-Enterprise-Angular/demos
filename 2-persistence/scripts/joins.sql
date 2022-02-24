SELECT * FROM "Artist";
SELECT * FROM "Album";

-- Inner join
-- left join
-- right join
-- outter join (full join)

-- return the album ID, track title, and artist name by joining both THE
-- album and artists TABLES 
CREATE VIEW simple_album_artist_view AS
SELECT alb."AlbumId", alb."Title", art."Name" AS artist
	FROM "Album" alb
	JOIN "Artist" art 
	ON alb."ArtistId" = art."ArtistId";

SELECT * FROM simple_album_artist_view;


-- the above could also be expressed as a natural join 
SELECT * FROM "Artist" 
	NATURAL JOIN "Album";

-- SELF JOIN
SELECT * FROM "Employee";

SELECT e1."FirstName", e1."Title", e2."FirstName" AS boss_first_name, e2."Title" AS boss_title
	FROM "Employee" e1
	JOIN "Employee" e2
	ON e1."ReportsTo" = e2."EmployeeId";

SELECT * FROM chinook."Track";
SELECT * FROM chinook."InvoiceLine";

-- trackID, track name, invoicelineID, Invoice Id ON trackID 
SELECT a."TrackId", a."Name", b."InvoiceLineId", b."InvoiceId"
	FROM chinook."Track" AS a
	LEFT JOIN chinook."InvoiceLine" AS b 
	ON a."TrackId" = b."TrackId";

