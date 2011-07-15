--
-- PostgreSQL database dump
--

-- Started on 2010-12-09 16:21:17

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 698 (class 2612 OID 16386)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 23 (class 1255 OID 31882)
-- Dependencies: 3 698
-- Name: ebsc_change_parent_set(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_change_parent_set() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE	
		
BEGIN
	
	-- RAISE NOTICE
	RAISE NOTICE 'Execute ebsc_insert_tar2()';
	
	IF (NEW.objtype = 0) THEN
		NEW.parentid := null;
	END IF;
	
	RETURN NEW;
END
$$;


ALTER FUNCTION public.ebsc_change_parent_set() OWNER TO postgres;

--
-- TOC entry 19 (class 1255 OID 28198)
-- Dependencies: 698 3
-- Name: ebsc_create_organization_objectives(integer, integer, integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_create_organization_objectives(orgid integer, yearvalue integer, typevalue integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$ 
DECLARE
	retValue int;
	countValue int;
	maxOrgObjId int;
	iMonth int;
	iQuarter int;
	iMonthCode int;

BEGIN

	--
	-- Return values:
	-- -1 for error: invalid input
	-- 0 for successful
	-- 1 for organization objectives is existed!
	--

	retValue := -1;
	countValue := 0;
		
	-- RAISE NOTICE
	RAISE NOTICE 'Input fields: orgId = %, yearValue = %, typeValue = %', orgId, yearValue, typeValue;
	
	-- Check existing for data tables initial
	SELECT count(*) INTO countValue FROM ebsc_orgobjectives_types;
	IF countValue = 0 THEN 
		EXECUTE  'SELECT ebsc_initilize_data_tables();';
	END IF;
		
	-- typeValue: 0 for year type, 1 for quarter, 2 for month
	
	IF typeValue < 3 THEN 
		
		retValue := 1;

		-- Check existing for organization objectives
		SELECT count(*) INTO countValue FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (objtype = typeValue);
		IF countValue > 0 THEN
			RETURN retValue;
		END IF;
		
		-- Check existing for organization objectives for year type
		SELECT count(*) INTO countValue FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (objtype = 0);

		IF countValue = 0 THEN
		
			retValue := 0;

			--
			-- Create organization objectives for year type
			--
			
			iMonthCode := 0;
			
			-- RAISE NOTICE
			RAISE NOTICE 'Year is %', yearValue;
			
			-- Table: ebsc_orgobjectives_list
			INSERT INTO ebsc_orgobjectives_list(
						org_id, name, description, created_date, year, objtype, 
						entering_percent, completion_percent, isapproved, month_hash, validweight)
				VALUES (orgId, E'Năm ' || yearValue, E'Bộ mục tiêu cho năm ' || yearValue, LOCALTIMESTAMP, yearValue, 0, 
						0.00, 0.00, FALSE, 0, FALSE);
			
			SELECT MAX(id) INTO maxOrgObjId FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (month_hash = iMonthCode);
						
			-- Table: ebsc_orgobjectives_perspectives. 
			-- Row: Financial
			INSERT INTO ebsc_orgobjectives_perspectives(
						obj_id, name, description, weight_percent, entering_percent, 
						completion_percent, objective_count, validweight, pertype)
				VALUES (maxOrgObjId, 'Financial', 'Financial', 0.00, 0.00, 
						0.00, 0, FALSE, 0);
						
			-- Row: Customer
			INSERT INTO ebsc_orgobjectives_perspectives(
						obj_id, name, description, weight_percent, entering_percent, 
						completion_percent, objective_count, validweight, pertype)
				VALUES (maxOrgObjId, 'Customer', 'Customer', 0.00, 0.00, 
						0.00, 0, FALSE, 1);
			
			-- Row: Internal Process
			INSERT INTO ebsc_orgobjectives_perspectives(
						obj_id, name, description, weight_percent, entering_percent, 
						completion_percent, objective_count, validweight, pertype)
				VALUES (maxOrgObjId, 'Internal Process', 'Internal Process', 0.00, 0.00, 
						0.00, 0, FALSE, 2);
						
			-- Row: Learning & Growth
			INSERT INTO ebsc_orgobjectives_perspectives(
						obj_id, name, description, weight_percent, entering_percent, 
						completion_percent, objective_count, validweight, pertype)
				VALUES (maxOrgObjId, 'Learning & Growth', 'Learning & Growth', 0.00, 0.00, 
						0.00, 0, FALSE, 3);

		END IF;

		IF typeValue = 1 THEN

			retValue := 0;

			--
			-- Create organization objectives for quarter type	
			--

			FOR iQuarter IN 1..4 LOOP
					
				-- RAISE NOTICE
				RAISE NOTICE 'Quarter is %', iQuarter;
				
				--
				-- Create organization objectives for quarter type	
				--
				
				iMonthCode := iQuarter * 100;
				
				-- Table: ebsc_orgobjectives_list
				INSERT INTO ebsc_orgobjectives_list(
							org_id, name, description, created_date, year, objtype, 
							entering_percent, completion_percent, isapproved, month_hash, validweight)
					VALUES (orgId, E'Quý ' || iQuarter || ' - Năm ' || yearValue, E'Bộ mục tiêu cho quý ' || iQuarter || ' - năm ' || yearValue, LOCALTIMESTAMP, yearValue, 1, 
							0.00, 0.00, FALSE, iMonthCode, FALSE);
				
				SELECT MAX(id) INTO maxOrgObjId FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (month_hash = iMonthCode);
							
				-- Table: ebsc_orgobjectives_perspectives. 
				-- Row: Financial
				INSERT INTO ebsc_orgobjectives_perspectives(
							obj_id, name, description, weight_percent, entering_percent, 
							completion_percent, objective_count, validweight, pertype)
					VALUES (maxOrgObjId, 'Financial', 'Financial', 0.00, 0.00, 
							0.00, 0, FALSE, 0);
							
				-- Row: Customer
				INSERT INTO ebsc_orgobjectives_perspectives(
							obj_id, name, description, weight_percent, entering_percent, 
							completion_percent, objective_count, validweight, pertype)
					VALUES (maxOrgObjId, 'Customer', 'Customer', 0.00, 0.00, 
							0.00, 0, FALSE, 1);
				
				-- Row: Internal Process
				INSERT INTO ebsc_orgobjectives_perspectives(
							obj_id, name, description, weight_percent, entering_percent, 
							completion_percent, objective_count, validweight, pertype)
					VALUES (maxOrgObjId, 'Internal Process', 'Internal Process', 0.00, 0.00, 
							0.00, 0, FALSE, 2);
							
				-- Row: Learning & Growth
				INSERT INTO ebsc_orgobjectives_perspectives(
							obj_id, name, description, weight_percent, entering_percent, 
							completion_percent, objective_count, validweight, pertype)
					VALUES (maxOrgObjId, 'Learning & Growth', 'Learning & Growth', 0.00, 0.00, 
							0.00, 0, FALSE, 3);
				
			END LOOP;
			
		ELSE
			IF typeValue = 2 THEN		
			
				-- Check existing for organization objectives for year type
				SELECT count(*) INTO countValue FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (objtype = 1);

				--
				-- Create organization objectives for quarter type and month type
				--
				
				FOR iMonth IN 1..12 LOOP
					
					IF (iMonth - 1) % 3 = 0 THEN

						IF countValue = 0 THEN

							retValue := 0;

							iQuarter := (iMonth / 3 + 1);
							
							-- RAISE NOTICE
							RAISE NOTICE 'Quarter is %', iQuarter;
							
							--
							-- Create organization objectives for quarter type	
							--
							
							iMonthCode := iQuarter * 100;
							
							-- Table: ebsc_orgobjectives_list
							INSERT INTO ebsc_orgobjectives_list(
										org_id, name, description, created_date, year, objtype, 
										entering_percent, completion_percent, isapproved, month_hash, validweight)
								VALUES (orgId, E'Quý ' || iQuarter || ' - Năm ' || yearValue, E'Bộ mục tiêu cho quý ' || iQuarter || ' - năm ' || yearValue, LOCALTIMESTAMP, yearValue, 1, 
										0.00, 0.00, FALSE, iMonthCode, FALSE);
							
							SELECT MAX(id) INTO maxOrgObjId FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (month_hash = iMonthCode);
										
							-- Table: ebsc_orgobjectives_perspectives. 
							-- Row: Financial
							INSERT INTO ebsc_orgobjectives_perspectives(
										obj_id, name, description, weight_percent, entering_percent, 
										completion_percent, objective_count, validweight, pertype)
								VALUES (maxOrgObjId, 'Financial', 'Financial', 0.00, 0.00, 
										0.00, 0, FALSE, 0);
										
							-- Row: Customer
							INSERT INTO ebsc_orgobjectives_perspectives(
										obj_id, name, description, weight_percent, entering_percent, 
										completion_percent, objective_count, validweight, pertype)
								VALUES (maxOrgObjId, 'Customer', 'Customer', 0.00, 0.00, 
										0.00, 0, FALSE, 1);
							
							-- Row: Internal Process
							INSERT INTO ebsc_orgobjectives_perspectives(
										obj_id, name, description, weight_percent, entering_percent, 
										completion_percent, objective_count, validweight, pertype)
								VALUES (maxOrgObjId, 'Internal Process', 'Internal Process', 0.00, 0.00, 
										0.00, 0, FALSE, 2);
										
							-- Row: Learning & Growth
							INSERT INTO ebsc_orgobjectives_perspectives(
										obj_id, name, description, weight_percent, entering_percent, 
										completion_percent, objective_count, validweight, pertype)
								VALUES (maxOrgObjId, 'Learning & Growth', 'Learning & Growth', 0.00, 0.00, 
										0.00, 0, FALSE, 3);

						END IF;
						
					END IF;
					
					-- RAISE NOTICE
					RAISE NOTICE 'Month is %', iMonth;
					
					--
					-- Create organization objectives for month type	
					--
					
					iMonthCode := iQuarter * 100 + iMonth;
					
					-- Table: ebsc_orgobjectives_list
					INSERT INTO ebsc_orgobjectives_list(
								org_id, name, description, created_date, year, objtype, 
								entering_percent, completion_percent, isapproved, 
								month_hash, validweight)
						VALUES (orgId, E'Tháng ' || iMonth || ' - Quý ' || iQuarter || ' - Năm ' || yearValue, E'Bộ mục tiêu cho tháng ' || iMonth || ' - quý ' || iQuarter || ' - năm ' || yearValue, LOCALTIMESTAMP, yearValue, 2, 
								0.00, 0.00, FALSE, iMonthCode, FALSE);
					
					SELECT MAX(id) INTO maxOrgObjId FROM ebsc_orgobjectives_list WHERE (org_id = orgId) AND (year = yearValue) AND (month_hash = iMonthCode);
								
					-- Table: ebsc_orgobjectives_perspectives. 
					-- Row: Financial
					INSERT INTO ebsc_orgobjectives_perspectives(
								obj_id, name, description, weight_percent, entering_percent, 
								completion_percent, objective_count, validweight, pertype)
						VALUES (maxOrgObjId, 'Financial', 'Financial', 0.00, 0.00, 
								0.00, 0, FALSE, 0);
								
					-- Row: Customer
					INSERT INTO ebsc_orgobjectives_perspectives(
								obj_id, name, description, weight_percent, entering_percent, 
								completion_percent, objective_count, validweight, pertype)
						VALUES (maxOrgObjId, 'Customer', 'Customer', 0.00, 0.00, 
								0.00, 0, FALSE, 1);
					
					-- Row: Internal Process
					INSERT INTO ebsc_orgobjectives_perspectives(
								obj_id, name, description, weight_percent, entering_percent, 
								completion_percent, objective_count, validweight, pertype)
						VALUES (maxOrgObjId, 'Internal Process', 'Internal Process', 0.00, 0.00, 
								0.00, 0, FALSE, 2);
								
					-- Row: Learning & Growth
					INSERT INTO ebsc_orgobjectives_perspectives(
								obj_id, name, description, weight_percent, entering_percent, 
								completion_percent, objective_count, validweight, pertype)
						VALUES (maxOrgObjId, 'Learning & Growth', 'Learning & Growth', 0.00, 0.00, 
								0.00, 0, FALSE, 3);
					
				END LOOP;
			
			END IF;			
		END IF;

		RETURN retValue;
	END IF;
	
	-- ERROR: Invalid input
	RETURN retValue;
END
$$;


ALTER FUNCTION public.ebsc_create_organization_objectives(orgid integer, yearvalue integer, typevalue integer) OWNER TO postgres;

--
-- TOC entry 20 (class 1255 OID 28200)
-- Dependencies: 698 3
-- Name: ebsc_initilize_data_tables(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_initilize_data_tables() RETURNS boolean
    LANGUAGE plpgsql
    AS $$ 
DECLARE
	countVaule int;

BEGIN

	-- Initialize ebsc_orgobjectives_types
	-- Type		Name		Desciption
	-- 0		Year		Year
	-- 1		Quarter		Quarter
	-- 2		Month		Month
	SELECT count(*) INTO countVaule FROM ebsc_orgobjectives_types;
	IF (countVaule = 0) THEN 
		-- RAISE NOTICE
		RAISE NOTICE 'Initialize ebsc_orgobjectives_types';
		
		INSERT INTO ebsc_orgobjectives_types(
			    objtype, name, description)
		    VALUES (0, 'Year', 'Year');

		INSERT INTO ebsc_orgobjectives_types(
			    objtype, name, description)
		    VALUES (1, 'Quarter', 'Quarter');

		INSERT INTO ebsc_orgobjectives_types(
			    objtype, name, description)
		    VALUES (2, 'Month', 'Month');
	END IF;

	-- Initialize ebsc_orgobjectives_types
	-- Type		Definition 				Explanation
	-- 1		Equal importance			Two activities contribute equally to the objective
	-- 2		Weak	
	-- 3		Moderate importance			Experience and judgment slightly favor one activity over another
	-- 4		Moderate plus	
	-- 5		Strong importance			Experience and judgment strongly favor one activity over another
	-- 6		Strong plus	
	-- 7		Very strong or demonstrated importance	An activity is favored very strongly over another; its dominance demonstrated in practice
	-- 8		Very, very strong	
	-- 9		Extreme importance			The evidence favoring on activity over another is of the highest possible order of affirmation

	SELECT count(*) INTO countVaule FROM ebsc_orgobjectives_fundamentalscales;
	IF (countVaule = 0) THEN 
		-- RAISE NOTICE
		RAISE NOTICE 'Initialize ebsc_orgobjectives_fundamentalscales';
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (1, 'Definition', 'Two activities contribute equally to the objective');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (2, 'Weak', '');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (3, 'Moderate importance', 'Experience and judgment slightly favor one activity over another');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (4, 'Moderate plus', '');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (5, 'Strong importance', 'Experience and judgment strongly favor one activity over another');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (6, 'Strong plus', '');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (7, 'Very strong or demonstrated importance', 'An activity is favored very strongly over another; its dominance demonstrated in practice');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (8, 'Very, very strong', '');
		
		INSERT INTO ebsc_orgobjectives_fundamentalscales(
			    scale, definition, explanation)
		    VALUES (9, 'Extreme importance', 'The evidence favoring on activity over another is of the highest possible order of affirmation');
	END IF;
	
	RETURN TRUE;
END
$$;


ALTER FUNCTION public.ebsc_initilize_data_tables() OWNER TO postgres;

--
-- TOC entry 21 (class 1255 OID 28201)
-- Dependencies: 3 698
-- Name: ebsc_insert_measure_ahp(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_insert_measure_ahp() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE	
	newId 		integer;
	newObjId	integer;
	currentRow	record;
	
BEGIN
	
	-- RAISE NOTICE
	RAISE NOTICE 'Execute ebsc_insert_measure_ahp()';
	
	newId := NEW.id;
	newObjId := NEW.obj_id;
	
	-- Vertical
	FOR currentRow IN (SELECT DISTINCT vindex FROM ebsc_orgobjectives_measure_ahp WHERE (obj_id = newObjId) AND (vindex != newId) ORDER BY vindex) LOOP		
		INSERT INTO ebsc_orgobjectives_measure_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, currentRow.vindex, newId, 0.00);
	END LOOP;

	-- Horizontal
	FOR currentRow IN (SELECT DISTINCT hindex FROM ebsc_orgobjectives_measure_ahp WHERE (obj_id = newObjId) AND (hindex != newId) ORDER BY hindex) LOOP		
		INSERT INTO ebsc_orgobjectives_measure_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, currentRow.hindex, 0.00);
	END LOOP;
	
	-- (newId, newId)
	INSERT INTO ebsc_orgobjectives_measure_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, newId, 1.00);

	RETURN NEW;
END;
$$;


ALTER FUNCTION public.ebsc_insert_measure_ahp() OWNER TO postgres;

--
-- TOC entry 22 (class 1255 OID 28202)
-- Dependencies: 3 698
-- Name: ebsc_insert_objective_ahp(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_insert_objective_ahp() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE	
	newId 		integer;
	newObjId	integer;
	currentRow	record;
	
BEGIN
	
	-- RAISE NOTICE
	RAISE NOTICE 'Execute ebsc_insert_objective_ahp()';
	
	newId := NEW.id;
	newObjId := NEW.obj_id;
	
	-- Vertical
	FOR currentRow IN (SELECT DISTINCT vindex FROM ebsc_orgobjectives_objective_ahp WHERE (obj_id = newObjId) AND (vindex != newId) ORDER BY vindex) LOOP		
		INSERT INTO ebsc_orgobjectives_objective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, currentRow.vindex, newId, 0.00);
	END LOOP;

	-- Horizontal
	FOR currentRow IN (SELECT DISTINCT hindex FROM ebsc_orgobjectives_objective_ahp WHERE (obj_id = newObjId) AND (hindex != newId) ORDER BY hindex) LOOP		
		INSERT INTO ebsc_orgobjectives_objective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, currentRow.hindex, 0.00);
	END LOOP;
	
	-- (newId, newId)
	INSERT INTO ebsc_orgobjectives_objective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, newId, 1.00);

	RETURN NEW;
END;
$$;


ALTER FUNCTION public.ebsc_insert_objective_ahp() OWNER TO postgres;

--
-- TOC entry 24 (class 1255 OID 28203)
-- Dependencies: 698 3
-- Name: ebsc_insert_perspective_ahp(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION ebsc_insert_perspective_ahp() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE	
	newId 		integer;
	newObjId	integer;
	currentRow	record;
	
BEGIN
	
	-- RAISE NOTICE
	RAISE NOTICE 'Execute ebsc_insert_perspective_ahp()';
	
	newId := NEW.id;
	newObjId := NEW.obj_id;
	
	-- Vertical
	FOR currentRow IN (SELECT DISTINCT vindex FROM ebsc_orgobjectives_perspective_ahp WHERE (obj_id = newObjId) AND (vindex != newId) ORDER BY vindex) LOOP		
		INSERT INTO ebsc_orgobjectives_perspective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, currentRow.vindex, newId, 0.00);
	END LOOP;

	-- Horizontal
	FOR currentRow IN (SELECT DISTINCT hindex FROM ebsc_orgobjectives_perspective_ahp WHERE (obj_id = newObjId) AND (hindex != newId) ORDER BY hindex) LOOP		
		INSERT INTO ebsc_orgobjectives_perspective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, currentRow.hindex, 0.00);
	END LOOP;
	
	-- (newId, newId)
	INSERT INTO ebsc_orgobjectives_perspective_ahp(
					obj_id, vindex, hindex, value)
		    VALUES (newObjId, newId, newId, 1.00);

	RETURN NEW;
END;
$$;


ALTER FUNCTION public.ebsc_insert_perspective_ahp() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1919 (class 1259 OID 28520)
-- Dependencies: 3
-- Name: account_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE account_ (
    accountid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentaccountid bigint,
    name character varying(75),
    legalname character varying(75),
    legalid character varying(75),
    legaltype character varying(75),
    siccode character varying(75),
    tickersymbol character varying(75),
    industry character varying(75),
    type_ character varying(75),
    size_ character varying(75)
);


ALTER TABLE public.account_ OWNER TO postgres;

