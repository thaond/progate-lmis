/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import larion.progate.service.CountryLocalService;
import larion.progate.service.CountryService;
import larion.progate.service.OrgObjectApprovalLocalService;
import larion.progate.service.OrgObjectApprovalService;
import larion.progate.service.OrgObjectListLocalService;
import larion.progate.service.OrgObjectListService;
import larion.progate.service.OrgObjectMeasureLocalService;
import larion.progate.service.OrgObjectMeasureService;
import larion.progate.service.OrgObjectObjectiveLocalService;
import larion.progate.service.OrgObjectObjectiveService;
import larion.progate.service.OrgObjectPerspectiveLocalService;
import larion.progate.service.OrgObjectPerspectiveService;
import larion.progate.service.OrgObjectTargetsLocalService;
import larion.progate.service.OrgObjectTargetsService;
import larion.progate.service.OrganizationLocalService;
import larion.progate.service.OrganizationService;
import larion.progate.service.OrganizationViewLocalService;
import larion.progate.service.OrganizationViewService;
import larion.progate.service.ProGateApplicationsLocalService;
import larion.progate.service.ProGateApplicationsService;
import larion.progate.service.ProGateCurrencyTypesLocalService;
import larion.progate.service.ProGateCurrencyTypesService;
import larion.progate.service.ProGateJournalArticleLocalService;
import larion.progate.service.ProGateJournalArticlePrioritiesLocalService;
import larion.progate.service.ProGateJournalArticlePrioritiesService;
import larion.progate.service.ProGateJournalArticleService;
import larion.progate.service.ProGateJournalArticleSlideShowLocalService;
import larion.progate.service.ProGateJournalArticleSlideShowService;
import larion.progate.service.ProGateJournalArticleTypesLocalService;
import larion.progate.service.ProGateJournalArticleTypesService;
import larion.progate.service.ProGateJournalArticleViewLocalService;
import larion.progate.service.ProGateJournalArticleViewService;
import larion.progate.service.ProGateMenuViewLocalService;
import larion.progate.service.ProGateMenuViewService;
import larion.progate.service.ProGateOrgCustomerLocalService;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalService;
import larion.progate.service.ProGateOrgCustomerRepresenterService;
import larion.progate.service.ProGateOrgCustomerService;
import larion.progate.service.ProGateOrgTypeLocalService;
import larion.progate.service.ProGateOrgTypeService;
import larion.progate.service.ProGateOrgsUsersPermissionsLocalService;
import larion.progate.service.ProGateOrgsUsersPermissionsService;
import larion.progate.service.ProGatePermissionsLocalService;
import larion.progate.service.ProGatePermissionsService;
import larion.progate.service.ProGateProductsServicesLocalService;
import larion.progate.service.ProGateProductsServicesService;
import larion.progate.service.ProGateRolesLocalService;
import larion.progate.service.ProGateRolesService;
import larion.progate.service.ProGateUserApplicationsLocalService;
import larion.progate.service.ProGateUserApplicationsService;
import larion.progate.service.ProgateApplicationsSettingLocalService;
import larion.progate.service.ProgateApplicationsSettingService;
import larion.progate.service.ProgateLayoutsMenusLocalService;
import larion.progate.service.ProgateLayoutsMenusService;
import larion.progate.service.ProgateLayoutsRolesLocalService;
import larion.progate.service.ProgateLayoutsRolesService;
import larion.progate.service.ProgateMenusLocalService;
import larion.progate.service.ProgateOrganizationParticipantsLocalService;
import larion.progate.service.ProgateOrganizationParticipantsService;
import larion.progate.service.ProgateOrganizationsStaffsLocalService;
import larion.progate.service.ProgateOrganizationsStaffsService;
import larion.progate.service.ProgatePortalMenuLocalService;
import larion.progate.service.ProgatePortalMenuService;
import larion.progate.service.RegionLocalService;
import larion.progate.service.RegionService;
import larion.progate.service.UserInformationViewLocalService;
import larion.progate.service.UserInformationViewService;
import larion.progate.service.UserLocalService;
import larion.progate.service.UserService;
import larion.progate.service.ViewOrgUsersPermissionsLocalService;
import larion.progate.service.ViewOrgUsersPermissionsService;
import larion.progate.service.ViewProGatePermissionsRolesLocalService;
import larion.progate.service.ViewProGatePermissionsRolesService;
import larion.progate.service.persistence.CountryPersistence;
import larion.progate.service.persistence.OrgObjectApprovalPersistence;
import larion.progate.service.persistence.OrgObjectListPersistence;
import larion.progate.service.persistence.OrgObjectMeasurePersistence;
import larion.progate.service.persistence.OrgObjectObjectivePersistence;
import larion.progate.service.persistence.OrgObjectPerspectivePersistence;
import larion.progate.service.persistence.OrgObjectTargetsPersistence;
import larion.progate.service.persistence.OrganizationFinder;
import larion.progate.service.persistence.OrganizationPersistence;
import larion.progate.service.persistence.OrganizationViewPersistence;
import larion.progate.service.persistence.ProGateApplicationsPersistence;
import larion.progate.service.persistence.ProGateCurrencyTypesPersistence;
import larion.progate.service.persistence.ProGateJournalArticlePersistence;
import larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence;
import larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence;
import larion.progate.service.persistence.ProGateJournalArticleTypesPersistence;
import larion.progate.service.persistence.ProGateJournalArticleViewPersistence;
import larion.progate.service.persistence.ProGateMenuViewPersistence;
import larion.progate.service.persistence.ProGateOrgCustomerPersistence;
import larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence;
import larion.progate.service.persistence.ProGateOrgTypePersistence;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsFinder;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence;
import larion.progate.service.persistence.ProGatePermissionsPersistence;
import larion.progate.service.persistence.ProGateProductsServicesPersistence;
import larion.progate.service.persistence.ProGateRolesPersistence;
import larion.progate.service.persistence.ProGateUserApplicationsPersistence;
import larion.progate.service.persistence.ProgateApplicationsSettingPersistence;
import larion.progate.service.persistence.ProgateLayoutsMenusPersistence;
import larion.progate.service.persistence.ProgateLayoutsRolesPersistence;
import larion.progate.service.persistence.ProgateMenusPersistence;
import larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence;
import larion.progate.service.persistence.ProgateOrganizationsStaffsFinder;
import larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence;
import larion.progate.service.persistence.ProgatePortalMenuPersistence;
import larion.progate.service.persistence.RegionPersistence;
import larion.progate.service.persistence.UserFinder;
import larion.progate.service.persistence.UserInformationViewFinder;
import larion.progate.service.persistence.UserInformationViewPersistence;
import larion.progate.service.persistence.UserPersistence;
import larion.progate.service.persistence.ViewOrgUsersPermissionsFinder;
import larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence;
import larion.progate.service.persistence.ViewProGatePermissionsRolesFinder;
import larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence;

