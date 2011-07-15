create index IX_C43A83EC on V_ProGateJournalArticle (articletype);
create index IX_3930A8D2 on V_ProGateJournalArticle (created_at);
create index IX_39312FF6 on V_ProGateJournalArticle (created_by);
create index IX_6CA6CF06 on V_ProGateJournalArticle (currencyCode);
create index IX_84A190E9 on V_ProGateJournalArticle (discount);
create index IX_CAB8BB20 on V_ProGateJournalArticle (is_hot);
create index IX_F2C308C7 on V_ProGateJournalArticle (isservice);
create index IX_8F719E01 on V_ProGateJournalArticle (journalarticleTypesName);
create index IX_21A35D7B on V_ProGateJournalArticle (orgid);
create index IX_56A31145 on V_ProGateJournalArticle (price);
create index IX_9EF2088C on V_ProGateJournalArticle (priority);
create index IX_EF63E525 on V_ProGateJournalArticle (producttype);
create index IX_EF69710D on V_ProGateJournalArticle (progate_category);
create index IX_1B7F7A94 on V_ProGateJournalArticle (title);
create index IX_A59B72DF on V_ProGateJournalArticle (updated_at);
create index IX_A59BFA03 on V_ProGateJournalArticle (updated_by);

create index IX_9F106F2D on cds_competencies (name);
create index IX_8F4E503A on cds_competencies (number_order);
create index IX_FF50589A on cds_competencies (root_id);

create index IX_94944246 on cds_evaluation_periods (root_id);
create index IX_C8AC6BA8 on cds_evaluation_periods (status);

create index IX_34B78B0B on cds_levels (competency_id);
create index IX_8C2F2121 on cds_levels (name);
create index IX_E656F226 on cds_levels (root_id);

create index IX_16A0EDCB on cds_minimum_requirement_levels (minimum_requirement_id);
create index IX_62C0BAEE on cds_minimum_requirement_levels (name);

create index IX_1F2A9413 on cds_minimum_requirements (name);
create index IX_2A802F20 on cds_minimum_requirements (number_order);
create index IX_61BC41F4 on cds_minimum_requirements (root_id);

create index IX_66835572 on cds_performance_appraisal_competencies (period_id);

create index IX_6179D6C2 on cds_performance_appraisal_final (root_id);
create index IX_A963D579 on cds_performance_appraisal_final (user_id);

create index IX_28E7C968 on cds_performance_appraisal_final_competencies (root_id);
create index IX_70D1C81F on cds_performance_appraisal_final_competencies (user_id);

create index IX_2F4E9574 on cds_performance_appraisal_final_levels (root_id);
create index IX_7738942B on cds_performance_appraisal_final_levels (user_id);

create index IX_6819FCC on cds_performance_appraisal_final_slots (root_id);
create index IX_4E6B9E83 on cds_performance_appraisal_final_slots (user_id);

create index IX_3E33101E on cds_performance_appraisal_slot_rating (slot_id);
create index IX_297C2671 on cds_performance_appraisal_slot_rating (user_id);

create index IX_68DBD0E4 on cds_performance_appraisal_slots (period_id);
create index IX_E353242A on cds_performance_appraisal_slots (user_id );

create index IX_650C6239 on cds_performance_appraisals (period_id);
create index IX_8F3005EF on cds_performance_appraisals (user_id);

create index IX_B44D2824 on cds_points (point_name);
create index IX_CD70FA32 on cds_points (root_id);

create index IX_CFA5B158 on cds_slots (level_id);
create index IX_BDE44AED on cds_slots (name);

create index IX_7EB6E098 on cds_title_competencies (competency_id);
create index IX_6DC1918B on cds_title_competencies (title_id);

create index IX_69BAFEC5 on cds_title_minimum_requirements (level_id);
create index IX_2B0CE6B7 on cds_title_minimum_requirements (minimum_requirement_id);
create index IX_F3AF9C71 on cds_title_minimum_requirements (title_id);

