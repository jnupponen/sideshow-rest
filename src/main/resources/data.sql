INSERT INTO location values ('a', 'b', 'c', 'd', '2016-10-11T12:45:45')
ON CONFLICT(id) DO UPDATE
SET secret = 'secret';