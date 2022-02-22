-- Kinds of Joins

-- Left JOIN
-- Right Join
-- Inner Join
-- Outer Join 

SELECT * FROM posts;
SELECT * FROM users;

CREATE VIEW most_posts AS SELECT users.id, first_name, last_name, count(*) AS count_num FROM users
	LEFT JOIN posts ON posts.author_id = users.id
	GROUP BY users.id;

SELECT * FROM most_posts;