create index IX_F75F49DA on cds_titles (number_order);
create index IX_E5B1DAFA on cds_titles (root_id);

create index IX_B81378AD on country (active_);
create index IX_5547489B on country (name);

create index IX_91FDD093 on ebsc_orgobjectives_approval (approved_by);
create index IX_2ABBF322 on ebsc_orgobjectives_approval (status);

create index IX_1FD4F3D6 on ebsc_orgobjectives_list (name);
create index IX_CA10002A on ebsc_orgobjectives_list (objtype);
create index IX_5F1E88A1 on ebsc_orgobjectives_list (org_id);
create index IX_32CD5D08 on ebsc_orgobjectives_list (year);

create index IX_38B8D18D on ebsc_orgobjectives_measures (name);
create index IX_853CAA65 on ebsc_orgobjectives_measures (obj_id);

create index IX_3D898352 on ebsc_orgobjectives_objectives (name);
create index IX_98A7FEEA on ebsc_orgobjectives_objectives (obj_id);

create index IX_A10E44EF on ebsc_orgobjectives_perspectives (name);
create index IX_2E02CD47 on ebsc_orgobjectives_perspectives (obj_id);
create index IX_2A2E3C17 on ebsc_orgobjectives_perspectives (pertype);

create index IX_CACA707A on ebsc_orgobjectives_targets (mea_id);
create index IX_B8FE9AF4 on ebsc_orgobjectives_targets (name);

create index IX_29E717CF on lmis_absence_approvals (approved_by);
create index IX_9B503FF on lmis_absence_approvals (request_id);
create index IX_4FBBEF48 on lmis_absence_approvals (root_id);

create index IX_AC09AC6D on lmis_absence_monthly (absence_type);
create index IX_3CC7BB51 on lmis_absence_monthly (absence_type_id);
create index IX_95F87185 on lmis_absence_monthly (month_value);
create index IX_92D8EF2B on lmis_absence_monthly (root_id);
create index IX_DAC2EDE2 on lmis_absence_monthly (user_id);
create index IX_599E3660 on lmis_absence_monthly (year_value);

create index IX_841C2710 on lmis_absence_requests (absence_type);
create index IX_CB3519CE on lmis_absence_requests (absence_type_id);
create index IX_2A3CE726 on lmis_absence_requests (end_date);
create index IX_72CE7ADC on lmis_absence_requests (requested_by);
create index IX_5F7C0237 on lmis_absence_requests (requested_status);
create index IX_7B371AA8 on lmis_absence_requests (root_id);
create index IX_94CE053F on lmis_absence_requests (start_date);

create index IX_BFAAE954 on lmis_absence_settings (absence_permissive);
create index IX_3ABE9CE9 on lmis_absence_settings (root_id);

create index IX_B3EAC356 on lmis_absence_yearly (absence_type);
create index IX_27B0CFC8 on lmis_absence_yearly (absence_type_id);
create index IX_B49D6AA2 on lmis_absence_yearly (root_id);
create index IX_FC876959 on lmis_absence_yearly (user_id);
create index IX_E979F389 on lmis_absence_yearly (year_value);

create index IX_19D5EDA2 on lmis_attendance_daily (absence_value);
create index IX_895E881 on lmis_attendance_daily (day_value);
create index IX_D3A9C4CB on lmis_attendance_daily (root_id);
create index IX_1B93C382 on lmis_attendance_daily (user_id);

create index IX_6ADEB631 on lmis_attendance_monthly (month_value);
create index IX_827C1AC0 on lmis_attendance_monthly (num_day_award);
create index IX_FC9469D7 on lmis_attendance_monthly (root_id);
create index IX_447E688E on lmis_attendance_monthly (user_id);
create index IX_89C6AC34 on lmis_attendance_monthly (year_value);

