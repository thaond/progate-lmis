package com.larion.progate.menu.action;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgatePortalMenu;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProgatePortalMenuLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ShowingPortalMenuAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);

			int userId = (int) themeDisplay.getUserId();

			HttpServletRequest httpSR = PortalUtil
					.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSR);

			int orgId = ProGateUtil.getOrganizationId(origReq);

			List<ProGateRoles> userRoles = ProgateOrganizationParticipantsLocalServiceUtil
					.getRolesOfUserInOrg(userId, orgId);

			int userRoleId = 1;
			if (userRoles != null && userRoles.size() > 0) {
				userRoleId = userRoles.get(0).getRoleId();
			}

			List<ProgatePortalMenu> portalMenus = ProgatePortalMenuLocalServiceUtil
					.getProgatePortalMenus(orgId, userRoleId);

			Layout layout = null;

			if (themeDisplay != null) {
				layout = themeDisplay.getLayout();
			}

			StringBuilder portalMenu = new StringBuilder();
			portalMenu.append("<ul>");

			for (ProgatePortalMenu _portalMenu : portalMenus) {

				Layout nav_item = LayoutLocalServiceUtil.getLayout(_portalMenu
						.getLayoutId());

				String nav_item_class;

				if (nav_item.getLayoutId() == layout.getLayoutId()
						|| ProGateUtil.hasAncestor(layout, nav_item.getLayoutId())) {
					nav_item_class = "selected";
				} else {
					nav_item_class = "";
				}

				portalMenu.append(createNodeByLayout(layout, nav_item,
						nav_item_class, request));

			}
			portalMenu.append("</ul> ");

			bean.put("portalMenu", portalMenu.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createNodeByLayout(Layout layout, Layout nav_item,
			String nav_item_class, PortletRequest request) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		Locale locale = themeDisplay.getLocale();

		StringBuilder node = new StringBuilder();

		node.append("<li>");

		if (nav_item.getChildren().size() == 0) {
			node.append("<a class=\'" + nav_item_class + "\'" + " href="
					+ nav_item.getFriendlyURL()
					+ ProGateUtil.buildParametersUrl(nav_item, request) + ">"
					+ nav_item.getName(locale, true) + "</a>");

		} else {
			node.append("<a class=\'" + nav_item_class + "\'>"
					+ nav_item.getName(locale, true) + "</a>");

			node.append("<ul " + getMaxLengthCss(nav_item, locale) + ">");

			for (Layout nav_child : nav_item.getChildren()) {

				if (!nav_child.isHidden()) {
					String nav_child_class = "";

					if (nav_child.getLayoutId() == layout.getLayoutId()
							|| ProGateUtil.hasAncestor(layout, nav_child.getLayoutId())) {
						nav_child_class = "selected";
					} else {
						nav_child_class = "";
					}

					node.append("<li>");

					if (nav_child.getChildren().size() == 0) {
						node.append("<a class=\'"
								+ nav_child_class
								+ "\'"
								+ " href="
								+ nav_child.getFriendlyURL()
								+ ProGateUtil.buildParametersUrl(nav_child,
										request) + ">"
								+ nav_child.getName(locale, true) + "</a>");
					} else {
						node.append("<a class=\'" + nav_child_class + "\'>"
								+ nav_child.getName(locale, true) + "</a>");

						node.append("<ul " + getMaxLengthCss(nav_child, locale)
								+ ">");

						for (Layout nav_child2 : nav_child.getChildren()) {
							if (!nav_child2.isHidden()) {

								String nav_child_class2 = "";

								if (nav_child2.getLayoutId() == layout
										.getLayoutId()
										|| ProGateUtil.hasAncestor(layout,
												nav_child2.getLayoutId())) {
									nav_child_class2 = "selected";
								} else {
									nav_child_class2 = "";
								}
								node.append("<li>");

								if (nav_child2.getChildren().size() == 0) {
									node.append("<a class=\'"
											+ nav_child_class2
											+ "\'"
											+ " href="
											+ nav_child2.getFriendlyURL()
											+ ProGateUtil.buildParametersUrl(
													nav_child2, request) + ">"
											+ nav_child2.getName(locale, true)
											+ "</a>");
								} else {
									node.append("<a class=\'"
											+ nav_child_class2 + "\'>"
											+ nav_child2.getName(locale, true)
											+ "</a>");

									node.append("<ul "
											+ getMaxLengthCss(nav_child2,
													locale) + ">");

									for (Layout nav_child3 : nav_child2
											.getChildren()) {
										if (!nav_child3.isHidden()) {

											String nav_child_class3 = "";

											if (nav_child3.getLayoutId() == layout
													.getLayoutId()
													|| ProGateUtil.hasAncestor(
															layout,
															nav_child3
																	.getLayoutId())) {
												nav_child_class3 = "selected";
											} else {
												nav_child_class3 = "";
											}
											node.append("<li>");

											node.append("<a class=\'"
													+ nav_child_class3
													+ "\'"
													+ " href="
													+ nav_child3
															.getFriendlyURL()
													+ ProGateUtil
															.buildParametersUrl(
																	nav_child3,
																	request)
													+ ">"
													+ nav_child3.getName(
															locale, true)
													+ "</a>");

											node.append("</li>");
										}
									}
									node.append("</ul>");
								}
								node.append("</li>");
							}
						}
						node.append("</ul>");
					}
					node.append("</li>");
				}
			}
			node.append("</ul>");
		}
		node.append("</li>");

		return node.toString();
	}

	public String getMaxLengthCss(Layout nav_item, Locale locale) {
		try {
			StringBuilder style = new StringBuilder();

			style.append("style=\'width: ");

			int maxWidth = 0;

			for (Layout item : nav_item.getChildren()) {

				String name = item.getName(locale, true);

				if (name.length() > maxWidth) {
					maxWidth = name.length();
				}
			}

			maxWidth = maxWidth * 8 + 40;

			style.append(maxWidth + "px\'");

			return style.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return "";
		}
	}	
}
