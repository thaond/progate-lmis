package com.larion.progate.menu.action;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import larion.progate.model.ProGateMenuView;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.service.ProGateMenuViewLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProgateLayoutsMenusLocalServiceUtil;
import larion.progate.service.utils.Constants;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ShowingMenuAction extends ParameterizableViewAction {

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

			int orgId = ParamUtil
					.getInteger(origReq, URLParameter_RS.ORG_ID, 0);

			if (orgId == 0) {
				orgId = ParamUtil.getInteger(request, Request.SELECTED_ORG_ID,
						0);
			}

			System.out.println("orgId of Org Profile Menu from URL: " + orgId);

			HttpSession session = origReq.getSession();

			if (orgId == 0) {
				if (session.getAttribute(URLParameter_RS.ORG_ID) != null) {
					orgId = GetterUtil.getInteger(
							session.getAttribute(URLParameter_RS.ORG_ID)
									.toString(), 0);

					System.out
							.println("orgId of Org Profile Menu from session: "
									+ orgId);
				}
			} else {
				session.setAttribute(URLParameter_RS.ORG_ID, orgId);
			}

			System.out.println("orgId of Org Profile Menu: " + orgId);

			ProgateOrganizationParticipants participant = ProgateOrganizationParticipantsLocalServiceUtil
					.getCurrentParticipant(userId, orgId);

			int userRolePriority = 1;
			if (participant != null
					&& participant.getStatus() == Constants.ORG_USER_STATUS_USER_JOIN_ORG) {

				userRolePriority = ProGateRolesLocalServiceUtil
						.getProGateRoles(participant.getRoleId()).getPriority();
			}

			Layout layout = null;

			if (themeDisplay != null) {
				layout = themeDisplay.getLayout();
			}

			int layoutId = (int) layout.getPlid();

			List<String> menuList = ProgateLayoutsMenusLocalServiceUtil
					.getMenuNamesByLayoutId(layoutId);

			ProGateMenuView menus = ProGateMenuViewLocalServiceUtil
					.getProGateMenuView(menuList.get(0));

			StringBuilder navMenu = new StringBuilder();
			navMenu.append("<ul id=\'beneath-globalnav\'>");

			String[] arrayLayoutIdAndRole = menus.getMenus().split(";");

			int index = 0;

			for (String layoutIdAndRole : arrayLayoutIdAndRole) {
				String menu = layoutIdAndRole.split(":")[0];
				String role = layoutIdAndRole.split(":")[1];

				Layout nav_item = LayoutLocalServiceUtil.getLayout(Integer
						.parseInt(menu));

				if (!nav_item.isHidden()
						&& !"/home".equals(nav_item.getFriendlyURL())
						&& userRolePriority >= Integer.parseInt(role)) {

					String nav_item_class;

					if (nav_item.getLayoutId() == layout.getLayoutId()
							|| ProGateUtil.hasAncestor(layout,
									nav_item.getLayoutId())) {
						nav_item_class = "selected";
					} else {
						if (index == 0) {
							nav_item_class = "nav-first";
						} else {
							nav_item_class = "";
						}
					}
					index++;

					boolean isLastChildMenu = (index == arrayLayoutIdAndRole.length) ? true
							: false;

					navMenu.append(createNodeByLayout(layout, nav_item,
							nav_item_class, request, isLastChildMenu));
				}
			}
			navMenu.append("</ul> ");

			bean.put("navMenu", navMenu.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createNodeByLayout(Layout layout, Layout nav_item,
			String nav_item_class, PortletRequest request,
			boolean isLastChildMenu) throws Exception {
		StringBuilder node = new StringBuilder();

		node.append("<li class=\'child\'>");

		boolean hasNoChildren = false;

		if (nav_item.getChildren().size() == 0) {
			hasNoChildren = true;
		} else {
			if (nav_item.getChildren().get(0).isHidden()
					&& nav_item.getChildren().size() == 1) {
				hasNoChildren = true;
			}
		}

		if (hasNoChildren) {
			node.append("<a class=\'" + nav_item_class + "\'" + " href="
					+ nav_item.getFriendlyURL()
					+ ProGateUtil.buildParametersUrl(nav_item, request) + ">"
					+ nav_item.getName() + "</a>");
		} else {
			node.append("<a class=\'" + nav_item_class + "\'>"
					+ nav_item.getName() + "</a>");

			node.append("<ul name=\'child_level1\' class=\'child-menu "
					+ (isLastChildMenu ? "last-child-menu" : "") + "\'>");

			for (Layout nav_child : nav_item.getChildren()) {

				if (!nav_child.isHidden()) {
					String nav_child_class = "";
					if (nav_child.getLayoutId() == layout.getLayoutId()) {
						nav_child_class = "selected";
					} else {
						nav_child_class = "";
					}

					node.append("<li class=\'child-level1\'>");

					if (nav_child.getChildren().size() == 0) {
						node.append("<a class=\'"
								+ nav_child_class
								+ "\'"
								+ " href="
								+ nav_child.getFriendlyURL()
								+ ProGateUtil.buildParametersUrl(nav_child,
										request) + ">" + nav_child.getName()
								+ "</a>");
					} else {
						node.append("<a class=\'" + nav_child_class + "\'>"
								+ nav_child.getName() + "</a>");

						node.append("<ul name=\'child_menu2\' class=\'sub-child-menu\'>");

						for (Layout nav_child2 : nav_child.getChildren()) {
							if (!nav_child2.isHidden()) {
								String nav_child_class2 = "";
								if (nav_child2.getLayoutId() == layout
										.getLayoutId()) {
									nav_child_class2 = "selected";
								} else {
									nav_child_class2 = "";
								}
								node.append("<li class=\'" + nav_child_class2
										+ "\'>");

								if (nav_child2.getChildren().size() == 0) {
									node.append("<a href="
											+ nav_child2.getFriendlyURL()
											+ ProGateUtil.buildParametersUrl(
													nav_child2, request)
											+ nav_child2.getTarget() + ">"
											+ nav_child2.getName() + "</a>");
								} else {
									node.append("<a>" + nav_child2.getName()
											+ "</a>");

									node.append("<ul name=\'child_menu3\' class=\'sub-child-menu\'>");

									for (Layout nav_child3 : nav_child2
											.getChildren()) {
										if (!nav_child3.isHidden()) {
											String nav_child_class3 = "";
											if (nav_child3.getLayoutId() == layout
													.getLayoutId()) {
												nav_child_class3 = "selected";
											} else {
												nav_child_class3 = "";
											}
											node.append("<li class=\'"
													+ nav_child_class3 + "\'>");

											node.append("<a href="
													+ nav_child3
															.getFriendlyURL()
													+ ProGateUtil
															.buildParametersUrl(
																	nav_child3,
																	request)
													+ nav_child3.getTarget()
													+ ">"
													+ nav_child3.getName()
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
}