create index IX_6571EA76 on lmis_attendance_yearly (root_id);
create index IX_AD5BE92D on lmis_attendance_yearly (user_id);
create index IX_D2417335 on lmis_attendance_yearly (year_value);

create index IX_25B86476 on lmis_data_import_details (import_id);
create index IX_C4CAED19 on lmis_data_import_details (root_id);
create index IX_8FA3B27F on lmis_data_import_details (scanner_id);

create index IX_BF6DAB47 on lmis_data_imports (date_value);
create index IX_119950E on lmis_data_imports (import_by);
create index IX_B76F6475 on lmis_data_imports (root_id);

create index IX_BD1E0F38 on lmis_data_inputs (root_id);
create index IX_5080DEF on lmis_data_inputs (user_id);

create index IX_7DAEAB40 on lmis_day_types (root_id);

create index IX_527C89C3 on lmis_email_setting_details (email_setting_id);

create index IX_5A4FEB72 on lmis_email_settings (category);
create index IX_B3F31BC8 on lmis_email_settings (root_id);

create index IX_69743431 on lmis_general_settings (conf_type);
create index IX_77292014 on lmis_general_settings (root_id);

create index IX_F5AAD8C3 on lmis_overtime_approvals (approved_by);
create index IX_7A17C4AA on lmis_overtime_approvals (report_id);
create index IX_DEBB548B on lmis_overtime_approvals (request_id);
create index IX_F2CE4A3C on lmis_overtime_approvals (root_id);

create index IX_BDDFDF79 on lmis_overtime_monthly (month_value);
create index IX_2A1B0713 on lmis_overtime_monthly (org_id);
create index IX_887A253C on lmis_overtime_monthly (ot_id);
create index IX_68ED771F on lmis_overtime_monthly (root_id);
create index IX_B0D775D6 on lmis_overtime_monthly (user_id);
create index IX_18D739EC on lmis_overtime_monthly (year_value);

create index IX_356B658F on lmis_overtime_report_details (report_id);
create index IX_73EEE061 on lmis_overtime_report_details (root_id);
create index IX_BBD8DF18 on lmis_overtime_report_details (user_id);

create index IX_3A213125 on lmis_overtime_report_hours (detail_id);
create index IX_4BB55D11 on lmis_overtime_report_hours (ot_id);

create index IX_496AD245 on lmis_overtime_reports (org_id);
create index IX_E3D6BAFA on lmis_overtime_reports (request_id);
create index IX_3397122D on lmis_overtime_reports (root_id);

create index IX_D5E6728D on lmis_overtime_request_details (request_id);
create index IX_34BDBB7A on lmis_overtime_request_details (root_id);
create index IX_7CA7BA31 on lmis_overtime_request_details (user_id);

create index IX_21CED65E on lmis_overtime_requests (org_id);
create index IX_3E923BD0 on lmis_overtime_requests (requested_by);
create index IX_67B39134 on lmis_overtime_requests (root_id);

create index IX_250B8EA4 on lmis_overtime_settings (day_type);
create index IX_190EDF12 on lmis_overtime_settings (ot_id);
create index IX_273B1375 on lmis_overtime_settings (root_id);

create index IX_22F6CDB3 on lmis_overtime_types (root_id);

create index IX_1E9E142E on lmis_overtime_yearly (root_id);
create index IX_668812E5 on lmis_overtime_yearly (user_id);
create index IX_8C8C4E7D on lmis_overtime_yearly (year_value);

create index IX_F117E227 on lmis_timechange_approvals (approved_by);
create index IX_DE958EA7 on lmis_timechange_approvals (request_id);
create index IX_56DFA5A0 on lmis_timechange_approvals (root_id);

create index IX_39FF4534 on lmis_timechange_requests (requested_by);
create index IX_10173950 on lmis_timechange_requests (root_id);

create index IX_2B751A26 on lmis_working_calendar_sessions (root_id);

