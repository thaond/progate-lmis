
create table V_ProGateJournalArticle (
	id INTEGER not null primary key,
	orgid VARCHAR(75) null,
	name VARCHAR(75) null,
	articletype INTEGER,
	title VARCHAR(75) null,
	titleurl VARCHAR(75) null,
	description VARCHAR(75) null,
	content VARCHAR(75) null,
	priority INTEGER,
	smallimageurl VARCHAR(75) null,
	bigimageurl VARCHAR(75) null,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null,
	discount DOUBLE,
	price DOUBLE,
	currencyid INTEGER,
	producttype INTEGER,
	is_hot BOOLEAN,
	isservice BOOLEAN,
	expired_date DATE null,
	amount INTEGER,
	currencyCode VARCHAR(75) null,
	journalarticleTypesName VARCHAR(75) null,
	progate_category INTEGER
);

create table cds_cdp (
	id INTEGER not null primary key,
	root_id INTEGER,
	period_id INTEGER,
	user_id INTEGER,
	written_by INTEGER,
	written_at DATE null,
	written_content VARCHAR(75) null
);

create table cds_competencies (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_competency_statistical_report (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	period_id INTEGER,
	user_id INTEGER,
	level_ranking_hash INTEGER,
	level_ranking_value VARCHAR(75) null
);

create table cds_evaluation_periods (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	from_date DATE null,
	to_date DATE null,
	start_date DATE null,
	end_date DATE null,
	status INTEGER,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null,
	is_modified BOOLEAN
);

create table cds_level_statistical_report (
	id INTEGER not null primary key,
	root_id INTEGER,
	competency_id INTEGER,
	name VARCHAR(75) null,
	period_id INTEGER,
	user_id INTEGER,
	total_level_point INTEGER
);

create table cds_levels (
	root_id INTEGER,
	id INTEGER not null primary key,
	competency_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	alias_name VARCHAR(75) null,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_minimum_requirement_levels (
	id INTEGER not null primary key,
	minimum_requirement_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_minimum_requirements (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_performance_appraisal_competencies (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	period_id INTEGER,
	user_id  INTEGER,
	competency_id INTEGER,
	level_ranking_hash INTEGER,
	level_ranking_value VARCHAR(75) null
);

create table cds_performance_appraisal_final (
	id INTEGER not null primary key,
	root_id INTEGER,
	user_id INTEGER,
	title_id INTEGER
);

create table cds_performance_appraisal_final_competencies (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	competency_id INTEGER,
	level_ranking_hash INTEGER,
	level_ranking_value VARCHAR(75) null
);

create table cds_performance_appraisal_final_levels (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	level_id INTEGER,
	total_level_point INTEGER,
	is_passed BOOLEAN
);

create table cds_performance_appraisal_final_slots (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	slot_id INTEGER,
	rating_status BOOLEAN,
	point_name VARCHAR(75) null,
	max_point_name VARCHAR(75) null,
	point_value INTEGER,
	max_point_value INTEGER,
	is_passed BOOLEAN
);

create table cds_performance_appraisal_levels (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	period_id INTEGER,
	user_id  INTEGER,
	level_id INTEGER,
	total_level_point INTEGER,
	is_passed BOOLEAN
);

create table cds_performance_appraisal_slot_comments (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	period_id INTEGER,
	user_id INTEGER,
	slot_id INTEGER,
	comment_by INTEGER,
	comment_at DATE null,
	comment_content VARCHAR(75) null
);

create table cds_performance_appraisal_slot_rating (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	period_id INTEGER,
	user_id INTEGER,
	slot_id INTEGER,
	rating_by INTEGER,
	rating_at DATE null,
	rating_status BOOLEAN,
	user_type INTEGER,
	point_name VARCHAR(75) null,
	point_value INTEGER,
	rating_org_id INTEGER
);

create table cds_performance_appraisal_slots (
	id INTEGER not null primary key,
	pa_id INTEGER,
	root_id INTEGER,
	period_id INTEGER,
	user_id  INTEGER,
	slot_id INTEGER,
	pm_uid INTEGER,
	bod_uid INTEGER,
	rating_org_id INTEGER,
	rating_status INTEGER,
	rating_status_pm INTEGER,
	rating_status_bod INTEGER,
	point_name VARCHAR(75) null,
	max_point_name VARCHAR(75) null,
	point_value INTEGER,
	max_point_value INTEGER,
	is_passed BOOLEAN
);

create table cds_performance_appraisals (
	id INTEGER not null primary key,
	root_id INTEGER,
	period_id INTEGER,
	user_id INTEGER,
	title_id INTEGER,
	rating_status INTEGER,
	rating_status_pm INTEGER,
	rating_status_bod INTEGER,
	is_locked BOOLEAN,
	pm_list VARCHAR(75) null,
	org_list VARCHAR(75) null,
	bod_list VARCHAR(75) null,
	is_title_up BOOLEAN
);

create table cds_points (
	id INTEGER not null primary key,
	root_id INTEGER,
	point_name VARCHAR(75) null,
	point_value INTEGER,
	description VARCHAR(75) null,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_slot_statistical_report (
	id INTEGER not null primary key,
	root_id INTEGER,
	level_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	period_id INTEGER,
	user_id INTEGER,
	pm_uid INTEGER,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	rating_status_pm INTEGER,
	rating_status_bod INTEGER,
	point_name VARCHAR(75) null,
	point_value INTEGER,
	max_point_name VARCHAR(75) null,
	max_point_value INTEGER,
	to_date DATE null,
	status INTEGER
);

create table cds_slots (
	root_id INTEGER,
	id INTEGER not null primary key,
	level_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	alias_name VARCHAR(75) null,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table cds_title_competencies (
	id INTEGER not null primary key,
	title_id INTEGER,
	competency_id INTEGER,
	point_hash INTEGER,
	point_value VARCHAR(75) null
);

create table cds_title_minimum_requirements (
	id INTEGER not null primary key,
	title_id INTEGER,
	minimum_requirement_id INTEGER,
	level_id INTEGER
);

create table cds_titles (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	number_order INTEGER,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table country (
	countryid INTEGER not null primary key,
	name VARCHAR(75) null,
	active_ BOOLEAN
);

create table ebsc_orgobjectives_approval (
	id INTEGER not null primary key,
	status INTEGER,
	approved_at DATE null,
	approved_by INTEGER,
	reason VARCHAR(75) null,
	obj_id INTEGER
);

create table ebsc_orgobjectives_list (
	id INTEGER not null primary key,
	org_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	created_date DATE null,
	year INTEGER,
	objtype INTEGER,
	entering_percent DOUBLE,
	completion_percent DOUBLE,
	isapproved BOOLEAN,
	month_hash INTEGER,
	validweight BOOLEAN,
	current_total_cost DOUBLE,
	expected_completion DOUBLE,
	next_total_cost DOUBLE,
	consistency_ratio DOUBLE,
	parentid INTEGER
);

create table ebsc_orgobjectives_measures (
	id INTEGER not null primary key,
	obj_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	created_date DATE null,
	weight_percent DOUBLE,
	isassessed BOOLEAN,
	result DOUBLE,
	entering_percent DOUBLE,
	completion_percent DOUBLE,
	formula VARCHAR(75) null,
	target_count INTEGER,
	interpretation VARCHAR(75) null,
	weight_percent_suggested DOUBLE
);

create table ebsc_orgobjectives_objectives (
	id INTEGER not null primary key,
	obj_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	created_date DATE null,
	weight_percent DOUBLE,
	entering_percent DOUBLE,
	completion_percent DOUBLE,
	measure_count INTEGER,
	validweight BOOLEAN,
	consistency_ratio DOUBLE,
	weight_percent_suggested DOUBLE
);

create table ebsc_orgobjectives_perspectives (
	id INTEGER not null primary key,
	obj_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	weight_percent DOUBLE,
	entering_percent DOUBLE,
	completion_percent DOUBLE,
	objective_count DOUBLE,
	validweight BOOLEAN,
	pertype INTEGER,
	current_cost DOUBLE,
	next_cost DOUBLE,
	next_cost2 DOUBLE,
	consistency_ratio DOUBLE,
	weight_percent_suggested DOUBLE
);

create table ebsc_orgobjectives_targets (
	id INTEGER not null primary key,
	mea_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	created_date DATE null,
	value DOUBLE,
	minMax BOOLEAN
);

create table lmis_absence_approvals (
	id INTEGER not null primary key,
	root_id INTEGER,
	request_id INTEGER,
	approved_by INTEGER,
	approved_at DATE null,
	is_approved BOOLEAN,
	approved_status BOOLEAN,
	reason VARCHAR(75) null
);

create table lmis_absence_monthly (
	id INTEGER not null primary key,
	root_id INTEGER,
	month_value INTEGER,
	year_value INTEGER,
	user_id INTEGER,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	total_day DOUBLE,
	total_day_requested DOUBLE,
	total_day_approved DOUBLE
);

create table lmis_absence_requests (
	id INTEGER not null primary key,
	root_id INTEGER,
	requested_by INTEGER,
	start_date DATE null,
	end_date DATE null,
	start_session INTEGER,
	end_session INTEGER,
	requested_reason VARCHAR(75) null,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null
);

create table lmis_absence_settings (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	is_subtract BOOLEAN,
	is_modified BOOLEAN,
	absence_permissive BOOLEAN
);

create table lmis_absence_yearly (
	id INTEGER not null primary key,
	root_id INTEGER,
	year_value INTEGER,
	user_id INTEGER,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	total_day DOUBLE
);

create table lmis_attendance_daily (
	id INTEGER not null primary key,
	day_value DATE null,
	root_id INTEGER,
	user_id INTEGER,
	absence_value DOUBLE,
	is_permissive BOOLEAN,
	absence_reason VARCHAR(75) null,
	absence_reason_id INTEGER,
	plan_start_time DATE null,
	real_start_time DATE null,
	time_late INTEGER,
	time_late_penalty INTEGER,
	time_late_final DOUBLE,
	plan_end_time DATE null,
	real_end_time DATE null,
	time_early INTEGER,
	time_early_penalty INTEGER,
	time_early_final DOUBLE,
	overtime_value VARCHAR(75) null,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_time_final DOUBLE,
	comment VARCHAR(75) null,
	created_at DATE null,
	created_by INTEGER,
	updated_at DATE null,
	updated_by INTEGER,
	total_overtime_requested DOUBLE,
	absence INTEGER
);

create table lmis_attendance_monthly (
	id INTEGER not null primary key,
	year_value INTEGER,
	month_value INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	total_working_day INTEGER,
	num_day_award DOUBLE,
	total_dayoff DOUBLE,
	total_day_compensation DOUBLE,
	total_dayoff_compensation DOUBLE,
	start_time_average DATE null,
	end_time_average DATE null,
	total_time_late INTEGER,
	total_time_late_penalty INTEGER,
	total_time_early INTEGER,
	total_time_early_penalty INTEGER,
	total_day_overtime INTEGER,
	total_time_late_final DOUBLE,
	total_time_early_final DOUBLE,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_day_compensation_next_month DOUBLE,
	total_time_final DOUBLE,
	total_overtime_requested DOUBLE,
	total_dayoff_permissive DOUBLE
);

create table lmis_attendance_yearly (
	id INTEGER not null primary key,
	year_value INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	total_working_day INTEGER,
	total_day_award_prev_year DOUBLE,
	total_dayoff DOUBLE,
	total_day_award DOUBLE,
	total_day_remaining DOUBLE,
	start_time_average DATE null,
	end_time_average DATE null,
	total_time_late INTEGER,
	total_time_late_penalty INTEGER,
	total_time_early INTEGER,
	total_time_early_penalty INTEGER,
	total_day_overtime INTEGER,
	total_time_late_final DOUBLE,
	total_time_early_final DOUBLE,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_time_final DOUBLE,
	total_overtime_requested DOUBLE,
	total_dayoff_permissive DOUBLE
);

create table lmis_data_import_details (
	id INTEGER not null primary key,
	root_id INTEGER,
	import_id INTEGER,
	start_time DATE null,
	end_time DATE null,
	scanner_id VARCHAR(75) null,
	absence INTEGER,
	staff_name VARCHAR(75) null
);

create table lmis_data_imports (
	id INTEGER not null primary key,
	root_id INTEGER,
	date_value DATE null,
	import_type INTEGER,
	import_by INTEGER,
	import_at DATE null,
	session_id INTEGER
);

create table lmis_data_inputs (
	id INTEGER not null primary key,
	root_id INTEGER,
	user_id INTEGER,
	day_value DATE null,
	start_time DATE null,
	end_time DATE null,
	input_by INTEGER,
	input_at DATE null
);

create table lmis_day_types (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	day_type INTEGER
);

create table lmis_email_setting_details (
	id INTEGER not null primary key,
	email_setting_id INTEGER,
	org_related_id INTEGER,
	user_related_id INTEGER
);

create table lmis_email_settings (
	id INTEGER not null primary key,
	root_id INTEGER,
	email_name VARCHAR(75) null,
	email_desciption VARCHAR(75) null,
	email_template VARCHAR(75) null,
	email_type VARCHAR(75) null,
	category INTEGER,
	to_sender BOOLEAN,
	to_pm BOOLEAN,
	to_bod BOOLEAN
);

create table lmis_general_settings (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	conf_type INTEGER,
	conf_value DOUBLE
);

create table lmis_overtime_approvals (
	id INTEGER not null primary key,
	root_id INTEGER,
	request_id INTEGER,
	report_id INTEGER,
	approved_by INTEGER,
	approved_at DATE null,
	is_approved BOOLEAN,
	approved_status BOOLEAN,
	reason VARCHAR(75) null
);

create table lmis_overtime_monthly (
	id INTEGER not null primary key,
	month_value INTEGER,
	year_value INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	ot_type VARCHAR(75) null,
	ot_id INTEGER,
	total_hour DOUBLE,
	total_hour_final DOUBLE,
	org_id INTEGER
);

create table lmis_overtime_report_details (
	id INTEGER not null primary key,
	root_id INTEGER,
	report_id INTEGER,
	user_id INTEGER,
	start_time DATE null,
	end_time DATE null,
	total_hour DOUBLE
);

create table lmis_overtime_report_hours (
	id INTEGER not null primary key,
	detail_id INTEGER,
	ot_type VARCHAR(75) null,
	ot_hour DOUBLE,
	ot_coefficient DOUBLE,
	ot_id INTEGER
);

create table lmis_overtime_reports (
	id INTEGER not null primary key,
	root_id INTEGER,
	reported_by INTEGER,
	reported_at DATE null,
	reported_reason VARCHAR(75) null,
	reported_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	request_id INTEGER,
	org_id INTEGER
);

create table lmis_overtime_request_details (
	id INTEGER not null primary key,
	root_id INTEGER,
	request_id INTEGER,
	user_id INTEGER,
	start_time DATE null,
	end_time DATE null,
	requested_reason VARCHAR(75) null,
	requested_hour DOUBLE
);

create table lmis_overtime_requests (
	id INTEGER not null primary key,
	root_id INTEGER,
	requested_by INTEGER,
	requested_at DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	org_id INTEGER
);

create table lmis_overtime_settings (
	id INTEGER not null primary key,
	root_id INTEGER,
	ot_id INTEGER,
	day_type INTEGER,
	coefficient DOUBLE
);

create table lmis_overtime_types (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table lmis_overtime_yearly (
	id INTEGER not null primary key,
	year_value INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	ot_type VARCHAR(75) null,
	ot_id INTEGER,
	total_hour DOUBLE,
	total_hour_final DOUBLE
);

create table lmis_timechange_approvals (
	id INTEGER not null primary key,
	root_id INTEGER,
	request_id INTEGER,
	approved_by INTEGER,
	approved_at DATE null,
	is_approved BOOLEAN,
	approved_status BOOLEAN,
	reason VARCHAR(75) null
);

create table lmis_timechange_requests (
	id INTEGER not null primary key,
	root_id INTEGER,
	requested_by INTEGER,
	start_date DATE null,
	end_date DATE null,
	mon_selected BOOLEAN,
	mon_start_time DATE null,
	mon_end_time DATE null,
	tue_selected BOOLEAN,
	tue_start_time DATE null,
	tue_end_time DATE null,
	wed_selected BOOLEAN,
	wed_start_time DATE null,
	wed_end_time DATE null,
	thu_selected BOOLEAN,
	thu_start_time DATE null,
	thu_end_time DATE null,
	fri_selected BOOLEAN,
	fri_start_time DATE null,
	fri_end_time DATE null,
	sat_selected BOOLEAN,
	sat_start_time DATE null,
	sat_end_time DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null
);

create table lmis_working_calendar_sessions (
	id INTEGER not null primary key,
	root_id INTEGER,
	calendar_id INTEGER,
	session_id INTEGER
);

create table lmis_working_calendars (
	id INTEGER not null primary key,
	root_id INTEGER,
	day_value DATE null,
	day_type INTEGER,
	description VARCHAR(75) null,
	is_modified BOOLEAN,
	total_working_time DOUBLE,
	is_related_session BOOLEAN
);

create table lmis_workingtime_settings (
	id INTEGER not null primary key,
	root_id INTEGER,
	session_name VARCHAR(75) null,
	start_time DATE null,
	end_time DATE null,
	limit_late INTEGER,
	max_late INTEGER,
	coefficient_late DOUBLE,
	limit_early INTEGER,
	max_early INTEGER,
	coefficient_early DOUBLE
);

create table organizations (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	description VARCHAR(75) null,
	max_user_count INTEGER,
	expired_date DATE null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state VARCHAR(75) null,
	stateid INTEGER,
	country VARCHAR(75) null,
	phone VARCHAR(75) null,
	org_type VARCHAR(75) null,
	org_typeid INTEGER,
	org_status BOOLEAN,
	show_logo BOOLEAN,
	logourl VARCHAR(75) null,
	slogan VARCHAR(75) null,
	bannerurl VARCHAR(75) null,
	videourl VARCHAR(75) null,
	website VARCHAR(75) null,
	org_size INTEGER,
	org_founded DATE null,
	created_by LONG,
	created_at DATE null,
	updated_by LONG,
	updated_at DATE null,
	founder_list VARCHAR(75) null,
	parent_id INTEGER,
	root_id INTEGER,
	bod_id INTEGER,
	begin_time DATE null,
	end_time DATE null,
	email VARCHAR(75) null,
	is_proactive BOOLEAN,
	level_sharing INTEGER,
	is_private_profile BOOLEAN,
	profile_url VARCHAR(75) null,
	max_level INTEGER,
	level INTEGER
);

create table progate_applications (
	id INTEGER not null primary key,
	layout_id INTEGER,
	name VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	is_hidden BOOLEAN,
	friendly_url VARCHAR(75) null,
	image_url VARCHAR(75) null,
	icon_url VARCHAR(75) null,
	created_at DATE null,
	updated_at DATE null
);

create table progate_applications_setting (
	id INTEGER not null primary key,
	app_id INTEGER,
	role_id INTEGER,
	default_position INTEGER
);

create table progate_currencytypes (
	id INTEGER not null primary key,
	code VARCHAR(75) null,
	description VARCHAR(75) null
);

create table progate_journalarticle (
	id INTEGER not null primary key,
	orgid VARCHAR(75) null,
	articletype INTEGER,
	title VARCHAR(75) null,
	titleurl VARCHAR(75) null,
	description VARCHAR(75) null,
	content VARCHAR(75) null,
	priority INTEGER,
	smallimageurl VARCHAR(75) null,
	bigimageurl VARCHAR(75) null,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null,
	addInfo VARCHAR(75) null,
	article_order INTEGER
);

create table progate_journalarticle_priorities (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table progate_journalarticle_types (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table progate_layouts_menus (
	id INTEGER not null primary key,
	layout_id INTEGER,
	menu_name VARCHAR(75) null
);

create table progate_layouts_roles (
	id INTEGER not null primary key,
	layout_id INTEGER,
	min_role_priority INTEGER
);

create table progate_menus (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	layout_id INTEGER,
	number_order INTEGER
);

create table progate_org_customer (
	id INTEGER not null primary key,
	customer_type INTEGER,
	customer_name VARCHAR(75) null,
	org_id INTEGER,
	has_org_map BOOLEAN,
	url_org_map VARCHAR(75) null,
	logo VARCHAR(75) null,
	website VARCHAR(75) null,
	description VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null
);

create table progate_org_customer_representer (
	id INTEGER not null primary key,
	first_name VARCHAR(75) null,
	last_name VARCHAR(75) null,
	display_name VARCHAR(75) null,
	role VARCHAR(75) null,
	customer_id INTEGER,
	org_id INTEGER,
	description VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null
);

create table progate_organization_participants (
	id INTEGER not null primary key,
	user_id INTEGER,
	org_id INTEGER,
	role_id INTEGER,
	root_id INTEGER,
	bod_id INTEGER,
	requested_by INTEGER,
	requested_at DATE null,
	requested_reason VARCHAR(75) null,
	approved_by INTEGER,
	approved_at DATE null,
	approved_reason VARCHAR(75) null,
	status INTEGER,
	is_current BOOLEAN
);

create table progate_organizations_staffs (
	id INTEGER not null primary key,
	user_id INTEGER,
	org_id INTEGER,
	root_id INTEGER,
	bod_id INTEGER,
	participant_id INTEGER,
	position VARCHAR(75) null,
	availability DOUBLE,
	begin_time DATE null,
	end_time DATE null,
	is_active BOOLEAN,
	is_removed BOOLEAN,
	staff_code VARCHAR(75) null,
	scanner_code VARCHAR(75) null,
	created_at DATE null,
	updated_at DATE null
);

create table progate_organizations_users_permissions (
	id INTEGER not null primary key,
	org_id INTEGER,
	user_id INTEGER,
	per_id VARCHAR(75) null,
	value INTEGER,
	is_grant BOOLEAN,
	pm_id INTEGER
);

create table progate_organizations_users_roles (
	id INTEGER not null primary key,
	orgid INTEGER,
	userid INTEGER,
	roleid INTEGER
);

create table progate_orgtypes (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	status BOOLEAN
);

create table progate_permissions (
	id VARCHAR(75) not null primary key,
	app_id INTEGER,
	category INTEGER,
	description VARCHAR(75) null
);

create table progate_portal_menu (
	id INTEGER not null primary key,
	menu_name VARCHAR(75) null,
	layout_id INTEGER,
	role_id INTEGER,
	org_id INTEGER,
	menu_order INTEGER
);

create table progate_products_services (
	id INTEGER not null primary key,
	articleid INTEGER,
	orgid INTEGER,
	discount DOUBLE,
	price DOUBLE,
	currencyid INTEGER,
	producttype INTEGER,
	is_hot BOOLEAN,
	isservice BOOLEAN,
	progate_category INTEGER,
	expired_date DATE null,
	amount INTEGER
);

create table progate_products_slideshow (
	id INTEGER not null primary key,
	orgid INTEGER,
	productid INTEGER,
	imageurl VARCHAR(75) null,
	title VARCHAR(75) null,
	titleurl VARCHAR(75) null,
	slideindex INTEGER,
	isservice BOOLEAN,
	created_by INTEGER,
	created_at DATE null,
	updated_by INTEGER,
	updated_at DATE null
);

create table progate_roles (
	id INTEGER not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	roletype INTEGER,
	priority INTEGER
);

create table progate_user_applications (
	id INTEGER not null primary key,
	user_id INTEGER,
	app_id INTEGER,
	org_id INTEGER,
	position INTEGER
);

create table quannn (
	id INTEGER not null primary key,
	name VARCHAR(75) null
);

create table region (
	regionid INTEGER not null primary key,
	name VARCHAR(75) null,
	regioncode VARCHAR(75) null,
	countryid VARCHAR(75) null,
	active_ BOOLEAN
);

create table user_ (
	userid INTEGER not null primary key,
	uuid_ VARCHAR(75) null,
	companyid INTEGER,
	createdate DATE null,
	modifieddate DATE null,
	defaultuser BOOLEAN,
	contactid INTEGER,
	password_ VARCHAR(75) null,
	passwordencrypted BOOLEAN,
	passwordreset BOOLEAN,
	passwordmodifieddate DATE null,
	reminderqueryquestion VARCHAR(75) null,
	reminderqueryanswer VARCHAR(75) null,
	gracelogincount INTEGER,
	screenname VARCHAR(75) null,
	emailaddress VARCHAR(75) null,
	openid VARCHAR(75) null,
	languageid VARCHAR(75) null,
	timezoneid VARCHAR(75) null,
	greeting VARCHAR(75) null,
	comments VARCHAR(75) null,
	firstname VARCHAR(75) null,
	middlename VARCHAR(75) null,
	lastname VARCHAR(75) null,
	jobtitle VARCHAR(75) null,
	logindate DATE null,
	loginip VARCHAR(75) null,
	lastlogindate DATE null,
	lastloginip VARCHAR(75) null,
	lastfailedlogindate DATE null,
	failedloginattempts INTEGER,
	lockout BOOLEAN,
	lockoutdate DATE null,
	agreedtotermsofuse BOOLEAN,
	active_ BOOLEAN,
	is_proactive BOOLEAN,
	status BOOLEAN
);

create table v_cds_performance_appraisal_final_cds_titles (
	id INTEGER not null primary key,
	root_id INTEGER,
	user_id INTEGER,
	title_id INTEGER,
	titlename VARCHAR(75) null
);

create table v_employees_in_projects (
	view_id VARCHAR(75) not null primary key,
	root_id INTEGER,
	user_id INTEGER,
	firstname VARCHAR(75) null,
	middlename VARCHAR(75) null,
	lastname VARCHAR(75) null,
	position VARCHAR(75) null,
	title_abbreviation VARCHAR(75) null,
	title_name VARCHAR(75) null,
	org_id INTEGER,
	org_list VARCHAR(75) null,
	pm_list VARCHAR(75) null,
	period_id INTEGER,
	period_name VARCHAR(75) null,
	from_date DATE null,
	to_date DATE null,
	period_status INTEGER,
	rating_status INTEGER,
	rating_status_pm INTEGER,
	rating_status_bod INTEGER,
	is_active BOOLEAN,
	is_removed BOOLEAN,
	is_locked BOOLEAN,
	begin_time DATE null,
	end_time DATE null,
	is_title_up BOOLEAN
);

create table v_final_competencies (
	id INTEGER not null primary key,
	root_id INTEGER,
	name VARCHAR(75) null,
	user_id INTEGER,
	level_ranking_hash INTEGER,
	level_ranking_value VARCHAR(75) null
);

create table v_final_levels (
	id INTEGER not null primary key,
	competency_id INTEGER,
	root_id INTEGER,
	name VARCHAR(75) null,
	user_id INTEGER,
	total_level_point INTEGER,
	is_passed BOOLEAN
);

create table v_final_slots (
	id INTEGER not null primary key,
	level_id INTEGER,
	root_id INTEGER,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	user_id INTEGER,
	rating_status BOOLEAN,
	point_name VARCHAR(75) null,
	max_point_name VARCHAR(75) null,
	point_value INTEGER,
	max_point_value INTEGER,
	is_passed BOOLEAN
);

create table v_organization_products (
	org_id INTEGER not null primary key,
	org_name VARCHAR(75) null,
	count_products INTEGER,
	org_name_lower VARCHAR(75) null
);

create table v_performance_appraisal_levels (
	view_id VARCHAR(75) not null primary key,
	level_id INTEGER,
	number_order INTEGER,
	competency_id INTEGER,
	root_id INTEGER,
	level_name VARCHAR(75) null,
	pa_id INTEGER,
	user_id INTEGER,
	period_id INTEGER,
	total_level_point INTEGER,
	is_passed BOOLEAN
);

create table v_performance_appraisal_slots (
	view_id VARCHAR(75) not null primary key,
	alias_name VARCHAR(75) null,
	description VARCHAR(75) null,
	number_order INTEGER,
	user_id INTEGER,
	period_id INTEGER,
	period_name VARCHAR(75) null,
	from_date DATE null,
	to_date DATE null,
	rating_org_id INTEGER,
	rating_status INTEGER,
	rating_status_bod INTEGER,
	rating_status_pm INTEGER
);

create table v_progate_permissions_roles (
	progate_permissions_id VARCHAR(75) not null primary key,
	app_id INTEGER,
	category INTEGER,
	role_id INTEGER,
	per_id VARCHAR(75) null,
	description VARCHAR(75) null
);

create table v_slot_information (
	id INTEGER not null primary key,
	root_id INTEGER,
	user_id INTEGER,
	slot_id INTEGER,
	point_name VARCHAR(75) null,
	max_point_name VARCHAR(75) null,
	is_passed BOOLEAN,
	period_name VARCHAR(75) null,
	from_date DATE null,
	to_date DATE null,
	pm_name VARCHAR(75) null,
	org_name VARCHAR(75) null
);

create table v_title_competencies (
	id VARCHAR(75) not null primary key,
	title_id INTEGER,
	root_id INTEGER,
	title_name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	competency_id INTEGER,
	competency_name VARCHAR(75) null,
	competency_number_order INTEGER,
	point_hash INTEGER,
	point_value VARCHAR(75) null
);

create table v_title_minimum_requirements (
	id VARCHAR(75) not null primary key,
	title_id INTEGER,
	root_id INTEGER,
	title_name VARCHAR(75) null,
	abbreviation VARCHAR(75) null,
	minimum_requirement_id INTEGER,
	minimum_requirement_name VARCHAR(75) null,
	minimum_requirement_number_order INTEGER,
	level_id INTEGER,
	level VARCHAR(75) null
);

create table v_user_information (
	view_id VARCHAR(75) not null primary key,
	userid INTEGER,
	screenname VARCHAR(75) null,
	emailaddress VARCHAR(75) null,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	lastlogindate DATE null,
	createdate DATE null,
	modifieddate DATE null,
	status INTEGER,
	is_proactive INTEGER,
	org_id INTEGER,
	org_name VARCHAR(75) null,
	parent_id INTEGER,
	joining_desc VARCHAR(75) null,
	joining_status INTEGER,
	request_at DATE null,
	approved_at DATE null,
	role_id INTEGER,
	role_name VARCHAR(75) null,
	role_priority INTEGER,
	is_current BOOLEAN,
	search_information VARCHAR(75) null
);

create table vw_att_info (
	id INTEGER not null primary key,
	staff_uid INTEGER,
	pm_uid INTEGER,
	day_value DATE null,
	root_id INTEGER,
	user_id INTEGER,
	absence_value DOUBLE,
	is_permissive BOOLEAN,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	plan_start_time DATE null,
	real_start_time DATE null,
	time_late INTEGER,
	time_late_penalty INTEGER,
	time_late_final DOUBLE,
	plan_end_time DATE null,
	real_end_time DATE null,
	time_early INTEGER,
	time_early_penalty INTEGER,
	time_early_final DOUBLE,
	overtime_value VARCHAR(75) null,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_time_final DOUBLE,
	created_at DATE null,
	created_by INTEGER,
	updated_at DATE null,
	updated_by INTEGER,
	total_overtime_requested DOUBLE,
	absence INTEGER,
	full_name VARCHAR(75) null,
	staff_code VARCHAR(75) null
);

create table vw_attendance (
	id INTEGER not null primary key,
	day_value DATE null,
	root_id INTEGER,
	user_id INTEGER,
	absence_value DOUBLE,
	is_permissive BOOLEAN,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	plan_start_time DATE null,
	real_start_time DATE null,
	time_late INTEGER,
	time_late_penalty INTEGER,
	time_late_final DOUBLE,
	plan_end_time DATE null,
	real_end_time DATE null,
	time_early INTEGER,
	time_early_penalty INTEGER,
	time_early_final DOUBLE,
	overtime_value VARCHAR(75) null,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_time_final DOUBLE,
	created_at DATE null,
	created_by INTEGER,
	updated_at DATE null,
	updated_by INTEGER,
	total_overtime_requested DOUBLE,
	absence INTEGER,
	full_name VARCHAR(75) null,
	staff_code VARCHAR(75) null
);

create table vw_attendance_daily (
	id INTEGER not null primary key,
	day_value DATE null,
	root_id INTEGER,
	user_id INTEGER,
	absence_value DOUBLE,
	is_permissive BOOLEAN,
	org_id INTEGER,
	absence_type VARCHAR(75) null,
	absence_type_id INTEGER,
	plan_start_time DATE null,
	real_start_time DATE null,
	time_late INTEGER,
	time_late_penalty INTEGER,
	time_late_final DOUBLE,
	plan_end_time DATE null,
	real_end_time DATE null,
	time_early INTEGER,
	time_early_penalty INTEGER,
	time_early_final DOUBLE,
	overtime_value VARCHAR(75) null,
	total_working_time DOUBLE,
	total_overtime DOUBLE,
	total_overtime_final DOUBLE,
	total_time_final DOUBLE,
	created_at DATE null,
	created_by INTEGER,
	updated_at DATE null,
	updated_by INTEGER,
	total_overtime_requested DOUBLE,
	absence INTEGER,
	full_name VARCHAR(75) null,
	staff_code VARCHAR(75) null
);

create table vw_day_types_overtime_settings_type (
	id INTEGER not null primary key,
	ot_type_id INTEGER,
	root_id INTEGER,
	name VARCHAR(75) null,
	day_type INTEGER,
	ot_id INTEGER,
	coefficient DOUBLE,
	name_overtime_type VARCHAR(75) null,
	description VARCHAR(75) null
);

create table vw_day_value_max (
	id INTEGER not null primary key,
	day_value DATE null,
	root_id INTEGER
);

create table vw_email_setting_detail_org (
	org_related_id INTEGER not null primary key,
	id INTEGER,
	root_id INTEGER,
	email_name VARCHAR(75) null,
	category INTEGER,
	to_sender BOOLEAN,
	to_pm BOOLEAN,
	to_bod BOOLEAN,
	email_type VARCHAR(75) null,
	email_org VARCHAR(75) null
);

create table vw_email_setting_detail_user (
	user_related_id INTEGER not null primary key,
	id INTEGER,
	root_id INTEGER,
	email_name VARCHAR(75) null,
	category INTEGER,
	to_sender BOOLEAN,
	to_pm BOOLEAN,
	to_bod BOOLEAN,
	email_type VARCHAR(75) null,
	email_user VARCHAR(75) null
);

create table vw_lmis_staff_mapping_pm (
	id INTEGER not null primary key,
	org_id INTEGER,
	root_id INTEGER,
	bod_id INTEGER,
	staff_uid INTEGER,
	pm_uid INTEGER,
	staff_code VARCHAR(75) null
);

create table vw_org_user_roles (
	id INTEGER not null primary key,
	root_id INTEGER,
	org_id INTEGER,
	user_id INTEGER,
	role_id INTEGER,
	org_name VARCHAR(75) null
);

create table vw_organizations_users_permissions (
	id VARCHAR(75) not null primary key,
	org_id INTEGER,
	root_id INTEGER,
	user_id INTEGER,
	role_id INTEGER,
	per_id VARCHAR(75) null,
	app_id INTEGER,
	category INTEGER,
	description VARCHAR(75) null,
	value INTEGER,
	priority INTEGER
);

create table vw_ot_app (
	id INTEGER not null primary key,
	root_id INTEGER,
	org_id INTEGER,
	requested_by INTEGER,
	requested_at DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	approved_by INTEGER,
	approved_at DATE null,
	is_approved BOOLEAN,
	approved_status BOOLEAN,
	reason VARCHAR(75) null
);

create table vw_overtime_report (
	id INTEGER not null primary key,
	root_id INTEGER,
	org_id INTEGER,
	request_id INTEGER,
	reported_by INTEGER,
	reported_at DATE null,
	reported_reason VARCHAR(75) null,
	reported_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	org_name VARCHAR(75) null
);

create table vw_overtime_report_detail (
	id INTEGER not null primary key,
	ot_rep_id INTEGER,
	root_id INTEGER,
	org_id INTEGER,
	request_id INTEGER,
	reported_by INTEGER,
	reported_at DATE null,
	reported_reason VARCHAR(75) null,
	reported_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	user_id INTEGER,
	total_hour DOUBLE,
	start_time DATE null,
	end_time DATE null,
	full_name VARCHAR(75) null,
	requested_hour DOUBLE,
	req_start_time DATE null,
	req_end_time DATE null
);

create table vw_progate_menu (
	name VARCHAR(75) not null primary key,
	array_to_string VARCHAR(75) null
);

create table vw_registration_overtime (
	id INTEGER not null primary key,
	ot_reqs_id INTEGER,
	root_id INTEGER,
	requested_by INTEGER,
	requested_at DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	org_id INTEGER,
	request_id INTEGER,
	user_id INTEGER,
	start_time DATE null,
	end_time DATE null,
	reason_detail VARCHAR(75) null,
	requested_hour DOUBLE,
	approved_by INTEGER,
	approved_at DATE null,
	is_approved BOOLEAN,
	approved_status BOOLEAN,
	reason VARCHAR(75) null,
	org_name VARCHAR(75) null,
	full_name VARCHAR(75) null,
	first_name VARCHAR(75) null,
	middle_name VARCHAR(75) null,
	last_name VARCHAR(75) null,
	req_first_name VARCHAR(75) null,
	req_middle_name VARCHAR(75) null,
	req_last_name VARCHAR(75) null
);

create table vw_registration_overtime_approval (
	id INTEGER not null primary key,
	root_id INTEGER,
	requested_by INTEGER,
	requested_at DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	org_id INTEGER,
	name VARCHAR(75) null,
	full_name VARCHAR(75) null
);

create table vw_report_overtime (
	id INTEGER not null primary key,
	ot_rep_id INTEGER,
	root_id INTEGER,
	org_id INTEGER,
	request_id INTEGER,
	reported_by INTEGER,
	reported_at DATE null,
	reported_reason VARCHAR(75) null,
	reported_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	report_id INTEGER,
	user_id INTEGER,
	total_hour DOUBLE,
	start_time DATE null,
	end_time DATE null,
	detail_id INTEGER,
	ot_type VARCHAR(75) null,
	ot_hour DOUBLE,
	ot_coefficient DOUBLE,
	ot_id INTEGER,
	org_name VARCHAR(75) null,
	full_name VARCHAR(75) null,
	first_name VARCHAR(75) null,
	middle_name VARCHAR(75) null,
	last_name VARCHAR(75) null,
	rep_first_name VARCHAR(75) null,
	rep_last_name VARCHAR(75) null,
	rep_middle_name VARCHAR(75) null,
	reg_requested_hour DOUBLE,
	reg_start_time DATE null,
	reg_end_time DATE null
);

create table vw_report_overtime_approval (
	id INTEGER not null primary key,
	root_id INTEGER,
	org_id INTEGER,
	request_id INTEGER,
	reported_by INTEGER,
	reported_at DATE null,
	reported_reason VARCHAR(75) null,
	reported_status INTEGER,
	created_at DATE null,
	updated_at DATE null,
	org_name VARCHAR(75) null,
	full_name VARCHAR(75) null
);

create table vw_staff_mapping (
	id INTEGER not null primary key,
	org_id INTEGER,
	root_id INTEGER,
	bod_id INTEGER,
	staff_uid INTEGER,
	pm_uid INTEGER,
	bod_uid INTEGER
);

create table vw_staff_root_org (
	user_id INTEGER not null primary key,
	root_id INTEGER,
	org_id INTEGER,
	bod_id INTEGER,
	screenname VARCHAR(75) null,
	emailaddress VARCHAR(75) null
);

create table vw_staff_root_org_fn_ordered (
	id INTEGER not null primary key,
	user_id INTEGER,
	root_id INTEGER,
	org_id INTEGER,
	bod_id INTEGER,
	staff_code VARCHAR(75) null,
	scanner_code VARCHAR(75) null,
	screenname VARCHAR(75) null,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	emailaddress VARCHAR(75) null
);

create table vw_staff_root_org_fullname (
	id INTEGER not null primary key,
	user_id INTEGER,
	root_id INTEGER,
	org_id INTEGER,
	bod_id INTEGER,
	staff_code VARCHAR(75) null,
	scanner_code VARCHAR(75) null,
	screenname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	emailaddress VARCHAR(75) null
);

create table vw_timechange_request_user_ (
	id INTEGER not null primary key,
	root_id INTEGER,
	requested_by INTEGER,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	fullname VARCHAR(75) null,
	start_date DATE null,
	end_date DATE null,
	mon_start_time DATE null,
	mon_end_time DATE null,
	tue_start_time DATE null,
	tue_end_time DATE null,
	wed_start_time DATE null,
	wed_end_time DATE null,
	thu_start_time DATE null,
	thu_end_time DATE null,
	fri_start_time DATE null,
	fri_end_time DATE null,
	sat_start_time DATE null,
	sat_end_time DATE null,
	requested_reason VARCHAR(75) null,
	requested_status INTEGER,
	created_at DATE null
);

create table vw_working_calendar (
	id INTEGER not null primary key,
	root_id INTEGER,
	day_value DATE null,
	day_type INTEGER,
	is_modified BOOLEAN,
	total_working_time DOUBLE,
	is_related_session BOOLEAN,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);
