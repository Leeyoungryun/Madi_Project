DROP SEQUENCE SEQ_MEMBER_NUM;

DROP TABLE MEMBER CASCADE CONSTRAINTS PURGE;

CREATE TABLE MEMBER
(
	MEMBER_NUM                NUMBER(3)  NOT NULL ,
	EMAIL                 VARCHAR2(500)  NOT NULL ,
	PW                    VARCHAR2(500)  NULL ,
	PHONE                 VARCHAR2(500)  NOT NULL ,
	LOCAL                 VARCHAR2(500)  NOT NULL ,
	NAME                  VARCHAR2(500)  NOT NULL 
);

CREATE UNIQUE INDEX XPK_MEMBER ON MEMBER
(MEMBER_NUM  ASC);

ALTER TABLE MEMBER
	ADD  PRIMARY KEY (MEMBER_NUM);

CREATE SEQUENCE SEQ_MEMBER_NUM START WITH 1 MAXVALUE 99999999999999 MINVALUE 1 NOCYCLE CACHE 20  NOORDER;

COMMIT;

INSERT INTO MEMBER (MEMBER_NUM, EMAIL, PW, NAME, PHONE, LOCAL) VALUES (SEQ_MEMBER_NUM.NEXTVAL, 'test@naver.com', '123', '����', '01033331111',	'����');

COMMIT;
