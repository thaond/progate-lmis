package com.larion.progate.cds.configuration.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.cds.model.CdsMinimumRequirements;
import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.model.CdsTitles;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.ViewListTitleCompetencies;
import larion.progate.cds.model.impl.CdsTitleCompetenciesImpl;
import larion.progate.cds.model.impl.CdsTitleMinimumRequirementsImpl;
import larion.progate.cds.service.CdsMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsTitlesLocalServiceUtil;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.ViewListTitleCompetenciesLocalServiceUtil;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class ConfigTitleController extends ParameterizableViewController {
	private PermissionAndRole perAndRoleOnTab1 = new PermissionAndRole(); // Config CDS Tree
	private PermissionAndRole perAndRoleOnTab2 = new PermissionAndRole(); // Config points
	private PermissionAndRole perAndRoleOnTab3 = new PermissionAndRole(); // Config periods
	private PermissionAndRole perAndRoleOnTab4 = new PermissionAndRole(); // Config minimum
	private PermissionAndRole perAndRoleOnTab5 = new PermissionAndRole(); // Config title

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}
		bean.put("orgId", rootId);

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();
		bean.put("userId", userId);

		perAndRoleOnTab1.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_CDS_TREE);
		perAndRoleOnTab2.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_POINTS);
		perAndRoleOnTab3.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_PERIODS);
		perAndRoleOnTab4.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_MINIMUM_REQUIREMENT);
		perAndRoleOnTab5.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_TITLE);

		bean.put("hasPermissionOnTab1", perAndRoleOnTab1.isPermitted());
		bean.put("hasPermissionOnTab2", perAndRoleOnTab2.isPermitted());
		bean.put("hasPermissionOnTab3", perAndRoleOnTab3.isPermitted());
		bean.put("hasPermissionOnTab4", perAndRoleOnTab4.isPermitted());
		bean.put("hasPermissionOnTab5", perAndRoleOnTab5.isPermitted());

		bean.put("tab", "configTitle");

		if (perAndRoleOnTab5.isPermitted()) {
			List<CdsTitles> titles = CdsTitlesLocalServiceUtil
					.loadListTitles(rootId);
			bean.put("listSize", titles.size());
			// default title number order when adding
			int nextTitleOrder = 1;
			if (titles.size() > 0) {
				nextTitleOrder = titles.get(titles.size() - 1).getNumberOrder() + 1;
			}
			bean.put("nextTitleOrder", nextTitleOrder);

			PaginationObject pagination = new PaginationObject("configTitle",
					titles.size());
			pagination.paging(request);

			titles = titles.subList(pagination.getStartIndex(),
					pagination.getEndIndex());

			bean.put("pagination", pagination);
			bean.put("titles", titles);


			// get list of competencies and minimumRequirements to load for
			// popup
			List<Competency> competencies = CompetencyLocalServiceUtil
					.getCompetencyListByRootId(rootId);
			bean.put("competencies", competencies);
			List<CdsMinimumRequirements> minimumRequirements = CdsMinimumRequirementsLocalServiceUtil
					.getMinimumRequirementListByRootId(rootId);
			bean.put("minimumRequirements", minimumRequirements);
			bean.put("mrSize", minimumRequirements.size());
		}

		return new ModelAndView(this.getViewName(), "bean", bean);
	}

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();

		perAndRoleOnTab5.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_TITLE);
		if (perAndRoleOnTab3.isPermitted()) {
			HttpServletResponse res = PortalUtil
					.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			String action = ParamUtil.getString(request, "handle");
			if (action.equals("add")) {
				try {

					int id = ParamUtil.getInteger(request, "id");
					String fullName = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "fullName"));
					String shortName = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "shortName"));
					int order = ParamUtil.getInteger(request, "order");
					int[] competenciesId = ParamUtil.getIntegerValues(request,
							"competenciesId");
					int[] pointHashes = ParamUtil.getIntegerValues(request,
							"pointHashes");
					String[] pointValues = request
							.getParameterValues("pointValues");
					int[] mininumRequirementsId = ParamUtil.getIntegerValues(
							request, "mininumRequirementsId");
					int[] mRLevelsId = ParamUtil.getIntegerValues(request,
							"mRLevelsId");

					/*
					 * System.out .println(
					 * "\n---------------------ADD DEBUG-----------------------"
					 * ); System.out.println("id: " + id);
					 * System.out.println("fullname: " + fullName);
					 * System.out.println("shortName: " + shortName);
					 * System.out.println("order: " + order);
					 * System.out.print("competenciesId: "); for (int i = 0; i <
					 * competenciesId.length; i++) {
					 * System.out.print(competenciesId[i] + " "); }
					 * System.out.print("\npointHashes: "); for (int i = 0; i <
					 * pointHashes.length; i++) {
					 * System.out.print(pointHashes[i] + " "); }
					 * System.out.print("\npointValues: "); for (int i = 0; i <
					 * pointValues.length; i++) {
					 * System.out.print(pointValues[i] + " "); }
					 * System.out.print("\nmininumRequirementsId: "); for (int i
					 * = 0; i < mininumRequirementsId.length; i++) {
					 * System.out.print(mininumRequirementsId[i] + " "); }
					 * System.out.print("\nmRLevelsId: "); for (int i = 0; i <
					 * mRLevelsId.length; i++) { System.out.print(mRLevelsId[i]
					 * + " "); } System.out .println(
					 * "\n---------------------END ADD DEBUG-----------------------"
					 * );
					 */

					List<CdsTitleCompetencies> titleCompetencies = new ArrayList<CdsTitleCompetencies>();
					List<CdsTitleMinimumRequirements> titleMinimumRequirements = new ArrayList<CdsTitleMinimumRequirements>();
					for (int i = 0; i < competenciesId.length; i++) {
						CdsTitleCompetencies titleCompetency = new CdsTitleCompetenciesImpl();
						titleCompetency.setCompetencyId(competenciesId[i]);
						titleCompetency.setPointHash(pointHashes[i]);
						titleCompetency.setPointValue(pointValues[i]);
						titleCompetencies.add(titleCompetency);
					}
					for (int i = 0; i < mininumRequirementsId.length; i++) {
						CdsTitleMinimumRequirements titleMinimumRequirement = new CdsTitleMinimumRequirementsImpl();
						titleMinimumRequirement
								.setMinimumRequirementId(mininumRequirementsId[i]);
						titleMinimumRequirement
								.setMinimumRequirementLevelId(mRLevelsId[i]);
						titleMinimumRequirements.add(titleMinimumRequirement);
					}

					if (id == -1) { // add
						if (CdsTitlesLocalServiceUtil.addCdsTitle(rootId,
								fullName, shortName, order, userId,
								titleCompetencies, titleMinimumRequirements)) {
							output.print("ban da them thanh cong mot title");
						}

					} else { // edit
						if (CdsTitlesLocalServiceUtil.updateCdsTitle(id,
								fullName, shortName, order, userId,
								titleCompetencies, titleMinimumRequirements)) {
							output.print("ban da sua thanh cong mot title");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi them title");
				}
			} else if (action.equals("delete")) {
				try {
					int[] titlesId = ParamUtil.getIntegerValues(request,
							"titlesId");
					for (int i = 0; i < titlesId.length; i++) {
						if (CdsTitlesLocalServiceUtil
								.deleteCdsTitle(titlesId[i])) {
							// System.out.println("Xoa " + titlesId[i]);
							output.println("Ban da xoa thanh cong title "
									+ titlesId[i]);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					output.print("Co loi xay ra khi xoa title");
				}
			} else if (action.equals("edit")) {
				try {
					/*
					 * System.out .println(
					 * "\n---------------------EDIT DEBUG-----------------------"
					 * );
					 */

					int titleId = ParamUtil.getInteger(request, "titleId");
					// System.out.println("titleId: " + titleId);
					// get a title base on titleId
					CdsTitles cdsTitle = CdsTitlesLocalServiceUtil
							.getCdsTitles(titleId);

					StringBuffer xml = new StringBuffer();

					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<cdsTitle>\n");

					xml.append("<fullName>");
					xml.append(cdsTitle.getName());
					xml.append("</fullName>\n");
					// System.out.println("fullName: " + cdsTitle.getName());

					xml.append("<shortName>");
					xml.append(cdsTitle.getAbbreviation());
					xml.append("</shortName>\n");
					// System.out.println("shortName: " +
					// cdsTitle.getAbbreviation());

					xml.append("<order>");
					xml.append(cdsTitle.getNumberOrder());
					xml.append("</order>\n");
					// System.out.println("order: " +
					// cdsTitle.getNumberOrder());

					// use view to get list of title competencies base on
					// titleId
					// and sort by competency's order
					List<ViewListTitleCompetencies> cdsTitleCompetencies = ViewListTitleCompetenciesLocalServiceUtil
							.loadListTitleCompetencies(titleId);

					int i = 1;// index of name to define data return
					for (ViewListTitleCompetencies cdsTitleCompetency : cdsTitleCompetencies) {
						xml.append("<pointHash" + i + ">");

						xml.append(cdsTitleCompetency.getPointHash());
						xml.append("</pointHash" + i + ">\n");
						/*
						 * System.out.println("<pointHash" + i + ">" +
						 * cdsTitleCompetency.getPointHash() + "</pointHash"+ i
						 * + ">");
						 */
						i = i + 1;
					}

					// get list of titleMinimumRequirements by title Id
					List<CdsTitleMinimumRequirements> titleMinimumRequirements = CdsTitleMinimumRequirementsLocalServiceUtil
							.loadListTitleMinimumRequirements(titleId);
					// get list of minimumRequirement ID in
					// titleMinimumRequirements
					List<Integer> titleMinimumRequirementsId = new ArrayList<Integer>();
					for (CdsTitleMinimumRequirements titleMinimumRequirement : titleMinimumRequirements) {
						titleMinimumRequirementsId.add(titleMinimumRequirement
								.getMinimumRequirementId());
					}
					// get list of minimumRequirements
					List<CdsMinimumRequirements> minimumRequirements = CdsMinimumRequirementsLocalServiceUtil
							.getMinimumRequirementListByRootId(rootId);
					// get list of minimumRequirements ID in minimumRequirements list
					List<Integer> minimumRequirementsId = new ArrayList<Integer>();
					for (CdsMinimumRequirements minimumRequirement : minimumRequirements) {
						minimumRequirementsId.add(minimumRequirement
								.getMinimumRequirementId());
					}

					for (Integer titleMinimumRequirementId : titleMinimumRequirementsId) {
						// System.out.println("T: " +
						// titleMinimumRequirementId);
						int mRIdIndex = minimumRequirementsId
								.indexOf(titleMinimumRequirementId);
						i = mRIdIndex + 1;
						xml.append("<checkMinimumRequirement" + i + ">");
						xml.append(1);
						xml.append("</checkMinimumRequirement" + i + ">\n");

						xml.append("<MRLevelId" + i + ">");
						for (CdsTitleMinimumRequirements titleMinimumRequirement : titleMinimumRequirements) {
							if (titleMinimumRequirementId == titleMinimumRequirement
									.getMinimumRequirementId()) {
								xml.append(titleMinimumRequirement
										.getMinimumRequirementLevelId());
							}
						}
						xml.append("</MRLevelId" + i + ">\n");
					}
					for (Integer minimumRequirementId : minimumRequirementsId) {
						// System.out.println("mr:" + minimumRequirementId);
						int mRIdIndex = titleMinimumRequirementsId
								.indexOf(minimumRequirementId);
						// System.out.println(mRIdIndex);
						if (mRIdIndex == -1) {
							mRIdIndex = minimumRequirementsId
									.indexOf(minimumRequirementId);
							i = mRIdIndex + 1;
							xml.append("<checkMinimumRequirement" + i + ">");
							xml.append(0);
							xml.append("</checkMinimumRequirement" + i + ">\n");

							xml.append("<MRLevelId" + i + ">");
							xml.append(-1);
							xml.append("</MRLevelId" + i + ">\n");
						}
					}
					/*
					 * System.out .println(
					 * "\n---------------------END EDIT DEBUG-----------------------"
					 * );
					 */

					xml.append("</cdsTitle>\n");
					output.print(xml.toString());

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi lay title");
				}
			} else if (action.equals("checkDuplicateName")) {
				int titleId = ParamUtil.getInteger(request, "titleId");
				String newName = ParamUtil.getString(request, "newName").trim();
				String methodName = ParamUtil.getString(request, "methodName");
				
				//click edit
				if (titleId != -1) {
					CdsTitles cdsTitle = CdsTitlesLocalServiceUtil
							.getCdsTitles(titleId);
					String oldName = (String) CdsTitles.class.getMethod(methodName).invoke(cdsTitle, null);
					//if not change default name in textbox --> name not existed
					if(newName.equals(oldName)) {
						output.print("false");
						output.flush();
						return ;
					}
				}
				List<CdsTitles> titles = CdsTitlesLocalServiceUtil
						.loadListTitles(rootId);
				for (CdsTitles cdsTitle : titles) {
					String oldName = (String) CdsTitles.class.getMethod(methodName).invoke(cdsTitle, null);
					//name existed
					if(newName.equals(oldName)) {
						output.print("true");
						output.flush();
						return ;
					}
				}
				output.print("false");
			}
			output.flush();
		}
	}

}
