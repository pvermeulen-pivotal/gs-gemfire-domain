CREATE TABLE "cloud"."beacon_request"
(                                                                                
	"ID" serial,                                                     
	"CUSTOMERID" bigint,                                                     
	"DEVICEID" VARCHAR(16),                                                         
	"UUID" CHAR(16),                                                                
	"MAJOR" smallint,                                                           
	"MINOR" smallint,                                                           
	"SIGNAL_POWER" smallint                                                         
) DISTRIBUTED BY ("ID");
  
CREATE TABLE "cloud"."beacon_response" 
(	
	"ID" serial,                                                     
	"CUSTOMERID" bigint, 
	"DEVICEID" VARCHAR(16), 
	"UUID" CHAR(16), 
	"MAJOR" smallint, 
	"MINOR" smallint,
	"PROMO_ID" integer,
	"MESSAGE" text,
	"URL" text,
	"ERROR" text
)  DISTRIBUTED BY ("ID");

CREATE TABLE "cloud"."assoc_rules" 
(	
	"RULEID" integer,
	"PREPRODUCTID" bigint,
	"POSTPRODUCTID" bigint,
	"COUNT" integer,
	"SUPPORT" double precision,
	"CONFIDENCE" double precision,
	"LIFT" double precision,
	"CONVICTION" double precision
) DISTRIBUTED BY ("RULEID");

CREATE TABLE "cloud"."beacon" 
(	
	"ID" serial,
	"UUID" VARCHAR(16),
	"MAJOR" smallint,
	"MINOR" smallint,
	"CATEGORYID" integer
) DISTRIBUTED BY ("ID");

CREATE TABLE "cloud"."category" 
(	
	"CATEGORYID" integer,
	"CATEGORYNAME" text,
	"SUBCATEGORYID" integer,
	"SUBCATEGORYNAME" text
) DISTRIBUTED BY ("CATEGORYID");

CREATE TABLE "cloud"."customer" 
(	
	"CUSTOMERID" bigint,
	"FIRSTNAME" text,
	"LASTNAME" text,
	"STREET" text,
	"CITY" text,
	"STATE" text,
	"ZIPCODE" text,
	"PRIMARYNUMBER" VARCHAR(10),
	"MOBILENUMBER" VARCHAR(10),
	"OPENDATE" date,
	"LASTUPDATE" date
) DISTRIBUTED BY ("CUSTOMERID");

CREATE TABLE "cloud"."customer_favorites" 
(	
	"ID" serial,
	"CUSTOMERID" bigint,
	"PRODUCTID" bigint,
	"COUNT" integer
) DISTRIBUTED BY ("ID");

CREATE TABLE "cloud"."product" 
(	
	"PRODUCTID" bigint,
	"PRODUCTNAME" text,
	"CATEGORYID" integer,
	"SUBCATEGORYID" integer,
	"UNIT" double precision,
	"COST" double precision,
	"PRICE" double precision,
	"URL" text,
	"STARTDATE" date,
	"ENDDATE" date,
	"CREATEDDATE" date,
	"LASTUPDATEDATE" date
) DISTRIBUTED BY ("PRODUCTID");

CREATE TABLE "cloud"."product_promotion" 
(	
	"PRODUCTID" bigint,
	"CATEGORYID" integer,
	"SUBCATEGORYID" integer,
	"PROMOTIONID" integer,
	"STARTDATE" date,
	"ENDDATE" date
) DISTRIBUTED BY ("PRODUCTID");

CREATE TABLE "cloud"."promotion" 
(	
	"PROMOTIONID" integer,
	"STARTDATE" date,
	"ENDDATE" date,
	"MESSAGE" text,
	"URL" text
) DISTRIBUTED BY ("PROMOTIONID");

CREATE TABLE "cloud"."store" 
(	
	"STOREID" integer,
	"NAME" text,
	"STREET" text,
	"CITY" text,
	"STATE" text,
	"ZIPCODE" text,
	"LONGITUDE" double precision,
	"LATITUDE" double precision
) DISTRIBUTED BY ("STOREID");
  