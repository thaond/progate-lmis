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

package larion.progate.service.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import larion.progate.service.ClpSerializer;
import larion.progate.service.CountryLocalServiceUtil;
import larion.progate.service.CountryServiceUtil;
import larion.progate.service.OrgObjectApprovalLocalServiceUtil;
import larion.progate.service.OrgObjectApprovalServiceUtil;
import larion.progate.service.OrgObjectListLocalServiceUtil;
import larion.progate.service.OrgObjectListServiceUtil;
import larion.progate.service.OrgObjectMeasureLocalServiceUtil;
import larion.progate.service.OrgObjectMeasureServiceUtil;
import larion.progate.service.OrgObjectObjectiveLocalServiceUtil;
import larion.progate.service.OrgObjectObjectiveServiceUtil;
import larion.progate.service.OrgObjectPerspectiveLocalServiceUtil;
import larion.progate.service.OrgObjectPerspectiveServiceUtil;
import larion.progate.service.OrgObjectTargetsLocalServiceUtil;
import larion.progate.service.OrgObjectTargetsServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.OrganizationServiceUtil;
import larion.progate.service.OrganizationViewLocalServiceUtil;
import larion.progate.service.OrganizationViewServiceUtil;
import larion.progate.service.ProGateApplicationsLocalServiceUtil;
import larion.progate.service.ProGateApplicationsServiceUtil;
import larion.progate.service.ProGateCurrencyTypesLocalServiceUtil;
import larion.progate.service.ProGateCurrencyTypesServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticlePrioritiesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticlePrioritiesServiceUtil;
import larion.progate.service.ProGateJournalArticleServiceUtil;
import larion.progate.service.ProGateJournalArticleSlideShowLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleSlideShowServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewServiceUtil;
import larion.progate.service.ProGateMenuViewLocalServiceUtil;
import larion.progate.service.ProGateMenuViewServiceUtil;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterServiceUtil;
import larion.progate.service.ProGateOrgCustomerServiceUtil;
import larion.progate.service.ProGateOrgTypeLocalServiceUtil;
import larion.progate.service.ProGateOrgTypeServiceUtil;
import larion.progate.service.ProGateOrgsUsersPermissionsLocalServiceUtil;
import larion.progate.service.ProGateOrgsUsersPermissionsServiceUtil;
import larion.progate.service.ProGatePermissionsLocalServiceUtil;
import larion.progate.service.ProGatePermissionsServiceUtil;
import larion.progate.service.ProGateProductsServicesLocalServiceUtil;
import larion.progate.service.ProGateProductsServicesServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProGateRolesServiceUtil;
import larion.progate.service.ProGateUserApplicationsLocalServiceUtil;
import larion.progate.service.ProGateUserApplicationsServiceUtil;
import larion.progate.service.ProgateApplicationsSettingLocalServiceUtil;
import larion.progate.service.ProgateApplicationsSettingServiceUtil;
import larion.progate.service.ProgateLayoutsMenusLocalServiceUtil;
import larion.progate.service.ProgateLayoutsMenusServiceUtil;
import larion.progate.service.ProgateLayoutsRolesLocalServiceUtil;
import larion.progate.service.ProgateLayoutsRolesServiceUtil;
import larion.progate.service.ProgateMenusLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsServiceUtil;
import larion.progate.service.ProgatePortalMenuLocalServiceUtil;
import larion.progate.service.ProgatePortalMenuServiceUtil;
import larion.progate.service.RegionLocalServiceUtil;
import larion.progate.service.RegionServiceUtil;
import larion.progate.service.UserInformationViewLocalServiceUtil;
import larion.progate.service.UserInformationViewServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.service.UserServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsServiceUtil;
import larion.progate.service.ViewProGatePermissionsRolesLocalServiceUtil;
import larion.progate.service.ViewProGatePermissionsRolesServiceUtil;

