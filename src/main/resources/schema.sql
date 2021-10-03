DROP TABLE IF EXISTS MsgGenErrors;

CREATE TABLE MsgGenErrors (
  long INT AUTO_INCREMENT  PRIMARY KEY,
  convertor VARCHAR(250),
  source VARCHAR(250),
  context VARCHAR(250),
  message VARCHAR(250) NOT NULL,
  timestamp DATE NOT NULL
);