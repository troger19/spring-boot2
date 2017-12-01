ALTER TABLE Car ADD COLUMN (color VARCHAR (200));
UPDATE Car SET color = 'Red' where color is null;