/**
 * <a href="ClpMessageListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpMessageListener implements MessageListener {
	public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(SERVLET_CONTEXT_NAME)) {
			UserLocalServiceUtil.clearService();

			UserServiceUtil.clearService();
			UserInformationViewLocalServiceUtil.clearService();

			UserInformationViewServiceUtil.clearService();
			OrganizationLocalServiceUtil.clearService();

			OrganizationServiceUtil.clearService();
			OrganizationViewLocalServiceUtil.clearService();

			OrganizationViewServiceUtil.clearService();
			OrgObjectListLocalServiceUtil.clearService();

			OrgObjectListServiceUtil.clearService();
			OrgObjectApprovalLocalServiceUtil.clearService();

			OrgObjectApprovalServiceUtil.clearService();
			OrgObjectPerspectiveLocalServiceUtil.clearService();

			OrgObjectPerspectiveServiceUtil.clearService();
			OrgObjectObjectiveLocalServiceUtil.clearService();

			OrgObjectObjectiveServiceUtil.clearService();
			OrgObjectMeasureLocalServiceUtil.clearService();

			OrgObjectMeasureServiceUtil.clearService();
			OrgObjectTargetsLocalServiceUtil.clearService();

			OrgObjectTargetsServiceUtil.clearService();
			ProgatePortalMenuLocalServiceUtil.clearService();

			ProgatePortalMenuServiceUtil.clearService();
			ProGateRolesLocalServiceUtil.clearService();

			ProGateRolesServiceUtil.clearService();
			ProGateOrgTypeLocalServiceUtil.clearService();

			ProGateOrgTypeServiceUtil.clearService();
			ProGateJournalArticleLocalServiceUtil.clearService();

			ProGateJournalArticleServiceUtil.clearService();
			ProGateProductsServicesLocalServiceUtil.clearService();

			ProGateProductsServicesServiceUtil.clearService();
			ProGateCurrencyTypesLocalServiceUtil.clearService();

			ProGateCurrencyTypesServiceUtil.clearService();
			ProGateJournalArticlePrioritiesLocalServiceUtil.clearService();

			ProGateJournalArticlePrioritiesServiceUtil.clearService();
			ProGateJournalArticleTypesLocalServiceUtil.clearService();

			ProGateJournalArticleTypesServiceUtil.clearService();
			RegionLocalServiceUtil.clearService();

			RegionServiceUtil.clearService();
			CountryLocalServiceUtil.clearService();

			CountryServiceUtil.clearService();
			ProGateJournalArticleViewLocalServiceUtil.clearService();

			ProGateJournalArticleViewServiceUtil.clearService();
			ProGateJournalArticleSlideShowLocalServiceUtil.clearService();

			ProGateJournalArticleSlideShowServiceUtil.clearService();
			ProGateOrgCustomerLocalServiceUtil.clearService();

			ProGateOrgCustomerServiceUtil.clearService();
			ProGateOrgCustomerRepresenterLocalServiceUtil.clearService();

			ProGateOrgCustomerRepresenterServiceUtil.clearService();
			ProGateApplicationsLocalServiceUtil.clearService();

			ProGateApplicationsServiceUtil.clearService();
			ProGateUserApplicationsLocalServiceUtil.clearService();

			ProGateUserApplicationsServiceUtil.clearService();
			ProgateOrganizationParticipantsLocalServiceUtil.clearService();

			ProgateOrganizationParticipantsServiceUtil.clearService();
			ProgateOrganizationsStaffsLocalServiceUtil.clearService();

			ProgateOrganizationsStaffsServiceUtil.clearService();
			ProgateApplicationsSettingLocalServiceUtil.clearService();

			ProgateApplicationsSettingServiceUtil.clearService();
			ProgateMenusLocalServiceUtil.clearService();

			ProgateLayoutsRolesLocalServiceUtil.clearService();

			ProgateLayoutsRolesServiceUtil.clearService();
			ProgateLayoutsMenusLocalServiceUtil.clearService();

			ProgateLayoutsMenusServiceUtil.clearService();
			ProGateMenuViewLocalServiceUtil.clearService();

			ProGateMenuViewServiceUtil.clearService();
			ProGateOrgsUsersPermissionsLocalServiceUtil.clearService();

			ProGateOrgsUsersPermissionsServiceUtil.clearService();
			ProGatePermissionsLocalServiceUtil.clearService();

			ProGatePermissionsServiceUtil.clearService();
			ViewOrgUsersPermissionsLocalServiceUtil.clearService();

			ViewOrgUsersPermissionsServiceUtil.clearService();
			ViewProGatePermissionsRolesLocalServiceUtil.clearService();

			ViewProGatePermissionsRolesServiceUtil.clearService();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);
}