create index IX_EC56820A on lmis_working_calendars (day_type);
create index IX_DF21AE05 on lmis_working_calendars (day_value);
create index IX_4EB11B4F on lmis_working_calendars (root_id);

create index IX_F59F77AA on lmis_workingtime_settings (root_id);
create index IX_9B928FE6 on lmis_workingtime_settings (session_name);

create index IX_E06C1ABD on organizations (bod_id);
create index IX_C0F552B2 on organizations (is_private_profile);
create index IX_B1F05C78 on organizations (is_proactive);
create index IX_2C85556B on organizations (level_sharing);
create index IX_CAB300A5 on organizations (name);
create index IX_2DF3D47 on organizations (org_status);
create index IX_E60A174F on organizations (org_type);
create index IX_BE9A535A on organizations (parent_id);
create index IX_DA8EB422 on organizations (root_id);

create index IX_72A03B2E on progate_applications (created_at);
create index IX_CD5FD9FF on progate_applications (is_hidden);
create index IX_DAD305B0 on progate_applications (layout_id);
create index IX_B6EDBE0F on progate_applications (name);
create index IX_DF0B053B on progate_applications (updated_at);

create index IX_7254854E on progate_applications_setting (app_id);
create index IX_7F00B3B3 on progate_applications_setting (role_id);

create index IX_429DA4E8 on progate_currencytypes (code);

create index IX_F8E2393 on progate_journalarticle (addInfo);
create index IX_B9976669 on progate_journalarticle (article_order);
create index IX_53FE0694 on progate_journalarticle (articletype);
create index IX_671E312A on progate_journalarticle (created_at);
create index IX_671EB84E on progate_journalarticle (created_by);
create index IX_A047FE23 on progate_journalarticle (orgid);
create index IX_36D5C6E4 on progate_journalarticle (priority);
create index IX_9A241B3C on progate_journalarticle (title);
create index IX_D388FB37 on progate_journalarticle (updated_at);
create index IX_D389825B on progate_journalarticle (updated_by);

create index IX_C968E320 on progate_journalarticle_priorities (name);

create index IX_18566605 on progate_journalarticle_types (name);

create index IX_AC0B2D23 on progate_layouts_menus (layout_id);

create index IX_84325F5F on progate_org_customer (created_date);
create index IX_5583F4B6 on progate_org_customer (customer_name);
create index IX_611499A5 on progate_org_customer (customer_type);
create index IX_72061BCE on progate_org_customer (modified_date);
create index IX_F2295AD0 on progate_org_customer (org_id);

create index IX_BBC52F75 on progate_org_customer_representer (created_date);
create index IX_436792B0 on progate_org_customer_representer (customer_id);
create index IX_E5166190 on progate_org_customer_representer (description);
create index IX_2CCD4E78 on progate_org_customer_representer (modified_date);
create index IX_C3C77366 on progate_org_customer_representer (org_id);
create index IX_D06C0306 on progate_org_customer_representer (role);

create index IX_946094E0 on progate_organization_participants (approved_at);
create index IX_94611C04 on progate_organization_participants (approved_by);
create index IX_3E24983 on progate_organization_participants (is_current);
create index IX_F1BFD475 on progate_organization_participants (org_id);
create index IX_89FB8583 on progate_organization_participants (requested_at);
create index IX_89FC0CA7 on progate_organization_participants (requested_by);
create index IX_DD96F2E9 on progate_organization_participants (role_id);
create index IX_F2018511 on progate_organization_participants (status);
create index IX_DDCC54B4 on progate_organization_participants (user_id);

create index IX_2DA853D6 on progate_organizations_staffs (bod_id);
create index IX_E6D143CC on progate_organizations_staffs (is_active);
create index IX_33973EFE on progate_organizations_staffs (is_removed);
create index IX_17E8D6C9 on progate_organizations_staffs (org_id);
create index IX_8FF51EDA on progate_organizations_staffs (participant_id);
create index IX_34D99E29 on progate_organizations_staffs (root_id);
create index IX_B9BFEB41 on progate_organizations_staffs (scanner_code);
create index IX_7936C85F on progate_organizations_staffs (staff_code);
create index IX_7CC39CE0 on progate_organizations_staffs (user_id);

