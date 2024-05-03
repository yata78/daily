-- create table {テーブル名} (id ---, name---)
DROP TABLE daily_ev;
CREATE TABLE daily_ev (
    id integer PRIMARY KEY,
    event_name varchar(20) NOT NULL,
    event_detail text NOT NULL,
    event_data date
);