/**
 * <a href="ProGateOrgsUsersPermissionsServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class ProGateOrgsUsersPermissionsServiceBaseImpl
	extends PrincipalBean implements ProGateOrgsUsersPermissionsService {
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public UserFinder getUserFinder() {
		return userFinder;
	}

	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	public UserInformationViewLocalService getUserInformationViewLocalService() {
		return userInformationViewLocalService;
	}

	public void setUserInformationViewLocalService(
		UserInformationViewLocalService userInformationViewLocalService) {
		this.userInformationViewLocalService = userInformationViewLocalService;
	}

	public UserInformationViewService getUserInformationViewService() {
		return userInformationViewService;
	}

	public void setUserInformationViewService(
		UserInformationViewService userInformationViewService) {
		this.userInformationViewService = userInformationViewService;
	}

	public UserInformationViewPersistence getUserInformationViewPersistence() {
		return userInformationViewPersistence;
	}

	public void setUserInformationViewPersistence(
		UserInformationViewPersistence userInformationViewPersistence) {
		this.userInformationViewPersistence = userInformationViewPersistence;
	}

	public UserInformationViewFinder getUserInformationViewFinder() {
		return userInformationViewFinder;
	}

	public void setUserInformationViewFinder(
		UserInformationViewFinder userInformationViewFinder) {
		this.userInformationViewFinder = userInformationViewFinder;
	}

	public OrganizationLocalService getOrganizationLocalService() {
		return organizationLocalService;
	}

	public void setOrganizationLocalService(
		OrganizationLocalService organizationLocalService) {
		this.organizationLocalService = organizationLocalService;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public OrganizationPersistence getOrganizationPersistence() {
		return organizationPersistence;
	}

	public void setOrganizationPersistence(
		OrganizationPersistence organizationPersistence) {
		this.organizationPersistence = organizationPersistence;
	}

	public OrganizationFinder getOrganizationFinder() {
		return organizationFinder;
	}

	public void setOrganizationFinder(OrganizationFinder organizationFinder) {
		this.organizationFinder = organizationFinder;
	}

	public OrganizationViewLocalService getOrganizationViewLocalService() {
		return organizationViewLocalService;
	}

	public void setOrganizationViewLocalService(
		OrganizationViewLocalService organizationViewLocalService) {
		this.organizationViewLocalService = organizationViewLocalService;
	}

	public OrganizationViewService getOrganizationViewService() {
		return organizationViewService;
	}

	public void setOrganizationViewService(
		OrganizationViewService organizationViewService) {
		this.organizationViewService = organizationViewService;
	}

	public OrganizationViewPersistence getOrganizationViewPersistence() {
		return organizationViewPersistence;
	}

	public void setOrganizationViewPersistence(
		OrganizationViewPersistence organizationViewPersistence) {
		this.organizationViewPersistence = organizationViewPersistence;
	}

	public OrgObjectListLocalService getOrgObjectListLocalService() {
		return orgObjectListLocalService;
	}

	public void setOrgObjectListLocalService(
		OrgObjectListLocalService orgObjectListLocalService) {
		this.orgObjectListLocalService = orgObjectListLocalService;
	}

	public OrgObjectListService getOrgObjectListService() {
		return orgObjectListService;
	}

	public void setOrgObjectListService(
		OrgObjectListService orgObjectListService) {
		this.orgObjectListService = orgObjectListService;
	}

	public OrgObjectListPersistence getOrgObjectListPersistence() {
		return orgObjectListPersistence;
	}

	public void setOrgObjectListPersistence(
		OrgObjectListPersistence orgObjectListPersistence) {
		this.orgObjectListPersistence = orgObjectListPersistence;
	}

	public OrgObjectApprovalLocalService getOrgObjectApprovalLocalService() {
		return orgObjectApprovalLocalService;
	}

	public void setOrgObjectApprovalLocalService(
		OrgObjectApprovalLocalService orgObjectApprovalLocalService) {
		this.orgObjectApprovalLocalService = orgObjectApprovalLocalService;
	}

	public OrgObjectApprovalService getOrgObjectApprovalService() {
		return orgObjectApprovalService;
	}

	public void setOrgObjectApprovalService(
		OrgObjectApprovalService orgObjectApprovalService) {
		this.orgObjectApprovalService = orgObjectApprovalService;
	}

	public OrgObjectApprovalPersistence getOrgObjectApprovalPersistence() {
		return orgObjectApprovalPersistence;
	}

	public void setOrgObjectApprovalPersistence(
		OrgObjectApprovalPersistence orgObjectApprovalPersistence) {
		this.orgObjectApprovalPersistence = orgObjectApprovalPersistence;
	}

	public OrgObjectPerspectiveLocalService getOrgObjectPerspectiveLocalService() {
		return orgObjectPerspectiveLocalService;
	}

	public void setOrgObjectPerspectiveLocalService(
		OrgObjectPerspectiveLocalService orgObjectPerspectiveLocalService) {
		this.orgObjectPerspectiveLocalService = orgObjectPerspectiveLocalService;
	}

	public OrgObjectPerspectiveService getOrgObjectPerspectiveService() {
		return orgObjectPerspectiveService;
	}

	public void setOrgObjectPerspectiveService(
		OrgObjectPerspectiveService orgObjectPerspectiveService) {
		this.orgObjectPerspectiveService = orgObjectPerspectiveService;
	}

	public OrgObjectPerspectivePersistence getOrgObjectPerspectivePersistence() {
		return orgObjectPerspectivePersistence;
	}

	public void setOrgObjectPerspectivePersistence(
		OrgObjectPerspectivePersistence orgObjectPerspectivePersistence) {
		this.orgObjectPerspectivePersistence = orgObjectPerspectivePersistence;
	}

	public OrgObjectObjectiveLocalService getOrgObjectObjectiveLocalService() {
		return orgObjectObjectiveLocalService;
	}

	public void setOrgObjectObjectiveLocalService(
		OrgObjectObjectiveLocalService orgObjectObjectiveLocalService) {
		this.orgObjectObjectiveLocalService = orgObjectObjectiveLocalService;
	}

	public OrgObjectObjectiveService getOrgObjectObjectiveService() {
		return orgObjectObjectiveService;
	}

	public void setOrgObjectObjectiveService(
		OrgObjectObjectiveService orgObjectObjectiveService) {
		this.orgObjectObjectiveService = orgObjectObjectiveService;
	}

	public OrgObjectObjectivePersistence getOrgObjectObjectivePersistence() {
		return orgObjectObjectivePersistence;
	}

	public void setOrgObjectObjectivePersistence(
		OrgObjectObjectivePersistence orgObjectObjectivePersistence) {
		this.orgObjectObjectivePersistence = orgObjectObjectivePersistence;
	}

	public OrgObjectMeasureLocalService getOrgObjectMeasureLocalService() {
		return orgObjectMeasureLocalService;
	}

	public void setOrgObjectMeasureLocalService(
		OrgObjectMeasureLocalService orgObjectMeasureLocalService) {
		this.orgObjectMeasureLocalService = orgObjectMeasureLocalService;
	}

	public OrgObjectMeasureService getOrgObjectMeasureService() {
		return orgObjectMeasureService;
	}

	public void setOrgObjectMeasureService(
		OrgObjectMeasureService orgObjectMeasureService) {
		this.orgObjectMeasureService = orgObjectMeasureService;
	}

	public OrgObjectMeasurePersistence getOrgObjectMeasurePersistence() {
		return orgObjectMeasurePersistence;
	}

	public void setOrgObjectMeasurePersistence(
		OrgObjectMeasurePersistence orgObjectMeasurePersistence) {
		this.orgObjectMeasurePersistence = orgObjectMeasurePersistence;
	}

	public OrgObjectTargetsLocalService getOrgObjectTargetsLocalService() {
		return orgObjectTargetsLocalService;
	}

	public void setOrgObjectTargetsLocalService(
		OrgObjectTargetsLocalService orgObjectTargetsLocalService) {
		this.orgObjectTargetsLocalService = orgObjectTargetsLocalService;
	}

	public OrgObjectTargetsService getOrgObjectTargetsService() {
		return orgObjectTargetsService;
	}

	public void setOrgObjectTargetsService(
		OrgObjectTargetsService orgObjectTargetsService) {
		this.orgObjectTargetsService = orgObjectTargetsService;
	}

	public OrgObjectTargetsPersistence getOrgObjectTargetsPersistence() {
		return orgObjectTargetsPersistence;
	}

	public void setOrgObjectTargetsPersistence(
		OrgObjectTargetsPersistence orgObjectTargetsPersistence) {
		this.orgObjectTargetsPersistence = orgObjectTargetsPersistence;
	}

	public ProgatePortalMenuLocalService getProgatePortalMenuLocalService() {
		return progatePortalMenuLocalService;
	}

	public void setProgatePortalMenuLocalService(
		ProgatePortalMenuLocalService progatePortalMenuLocalService) {
		this.progatePortalMenuLocalService = progatePortalMenuLocalService;
	}

	public ProgatePortalMenuService getProgatePortalMenuService() {
		return progatePortalMenuService;
	}

	public void setProgatePortalMenuService(
		ProgatePortalMenuService progatePortalMenuService) {
		this.progatePortalMenuService = progatePortalMenuService;
	}

	public ProgatePortalMenuPersistence getProgatePortalMenuPersistence() {
		return progatePortalMenuPersistence;
	}

	public void setProgatePortalMenuPersistence(
		ProgatePortalMenuPersistence progatePortalMenuPersistence) {
		this.progatePortalMenuPersistence = progatePortalMenuPersistence;
	}

	public ProGateRolesLocalService getProGateRolesLocalService() {
		return proGateRolesLocalService;
	}

	public void setProGateRolesLocalService(
		ProGateRolesLocalService proGateRolesLocalService) {
		this.proGateRolesLocalService = proGateRolesLocalService;
	}

	public ProGateRolesService getProGateRolesService() {
		return proGateRolesService;
	}

	public void setProGateRolesService(ProGateRolesService proGateRolesService) {
		this.proGateRolesService = proGateRolesService;
	}

	public ProGateRolesPersistence getProGateRolesPersistence() {
		return proGateRolesPersistence;
	}

	public void setProGateRolesPersistence(
		ProGateRolesPersistence proGateRolesPersistence) {
		this.proGateRolesPersistence = proGateRolesPersistence;
	}

	public ProGateOrgTypeLocalService getProGateOrgTypeLocalService() {
		return proGateOrgTypeLocalService;
	}

	public void setProGateOrgTypeLocalService(
		ProGateOrgTypeLocalService proGateOrgTypeLocalService) {
		this.proGateOrgTypeLocalService = proGateOrgTypeLocalService;
	}

	public ProGateOrgTypeService getProGateOrgTypeService() {
		return proGateOrgTypeService;
	}

	public void setProGateOrgTypeService(
		ProGateOrgTypeService proGateOrgTypeService) {
		this.proGateOrgTypeService = proGateOrgTypeService;
	}

	public ProGateOrgTypePersistence getProGateOrgTypePersistence() {
		return proGateOrgTypePersistence;
	}

	public void setProGateOrgTypePersistence(
		ProGateOrgTypePersistence proGateOrgTypePersistence) {
		this.proGateOrgTypePersistence = proGateOrgTypePersistence;
	}

	public ProGateJournalArticleLocalService getProGateJournalArticleLocalService() {
		return proGateJournalArticleLocalService;
	}

	public void setProGateJournalArticleLocalService(
		ProGateJournalArticleLocalService proGateJournalArticleLocalService) {
		this.proGateJournalArticleLocalService = proGateJournalArticleLocalService;
	}

	public ProGateJournalArticleService getProGateJournalArticleService() {
		return proGateJournalArticleService;
	}

	public void setProGateJournalArticleService(
		ProGateJournalArticleService proGateJournalArticleService) {
		this.proGateJournalArticleService = proGateJournalArticleService;
	}

	public ProGateJournalArticlePersistence getProGateJournalArticlePersistence() {
		return proGateJournalArticlePersistence;
	}

	public void setProGateJournalArticlePersistence(
		ProGateJournalArticlePersistence proGateJournalArticlePersistence) {
		this.proGateJournalArticlePersistence = proGateJournalArticlePersistence;
	}

	public ProGateProductsServicesLocalService getProGateProductsServicesLocalService() {
		return proGateProductsServicesLocalService;
	}

	public void setProGateProductsServicesLocalService(
		ProGateProductsServicesLocalService proGateProductsServicesLocalService) {
		this.proGateProductsServicesLocalService = proGateProductsServicesLocalService;
	}

	public ProGateProductsServicesService getProGateProductsServicesService() {
		return proGateProductsServicesService;
	}

	public void setProGateProductsServicesService(
		ProGateProductsServicesService proGateProductsServicesService) {
		this.proGateProductsServicesService = proGateProductsServicesService;
	}

	public ProGateProductsServicesPersistence getProGateProductsServicesPersistence() {
		return proGateProductsServicesPersistence;
	}

	public void setProGateProductsServicesPersistence(
		ProGateProductsServicesPersistence proGateProductsServicesPersistence) {
		this.proGateProductsServicesPersistence = proGateProductsServicesPersistence;
	}

	public ProGateCurrencyTypesLocalService getProGateCurrencyTypesLocalService() {
		return proGateCurrencyTypesLocalService;
	}

	public void setProGateCurrencyTypesLocalService(
		ProGateCurrencyTypesLocalService proGateCurrencyTypesLocalService) {
		this.proGateCurrencyTypesLocalService = proGateCurrencyTypesLocalService;
	}

	public ProGateCurrencyTypesService getProGateCurrencyTypesService() {
		return proGateCurrencyTypesService;
	}

	public void setProGateCurrencyTypesService(
		ProGateCurrencyTypesService proGateCurrencyTypesService) {
		this.proGateCurrencyTypesService = proGateCurrencyTypesService;
	}

	public ProGateCurrencyTypesPersistence getProGateCurrencyTypesPersistence() {
		return proGateCurrencyTypesPersistence;
	}

	public void setProGateCurrencyTypesPersistence(
		ProGateCurrencyTypesPersistence proGateCurrencyTypesPersistence) {
		this.proGateCurrencyTypesPersistence = proGateCurrencyTypesPersistence;
	}

	public ProGateJournalArticlePrioritiesLocalService getProGateJournalArticlePrioritiesLocalService() {
		return proGateJournalArticlePrioritiesLocalService;
	}

	public void setProGateJournalArticlePrioritiesLocalService(
		ProGateJournalArticlePrioritiesLocalService proGateJournalArticlePrioritiesLocalService) {
		this.proGateJournalArticlePrioritiesLocalService = proGateJournalArticlePrioritiesLocalService;
	}

	public ProGateJournalArticlePrioritiesService getProGateJournalArticlePrioritiesService() {
		return proGateJournalArticlePrioritiesService;
	}

	public void setProGateJournalArticlePrioritiesService(
		ProGateJournalArticlePrioritiesService proGateJournalArticlePrioritiesService) {
		this.proGateJournalArticlePrioritiesService = proGateJournalArticlePrioritiesService;
	}

	public ProGateJournalArticlePrioritiesPersistence getProGateJournalArticlePrioritiesPersistence() {
		return proGateJournalArticlePrioritiesPersistence;
	}

	public void setProGateJournalArticlePrioritiesPersistence(
		ProGateJournalArticlePrioritiesPersistence proGateJournalArticlePrioritiesPersistence) {
		this.proGateJournalArticlePrioritiesPersistence = proGateJournalArticlePrioritiesPersistence;
	}

	public ProGateJournalArticleTypesLocalService getProGateJournalArticleTypesLocalService() {
		return proGateJournalArticleTypesLocalService;
	}

	public void setProGateJournalArticleTypesLocalService(
		ProGateJournalArticleTypesLocalService proGateJournalArticleTypesLocalService) {
		this.proGateJournalArticleTypesLocalService = proGateJournalArticleTypesLocalService;
	}

	public ProGateJournalArticleTypesService getProGateJournalArticleTypesService() {
		return proGateJournalArticleTypesService;
	}

	public void setProGateJournalArticleTypesService(
		ProGateJournalArticleTypesService proGateJournalArticleTypesService) {
		this.proGateJournalArticleTypesService = proGateJournalArticleTypesService;
	}

	public ProGateJournalArticleTypesPersistence getProGateJournalArticleTypesPersistence() {
		return proGateJournalArticleTypesPersistence;
	}

	public void setProGateJournalArticleTypesPersistence(
		ProGateJournalArticleTypesPersistence proGateJournalArticleTypesPersistence) {
		this.proGateJournalArticleTypesPersistence = proGateJournalArticleTypesPersistence;
	}

	public RegionLocalService getRegionLocalService() {
		return regionLocalService;
	}

	public void setRegionLocalService(RegionLocalService regionLocalService) {
		this.regionLocalService = regionLocalService;
	}

	public RegionService getRegionService() {
		return regionService;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public RegionPersistence getRegionPersistence() {
		return regionPersistence;
	}

	public void setRegionPersistence(RegionPersistence regionPersistence) {
		this.regionPersistence = regionPersistence;
	}

	public CountryLocalService getCountryLocalService() {
		return countryLocalService;
	}

	public void setCountryLocalService(CountryLocalService countryLocalService) {
		this.countryLocalService = countryLocalService;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public CountryPersistence getCountryPersistence() {
		return countryPersistence;
	}

	public void setCountryPersistence(CountryPersistence countryPersistence) {
		this.countryPersistence = countryPersistence;
	}

	public ProGateJournalArticleViewLocalService getProGateJournalArticleViewLocalService() {
		return proGateJournalArticleViewLocalService;
	}

	public void setProGateJournalArticleViewLocalService(
		ProGateJournalArticleViewLocalService proGateJournalArticleViewLocalService) {
		this.proGateJournalArticleViewLocalService = proGateJournalArticleViewLocalService;
	}

	public ProGateJournalArticleViewService getProGateJournalArticleViewService() {
		return proGateJournalArticleViewService;
	}

	public void setProGateJournalArticleViewService(
		ProGateJournalArticleViewService proGateJournalArticleViewService) {
		this.proGateJournalArticleViewService = proGateJournalArticleViewService;
	}

	public ProGateJournalArticleViewPersistence getProGateJournalArticleViewPersistence() {
		return proGateJournalArticleViewPersistence;
	}

	public void setProGateJournalArticleViewPersistence(
		ProGateJournalArticleViewPersistence proGateJournalArticleViewPersistence) {
		this.proGateJournalArticleViewPersistence = proGateJournalArticleViewPersistence;
	}

	public ProGateJournalArticleSlideShowLocalService getProGateJournalArticleSlideShowLocalService() {
		return proGateJournalArticleSlideShowLocalService;
	}

	public void setProGateJournalArticleSlideShowLocalService(
		ProGateJournalArticleSlideShowLocalService proGateJournalArticleSlideShowLocalService) {
		this.proGateJournalArticleSlideShowLocalService = proGateJournalArticleSlideShowLocalService;
	}

	public ProGateJournalArticleSlideShowService getProGateJournalArticleSlideShowService() {
		return proGateJournalArticleSlideShowService;
	}

	public void setProGateJournalArticleSlideShowService(
		ProGateJournalArticleSlideShowService proGateJournalArticleSlideShowService) {
		this.proGateJournalArticleSlideShowService = proGateJournalArticleSlideShowService;
	}

	public ProGateJournalArticleSlideShowPersistence getProGateJournalArticleSlideShowPersistence() {
		return proGateJournalArticleSlideShowPersistence;
	}

	public void setProGateJournalArticleSlideShowPersistence(
		ProGateJournalArticleSlideShowPersistence proGateJournalArticleSlideShowPersistence) {
		this.proGateJournalArticleSlideShowPersistence = proGateJournalArticleSlideShowPersistence;
	}

	public ProGateOrgCustomerLocalService getProGateOrgCustomerLocalService() {
		return proGateOrgCustomerLocalService;
	}

	public void setProGateOrgCustomerLocalService(
		ProGateOrgCustomerLocalService proGateOrgCustomerLocalService) {
		this.proGateOrgCustomerLocalService = proGateOrgCustomerLocalService;
	}

	public ProGateOrgCustomerService getProGateOrgCustomerService() {
		return proGateOrgCustomerService;
	}

	public void setProGateOrgCustomerService(
		ProGateOrgCustomerService proGateOrgCustomerService) {
		this.proGateOrgCustomerService = proGateOrgCustomerService;
	}

	public ProGateOrgCustomerPersistence getProGateOrgCustomerPersistence() {
		return proGateOrgCustomerPersistence;
	}

	public void setProGateOrgCustomerPersistence(
		ProGateOrgCustomerPersistence proGateOrgCustomerPersistence) {
		this.proGateOrgCustomerPersistence = proGateOrgCustomerPersistence;
	}

	public ProGateOrgCustomerRepresenterLocalService getProGateOrgCustomerRepresenterLocalService() {
		return proGateOrgCustomerRepresenterLocalService;
	}

	public void setProGateOrgCustomerRepresenterLocalService(
		ProGateOrgCustomerRepresenterLocalService proGateOrgCustomerRepresenterLocalService) {
		this.proGateOrgCustomerRepresenterLocalService = proGateOrgCustomerRepresenterLocalService;
	}

	public ProGateOrgCustomerRepresenterService getProGateOrgCustomerRepresenterService() {
		return proGateOrgCustomerRepresenterService;
	}

	public void setProGateOrgCustomerRepresenterService(
		ProGateOrgCustomerRepresenterService proGateOrgCustomerRepresenterService) {
		this.proGateOrgCustomerRepresenterService = proGateOrgCustomerRepresenterService;
	}

	public ProGateOrgCustomerRepresenterPersistence getProGateOrgCustomerRepresenterPersistence() {
		return proGateOrgCustomerRepresenterPersistence;
	}

	public void setProGateOrgCustomerRepresenterPersistence(
		ProGateOrgCustomerRepresenterPersistence proGateOrgCustomerRepresenterPersistence) {
		this.proGateOrgCustomerRepresenterPersistence = proGateOrgCustomerRepresenterPersistence;
	}

	public ProGateApplicationsLocalService getProGateApplicationsLocalService() {
		return proGateApplicationsLocalService;
	}

	public void setProGateApplicationsLocalService(
		ProGateApplicationsLocalService proGateApplicationsLocalService) {
		this.proGateApplicationsLocalService = proGateApplicationsLocalService;
	}

	public ProGateApplicationsService getProGateApplicationsService() {
		return proGateApplicationsService;
	}

	public void setProGateApplicationsService(
		ProGateApplicationsService proGateApplicationsService) {
		this.proGateApplicationsService = proGateApplicationsService;
	}

	public ProGateApplicationsPersistence getProGateApplicationsPersistence() {
		return proGateApplicationsPersistence;
	}

	public void setProGateApplicationsPersistence(
		ProGateApplicationsPersistence proGateApplicationsPersistence) {
		this.proGateApplicationsPersistence = proGateApplicationsPersistence;
	}

	public ProGateUserApplicationsLocalService getProGateUserApplicationsLocalService() {
		return proGateUserApplicationsLocalService;
	}

	public void setProGateUserApplicationsLocalService(
		ProGateUserApplicationsLocalService proGateUserApplicationsLocalService) {
		this.proGateUserApplicationsLocalService = proGateUserApplicationsLocalService;
	}

	public ProGateUserApplicationsService getProGateUserApplicationsService() {
		return proGateUserApplicationsService;
	}

	public void setProGateUserApplicationsService(
		ProGateUserApplicationsService proGateUserApplicationsService) {
		this.proGateUserApplicationsService = proGateUserApplicationsService;
	}

	public ProGateUserApplicationsPersistence getProGateUserApplicationsPersistence() {
		return proGateUserApplicationsPersistence;
	}

	public void setProGateUserApplicationsPersistence(
		ProGateUserApplicationsPersistence proGateUserApplicationsPersistence) {
		this.proGateUserApplicationsPersistence = proGateUserApplicationsPersistence;
	}

	public ProgateOrganizationParticipantsLocalService getProgateOrganizationParticipantsLocalService() {
		return progateOrganizationParticipantsLocalService;
	}

	public void setProgateOrganizationParticipantsLocalService(
		ProgateOrganizationParticipantsLocalService progateOrganizationParticipantsLocalService) {
		this.progateOrganizationParticipantsLocalService = progateOrganizationParticipantsLocalService;
	}

	public ProgateOrganizationParticipantsService getProgateOrganizationParticipantsService() {
		return progateOrganizationParticipantsService;
	}

	public void setProgateOrganizationParticipantsService(
		ProgateOrganizationParticipantsService progateOrganizationParticipantsService) {
		this.progateOrganizationParticipantsService = progateOrganizationParticipantsService;
	}

	public ProgateOrganizationParticipantsPersistence getProgateOrganizationParticipantsPersistence() {
		return progateOrganizationParticipantsPersistence;
	}

	public void setProgateOrganizationParticipantsPersistence(
		ProgateOrganizationParticipantsPersistence progateOrganizationParticipantsPersistence) {
		this.progateOrganizationParticipantsPersistence = progateOrganizationParticipantsPersistence;
	}

	public ProgateOrganizationsStaffsLocalService getProgateOrganizationsStaffsLocalService() {
		return progateOrganizationsStaffsLocalService;
	}

	public void setProgateOrganizationsStaffsLocalService(
		ProgateOrganizationsStaffsLocalService progateOrganizationsStaffsLocalService) {
		this.progateOrganizationsStaffsLocalService = progateOrganizationsStaffsLocalService;
	}

	public ProgateOrganizationsStaffsService getProgateOrganizationsStaffsService() {
		return progateOrganizationsStaffsService;
	}

	public void setProgateOrganizationsStaffsService(
		ProgateOrganizationsStaffsService progateOrganizationsStaffsService) {
		this.progateOrganizationsStaffsService = progateOrganizationsStaffsService;
	}

	public ProgateOrganizationsStaffsPersistence getProgateOrganizationsStaffsPersistence() {
		return progateOrganizationsStaffsPersistence;
	}

	public void setProgateOrganizationsStaffsPersistence(
		ProgateOrganizationsStaffsPersistence progateOrganizationsStaffsPersistence) {
		this.progateOrganizationsStaffsPersistence = progateOrganizationsStaffsPersistence;
	}

	public ProgateOrganizationsStaffsFinder getProgateOrganizationsStaffsFinder() {
		return progateOrganizationsStaffsFinder;
	}

	public void setProgateOrganizationsStaffsFinder(
		ProgateOrganizationsStaffsFinder progateOrganizationsStaffsFinder) {
		this.progateOrganizationsStaffsFinder = progateOrganizationsStaffsFinder;
	}

	public ProgateApplicationsSettingLocalService getProgateApplicationsSettingLocalService() {
		return progateApplicationsSettingLocalService;
	}

	public void setProgateApplicationsSettingLocalService(
		ProgateApplicationsSettingLocalService progateApplicationsSettingLocalService) {
		this.progateApplicationsSettingLocalService = progateApplicationsSettingLocalService;
	}

	public ProgateApplicationsSettingService getProgateApplicationsSettingService() {
		return progateApplicationsSettingService;
	}

	public void setProgateApplicationsSettingService(
		ProgateApplicationsSettingService progateApplicationsSettingService) {
		this.progateApplicationsSettingService = progateApplicationsSettingService;
	}

	public ProgateApplicationsSettingPersistence getProgateApplicationsSettingPersistence() {
		return progateApplicationsSettingPersistence;
	}

	public void setProgateApplicationsSettingPersistence(
		ProgateApplicationsSettingPersistence progateApplicationsSettingPersistence) {
		this.progateApplicationsSettingPersistence = progateApplicationsSettingPersistence;
	}

	public ProgateMenusLocalService getProgateMenusLocalService() {
		return progateMenusLocalService;
	}

	public void setProgateMenusLocalService(
		ProgateMenusLocalService progateMenusLocalService) {
		this.progateMenusLocalService = progateMenusLocalService;
	}

	public ProgateMenusPersistence getProgateMenusPersistence() {
		return progateMenusPersistence;
	}

	public void setProgateMenusPersistence(
		ProgateMenusPersistence progateMenusPersistence) {
		this.progateMenusPersistence = progateMenusPersistence;
	}

	public ProgateLayoutsRolesLocalService getProgateLayoutsRolesLocalService() {
		return progateLayoutsRolesLocalService;
	}

	public void setProgateLayoutsRolesLocalService(
		ProgateLayoutsRolesLocalService progateLayoutsRolesLocalService) {
		this.progateLayoutsRolesLocalService = progateLayoutsRolesLocalService;
	}

	public ProgateLayoutsRolesService getProgateLayoutsRolesService() {
		return progateLayoutsRolesService;
	}

	public void setProgateLayoutsRolesService(
		ProgateLayoutsRolesService progateLayoutsRolesService) {
		this.progateLayoutsRolesService = progateLayoutsRolesService;
	}

	public ProgateLayoutsRolesPersistence getProgateLayoutsRolesPersistence() {
		return progateLayoutsRolesPersistence;
	}

	public void setProgateLayoutsRolesPersistence(
		ProgateLayoutsRolesPersistence progateLayoutsRolesPersistence) {
		this.progateLayoutsRolesPersistence = progateLayoutsRolesPersistence;
	}

	public ProgateLayoutsMenusLocalService getProgateLayoutsMenusLocalService() {
		return progateLayoutsMenusLocalService;
	}

	public void setProgateLayoutsMenusLocalService(
		ProgateLayoutsMenusLocalService progateLayoutsMenusLocalService) {
		this.progateLayoutsMenusLocalService = progateLayoutsMenusLocalService;
	}

	public ProgateLayoutsMenusService getProgateLayoutsMenusService() {
		return progateLayoutsMenusService;
	}

	public void setProgateLayoutsMenusService(
		ProgateLayoutsMenusService progateLayoutsMenusService) {
		this.progateLayoutsMenusService = progateLayoutsMenusService;
	}

	public ProgateLayoutsMenusPersistence getProgateLayoutsMenusPersistence() {
		return progateLayoutsMenusPersistence;
	}

	public void setProgateLayoutsMenusPersistence(
		ProgateLayoutsMenusPersistence progateLayoutsMenusPersistence) {
		this.progateLayoutsMenusPersistence = progateLayoutsMenusPersistence;
	}

	public ProGateMenuViewLocalService getProGateMenuViewLocalService() {
		return proGateMenuViewLocalService;
	}

	public void setProGateMenuViewLocalService(
		ProGateMenuViewLocalService proGateMenuViewLocalService) {
		this.proGateMenuViewLocalService = proGateMenuViewLocalService;
	}

	public ProGateMenuViewService getProGateMenuViewService() {
		return proGateMenuViewService;
	}

	public void setProGateMenuViewService(
		ProGateMenuViewService proGateMenuViewService) {
		this.proGateMenuViewService = proGateMenuViewService;
	}

	public ProGateMenuViewPersistence getProGateMenuViewPersistence() {
		return proGateMenuViewPersistence;
	}

	public void setProGateMenuViewPersistence(
		ProGateMenuViewPersistence proGateMenuViewPersistence) {
		this.proGateMenuViewPersistence = proGateMenuViewPersistence;
	}

	public ProGateOrgsUsersPermissionsLocalService getProGateOrgsUsersPermissionsLocalService() {
		return proGateOrgsUsersPermissionsLocalService;
	}

	public void setProGateOrgsUsersPermissionsLocalService(
		ProGateOrgsUsersPermissionsLocalService proGateOrgsUsersPermissionsLocalService) {
		this.proGateOrgsUsersPermissionsLocalService = proGateOrgsUsersPermissionsLocalService;
	}

	public ProGateOrgsUsersPermissionsService getProGateOrgsUsersPermissionsService() {
		return proGateOrgsUsersPermissionsService;
	}

	public void setProGateOrgsUsersPermissionsService(
		ProGateOrgsUsersPermissionsService proGateOrgsUsersPermissionsService) {
		this.proGateOrgsUsersPermissionsService = proGateOrgsUsersPermissionsService;
	}

	public ProGateOrgsUsersPermissionsPersistence getProGateOrgsUsersPermissionsPersistence() {
		return proGateOrgsUsersPermissionsPersistence;
	}

	public void setProGateOrgsUsersPermissionsPersistence(
		ProGateOrgsUsersPermissionsPersistence proGateOrgsUsersPermissionsPersistence) {
		this.proGateOrgsUsersPermissionsPersistence = proGateOrgsUsersPermissionsPersistence;
	}

	public ProGateOrgsUsersPermissionsFinder getProGateOrgsUsersPermissionsFinder() {
		return proGateOrgsUsersPermissionsFinder;
	}

	public void setProGateOrgsUsersPermissionsFinder(
		ProGateOrgsUsersPermissionsFinder proGateOrgsUsersPermissionsFinder) {
		this.proGateOrgsUsersPermissionsFinder = proGateOrgsUsersPermissionsFinder;
	}

	public ProGatePermissionsLocalService getProGatePermissionsLocalService() {
		return proGatePermissionsLocalService;
	}

	public void setProGatePermissionsLocalService(
		ProGatePermissionsLocalService proGatePermissionsLocalService) {
		this.proGatePermissionsLocalService = proGatePermissionsLocalService;
	}

	public ProGatePermissionsService getProGatePermissionsService() {
		return proGatePermissionsService;
	}

	public void setProGatePermissionsService(
		ProGatePermissionsService proGatePermissionsService) {
		this.proGatePermissionsService = proGatePermissionsService;
	}

	public ProGatePermissionsPersistence getProGatePermissionsPersistence() {
		return proGatePermissionsPersistence;
	}

	public void setProGatePermissionsPersistence(
		ProGatePermissionsPersistence proGatePermissionsPersistence) {
		this.proGatePermissionsPersistence = proGatePermissionsPersistence;
	}

	public ViewOrgUsersPermissionsLocalService getViewOrgUsersPermissionsLocalService() {
		return viewOrgUsersPermissionsLocalService;
	}

	public void setViewOrgUsersPermissionsLocalService(
		ViewOrgUsersPermissionsLocalService viewOrgUsersPermissionsLocalService) {
		this.viewOrgUsersPermissionsLocalService = viewOrgUsersPermissionsLocalService;
	}

	public ViewOrgUsersPermissionsService getViewOrgUsersPermissionsService() {
		return viewOrgUsersPermissionsService;
	}

	public void setViewOrgUsersPermissionsService(
		ViewOrgUsersPermissionsService viewOrgUsersPermissionsService) {
		this.viewOrgUsersPermissionsService = viewOrgUsersPermissionsService;
	}

	public ViewOrgUsersPermissionsPersistence getViewOrgUsersPermissionsPersistence() {
		return viewOrgUsersPermissionsPersistence;
	}

	public void setViewOrgUsersPermissionsPersistence(
		ViewOrgUsersPermissionsPersistence viewOrgUsersPermissionsPersistence) {
		this.viewOrgUsersPermissionsPersistence = viewOrgUsersPermissionsPersistence;
	}

	public ViewOrgUsersPermissionsFinder getViewOrgUsersPermissionsFinder() {
		return viewOrgUsersPermissionsFinder;
	}

	public void setViewOrgUsersPermissionsFinder(
		ViewOrgUsersPermissionsFinder viewOrgUsersPermissionsFinder) {
		this.viewOrgUsersPermissionsFinder = viewOrgUsersPermissionsFinder;
	}

	public ViewProGatePermissionsRolesLocalService getViewProGatePermissionsRolesLocalService() {
		return viewProGatePermissionsRolesLocalService;
	}

	public void setViewProGatePermissionsRolesLocalService(
		ViewProGatePermissionsRolesLocalService viewProGatePermissionsRolesLocalService) {
		this.viewProGatePermissionsRolesLocalService = viewProGatePermissionsRolesLocalService;
	}

	public ViewProGatePermissionsRolesService getViewProGatePermissionsRolesService() {
		return viewProGatePermissionsRolesService;
	}

	public void setViewProGatePermissionsRolesService(
		ViewProGatePermissionsRolesService viewProGatePermissionsRolesService) {
		this.viewProGatePermissionsRolesService = viewProGatePermissionsRolesService;
	}

	public ViewProGatePermissionsRolesPersistence getViewProGatePermissionsRolesPersistence() {
		return viewProGatePermissionsRolesPersistence;
	}

	public void setViewProGatePermissionsRolesPersistence(
		ViewProGatePermissionsRolesPersistence viewProGatePermissionsRolesPersistence) {
		this.viewProGatePermissionsRolesPersistence = viewProGatePermissionsRolesPersistence;
	}

	public ViewProGatePermissionsRolesFinder getViewProGatePermissionsRolesFinder() {
		return viewProGatePermissionsRolesFinder;
	}

	public void setViewProGatePermissionsRolesFinder(
		ViewProGatePermissionsRolesFinder viewProGatePermissionsRolesFinder) {
		this.viewProGatePermissionsRolesFinder = viewProGatePermissionsRolesFinder;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "larion.progate.service.UserLocalService.impl")
	protected UserLocalService userLocalService;
	@BeanReference(name = "larion.progate.service.UserService.impl")
	protected UserService userService;
	@BeanReference(name = "larion.progate.service.persistence.UserPersistence.impl")
	protected UserPersistence userPersistence;
	@BeanReference(name = "larion.progate.service.persistence.UserFinder.impl")
	protected UserFinder userFinder;
	@BeanReference(name = "larion.progate.service.UserInformationViewLocalService.impl")
	protected UserInformationViewLocalService userInformationViewLocalService;
	@BeanReference(name = "larion.progate.service.UserInformationViewService.impl")
	protected UserInformationViewService userInformationViewService;
	@BeanReference(name = "larion.progate.service.persistence.UserInformationViewPersistence.impl")
	protected UserInformationViewPersistence userInformationViewPersistence;
	@BeanReference(name = "larion.progate.service.persistence.UserInformationViewFinder.impl")
	protected UserInformationViewFinder userInformationViewFinder;
	@BeanReference(name = "larion.progate.service.OrganizationLocalService.impl")
	protected OrganizationLocalService organizationLocalService;
	@BeanReference(name = "larion.progate.service.OrganizationService.impl")
	protected OrganizationService organizationService;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationPersistence.impl")
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationFinder.impl")
	protected OrganizationFinder organizationFinder;
	@BeanReference(name = "larion.progate.service.OrganizationViewLocalService.impl")
	protected OrganizationViewLocalService organizationViewLocalService;
	@BeanReference(name = "larion.progate.service.OrganizationViewService.impl")
	protected OrganizationViewService organizationViewService;
	@BeanReference(name = "larion.progate.service.persistence.OrganizationViewPersistence.impl")
	protected OrganizationViewPersistence organizationViewPersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectListLocalService.impl")
	protected OrgObjectListLocalService orgObjectListLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectListService.impl")
	protected OrgObjectListService orgObjectListService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectListPersistence.impl")
	protected OrgObjectListPersistence orgObjectListPersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectApprovalLocalService.impl")
	protected OrgObjectApprovalLocalService orgObjectApprovalLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectApprovalService.impl")
	protected OrgObjectApprovalService orgObjectApprovalService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectApprovalPersistence.impl")
	protected OrgObjectApprovalPersistence orgObjectApprovalPersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectPerspectiveLocalService.impl")
	protected OrgObjectPerspectiveLocalService orgObjectPerspectiveLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectPerspectiveService.impl")
	protected OrgObjectPerspectiveService orgObjectPerspectiveService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectPerspectivePersistence.impl")
	protected OrgObjectPerspectivePersistence orgObjectPerspectivePersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectObjectiveLocalService.impl")
	protected OrgObjectObjectiveLocalService orgObjectObjectiveLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectObjectiveService.impl")
	protected OrgObjectObjectiveService orgObjectObjectiveService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectObjectivePersistence.impl")
	protected OrgObjectObjectivePersistence orgObjectObjectivePersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectMeasureLocalService.impl")
	protected OrgObjectMeasureLocalService orgObjectMeasureLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectMeasureService.impl")
	protected OrgObjectMeasureService orgObjectMeasureService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectMeasurePersistence.impl")
	protected OrgObjectMeasurePersistence orgObjectMeasurePersistence;
	@BeanReference(name = "larion.progate.service.OrgObjectTargetsLocalService.impl")
	protected OrgObjectTargetsLocalService orgObjectTargetsLocalService;
	@BeanReference(name = "larion.progate.service.OrgObjectTargetsService.impl")
	protected OrgObjectTargetsService orgObjectTargetsService;
	@BeanReference(name = "larion.progate.service.persistence.OrgObjectTargetsPersistence.impl")
	protected OrgObjectTargetsPersistence orgObjectTargetsPersistence;
	@BeanReference(name = "larion.progate.service.ProgatePortalMenuLocalService.impl")
	protected ProgatePortalMenuLocalService progatePortalMenuLocalService;
	@BeanReference(name = "larion.progate.service.ProgatePortalMenuService.impl")
	protected ProgatePortalMenuService progatePortalMenuService;
	@BeanReference(name = "larion.progate.service.persistence.ProgatePortalMenuPersistence.impl")
	protected ProgatePortalMenuPersistence progatePortalMenuPersistence;
	@BeanReference(name = "larion.progate.service.ProGateRolesLocalService.impl")
	protected ProGateRolesLocalService proGateRolesLocalService;
	@BeanReference(name = "larion.progate.service.ProGateRolesService.impl")
	protected ProGateRolesService proGateRolesService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateRolesPersistence.impl")
	protected ProGateRolesPersistence proGateRolesPersistence;
	@BeanReference(name = "larion.progate.service.ProGateOrgTypeLocalService.impl")
	protected ProGateOrgTypeLocalService proGateOrgTypeLocalService;
	@BeanReference(name = "larion.progate.service.ProGateOrgTypeService.impl")
	protected ProGateOrgTypeService proGateOrgTypeService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgTypePersistence.impl")
	protected ProGateOrgTypePersistence proGateOrgTypePersistence;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleLocalService.impl")
	protected ProGateJournalArticleLocalService proGateJournalArticleLocalService;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleService.impl")
	protected ProGateJournalArticleService proGateJournalArticleService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePersistence.impl")
	protected ProGateJournalArticlePersistence proGateJournalArticlePersistence;
	@BeanReference(name = "larion.progate.service.ProGateProductsServicesLocalService.impl")
	protected ProGateProductsServicesLocalService proGateProductsServicesLocalService;
	@BeanReference(name = "larion.progate.service.ProGateProductsServicesService.impl")
	protected ProGateProductsServicesService proGateProductsServicesService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateProductsServicesPersistence.impl")
	protected ProGateProductsServicesPersistence proGateProductsServicesPersistence;
	@BeanReference(name = "larion.progate.service.ProGateCurrencyTypesLocalService.impl")
	protected ProGateCurrencyTypesLocalService proGateCurrencyTypesLocalService;
	@BeanReference(name = "larion.progate.service.ProGateCurrencyTypesService.impl")
	protected ProGateCurrencyTypesService proGateCurrencyTypesService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateCurrencyTypesPersistence.impl")
	protected ProGateCurrencyTypesPersistence proGateCurrencyTypesPersistence;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticlePrioritiesLocalService.impl")
	protected ProGateJournalArticlePrioritiesLocalService proGateJournalArticlePrioritiesLocalService;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticlePrioritiesService.impl")
	protected ProGateJournalArticlePrioritiesService proGateJournalArticlePrioritiesService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticlePrioritiesPersistence.impl")
	protected ProGateJournalArticlePrioritiesPersistence proGateJournalArticlePrioritiesPersistence;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleTypesLocalService.impl")
	protected ProGateJournalArticleTypesLocalService proGateJournalArticleTypesLocalService;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleTypesService.impl")
	protected ProGateJournalArticleTypesService proGateJournalArticleTypesService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleTypesPersistence.impl")
	protected ProGateJournalArticleTypesPersistence proGateJournalArticleTypesPersistence;
	@BeanReference(name = "larion.progate.service.RegionLocalService.impl")
	protected RegionLocalService regionLocalService;
	@BeanReference(name = "larion.progate.service.RegionService.impl")
	protected RegionService regionService;
	@BeanReference(name = "larion.progate.service.persistence.RegionPersistence.impl")
	protected RegionPersistence regionPersistence;
	@BeanReference(name = "larion.progate.service.CountryLocalService.impl")
	protected CountryLocalService countryLocalService;
	@BeanReference(name = "larion.progate.service.CountryService.impl")
	protected CountryService countryService;
	@BeanReference(name = "larion.progate.service.persistence.CountryPersistence.impl")
	protected CountryPersistence countryPersistence;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleViewLocalService.impl")
	protected ProGateJournalArticleViewLocalService proGateJournalArticleViewLocalService;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleViewService.impl")
	protected ProGateJournalArticleViewService proGateJournalArticleViewService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleViewPersistence.impl")
	protected ProGateJournalArticleViewPersistence proGateJournalArticleViewPersistence;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleSlideShowLocalService.impl")
	protected ProGateJournalArticleSlideShowLocalService proGateJournalArticleSlideShowLocalService;
	@BeanReference(name = "larion.progate.service.ProGateJournalArticleSlideShowService.impl")
	protected ProGateJournalArticleSlideShowService proGateJournalArticleSlideShowService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateJournalArticleSlideShowPersistence.impl")
	protected ProGateJournalArticleSlideShowPersistence proGateJournalArticleSlideShowPersistence;
	@BeanReference(name = "larion.progate.service.ProGateOrgCustomerLocalService.impl")
	protected ProGateOrgCustomerLocalService proGateOrgCustomerLocalService;
	@BeanReference(name = "larion.progate.service.ProGateOrgCustomerService.impl")
	protected ProGateOrgCustomerService proGateOrgCustomerService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerPersistence.impl")
	protected ProGateOrgCustomerPersistence proGateOrgCustomerPersistence;
	@BeanReference(name = "larion.progate.service.ProGateOrgCustomerRepresenterLocalService.impl")
	protected ProGateOrgCustomerRepresenterLocalService proGateOrgCustomerRepresenterLocalService;
	@BeanReference(name = "larion.progate.service.ProGateOrgCustomerRepresenterService.impl")
	protected ProGateOrgCustomerRepresenterService proGateOrgCustomerRepresenterService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgCustomerRepresenterPersistence.impl")
	protected ProGateOrgCustomerRepresenterPersistence proGateOrgCustomerRepresenterPersistence;
	@BeanReference(name = "larion.progate.service.ProGateApplicationsLocalService.impl")
	protected ProGateApplicationsLocalService proGateApplicationsLocalService;
	@BeanReference(name = "larion.progate.service.ProGateApplicationsService.impl")
	protected ProGateApplicationsService proGateApplicationsService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateApplicationsPersistence.impl")
	protected ProGateApplicationsPersistence proGateApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.ProGateUserApplicationsLocalService.impl")
	protected ProGateUserApplicationsLocalService proGateUserApplicationsLocalService;
	@BeanReference(name = "larion.progate.service.ProGateUserApplicationsService.impl")
	protected ProGateUserApplicationsService proGateUserApplicationsService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateUserApplicationsPersistence.impl")
	protected ProGateUserApplicationsPersistence proGateUserApplicationsPersistence;
	@BeanReference(name = "larion.progate.service.ProgateOrganizationParticipantsLocalService.impl")
	protected ProgateOrganizationParticipantsLocalService progateOrganizationParticipantsLocalService;
	@BeanReference(name = "larion.progate.service.ProgateOrganizationParticipantsService.impl")
	protected ProgateOrganizationParticipantsService progateOrganizationParticipantsService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationParticipantsPersistence.impl")
	protected ProgateOrganizationParticipantsPersistence progateOrganizationParticipantsPersistence;
	@BeanReference(name = "larion.progate.service.ProgateOrganizationsStaffsLocalService.impl")
	protected ProgateOrganizationsStaffsLocalService progateOrganizationsStaffsLocalService;
	@BeanReference(name = "larion.progate.service.ProgateOrganizationsStaffsService.impl")
	protected ProgateOrganizationsStaffsService progateOrganizationsStaffsService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationsStaffsPersistence.impl")
	protected ProgateOrganizationsStaffsPersistence progateOrganizationsStaffsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProgateOrganizationsStaffsFinder.impl")
	protected ProgateOrganizationsStaffsFinder progateOrganizationsStaffsFinder;
	@BeanReference(name = "larion.progate.service.ProgateApplicationsSettingLocalService.impl")
	protected ProgateApplicationsSettingLocalService progateApplicationsSettingLocalService;
	@BeanReference(name = "larion.progate.service.ProgateApplicationsSettingService.impl")
	protected ProgateApplicationsSettingService progateApplicationsSettingService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateApplicationsSettingPersistence.impl")
	protected ProgateApplicationsSettingPersistence progateApplicationsSettingPersistence;
	@BeanReference(name = "larion.progate.service.ProgateMenusLocalService.impl")
	protected ProgateMenusLocalService progateMenusLocalService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateMenusPersistence.impl")
	protected ProgateMenusPersistence progateMenusPersistence;
	@BeanReference(name = "larion.progate.service.ProgateLayoutsRolesLocalService.impl")
	protected ProgateLayoutsRolesLocalService progateLayoutsRolesLocalService;
	@BeanReference(name = "larion.progate.service.ProgateLayoutsRolesService.impl")
	protected ProgateLayoutsRolesService progateLayoutsRolesService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsRolesPersistence.impl")
	protected ProgateLayoutsRolesPersistence progateLayoutsRolesPersistence;
	@BeanReference(name = "larion.progate.service.ProgateLayoutsMenusLocalService.impl")
	protected ProgateLayoutsMenusLocalService progateLayoutsMenusLocalService;
	@BeanReference(name = "larion.progate.service.ProgateLayoutsMenusService.impl")
	protected ProgateLayoutsMenusService progateLayoutsMenusService;
	@BeanReference(name = "larion.progate.service.persistence.ProgateLayoutsMenusPersistence.impl")
	protected ProgateLayoutsMenusPersistence progateLayoutsMenusPersistence;
	@BeanReference(name = "larion.progate.service.ProGateMenuViewLocalService.impl")
	protected ProGateMenuViewLocalService proGateMenuViewLocalService;
	@BeanReference(name = "larion.progate.service.ProGateMenuViewService.impl")
	protected ProGateMenuViewService proGateMenuViewService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateMenuViewPersistence.impl")
	protected ProGateMenuViewPersistence proGateMenuViewPersistence;
	@BeanReference(name = "larion.progate.service.ProGateOrgsUsersPermissionsLocalService.impl")
	protected ProGateOrgsUsersPermissionsLocalService proGateOrgsUsersPermissionsLocalService;
	@BeanReference(name = "larion.progate.service.ProGateOrgsUsersPermissionsService.impl")
	protected ProGateOrgsUsersPermissionsService proGateOrgsUsersPermissionsService;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgsUsersPermissionsPersistence.impl")
	protected ProGateOrgsUsersPermissionsPersistence proGateOrgsUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ProGateOrgsUsersPermissionsFinder.impl")
	protected ProGateOrgsUsersPermissionsFinder proGateOrgsUsersPermissionsFinder;
	@BeanReference(name = "larion.progate.service.ProGatePermissionsLocalService.impl")
	protected ProGatePermissionsLocalService proGatePermissionsLocalService;
	@BeanReference(name = "larion.progate.service.ProGatePermissionsService.impl")
	protected ProGatePermissionsService proGatePermissionsService;
	@BeanReference(name = "larion.progate.service.persistence.ProGatePermissionsPersistence.impl")
	protected ProGatePermissionsPersistence proGatePermissionsPersistence;
	@BeanReference(name = "larion.progate.service.ViewOrgUsersPermissionsLocalService.impl")
	protected ViewOrgUsersPermissionsLocalService viewOrgUsersPermissionsLocalService;
	@BeanReference(name = "larion.progate.service.ViewOrgUsersPermissionsService.impl")
	protected ViewOrgUsersPermissionsService viewOrgUsersPermissionsService;
	@BeanReference(name = "larion.progate.service.persistence.ViewOrgUsersPermissionsPersistence.impl")
	protected ViewOrgUsersPermissionsPersistence viewOrgUsersPermissionsPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewOrgUsersPermissionsFinder.impl")
	protected ViewOrgUsersPermissionsFinder viewOrgUsersPermissionsFinder;
	@BeanReference(name = "larion.progate.service.ViewProGatePermissionsRolesLocalService.impl")
	protected ViewProGatePermissionsRolesLocalService viewProGatePermissionsRolesLocalService;
	@BeanReference(name = "larion.progate.service.ViewProGatePermissionsRolesService.impl")
	protected ViewProGatePermissionsRolesService viewProGatePermissionsRolesService;
	@BeanReference(name = "larion.progate.service.persistence.ViewProGatePermissionsRolesPersistence.impl")
	protected ViewProGatePermissionsRolesPersistence viewProGatePermissionsRolesPersistence;
	@BeanReference(name = "larion.progate.service.persistence.ViewProGatePermissionsRolesFinder.impl")
	protected ViewProGatePermissionsRolesFinder viewProGatePermissionsRolesFinder;
}