create index IX_ACD4BF7 on progate_organizations_users_permissions (org_id);
create index IX_E66DCD72 on progate_organizations_users_permissions (user_id);

create index IX_35EA0649 on progate_organizations_users_roles (orgid);
create index IX_289A962B on progate_organizations_users_roles (roleid);
create index IX_289C4F00 on progate_organizations_users_roles (userid);

create index IX_AC13EA81 on progate_orgtypes (name);
create index IX_D7BC3128 on progate_orgtypes (status);

create index IX_8FA7D670 on progate_permissions (app_id);

create index IX_FC4DCBCF on progate_portal_menu (layout_id);
create index IX_DCC6642A on progate_portal_menu (menu_name);
create index IX_AF6AAEDB on progate_portal_menu (org_id);
create index IX_D5476543 on progate_portal_menu (role_id);

create index IX_5DA4B869 on progate_products_services (articleid);
create index IX_B6179A8D on progate_products_services (discount);
create index IX_A8ACDDC4 on progate_products_services (is_hot);
create index IX_F00E33A3 on progate_products_services (isservice);
create index IX_310E5657 on progate_products_services (orgid);
create index IX_660E0A21 on progate_products_services (price);
create index IX_C68FC901 on progate_products_services (producttype);
create index IX_AE9D96B1 on progate_products_services (progate_category);

create index IX_F7540FDE on progate_products_slideshow (created_at);
create index IX_F7549702 on progate_products_slideshow (created_by);
create index IX_91813F28 on progate_products_slideshow (imageurl);
create index IX_1166BEEF on progate_products_slideshow (orgid);
create index IX_8A39707A on progate_products_slideshow (productid);
create index IX_51C55EF5 on progate_products_slideshow (slideindex);
create index IX_63BED9EB on progate_products_slideshow (updated_at);
create index IX_63BF610F on progate_products_slideshow (updated_by);

create index IX_51D409BB on progate_roles (name);
create index IX_82DB1794 on progate_roles (priority);
create index IX_D98EEFA0 on progate_roles (roletype);

create index IX_3717CC83 on progate_user_applications (app_id);
create index IX_3FD919A0 on progate_user_applications (org_id);
create index IX_E82E1BB3 on progate_user_applications (position);
create index IX_52DBB4E9 on progate_user_applications (user_id);

create index IX_47B0A4D6 on quannn (name);

create index IX_42D6028F on region (active_);
create index IX_7B59D9F9 on region (name);
create index IX_1B202FCF on region (regioncode);

create index IX_77413B8F on user_ (active_);
create index IX_91DBF406 on user_ (emailaddress);
create index IX_DA1E7D31 on user_ (firstname);
create index IX_1FD308CC on user_ (is_proactive);
create index IX_97B0AD0F on user_ (lastname);
create index IX_8DEEE9CE on user_ (middlename);
create index IX_33F51365 on user_ (screenname);
create index IX_520DC9A0 on user_ (status);

create index IX_64B01FF2 on v_cds_performance_appraisal_final_cds_titles (root_id);
create index IX_AC9A1EA9 on v_cds_performance_appraisal_final_cds_titles (user_id);

create index IX_FAFAB461 on v_employees_in_projects (org_id);
create index IX_B4037391 on v_employees_in_projects (root_id);

create index IX_B257AEF5 on v_organization_products (count_products);
create index IX_C3CDAA27 on v_organization_products (org_name);
create index IX_B63073E9 on v_organization_products (org_name_lower);

create index IX_3AC408C7 on v_title_competencies (title_id);

create index IX_2E5517AD on v_title_minimum_requirements (title_id);