--
-- TOC entry 1920 (class 1259 OID 28528)
-- Dependencies: 3
-- Name: address; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE address (
    addressid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    street1 character varying(75),
    street2 character varying(75),
    street3 character varying(75),
    city character varying(75),
    zip character varying(75),
    regionid bigint,
    countryid bigint,
    typeid integer,
    mailing boolean,
    primary_ boolean
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 1921 (class 1259 OID 28533)
-- Dependencies: 3
-- Name: announcementsdelivery; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE announcementsdelivery (
    deliveryid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    type_ character varying(75),
    email boolean,
    sms boolean,
    website boolean
);


ALTER TABLE public.announcementsdelivery OWNER TO postgres;

--
-- TOC entry 1922 (class 1259 OID 28538)
-- Dependencies: 3
-- Name: announcementsentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE announcementsentry (
    uuid_ character varying(75),
    entryid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    title character varying(75),
    content text,
    url text,
    type_ character varying(75),
    displaydate timestamp without time zone,
    expirationdate timestamp without time zone,
    priority integer,
    alert boolean
);


ALTER TABLE public.announcementsentry OWNER TO postgres;

--
-- TOC entry 1923 (class 1259 OID 28546)
-- Dependencies: 3
-- Name: announcementsflag; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE announcementsflag (
    flagid bigint NOT NULL,
    userid bigint,
    createdate timestamp without time zone,
    entryid bigint,
    value integer
);


ALTER TABLE public.announcementsflag OWNER TO postgres;

--
-- TOC entry 1924 (class 1259 OID 28551)
-- Dependencies: 3
-- Name: blogsentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE blogsentry (
    uuid_ character varying(75),
    entryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    title character varying(150),
    urltitle character varying(150),
    content text,
    displaydate timestamp without time zone,
    draft boolean,
    allowtrackbacks boolean,
    trackbacks text
);


ALTER TABLE public.blogsentry OWNER TO postgres;

--
-- TOC entry 1925 (class 1259 OID 28559)
-- Dependencies: 3
-- Name: blogsstatsuser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE blogsstatsuser (
    statsuserid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    entrycount integer,
    lastpostdate timestamp without time zone,
    ratingstotalentries integer,
    ratingstotalscore double precision,
    ratingsaveragescore double precision
);


ALTER TABLE public.blogsstatsuser OWNER TO postgres;

--
-- TOC entry 1926 (class 1259 OID 28564)
-- Dependencies: 3
-- Name: bookmarksentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bookmarksentry (
    uuid_ character varying(75),
    entryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    folderid bigint,
    name character varying(255),
    url text,
    comments text,
    visits integer,
    priority integer
);


ALTER TABLE public.bookmarksentry OWNER TO postgres;

--
-- TOC entry 1927 (class 1259 OID 28572)
-- Dependencies: 3
-- Name: bookmarksfolder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bookmarksfolder (
    uuid_ character varying(75),
    folderid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentfolderid bigint,
    name character varying(75),
    description text
);


ALTER TABLE public.bookmarksfolder OWNER TO postgres;

--
-- TOC entry 1928 (class 1259 OID 28580)
-- Dependencies: 3
-- Name: browsertracker; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE browsertracker (
    browsertrackerid bigint NOT NULL,
    userid bigint,
    browserkey bigint
);


ALTER TABLE public.browsertracker OWNER TO postgres;

--
-- TOC entry 1929 (class 1259 OID 28585)
-- Dependencies: 3
-- Name: calevent; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE calevent (
    uuid_ character varying(75),
    eventid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    title character varying(75),
    description text,
    startdate timestamp without time zone,
    enddate timestamp without time zone,
    durationhour integer,
    durationminute integer,
    allday boolean,
    timezonesensitive boolean,
    type_ character varying(75),
    repeating boolean,
    recurrence text,
    remindby integer,
    firstreminder integer,
    secondreminder integer
);


ALTER TABLE public.calevent OWNER TO postgres;

--
-- TOC entry 1930 (class 1259 OID 28593)
-- Dependencies: 3
-- Name: classname_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classname_ (
    classnameid bigint NOT NULL,
    value character varying(200)
);


ALTER TABLE public.classname_ OWNER TO postgres;

--
-- TOC entry 1931 (class 1259 OID 28598)
-- Dependencies: 3
-- Name: company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE company (
    companyid bigint NOT NULL,
    accountid bigint,
    webid character varying(75),
    key_ text,
    virtualhost character varying(75),
    mx character varying(75),
    homeurl text,
    logoid bigint,
    system boolean
);


ALTER TABLE public.company OWNER TO postgres;

--
-- TOC entry 1932 (class 1259 OID 28606)
-- Dependencies: 3
-- Name: contact_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE contact_ (
    contactid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    accountid bigint,
    parentcontactid bigint,
    firstname character varying(75),
    middlename character varying(75),
    lastname character varying(75),
    prefixid integer,
    suffixid integer,
    male boolean,
    birthday timestamp without time zone,
    smssn character varying(75),
    aimsn character varying(75),
    facebooksn character varying(75),
    icqsn character varying(75),
    jabbersn character varying(75),
    msnsn character varying(75),
    myspacesn character varying(75),
    skypesn character varying(75),
    twittersn character varying(75),
    ymsn character varying(75),
    employeestatusid character varying(75),
    employeenumber character varying(75),
    jobtitle character varying(100),
    jobclass character varying(75),
    hoursofoperation character varying(75)
);


ALTER TABLE public.contact_ OWNER TO postgres;

--
-- TOC entry 1933 (class 1259 OID 28614)
-- Dependencies: 3
-- Name: counter; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE counter (
    name character varying(75) NOT NULL,
    currentid bigint
);


ALTER TABLE public.counter OWNER TO postgres;

--
-- TOC entry 1934 (class 1259 OID 28619)
-- Dependencies: 3
-- Name: country; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE country (
    countryid bigint NOT NULL,
    name character varying(75),
    a2 character varying(75),
    a3 character varying(75),
    number_ character varying(75),
    idd_ character varying(75),
    active_ boolean
);


ALTER TABLE public.country OWNER TO postgres;

--
-- TOC entry 1935 (class 1259 OID 28624)
-- Dependencies: 3
-- Name: cyrususer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cyrususer (
    userid character varying(75) NOT NULL,
    password_ character varying(75) NOT NULL
);


ALTER TABLE public.cyrususer OWNER TO postgres;

--
-- TOC entry 1936 (class 1259 OID 28629)
-- Dependencies: 3
-- Name: cyrusvirtual; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cyrusvirtual (
    emailaddress character varying(75) NOT NULL,
    userid character varying(75) NOT NULL
);


ALTER TABLE public.cyrusvirtual OWNER TO postgres;

--
-- TOC entry 1937 (class 1259 OID 28634)
-- Dependencies: 3
-- Name: dlfileentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dlfileentry (
    uuid_ character varying(75),
    fileentryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    versionuserid bigint,
    versionusername character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    folderid bigint,
    name character varying(255),
    title character varying(255),
    description text,
    version double precision,
    size_ integer,
    readcount integer,
    extrasettings text
);


ALTER TABLE public.dlfileentry OWNER TO postgres;

--
-- TOC entry 1938 (class 1259 OID 28642)
-- Dependencies: 3
-- Name: dlfilerank; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dlfilerank (
    filerankid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    folderid bigint,
    name character varying(255)
);


ALTER TABLE public.dlfilerank OWNER TO postgres;

--
-- TOC entry 1939 (class 1259 OID 28647)
-- Dependencies: 3
-- Name: dlfileshortcut; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dlfileshortcut (
    uuid_ character varying(75),
    fileshortcutid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    folderid bigint,
    tofolderid bigint,
    toname character varying(255)
);


ALTER TABLE public.dlfileshortcut OWNER TO postgres;

--
-- TOC entry 1940 (class 1259 OID 28652)
-- Dependencies: 3
-- Name: dlfileversion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dlfileversion (
    fileversionid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    folderid bigint,
    name character varying(255),
    version double precision,
    size_ integer
);


ALTER TABLE public.dlfileversion OWNER TO postgres;

--
-- TOC entry 1941 (class 1259 OID 28657)
-- Dependencies: 3
-- Name: dlfolder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dlfolder (
    uuid_ character varying(75),
    folderid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentfolderid bigint,
    name character varying(100),
    description text,
    lastpostdate timestamp without time zone
);


ALTER TABLE public.dlfolder OWNER TO postgres;

--
-- TOC entry 1885 (class 1259 OID 28204)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_approval; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_approval (
    id integer NOT NULL,
    status integer,
    approved_date date,
    approved_by integer,
    reason text,
    obj_id integer NOT NULL
);


ALTER TABLE public.ebsc_orgobjectives_approval OWNER TO postgres;

--
-- TOC entry 1886 (class 1259 OID 28210)
-- Dependencies: 3 1885
-- Name: ebsc_orgobjectives_approval_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_approval_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_approval_id_seq OWNER TO postgres;

--
-- TOC entry 3207 (class 0 OID 0)
-- Dependencies: 1886
-- Name: ebsc_orgobjectives_approval_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_approval_id_seq OWNED BY ebsc_orgobjectives_approval.id;


--
-- TOC entry 1887 (class 1259 OID 28212)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_fundamentalscales; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_fundamentalscales (
    id integer NOT NULL,
    scale integer NOT NULL,
    definition character varying(75),
    explanation text
);


ALTER TABLE public.ebsc_orgobjectives_fundamentalscales OWNER TO postgres;

--
-- TOC entry 1888 (class 1259 OID 28218)
-- Dependencies: 1887 3
-- Name: ebsc_orgobjectives_fundamentalscales_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_fundamentalscales_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_fundamentalscales_id_seq OWNER TO postgres;

--
-- TOC entry 3208 (class 0 OID 0)
-- Dependencies: 1888
-- Name: ebsc_orgobjectives_fundamentalscales_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_fundamentalscales_id_seq OWNED BY ebsc_orgobjectives_fundamentalscales.id;


--
-- TOC entry 1889 (class 1259 OID 28220)
-- Dependencies: 2327 2328 2329 2330 2331 2332 2333 2335 2336 3
-- Name: ebsc_orgobjectives_list; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_list (
    id integer NOT NULL,
    org_id integer NOT NULL,
    name character varying(75) NOT NULL,
    description text,
    created_date time without time zone NOT NULL,
    year integer NOT NULL,
    objtype integer NOT NULL,
    entering_percent double precision DEFAULT 0.00 NOT NULL,
    completion_percent double precision DEFAULT 0.00 NOT NULL,
    isapproved boolean DEFAULT false NOT NULL,
    month_hash integer NOT NULL,
    validweight boolean DEFAULT false NOT NULL,
    current_total_cost double precision DEFAULT 0.00 NOT NULL,
    expected_completion double precision DEFAULT 0.00 NOT NULL,
    next_total_cost double precision DEFAULT 0.00 NOT NULL,
    consistency_ratio double precision DEFAULT 0.0 NOT NULL,
    parentid integer,
    next_total_cost2 double precision DEFAULT 0.0
);


ALTER TABLE public.ebsc_orgobjectives_list OWNER TO postgres;

--
-- TOC entry 1890 (class 1259 OID 28233)
-- Dependencies: 3 1889
-- Name: ebsc_orgobjectives_list_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_list_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_list_id_seq OWNER TO postgres;

--
-- TOC entry 3209 (class 0 OID 0)
-- Dependencies: 1890
-- Name: ebsc_orgobjectives_list_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_list_id_seq OWNED BY ebsc_orgobjectives_list.id;


--
-- TOC entry 1891 (class 1259 OID 28235)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_measure_ahp; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_measure_ahp (
    id integer NOT NULL,
    obj_id integer NOT NULL,
    vindex integer NOT NULL,
    hindex integer NOT NULL,
    value double precision
);


ALTER TABLE public.ebsc_orgobjectives_measure_ahp OWNER TO postgres;

--
-- TOC entry 1892 (class 1259 OID 28238)
-- Dependencies: 3 1891
-- Name: ebsc_orgobjectives_measure_ahp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_measure_ahp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_measure_ahp_id_seq OWNER TO postgres;

--
-- TOC entry 3210 (class 0 OID 0)
-- Dependencies: 1892
-- Name: ebsc_orgobjectives_measure_ahp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_measure_ahp_id_seq OWNED BY ebsc_orgobjectives_measure_ahp.id;


--
-- TOC entry 1893 (class 1259 OID 28240)
-- Dependencies: 2338 2339 2340 2341 2342 2343 2345 3
-- Name: ebsc_orgobjectives_measures; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_measures (
    id integer NOT NULL,
    obj_id integer NOT NULL,
    name character varying(75) NOT NULL,
    description text,
    created_date time without time zone NOT NULL,
    weight_percent double precision DEFAULT 0.00 NOT NULL,
    isassessed boolean DEFAULT false NOT NULL,
    result double precision DEFAULT 0.00,
    entering_percent double precision DEFAULT 0.00 NOT NULL,
    completion_percent double precision DEFAULT 0.00 NOT NULL,
    formula text,
    target_count integer DEFAULT 0 NOT NULL,
    interpretation text,
    weight_percent_suggested double precision DEFAULT 0.0 NOT NULL
);


ALTER TABLE public.ebsc_orgobjectives_measures OWNER TO postgres;

--
-- TOC entry 1894 (class 1259 OID 28252)
-- Dependencies: 3 1893
-- Name: ebsc_orgobjectives_measures_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_measures_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_measures_id_seq OWNER TO postgres;

--
-- TOC entry 3211 (class 0 OID 0)
-- Dependencies: 1894
-- Name: ebsc_orgobjectives_measures_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_measures_id_seq OWNED BY ebsc_orgobjectives_measures.id;


--
-- TOC entry 1895 (class 1259 OID 28254)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_objective_ahp; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_objective_ahp (
    id integer NOT NULL,
    obj_id integer NOT NULL,
    vindex integer NOT NULL,
    hindex integer NOT NULL,
    value double precision
);


ALTER TABLE public.ebsc_orgobjectives_objective_ahp OWNER TO postgres;

--
-- TOC entry 1896 (class 1259 OID 28257)
-- Dependencies: 3 1895
-- Name: ebsc_orgobjectives_objective_ahp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_objective_ahp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_objective_ahp_id_seq OWNER TO postgres;

--
-- TOC entry 3212 (class 0 OID 0)
-- Dependencies: 1896
-- Name: ebsc_orgobjectives_objective_ahp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_objective_ahp_id_seq OWNED BY ebsc_orgobjectives_objective_ahp.id;


--
-- TOC entry 1897 (class 1259 OID 28259)
-- Dependencies: 2347 2348 2349 2350 2351 2353 2354 3
-- Name: ebsc_orgobjectives_objectives; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_objectives (
    id integer NOT NULL,
    obj_id integer NOT NULL,
    name character varying(75) NOT NULL,
    description text,
    created_date time without time zone NOT NULL,
    weight_percent double precision DEFAULT 0.00 NOT NULL,
    entering_percent double precision DEFAULT 0.00 NOT NULL,
    completion_percent double precision DEFAULT 0.00 NOT NULL,
    measure_count integer DEFAULT 0 NOT NULL,
    validweight boolean DEFAULT false NOT NULL,
    consistency_ratio double precision DEFAULT 0.0 NOT NULL,
    weight_percent_suggested double precision DEFAULT 0.0 NOT NULL
);


ALTER TABLE public.ebsc_orgobjectives_objectives OWNER TO postgres;

--
-- TOC entry 1898 (class 1259 OID 28270)
-- Dependencies: 3 1897
-- Name: ebsc_orgobjectives_objectives_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_objectives_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_objectives_id_seq OWNER TO postgres;

--
-- TOC entry 3213 (class 0 OID 0)
-- Dependencies: 1898
-- Name: ebsc_orgobjectives_objectives_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_objectives_id_seq OWNED BY ebsc_orgobjectives_objectives.id;


--
-- TOC entry 1899 (class 1259 OID 28272)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_perspective_ahp; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_perspective_ahp (
    id integer NOT NULL,
    vindex integer NOT NULL,
    hindex integer NOT NULL,
    value double precision,
    obj_id integer NOT NULL
);


ALTER TABLE public.ebsc_orgobjectives_perspective_ahp OWNER TO postgres;

--
-- TOC entry 1900 (class 1259 OID 28275)
-- Dependencies: 3 1899
-- Name: ebsc_orgobjectives_perspective_ahp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_perspective_ahp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_perspective_ahp_id_seq OWNER TO postgres;

--
-- TOC entry 3214 (class 0 OID 0)
-- Dependencies: 1900
-- Name: ebsc_orgobjectives_perspective_ahp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_perspective_ahp_id_seq OWNED BY ebsc_orgobjectives_perspective_ahp.id;


--
-- TOC entry 1901 (class 1259 OID 28277)
-- Dependencies: 2356 2357 2358 2359 2360 2361 2362 2364 2365 2366 3
-- Name: ebsc_orgobjectives_perspectives; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_perspectives (
    id integer NOT NULL,
    obj_id integer NOT NULL,
    name character varying(75) NOT NULL,
    description text,
    weight_percent double precision DEFAULT 0.00 NOT NULL,
    entering_percent double precision DEFAULT 0.00 NOT NULL,
    completion_percent double precision DEFAULT 0.00 NOT NULL,
    objective_count double precision DEFAULT 0 NOT NULL,
    validweight boolean DEFAULT false NOT NULL,
    pertype integer NOT NULL,
    current_cost double precision DEFAULT 0.00 NOT NULL,
    next_cost double precision DEFAULT 0.00 NOT NULL,
    consistency_ratio double precision DEFAULT 0.0 NOT NULL,
    weight_percent_suggested double precision DEFAULT 0.0 NOT NULL,
    next_cost2 double precision DEFAULT 0.0
);


ALTER TABLE public.ebsc_orgobjectives_perspectives OWNER TO postgres;

--
-- TOC entry 1902 (class 1259 OID 28290)
-- Dependencies: 3 1901
-- Name: ebsc_orgobjectives_perspectives_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_perspectives_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_perspectives_id_seq OWNER TO postgres;

--
-- TOC entry 3215 (class 0 OID 0)
-- Dependencies: 1902
-- Name: ebsc_orgobjectives_perspectives_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_perspectives_id_seq OWNED BY ebsc_orgobjectives_perspectives.id;


--
-- TOC entry 1903 (class 1259 OID 28292)
-- Dependencies: 2367 2368 3
-- Name: ebsc_orgobjectives_targets; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_targets (
    id integer NOT NULL,
    mea_id integer NOT NULL,
    name character varying(75) NOT NULL,
    description text,
    created_date time without time zone NOT NULL,
    value double precision DEFAULT 0.00,
    minmax boolean DEFAULT false
);


ALTER TABLE public.ebsc_orgobjectives_targets OWNER TO postgres;

--
-- TOC entry 1904 (class 1259 OID 28300)
-- Dependencies: 1903 3
-- Name: ebsc_orgobjectives_targets_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_targets_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_targets_id_seq OWNER TO postgres;

--
-- TOC entry 3216 (class 0 OID 0)
-- Dependencies: 1904
-- Name: ebsc_orgobjectives_targets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_targets_id_seq OWNED BY ebsc_orgobjectives_targets.id;


--
-- TOC entry 1905 (class 1259 OID 28302)
-- Dependencies: 3
-- Name: ebsc_orgobjectives_types; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ebsc_orgobjectives_types (
    id integer NOT NULL,
    objtype integer NOT NULL,
    name character varying(75) NOT NULL,
    description text
);


ALTER TABLE public.ebsc_orgobjectives_types OWNER TO postgres;

--
-- TOC entry 1906 (class 1259 OID 28308)
-- Dependencies: 3 1905
-- Name: ebsc_orgobjectives_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ebsc_orgobjectives_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.ebsc_orgobjectives_types_id_seq OWNER TO postgres;

--
-- TOC entry 3217 (class 0 OID 0)
-- Dependencies: 1906
-- Name: ebsc_orgobjectives_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ebsc_orgobjectives_types_id_seq OWNED BY ebsc_orgobjectives_types.id;


--
-- TOC entry 1942 (class 1259 OID 28665)
-- Dependencies: 3
-- Name: emailaddress; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE emailaddress (
    emailaddressid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    address character varying(75),
    typeid integer,
    primary_ boolean
);


ALTER TABLE public.emailaddress OWNER TO postgres;

--
-- TOC entry 1943 (class 1259 OID 28670)
-- Dependencies: 3
-- Name: expandocolumn; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE expandocolumn (
    columnid bigint NOT NULL,
    companyid bigint,
    tableid bigint,
    name character varying(75),
    type_ integer,
    defaultdata text,
    typesettings text
);


ALTER TABLE public.expandocolumn OWNER TO postgres;

--
-- TOC entry 1944 (class 1259 OID 28678)
-- Dependencies: 3
-- Name: expandorow; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE expandorow (
    rowid_ bigint NOT NULL,
    companyid bigint,
    tableid bigint,
    classpk bigint
);


ALTER TABLE public.expandorow OWNER TO postgres;

--
-- TOC entry 1945 (class 1259 OID 28683)
-- Dependencies: 3
-- Name: expandotable; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE expandotable (
    tableid bigint NOT NULL,
    companyid bigint,
    classnameid bigint,
    name character varying(75)
);


ALTER TABLE public.expandotable OWNER TO postgres;

--
-- TOC entry 1946 (class 1259 OID 28688)
-- Dependencies: 3
-- Name: expandovalue; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE expandovalue (
    valueid bigint NOT NULL,
    companyid bigint,
    tableid bigint,
    columnid bigint,
    rowid_ bigint,
    classnameid bigint,
    classpk bigint,
    data_ text
);


ALTER TABLE public.expandovalue OWNER TO postgres;

--
-- TOC entry 1947 (class 1259 OID 28696)
-- Dependencies: 3
-- Name: group_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE group_ (
    groupid bigint NOT NULL,
    companyid bigint,
    creatoruserid bigint,
    classnameid bigint,
    classpk bigint,
    parentgroupid bigint,
    livegroupid bigint,
    name character varying(75),
    description text,
    type_ integer,
    typesettings text,
    friendlyurl character varying(100),
    active_ boolean
);


ALTER TABLE public.group_ OWNER TO postgres;

--
-- TOC entry 1948 (class 1259 OID 28704)
-- Dependencies: 3
-- Name: groups_orgs; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE groups_orgs (
    groupid bigint NOT NULL,
    organizationid bigint NOT NULL
);


ALTER TABLE public.groups_orgs OWNER TO postgres;

--
-- TOC entry 1949 (class 1259 OID 28709)
-- Dependencies: 3
-- Name: groups_permissions; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE groups_permissions (
    groupid bigint NOT NULL,
    permissionid bigint NOT NULL
);


ALTER TABLE public.groups_permissions OWNER TO postgres;

--
-- TOC entry 1950 (class 1259 OID 28714)
-- Dependencies: 3
-- Name: groups_roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE groups_roles (
    groupid bigint NOT NULL,
    roleid bigint NOT NULL
);


ALTER TABLE public.groups_roles OWNER TO postgres;

--
-- TOC entry 1951 (class 1259 OID 28719)
-- Dependencies: 3
-- Name: groups_usergroups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE groups_usergroups (
    groupid bigint NOT NULL,
    usergroupid bigint NOT NULL
);


ALTER TABLE public.groups_usergroups OWNER TO postgres;

--
-- TOC entry 1952 (class 1259 OID 28724)
-- Dependencies: 3
-- Name: igfolder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE igfolder (
    uuid_ character varying(75),
    folderid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentfolderid bigint,
    name character varying(75),
    description text
);


ALTER TABLE public.igfolder OWNER TO postgres;

--
-- TOC entry 1953 (class 1259 OID 28732)
-- Dependencies: 3
-- Name: igimage; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE igimage (
    uuid_ character varying(75),
    imageid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    folderid bigint,
    name character varying(75),
    description text,
    smallimageid bigint,
    largeimageid bigint,
    custom1imageid bigint,
    custom2imageid bigint
);


ALTER TABLE public.igimage OWNER TO postgres;

--
-- TOC entry 1954 (class 1259 OID 28740)
-- Dependencies: 3
-- Name: image; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE image (
    imageid bigint NOT NULL,
    modifieddate timestamp without time zone,
    text_ text,
    type_ character varying(75),
    height integer,
    width integer,
    size_ integer
);


ALTER TABLE public.image OWNER TO postgres;

--
-- TOC entry 1955 (class 1259 OID 28748)
-- Dependencies: 3
-- Name: journalarticle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalarticle (
    uuid_ character varying(75),
    id_ bigint NOT NULL,
    resourceprimkey bigint,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    articleid character varying(75),
    version double precision,
    title character varying(100),
    urltitle character varying(150),
    description text,
    content text,
    type_ character varying(75),
    structureid character varying(75),
    templateid character varying(75),
    displaydate timestamp without time zone,
    approved boolean,
    approvedbyuserid bigint,
    approvedbyusername character varying(75),
    approveddate timestamp without time zone,
    expired boolean,
    expirationdate timestamp without time zone,
    reviewdate timestamp without time zone,
    indexable boolean,
    smallimage boolean,
    smallimageid bigint,
    smallimageurl character varying(75)
);


ALTER TABLE public.journalarticle OWNER TO postgres;

--
-- TOC entry 1956 (class 1259 OID 28756)
-- Dependencies: 3
-- Name: journalarticleimage; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalarticleimage (
    articleimageid bigint NOT NULL,
    groupid bigint,
    articleid character varying(75),
    version double precision,
    elinstanceid character varying(75),
    elname character varying(75),
    languageid character varying(75),
    tempimage boolean
);


ALTER TABLE public.journalarticleimage OWNER TO postgres;

--
-- TOC entry 1957 (class 1259 OID 28761)
-- Dependencies: 3
-- Name: journalarticleresource; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalarticleresource (
    resourceprimkey bigint NOT NULL,
    groupid bigint,
    articleid character varying(75)
);


ALTER TABLE public.journalarticleresource OWNER TO postgres;

--
-- TOC entry 1958 (class 1259 OID 28766)
-- Dependencies: 3
-- Name: journalcontentsearch; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalcontentsearch (
    contentsearchid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    privatelayout boolean,
    layoutid bigint,
    portletid character varying(200),
    articleid character varying(75)
);


ALTER TABLE public.journalcontentsearch OWNER TO postgres;

--
-- TOC entry 1959 (class 1259 OID 28771)
-- Dependencies: 3
-- Name: journalfeed; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalfeed (
    uuid_ character varying(75),
    id_ bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    feedid character varying(75),
    name character varying(75),
    description text,
    type_ character varying(75),
    structureid character varying(75),
    templateid character varying(75),
    renderertemplateid character varying(75),
    delta integer,
    orderbycol character varying(75),
    orderbytype character varying(75),
    targetlayoutfriendlyurl character varying(75),
    targetportletid character varying(75),
    contentfield character varying(75),
    feedtype character varying(75),
    feedversion double precision
);


ALTER TABLE public.journalfeed OWNER TO postgres;

--
-- TOC entry 1960 (class 1259 OID 28779)
-- Dependencies: 3
-- Name: journalstructure; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journalstructure (
    uuid_ character varying(75),
    id_ bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    structureid character varying(75),
    parentstructureid character varying(75),
    name character varying(75),
    description text,
    xsd text
);


ALTER TABLE public.journalstructure OWNER TO postgres;

--
-- TOC entry 1961 (class 1259 OID 28787)
-- Dependencies: 3
-- Name: journaltemplate; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE journaltemplate (
    uuid_ character varying(75),
    id_ bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    templateid character varying(75),
    structureid character varying(75),
    name character varying(75),
    description text,
    xsl text,
    langtype character varying(75),
    cacheable boolean,
    smallimage boolean,
    smallimageid bigint,
    smallimageurl character varying(75)
);


ALTER TABLE public.journaltemplate OWNER TO postgres;

--
-- TOC entry 1962 (class 1259 OID 28795)
-- Dependencies: 3
-- Name: layout; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE layout (
    plid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    privatelayout boolean,
    layoutid bigint,
    parentlayoutid bigint,
    name text,
    title text,
    description text,
    type_ character varying(75),
    typesettings text,
    hidden_ boolean,
    friendlyurl character varying(100),
    iconimage boolean,
    iconimageid bigint,
    themeid character varying(75),
    colorschemeid character varying(75),
    wapthemeid character varying(75),
    wapcolorschemeid character varying(75),
    css text,
    priority integer,
    dlfolderid bigint
);


ALTER TABLE public.layout OWNER TO postgres;

--
-- TOC entry 1963 (class 1259 OID 28803)
-- Dependencies: 3
-- Name: layoutset; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE layoutset (
    layoutsetid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    privatelayout boolean,
    logo boolean,
    logoid bigint,
    themeid character varying(75),
    colorschemeid character varying(75),
    wapthemeid character varying(75),
    wapcolorschemeid character varying(75),
    css text,
    pagecount integer,
    virtualhost character varying(75)
);


ALTER TABLE public.layoutset OWNER TO postgres;

--
-- TOC entry 1964 (class 1259 OID 28811)
-- Dependencies: 3
-- Name: listtype; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE listtype (
    listtypeid integer NOT NULL,
    name character varying(75),
    type_ character varying(75)
);


ALTER TABLE public.listtype OWNER TO postgres;

--
-- TOC entry 1965 (class 1259 OID 28816)
-- Dependencies: 3
-- Name: mbban; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbban (
    banid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    banuserid bigint
);


ALTER TABLE public.mbban OWNER TO postgres;

--
-- TOC entry 1966 (class 1259 OID 28821)
-- Dependencies: 3
-- Name: mbcategory; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbcategory (
    uuid_ character varying(75),
    categoryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentcategoryid bigint,
    name character varying(75),
    description text,
    threadcount integer,
    messagecount integer,
    lastpostdate timestamp without time zone
);


ALTER TABLE public.mbcategory OWNER TO postgres;

--
-- TOC entry 1967 (class 1259 OID 28829)
-- Dependencies: 3
-- Name: mbdiscussion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbdiscussion (
    discussionid bigint NOT NULL,
    classnameid bigint,
    classpk bigint,
    threadid bigint
);


ALTER TABLE public.mbdiscussion OWNER TO postgres;

--
-- TOC entry 1968 (class 1259 OID 28834)
-- Dependencies: 3
-- Name: mbmailinglist; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbmailinglist (
    uuid_ character varying(75),
    mailinglistid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    categoryid bigint,
    emailaddress character varying(75),
    inprotocol character varying(75),
    inservername character varying(75),
    inserverport integer,
    inusessl boolean,
    inusername character varying(75),
    inpassword character varying(75),
    inreadinterval integer,
    outemailaddress character varying(75),
    outcustom boolean,
    outservername character varying(75),
    outserverport integer,
    outusessl boolean,
    outusername character varying(75),
    outpassword character varying(75),
    active_ boolean
);


ALTER TABLE public.mbmailinglist OWNER TO postgres;

--
-- TOC entry 1969 (class 1259 OID 28842)
-- Dependencies: 3
-- Name: mbmessage; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbmessage (
    uuid_ character varying(75),
    messageid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    categoryid bigint,
    threadid bigint,
    parentmessageid bigint,
    subject character varying(75),
    body text,
    attachments boolean,
    anonymous boolean,
    priority double precision
);


ALTER TABLE public.mbmessage OWNER TO postgres;

--
-- TOC entry 1970 (class 1259 OID 28850)
-- Dependencies: 3
-- Name: mbmessageflag; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbmessageflag (
    messageflagid bigint NOT NULL,
    userid bigint,
    modifieddate timestamp without time zone,
    threadid bigint,
    messageid bigint,
    flag integer
);


ALTER TABLE public.mbmessageflag OWNER TO postgres;

--
-- TOC entry 1971 (class 1259 OID 28855)
-- Dependencies: 3
-- Name: mbstatsuser; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbstatsuser (
    statsuserid bigint NOT NULL,
    groupid bigint,
    userid bigint,
    messagecount integer,
    lastpostdate timestamp without time zone
);


ALTER TABLE public.mbstatsuser OWNER TO postgres;

--
-- TOC entry 1972 (class 1259 OID 28860)
-- Dependencies: 3
-- Name: mbthread; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE mbthread (
    threadid bigint NOT NULL,
    groupid bigint,
    categoryid bigint,
    rootmessageid bigint,
    messagecount integer,
    viewcount integer,
    lastpostbyuserid bigint,
    lastpostdate timestamp without time zone,
    priority double precision
);


ALTER TABLE public.mbthread OWNER TO postgres;

--
-- TOC entry 1973 (class 1259 OID 28865)
-- Dependencies: 3
-- Name: membershiprequest; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE membershiprequest (
    membershiprequestid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    groupid bigint,
    comments text,
    replycomments text,
    replydate timestamp without time zone,
    replieruserid bigint,
    statusid integer
);


ALTER TABLE public.membershiprequest OWNER TO postgres;

--
-- TOC entry 1974 (class 1259 OID 28873)
-- Dependencies: 3
-- Name: organization_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE organization_ (
    organizationid bigint NOT NULL,
    companyid bigint,
    parentorganizationid bigint,
    leftorganizationid bigint,
    rightorganizationid bigint,
    name character varying(100),
    type_ character varying(75),
    recursable boolean,
    regionid bigint,
    countryid bigint,
    statusid integer,
    comments text
);


ALTER TABLE public.organization_ OWNER TO postgres;

--
-- TOC entry 2047 (class 1259 OID 31866)
-- Dependencies: 3
-- Name: organizations; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE organizations (
    id integer NOT NULL,
    name character varying(75),
    abbreviation character varying(75),
    description character varying(75),
    max_user_count integer,
    expired_date timestamp without time zone,
    eid character varying(75),
    address1 character varying(75),
    address2 character varying(75),
    city character varying(75),
    state character varying(75),
    country character varying(75),
    phone character varying(75),
    show_logo boolean,
    org_status boolean,
    created_at timestamp without time zone,
    org_type character varying(75),
    updated_at timestamp without time zone
);


ALTER TABLE public.organizations OWNER TO postgres;

--
-- TOC entry 1975 (class 1259 OID 28881)
-- Dependencies: 3
-- Name: orggrouppermission; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orggrouppermission (
    organizationid bigint NOT NULL,
    groupid bigint NOT NULL,
    permissionid bigint NOT NULL
);


ALTER TABLE public.orggrouppermission OWNER TO postgres;

--
-- TOC entry 1976 (class 1259 OID 28886)
-- Dependencies: 3
-- Name: orggrouprole; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orggrouprole (
    organizationid bigint NOT NULL,
    groupid bigint NOT NULL,
    roleid bigint NOT NULL
);


ALTER TABLE public.orggrouprole OWNER TO postgres;

--
-- TOC entry 1977 (class 1259 OID 28891)
-- Dependencies: 3
-- Name: orglabor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE orglabor (
    orglaborid bigint NOT NULL,
    organizationid bigint,
    typeid integer,
    sunopen integer,
    sunclose integer,
    monopen integer,
    monclose integer,
    tueopen integer,
    tueclose integer,
    wedopen integer,
    wedclose integer,
    thuopen integer,
    thuclose integer,
    friopen integer,
    friclose integer,
    satopen integer,
    satclose integer
);


ALTER TABLE public.orglabor OWNER TO postgres;

--
-- TOC entry 1978 (class 1259 OID 28896)
-- Dependencies: 3
-- Name: passwordpolicy; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE passwordpolicy (
    passwordpolicyid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    defaultpolicy boolean,
    name character varying(75),
    description text,
    changeable boolean,
    changerequired boolean,
    minage bigint,
    checksyntax boolean,
    allowdictionarywords boolean,
    minlength integer,
    history boolean,
    historycount integer,
    expireable boolean,
    maxage bigint,
    warningtime bigint,
    gracelimit integer,
    lockout boolean,
    maxfailure integer,
    lockoutduration bigint,
    requireunlock boolean,
    resetfailurecount bigint
);


ALTER TABLE public.passwordpolicy OWNER TO postgres;

--
-- TOC entry 1979 (class 1259 OID 28904)
-- Dependencies: 3
-- Name: passwordpolicyrel; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE passwordpolicyrel (
    passwordpolicyrelid bigint NOT NULL,
    passwordpolicyid bigint,
    classnameid bigint,
    classpk bigint
);


ALTER TABLE public.passwordpolicyrel OWNER TO postgres;

--
-- TOC entry 1980 (class 1259 OID 28909)
-- Dependencies: 3
-- Name: passwordtracker; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE passwordtracker (
    passwordtrackerid bigint NOT NULL,
    userid bigint,
    createdate timestamp without time zone,
    password_ character varying(75)
);


ALTER TABLE public.passwordtracker OWNER TO postgres;

--
-- TOC entry 1981 (class 1259 OID 28914)
-- Dependencies: 3
-- Name: permission_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permission_ (
    permissionid bigint NOT NULL,
    companyid bigint,
    actionid character varying(75),
    resourceid bigint
);


ALTER TABLE public.permission_ OWNER TO postgres;

--
-- TOC entry 1982 (class 1259 OID 28919)
-- Dependencies: 3
-- Name: phone; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE phone (
    phoneid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    number_ character varying(75),
    extension character varying(75),
    typeid integer,
    primary_ boolean
);


ALTER TABLE public.phone OWNER TO postgres;

--
-- TOC entry 1983 (class 1259 OID 28924)
-- Dependencies: 3
-- Name: pluginsetting; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pluginsetting (
    pluginsettingid bigint NOT NULL,
    companyid bigint,
    pluginid character varying(75),
    plugintype character varying(75),
    roles text,
    active_ boolean
);


ALTER TABLE public.pluginsetting OWNER TO postgres;

--
-- TOC entry 1984 (class 1259 OID 28932)
-- Dependencies: 3
-- Name: pollschoice; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pollschoice (
    uuid_ character varying(75),
    choiceid bigint NOT NULL,
    questionid bigint,
    name character varying(75),
    description character varying(1000)
);


ALTER TABLE public.pollschoice OWNER TO postgres;

--
-- TOC entry 1985 (class 1259 OID 28940)
-- Dependencies: 3
-- Name: pollsquestion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pollsquestion (
    uuid_ character varying(75),
    questionid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    title character varying(500),
    description text,
    expirationdate timestamp without time zone,
    lastvotedate timestamp without time zone
);


ALTER TABLE public.pollsquestion OWNER TO postgres;

--
-- TOC entry 1986 (class 1259 OID 28948)
-- Dependencies: 3
-- Name: pollsvote; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pollsvote (
    voteid bigint NOT NULL,
    userid bigint,
    questionid bigint,
    choiceid bigint,
    votedate timestamp without time zone
);


ALTER TABLE public.pollsvote OWNER TO postgres;

--
-- TOC entry 1987 (class 1259 OID 28953)
-- Dependencies: 3
-- Name: portlet; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE portlet (
    id_ bigint NOT NULL,
    companyid bigint,
    portletid character varying(200),
    roles text,
    active_ boolean
);


ALTER TABLE public.portlet OWNER TO postgres;

--
-- TOC entry 1988 (class 1259 OID 28961)
-- Dependencies: 3
-- Name: portletitem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE portletitem (
    portletitemid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    portletid character varying(75),
    classnameid bigint
);


ALTER TABLE public.portletitem OWNER TO postgres;

--
-- TOC entry 1989 (class 1259 OID 28966)
-- Dependencies: 3
-- Name: portletpreferences; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE portletpreferences (
    portletpreferencesid bigint NOT NULL,
    ownerid bigint,
    ownertype integer,
    plid bigint,
    portletid character varying(200),
    preferences text
);


ALTER TABLE public.portletpreferences OWNER TO postgres;

--
-- TOC entry 1912 (class 1259 OID 28467)
-- Dependencies: 3
-- Name: quartz_blob_triggers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_blob_triggers (
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    blob_data bytea
);


ALTER TABLE public.quartz_blob_triggers OWNER TO postgres;

--
-- TOC entry 1914 (class 1259 OID 28480)
-- Dependencies: 3
-- Name: quartz_calendars; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_calendars (
    calendar_name character varying(80) NOT NULL,
    calendar bytea NOT NULL
);


ALTER TABLE public.quartz_calendars OWNER TO postgres;

--
-- TOC entry 1911 (class 1259 OID 28462)
-- Dependencies: 3
-- Name: quartz_cron_triggers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_cron_triggers (
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    cron_expression character varying(80) NOT NULL,
    time_zone_id character varying(80)
);


ALTER TABLE public.quartz_cron_triggers OWNER TO postgres;

--
-- TOC entry 1916 (class 1259 OID 28493)
-- Dependencies: 3
-- Name: quartz_fired_triggers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_fired_triggers (
    entry_id character varying(95) NOT NULL,
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    is_volatile boolean NOT NULL,
    instance_name character varying(80) NOT NULL,
    fired_time bigint NOT NULL,
    priority integer NOT NULL,
    state character varying(16) NOT NULL,
    job_name character varying(80),
    job_group character varying(80),
    is_stateful boolean,
    requests_recovery boolean
);


ALTER TABLE public.quartz_fired_triggers OWNER TO postgres;

--
-- TOC entry 1907 (class 1259 OID 28436)
-- Dependencies: 3
-- Name: quartz_job_details; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_job_details (
    job_name character varying(80) NOT NULL,
    job_group character varying(80) NOT NULL,
    description character varying(120),
    job_class_name character varying(128) NOT NULL,
    is_durable boolean NOT NULL,
    is_volatile boolean NOT NULL,
    is_stateful boolean NOT NULL,
    requests_recovery boolean NOT NULL,
    job_data bytea
);


ALTER TABLE public.quartz_job_details OWNER TO postgres;

--
-- TOC entry 1908 (class 1259 OID 28444)
-- Dependencies: 3
-- Name: quartz_job_listeners; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_job_listeners (
    job_name character varying(80) NOT NULL,
    job_group character varying(80) NOT NULL,
    job_listener character varying(80) NOT NULL
);


ALTER TABLE public.quartz_job_listeners OWNER TO postgres;

--
-- TOC entry 1918 (class 1259 OID 28506)
-- Dependencies: 3
-- Name: quartz_locks; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_locks (
    lock_name character varying(40) NOT NULL
);


ALTER TABLE public.quartz_locks OWNER TO postgres;

--
-- TOC entry 1915 (class 1259 OID 28488)
-- Dependencies: 3
-- Name: quartz_paused_trigger_grps; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_paused_trigger_grps (
    trigger_group character varying(80) NOT NULL
);


ALTER TABLE public.quartz_paused_trigger_grps OWNER TO postgres;

--
-- TOC entry 1917 (class 1259 OID 28501)
-- Dependencies: 3
-- Name: quartz_scheduler_state; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_scheduler_state (
    instance_name character varying(80) NOT NULL,
    last_checkin_time bigint NOT NULL,
    checkin_interval bigint NOT NULL
);


ALTER TABLE public.quartz_scheduler_state OWNER TO postgres;

--
-- TOC entry 1910 (class 1259 OID 28457)
-- Dependencies: 3
-- Name: quartz_simple_triggers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_simple_triggers (
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    repeat_count bigint NOT NULL,
    repeat_interval bigint NOT NULL,
    times_triggered bigint NOT NULL
);


ALTER TABLE public.quartz_simple_triggers OWNER TO postgres;

--
-- TOC entry 1913 (class 1259 OID 28475)
-- Dependencies: 3
-- Name: quartz_trigger_listeners; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_trigger_listeners (
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    trigger_listener character varying(80) NOT NULL
);


ALTER TABLE public.quartz_trigger_listeners OWNER TO postgres;

--
-- TOC entry 1909 (class 1259 OID 28449)
-- Dependencies: 3
-- Name: quartz_triggers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quartz_triggers (
    trigger_name character varying(80) NOT NULL,
    trigger_group character varying(80) NOT NULL,
    job_name character varying(80) NOT NULL,
    job_group character varying(80) NOT NULL,
    is_volatile boolean NOT NULL,
    description character varying(120),
    next_fire_time bigint,
    prev_fire_time bigint,
    priority integer,
    trigger_state character varying(16) NOT NULL,
    trigger_type character varying(8) NOT NULL,
    start_time bigint NOT NULL,
    end_time bigint,
    calendar_name character varying(80),
    misfire_instr integer,
    job_data bytea
);


ALTER TABLE public.quartz_triggers OWNER TO postgres;

--
-- TOC entry 1990 (class 1259 OID 28974)
-- Dependencies: 3
-- Name: ratingsentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ratingsentry (
    entryid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    score double precision
);


ALTER TABLE public.ratingsentry OWNER TO postgres;

--
-- TOC entry 1991 (class 1259 OID 28979)
-- Dependencies: 3
-- Name: ratingsstats; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ratingsstats (
    statsid bigint NOT NULL,
    classnameid bigint,
    classpk bigint,
    totalentries integer,
    totalscore double precision,
    averagescore double precision
);


ALTER TABLE public.ratingsstats OWNER TO postgres;

--
-- TOC entry 1992 (class 1259 OID 28984)
-- Dependencies: 3
-- Name: region; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE region (
    regionid bigint NOT NULL,
    countryid bigint,
    regioncode character varying(75),
    name character varying(75),
    active_ boolean
);


ALTER TABLE public.region OWNER TO postgres;

--
-- TOC entry 1993 (class 1259 OID 28989)
-- Dependencies: 3
-- Name: release_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE release_ (
    releaseid bigint NOT NULL,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    buildnumber integer,
    builddate timestamp without time zone,
    verified boolean,
    teststring character varying(1024)
);


ALTER TABLE public.release_ OWNER TO postgres;

--
-- TOC entry 1994 (class 1259 OID 28997)
-- Dependencies: 3
-- Name: resource_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE resource_ (
    resourceid bigint NOT NULL,
    codeid bigint,
    primkey character varying(255)
);


ALTER TABLE public.resource_ OWNER TO postgres;

--
-- TOC entry 1995 (class 1259 OID 29002)
-- Dependencies: 3
-- Name: resourceaction; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE resourceaction (
    resourceactionid bigint NOT NULL,
    name character varying(75),
    actionid character varying(75),
    bitwisevalue bigint
);


ALTER TABLE public.resourceaction OWNER TO postgres;

--
-- TOC entry 1996 (class 1259 OID 29007)
-- Dependencies: 3
-- Name: resourcecode; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE resourcecode (
    codeid bigint NOT NULL,
    companyid bigint,
    name character varying(255),
    scope integer
);


ALTER TABLE public.resourcecode OWNER TO postgres;

--
-- TOC entry 1997 (class 1259 OID 29012)
-- Dependencies: 3
-- Name: resourcepermission; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE resourcepermission (
    resourcepermissionid bigint NOT NULL,
    companyid bigint,
    name character varying(255),
    scope integer,
    primkey character varying(255),
    roleid bigint,
    actionids bigint
);


ALTER TABLE public.resourcepermission OWNER TO postgres;

--
-- TOC entry 1998 (class 1259 OID 29020)
-- Dependencies: 3
-- Name: role_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE role_ (
    roleid bigint NOT NULL,
    companyid bigint,
    classnameid bigint,
    classpk bigint,
    name character varying(75),
    title text,
    description text,
    type_ integer,
    subtype character varying(75)
);


ALTER TABLE public.role_ OWNER TO postgres;

--
-- TOC entry 1999 (class 1259 OID 29028)
-- Dependencies: 3
-- Name: roles_permissions; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roles_permissions (
    roleid bigint NOT NULL,
    permissionid bigint NOT NULL
);


ALTER TABLE public.roles_permissions OWNER TO postgres;

--
-- TOC entry 2000 (class 1259 OID 29033)
-- Dependencies: 3
-- Name: scframeworkversi_scproductvers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scframeworkversi_scproductvers (
    frameworkversionid bigint NOT NULL,
    productversionid bigint NOT NULL
);


ALTER TABLE public.scframeworkversi_scproductvers OWNER TO postgres;

--
-- TOC entry 2001 (class 1259 OID 29038)
-- Dependencies: 3
-- Name: scframeworkversion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scframeworkversion (
    frameworkversionid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    url text,
    active_ boolean,
    priority integer
);


ALTER TABLE public.scframeworkversion OWNER TO postgres;

--
-- TOC entry 2002 (class 1259 OID 29046)
-- Dependencies: 3
-- Name: sclicense; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sclicense (
    licenseid bigint NOT NULL,
    name character varying(75),
    url text,
    opensource boolean,
    active_ boolean,
    recommended boolean
);


ALTER TABLE public.sclicense OWNER TO postgres;

--
-- TOC entry 2003 (class 1259 OID 29054)
-- Dependencies: 3
-- Name: sclicenses_scproductentries; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sclicenses_scproductentries (
    licenseid bigint NOT NULL,
    productentryid bigint NOT NULL
);


ALTER TABLE public.sclicenses_scproductentries OWNER TO postgres;

--
-- TOC entry 2004 (class 1259 OID 29059)
-- Dependencies: 3
-- Name: scproductentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scproductentry (
    productentryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    type_ character varying(75),
    tags character varying(255),
    shortdescription text,
    longdescription text,
    pageurl text,
    author character varying(75),
    repogroupid character varying(75),
    repoartifactid character varying(75)
);


ALTER TABLE public.scproductentry OWNER TO postgres;

--
-- TOC entry 2005 (class 1259 OID 29067)
-- Dependencies: 3
-- Name: scproductscreenshot; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scproductscreenshot (
    productscreenshotid bigint NOT NULL,
    companyid bigint,
    groupid bigint,
    productentryid bigint,
    thumbnailid bigint,
    fullimageid bigint,
    priority integer
);


ALTER TABLE public.scproductscreenshot OWNER TO postgres;

--
-- TOC entry 2006 (class 1259 OID 29072)
-- Dependencies: 3
-- Name: scproductversion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scproductversion (
    productversionid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    productentryid bigint,
    version character varying(75),
    changelog text,
    downloadpageurl text,
    directdownloadurl character varying(2000),
    repostoreartifact boolean
);


ALTER TABLE public.scproductversion OWNER TO postgres;

--
-- TOC entry 2007 (class 1259 OID 29080)
-- Dependencies: 3
-- Name: servicecomponent; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE servicecomponent (
    servicecomponentid bigint NOT NULL,
    buildnamespace character varying(75),
    buildnumber bigint,
    builddate bigint,
    data_ text
);


ALTER TABLE public.servicecomponent OWNER TO postgres;

--
-- TOC entry 2008 (class 1259 OID 29088)
-- Dependencies: 3
-- Name: shard; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shard (
    shardid bigint NOT NULL,
    classnameid bigint,
    classpk bigint,
    name character varying(75)
);


ALTER TABLE public.shard OWNER TO postgres;

--
-- TOC entry 2009 (class 1259 OID 29093)
-- Dependencies: 3
-- Name: shoppingcart; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingcart (
    cartid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    itemids text,
    couponcodes character varying(75),
    altshipping integer,
    insure boolean
);


ALTER TABLE public.shoppingcart OWNER TO postgres;

--
-- TOC entry 2010 (class 1259 OID 29101)
-- Dependencies: 3
-- Name: shoppingcategory; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingcategory (
    categoryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parentcategoryid bigint,
    name character varying(75),
    description text
);


ALTER TABLE public.shoppingcategory OWNER TO postgres;

--
-- TOC entry 2011 (class 1259 OID 29109)
-- Dependencies: 3
-- Name: shoppingcoupon; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingcoupon (
    couponid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    code_ character varying(75),
    name character varying(75),
    description text,
    startdate timestamp without time zone,
    enddate timestamp without time zone,
    active_ boolean,
    limitcategories text,
    limitskus text,
    minorder double precision,
    discount double precision,
    discounttype character varying(75)
);


ALTER TABLE public.shoppingcoupon OWNER TO postgres;

--
-- TOC entry 2012 (class 1259 OID 29117)
-- Dependencies: 3
-- Name: shoppingitem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingitem (
    itemid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    categoryid bigint,
    sku character varying(75),
    name character varying(200),
    description text,
    properties text,
    fields_ boolean,
    fieldsquantities text,
    minquantity integer,
    maxquantity integer,
    price double precision,
    discount double precision,
    taxable boolean,
    shipping double precision,
    useshippingformula boolean,
    requiresshipping boolean,
    stockquantity integer,
    featured_ boolean,
    sale_ boolean,
    smallimage boolean,
    smallimageid bigint,
    smallimageurl character varying(75),
    mediumimage boolean,
    mediumimageid bigint,
    mediumimageurl character varying(75),
    largeimage boolean,
    largeimageid bigint,
    largeimageurl character varying(75)
);


ALTER TABLE public.shoppingitem OWNER TO postgres;

--
-- TOC entry 2013 (class 1259 OID 29125)
-- Dependencies: 3
-- Name: shoppingitemfield; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingitemfield (
    itemfieldid bigint NOT NULL,
    itemid bigint,
    name character varying(75),
    values_ text,
    description text
);


ALTER TABLE public.shoppingitemfield OWNER TO postgres;

--
-- TOC entry 2014 (class 1259 OID 29133)
-- Dependencies: 3
-- Name: shoppingitemprice; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingitemprice (
    itempriceid bigint NOT NULL,
    itemid bigint,
    minquantity integer,
    maxquantity integer,
    price double precision,
    discount double precision,
    taxable boolean,
    shipping double precision,
    useshippingformula boolean,
    status integer
);


ALTER TABLE public.shoppingitemprice OWNER TO postgres;

--
-- TOC entry 2015 (class 1259 OID 29138)
-- Dependencies: 3
-- Name: shoppingorder; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingorder (
    orderid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    number_ character varying(75),
    tax double precision,
    shipping double precision,
    altshipping character varying(75),
    requiresshipping boolean,
    insure boolean,
    insurance double precision,
    couponcodes character varying(75),
    coupondiscount double precision,
    billingfirstname character varying(75),
    billinglastname character varying(75),
    billingemailaddress character varying(75),
    billingcompany character varying(75),
    billingstreet character varying(75),
    billingcity character varying(75),
    billingstate character varying(75),
    billingzip character varying(75),
    billingcountry character varying(75),
    billingphone character varying(75),
    shiptobilling boolean,
    shippingfirstname character varying(75),
    shippinglastname character varying(75),
    shippingemailaddress character varying(75),
    shippingcompany character varying(75),
    shippingstreet character varying(75),
    shippingcity character varying(75),
    shippingstate character varying(75),
    shippingzip character varying(75),
    shippingcountry character varying(75),
    shippingphone character varying(75),
    ccname character varying(75),
    cctype character varying(75),
    ccnumber character varying(75),
    ccexpmonth integer,
    ccexpyear integer,
    ccvernumber character varying(75),
    comments text,
    pptxnid character varying(75),
    pppaymentstatus character varying(75),
    pppaymentgross double precision,
    ppreceiveremail character varying(75),
    pppayeremail character varying(75),
    sendorderemail boolean,
    sendshippingemail boolean
);


ALTER TABLE public.shoppingorder OWNER TO postgres;

--
-- TOC entry 2016 (class 1259 OID 29146)
-- Dependencies: 3
-- Name: shoppingorderitem; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE shoppingorderitem (
    orderitemid bigint NOT NULL,
    orderid bigint,
    itemid character varying(75),
    sku character varying(75),
    name character varying(200),
    description text,
    properties text,
    price double precision,
    quantity integer,
    shippeddate timestamp without time zone
);


ALTER TABLE public.shoppingorderitem OWNER TO postgres;

--
-- TOC entry 2017 (class 1259 OID 29154)
-- Dependencies: 3
-- Name: socialactivity; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE socialactivity (
    activityid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    mirroractivityid bigint,
    classnameid bigint,
    classpk bigint,
    type_ integer,
    extradata text,
    receiveruserid bigint
);


ALTER TABLE public.socialactivity OWNER TO postgres;

--
-- TOC entry 2018 (class 1259 OID 29162)
-- Dependencies: 3
-- Name: socialrelation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE socialrelation (
    uuid_ character varying(75),
    relationid bigint NOT NULL,
    companyid bigint,
    createdate timestamp without time zone,
    userid1 bigint,
    userid2 bigint,
    type_ integer
);


ALTER TABLE public.socialrelation OWNER TO postgres;

--
-- TOC entry 2019 (class 1259 OID 29167)
-- Dependencies: 3
-- Name: socialrequest; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE socialrequest (
    uuid_ character varying(75),
    requestid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    type_ integer,
    extradata text,
    receiveruserid bigint,
    status integer
);


ALTER TABLE public.socialrequest OWNER TO postgres;

--
-- TOC entry 2020 (class 1259 OID 29175)
-- Dependencies: 3
-- Name: subscription; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE subscription (
    subscriptionid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    frequency character varying(75)
);


ALTER TABLE public.subscription OWNER TO postgres;

--
-- TOC entry 2021 (class 1259 OID 29180)
-- Dependencies: 3
-- Name: tagsasset; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagsasset (
    assetid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    visible boolean,
    startdate timestamp without time zone,
    enddate timestamp without time zone,
    publishdate timestamp without time zone,
    expirationdate timestamp without time zone,
    mimetype character varying(75),
    title character varying(255),
    description text,
    summary text,
    url text,
    height integer,
    width integer,
    priority double precision,
    viewcount integer
);


ALTER TABLE public.tagsasset OWNER TO postgres;

--
-- TOC entry 2022 (class 1259 OID 29188)
-- Dependencies: 3
-- Name: tagsassets_tagsentries; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagsassets_tagsentries (
    assetid bigint NOT NULL,
    entryid bigint NOT NULL
);


ALTER TABLE public.tagsassets_tagsentries OWNER TO postgres;

--
-- TOC entry 2023 (class 1259 OID 29193)
-- Dependencies: 3
-- Name: tagsentry; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagsentry (
    entryid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    parententryid bigint,
    name character varying(75),
    vocabularyid bigint
);


ALTER TABLE public.tagsentry OWNER TO postgres;

--
-- TOC entry 2024 (class 1259 OID 29198)
-- Dependencies: 3
-- Name: tagsproperty; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagsproperty (
    propertyid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    entryid bigint,
    key_ character varying(75),
    value character varying(255)
);


ALTER TABLE public.tagsproperty OWNER TO postgres;

--
-- TOC entry 2025 (class 1259 OID 29203)
-- Dependencies: 3
-- Name: tagssource; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagssource (
    sourceid bigint NOT NULL,
    parentsourceid bigint,
    name character varying(75),
    acronym character varying(75)
);


ALTER TABLE public.tagssource OWNER TO postgres;

--
-- TOC entry 2026 (class 1259 OID 29208)
-- Dependencies: 3
-- Name: tagsvocabulary; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tagsvocabulary (
    vocabularyid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    description character varying(75),
    folksonomy boolean
);


ALTER TABLE public.tagsvocabulary OWNER TO postgres;

--
-- TOC entry 2027 (class 1259 OID 29213)
-- Dependencies: 3
-- Name: tasksproposal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tasksproposal (
    proposalid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk character varying(75),
    name character varying(75),
    description text,
    publishdate timestamp without time zone,
    duedate timestamp without time zone
);


ALTER TABLE public.tasksproposal OWNER TO postgres;

--
-- TOC entry 2028 (class 1259 OID 29221)
-- Dependencies: 3
-- Name: tasksreview; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tasksreview (
    reviewid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    proposalid bigint,
    assignedbyuserid bigint,
    assignedbyusername character varying(75),
    stage integer,
    completed boolean,
    rejected boolean
);


ALTER TABLE public.tasksreview OWNER TO postgres;

--
-- TOC entry 2029 (class 1259 OID 29226)
-- Dependencies: 3
-- Name: user_; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE user_ (
    uuid_ character varying(75),
    userid bigint NOT NULL,
    companyid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    defaultuser boolean,
    contactid bigint,
    password_ character varying(75),
    passwordencrypted boolean,
    passwordreset boolean,
    passwordmodifieddate timestamp without time zone,
    reminderqueryquestion character varying(75),
    reminderqueryanswer character varying(75),
    gracelogincount integer,
    screenname character varying(75),
    emailaddress character varying(75),
    openid character varying(1024),
    portraitid bigint,
    languageid character varying(75),
    timezoneid character varying(75),
    greeting character varying(255),
    comments text,
    firstname character varying(75),
    middlename character varying(75),
    lastname character varying(75),
    jobtitle character varying(75),
    logindate timestamp without time zone,
    loginip character varying(75),
    lastlogindate timestamp without time zone,
    lastloginip character varying(75),
    lastfailedlogindate timestamp without time zone,
    failedloginattempts integer,
    lockout boolean,
    lockoutdate timestamp without time zone,
    agreedtotermsofuse boolean,
    active_ boolean
);


ALTER TABLE public.user_ OWNER TO postgres;

--
-- TOC entry 2030 (class 1259 OID 29234)
-- Dependencies: 3
-- Name: usergroup; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usergroup (
    usergroupid bigint NOT NULL,
    companyid bigint,
    parentusergroupid bigint,
    name character varying(75),
    description text
);


ALTER TABLE public.usergroup OWNER TO postgres;

--
-- TOC entry 2031 (class 1259 OID 29242)
-- Dependencies: 3
-- Name: usergrouprole; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usergrouprole (
    userid bigint NOT NULL,
    groupid bigint NOT NULL,
    roleid bigint NOT NULL
);


ALTER TABLE public.usergrouprole OWNER TO postgres;

--
-- TOC entry 2032 (class 1259 OID 29247)
-- Dependencies: 3
-- Name: useridmapper; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE useridmapper (
    useridmapperid bigint NOT NULL,
    userid bigint,
    type_ character varying(75),
    description character varying(75),
    externaluserid character varying(75)
);


ALTER TABLE public.useridmapper OWNER TO postgres;

--
-- TOC entry 2046 (class 1259 OID 31858)
-- Dependencies: 3
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    email character varying(75),
    encrypted_password character varying(75),
    salt character varying(75),
    first_name character varying(75),
    last_name character varying(75),
    department_id character varying(75),
    phone character varying(75),
    primary_role_id character varying(75),
    user_status boolean,
    org_id integer,
    group_id integer,
    password_reset_code character varying(75),
    remember_token character varying(75),
    remember_token_expires_at timestamp without time zone,
    num_signin integer,
    last_visited timestamp without time zone,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 2033 (class 1259 OID 29252)
-- Dependencies: 3
-- Name: users_groups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_groups (
    userid bigint NOT NULL,
    groupid bigint NOT NULL
);


ALTER TABLE public.users_groups OWNER TO postgres;

--
-- TOC entry 2034 (class 1259 OID 29257)
-- Dependencies: 3
-- Name: users_orgs; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_orgs (
    userid bigint NOT NULL,
    organizationid bigint NOT NULL
);


ALTER TABLE public.users_orgs OWNER TO postgres;

--
-- TOC entry 2035 (class 1259 OID 29262)
-- Dependencies: 3
-- Name: users_permissions; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_permissions (
    userid bigint NOT NULL,
    permissionid bigint NOT NULL
);


ALTER TABLE public.users_permissions OWNER TO postgres;

--
-- TOC entry 2036 (class 1259 OID 29267)
-- Dependencies: 3
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_roles (
    userid bigint NOT NULL,
    roleid bigint NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- TOC entry 2037 (class 1259 OID 29272)
-- Dependencies: 3
-- Name: users_usergroups; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users_usergroups (
    usergroupid bigint NOT NULL,
    userid bigint NOT NULL
);


ALTER TABLE public.users_usergroups OWNER TO postgres;

--
-- TOC entry 2038 (class 1259 OID 29277)
-- Dependencies: 3
-- Name: usertracker; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usertracker (
    usertrackerid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    modifieddate timestamp without time zone,
    sessionid character varying(200),
    remoteaddr character varying(75),
    remotehost character varying(75),
    useragent character varying(200)
);


ALTER TABLE public.usertracker OWNER TO postgres;

--
-- TOC entry 2039 (class 1259 OID 29285)
-- Dependencies: 3
-- Name: usertrackerpath; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usertrackerpath (
    usertrackerpathid bigint NOT NULL,
    usertrackerid bigint,
    path_ text,
    pathdate timestamp without time zone
);


ALTER TABLE public.usertrackerpath OWNER TO postgres;

--
-- TOC entry 2040 (class 1259 OID 29293)
-- Dependencies: 3
-- Name: vocabulary; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vocabulary (
    vocabularyid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    description character varying(75),
    folksonomy boolean
);


ALTER TABLE public.vocabulary OWNER TO postgres;

--
-- TOC entry 2041 (class 1259 OID 29298)
-- Dependencies: 3
-- Name: webdavprops; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE webdavprops (
    webdavpropsid bigint NOT NULL,
    companyid bigint,
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    props text
);


ALTER TABLE public.webdavprops OWNER TO postgres;

--
-- TOC entry 2042 (class 1259 OID 29306)
-- Dependencies: 3
-- Name: website; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE website (
    websiteid bigint NOT NULL,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    classnameid bigint,
    classpk bigint,
    url text,
    typeid integer,
    primary_ boolean
);


ALTER TABLE public.website OWNER TO postgres;

--
-- TOC entry 2043 (class 1259 OID 29314)
-- Dependencies: 3
-- Name: wikinode; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE wikinode (
    uuid_ character varying(75),
    nodeid bigint NOT NULL,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    name character varying(75),
    description text,
    lastpostdate timestamp without time zone
);


ALTER TABLE public.wikinode OWNER TO postgres;

--
-- TOC entry 2044 (class 1259 OID 29322)
-- Dependencies: 3
-- Name: wikipage; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE wikipage (
    uuid_ character varying(75),
    pageid bigint NOT NULL,
    resourceprimkey bigint,
    groupid bigint,
    companyid bigint,
    userid bigint,
    username character varying(75),
    createdate timestamp without time zone,
    modifieddate timestamp without time zone,
    nodeid bigint,
    title character varying(255),
    version double precision,
    minoredit boolean,
    content text,
    summary text,
    format character varying(75),
    head boolean,
    parenttitle character varying(75),
    redirecttitle character varying(75)
);


ALTER TABLE public.wikipage OWNER TO postgres;

--
-- TOC entry 2045 (class 1259 OID 29330)
-- Dependencies: 3
-- Name: wikipageresource; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE wikipageresource (
    resourceprimkey bigint NOT NULL,
    nodeid bigint,
    title character varying(75)
);


ALTER TABLE public.wikipageresource OWNER TO postgres;

--
-- TOC entry 2325 (class 2604 OID 28310)
-- Dependencies: 1886 1885
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_approval ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_approval_id_seq'::regclass);


--
-- TOC entry 2326 (class 2604 OID 28311)
-- Dependencies: 1888 1887
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_fundamentalscales ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_fundamentalscales_id_seq'::regclass);


--
-- TOC entry 2334 (class 2604 OID 28312)
-- Dependencies: 1890 1889
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_list ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_list_id_seq'::regclass);


--
-- TOC entry 2337 (class 2604 OID 28313)
-- Dependencies: 1892 1891
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_measure_ahp ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_measure_ahp_id_seq'::regclass);


--
-- TOC entry 2344 (class 2604 OID 28314)
-- Dependencies: 1894 1893
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_measures ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_measures_id_seq'::regclass);


--
-- TOC entry 2346 (class 2604 OID 28315)
-- Dependencies: 1896 1895
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_objective_ahp ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_objective_ahp_id_seq'::regclass);


--
-- TOC entry 2352 (class 2604 OID 28316)
-- Dependencies: 1898 1897
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_objectives ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_objectives_id_seq'::regclass);


--
-- TOC entry 2355 (class 2604 OID 28317)
-- Dependencies: 1900 1899
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_perspective_ahp ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_perspective_ahp_id_seq'::regclass);


--
-- TOC entry 2363 (class 2604 OID 28318)
-- Dependencies: 1902 1901
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_perspectives ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_perspectives_id_seq'::regclass);


--
-- TOC entry 2369 (class 2604 OID 28319)
-- Dependencies: 1904 1903
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_targets ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_targets_id_seq'::regclass);


--
-- TOC entry 2370 (class 2604 OID 28320)
-- Dependencies: 1906 1905
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ebsc_orgobjectives_types ALTER COLUMN id SET DEFAULT nextval('ebsc_orgobjectives_types_id_seq'::regclass);


--
-- TOC entry 2476 (class 2606 OID 28527)
-- Dependencies: 1919 1919
-- Name: account__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY account_
    ADD CONSTRAINT account__pkey PRIMARY KEY (accountid);


--
-- TOC entry 2478 (class 2606 OID 28532)
-- Dependencies: 1920 1920
-- Name: address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (addressid);


--
-- TOC entry 2486 (class 2606 OID 28537)
-- Dependencies: 1921 1921
-- Name: announcementsdelivery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY announcementsdelivery
    ADD CONSTRAINT announcementsdelivery_pkey PRIMARY KEY (deliveryid);


--
-- TOC entry 2490 (class 2606 OID 28545)
-- Dependencies: 1922 1922
-- Name: announcementsentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY announcementsentry
    ADD CONSTRAINT announcementsentry_pkey PRIMARY KEY (entryid);


--
-- TOC entry 2496 (class 2606 OID 28550)
-- Dependencies: 1923 1923
-- Name: announcementsflag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY announcementsflag
    ADD CONSTRAINT announcementsflag_pkey PRIMARY KEY (flagid);


--
-- TOC entry 2500 (class 2606 OID 28558)
-- Dependencies: 1924 1924
-- Name: blogsentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blogsentry
    ADD CONSTRAINT blogsentry_pkey PRIMARY KEY (entryid);


--
-- TOC entry 2511 (class 2606 OID 28563)
-- Dependencies: 1925 1925
-- Name: blogsstatsuser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY blogsstatsuser
    ADD CONSTRAINT blogsstatsuser_pkey PRIMARY KEY (statsuserid);


--
-- TOC entry 2518 (class 2606 OID 28571)
-- Dependencies: 1926 1926
-- Name: bookmarksentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bookmarksentry
    ADD CONSTRAINT bookmarksentry_pkey PRIMARY KEY (entryid);


--
-- TOC entry 2525 (class 2606 OID 28579)
-- Dependencies: 1927 1927
-- Name: bookmarksfolder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bookmarksfolder
    ADD CONSTRAINT bookmarksfolder_pkey PRIMARY KEY (folderid);


--
-- TOC entry 2532 (class 2606 OID 28584)
-- Dependencies: 1928 1928
-- Name: browsertracker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY browsertracker
    ADD CONSTRAINT browsertracker_pkey PRIMARY KEY (browsertrackerid);


--
-- TOC entry 2535 (class 2606 OID 28592)
-- Dependencies: 1929 1929
-- Name: calevent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY calevent
    ADD CONSTRAINT calevent_pkey PRIMARY KEY (eventid);


--
-- TOC entry 2544 (class 2606 OID 28597)
-- Dependencies: 1930 1930
-- Name: classname__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classname_
    ADD CONSTRAINT classname__pkey PRIMARY KEY (classnameid);


--
-- TOC entry 2547 (class 2606 OID 28605)
-- Dependencies: 1931 1931
-- Name: company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (companyid);


--
-- TOC entry 2554 (class 2606 OID 28613)
-- Dependencies: 1932 1932
-- Name: contact__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY contact_
    ADD CONSTRAINT contact__pkey PRIMARY KEY (contactid);


--
-- TOC entry 2557 (class 2606 OID 28618)
-- Dependencies: 1933 1933
-- Name: counter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY counter
    ADD CONSTRAINT counter_pkey PRIMARY KEY (name);


--
-- TOC entry 2559 (class 2606 OID 28623)
-- Dependencies: 1934 1934
-- Name: country_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY country
    ADD CONSTRAINT country_pkey PRIMARY KEY (countryid);


--
-- TOC entry 2565 (class 2606 OID 28628)
-- Dependencies: 1935 1935
-- Name: cyrususer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cyrususer
    ADD CONSTRAINT cyrususer_pkey PRIMARY KEY (userid);


--
-- TOC entry 2567 (class 2606 OID 28633)
-- Dependencies: 1936 1936
-- Name: cyrusvirtual_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cyrusvirtual
    ADD CONSTRAINT cyrusvirtual_pkey PRIMARY KEY (emailaddress);


--
-- TOC entry 2569 (class 2606 OID 28641)
-- Dependencies: 1937 1937
-- Name: dlfileentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dlfileentry
    ADD CONSTRAINT dlfileentry_pkey PRIMARY KEY (fileentryid);


--
-- TOC entry 2579 (class 2606 OID 28646)
-- Dependencies: 1938 1938
-- Name: dlfilerank_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dlfilerank
    ADD CONSTRAINT dlfilerank_pkey PRIMARY KEY (filerankid);


--
-- TOC entry 2585 (class 2606 OID 28651)
-- Dependencies: 1939 1939
-- Name: dlfileshortcut_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dlfileshortcut
    ADD CONSTRAINT dlfileshortcut_pkey PRIMARY KEY (fileshortcutid);


--
-- TOC entry 2591 (class 2606 OID 28656)
-- Dependencies: 1940 1940
-- Name: dlfileversion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dlfileversion
    ADD CONSTRAINT dlfileversion_pkey PRIMARY KEY (fileversionid);


--
-- TOC entry 2595 (class 2606 OID 28664)
-- Dependencies: 1941 1941
-- Name: dlfolder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dlfolder
    ADD CONSTRAINT dlfolder_pkey PRIMARY KEY (folderid);


--
-- TOC entry 2372 (class 2606 OID 28322)
-- Dependencies: 1885 1885
-- Name: ebsc_orgobjectives_approval_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_approval
    ADD CONSTRAINT ebsc_orgobjectives_approval_pkey PRIMARY KEY (id);


--
-- TOC entry 2376 (class 2606 OID 28324)
-- Dependencies: 1887 1887
-- Name: ebsc_orgobjectives_fundamentalscales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_fundamentalscales
    ADD CONSTRAINT ebsc_orgobjectives_fundamentalscales_pkey PRIMARY KEY (id);


--
-- TOC entry 2378 (class 2606 OID 28326)
-- Dependencies: 1887 1887
-- Name: ebsc_orgobjectives_fundamentalscales_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_fundamentalscales
    ADD CONSTRAINT ebsc_orgobjectives_fundamentalscales_uk UNIQUE (scale);


--
-- TOC entry 2380 (class 2606 OID 28328)
-- Dependencies: 1889 1889
-- Name: ebsc_orgobjectives_list_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_list
    ADD CONSTRAINT ebsc_orgobjectives_list_pkey PRIMARY KEY (id);


--
-- TOC entry 2382 (class 2606 OID 28330)
-- Dependencies: 1889 1889 1889 1889
-- Name: ebsc_orgobjectives_list_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_list
    ADD CONSTRAINT ebsc_orgobjectives_list_uk UNIQUE (org_id, year, month_hash);


--
-- TOC entry 2392 (class 2606 OID 28332)
-- Dependencies: 1891 1891
-- Name: ebsc_orgobjectives_measure_ahp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_measure_ahp
    ADD CONSTRAINT ebsc_orgobjectives_measure_ahp_pkey PRIMARY KEY (id);


--
-- TOC entry 2394 (class 2606 OID 28334)
-- Dependencies: 1891 1891 1891
-- Name: ebsc_orgobjectives_measure_ahp_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_measure_ahp
    ADD CONSTRAINT ebsc_orgobjectives_measure_ahp_uk UNIQUE (vindex, hindex);


--
-- TOC entry 2397 (class 2606 OID 28336)
-- Dependencies: 1893 1893
-- Name: ebsc_orgobjectives_measures_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_measures
    ADD CONSTRAINT ebsc_orgobjectives_measures_pk PRIMARY KEY (id);


--
-- TOC entry 2399 (class 2606 OID 28338)
-- Dependencies: 1893 1893 1893
-- Name: ebsc_orgobjectives_measures_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_measures
    ADD CONSTRAINT ebsc_orgobjectives_measures_uk UNIQUE (obj_id, name);


--
-- TOC entry 2406 (class 2606 OID 28340)
-- Dependencies: 1895 1895
-- Name: ebsc_orgobjectives_objective_ahp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_objective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_objective_ahp_pkey PRIMARY KEY (id);


--
-- TOC entry 2408 (class 2606 OID 28342)
-- Dependencies: 1895 1895 1895
-- Name: ebsc_orgobjectives_objective_ahp_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_objective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_objective_ahp_uk UNIQUE (vindex, hindex);


--
-- TOC entry 2411 (class 2606 OID 28344)
-- Dependencies: 1897 1897
-- Name: ebsc_orgobjectives_objectives_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_objectives
    ADD CONSTRAINT ebsc_orgobjectives_objectives_pk PRIMARY KEY (id);


--
-- TOC entry 2413 (class 2606 OID 28346)
-- Dependencies: 1897 1897 1897
-- Name: ebsc_orgobjectives_objectives_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_objectives
    ADD CONSTRAINT ebsc_orgobjectives_objectives_uk UNIQUE (obj_id, name);


--
-- TOC entry 2420 (class 2606 OID 28348)
-- Dependencies: 1899 1899
-- Name: ebsc_orgobjectives_perspective_ahp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_perspective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_perspective_ahp_pkey PRIMARY KEY (id);


--
-- TOC entry 2422 (class 2606 OID 28350)
-- Dependencies: 1899 1899 1899
-- Name: ebsc_orgobjectives_perspective_ahp_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_perspective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_perspective_ahp_uk UNIQUE (vindex, hindex);


--
-- TOC entry 2425 (class 2606 OID 28352)
-- Dependencies: 1901 1901
-- Name: ebsc_orgobjectives_perspectives_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_perspectives
    ADD CONSTRAINT ebsc_orgobjectives_perspectives_pk PRIMARY KEY (id);


--
-- TOC entry 2427 (class 2606 OID 28354)
-- Dependencies: 1901 1901 1901
-- Name: ebsc_orgobjectives_perspectives_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_perspectives
    ADD CONSTRAINT ebsc_orgobjectives_perspectives_uk UNIQUE (obj_id, name);


--
-- TOC entry 2433 (class 2606 OID 28356)
-- Dependencies: 1903 1903
-- Name: ebsc_orgobjectives_targets_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_targets
    ADD CONSTRAINT ebsc_orgobjectives_targets_pk PRIMARY KEY (id);


--
-- TOC entry 2435 (class 2606 OID 28358)
-- Dependencies: 1903 1903 1903
-- Name: ebsc_orgobjectives_targets_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_targets
    ADD CONSTRAINT ebsc_orgobjectives_targets_uk UNIQUE (mea_id, name);


--
-- TOC entry 2439 (class 2606 OID 28360)
-- Dependencies: 1905 1905
-- Name: ebsc_orgobjectives_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_types
    ADD CONSTRAINT ebsc_orgobjectives_types_pkey PRIMARY KEY (id);


--
-- TOC entry 2441 (class 2606 OID 28362)
-- Dependencies: 1905 1905
-- Name: ebsc_orgobjectives_types_uk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ebsc_orgobjectives_types
    ADD CONSTRAINT ebsc_orgobjectives_types_uk UNIQUE (objtype);


--
-- TOC entry 2604 (class 2606 OID 28669)
-- Dependencies: 1942 1942
-- Name: emailaddress_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY emailaddress
    ADD CONSTRAINT emailaddress_pkey PRIMARY KEY (emailaddressid);


--
-- TOC entry 2611 (class 2606 OID 28677)
-- Dependencies: 1943 1943
-- Name: expandocolumn_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY expandocolumn
    ADD CONSTRAINT expandocolumn_pkey PRIMARY KEY (columnid);


--
-- TOC entry 2615 (class 2606 OID 28682)
-- Dependencies: 1944 1944
-- Name: expandorow_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY expandorow
    ADD CONSTRAINT expandorow_pkey PRIMARY KEY (rowid_);


--
-- TOC entry 2619 (class 2606 OID 28687)
-- Dependencies: 1945 1945
-- Name: expandotable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY expandotable
    ADD CONSTRAINT expandotable_pkey PRIMARY KEY (tableid);


--
-- TOC entry 2623 (class 2606 OID 28695)
-- Dependencies: 1946 1946
-- Name: expandovalue_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY expandovalue
    ADD CONSTRAINT expandovalue_pkey PRIMARY KEY (valueid);


--
-- TOC entry 2634 (class 2606 OID 28703)
-- Dependencies: 1947 1947
-- Name: group__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY group_
    ADD CONSTRAINT group__pkey PRIMARY KEY (groupid);


--
-- TOC entry 2643 (class 2606 OID 28708)
-- Dependencies: 1948 1948 1948
-- Name: groups_orgs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY groups_orgs
    ADD CONSTRAINT groups_orgs_pkey PRIMARY KEY (groupid, organizationid);


--
-- TOC entry 2647 (class 2606 OID 28713)
-- Dependencies: 1949 1949 1949
-- Name: groups_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY groups_permissions
    ADD CONSTRAINT groups_permissions_pkey PRIMARY KEY (groupid, permissionid);


--
-- TOC entry 2651 (class 2606 OID 28718)
-- Dependencies: 1950 1950 1950
-- Name: groups_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY groups_roles
    ADD CONSTRAINT groups_roles_pkey PRIMARY KEY (groupid, roleid);


--
-- TOC entry 2655 (class 2606 OID 28723)
-- Dependencies: 1951 1951 1951
-- Name: groups_usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY groups_usergroups
    ADD CONSTRAINT groups_usergroups_pkey PRIMARY KEY (groupid, usergroupid);


--
-- TOC entry 2659 (class 2606 OID 28731)
-- Dependencies: 1952 1952
-- Name: igfolder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY igfolder
    ADD CONSTRAINT igfolder_pkey PRIMARY KEY (folderid);


--
-- TOC entry 2667 (class 2606 OID 28739)
-- Dependencies: 1953 1953
-- Name: igimage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY igimage
    ADD CONSTRAINT igimage_pkey PRIMARY KEY (imageid);


--
-- TOC entry 2679 (class 2606 OID 28747)
-- Dependencies: 1954 1954
-- Name: image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY image
    ADD CONSTRAINT image_pkey PRIMARY KEY (imageid);


--
-- TOC entry 2694 (class 2606 OID 28755)
-- Dependencies: 1955 1955
-- Name: journalarticle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalarticle
    ADD CONSTRAINT journalarticle_pkey PRIMARY KEY (id_);


--
-- TOC entry 2700 (class 2606 OID 28760)
-- Dependencies: 1956 1956
-- Name: journalarticleimage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalarticleimage
    ADD CONSTRAINT journalarticleimage_pkey PRIMARY KEY (articleimageid);


--
-- TOC entry 2704 (class 2606 OID 28765)
-- Dependencies: 1957 1957
-- Name: journalarticleresource_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalarticleresource
    ADD CONSTRAINT journalarticleresource_pkey PRIMARY KEY (resourceprimkey);


--
-- TOC entry 2712 (class 2606 OID 28770)
-- Dependencies: 1958 1958
-- Name: journalcontentsearch_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalcontentsearch
    ADD CONSTRAINT journalcontentsearch_pkey PRIMARY KEY (contentsearchid);


--
-- TOC entry 2718 (class 2606 OID 28778)
-- Dependencies: 1959 1959
-- Name: journalfeed_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalfeed
    ADD CONSTRAINT journalfeed_pkey PRIMARY KEY (id_);


--
-- TOC entry 2726 (class 2606 OID 28786)
-- Dependencies: 1960 1960
-- Name: journalstructure_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journalstructure
    ADD CONSTRAINT journalstructure_pkey PRIMARY KEY (id_);


--
-- TOC entry 2735 (class 2606 OID 28794)
-- Dependencies: 1961 1961
-- Name: journaltemplate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY journaltemplate
    ADD CONSTRAINT journaltemplate_pkey PRIMARY KEY (id_);


--
-- TOC entry 2746 (class 2606 OID 28802)
-- Dependencies: 1962 1962
-- Name: layout_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY layout
    ADD CONSTRAINT layout_pkey PRIMARY KEY (plid);


--
-- TOC entry 2751 (class 2606 OID 28810)
-- Dependencies: 1963 1963
-- Name: layoutset_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY layoutset
    ADD CONSTRAINT layoutset_pkey PRIMARY KEY (layoutsetid);


--
-- TOC entry 2754 (class 2606 OID 28815)
-- Dependencies: 1964 1964
-- Name: listtype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY listtype
    ADD CONSTRAINT listtype_pkey PRIMARY KEY (listtypeid);


--
-- TOC entry 2760 (class 2606 OID 28820)
-- Dependencies: 1965 1965
-- Name: mbban_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbban
    ADD CONSTRAINT mbban_pkey PRIMARY KEY (banid);


--
-- TOC entry 2767 (class 2606 OID 28828)
-- Dependencies: 1966 1966
-- Name: mbcategory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbcategory
    ADD CONSTRAINT mbcategory_pkey PRIMARY KEY (categoryid);


--
-- TOC entry 2772 (class 2606 OID 28833)
-- Dependencies: 1967 1967
-- Name: mbdiscussion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbdiscussion
    ADD CONSTRAINT mbdiscussion_pkey PRIMARY KEY (discussionid);


--
-- TOC entry 2778 (class 2606 OID 28841)
-- Dependencies: 1968 1968
-- Name: mbmailinglist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbmailinglist
    ADD CONSTRAINT mbmailinglist_pkey PRIMARY KEY (mailinglistid);


--
-- TOC entry 2790 (class 2606 OID 28849)
-- Dependencies: 1969 1969
-- Name: mbmessage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbmessage
    ADD CONSTRAINT mbmessage_pkey PRIMARY KEY (messageid);


--
-- TOC entry 2799 (class 2606 OID 28854)
-- Dependencies: 1970 1970
-- Name: mbmessageflag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbmessageflag
    ADD CONSTRAINT mbmessageflag_pkey PRIMARY KEY (messageflagid);


--
-- TOC entry 2805 (class 2606 OID 28859)
-- Dependencies: 1971 1971
-- Name: mbstatsuser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbstatsuser
    ADD CONSTRAINT mbstatsuser_pkey PRIMARY KEY (statsuserid);


--
-- TOC entry 2810 (class 2606 OID 28864)
-- Dependencies: 1972 1972
-- Name: mbthread_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY mbthread
    ADD CONSTRAINT mbthread_pkey PRIMARY KEY (threadid);


--
-- TOC entry 2815 (class 2606 OID 28872)
-- Dependencies: 1973 1973
-- Name: membershiprequest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY membershiprequest
    ADD CONSTRAINT membershiprequest_pkey PRIMARY KEY (membershiprequestid);


--
-- TOC entry 2820 (class 2606 OID 28880)
-- Dependencies: 1974 1974
-- Name: organization__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY organization_
    ADD CONSTRAINT organization__pkey PRIMARY KEY (organizationid);


--
-- TOC entry 3185 (class 2606 OID 31873)
-- Dependencies: 2047 2047
-- Name: organizations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY organizations
    ADD CONSTRAINT organizations_pkey PRIMARY KEY (id);


--
-- TOC entry 2824 (class 2606 OID 28885)
-- Dependencies: 1975 1975 1975 1975
-- Name: orggrouppermission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orggrouppermission
    ADD CONSTRAINT orggrouppermission_pkey PRIMARY KEY (organizationid, groupid, permissionid);


--
-- TOC entry 2828 (class 2606 OID 28890)
-- Dependencies: 1976 1976 1976 1976
-- Name: orggrouprole_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orggrouprole
    ADD CONSTRAINT orggrouprole_pkey PRIMARY KEY (organizationid, groupid, roleid);


--
-- TOC entry 2831 (class 2606 OID 28895)
-- Dependencies: 1977 1977
-- Name: orglabor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY orglabor
    ADD CONSTRAINT orglabor_pkey PRIMARY KEY (orglaborid);


--
-- TOC entry 2835 (class 2606 OID 28903)
-- Dependencies: 1978 1978
-- Name: passwordpolicy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY passwordpolicy
    ADD CONSTRAINT passwordpolicy_pkey PRIMARY KEY (passwordpolicyid);


--
-- TOC entry 2839 (class 2606 OID 28908)
-- Dependencies: 1979 1979
-- Name: passwordpolicyrel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY passwordpolicyrel
    ADD CONSTRAINT passwordpolicyrel_pkey PRIMARY KEY (passwordpolicyrelid);


--
-- TOC entry 2842 (class 2606 OID 28913)
-- Dependencies: 1980 1980
-- Name: passwordtracker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY passwordtracker
    ADD CONSTRAINT passwordtracker_pkey PRIMARY KEY (passwordtrackerid);


--
-- TOC entry 2846 (class 2606 OID 28918)
-- Dependencies: 1981 1981
-- Name: permission__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permission_
    ADD CONSTRAINT permission__pkey PRIMARY KEY (permissionid);


--
-- TOC entry 2853 (class 2606 OID 28923)
-- Dependencies: 1982 1982
-- Name: phone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY phone
    ADD CONSTRAINT phone_pkey PRIMARY KEY (phoneid);


--
-- TOC entry 2857 (class 2606 OID 28931)
-- Dependencies: 1983 1983
-- Name: pluginsetting_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pluginsetting
    ADD CONSTRAINT pluginsetting_pkey PRIMARY KEY (pluginsettingid);


--
-- TOC entry 2862 (class 2606 OID 28939)
-- Dependencies: 1984 1984
-- Name: pollschoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pollschoice
    ADD CONSTRAINT pollschoice_pkey PRIMARY KEY (choiceid);


--
-- TOC entry 2867 (class 2606 OID 28947)
-- Dependencies: 1985 1985
-- Name: pollsquestion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pollsquestion
    ADD CONSTRAINT pollsquestion_pkey PRIMARY KEY (questionid);


--
-- TOC entry 2872 (class 2606 OID 28952)
-- Dependencies: 1986 1986
-- Name: pollsvote_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pollsvote
    ADD CONSTRAINT pollsvote_pkey PRIMARY KEY (voteid);


--
-- TOC entry 2876 (class 2606 OID 28960)
-- Dependencies: 1987 1987
-- Name: portlet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY portlet
    ADD CONSTRAINT portlet_pkey PRIMARY KEY (id_);


--
-- TOC entry 2884 (class 2606 OID 28965)
-- Dependencies: 1988 1988
-- Name: portletitem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY portletitem
    ADD CONSTRAINT portletitem_pkey PRIMARY KEY (portletitemid);


--
-- TOC entry 2890 (class 2606 OID 28973)
-- Dependencies: 1989 1989
-- Name: portletpreferences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY portletpreferences
    ADD CONSTRAINT portletpreferences_pkey PRIMARY KEY (portletpreferencesid);


--
-- TOC entry 2456 (class 2606 OID 28474)
-- Dependencies: 1912 1912 1912
-- Name: quartz_blob_triggers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_blob_triggers
    ADD CONSTRAINT quartz_blob_triggers_pkey PRIMARY KEY (trigger_name, trigger_group);


--
-- TOC entry 2460 (class 2606 OID 28487)
-- Dependencies: 1914 1914
-- Name: quartz_calendars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_calendars
    ADD CONSTRAINT quartz_calendars_pkey PRIMARY KEY (calendar_name);


--
-- TOC entry 2454 (class 2606 OID 28466)
-- Dependencies: 1911 1911 1911
-- Name: quartz_cron_triggers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_cron_triggers
    ADD CONSTRAINT quartz_cron_triggers_pkey PRIMARY KEY (trigger_name, trigger_group);


--
-- TOC entry 2470 (class 2606 OID 28500)
-- Dependencies: 1916 1916
-- Name: quartz_fired_triggers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_fired_triggers
    ADD CONSTRAINT quartz_fired_triggers_pkey PRIMARY KEY (entry_id);


--
-- TOC entry 2443 (class 2606 OID 28443)
-- Dependencies: 1907 1907 1907
-- Name: quartz_job_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_job_details
    ADD CONSTRAINT quartz_job_details_pkey PRIMARY KEY (job_name, job_group);


--
-- TOC entry 2445 (class 2606 OID 28448)
-- Dependencies: 1908 1908 1908 1908
-- Name: quartz_job_listeners_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_job_listeners
    ADD CONSTRAINT quartz_job_listeners_pkey PRIMARY KEY (job_name, job_group, job_listener);


--
-- TOC entry 2474 (class 2606 OID 28510)
-- Dependencies: 1918 1918
-- Name: quartz_locks_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_locks
    ADD CONSTRAINT quartz_locks_pkey PRIMARY KEY (lock_name);


--
-- TOC entry 2462 (class 2606 OID 28492)
-- Dependencies: 1915 1915
-- Name: quartz_paused_trigger_grps_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_paused_trigger_grps
    ADD CONSTRAINT quartz_paused_trigger_grps_pkey PRIMARY KEY (trigger_group);


--
-- TOC entry 2472 (class 2606 OID 28505)
-- Dependencies: 1917 1917
-- Name: quartz_scheduler_state_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_scheduler_state
    ADD CONSTRAINT quartz_scheduler_state_pkey PRIMARY KEY (instance_name);


--
-- TOC entry 2452 (class 2606 OID 28461)
-- Dependencies: 1910 1910 1910
-- Name: quartz_simple_triggers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_simple_triggers
    ADD CONSTRAINT quartz_simple_triggers_pkey PRIMARY KEY (trigger_name, trigger_group);


--
-- TOC entry 2458 (class 2606 OID 28479)
-- Dependencies: 1913 1913 1913 1913
-- Name: quartz_trigger_listeners_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_trigger_listeners
    ADD CONSTRAINT quartz_trigger_listeners_pkey PRIMARY KEY (trigger_name, trigger_group, trigger_listener);


--
-- TOC entry 2450 (class 2606 OID 28456)
-- Dependencies: 1909 1909 1909
-- Name: quartz_triggers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quartz_triggers
    ADD CONSTRAINT quartz_triggers_pkey PRIMARY KEY (trigger_name, trigger_group);


--
-- TOC entry 2894 (class 2606 OID 28978)
-- Dependencies: 1990 1990
-- Name: ratingsentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ratingsentry
    ADD CONSTRAINT ratingsentry_pkey PRIMARY KEY (entryid);


--
-- TOC entry 2897 (class 2606 OID 28983)
-- Dependencies: 1991 1991
-- Name: ratingsstats_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ratingsstats
    ADD CONSTRAINT ratingsstats_pkey PRIMARY KEY (statsid);


--
-- TOC entry 2902 (class 2606 OID 28988)
-- Dependencies: 1992 1992
-- Name: region_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY region
    ADD CONSTRAINT region_pkey PRIMARY KEY (regionid);


--
-- TOC entry 2904 (class 2606 OID 28996)
-- Dependencies: 1993 1993
-- Name: release__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY release_
    ADD CONSTRAINT release__pkey PRIMARY KEY (releaseid);


--
-- TOC entry 2908 (class 2606 OID 29001)
-- Dependencies: 1994 1994
-- Name: resource__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resource_
    ADD CONSTRAINT resource__pkey PRIMARY KEY (resourceid);


--
-- TOC entry 2912 (class 2606 OID 29006)
-- Dependencies: 1995 1995
-- Name: resourceaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resourceaction
    ADD CONSTRAINT resourceaction_pkey PRIMARY KEY (resourceactionid);


--
-- TOC entry 2917 (class 2606 OID 29011)
-- Dependencies: 1996 1996
-- Name: resourcecode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resourcecode
    ADD CONSTRAINT resourcecode_pkey PRIMARY KEY (codeid);


--
-- TOC entry 2923 (class 2606 OID 29019)
-- Dependencies: 1997 1997
-- Name: resourcepermission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY resourcepermission
    ADD CONSTRAINT resourcepermission_pkey PRIMARY KEY (resourcepermissionid);


--
-- TOC entry 2929 (class 2606 OID 29027)
-- Dependencies: 1998 1998
-- Name: role__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY role_
    ADD CONSTRAINT role__pkey PRIMARY KEY (roleid);


--
-- TOC entry 2933 (class 2606 OID 29032)
-- Dependencies: 1999 1999 1999
-- Name: roles_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles_permissions
    ADD CONSTRAINT roles_permissions_pkey PRIMARY KEY (roleid, permissionid);


--
-- TOC entry 2937 (class 2606 OID 29037)
-- Dependencies: 2000 2000 2000
-- Name: scframeworkversi_scproductvers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scframeworkversi_scproductvers
    ADD CONSTRAINT scframeworkversi_scproductvers_pkey PRIMARY KEY (frameworkversionid, productversionid);


--
-- TOC entry 2942 (class 2606 OID 29045)
-- Dependencies: 2001 2001
-- Name: scframeworkversion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scframeworkversion
    ADD CONSTRAINT scframeworkversion_pkey PRIMARY KEY (frameworkversionid);


--
-- TOC entry 2946 (class 2606 OID 29053)
-- Dependencies: 2002 2002
-- Name: sclicense_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sclicense
    ADD CONSTRAINT sclicense_pkey PRIMARY KEY (licenseid);


--
-- TOC entry 2950 (class 2606 OID 29058)
-- Dependencies: 2003 2003 2003
-- Name: sclicenses_scproductentries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sclicenses_scproductentries
    ADD CONSTRAINT sclicenses_scproductentries_pkey PRIMARY KEY (licenseid, productentryid);


--
-- TOC entry 2956 (class 2606 OID 29066)
-- Dependencies: 2004 2004
-- Name: scproductentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scproductentry
    ADD CONSTRAINT scproductentry_pkey PRIMARY KEY (productentryid);


--
-- TOC entry 2962 (class 2606 OID 29071)
-- Dependencies: 2005 2005
-- Name: scproductscreenshot_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scproductscreenshot
    ADD CONSTRAINT scproductscreenshot_pkey PRIMARY KEY (productscreenshotid);


--
-- TOC entry 2966 (class 2606 OID 29079)
-- Dependencies: 2006 2006
-- Name: scproductversion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scproductversion
    ADD CONSTRAINT scproductversion_pkey PRIMARY KEY (productversionid);


--
-- TOC entry 2970 (class 2606 OID 29087)
-- Dependencies: 2007 2007
-- Name: servicecomponent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY servicecomponent
    ADD CONSTRAINT servicecomponent_pkey PRIMARY KEY (servicecomponentid);


--
-- TOC entry 2974 (class 2606 OID 29092)
-- Dependencies: 2008 2008
-- Name: shard_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shard
    ADD CONSTRAINT shard_pkey PRIMARY KEY (shardid);


--
-- TOC entry 2979 (class 2606 OID 29100)
-- Dependencies: 2009 2009
-- Name: shoppingcart_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingcart
    ADD CONSTRAINT shoppingcart_pkey PRIMARY KEY (cartid);


--
-- TOC entry 2983 (class 2606 OID 29108)
-- Dependencies: 2010 2010
-- Name: shoppingcategory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingcategory
    ADD CONSTRAINT shoppingcategory_pkey PRIMARY KEY (categoryid);


--
-- TOC entry 2987 (class 2606 OID 29116)
-- Dependencies: 2011 2011
-- Name: shoppingcoupon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingcoupon
    ADD CONSTRAINT shoppingcoupon_pkey PRIMARY KEY (couponid);


--
-- TOC entry 2994 (class 2606 OID 29124)
-- Dependencies: 2012 2012
-- Name: shoppingitem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingitem
    ADD CONSTRAINT shoppingitem_pkey PRIMARY KEY (itemid);


--
-- TOC entry 2997 (class 2606 OID 29132)
-- Dependencies: 2013 2013
-- Name: shoppingitemfield_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingitemfield
    ADD CONSTRAINT shoppingitemfield_pkey PRIMARY KEY (itemfieldid);


--
-- TOC entry 3000 (class 2606 OID 29137)
-- Dependencies: 2014 2014
-- Name: shoppingitemprice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingitemprice
    ADD CONSTRAINT shoppingitemprice_pkey PRIMARY KEY (itempriceid);


--
-- TOC entry 3006 (class 2606 OID 29145)
-- Dependencies: 2015 2015
-- Name: shoppingorder_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingorder
    ADD CONSTRAINT shoppingorder_pkey PRIMARY KEY (orderid);


--
-- TOC entry 3009 (class 2606 OID 29153)
-- Dependencies: 2016 2016
-- Name: shoppingorderitem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY shoppingorderitem
    ADD CONSTRAINT shoppingorderitem_pkey PRIMARY KEY (orderitemid);


--
-- TOC entry 3020 (class 2606 OID 29161)
-- Dependencies: 2017 2017
-- Name: socialactivity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY socialactivity
    ADD CONSTRAINT socialactivity_pkey PRIMARY KEY (activityid);


--
-- TOC entry 3031 (class 2606 OID 29166)
-- Dependencies: 2018 2018
-- Name: socialrelation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY socialrelation
    ADD CONSTRAINT socialrelation_pkey PRIMARY KEY (relationid);


--
-- TOC entry 3043 (class 2606 OID 29174)
-- Dependencies: 2019 2019
-- Name: socialrequest_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY socialrequest
    ADD CONSTRAINT socialrequest_pkey PRIMARY KEY (requestid);


--
-- TOC entry 3049 (class 2606 OID 29179)
-- Dependencies: 2020 2020
-- Name: subscription_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY subscription
    ADD CONSTRAINT subscription_pkey PRIMARY KEY (subscriptionid);


--
-- TOC entry 3053 (class 2606 OID 29187)
-- Dependencies: 2021 2021
-- Name: tagsasset_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagsasset
    ADD CONSTRAINT tagsasset_pkey PRIMARY KEY (assetid);


--
-- TOC entry 3057 (class 2606 OID 29192)
-- Dependencies: 2022 2022 2022
-- Name: tagsassets_tagsentries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagsassets_tagsentries
    ADD CONSTRAINT tagsassets_tagsentries_pkey PRIMARY KEY (assetid, entryid);


--
-- TOC entry 3061 (class 2606 OID 29197)
-- Dependencies: 2023 2023
-- Name: tagsentry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagsentry
    ADD CONSTRAINT tagsentry_pkey PRIMARY KEY (entryid);


--
-- TOC entry 3067 (class 2606 OID 29202)
-- Dependencies: 2024 2024
-- Name: tagsproperty_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagsproperty
    ADD CONSTRAINT tagsproperty_pkey PRIMARY KEY (propertyid);


--
-- TOC entry 3069 (class 2606 OID 29207)
-- Dependencies: 2025 2025
-- Name: tagssource_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagssource
    ADD CONSTRAINT tagssource_pkey PRIMARY KEY (sourceid);


--
-- TOC entry 3074 (class 2606 OID 29212)
-- Dependencies: 2026 2026
-- Name: tagsvocabulary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tagsvocabulary
    ADD CONSTRAINT tagsvocabulary_pkey PRIMARY KEY (vocabularyid);


--
-- TOC entry 3079 (class 2606 OID 29220)
-- Dependencies: 2027 2027
-- Name: tasksproposal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tasksproposal
    ADD CONSTRAINT tasksproposal_pkey PRIMARY KEY (proposalid);


--
-- TOC entry 3087 (class 2606 OID 29225)
-- Dependencies: 2028 2028
-- Name: tasksreview_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tasksreview
    ADD CONSTRAINT tasksreview_pkey PRIMARY KEY (reviewid);


--
-- TOC entry 3099 (class 2606 OID 29233)
-- Dependencies: 2029 2029
-- Name: user__pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY user_
    ADD CONSTRAINT user__pkey PRIMARY KEY (userid);


--
-- TOC entry 3104 (class 2606 OID 29241)
-- Dependencies: 2030 2030
-- Name: usergroup_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usergroup
    ADD CONSTRAINT usergroup_pkey PRIMARY KEY (usergroupid);


--
-- TOC entry 3111 (class 2606 OID 29246)
-- Dependencies: 2031 2031 2031 2031
-- Name: usergrouprole_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usergrouprole
    ADD CONSTRAINT usergrouprole_pkey PRIMARY KEY (userid, groupid, roleid);


--
-- TOC entry 3116 (class 2606 OID 29251)
-- Dependencies: 2032 2032
-- Name: useridmapper_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY useridmapper
    ADD CONSTRAINT useridmapper_pkey PRIMARY KEY (useridmapperid);


--
-- TOC entry 3120 (class 2606 OID 29256)
-- Dependencies: 2033 2033 2033
-- Name: users_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_groups
    ADD CONSTRAINT users_groups_pkey PRIMARY KEY (userid, groupid);


--
-- TOC entry 3124 (class 2606 OID 29261)
-- Dependencies: 2034 2034 2034
-- Name: users_orgs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_orgs
    ADD CONSTRAINT users_orgs_pkey PRIMARY KEY (userid, organizationid);


--
-- TOC entry 3128 (class 2606 OID 29266)
-- Dependencies: 2035 2035 2035
-- Name: users_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_permissions
    ADD CONSTRAINT users_permissions_pkey PRIMARY KEY (userid, permissionid);


--
-- TOC entry 3182 (class 2606 OID 31865)
-- Dependencies: 2046 2046
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3132 (class 2606 OID 29271)
-- Dependencies: 2036 2036 2036
-- Name: users_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (userid, roleid);


--
-- TOC entry 3136 (class 2606 OID 29276)
-- Dependencies: 2037 2037 2037
-- Name: users_usergroups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users_usergroups
    ADD CONSTRAINT users_usergroups_pkey PRIMARY KEY (usergroupid, userid);


--
-- TOC entry 3141 (class 2606 OID 29284)
-- Dependencies: 2038 2038
-- Name: usertracker_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usertracker
    ADD CONSTRAINT usertracker_pkey PRIMARY KEY (usertrackerid);


--
-- TOC entry 3144 (class 2606 OID 29292)
-- Dependencies: 2039 2039
-- Name: usertrackerpath_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usertrackerpath
    ADD CONSTRAINT usertrackerpath_pkey PRIMARY KEY (usertrackerpathid);


--
-- TOC entry 3146 (class 2606 OID 29297)
-- Dependencies: 2040 2040
-- Name: vocabulary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vocabulary
    ADD CONSTRAINT vocabulary_pkey PRIMARY KEY (vocabularyid);


--
-- TOC entry 3149 (class 2606 OID 29305)
-- Dependencies: 2041 2041
-- Name: webdavprops_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY webdavprops
    ADD CONSTRAINT webdavprops_pkey PRIMARY KEY (webdavpropsid);


--
-- TOC entry 3156 (class 2606 OID 29313)
-- Dependencies: 2042 2042
-- Name: website_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY website
    ADD CONSTRAINT website_pkey PRIMARY KEY (websiteid);


--
-- TOC entry 3163 (class 2606 OID 29321)
-- Dependencies: 2043 2043
-- Name: wikinode_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY wikinode
    ADD CONSTRAINT wikinode_pkey PRIMARY KEY (nodeid);


--
-- TOC entry 3176 (class 2606 OID 29329)
-- Dependencies: 2044 2044
-- Name: wikipage_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY wikipage
    ADD CONSTRAINT wikipage_pkey PRIMARY KEY (pageid);


--
-- TOC entry 3179 (class 2606 OID 29334)
-- Dependencies: 2045 2045
-- Name: wikipageresource_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY wikipageresource
    ADD CONSTRAINT wikipageresource_pkey PRIMARY KEY (resourceprimkey);


--
-- TOC entry 2383 (class 1259 OID 28363)
-- Dependencies: 1889 1889
-- Name: ebsc_orgobjectives_list_year; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_list_year ON ebsc_orgobjectives_list USING btree (org_id, year);


--
-- TOC entry 2388 (class 1259 OID 28364)
-- Dependencies: 1891
-- Name: ebsc_orgobjectives_measure_ahp_objid; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_measure_ahp_objid ON ebsc_orgobjectives_measure_ahp USING btree (obj_id);


--
-- TOC entry 2389 (class 1259 OID 28365)
-- Dependencies: 1891 1891
-- Name: ebsc_orgobjectives_measure_ahp_objid_hindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_measure_ahp_objid_hindex ON ebsc_orgobjectives_measure_ahp USING btree (obj_id, hindex);


--
-- TOC entry 2390 (class 1259 OID 28366)
-- Dependencies: 1891 1891
-- Name: ebsc_orgobjectives_measure_ahp_objid_vindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_measure_ahp_objid_vindex ON ebsc_orgobjectives_measure_ahp USING btree (obj_id, vindex);


--
-- TOC entry 2395 (class 1259 OID 28367)
-- Dependencies: 1893
-- Name: ebsc_orgobjectives_measures_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_measures_id ON ebsc_orgobjectives_measures USING btree (id);


--
-- TOC entry 2402 (class 1259 OID 28368)
-- Dependencies: 1895
-- Name: ebsc_orgobjectives_objective_ahp_objid; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_objective_ahp_objid ON ebsc_orgobjectives_objective_ahp USING btree (obj_id);


--
-- TOC entry 2403 (class 1259 OID 28369)
-- Dependencies: 1895 1895
-- Name: ebsc_orgobjectives_objective_ahp_objid_hindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_objective_ahp_objid_hindex ON ebsc_orgobjectives_objective_ahp USING btree (obj_id, hindex);


--
-- TOC entry 2404 (class 1259 OID 28370)
-- Dependencies: 1895 1895
-- Name: ebsc_orgobjectives_objective_ahp_objid_vindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_objective_ahp_objid_vindex ON ebsc_orgobjectives_objective_ahp USING btree (obj_id, vindex);


--
-- TOC entry 2409 (class 1259 OID 28371)
-- Dependencies: 1897
-- Name: ebsc_orgobjectives_objectives_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_objectives_id ON ebsc_orgobjectives_objectives USING btree (id);


--
-- TOC entry 2416 (class 1259 OID 28372)
-- Dependencies: 1899
-- Name: ebsc_orgobjectives_perspective_ahp_objid; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_perspective_ahp_objid ON ebsc_orgobjectives_perspective_ahp USING btree (obj_id);


--
-- TOC entry 2417 (class 1259 OID 28373)
-- Dependencies: 1899 1899
-- Name: ebsc_orgobjectives_perspective_ahp_objid_hindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_perspective_ahp_objid_hindex ON ebsc_orgobjectives_perspective_ahp USING btree (obj_id, hindex);


--
-- TOC entry 2418 (class 1259 OID 28374)
-- Dependencies: 1899 1899
-- Name: ebsc_orgobjectives_perspective_ahp_objid_vindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_perspective_ahp_objid_vindex ON ebsc_orgobjectives_perspective_ahp USING btree (obj_id, vindex);


--
-- TOC entry 2423 (class 1259 OID 28375)
-- Dependencies: 1901
-- Name: ebsc_orgobjectives_perspectives_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_perspectives_id ON ebsc_orgobjectives_perspectives USING btree (id);


--
-- TOC entry 2431 (class 1259 OID 28376)
-- Dependencies: 1903
-- Name: ebsc_orgobjectives_targets_id; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ebsc_orgobjectives_targets_id ON ebsc_orgobjectives_targets USING btree (id);


--
-- TOC entry 2695 (class 1259 OID 29483)
-- Dependencies: 1956 1956 1956 1956 1956 1956
-- Name: ix_103d6207; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_103d6207 ON journalarticleimage USING btree (groupid, articleid, version, elinstanceid, elname, languageid);


--
-- TOC entry 3001 (class 1259 OID 29670)
-- Dependencies: 2015 2015 2015
-- Name: ix_119b5630; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_119b5630 ON shoppingorder USING btree (groupid, userid, pppaymentstatus);


--
-- TOC entry 2898 (class 1259 OID 29614)
-- Dependencies: 1992 1992
-- Name: ix_11fb3e42; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_11fb3e42 ON region USING btree (countryid, active_);


--
-- TOC entry 2868 (class 1259 OID 29595)
-- Dependencies: 1986
-- Name: ix_12112599; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_12112599 ON pollsvote USING btree (questionid);


--
-- TOC entry 3010 (class 1259 OID 29681)
-- Dependencies: 2017
-- Name: ix_121ca3cb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_121ca3cb ON socialactivity USING btree (receiveruserid);


--
-- TOC entry 2548 (class 1259 OID 29383)
-- Dependencies: 1931
-- Name: ix_12566ec2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_12566ec2 ON company USING btree (mx);


--
-- TOC entry 3011 (class 1259 OID 29679)
-- Dependencies: 2017
-- Name: ix_1271f25f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1271f25f ON socialactivity USING btree (mirroractivityid);


--
-- TOC entry 3021 (class 1259 OID 29688)
-- Dependencies: 2018 2018 2018
-- Name: ix_12a92145; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_12a92145 ON socialrelation USING btree (userid1, userid2, type_);


--
-- TOC entry 2873 (class 1259 OID 29598)
-- Dependencies: 1987 1987
-- Name: ix_12b5e51d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_12b5e51d ON portlet USING btree (companyid, portletid);


--
-- TOC entry 2536 (class 1259 OID 29375)
-- Dependencies: 1929
-- Name: ix_12ee4898; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_12ee4898 ON calevent USING btree (groupid);


--
-- TOC entry 2779 (class 1259 OID 29540)
-- Dependencies: 1969 1969
-- Name: ix_138c7f1e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_138c7f1e ON mbmessage USING btree (categoryid, threadid);


--
-- TOC entry 3142 (class 1259 OID 29742)
-- Dependencies: 2039
-- Name: ix_14d8bcc0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_14d8bcc0 ON usertrackerpath USING btree (usertrackerid);


--
-- TOC entry 2491 (class 1259 OID 29344)
-- Dependencies: 1922 1922 1922
-- Name: ix_14f06a6b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_14f06a6b ON announcementsentry USING btree (classnameid, classpk, alert);


--
-- TOC entry 2696 (class 1259 OID 29482)
-- Dependencies: 1956 1956 1956
-- Name: ix_158b526f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_158b526f ON journalarticleimage USING btree (groupid, articleid, version);


--
-- TOC entry 2891 (class 1259 OID 29609)
-- Dependencies: 1990 1990
-- Name: ix_16184d57; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_16184d57 ON ratingsentry USING btree (classnameid, classpk);


--
-- TOC entry 2635 (class 1259 OID 29442)
-- Dependencies: 1947
-- Name: ix_16218a38; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_16218a38 ON group_ USING btree (livegroupid);


--
-- TOC entry 2899 (class 1259 OID 29613)
-- Dependencies: 1992
-- Name: ix_16d87ca7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_16d87ca7 ON region USING btree (countryid);


--
-- TOC entry 2727 (class 1259 OID 29504)
-- Dependencies: 1961 1961
-- Name: ix_1701cb2b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1701cb2b ON journaltemplate USING btree (groupid, structureid);


--
-- TOC entry 3075 (class 1259 OID 29719)
-- Dependencies: 2027 2027
-- Name: ix_181a4a1b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_181a4a1b ON tasksproposal USING btree (classnameid, classpk);


--
-- TOC entry 3080 (class 1259 OID 29724)
-- Dependencies: 2028 2028 2028
-- Name: ix_1894b29a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1894b29a ON tasksreview USING btree (proposalid, stage, completed);


--
-- TOC entry 2806 (class 1259 OID 29561)
-- Dependencies: 1972 1972
-- Name: ix_19d8b60a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_19d8b60a ON mbthread USING btree (categoryid, lastpostdate);


--
-- TOC entry 2560 (class 1259 OID 29391)
-- Dependencies: 1934
-- Name: ix_19da007b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_19da007b ON country USING btree (name);


--
-- TOC entry 2736 (class 1259 OID 29517)
-- Dependencies: 1962 1962 1962
-- Name: ix_1a1b61d2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1a1b61d2 ON layout USING btree (groupid, privatelayout, type_);


--
-- TOC entry 2660 (class 1259 OID 29454)
-- Dependencies: 1952 1952
-- Name: ix_1a605e9f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1a605e9f ON igfolder USING btree (groupid, parentfolderid);


--
-- TOC entry 3150 (class 1259 OID 29767)
-- Dependencies: 2042 2042 2042 2042
-- Name: ix_1aa07a6d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1aa07a6d ON website USING btree (companyid, classnameid, classpk, primary_);


--
-- TOC entry 3050 (class 1259 OID 29706)
-- Dependencies: 2021 2021
-- Name: ix_1ab6d6d2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_1ab6d6d2 ON tagsasset USING btree (classnameid, classpk);


--
-- TOC entry 2492 (class 1259 OID 29346)
-- Dependencies: 1922
-- Name: ix_1afbde08; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1afbde08 ON announcementsentry USING btree (uuid_);


--
-- TOC entry 2501 (class 1259 OID 29357)
-- Dependencies: 1924 1924
-- Name: ix_1b1040fd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_1b1040fd ON blogsentry USING btree (uuid_, groupid);


--
-- TOC entry 2728 (class 1259 OID 29507)
-- Dependencies: 1961
-- Name: ix_1b12ca20; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1b12ca20 ON journaltemplate USING btree (templateid);


--
-- TOC entry 3105 (class 1259 OID 29731)
-- Dependencies: 2031
-- Name: ix_1b988d7a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1b988d7a ON usergrouprole USING btree (groupid);


--
-- TOC entry 2605 (class 1259 OID 29417)
-- Dependencies: 1942
-- Name: ix_1bb072ca; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1bb072ca ON emailaddress USING btree (companyid);


--
-- TOC entry 2869 (class 1259 OID 29596)
-- Dependencies: 1986 1986
-- Name: ix_1bbfd4d3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_1bbfd4d3 ON pollsvote USING btree (questionid, userid);


--
-- TOC entry 2624 (class 1259 OID 29433)
-- Dependencies: 1946 1946
-- Name: ix_1bd3f4c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1bd3f4c ON expandovalue USING btree (tableid, classpk);


--
-- TOC entry 2988 (class 1259 OID 29663)
-- Dependencies: 2012 2012
-- Name: ix_1c717ca6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_1c717ca6 ON shoppingitem USING btree (companyid, sku);


--
-- TOC entry 2943 (class 1259 OID 29637)
-- Dependencies: 2002
-- Name: ix_1c841592; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1c841592 ON sclicense USING btree (active_);


--
-- TOC entry 3002 (class 1259 OID 29669)
-- Dependencies: 2015
-- Name: ix_1d15553e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1d15553e ON shoppingorder USING btree (groupid);


--
-- TOC entry 2980 (class 1259 OID 29659)
-- Dependencies: 2010 2010
-- Name: ix_1e6464f5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1e6464f5 ON shoppingcategory USING btree (groupid, parentcategoryid);


--
-- TOC entry 3164 (class 1259 OID 29780)
-- Dependencies: 2044 2044
-- Name: ix_1ecc7656; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1ecc7656 ON wikipage USING btree (nodeid, redirecttitle);


--
-- TOC entry 3012 (class 1259 OID 29680)
-- Dependencies: 2017 2017 2017
-- Name: ix_1f00c374; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1f00c374 ON socialactivity USING btree (mirroractivityid, classnameid, classpk);


--
-- TOC entry 2384 (class 1259 OID 29805)
-- Dependencies: 1889
-- Name: ix_1fd4f3d6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_1fd4f3d6 ON ebsc_orgobjectives_list USING btree (name);


--
-- TOC entry 2661 (class 1259 OID 29453)
-- Dependencies: 1952
-- Name: ix_206498f8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_206498f8 ON igfolder USING btree (groupid);


--
-- TOC entry 2705 (class 1259 OID 29488)
-- Dependencies: 1958 1958
-- Name: ix_20962903; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_20962903 ON journalcontentsearch USING btree (groupid, privatelayout);


--
-- TOC entry 2463 (class 1259 OID 28519)
-- Dependencies: 1916 1916
-- Name: ix_20d8706c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_20d8706c ON quartz_fired_triggers USING btree (trigger_name, trigger_group);


--
-- TOC entry 3177 (class 1259 OID 29786)
-- Dependencies: 2045 2045
-- Name: ix_21277664; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_21277664 ON wikipageresource USING btree (nodeid, title);


--
-- TOC entry 2918 (class 1259 OID 29621)
-- Dependencies: 1997 1997 1997 1997
-- Name: ix_2200aa69; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2200aa69 ON resourcepermission USING btree (companyid, name, scope, primkey);


--
-- TOC entry 2681 (class 1259 OID 29476)
-- Dependencies: 1955 1955
-- Name: ix_22882d02; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_22882d02 ON journalarticle USING btree (groupid, urltitle);


--
-- TOC entry 2737 (class 1259 OID 29518)
-- Dependencies: 1962
-- Name: ix_23922f7d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_23922f7d ON layout USING btree (iconimageid);


--
-- TOC entry 3100 (class 1259 OID 29729)
-- Dependencies: 2030 2030
-- Name: ix_23ead0d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_23ead0d ON usergroup USING btree (companyid, name);


--
-- TOC entry 2570 (class 1259 OID 29393)
-- Dependencies: 1937
-- Name: ix_24a846d1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_24a846d1 ON dlfileentry USING btree (folderid);


--
-- TOC entry 2905 (class 1259 OID 29624)
-- Dependencies: 1994
-- Name: ix_2578fbd3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2578fbd3 ON resource_ USING btree (codeid);


--
-- TOC entry 2561 (class 1259 OID 29390)
-- Dependencies: 1934
-- Name: ix_25d734cd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_25d734cd ON country USING btree (active_);


--
-- TOC entry 2729 (class 1259 OID 29506)
-- Dependencies: 1961
-- Name: ix_25ffb6fa; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_25ffb6fa ON journaltemplate USING btree (smallimageid);


--
-- TOC entry 2668 (class 1259 OID 29466)
-- Dependencies: 1953
-- Name: ix_265bb0f1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_265bb0f1 ON igimage USING btree (uuid_);


--
-- TOC entry 2947 (class 1259 OID 29639)
-- Dependencies: 2003
-- Name: ix_27006638; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_27006638 ON sclicenses_scproductentries USING btree (licenseid);


--
-- TOC entry 2938 (class 1259 OID 29635)
-- Dependencies: 2001
-- Name: ix_272991fa; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_272991fa ON scframeworkversion USING btree (groupid);


--
-- TOC entry 2730 (class 1259 OID 29508)
-- Dependencies: 1961
-- Name: ix_2857419d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2857419d ON journaltemplate USING btree (uuid_);


--
-- TOC entry 2512 (class 1259 OID 29360)
-- Dependencies: 1925 1925
-- Name: ix_28c78d5c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_28c78d5c ON blogsstatsuser USING btree (groupid, entrycount);


--
-- TOC entry 3058 (class 1259 OID 29711)
-- Dependencies: 2023
-- Name: ix_28e8954; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_28e8954 ON tagsentry USING btree (vocabularyid);


--
-- TOC entry 2752 (class 1259 OID 29522)
-- Dependencies: 1964
-- Name: ix_2932dd37; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2932dd37 ON listtype USING btree (type_);


--
-- TOC entry 3137 (class 1259 OID 29739)
-- Dependencies: 2038
-- Name: ix_29ba1cf5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_29ba1cf5 ON usertracker USING btree (companyid);


--
-- TOC entry 3013 (class 1259 OID 29677)
-- Dependencies: 2017
-- Name: ix_2a2468; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2a2468 ON socialactivity USING btree (groupid);


--
-- TOC entry 2606 (class 1259 OID 29420)
-- Dependencies: 1942 1942 1942 1942
-- Name: ix_2a2cb130; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2a2cb130 ON emailaddress USING btree (companyid, classnameid, classpk, primary_);


--
-- TOC entry 2428 (class 1259 OID 31878)
-- Dependencies: 1901
-- Name: ix_2a2e3c17; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2a2e3c17 ON ebsc_orgobjectives_perspectives USING btree (pertype);


--
-- TOC entry 2526 (class 1259 OID 29368)
-- Dependencies: 1927
-- Name: ix_2aba25d7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2aba25d7 ON bookmarksfolder USING btree (companyid);


--
-- TOC entry 2373 (class 1259 OID 29804)
-- Dependencies: 1885
-- Name: ix_2abbf322; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2abbf322 ON ebsc_orgobjectives_approval USING btree (status);


--
-- TOC entry 2832 (class 1259 OID 29574)
-- Dependencies: 1978 1978
-- Name: ix_2c1142e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2c1142e ON passwordpolicy USING btree (companyid, defaultpolicy);


--
-- TOC entry 2877 (class 1259 OID 29601)
-- Dependencies: 1988 1988
-- Name: ix_2c61314e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2c61314e ON portletitem USING btree (groupid, portletid);


--
-- TOC entry 2900 (class 1259 OID 29612)
-- Dependencies: 1992
-- Name: ix_2d9a426f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2d9a426f ON region USING btree (active_);


--
-- TOC entry 2429 (class 1259 OID 31877)
-- Dependencies: 1901
-- Name: ix_2e02cd47; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2e02cd47 ON ebsc_orgobjectives_perspectives USING btree (obj_id);


--
-- TOC entry 3044 (class 1259 OID 29703)
-- Dependencies: 2020 2020 2020 2020
-- Name: ix_2e1a92d4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_2e1a92d4 ON subscription USING btree (companyid, userid, classnameid, classpk);


--
-- TOC entry 2682 (class 1259 OID 29474)
-- Dependencies: 1955 1955
-- Name: ix_2e207659; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2e207659 ON journalarticle USING btree (groupid, structureid);


--
-- TOC entry 2791 (class 1259 OID 29555)
-- Dependencies: 1970 1970 1970
-- Name: ix_2ea537d7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_2ea537d7 ON mbmessageflag USING btree (userid, threadid, flag);


--
-- TOC entry 2652 (class 1259 OID 29449)
-- Dependencies: 1950
-- Name: ix_3103ef3d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3103ef3d ON groups_roles USING btree (roleid);


--
-- TOC entry 2656 (class 1259 OID 29450)
-- Dependencies: 1951
-- Name: ix_31fb749a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_31fb749a ON groups_usergroups USING btree (groupid);


--
-- TOC entry 3032 (class 1259 OID 29694)
-- Dependencies: 2019
-- Name: ix_32292ed1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_32292ed1 ON socialrequest USING btree (receiveruserid);


--
-- TOC entry 2984 (class 1259 OID 29661)
-- Dependencies: 2011
-- Name: ix_3251af16; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3251af16 ON shoppingcoupon USING btree (groupid);


--
-- TOC entry 2840 (class 1259 OID 29578)
-- Dependencies: 1980
-- Name: ix_326f75bd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_326f75bd ON passwordtracker USING btree (userid);


--
-- TOC entry 2385 (class 1259 OID 29807)
-- Dependencies: 1889
-- Name: ix_32cd5d08; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_32cd5d08 ON ebsc_orgobjectives_list USING btree (year);


--
-- TOC entry 2768 (class 1259 OID 29533)
-- Dependencies: 1967 1967
-- Name: ix_33a4de38; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_33a4de38 ON mbdiscussion USING btree (classnameid, classpk);


--
-- TOC entry 2878 (class 1259 OID 29604)
-- Dependencies: 1988 1988 1988
-- Name: ix_33b8ce8d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_33b8ce8d ON portletitem USING btree (groupid, portletid, name);


--
-- TOC entry 2683 (class 1259 OID 29480)
-- Dependencies: 1955 1955
-- Name: ix_3463d95b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_3463d95b ON journalarticle USING btree (uuid_, groupid);


--
-- TOC entry 3014 (class 1259 OID 29682)
-- Dependencies: 2017
-- Name: ix_3504b8bc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3504b8bc ON socialactivity USING btree (userid);


--
-- TOC entry 2713 (class 1259 OID 29493)
-- Dependencies: 1959
-- Name: ix_35a2db2f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_35a2db2f ON journalfeed USING btree (groupid);


--
-- TOC entry 2549 (class 1259 OID 29384)
-- Dependencies: 1931
-- Name: ix_35e3e7c6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_35e3e7c6 ON company USING btree (system);


--
-- TOC entry 3033 (class 1259 OID 29697)
-- Dependencies: 2019 2019 2019 2019 2019
-- Name: ix_36a90ca7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_36a90ca7 ON socialrequest USING btree (userid, classnameid, classpk, type_, receiveruserid);


--
-- TOC entry 3081 (class 1259 OID 29726)
-- Dependencies: 2028
-- Name: ix_36f512e6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_36f512e6 ON tasksreview USING btree (userid);


--
-- TOC entry 2620 (class 1259 OID 29427)
-- Dependencies: 1945 1945 1945
-- Name: ix_37562284; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_37562284 ON expandotable USING btree (companyid, classnameid, name);


--
-- TOC entry 2400 (class 1259 OID 29808)
-- Dependencies: 1893
-- Name: ix_38b8d18d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_38b8d18d ON ebsc_orgobjectives_measures USING btree (name);


--
-- TOC entry 2550 (class 1259 OID 29382)
-- Dependencies: 1931
-- Name: ix_38efe3fd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_38efe3fd ON company USING btree (logoid);


--
-- TOC entry 2714 (class 1259 OID 29496)
-- Dependencies: 1959 1959
-- Name: ix_39031f51; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_39031f51 ON journalfeed USING btree (uuid_, groupid);


--
-- TOC entry 3088 (class 1259 OID 29743)
-- Dependencies: 2029
-- Name: ix_3a1e834e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3a1e834e ON user_ USING btree (companyid);


--
-- TOC entry 2697 (class 1259 OID 29481)
-- Dependencies: 1956
-- Name: ix_3b51bb68; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3b51bb68 ON journalarticleimage USING btree (groupid);


--
-- TOC entry 2657 (class 1259 OID 29451)
-- Dependencies: 1951
-- Name: ix_3b69160f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3b69160f ON groups_usergroups USING btree (usergroupid);


--
-- TOC entry 2934 (class 1259 OID 29632)
-- Dependencies: 2000
-- Name: ix_3bb93eca; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3bb93eca ON scframeworkversi_scproductvers USING btree (frameworkversionid);


--
-- TOC entry 2780 (class 1259 OID 29539)
-- Dependencies: 1969
-- Name: ix_3c865ee5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3c865ee5 ON mbmessage USING btree (categoryid);


--
-- TOC entry 2596 (class 1259 OID 29416)
-- Dependencies: 1941 1941
-- Name: ix_3cc1ded2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_3cc1ded2 ON dlfolder USING btree (uuid_, groupid);


--
-- TOC entry 2792 (class 1259 OID 29552)
-- Dependencies: 1970 1970
-- Name: ix_3cfd579d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3cfd579d ON mbmessageflag USING btree (threadid, flag);


--
-- TOC entry 3165 (class 1259 OID 29783)
-- Dependencies: 2044 2044 2044
-- Name: ix_3d4af476; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_3d4af476 ON wikipage USING btree (nodeid, title, version);


--
-- TOC entry 2414 (class 1259 OID 29809)
-- Dependencies: 1897
-- Name: ix_3d898352; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3d898352 ON ebsc_orgobjectives_objectives USING btree (name);


--
-- TOC entry 3022 (class 1259 OID 29690)
-- Dependencies: 2018 2018
-- Name: ix_3f9c2fa8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_3f9c2fa8 ON socialrelation USING btree (userid2, type_);


--
-- TOC entry 2833 (class 1259 OID 29575)
-- Dependencies: 1978 1978
-- Name: ix_3fbfa9f4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_3fbfa9f4 ON passwordpolicy USING btree (companyid, name);


--
-- TOC entry 2580 (class 1259 OID 29401)
-- Dependencies: 1938 1938
-- Name: ix_40b56512; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_40b56512 ON dlfilerank USING btree (folderid, name);


--
-- TOC entry 2773 (class 1259 OID 29537)
-- Dependencies: 1968
-- Name: ix_4115ec7a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4115ec7a ON mbmailinglist USING btree (uuid_);


--
-- TOC entry 2816 (class 1259 OID 29573)
-- Dependencies: 1974 1974
-- Name: ix_418e4522; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_418e4522 ON organization_ USING btree (companyid, parentorganizationid);


--
-- TOC entry 3112 (class 1259 OID 29736)
-- Dependencies: 2032 2032
-- Name: ix_41a32e0d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_41a32e0d ON useridmapper USING btree (type_, externaluserid);


--
-- TOC entry 3082 (class 1259 OID 29725)
-- Dependencies: 2028 2028 2028 2028
-- Name: ix_41afc20c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_41afc20c ON tasksreview USING btree (proposalid, stage, completed, rejected);


--
-- TOC entry 2719 (class 1259 OID 29502)
-- Dependencies: 1960 1960
-- Name: ix_42e86e58; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_42e86e58 ON journalstructure USING btree (uuid_, groupid);


--
-- TOC entry 2571 (class 1259 OID 29397)
-- Dependencies: 1937 1937
-- Name: ix_43261870; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_43261870 ON dlfileentry USING btree (groupid, userid);


--
-- TOC entry 2513 (class 1259 OID 29359)
-- Dependencies: 1925
-- Name: ix_43840eeb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_43840eeb ON blogsstatsuser USING btree (groupid);


--
-- TOC entry 2669 (class 1259 OID 29460)
-- Dependencies: 1953
-- Name: ix_4438ca80; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4438ca80 ON igimage USING btree (folderid);


--
-- TOC entry 2519 (class 1259 OID 29363)
-- Dependencies: 1926
-- Name: ix_443bdc38; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_443bdc38 ON bookmarksentry USING btree (folderid);


--
-- TOC entry 2924 (class 1259 OID 29626)
-- Dependencies: 1998
-- Name: ix_449a10b9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_449a10b9 ON role_ USING btree (companyid);


--
-- TOC entry 2527 (class 1259 OID 29371)
-- Dependencies: 1927
-- Name: ix_451e7ae3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_451e7ae3 ON bookmarksfolder USING btree (uuid_);


--
-- TOC entry 2497 (class 1259 OID 29348)
-- Dependencies: 1923 1923 1923
-- Name: ix_4539a99c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_4539a99c ON announcementsflag USING btree (userid, entryid, value);


--
-- TOC entry 2957 (class 1259 OID 29646)
-- Dependencies: 2005
-- Name: ix_467956fd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_467956fd ON scproductscreenshot USING btree (productentryid);


--
-- TOC entry 3138 (class 1259 OID 29740)
-- Dependencies: 2038
-- Name: ix_46b0ae8e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_46b0ae8e ON usertracker USING btree (sessionid);


--
-- TOC entry 3166 (class 1259 OID 29779)
-- Dependencies: 2044 2044
-- Name: ix_46eef3c8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_46eef3c8 ON wikipage USING btree (nodeid, parenttitle);


--
-- TOC entry 2586 (class 1259 OID 29406)
-- Dependencies: 1939
-- Name: ix_4831ebe4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4831ebe4 ON dlfileshortcut USING btree (uuid_);


--
-- TOC entry 2747 (class 1259 OID 29520)
-- Dependencies: 1963 1963
-- Name: ix_48550691; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_48550691 ON layoutset USING btree (groupid, privatelayout);


--
-- TOC entry 2755 (class 1259 OID 29526)
-- Dependencies: 1965
-- Name: ix_48814bba; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_48814bba ON mbban USING btree (userid);


--
-- TOC entry 2597 (class 1259 OID 29412)
-- Dependencies: 1941 1941
-- Name: ix_49c37475; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_49c37475 ON dlfolder USING btree (groupid, parentfolderid);


--
-- TOC entry 2607 (class 1259 OID 29418)
-- Dependencies: 1942 1942
-- Name: ix_49d2dec4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_49d2dec4 ON emailaddress USING btree (companyid, classnameid);


--
-- TOC entry 3034 (class 1259 OID 29700)
-- Dependencies: 2019
-- Name: ix_49d5872c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_49d5872c ON socialrequest USING btree (uuid_);


--
-- TOC entry 2825 (class 1259 OID 29568)
-- Dependencies: 1976
-- Name: ix_4a527dd3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4a527dd3 ON orggrouprole USING btree (groupid);


--
-- TOC entry 3023 (class 1259 OID 29687)
-- Dependencies: 2018 2018
-- Name: ix_4b52be89; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4b52be89 ON socialrelation USING btree (userid1, type_);


--
-- TOC entry 2572 (class 1259 OID 29392)
-- Dependencies: 1937
-- Name: ix_4cb1b2b4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4cb1b2b4 ON dlfileentry USING btree (companyid);


--
-- TOC entry 3106 (class 1259 OID 29735)
-- Dependencies: 2031 2031
-- Name: ix_4d040680; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4d040680 ON usergrouprole USING btree (userid, groupid);


--
-- TOC entry 3083 (class 1259 OID 29722)
-- Dependencies: 2028
-- Name: ix_4d0c7f8d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4d0c7f8d ON tasksreview USING btree (proposalid);


--
-- TOC entry 2843 (class 1259 OID 29579)
-- Dependencies: 1981 1981
-- Name: ix_4d19c2b8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_4d19c2b8 ON permission_ USING btree (actionid, resourceid);


--
-- TOC entry 2967 (class 1259 OID 29652)
-- Dependencies: 2007 2007
-- Name: ix_4f0315b8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_4f0315b8 ON servicecomponent USING btree (buildnamespace, buildnumber);


--
-- TOC entry 3151 (class 1259 OID 29765)
-- Dependencies: 2042 2042
-- Name: ix_4f0f0ca7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4f0f0ca7 ON website USING btree (companyid, classnameid);


--
-- TOC entry 3035 (class 1259 OID 29701)
-- Dependencies: 2019 2019
-- Name: ix_4f973efe; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_4f973efe ON socialrequest USING btree (uuid_, groupid);


--
-- TOC entry 2537 (class 1259 OID 29376)
-- Dependencies: 1929 1929
-- Name: ix_4fddd2bf; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_4fddd2bf ON calevent USING btree (groupid, repeating);


--
-- TOC entry 2715 (class 1259 OID 29495)
-- Dependencies: 1959
-- Name: ix_50c36d79; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_50c36d79 ON journalfeed USING btree (uuid_);


--
-- TOC entry 2598 (class 1259 OID 29414)
-- Dependencies: 1941 1941
-- Name: ix_51556082; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_51556082 ON dlfolder USING btree (parentfolderid, name);


--
-- TOC entry 2781 (class 1259 OID 29541)
-- Dependencies: 1969 1969
-- Name: ix_51a8d44d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_51a8d44d ON mbmessage USING btree (classnameid, classpk);


--
-- TOC entry 2863 (class 1259 OID 29592)
-- Dependencies: 1985
-- Name: ix_51f087f4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_51f087f4 ON pollsquestion USING btree (uuid_);


--
-- TOC entry 3062 (class 1259 OID 29714)
-- Dependencies: 2024
-- Name: ix_5200a629; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5200a629 ON tagsproperty USING btree (entryid);


--
-- TOC entry 3101 (class 1259 OID 29728)
-- Dependencies: 2030
-- Name: ix_524fefce; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_524fefce ON usergroup USING btree (companyid);


--
-- TOC entry 2944 (class 1259 OID 29638)
-- Dependencies: 2002 2002
-- Name: ix_5327bb79; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5327bb79 ON sclicense USING btree (active_, recommended);


--
-- TOC entry 2975 (class 1259 OID 29657)
-- Dependencies: 2009
-- Name: ix_54101cc8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_54101cc8 ON shoppingcart USING btree (userid);


--
-- TOC entry 3045 (class 1259 OID 29704)
-- Dependencies: 2020
-- Name: ix_54243afd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_54243afd ON subscription USING btree (userid);


--
-- TOC entry 2608 (class 1259 OID 29419)
-- Dependencies: 1942 1942 1942
-- Name: ix_551a519f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_551a519f ON emailaddress USING btree (companyid, classnameid, classpk);


--
-- TOC entry 3024 (class 1259 OID 29686)
-- Dependencies: 2018
-- Name: ix_5a40cdcc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5a40cdcc ON socialrelation USING btree (userid1);


--
-- TOC entry 3025 (class 1259 OID 29689)
-- Dependencies: 2018
-- Name: ix_5a40d18d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5a40d18d ON socialrelation USING btree (userid2);


--
-- TOC entry 2636 (class 1259 OID 29441)
-- Dependencies: 1947 1947
-- Name: ix_5aa68501; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5aa68501 ON group_ USING btree (companyid, name);


--
-- TOC entry 2748 (class 1259 OID 29521)
-- Dependencies: 1963
-- Name: ix_5abc2905; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5abc2905 ON layoutset USING btree (virtualhost);


--
-- TOC entry 3089 (class 1259 OID 29748)
-- Dependencies: 2029
-- Name: ix_5adbe171; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5adbe171 ON user_ USING btree (contactid);


--
-- TOC entry 2782 (class 1259 OID 29543)
-- Dependencies: 1969
-- Name: ix_5b153fb2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5b153fb2 ON mbmessage USING btree (groupid);


--
-- TOC entry 2479 (class 1259 OID 29340)
-- Dependencies: 1920
-- Name: ix_5bc8b0d4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5bc8b0d4 ON address USING btree (userid);


--
-- TOC entry 2637 (class 1259 OID 29439)
-- Dependencies: 1947 1947
-- Name: ix_5bddb872; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5bddb872 ON group_ USING btree (companyid, friendlyurl);


--
-- TOC entry 2756 (class 1259 OID 29524)
-- Dependencies: 1965
-- Name: ix_5c3ff12a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5c3ff12a ON mbban USING btree (groupid);


--
-- TOC entry 3084 (class 1259 OID 29727)
-- Dependencies: 2028 2028
-- Name: ix_5c6be4c7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5c6be4c7 ON tasksreview USING btree (userid, proposalid);


--
-- TOC entry 2538 (class 1259 OID 29380)
-- Dependencies: 1929 1929
-- Name: ix_5cce79c8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5cce79c8 ON calevent USING btree (uuid_, groupid);


--
-- TOC entry 2951 (class 1259 OID 29641)
-- Dependencies: 2004
-- Name: ix_5d25244f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5d25244f ON scproductentry USING btree (companyid);


--
-- TOC entry 3157 (class 1259 OID 29769)
-- Dependencies: 2043
-- Name: ix_5d6fe3f0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5d6fe3f0 ON wikinode USING btree (companyid);


--
-- TOC entry 2638 (class 1259 OID 29438)
-- Dependencies: 1947 1947 1947 1947
-- Name: ix_5de0be11; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_5de0be11 ON group_ USING btree (companyid, classnameid, livegroupid, name);


--
-- TOC entry 2386 (class 1259 OID 29806)
-- Dependencies: 1889
-- Name: ix_5f1e88a1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5f1e88a1 ON ebsc_orgobjectives_list USING btree (org_id);


--
-- TOC entry 2981 (class 1259 OID 29658)
-- Dependencies: 2010
-- Name: ix_5f615d3e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5f615d3e ON shoppingcategory USING btree (groupid);


--
-- TOC entry 2464 (class 1259 OID 28518)
-- Dependencies: 1916
-- Name: ix_5feabbc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_5feabbc ON quartz_fired_triggers USING btree (trigger_name);


--
-- TOC entry 2662 (class 1259 OID 29452)
-- Dependencies: 1952
-- Name: ix_60214cf6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_60214cf6 ON igfolder USING btree (companyid);


--
-- TOC entry 2919 (class 1259 OID 29620)
-- Dependencies: 1997 1997 1997
-- Name: ix_60b99860; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_60b99860 ON resourcepermission USING btree (companyid, name, scope);


--
-- TOC entry 3026 (class 1259 OID 29683)
-- Dependencies: 2018
-- Name: ix_61171e99; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_61171e99 ON socialrelation USING btree (companyid);


--
-- TOC entry 3090 (class 1259 OID 29745)
-- Dependencies: 2029 2029
-- Name: ix_615e9f7a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_615e9f7a ON user_ USING btree (companyid, emailaddress);


--
-- TOC entry 2731 (class 1259 OID 29509)
-- Dependencies: 1961 1961
-- Name: ix_62d1b3ad; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_62d1b3ad ON journaltemplate USING btree (uuid_, groupid);


--
-- TOC entry 2670 (class 1259 OID 29462)
-- Dependencies: 1953
-- Name: ix_63820a7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_63820a7 ON igimage USING btree (groupid);


--
-- TOC entry 2465 (class 1259 OID 28517)
-- Dependencies: 1916
-- Name: ix_64b194f2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_64b194f2 ON quartz_fired_triggers USING btree (trigger_group);


--
-- TOC entry 3015 (class 1259 OID 29676)
-- Dependencies: 2017
-- Name: ix_64b1bc66; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_64b1bc66 ON socialactivity USING btree (companyid);


--
-- TOC entry 2671 (class 1259 OID 29464)
-- Dependencies: 1953
-- Name: ix_64f0b572; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_64f0b572 ON igimage USING btree (largeimageid);


--
-- TOC entry 2573 (class 1259 OID 29398)
-- Dependencies: 1937
-- Name: ix_64f0fe40; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_64f0fe40 ON dlfileentry USING btree (uuid_);


--
-- TOC entry 2716 (class 1259 OID 29494)
-- Dependencies: 1959 1959
-- Name: ix_65576cbc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_65576cbc ON journalfeed USING btree (groupid, feedid);


--
-- TOC entry 3167 (class 1259 OID 29778)
-- Dependencies: 2044 2044 2044
-- Name: ix_65e84af4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_65e84af4 ON wikipage USING btree (nodeid, head, parenttitle);


--
-- TOC entry 2858 (class 1259 OID 29590)
-- Dependencies: 1984
-- Name: ix_6660b399; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6660b399 ON pollschoice USING btree (uuid_);


--
-- TOC entry 2555 (class 1259 OID 29387)
-- Dependencies: 1932
-- Name: ix_66d496a3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_66d496a3 ON contact_ USING btree (companyid);


--
-- TOC entry 2811 (class 1259 OID 29565)
-- Dependencies: 1973
-- Name: ix_66d70879; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_66d70879 ON membershiprequest USING btree (userid);


--
-- TOC entry 3133 (class 1259 OID 29761)
-- Dependencies: 2037
-- Name: ix_66ff2503; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_66ff2503 ON users_usergroups USING btree (usergroupid);


--
-- TOC entry 2720 (class 1259 OID 29501)
-- Dependencies: 1960
-- Name: ix_6702ca92; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6702ca92 ON journalstructure USING btree (uuid_);


--
-- TOC entry 2906 (class 1259 OID 29625)
-- Dependencies: 1994 1994
-- Name: ix_67de7856; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_67de7856 ON resource_ USING btree (codeid, primkey);


--
-- TOC entry 2706 (class 1259 OID 29487)
-- Dependencies: 1958 1958
-- Name: ix_6838e427; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6838e427 ON journalcontentsearch USING btree (groupid, articleid);


--
-- TOC entry 2684 (class 1259 OID 29471)
-- Dependencies: 1955 1955
-- Name: ix_68c0f69c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_68c0f69c ON journalarticle USING btree (groupid, articleid);


--
-- TOC entry 2502 (class 1259 OID 29356)
-- Dependencies: 1924
-- Name: ix_69157a4d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_69157a4d ON blogsentry USING btree (uuid_);


--
-- TOC entry 3102 (class 1259 OID 29730)
-- Dependencies: 2030 2030
-- Name: ix_69771487; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_69771487 ON usergroup USING btree (companyid, parentusergroupid);


--
-- TOC entry 2757 (class 1259 OID 29523)
-- Dependencies: 1965
-- Name: ix_69951a25; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_69951a25 ON mbban USING btree (banuserid);


--
-- TOC entry 2680 (class 1259 OID 29468)
-- Dependencies: 1954
-- Name: ix_6a925a4d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6a925a4d ON image USING btree (size_);


--
-- TOC entry 2829 (class 1259 OID 29570)
-- Dependencies: 1977
-- Name: ix_6af0d434; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6af0d434 ON orglabor USING btree (organizationid);


--
-- TOC entry 2644 (class 1259 OID 29445)
-- Dependencies: 1948
-- Name: ix_6bbb7682; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6bbb7682 ON groups_orgs USING btree (organizationid);


--
-- TOC entry 3158 (class 1259 OID 29772)
-- Dependencies: 2043
-- Name: ix_6c112d7c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6c112d7c ON wikinode USING btree (uuid_);


--
-- TOC entry 2821 (class 1259 OID 29567)
-- Dependencies: 1975
-- Name: ix_6c53da4e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6c53da4e ON orggrouppermission USING btree (permissionid);


--
-- TOC entry 2958 (class 1259 OID 29648)
-- Dependencies: 2005
-- Name: ix_6c572dac; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6c572dac ON scproductscreenshot USING btree (thumbnailid);


--
-- TOC entry 2592 (class 1259 OID 29409)
-- Dependencies: 1940 1940 1940
-- Name: ix_6c5e6512; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_6c5e6512 ON dlfileversion USING btree (folderid, name, version);


--
-- TOC entry 2995 (class 1259 OID 29667)
-- Dependencies: 2013
-- Name: ix_6d5f9b87; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6d5f9b87 ON shoppingitemfield USING btree (itemid);


--
-- TOC entry 2738 (class 1259 OID 29516)
-- Dependencies: 1962 1962 1962
-- Name: ix_6de88b06; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6de88b06 ON layout USING btree (groupid, privatelayout, parentlayoutid);


--
-- TOC entry 2939 (class 1259 OID 29636)
-- Dependencies: 2001 2001
-- Name: ix_6e1764f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6e1764f ON scframeworkversion USING btree (groupid, active_);


--
-- TOC entry 2487 (class 1259 OID 29341)
-- Dependencies: 1921
-- Name: ix_6edb9600; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6edb9600 ON announcementsdelivery USING btree (userid);


--
-- TOC entry 3076 (class 1259 OID 29721)
-- Dependencies: 2027 2027
-- Name: ix_6eec675e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6eec675e ON tasksproposal USING btree (groupid, userid);


--
-- TOC entry 3091 (class 1259 OID 29744)
-- Dependencies: 2029 2029
-- Name: ix_6ef03e4e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_6ef03e4e ON user_ USING btree (companyid, defaultuser);


--
-- TOC entry 2963 (class 1259 OID 29649)
-- Dependencies: 2006
-- Name: ix_7020130f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7020130f ON scproductversion USING btree (directdownloadurl);


--
-- TOC entry 2739 (class 1259 OID 29513)
-- Dependencies: 1962 1962
-- Name: ix_705f5aa3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_705f5aa3 ON layout USING btree (groupid, privatelayout);


--
-- TOC entry 3085 (class 1259 OID 29723)
-- Dependencies: 2028 2028
-- Name: ix_70afea01; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_70afea01 ON tasksreview USING btree (proposalid, stage);


--
-- TOC entry 2740 (class 1259 OID 29515)
-- Dependencies: 1962 1962 1962
-- Name: ix_7162c27c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_7162c27c ON layout USING btree (groupid, privatelayout, layoutid);


--
-- TOC entry 2854 (class 1259 OID 29587)
-- Dependencies: 1983 1983 1983
-- Name: ix_7171b2e8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_7171b2e8 ON pluginsetting USING btree (companyid, pluginid, plugintype);


--
-- TOC entry 2562 (class 1259 OID 29388)
-- Dependencies: 1934
-- Name: ix_717b97e1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_717b97e1 ON country USING btree (a2);


--
-- TOC entry 2563 (class 1259 OID 29389)
-- Dependencies: 1934
-- Name: ix_717b9ba2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_717b9ba2 ON country USING btree (a3);


--
-- TOC entry 2913 (class 1259 OID 29617)
-- Dependencies: 1996
-- Name: ix_717fdd47; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_717fdd47 ON resourcecode USING btree (companyid);


--
-- TOC entry 2480 (class 1259 OID 29337)
-- Dependencies: 1920 1920 1920
-- Name: ix_71cb1123; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_71cb1123 ON address USING btree (companyid, classnameid, classpk);


--
-- TOC entry 2503 (class 1259 OID 29349)
-- Dependencies: 1924
-- Name: ix_72ef6041; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_72ef6041 ON blogsentry USING btree (companyid);


--
-- TOC entry 2952 (class 1259 OID 29642)
-- Dependencies: 2004
-- Name: ix_72f87291; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_72f87291 ON scproductentry USING btree (groupid);


--
-- TOC entry 2953 (class 1259 OID 29644)
-- Dependencies: 2004 2004
-- Name: ix_7311e812; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7311e812 ON scproductentry USING btree (repogroupid, repoartifactid);


--
-- TOC entry 2968 (class 1259 OID 29651)
-- Dependencies: 2007
-- Name: ix_7338606f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7338606f ON servicecomponent USING btree (buildnamespace);


--
-- TOC entry 2645 (class 1259 OID 29444)
-- Dependencies: 1948
-- Name: ix_75267dca; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_75267dca ON groups_orgs USING btree (groupid);


--
-- TOC entry 2783 (class 1259 OID 29545)
-- Dependencies: 1969
-- Name: ix_75b95071; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_75b95071 ON mbmessage USING btree (threadid);


--
-- TOC entry 3159 (class 1259 OID 29773)
-- Dependencies: 2043 2043
-- Name: ix_7609b2ae; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_7609b2ae ON wikinode USING btree (uuid_, groupid);


--
-- TOC entry 2685 (class 1259 OID 29477)
-- Dependencies: 1955 1955
-- Name: ix_76186981; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_76186981 ON journalarticle USING btree (resourceprimkey, approved);


--
-- TOC entry 3092 (class 1259 OID 29749)
-- Dependencies: 2029
-- Name: ix_762f63c6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_762f63c6 ON user_ USING btree (emailaddress);


--
-- TOC entry 2732 (class 1259 OID 29503)
-- Dependencies: 1961
-- Name: ix_77923653; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_77923653 ON journaltemplate USING btree (groupid);


--
-- TOC entry 3046 (class 1259 OID 29702)
-- Dependencies: 2020 2020 2020
-- Name: ix_786d171a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_786d171a ON subscription USING btree (companyid, classnameid, classpk);


--
-- TOC entry 2769 (class 1259 OID 29532)
-- Dependencies: 1967
-- Name: ix_79d0120b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_79d0120b ON mbdiscussion USING btree (classnameid);


--
-- TOC entry 2930 (class 1259 OID 29630)
-- Dependencies: 1999
-- Name: ix_7a3619c6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7a3619c6 ON roles_permissions USING btree (permissionid);


--
-- TOC entry 2707 (class 1259 OID 29491)
-- Dependencies: 1958 1958 1958 1958
-- Name: ix_7acc74c9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7acc74c9 ON journalcontentsearch USING btree (groupid, privatelayout, layoutid, portletid);


--
-- TOC entry 2793 (class 1259 OID 29553)
-- Dependencies: 1970
-- Name: ix_7b2917be; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7b2917be ON mbmessageflag USING btree (userid);


--
-- TOC entry 2609 (class 1259 OID 29421)
-- Dependencies: 1942
-- Name: ix_7b43cd8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7b43cd8 ON emailaddress USING btree (userid);


--
-- TOC entry 2639 (class 1259 OID 29443)
-- Dependencies: 1947 1947
-- Name: ix_7b590a7a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7b590a7a ON group_ USING btree (type_, active_);


--
-- TOC entry 2708 (class 1259 OID 29489)
-- Dependencies: 1958 1958 1958
-- Name: ix_7cc7d73e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7cc7d73e ON journalcontentsearch USING btree (groupid, privatelayout, articleid);


--
-- TOC entry 3121 (class 1259 OID 29755)
-- Dependencies: 2034
-- Name: ix_7ef4ec0e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7ef4ec0e ON users_orgs USING btree (organizationid);


--
-- TOC entry 2528 (class 1259 OID 29369)
-- Dependencies: 1927
-- Name: ix_7f703619; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7f703619 ON bookmarksfolder USING btree (groupid);


--
-- TOC entry 3077 (class 1259 OID 29720)
-- Dependencies: 2027
-- Name: ix_7fb27324; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_7fb27324 ON tasksproposal USING btree (groupid);


--
-- TOC entry 2446 (class 1259 OID 28513)
-- Dependencies: 1909 1909
-- Name: ix_8040c593; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8040c593 ON quartz_triggers USING btree (trigger_state, next_fire_time);


--
-- TOC entry 2466 (class 1259 OID 28514)
-- Dependencies: 1916
-- Name: ix_804154af; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_804154af ON quartz_fired_triggers USING btree (instance_name);


--
-- TOC entry 2874 (class 1259 OID 29597)
-- Dependencies: 1987
-- Name: ix_80cc9508; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_80cc9508 ON portlet USING btree (companyid);


--
-- TOC entry 3036 (class 1259 OID 29696)
-- Dependencies: 2019
-- Name: ix_80f7a9c2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_80f7a9c2 ON socialrequest USING btree (userid);


--
-- TOC entry 2847 (class 1259 OID 29584)
-- Dependencies: 1982 1982 1982 1982
-- Name: ix_812ce07a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_812ce07a ON phone USING btree (companyid, classnameid, classpk, primary_);


--
-- TOC entry 2504 (class 1259 OID 29351)
-- Dependencies: 1924
-- Name: ix_81a50303; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_81a50303 ON blogsentry USING btree (groupid);


--
-- TOC entry 2616 (class 1259 OID 29425)
-- Dependencies: 1944 1944
-- Name: ix_81efbff5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_81efbff5 ON expandorow USING btree (tableid, classpk);


--
-- TOC entry 2909 (class 1259 OID 29615)
-- Dependencies: 1995
-- Name: ix_81f2db09; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_81f2db09 ON resourceaction USING btree (name);


--
-- TOC entry 2514 (class 1259 OID 29361)
-- Dependencies: 1925 1925
-- Name: ix_82254c25; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_82254c25 ON blogsstatsuser USING btree (groupid, userid);


--
-- TOC entry 3016 (class 1259 OID 29674)
-- Dependencies: 2017
-- Name: ix_82e39a0c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_82e39a0c ON socialactivity USING btree (classnameid);


--
-- TOC entry 2817 (class 1259 OID 29571)
-- Dependencies: 1974
-- Name: ix_834bceb6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_834bceb6 ON organization_ USING btree (companyid);


--
-- TOC entry 2964 (class 1259 OID 29650)
-- Dependencies: 2006
-- Name: ix_8377a211; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8377a211 ON scproductversion USING btree (productentryid);


--
-- TOC entry 2653 (class 1259 OID 29448)
-- Dependencies: 1950
-- Name: ix_84471fd2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_84471fd2 ON groups_roles USING btree (groupid);


--
-- TOC entry 2800 (class 1259 OID 29559)
-- Dependencies: 1971
-- Name: ix_847f92b5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_847f92b5 ON mbstatsuser USING btree (userid);


--
-- TOC entry 2401 (class 1259 OID 31875)
-- Dependencies: 1893
-- Name: ix_853caa65; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_853caa65 ON ebsc_orgobjectives_measures USING btree (obj_id);


--
-- TOC entry 2686 (class 1259 OID 29473)
-- Dependencies: 1955 1955 1955
-- Name: ix_85c52eec; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_85c52eec ON journalarticle USING btree (groupid, articleid, version);


--
-- TOC entry 3107 (class 1259 OID 29732)
-- Dependencies: 2031 2031
-- Name: ix_871412df; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_871412df ON usergrouprole USING btree (groupid, roleid);


--
-- TOC entry 2721 (class 1259 OID 29500)
-- Dependencies: 1960
-- Name: ix_8831e4fc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8831e4fc ON journalstructure USING btree (structureid);


--
-- TOC entry 3108 (class 1259 OID 29733)
-- Dependencies: 2031
-- Name: ix_887a2c95; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_887a2c95 ON usergrouprole USING btree (roleid);


--
-- TOC entry 3109 (class 1259 OID 29734)
-- Dependencies: 2031
-- Name: ix_887be56a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_887be56a ON usergrouprole USING btree (userid);


--
-- TOC entry 2701 (class 1259 OID 29486)
-- Dependencies: 1957 1957
-- Name: ix_88df994a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_88df994a ON journalarticleresource USING btree (groupid, articleid);


--
-- TOC entry 3168 (class 1259 OID 29785)
-- Dependencies: 2044 2044
-- Name: ix_899d3dfb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_899d3dfb ON wikipage USING btree (uuid_, groupid);


--
-- TOC entry 2812 (class 1259 OID 29563)
-- Dependencies: 1973
-- Name: ix_8a1cc4b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8a1cc4b ON membershiprequest USING btree (groupid);


--
-- TOC entry 2758 (class 1259 OID 29525)
-- Dependencies: 1965 1965
-- Name: ix_8abc4e3b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_8abc4e3b ON mbban USING btree (groupid, banuserid);


--
-- TOC entry 3125 (class 1259 OID 29757)
-- Dependencies: 2035
-- Name: ix_8ae58a91; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8ae58a91 ON users_permissions USING btree (permissionid);


--
-- TOC entry 2784 (class 1259 OID 29548)
-- Dependencies: 1969 1969
-- Name: ix_8d12316e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_8d12316e ON mbmessage USING btree (uuid_, groupid);


--
-- TOC entry 2920 (class 1259 OID 29622)
-- Dependencies: 1997 1997 1997 1997 1997
-- Name: ix_8d83d0ce; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_8d83d0ce ON resourcepermission USING btree (companyid, name, scope, primkey, roleid);


--
-- TOC entry 2687 (class 1259 OID 29472)
-- Dependencies: 1955 1955 1955
-- Name: ix_8dbf1387; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8dbf1387 ON journalarticle USING btree (groupid, articleid, approved);


--
-- TOC entry 2688 (class 1259 OID 29475)
-- Dependencies: 1955 1955
-- Name: ix_8deae14e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8deae14e ON journalarticle USING btree (groupid, templateid);


--
-- TOC entry 2879 (class 1259 OID 29603)
-- Dependencies: 1988 1988 1988 1988
-- Name: ix_8e71167f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8e71167f ON portletitem USING btree (groupid, portletid, classnameid, name);


--
-- TOC entry 2785 (class 1259 OID 29544)
-- Dependencies: 1969 1969
-- Name: ix_8eb8c5ec; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_8eb8c5ec ON mbmessage USING btree (groupid, userid);


--
-- TOC entry 3017 (class 1259 OID 29678)
-- Dependencies: 2017 2017 2017 2017 2017 2017 2017
-- Name: ix_8f32dec9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_8f32dec9 ON socialactivity USING btree (groupid, userid, createdate, classnameid, classpk, type_, receiveruserid);


--
-- TOC entry 2574 (class 1259 OID 29394)
-- Dependencies: 1937 1937
-- Name: ix_8f6c75d0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_8f6c75d0 ON dlfileentry USING btree (folderid, name);


--
-- TOC entry 2599 (class 1259 OID 29413)
-- Dependencies: 1941 1941 1941
-- Name: ix_902fd874; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_902fd874 ON dlfolder USING btree (groupid, parentfolderid, name);


--
-- TOC entry 2989 (class 1259 OID 29664)
-- Dependencies: 2012
-- Name: ix_903dc750; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_903dc750 ON shoppingitem USING btree (largeimageid);


--
-- TOC entry 2515 (class 1259 OID 29358)
-- Dependencies: 1925 1925
-- Name: ix_90cda39a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_90cda39a ON blogsstatsuser USING btree (companyid, entrycount);


--
-- TOC entry 2625 (class 1259 OID 29431)
-- Dependencies: 1946
-- Name: ix_9112a7a0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9112a7a0 ON expandovalue USING btree (rowid_);


--
-- TOC entry 2801 (class 1259 OID 29558)
-- Dependencies: 1971 1971
-- Name: ix_9168e2c9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_9168e2c9 ON mbstatsuser USING btree (groupid, userid);


--
-- TOC entry 2374 (class 1259 OID 29803)
-- Dependencies: 1885
-- Name: ix_91fdd093; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_91fdd093 ON ebsc_orgobjectives_approval USING btree (approved_by);


--
-- TOC entry 3160 (class 1259 OID 29771)
-- Dependencies: 2043 2043
-- Name: ix_920cd8b1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_920cd8b1 ON wikinode USING btree (groupid, name);


--
-- TOC entry 2481 (class 1259 OID 29339)
-- Dependencies: 1920 1920 1920 1920
-- Name: ix_9226dbb4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9226dbb4 ON address USING btree (companyid, classnameid, classpk, primary_);


--
-- TOC entry 2482 (class 1259 OID 29338)
-- Dependencies: 1920 1920 1920 1920
-- Name: ix_923bd178; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_923bd178 ON address USING btree (companyid, classnameid, classpk, mailing);


--
-- TOC entry 2689 (class 1259 OID 29470)
-- Dependencies: 1955
-- Name: ix_9356f865; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9356f865 ON journalarticle USING btree (groupid);


--
-- TOC entry 2483 (class 1259 OID 29335)
-- Dependencies: 1920
-- Name: ix_93d5ad4e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_93d5ad4e ON address USING btree (companyid);


--
-- TOC entry 2971 (class 1259 OID 29654)
-- Dependencies: 2008
-- Name: ix_941ba8c3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_941ba8c3 ON shard USING btree (name);


--
-- TOC entry 3027 (class 1259 OID 29684)
-- Dependencies: 2018 2018
-- Name: ix_95135d1c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_95135d1c ON socialrelation USING btree (companyid, type_);


--
-- TOC entry 2807 (class 1259 OID 29562)
-- Dependencies: 1972
-- Name: ix_95c0ea45; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_95c0ea45 ON mbthread USING btree (groupid);


--
-- TOC entry 2529 (class 1259 OID 29370)
-- Dependencies: 1927 1927
-- Name: ix_967799c0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_967799c0 ON bookmarksfolder USING btree (groupid, parentfolderid);


--
-- TOC entry 2880 (class 1259 OID 29599)
-- Dependencies: 1988 1988
-- Name: ix_96bdd537; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_96bdd537 ON portletitem USING btree (groupid, classnameid);


--
-- TOC entry 3152 (class 1259 OID 29764)
-- Dependencies: 2042
-- Name: ix_96f07007; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_96f07007 ON website USING btree (companyid);


--
-- TOC entry 2551 (class 1259 OID 29385)
-- Dependencies: 1931
-- Name: ix_975996c0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_975996c0 ON company USING btree (virtualhost);


--
-- TOC entry 3093 (class 1259 OID 29747)
-- Dependencies: 2029 2029
-- Name: ix_9782ad88; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_9782ad88 ON user_ USING btree (companyid, userid);


--
-- TOC entry 3147 (class 1259 OID 29763)
-- Dependencies: 2041 2041
-- Name: ix_97dfa146; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_97dfa146 ON webdavprops USING btree (classnameid, classpk);


--
-- TOC entry 2415 (class 1259 OID 31876)
-- Dependencies: 1897
-- Name: ix_98a7feea; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_98a7feea ON ebsc_orgobjectives_objectives USING btree (obj_id);


--
-- TOC entry 2954 (class 1259 OID 29643)
-- Dependencies: 2004 2004
-- Name: ix_98e6a9cb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_98e6a9cb ON scproductentry USING btree (groupid, userid);


--
-- TOC entry 2447 (class 1259 OID 28512)
-- Dependencies: 1909
-- Name: ix_9955efb5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9955efb5 ON quartz_triggers USING btree (trigger_state);


--
-- TOC entry 3169 (class 1259 OID 29781)
-- Dependencies: 2044 2044
-- Name: ix_997eedd2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_997eedd2 ON wikipage USING btree (nodeid, title);


--
-- TOC entry 2848 (class 1259 OID 29583)
-- Dependencies: 1982 1982 1982
-- Name: ix_9a53569; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9a53569 ON phone USING btree (companyid, classnameid, classpk);


--
-- TOC entry 2663 (class 1259 OID 29455)
-- Dependencies: 1952 1952 1952
-- Name: ix_9bbafb1e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_9bbafb1e ON igfolder USING btree (groupid, parentfolderid, name);


--
-- TOC entry 3170 (class 1259 OID 29784)
-- Dependencies: 2044
-- Name: ix_9c0e478f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9c0e478f ON wikipage USING btree (uuid_);


--
-- TOC entry 2498 (class 1259 OID 29347)
-- Dependencies: 1923
-- Name: ix_9c7eb9f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9c7eb9f ON announcementsflag USING btree (entryid);


--
-- TOC entry 2593 (class 1259 OID 29408)
-- Dependencies: 1940 1940
-- Name: ix_9cd91db6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9cd91db6 ON dlfileversion USING btree (folderid, name);


--
-- TOC entry 2626 (class 1259 OID 29430)
-- Dependencies: 1946 1946
-- Name: ix_9ddd21e5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_9ddd21e5 ON expandovalue USING btree (columnid, rowid_);


--
-- TOC entry 3070 (class 1259 OID 29717)
-- Dependencies: 2026 2026
-- Name: ix_9f26308a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9f26308a ON tagsvocabulary USING btree (groupid, folksonomy);


--
-- TOC entry 2849 (class 1259 OID 29581)
-- Dependencies: 1982
-- Name: ix_9f704a14; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9f704a14 ON phone USING btree (companyid);


--
-- TOC entry 2864 (class 1259 OID 29591)
-- Dependencies: 1985
-- Name: ix_9ff342ea; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_9ff342ea ON pollsquestion USING btree (groupid);


--
-- TOC entry 2802 (class 1259 OID 29556)
-- Dependencies: 1971
-- Name: ix_a00a898f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a00a898f ON mbstatsuser USING btree (groupid);


--
-- TOC entry 3054 (class 1259 OID 29709)
-- Dependencies: 2022
-- Name: ix_a02a8023; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a02a8023 ON tagsassets_tagsentries USING btree (entryid);


--
-- TOC entry 2430 (class 1259 OID 29810)
-- Dependencies: 1901
-- Name: ix_a10e44ef; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a10e44ef ON ebsc_orgobjectives_perspectives USING btree (name);


--
-- TOC entry 3094 (class 1259 OID 29751)
-- Dependencies: 2029
-- Name: ix_a18034a4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a18034a4 ON user_ USING btree (portraitid);


--
-- TOC entry 3171 (class 1259 OID 29774)
-- Dependencies: 2044
-- Name: ix_a2001730; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a2001730 ON wikipage USING btree (format);


--
-- TOC entry 2850 (class 1259 OID 29582)
-- Dependencies: 1982 1982
-- Name: ix_a2e4afba; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a2e4afba ON phone USING btree (companyid, classnameid);


--
-- TOC entry 2914 (class 1259 OID 29618)
-- Dependencies: 1996 1996 1996
-- Name: ix_a32c097e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_a32c097e ON resourcecode USING btree (companyid, name, scope);


--
-- TOC entry 2921 (class 1259 OID 29623)
-- Dependencies: 1997
-- Name: ix_a37a0588; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a37a0588 ON resourcepermission USING btree (roleid);


--
-- TOC entry 2749 (class 1259 OID 29519)
-- Dependencies: 1963
-- Name: ix_a40b8bec; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a40b8bec ON layoutset USING btree (groupid);


--
-- TOC entry 2822 (class 1259 OID 29566)
-- Dependencies: 1975
-- Name: ix_a425f71a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a425f71a ON orggrouppermission USING btree (groupid);


--
-- TOC entry 2794 (class 1259 OID 29550)
-- Dependencies: 1970 1970
-- Name: ix_a6973a8e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a6973a8e ON mbmessageflag USING btree (messageid, flag);


--
-- TOC entry 2895 (class 1259 OID 29611)
-- Dependencies: 1991 1991
-- Name: ix_a6e99284; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_a6e99284 ON ratingsstats USING btree (classnameid, classpk);


--
-- TOC entry 2493 (class 1259 OID 29343)
-- Dependencies: 1922 1922
-- Name: ix_a6ef0b81; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a6ef0b81 ON announcementsentry USING btree (classnameid, classpk);


--
-- TOC entry 2786 (class 1259 OID 29546)
-- Dependencies: 1969 1969
-- Name: ix_a7038cd7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a7038cd7 ON mbmessage USING btree (threadid, parentmessageid);


--
-- TOC entry 2600 (class 1259 OID 29410)
-- Dependencies: 1941
-- Name: ix_a74db14c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a74db14c ON dlfolder USING btree (companyid);


--
-- TOC entry 3018 (class 1259 OID 29675)
-- Dependencies: 2017 2017
-- Name: ix_a853c757; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a853c757 ON socialactivity USING btree (classnameid, classpk);


--
-- TOC entry 2925 (class 1259 OID 29627)
-- Dependencies: 1998 1998 1998
-- Name: ix_a88e424e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_a88e424e ON role_ USING btree (companyid, classnameid, classpk);


--
-- TOC entry 2612 (class 1259 OID 29422)
-- Dependencies: 1943
-- Name: ix_a8c0cbe8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a8c0cbe8 ON expandocolumn USING btree (tableid);


--
-- TOC entry 3037 (class 1259 OID 29693)
-- Dependencies: 2019
-- Name: ix_a90fe5a0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a90fe5a0 ON socialrequest USING btree (companyid);


--
-- TOC entry 2575 (class 1259 OID 29395)
-- Dependencies: 1937 1937
-- Name: ix_a9951f17; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a9951f17 ON dlfileentry USING btree (folderid, title);


--
-- TOC entry 3095 (class 1259 OID 29750)
-- Dependencies: 2029
-- Name: ix_a9ed7dd3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_a9ed7dd3 ON user_ USING btree (openid);


--
-- TOC entry 2915 (class 1259 OID 29619)
-- Dependencies: 1996
-- Name: ix_aacaff40; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_aacaff40 ON resourcecode USING btree (name);


--
-- TOC entry 2826 (class 1259 OID 29569)
-- Dependencies: 1976
-- Name: ix_ab044d1c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ab044d1c ON orggrouprole USING btree (roleid);


--
-- TOC entry 3051 (class 1259 OID 29707)
-- Dependencies: 2021
-- Name: ix_ab3d8bcb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ab3d8bcb ON tagsasset USING btree (companyid);


--
-- TOC entry 3038 (class 1259 OID 29699)
-- Dependencies: 2019 2019
-- Name: ix_ab5906a8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ab5906a8 ON socialrequest USING btree (userid, status);


--
-- TOC entry 2722 (class 1259 OID 29499)
-- Dependencies: 1960 1960
-- Name: ix_ab6e9996; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ab6e9996 ON journalstructure USING btree (groupid, structureid);


--
-- TOC entry 2484 (class 1259 OID 29336)
-- Dependencies: 1920 1920
-- Name: ix_abd7dac0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_abd7dac0 ON address USING btree (companyid, classnameid);


--
-- TOC entry 2774 (class 1259 OID 29536)
-- Dependencies: 1968
-- Name: ix_ada16fe7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ada16fe7 ON mbmailinglist USING btree (categoryid);


--
-- TOC entry 2467 (class 1259 OID 28516)
-- Dependencies: 1916
-- Name: ix_adee6a17; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_adee6a17 ON quartz_fired_triggers USING btree (job_name);


--
-- TOC entry 2959 (class 1259 OID 29645)
-- Dependencies: 2005
-- Name: ix_ae8224cc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ae8224cc ON scproductscreenshot USING btree (fullimageid);


--
-- TOC entry 2664 (class 1259 OID 29457)
-- Dependencies: 1952 1952
-- Name: ix_b10efd68; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_b10efd68 ON igfolder USING btree (uuid_, groupid);


--
-- TOC entry 2787 (class 1259 OID 29542)
-- Dependencies: 1969
-- Name: ix_b1432d30; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b1432d30 ON mbmessage USING btree (companyid);


--
-- TOC entry 3055 (class 1259 OID 29708)
-- Dependencies: 2022
-- Name: ix_b22f3a1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b22f3a1 ON tagsassets_tagsentries USING btree (assetid);


--
-- TOC entry 2545 (class 1259 OID 29381)
-- Dependencies: 1930
-- Name: ix_b27a301f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_b27a301f ON classname_ USING btree (value);


--
-- TOC entry 2627 (class 1259 OID 29428)
-- Dependencies: 1946 1946
-- Name: ix_b29fef17; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b29fef17 ON expandovalue USING btree (classnameid, classpk);


--
-- TOC entry 2709 (class 1259 OID 29490)
-- Dependencies: 1958 1958 1958
-- Name: ix_b3b318dc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b3b318dc ON journalcontentsearch USING btree (groupid, privatelayout, layoutid);


--
-- TOC entry 2892 (class 1259 OID 29610)
-- Dependencies: 1990 1990 1990
-- Name: ix_b47e3c11; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_b47e3c11 ON ratingsentry USING btree (userid, classnameid, classpk);


--
-- TOC entry 3161 (class 1259 OID 29770)
-- Dependencies: 2043
-- Name: ix_b480a672; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b480a672 ON wikinode USING btree (groupid);


--
-- TOC entry 2621 (class 1259 OID 29426)
-- Dependencies: 1945 1945
-- Name: ix_b5ae8a85; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b5ae8a85 ON expandotable USING btree (companyid, classnameid);


--
-- TOC entry 2770 (class 1259 OID 29534)
-- Dependencies: 1967
-- Name: ix_b5ca2dc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_b5ca2dc ON mbdiscussion USING btree (threadid);


--
-- TOC entry 3007 (class 1259 OID 29673)
-- Dependencies: 2016
-- Name: ix_b5f82c7a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b5f82c7a ON shoppingorderitem USING btree (orderid);


--
-- TOC entry 2520 (class 1259 OID 29366)
-- Dependencies: 1926
-- Name: ix_b670ba39; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b670ba39 ON bookmarksentry USING btree (uuid_);


--
-- TOC entry 2628 (class 1259 OID 29436)
-- Dependencies: 1946 1946
-- Name: ix_b71e92d5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b71e92d5 ON expandovalue USING btree (tableid, rowid_);


--
-- TOC entry 2505 (class 1259 OID 29355)
-- Dependencies: 1924 1924 1924 1924
-- Name: ix_b88e740e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b88e740e ON blogsentry USING btree (groupid, userid, displaydate, draft);


--
-- TOC entry 2436 (class 1259 OID 29811)
-- Dependencies: 1903
-- Name: ix_b8fe9af4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b8fe9af4 ON ebsc_orgobjectives_targets USING btree (name);


--
-- TOC entry 2855 (class 1259 OID 29586)
-- Dependencies: 1983
-- Name: ix_b9746445; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b9746445 ON pluginsetting USING btree (companyid);


--
-- TOC entry 2723 (class 1259 OID 29497)
-- Dependencies: 1960
-- Name: ix_b97f5608; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_b97f5608 ON journalstructure USING btree (groupid);


--
-- TOC entry 2488 (class 1259 OID 29342)
-- Dependencies: 1921 1921
-- Name: ix_ba4413d5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ba4413d5 ON announcementsdelivery USING btree (userid, type_);


--
-- TOC entry 2468 (class 1259 OID 28515)
-- Dependencies: 1916
-- Name: ix_bab9a1f7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bab9a1f7 ON quartz_fired_triggers USING btree (job_group);


--
-- TOC entry 2581 (class 1259 OID 29402)
-- Dependencies: 1938 1938
-- Name: ix_bafb116e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bafb116e ON dlfilerank USING btree (groupid, userid);


--
-- TOC entry 2516 (class 1259 OID 29362)
-- Dependencies: 1925
-- Name: ix_bb51f1d9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bb51f1d9 ON blogsstatsuser USING btree (userid);


--
-- TOC entry 2761 (class 1259 OID 29528)
-- Dependencies: 1966
-- Name: ix_bb870c11; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bb870c11 ON mbcategory USING btree (groupid);


--
-- TOC entry 2640 (class 1259 OID 29440)
-- Dependencies: 1947 1947 1947
-- Name: ix_bbca55b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_bbca55b ON group_ USING btree (companyid, livegroupid, name);


--
-- TOC entry 2741 (class 1259 OID 29514)
-- Dependencies: 1962 1962 1962
-- Name: ix_bc2c4231; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_bc2c4231 ON layout USING btree (groupid, privatelayout, friendlyurl);


--
-- TOC entry 2576 (class 1259 OID 29399)
-- Dependencies: 1937 1937
-- Name: ix_bc2e7e6a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_bc2e7e6a ON dlfileentry USING btree (uuid_, groupid);


--
-- TOC entry 2762 (class 1259 OID 29527)
-- Dependencies: 1966
-- Name: ix_bc735dcf; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bc735dcf ON mbcategory USING btree (companyid);


--
-- TOC entry 2672 (class 1259 OID 29461)
-- Dependencies: 1953 1953
-- Name: ix_bcb13a3f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bcb13a3f ON igimage USING btree (folderid, name);


--
-- TOC entry 2673 (class 1259 OID 29463)
-- Dependencies: 1953 1953
-- Name: ix_be79e1e1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_be79e1e1 ON igimage USING btree (groupid, userid);


--
-- TOC entry 3134 (class 1259 OID 29762)
-- Dependencies: 2037
-- Name: ix_be8102d6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_be8102d6 ON users_usergroups USING btree (userid);


--
-- TOC entry 2775 (class 1259 OID 29535)
-- Dependencies: 1968
-- Name: ix_bfeb984f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_bfeb984f ON mbmailinglist USING btree (active_);


--
-- TOC entry 2506 (class 1259 OID 29354)
-- Dependencies: 1924 1924
-- Name: ix_c07ca83d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c07ca83d ON blogsentry USING btree (groupid, userid);


--
-- TOC entry 2742 (class 1259 OID 29512)
-- Dependencies: 1962
-- Name: ix_c099d61a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c099d61a ON layout USING btree (groupid);


--
-- TOC entry 3063 (class 1259 OID 29712)
-- Dependencies: 2024
-- Name: ix_c134234; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c134234 ON tagsproperty USING btree (companyid);


--
-- TOC entry 3129 (class 1259 OID 29759)
-- Dependencies: 2036
-- Name: ix_c19e5f31; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c19e5f31 ON users_roles USING btree (roleid);


--
-- TOC entry 3130 (class 1259 OID 29760)
-- Dependencies: 2036
-- Name: ix_c1a01806; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c1a01806 ON users_roles USING btree (userid);


--
-- TOC entry 2539 (class 1259 OID 29379)
-- Dependencies: 1929
-- Name: ix_c1ad2122; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c1ad2122 ON calevent USING btree (uuid_);


--
-- TOC entry 2795 (class 1259 OID 29551)
-- Dependencies: 1970
-- Name: ix_c1c9a8fd; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c1c9a8fd ON mbmessageflag USING btree (threadid);


--
-- TOC entry 2763 (class 1259 OID 29530)
-- Dependencies: 1966
-- Name: ix_c2626edb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c2626edb ON mbcategory USING btree (uuid_);


--
-- TOC entry 3126 (class 1259 OID 29758)
-- Dependencies: 2035
-- Name: ix_c26aa64d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c26aa64d ON users_permissions USING btree (userid);


--
-- TOC entry 2976 (class 1259 OID 29655)
-- Dependencies: 2009
-- Name: ix_c28b41dc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c28b41dc ON shoppingcart USING btree (groupid);


--
-- TOC entry 2813 (class 1259 OID 29564)
-- Dependencies: 1973 1973
-- Name: ix_c28c72ec; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c28c72ec ON membershiprequest USING btree (groupid, statusid);


--
-- TOC entry 3028 (class 1259 OID 29685)
-- Dependencies: 2018
-- Name: ix_c31a64c6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c31a64c6 ON socialrelation USING btree (type_);


--
-- TOC entry 2836 (class 1259 OID 29576)
-- Dependencies: 1979 1979
-- Name: ix_c3a17327; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c3a17327 ON passwordpolicyrel USING btree (classnameid, classpk);


--
-- TOC entry 2710 (class 1259 OID 29492)
-- Dependencies: 1958 1958 1958 1958 1958
-- Name: ix_c3aa93b8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_c3aa93b8 ON journalcontentsearch USING btree (groupid, privatelayout, layoutid, portletid, articleid);


--
-- TOC entry 2648 (class 1259 OID 29446)
-- Dependencies: 1949
-- Name: ix_c48736b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c48736b ON groups_permissions USING btree (groupid);


--
-- TOC entry 3117 (class 1259 OID 29753)
-- Dependencies: 2033
-- Name: ix_c4f9e699; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c4f9e699 ON users_groups USING btree (groupid);


--
-- TOC entry 2788 (class 1259 OID 29547)
-- Dependencies: 1969
-- Name: ix_c57b16bc; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c57b16bc ON mbmessage USING btree (uuid_);


--
-- TOC entry 3096 (class 1259 OID 29746)
-- Dependencies: 2029 2029
-- Name: ix_c5806019; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_c5806019 ON user_ USING btree (companyid, screenname);


--
-- TOC entry 2885 (class 1259 OID 29606)
-- Dependencies: 1989 1989 1989 1989
-- Name: ix_c7057ff7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_c7057ff7 ON portletpreferences USING btree (ownerid, ownertype, plid, portletid);


--
-- TOC entry 2743 (class 1259 OID 29510)
-- Dependencies: 1962
-- Name: ix_c7fbc998; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c7fbc998 ON layout USING btree (companyid);


--
-- TOC entry 3172 (class 1259 OID 29776)
-- Dependencies: 2044
-- Name: ix_c8a9c476; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c8a9c476 ON wikipage USING btree (nodeid);


--
-- TOC entry 2990 (class 1259 OID 29662)
-- Dependencies: 2012
-- Name: ix_c8eacf2e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c8eacf2e ON shoppingitem USING btree (categoryid);


--
-- TOC entry 2940 (class 1259 OID 29634)
-- Dependencies: 2001
-- Name: ix_c98c0d78; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_c98c0d78 ON scframeworkversion USING btree (companyid);


--
-- TOC entry 2724 (class 1259 OID 29498)
-- Dependencies: 1960 1960
-- Name: ix_ca0bd48c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ca0bd48c ON journalstructure USING btree (groupid, parentstructureid);


--
-- TOC entry 2387 (class 1259 OID 31874)
-- Dependencies: 1889
-- Name: ix_ca10002a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ca10002a ON ebsc_orgobjectives_list USING btree (objtype);


--
-- TOC entry 2587 (class 1259 OID 29405)
-- Dependencies: 1939 1939
-- Name: ix_ca2708a2; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ca2708a2 ON dlfileshortcut USING btree (tofolderid, toname);


--
-- TOC entry 2629 (class 1259 OID 29434)
-- Dependencies: 1946 1946
-- Name: ix_ca9afb7c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ca9afb7c ON expandovalue USING btree (tableid, columnid);


--
-- TOC entry 3183 (class 1259 OID 31880)
-- Dependencies: 2047
-- Name: ix_cab300a5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_cab300a5 ON organizations USING btree (name);


--
-- TOC entry 2437 (class 1259 OID 31879)
-- Dependencies: 1903
-- Name: ix_caca707a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_caca707a ON ebsc_orgobjectives_targets USING btree (mea_id);


--
-- TOC entry 2808 (class 1259 OID 29560)
-- Dependencies: 1972
-- Name: ix_cb854772; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_cb854772 ON mbthread USING btree (categoryid);


--
-- TOC entry 2601 (class 1259 OID 29415)
-- Dependencies: 1941
-- Name: ix_cbc408d8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_cbc408d8 ON dlfolder USING btree (uuid_);


--
-- TOC entry 2926 (class 1259 OID 29629)
-- Dependencies: 1998 1998
-- Name: ix_cbe204; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_cbe204 ON role_ USING btree (type_, subtype);


--
-- TOC entry 3039 (class 1259 OID 29698)
-- Dependencies: 2019 2019 2019 2019 2019
-- Name: ix_cc86a444; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_cc86a444 ON socialrequest USING btree (userid, classnameid, classpk, type_, status);


--
-- TOC entry 2582 (class 1259 OID 29400)
-- Dependencies: 1938 1938 1938 1938
-- Name: ix_ce705d48; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ce705d48 ON dlfilerank USING btree (companyid, userid, folderid, name);


--
-- TOC entry 2641 (class 1259 OID 29437)
-- Dependencies: 1947 1947 1947
-- Name: ix_d0d5e397; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_d0d5e397 ON group_ USING btree (companyid, classnameid, classpk);


--
-- TOC entry 2796 (class 1259 OID 29549)
-- Dependencies: 1970
-- Name: ix_d180d4ae; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d180d4ae ON mbmessageflag USING btree (messageid);


--
-- TOC entry 3113 (class 1259 OID 29738)
-- Dependencies: 2032 2032
-- Name: ix_d1c44a6e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_d1c44a6e ON useridmapper USING btree (userid, type_);


--
-- TOC entry 2991 (class 1259 OID 29665)
-- Dependencies: 2012
-- Name: ix_d217ab30; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d217ab30 ON shoppingitem USING btree (mediumimageid);


--
-- TOC entry 2630 (class 1259 OID 29435)
-- Dependencies: 1946 1946 1946
-- Name: ix_d27b03e7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_d27b03e7 ON expandovalue USING btree (tableid, columnid, classpk);


--
-- TOC entry 2886 (class 1259 OID 29608)
-- Dependencies: 1989 1989
-- Name: ix_d340db76; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d340db76 ON portletpreferences USING btree (plid, portletid);


--
-- TOC entry 3040 (class 1259 OID 29692)
-- Dependencies: 2019 2019 2019 2019 2019
-- Name: ix_d3425487; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d3425487 ON socialrequest USING btree (classnameid, classpk, type_, receiveruserid, status);


--
-- TOC entry 2674 (class 1259 OID 29465)
-- Dependencies: 1953
-- Name: ix_d3d32126; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d3d32126 ON igimage USING btree (smallimageid);


--
-- TOC entry 2617 (class 1259 OID 29424)
-- Dependencies: 1944
-- Name: ix_d3f5d7ae; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d3f5d7ae ON expandorow USING btree (tableid);


--
-- TOC entry 2698 (class 1259 OID 29484)
-- Dependencies: 1956
-- Name: ix_d4121315; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d4121315 ON journalarticleimage USING btree (tempimage);


--
-- TOC entry 2494 (class 1259 OID 29345)
-- Dependencies: 1922
-- Name: ix_d49c2e66; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d49c2e66 ON announcementsentry USING btree (userid);


--
-- TOC entry 3180 (class 1259 OID 31881)
-- Dependencies: 2046
-- Name: ix_d53f77be; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d53f77be ON users USING btree (email);


--
-- TOC entry 2870 (class 1259 OID 29594)
-- Dependencies: 1986
-- Name: ix_d5df7b54; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d5df7b54 ON pollsvote USING btree (choiceid);


--
-- TOC entry 2881 (class 1259 OID 29600)
-- Dependencies: 1988 1988 1988 1988
-- Name: ix_d699243f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d699243f ON portletitem USING btree (groupid, name, portletid, classnameid);


--
-- TOC entry 2540 (class 1259 OID 29374)
-- Dependencies: 1929
-- Name: ix_d6fd9496; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d6fd9496 ON calevent USING btree (companyid);


--
-- TOC entry 2859 (class 1259 OID 29589)
-- Dependencies: 1984 1984
-- Name: ix_d76dd2cf; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_d76dd2cf ON pollschoice USING btree (questionid, name);


--
-- TOC entry 2948 (class 1259 OID 29640)
-- Dependencies: 2003
-- Name: ix_d7710a66; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d7710a66 ON sclicenses_scproductentries USING btree (productentryid);


--
-- TOC entry 3003 (class 1259 OID 29671)
-- Dependencies: 2015
-- Name: ix_d7d6e87a; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_d7d6e87a ON shoppingorder USING btree (number_);


--
-- TOC entry 3041 (class 1259 OID 29695)
-- Dependencies: 2019 2019
-- Name: ix_d9380cb7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d9380cb7 ON socialrequest USING btree (receiveruserid, status);


--
-- TOC entry 2675 (class 1259 OID 29459)
-- Dependencies: 1953
-- Name: ix_d9e0a34c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_d9e0a34c ON igimage USING btree (custom2imageid);


--
-- TOC entry 2507 (class 1259 OID 29352)
-- Dependencies: 1924 1924 1924
-- Name: ix_da53afd4; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_da53afd4 ON blogsentry USING btree (groupid, displaydate, draft);


--
-- TOC entry 2972 (class 1259 OID 29653)
-- Dependencies: 2008 2008
-- Name: ix_da5f4359; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_da5f4359 ON shard USING btree (classnameid, classpk);


--
-- TOC entry 2960 (class 1259 OID 29647)
-- Dependencies: 2005 2005
-- Name: ix_da913a55; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_da913a55 ON scproductscreenshot USING btree (productentryid, priority);


--
-- TOC entry 2508 (class 1259 OID 29353)
-- Dependencies: 1924 1924
-- Name: ix_db780a20; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_db780a20 ON blogsentry USING btree (groupid, urltitle);


--
-- TOC entry 2530 (class 1259 OID 29372)
-- Dependencies: 1927 1927
-- Name: ix_dc2f8927; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_dc2f8927 ON bookmarksfolder USING btree (uuid_, groupid);


--
-- TOC entry 2985 (class 1259 OID 29660)
-- Dependencies: 2011
-- Name: ix_dc60cfae; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_dc60cfae ON shoppingcoupon USING btree (code_);


--
-- TOC entry 2690 (class 1259 OID 29469)
-- Dependencies: 1955
-- Name: ix_dff98523; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_dff98523 ON journalarticle USING btree (companyid);


--
-- TOC entry 3097 (class 1259 OID 29752)
-- Dependencies: 2029
-- Name: ix_e0422bda; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e0422bda ON user_ USING btree (uuid_);


--
-- TOC entry 2931 (class 1259 OID 29631)
-- Dependencies: 1999
-- Name: ix_e04e486d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e04e486d ON roles_permissions USING btree (roleid);


--
-- TOC entry 3071 (class 1259 OID 29716)
-- Dependencies: 2026 2026
-- Name: ix_e0d51848; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e0d51848 ON tagsvocabulary USING btree (companyid, folksonomy);


--
-- TOC entry 2509 (class 1259 OID 29350)
-- Dependencies: 1924 1924 1924
-- Name: ix_e0d90212; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e0d90212 ON blogsentry USING btree (companyid, displaydate, draft);


--
-- TOC entry 2521 (class 1259 OID 29365)
-- Dependencies: 1926 1926
-- Name: ix_e2e9f129; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e2e9f129 ON bookmarksentry USING btree (groupid, userid);


--
-- TOC entry 2818 (class 1259 OID 29572)
-- Dependencies: 1974 1974
-- Name: ix_e301bdf5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e301bdf5 ON organization_ USING btree (companyid, name);


--
-- TOC entry 3139 (class 1259 OID 29741)
-- Dependencies: 2038
-- Name: ix_e4efba8d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e4efba8d ON usertracker USING btree (userid);


--
-- TOC entry 2887 (class 1259 OID 29605)
-- Dependencies: 1989 1989 1989
-- Name: ix_e4f13e6e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e4f13e6e ON portletpreferences USING btree (ownerid, ownertype, plid);


--
-- TOC entry 2522 (class 1259 OID 29364)
-- Dependencies: 1926
-- Name: ix_e52ff7ef; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e52ff7ef ON bookmarksentry USING btree (groupid);


--
-- TOC entry 2588 (class 1259 OID 29404)
-- Dependencies: 1939
-- Name: ix_e56ec6ad; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e56ec6ad ON dlfileshortcut USING btree (folderid);


--
-- TOC entry 2676 (class 1259 OID 29458)
-- Dependencies: 1953
-- Name: ix_e597322d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e597322d ON igimage USING btree (custom1imageid);


--
-- TOC entry 3114 (class 1259 OID 29737)
-- Dependencies: 2032
-- Name: ix_e60ea987; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e60ea987 ON useridmapper USING btree (userid);


--
-- TOC entry 3173 (class 1259 OID 29782)
-- Dependencies: 2044 2044 2044
-- Name: ix_e745ea26; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e745ea26 ON wikipage USING btree (nodeid, title, head);


--
-- TOC entry 2533 (class 1259 OID 29373)
-- Dependencies: 1928
-- Name: ix_e7b95510; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e7b95510 ON browsertracker USING btree (userid);


--
-- TOC entry 3174 (class 1259 OID 29777)
-- Dependencies: 2044 2044
-- Name: ix_e7f635ca; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e7f635ca ON wikipage USING btree (nodeid, head);


--
-- TOC entry 2733 (class 1259 OID 29505)
-- Dependencies: 1961 1961
-- Name: ix_e802aa3c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e802aa3c ON journaltemplate USING btree (groupid, templateid);


--
-- TOC entry 2776 (class 1259 OID 29538)
-- Dependencies: 1968 1968
-- Name: ix_e858f170; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e858f170 ON mbmailinglist USING btree (uuid_, groupid);


--
-- TOC entry 2935 (class 1259 OID 29633)
-- Dependencies: 2000
-- Name: ix_e8d33ff9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e8d33ff9 ON scframeworkversi_scproductvers USING btree (productversionid);


--
-- TOC entry 3047 (class 1259 OID 29705)
-- Dependencies: 2020 2020
-- Name: ix_e8f34171; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e8f34171 ON subscription USING btree (userid, classnameid);


--
-- TOC entry 2882 (class 1259 OID 29602)
-- Dependencies: 1988 1988 1988
-- Name: ix_e922d6c0; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_e922d6c0 ON portletitem USING btree (groupid, portletid, classnameid);


--
-- TOC entry 2677 (class 1259 OID 29467)
-- Dependencies: 1953 1953
-- Name: ix_e97342d9; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e97342d9 ON igimage USING btree (uuid_, groupid);


--
-- TOC entry 2797 (class 1259 OID 29554)
-- Dependencies: 1970 1970 1970
-- Name: ix_e9eb6194; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_e9eb6194 ON mbmessageflag USING btree (userid, messageid, flag);


--
-- TOC entry 2998 (class 1259 OID 29668)
-- Dependencies: 2014
-- Name: ix_ea6fd516; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ea6fd516 ON shoppingitemprice USING btree (itemid);


--
-- TOC entry 2523 (class 1259 OID 29367)
-- Dependencies: 1926 1926
-- Name: ix_eaa02a91; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_eaa02a91 ON bookmarksentry USING btree (uuid_, groupid);


--
-- TOC entry 3064 (class 1259 OID 29713)
-- Dependencies: 2024 2024
-- Name: ix_eb974d08; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_eb974d08 ON tagsproperty USING btree (companyid, key_);


--
-- TOC entry 2927 (class 1259 OID 29628)
-- Dependencies: 1998 1998
-- Name: ix_ebc931b8; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ebc931b8 ON role_ USING btree (companyid, name);


--
-- TOC entry 2552 (class 1259 OID 29386)
-- Dependencies: 1931
-- Name: ix_ec00543c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_ec00543c ON company USING btree (webid);


--
-- TOC entry 2860 (class 1259 OID 29588)
-- Dependencies: 1984
-- Name: ix_ec370f10; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ec370f10 ON pollschoice USING btree (questionid);


--
-- TOC entry 2649 (class 1259 OID 29447)
-- Dependencies: 1949
-- Name: ix_ec97689d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ec97689d ON groups_permissions USING btree (permissionid);


--
-- TOC entry 2764 (class 1259 OID 29529)
-- Dependencies: 1966 1966
-- Name: ix_ed292508; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ed292508 ON mbcategory USING btree (groupid, parentcategoryid);


--
-- TOC entry 2837 (class 1259 OID 29577)
-- Dependencies: 1979 1979 1979
-- Name: ix_ed7cf243; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ed7cf243 ON passwordpolicyrel USING btree (passwordpolicyid, classnameid, classpk);


--
-- TOC entry 2910 (class 1259 OID 29616)
-- Dependencies: 1995 1995
-- Name: ix_edb9986e; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_edb9986e ON resourceaction USING btree (name, actionid);


--
-- TOC entry 3059 (class 1259 OID 29710)
-- Dependencies: 2023 2023
-- Name: ix_ee55ed49; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ee55ed49 ON tagsentry USING btree (parententryid, vocabularyid);


--
-- TOC entry 2583 (class 1259 OID 29403)
-- Dependencies: 1938
-- Name: ix_eed06670; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_eed06670 ON dlfilerank USING btree (userid);


--
-- TOC entry 2691 (class 1259 OID 29478)
-- Dependencies: 1955
-- Name: ix_ef9b7028; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ef9b7028 ON journalarticle USING btree (smallimageid);


--
-- TOC entry 2692 (class 1259 OID 29479)
-- Dependencies: 1955
-- Name: ix_f029602f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f029602f ON journalarticle USING btree (uuid_);


--
-- TOC entry 2631 (class 1259 OID 29432)
-- Dependencies: 1946
-- Name: ix_f0566a77; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f0566a77 ON expandovalue USING btree (tableid);


--
-- TOC entry 2844 (class 1259 OID 29580)
-- Dependencies: 1981
-- Name: ix_f090c113; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f090c113 ON permission_ USING btree (resourceid);


--
-- TOC entry 3029 (class 1259 OID 29691)
-- Dependencies: 2018
-- Name: ix_f0ca24a5; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f0ca24a5 ON socialrelation USING btree (uuid_);


--
-- TOC entry 3118 (class 1259 OID 29754)
-- Dependencies: 2033
-- Name: ix_f10b6c6b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f10b6c6b ON users_groups USING btree (userid);


--
-- TOC entry 2888 (class 1259 OID 29607)
-- Dependencies: 1989
-- Name: ix_f15c1c4f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f15c1c4f ON portletpreferences USING btree (plid);


--
-- TOC entry 2851 (class 1259 OID 29585)
-- Dependencies: 1982
-- Name: ix_f202b9ce; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f202b9ce ON phone USING btree (userid);


--
-- TOC entry 2602 (class 1259 OID 29411)
-- Dependencies: 1941
-- Name: ix_f2ea1ace; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f2ea1ace ON dlfolder USING btree (groupid);


--
-- TOC entry 2865 (class 1259 OID 29593)
-- Dependencies: 1985 1985
-- Name: ix_f3c9f36; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_f3c9f36 ON pollsquestion USING btree (uuid_, groupid);


--
-- TOC entry 3004 (class 1259 OID 29672)
-- Dependencies: 2015
-- Name: ix_f474fd89; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f474fd89 ON shoppingorder USING btree (pptxnid);


--
-- TOC entry 2577 (class 1259 OID 29396)
-- Dependencies: 1937
-- Name: ix_f4af5636; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f4af5636 ON dlfileentry USING btree (groupid);


--
-- TOC entry 3065 (class 1259 OID 29715)
-- Dependencies: 2024 2024
-- Name: ix_f505253d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_f505253d ON tagsproperty USING btree (entryid, key_);


--
-- TOC entry 2541 (class 1259 OID 29378)
-- Dependencies: 1929
-- Name: ix_f6006202; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f6006202 ON calevent USING btree (remindby);


--
-- TOC entry 2665 (class 1259 OID 29456)
-- Dependencies: 1952
-- Name: ix_f73c0982; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f73c0982 ON igfolder USING btree (uuid_);


--
-- TOC entry 3153 (class 1259 OID 29768)
-- Dependencies: 2042
-- Name: ix_f75690bb; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f75690bb ON website USING btree (userid);


--
-- TOC entry 2448 (class 1259 OID 28511)
-- Dependencies: 1909
-- Name: ix_f7655cc3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f7655cc3 ON quartz_triggers USING btree (next_fire_time);


--
-- TOC entry 2765 (class 1259 OID 29531)
-- Dependencies: 1966 1966
-- Name: ix_f7d28c2f; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_f7d28c2f ON mbcategory USING btree (uuid_, groupid);


--
-- TOC entry 2632 (class 1259 OID 29429)
-- Dependencies: 1946
-- Name: ix_f7dd0987; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f7dd0987 ON expandovalue USING btree (columnid);


--
-- TOC entry 2702 (class 1259 OID 29485)
-- Dependencies: 1957
-- Name: ix_f8433677; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f8433677 ON journalarticleresource USING btree (groupid);


--
-- TOC entry 3154 (class 1259 OID 29766)
-- Dependencies: 2042 2042 2042
-- Name: ix_f960131c; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_f960131c ON website USING btree (companyid, classnameid, classpk);


--
-- TOC entry 3072 (class 1259 OID 29718)
-- Dependencies: 2026 2026
-- Name: ix_f9e51044; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_f9e51044 ON tagsvocabulary USING btree (groupid, name);


--
-- TOC entry 2803 (class 1259 OID 29557)
-- Dependencies: 1971 1971
-- Name: ix_fab5a88b; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_fab5a88b ON mbstatsuser USING btree (groupid, messagecount);


--
-- TOC entry 2744 (class 1259 OID 29511)
-- Dependencies: 1962
-- Name: ix_fad05595; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_fad05595 ON layout USING btree (dlfolderid);


--
-- TOC entry 3122 (class 1259 OID 29756)
-- Dependencies: 2034
-- Name: ix_fb646ca6; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_fb646ca6 ON users_orgs USING btree (userid);


--
-- TOC entry 2977 (class 1259 OID 29656)
-- Dependencies: 2009 2009
-- Name: ix_fc46fe16; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_fc46fe16 ON shoppingcart USING btree (groupid, userid);


--
-- TOC entry 2542 (class 1259 OID 29377)
-- Dependencies: 1929 1929
-- Name: ix_fcd7c63d; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_fcd7c63d ON calevent USING btree (groupid, type_);


--
-- TOC entry 2589 (class 1259 OID 29407)
-- Dependencies: 1939 1939
-- Name: ix_fdb4a946; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_fdb4a946 ON dlfileshortcut USING btree (uuid_, groupid);


--
-- TOC entry 2613 (class 1259 OID 29423)
-- Dependencies: 1943 1943
-- Name: ix_fefc8da7; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX ix_fefc8da7 ON expandocolumn USING btree (tableid, name);


--
-- TOC entry 2992 (class 1259 OID 29666)
-- Dependencies: 2012
-- Name: ix_ff203304; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX ix_ff203304 ON shoppingitem USING btree (smallimageid);


--
-- TOC entry 3198 (class 2620 OID 31883)
-- Dependencies: 1889 23
-- Name: trg_ebsc_change_parent_set; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trg_ebsc_change_parent_set
    BEFORE INSERT ON ebsc_orgobjectives_list
    FOR EACH ROW
    EXECUTE PROCEDURE ebsc_change_parent_set();


--
-- TOC entry 3199 (class 2620 OID 28377)
-- Dependencies: 1893 21
-- Name: trg_ebsc_insert_measure_ahp; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trg_ebsc_insert_measure_ahp
    AFTER INSERT ON ebsc_orgobjectives_measures
    FOR EACH ROW
    EXECUTE PROCEDURE ebsc_insert_measure_ahp();


--
-- TOC entry 3200 (class 2620 OID 28378)
-- Dependencies: 1897 22
-- Name: trg_ebsc_insert_objective_ahp; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trg_ebsc_insert_objective_ahp
    AFTER INSERT ON ebsc_orgobjectives_objectives
    FOR EACH ROW
    EXECUTE PROCEDURE ebsc_insert_objective_ahp();


--
-- TOC entry 3201 (class 2620 OID 28379)
-- Dependencies: 1901 24
-- Name: trg_ebsc_insert_perspective_ahp; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trg_ebsc_insert_perspective_ahp
    AFTER INSERT ON ebsc_orgobjectives_perspectives
    FOR EACH ROW
    EXECUTE PROCEDURE ebsc_insert_perspective_ahp();


--
-- TOC entry 3186 (class 2606 OID 28380)
-- Dependencies: 2379 1885 1889
-- Name: ebsc_orgobjectives_approval_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_approval
    ADD CONSTRAINT ebsc_orgobjectives_approval_fk FOREIGN KEY (obj_id) REFERENCES ebsc_orgobjectives_list(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3187 (class 2606 OID 31732)
-- Dependencies: 1889 2379 1889
-- Name: ebsc_orgobjectives_list_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_list
    ADD CONSTRAINT ebsc_orgobjectives_list_fk2 FOREIGN KEY (parentid) REFERENCES ebsc_orgobjectives_list(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3188 (class 2606 OID 28385)
-- Dependencies: 1893 1891 2396
-- Name: ebsc_orgobjectives_measure_ahp_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_measure_ahp
    ADD CONSTRAINT ebsc_orgobjectives_measure_ahp_fk1 FOREIGN KEY (vindex) REFERENCES ebsc_orgobjectives_measures(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3189 (class 2606 OID 28390)
-- Dependencies: 2396 1891 1893
-- Name: ebsc_orgobjectives_measure_ahp_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_measure_ahp
    ADD CONSTRAINT ebsc_orgobjectives_measure_ahp_fk2 FOREIGN KEY (hindex) REFERENCES ebsc_orgobjectives_measures(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3190 (class 2606 OID 28395)
-- Dependencies: 2410 1897 1893
-- Name: ebsc_orgobjectives_measures_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_measures
    ADD CONSTRAINT ebsc_orgobjectives_measures_fk FOREIGN KEY (obj_id) REFERENCES ebsc_orgobjectives_objectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3191 (class 2606 OID 28400)
-- Dependencies: 2410 1895 1897
-- Name: ebsc_orgobjectives_objective_ahp_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_objective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_objective_ahp_fk1 FOREIGN KEY (vindex) REFERENCES ebsc_orgobjectives_objectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3192 (class 2606 OID 28405)
-- Dependencies: 2410 1897 1895
-- Name: ebsc_orgobjectives_objective_ahp_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_objective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_objective_ahp_fk2 FOREIGN KEY (hindex) REFERENCES ebsc_orgobjectives_objectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3193 (class 2606 OID 28410)
-- Dependencies: 2424 1897 1901
-- Name: ebsc_orgobjectives_objectives_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_objectives
    ADD CONSTRAINT ebsc_orgobjectives_objectives_fk FOREIGN KEY (obj_id) REFERENCES ebsc_orgobjectives_perspectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3194 (class 2606 OID 28415)
-- Dependencies: 1901 2424 1899
-- Name: ebsc_orgobjectives_perspective_ahp_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_perspective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_perspective_ahp_fk1 FOREIGN KEY (vindex) REFERENCES ebsc_orgobjectives_perspectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3195 (class 2606 OID 28420)
-- Dependencies: 2424 1901 1899
-- Name: ebsc_orgobjectives_perspective_ahp_fk2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_perspective_ahp
    ADD CONSTRAINT ebsc_orgobjectives_perspective_ahp_fk2 FOREIGN KEY (hindex) REFERENCES ebsc_orgobjectives_perspectives(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3196 (class 2606 OID 28425)
-- Dependencies: 1901 2379 1889
-- Name: ebsc_orgobjectives_perspectives_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_perspectives
    ADD CONSTRAINT ebsc_orgobjectives_perspectives_fk FOREIGN KEY (obj_id) REFERENCES ebsc_orgobjectives_list(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3197 (class 2606 OID 28430)
-- Dependencies: 1903 1893 2396
-- Name: ebsc_orgobjectives_targets_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ebsc_orgobjectives_targets
    ADD CONSTRAINT ebsc_orgobjectives_targets_fk FOREIGN KEY (mea_id) REFERENCES ebsc_orgobjectives_measures(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 3206 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2010-12-09 16:21:17

--
-- PostgreSQL database dump complete
--

