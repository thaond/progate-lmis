package com.larion.progate.cds.configuration.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import larion.progate.cds.model.Competency;
import larion.progate.cds.model.Level;
import larion.progate.cds.model.Slot;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class ConfigCDSTreeController extends ParameterizableViewAction {

	private PermissionAndRole perAndRoleOnTab1 = new PermissionAndRole(); // Config
																			// CDS
																			// Tree
	private PermissionAndRole perAndRoleOnTab2 = new PermissionAndRole(); // Config
																			// points
	private PermissionAndRole perAndRoleOnTab3 = new PermissionAndRole(); // Config
																			// periods
	private PermissionAndRole perAndRoleOnTab4 = new PermissionAndRole(); // Config
																			// minimum
	private PermissionAndRole perAndRoleOnTab5 = new PermissionAndRole(); // Config
																			// title

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

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

		perAndRoleOnTab1.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_CDS_TREE);

		if (perAndRoleOnTab1.isPermitted()) {
			HttpServletResponse res = PortalUtil
					.getHttpServletResponse(response);
			// res.setContentType("text/html; charset=UTF-8");
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			String type = ParamUtil.getString(request, "type");
			String action = ParamUtil.getString(request, "handle");

			if (type.equals("competency")) {
				if (action.equals("checkNameExist")) {
					String competencyName = StringEscapeUtils
							.escapeHtml(ParamUtil.getString(request,
									"competencyName"));
					boolean test = CompetencyLocalServiceUtil
							.checkCompetencyName(rootId, competencyName);
					if (test) {
						output.print("true");
					} else {
						output.print("false");
					}
				}

				if (action.equals("add")) {

					String name = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "name"));
					int order = ParamUtil.getInteger(request, "order");
					int id = ParamUtil.getInteger(request, "id");

					try {
						if (id == -1) { // add
							CompetencyLocalServiceUtil.addCdsCompetency(rootId,
									name, order, userId);
							output.print("ban da them thanh cong mot competency");
						} else { // edit
							CompetencyLocalServiceUtil.updateCdsCompetency(id,
									name, order, userId);
							output.print("ban da sua thanh cong mot competency");
						}
					} catch (Exception e) {
						e.printStackTrace();
						if (id == -1) {
							output.print("co loi xay ra khi them competency");
						} else { // edit
							output.print("co loi xay ra khi sua competency");
						}
					}
				} else if (action.equals("delete")) {
					try {
						int id = ParamUtil.getInteger(request, "id");
						CompetencyLocalServiceUtil.deleteCdsCompetency(id);
						output.print("ban da xoa thanh cong mot competency");
					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi xoa competency");
					}
				} else if (action.equals("edit")) {
					try {
						int id = ParamUtil.getInteger(request, "id");
						Competency c = CompetencyLocalServiceUtil
								.getCompetency(id);

						StringBuffer xml = new StringBuffer();

						xml.append("<?xml version=\"1.0\"?>\n");
						xml.append("<competency>\n");

						xml.append("<id>");
						xml.append(c.getPrimaryKey());
						xml.append("</id>\n");

						xml.append("<name>");
						xml.append(c.getName());
						xml.append("</name>\n");

						xml.append("<order>");
						xml.append(c.getNumberOrder());
						xml.append("</order>\n");

						xml.append("</competency>\n");

						output.print(xml.toString());

					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi get competency");
					}
				}
			}

			if (type.equals("level")) {
				if (action.equals("checkNameExist")) {
					int parentId = ParamUtil.getInteger(request, "parentId");
					String levelName = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "levelName"));
					boolean test = LevelLocalServiceUtil.checkLevelName(rootId,
							levelName, parentId);
					if (test) {
						output.print("true");
					} else {
						output.print("false");
					}
				}

				if (action.equals("add")) {
					String name = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "name"));
					int order = ParamUtil.getInteger(request, "order");
					int id = ParamUtil.getInteger(request, "id");
					int parentId = ParamUtil.getInteger(request, "parentId");

					try {

						if (id == -1) { // add
							LevelLocalServiceUtil.addCdsLevel(parentId, name,
									order, userId);
							output.print("ban da them thanh cong mot level");
						} else { // edit
							LevelLocalServiceUtil.updateCdsLevel(id, name,
									order, userId);
							output.print("ban da sua thanh cong mot level");
						}
					} catch (Exception e) {
						e.printStackTrace();
						if (id == -1) { // add
							output.print("co loi xay ra khi them level");
						} else {
							output.print("co loi xay ra khi sua level");
						}
					}
				} else if (action.equals("delete")) {
					try {

						int id = ParamUtil.getInteger(request, "id");
						LevelLocalServiceUtil.deleteCdsLevel(id);
						output.print("ban da xoa thanh cong mot level");

					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi xoa level");
					}
				} else if (action.equals("edit")) {
					try {
						int id = ParamUtil.getInteger(request, "id");
						Level l = LevelLocalServiceUtil.getLevel(id);

						StringBuffer xml = new StringBuffer();

						xml.append("<?xml version=\"1.0\"?>\n");
						xml.append("<level>\n");

						xml.append("<id>");
						xml.append(l.getPrimaryKey());
						xml.append("</id>\n");

						xml.append("<parentId>");
						xml.append(l.getCompetencyId());
						xml.append("</parentId>\n");

						xml.append("<name>");
						xml.append(l.getName());
						xml.append("</name>\n");

						xml.append("<order>");
						xml.append(l.getNumberOrder());
						xml.append("</order>\n");

						xml.append("</level>\n");

						String xmlString = xml.toString();
						output.print(xmlString);

					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi get level");
					}
				}
			}

			if (type.equals("slot")) {
				if (action.equals("checkNameExist")) {
					int parentId = ParamUtil.getInteger(request, "parentId");
					String slotName = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "slotName"));
					boolean test = SlotLocalServiceUtil.checkSlotName(rootId,
							slotName, parentId);
					if (test) {
						output.print("true");
					} else {
						output.print("false");
					}
				}

				if (action.equals("add")) {

					String name = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "name"));
					int order = ParamUtil.getInteger(request, "order");
					String description = StringEscapeUtils.escapeHtml(ParamUtil
							.getString(request, "description"));
					int id = ParamUtil.getInteger(request, "id");
					int parentId = ParamUtil.getInteger(request, "parentId");

					try {
						if (id == -1) { // add
							SlotLocalServiceUtil.addCdsSlot(parentId, name,
									order, description, userId);
							output.print("ban da them thanh cong mot slot");
						} else { // edit
							SlotLocalServiceUtil.updateCdsSlot(id, name, order,
									description, userId);
							output.print("ban da sua thanh cong mot slot");
						}

					} catch (Exception e) {
						e.printStackTrace();

						if (id == -1) { // add
							output.print("co loi xay ra khi them slot");
						} else { // edit
							output.print("co loi xay ra khi sua slot");
						}
					}
				} else if (action.equals("delete")) {
					try {
						int id = ParamUtil.getInteger(request, "id");
						SlotLocalServiceUtil.deleteCdsSlot(id);
						output.print("ban da xoa thanh cong mot Slot");
					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi xoa slot");
					}
				} else if (action.equals("edit")) {
					try {
						int id = ParamUtil.getInteger(request, "id");
						Slot s = SlotLocalServiceUtil.getSlot(id);

						StringBuffer xml = new StringBuffer();

						xml.append("<?xml version=\"1.0\"?>\n");
						xml.append("<slot>\n");

						xml.append("<id>");
						xml.append(s.getPrimaryKey());
						xml.append("</id>\n");

						xml.append("<parentId>");
						xml.append(s.getLevelId());
						xml.append("</parentId>\n");

						xml.append("<name>");
						xml.append(s.getName());
						xml.append("</name>\n");

						xml.append("<order>");
						xml.append(s.getNumberOrder());
						xml.append("</order>\n");

						xml.append("<description>");
						xml.append(s.getDescription());
						xml.append("</description>\n");

						xml.append("</slot>\n");

						output.print(xml.toString());

					} catch (Exception e) {
						e.printStackTrace();
						output.print("co loi xay ra khi get slot");
					}
				}
			}

			output.flush();
		}

	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
			if (rootId == 0) {
				HttpServletRequest orgReq = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(request));
				rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
			}
			if (rootId == 0) {
				HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
				HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSR);
				rootId = ProGateUtil.getOrganizationId(origReq);
			}
			bean.put("orgId", rootId);

			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
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

			bean.put("tab", "configCDSTree");

			if (perAndRoleOnTab1.isPermitted()) {
				List<Competency> competencies = CompetencyLocalServiceUtil
						.getCompetencyListByRootId(rootId);
				List<Level> allLevels = new ArrayList<Level>();
				List<Slot> allSlots = new ArrayList<Slot>();
				List<Integer> competencyLevel = new ArrayList<Integer>(); // so
																			// level
																			// cua
																			// mot
																			// competency
				List<Integer> levelSlot = new ArrayList<Integer>(); // so slot
																	// cua mot
																	// level

				List<Integer> nextLevelOrders = new ArrayList<Integer>();
				List<Integer> nextSlotOrders = new ArrayList<Integer>();

				// order mac dinh cua competency se them moi
				int nextCompetencyOrder = 1;
				if (competencies.size() > 0) {
					nextCompetencyOrder = competencies.get(
							competencies.size() - 1).getNumberOrder() + 1;
				}
				Iterator<Competency> itCompetency = competencies.iterator();

				while (itCompetency.hasNext()) {

					Competency competency = itCompetency.next();
					List<Level> levels = LevelLocalServiceUtil
							.getLevelListByCompetencyId(competency
									.getPrimaryKey());

					// order mac dinh cua level se them moi
					if (levels.size() > 0) {
						int nextLevelOrder = levels.get(levels.size() - 1)
								.getNumberOrder() + 1;
						nextLevelOrders.add(nextLevelOrder);
					} else {
						nextLevelOrders.add(1);
					}

					competencyLevel.add(levels.size());

					Iterator<Level> itLevel = levels.iterator();

					while (itLevel.hasNext()) {

						Level level = itLevel.next();
						// System.out.println(level.getName());
						allLevels.add(level);
						List<Slot> slots = SlotLocalServiceUtil
								.getSlotListByLevelId(level.getPrimaryKey());

						// order mac dinh cua slot se them moi
						if (slots.size() > 0) {
							int nextSlotOrder = slots.get(slots.size() - 1)
									.getNumberOrder() + 1;
							nextSlotOrders.add(nextSlotOrder);
						} else {
							nextSlotOrders.add(1);
						}

						levelSlot.add(slots.size());

						Iterator<Slot> itSlot = slots.iterator();

						while (itSlot.hasNext()) {

							allSlots.add(itSlot.next());

						}
					}
				}

				bean.put("competencies", competencies);
				bean.put("sizeOfCompetency", competencies.size());
				bean.put("allLevels", allLevels);
				bean.put("sizeOfAllLevels", allLevels.size());
				bean.put("allSlots", allSlots);
				bean.put("competencyLevel", competencyLevel);
				bean.put("levelSlot", levelSlot);

				bean.put("nextCompetencyOrder", nextCompetencyOrder);
				bean.put("nextLevelOrders", nextLevelOrders);
				bean.put("nextSlotOrders", nextSlotOrders);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