create index IX_389DEF73 on v_user_information (emailaddress);
create index IX_F9BB00E4 on v_user_information (firstname);
create index IX_17FFA13F on v_user_information (is_current);
create index IX_C6950439 on v_user_information (is_proactive);
create index IX_2ED4A7B4 on v_user_information (joining_status);
create index IX_6F6B66FC on v_user_information (lastname);
create index IX_42D66A31 on v_user_information (org_id);
create index IX_C85DF128 on v_user_information (orgid);
create index IX_AF5314AD on v_user_information (role_id);
create index IX_7E90612 on v_user_information (screenname);
create index IX_6BD295B0 on v_user_information (search_information);
create index IX_43181ACD on v_user_information (status);
create index IX_CC8B1535 on v_user_information (user_org_roles_id);
create index IX_E4A5C001 on v_user_information (userid);

create index IX_9AFA50AE on vw_att_info (day_value);
create index IX_EE57389B on vw_att_info (full_name);
create index IX_EE745438 on vw_att_info (root_id);
create index IX_365E52EF on vw_att_info (user_id);

create index IX_E85A73F1 on vw_attendance (day_value);
create index IX_3BB75BDE on vw_attendance (full_name);
create index IX_C4FA6C3B on vw_attendance (root_id);
create index IX_CE46AF2 on vw_attendance (user_id);

create index IX_E86A7E57 on vw_attendance_daily (day_value);
create index IX_3BC76644 on vw_attendance_daily (full_name);
create index IX_DDA17DD1 on vw_attendance_daily (org_id);
create index IX_2635D821 on vw_attendance_daily (root_id);
create index IX_6E1FD6D8 on vw_attendance_daily (user_id);

create index IX_4A42C536 on vw_day_types_overtime_settings_type (day_type);
create index IX_D5D9C2A3 on vw_day_types_overtime_settings_type (root_id);

create index IX_B3B552ED on vw_day_value_max (root_id);

create index IX_CE04C43E on vw_email_setting_detail_org (category);
create index IX_4A9AD10E on vw_email_setting_detail_org (email_name);
create index IX_562B75FD on vw_email_setting_detail_org (email_type);
create index IX_4D0439B on vw_email_setting_detail_org (id);
create index IX_6519F97C on vw_email_setting_detail_org (root_id);

create index IX_2FE545A1 on vw_email_setting_detail_user (category);
create index IX_B66085B1 on vw_email_setting_detail_user (email_name);
create index IX_C1F12AA0 on vw_email_setting_detail_user (email_type);
create index IX_F3FA4B3E on vw_email_setting_detail_user (id);
create index IX_68423FB9 on vw_email_setting_detail_user (root_id);

create index IX_F9D91F80 on vw_lmis_staff_mapping_pm (bod_id);
create index IX_370AE72B on vw_lmis_staff_mapping_pm (pm_uid);
create index IX_EEC247BF on vw_lmis_staff_mapping_pm (root_id);
create index IX_39DD2518 on vw_lmis_staff_mapping_pm (staff_uid);

create index IX_5FAA1052 on vw_org_user_roles (org_id);
create index IX_E53F95C0 on vw_org_user_roles (root_id);
create index IX_2D299477 on vw_org_user_roles (user_id);

create index IX_69973D52 on vw_organizations_users_permissions (root_id);
create index IX_B1813C09 on vw_organizations_users_permissions (user_id);

create index IX_AF4022A4 on vw_ot_app (approved_by);
create index IX_55FF29D5 on vw_ot_app (org_id);
create index IX_CAFD52E3 on vw_ot_app (requested_at);
create index IX_CAFDDA07 on vw_ot_app (requested_by);
create index IX_4541D3E2 on vw_ot_app (requested_status);
create index IX_B98DAC9D on vw_ot_app (root_id);

