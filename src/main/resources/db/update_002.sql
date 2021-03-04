ALTER TABLE person RENAME COLUMN name to username;
ALTER TABLE person ADD COLUMN password text;

update public.person set password = '$2a$10$CQADw1DjFbUMsQ8oBoP7ju3SuacVTkRq6YRQjDN5QYQcHPeJEFLNO' where id = 3