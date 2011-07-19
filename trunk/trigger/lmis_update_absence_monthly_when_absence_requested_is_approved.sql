-- Function: lmis_update_absence_monthly_when_absence_requested_is_approved()

-- DROP FUNCTION lmis_update_absence_monthly_when_absence_requested_is_approved();

CREATE OR REPLACE FUNCTION lmis_update_absence_monthly_when_absence_requested_is_approved()
  RETURNS trigger AS
$BODY$
DECLARE	
  
  monMin date;
  monMax date;
  monInt int;
  yearInt int;
  total_old double precision;
  final double precision;
  countTemp int;
  rowData record;
  rowWc record;
  countWc double precision;
  
BEGIN
	IF(NEW.requested_status !=OLD.requested_status) THEN
		
		IF ( NEW.requested_status = 2 ) THEN
			
					--SELECT date_part('month', current_date)::int into monInt;
					--SELECT date_part('year', current_date)::int into yearInt;
					--monMin := (yearInt::text || '-' || monInt::text || '-01')::date;
					--Select(date_trunc('MONTH',monMin) + INTERVAL '1 MONTH -1 day')::date into monMax;

					SELECT count(*) INTO countTemp
					FROM lmis_absence_monthly
					WHERE root_id =NEW.root_id AND user_id = NEW.requested_by 
						AND absence_type = NEW.absence_type AND absence_type_id =NEW.absence_type_id;

					SELECT * INTO rowData
					FROM lmis_absence_monthly
					WHERE root_id = NEW.root_id AND user_id = NEW.requested_by 
						AND absence_type = NEW.absence_type AND absence_type_id = NEW.absence_type_id;
					
					--count day from range New.start_time and NEW.end_time
					
				
					SELECT lmis_caculate_date_will_off(NEW.root_id,NEW.start_date,NEW.end_date,NEW.start_session,NEW.end_session) INTO countWc;

					IF (countTemp > 0 ) THEN
						SELECT total_day_approved INTO total_old
						FROM lmis_absence_monthly
						WHERE root_id = NEW.root_id AND user_id = NEW.requested_by 
							AND absence_type = NEW.absence_type AND absence_type_id = NEW.absence_type_id;

	
						
						final := total_old + countWc::double precision;

		
						Raise Notice 'exc lmis_update_absence_monthly_when_absence_requested_is_approved case update:%',countTemp;
						
						SELECT date_part('month', current_date)::int into monInt;
						SELECT date_part('year', current_date)::int into yearInt;
						
						UPDATE lmis_absence_monthly
						   SET total_day_approved=final
						 WHERE root_id = NEW.root_id AND user_id = NEW.requested_by 
							AND absence_type = NEW.absence_type AND absence_type_id = NEW.absence_type_id
							AND month_value = monInt AND year_value = yearInt;

					ELSE
							--Raise Notice 'exc lmis_update_absence_monthly_when_absence_requested_is_approved no case insert:%1',countTemp;
					END IF;
		END IF;
	END IF;
  RETURN NEW;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION lmis_update_absence_monthly_when_absence_requested_is_approved() OWNER TO postgres;


-- Trigger: trg_lmis_update_absence_monthly_when_absence_requested_is_appro on lmis_absence_requests

-- DROP TRIGGER trg_lmis_update_absence_monthly_when_absence_requested_is_appro ON lmis_absence_requests;

CREATE TRIGGER trg_lmis_update_absence_monthly_when_absence_requested_is_appro
  AFTER UPDATE
  ON lmis_absence_requests
  FOR EACH ROW
  EXECUTE PROCEDURE lmis_update_absence_monthly_when_absence_requested_is_approved();