create index IX_C99B0B24 on vw_overtime_report (org_id);
create index IX_4FF726F5 on vw_overtime_report (reported_at);
create index IX_4FF7AE19 on vw_overtime_report (reported_by);
create index IX_522F4EF4 on vw_overtime_report (reported_status);
create index IX_B96DF52E on vw_overtime_report (root_id);

create index IX_DDFC77EC on vw_overtime_report_detail (org_id);
create index IX_71DC4A5 on vw_overtime_report_detail (ot_rep_id);
create index IX_70E2772D on vw_overtime_report_detail (reported_at);
create index IX_70E2FE51 on vw_overtime_report_detail (reported_by);
create index IX_7007C32C on vw_overtime_report_detail (reported_status);
create index IX_313A2166 on vw_overtime_report_detail (root_id);

create index IX_74F0C6C0 on vw_registration_overtime (approved_by);
create index IX_D9076439 on vw_registration_overtime (org_id);
create index IX_4E3132EE on vw_registration_overtime (request_id);
create index IX_BB613247 on vw_registration_overtime (requested_at);
create index IX_BB61B96B on vw_registration_overtime (requested_by);
create index IX_981F6146 on vw_registration_overtime (requested_status);
create index IX_978CBEB9 on vw_registration_overtime (root_id);
create index IX_DF76BD70 on vw_registration_overtime (user_id);

create index IX_F548729 on vw_registration_overtime_approval (org_id);
create index IX_6FA46137 on vw_registration_overtime_approval (requested_at);
create index IX_6FA4E85B on vw_registration_overtime_approval (requested_by);
create index IX_8519836 on vw_registration_overtime_approval (requested_status);
create index IX_2AE3F9C9 on vw_registration_overtime_approval (root_id);

create index IX_EB4B015E on vw_report_overtime (org_id);
create index IX_535722A2 on vw_report_overtime (report_id);
create index IX_ECA04FB on vw_report_overtime (reported_at);
create index IX_ECA8C1F on vw_report_overtime (reported_by);
create index IX_90B7B9FA on vw_report_overtime (reported_status);
create index IX_CDBCC634 on vw_report_overtime (root_id);

create index IX_316EE3A4 on vw_report_overtime_approval (org_id);
create index IX_45369E75 on vw_report_overtime_approval (reported_at);
create index IX_45372599 on vw_report_overtime_approval (reported_by);
create index IX_23E70674 on vw_report_overtime_approval (reported_status);
create index IX_4C152CAE on vw_report_overtime_approval (root_id);

create index IX_2237AD4E on vw_staff_mapping (bod_id);
create index IX_5F6974F9 on vw_staff_mapping (pm_uid);
create index IX_D23573B1 on vw_staff_mapping (root_id);
create index IX_D351C8A on vw_staff_mapping (staff_uid);

create index IX_744D31E1 on vw_staff_root_org (bod_id);
create index IX_5E8DB4D4 on vw_staff_root_org (org_id);
create index IX_C2D0817E on vw_staff_root_org (root_id);

create index IX_68617625 on vw_staff_root_org_fn_ordered (fullname);
create index IX_E2D54421 on vw_staff_root_org_fn_ordered (org_id);
create index IX_C77ADBD1 on vw_staff_root_org_fn_ordered (root_id);
create index IX_F64DA88 on vw_staff_root_org_fn_ordered (user_id);

create index IX_ED8BF489 on vw_staff_root_org_fullname (fullname);
create index IX_DC940B85 on vw_staff_root_org_fullname (org_id);
create index IX_59500ED on vw_staff_root_org_fullname (root_id);
create index IX_4D7EFFA4 on vw_staff_root_org_fullname (user_id);

create index IX_83F24C02 on vw_timechange_request_user_ (requested_by);
create index IX_1452A9C2 on vw_timechange_request_user_ (root_id);

create index IX_A0B93141 on vw_working_calendar (day_type);
create index IX_B714E5AE on vw_working_calendar (day_value);
create index IX_A302938 on vw_working_calendar (root_id);