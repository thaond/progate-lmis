package com.larion.progate.cds.configuration.controllers;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.model.User;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.cds.utils.SendMailUtil;

import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class EvaluationPeriodsController extends ParameterizableViewController {

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
		if (rootId == 0) {
			HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSR);
			rootId = ProGateUtil.getOrganizationId(origReq);
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

		bean.put("tab", "evaluationPeriods");
		if (perAndRoleOnTab3.isPermitted()) {
			int CDSEvaluationPeriodsesCount = CdsEvaluationPeriodsLocalServiceUtil
					.loadCdsPeriods(0, rootId).size();
			bean.put("count", CDSEvaluationPeriodsesCount);

			int CDS_Status = ParamUtil.getInteger(request, "CDS_Status", 0);
			bean.put("selectedStatus", CDS_Status);

			List<CdsEvaluationPeriods> evaluationPeriodsList = CdsEvaluationPeriodsLocalServiceUtil
					.loadCdsPeriods(CDS_Status, rootId);
			bean.put("listSize", evaluationPeriodsList.size());
			if(evaluationPeriodsList.size() > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date maxToDate = evaluationPeriodsList.get(evaluationPeriodsList.size() - 1).getToDate();
				bean.put("maxToDate", sdf.format(maxToDate)); 
			}
			
			int found = 0;
			for (CdsEvaluationPeriods period : evaluationPeriodsList) {
				if(period.getStatus() == 2) {
					bean.put("hasStatusOfOpen", true);
					found = 1;
					break;
				}
			}
			if(found == 0) {
				bean.put("hasStatusOfOpen", false);
			}
			
			PaginationObject pagination = new PaginationObject(
					"evaluationPeriods", evaluationPeriodsList.size());
			pagination.paging(request);

			evaluationPeriodsList = evaluationPeriodsList.subList(
					pagination.getStartIndex(), pagination.getEndIndex());

			bean.put("pagination", pagination);
			bean.put("evaluationPeriodsList", evaluationPeriodsList);

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

		perAndRoleOnTab3.check(rootId, userId,
				RequestConst.PERMISSION_CONFIG_PERIODS);
		if (perAndRoleOnTab3.isPermitted()) {
			HttpServletResponse res = PortalUtil
					.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			String action = ParamUtil.getString(request, "handle");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			if (action.equals("add")) {
				try {
					int id = ParamUtil.getInteger(request, "id");
					String nameEP = StringEscapeUtils.escapeHtml(ParamUtil.getString(request, "nameEP"));
					Date fromDate = ParamUtil.getDate(request, "fromDate", sdf);
					Date toDate = ParamUtil.getDate(request, "toDate", sdf);
					Date startDate = ParamUtil.getDate(request, "startDate",
							sdf);
					Date endDate = ParamUtil.getDate(request, "endDate", sdf);
					int newStatus = ParamUtil.getInteger(request, "status");

					if (id == -1) { // add
						if (CdsEvaluationPeriodsLocalServiceUtil.addCdsPeriod(
								rootId, nameEP, fromDate, toDate, startDate,
								endDate, newStatus, userId) != 0) {
							output.print("ban da them thanh cong mot dot cds");
						}
					} else { // edit
						if (CdsEvaluationPeriodsLocalServiceUtil
								.updateCdsPeriod(id, nameEP, fromDate, toDate,
										startDate, endDate, newStatus, userId)) {
							output.print("ban da sua thanh cong mot dot cds");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi them dot cds");
				}
			} else if (action.equals("sendMail")) {
				String nameEP = ParamUtil.getString(request, "nameEP");
				Date fromDate = ParamUtil.getDate(request, "fromDate", sdf);
				Date toDate = ParamUtil.getDate(request, "toDate", sdf);
				int status = ParamUtil.getInteger(request, "status");
				sendMailToAllStaffs(request, rootId, nameEP, status, fromDate, toDate);
				
			} else if (action.equals("edit")) {
				try {
					int id = ParamUtil.getInteger(request, "id");
					CdsEvaluationPeriods eP = CdsEvaluationPeriodsLocalServiceUtil
							.getCdsEvaluationPeriods(id);
					Boolean isNotUsed = CdsEvaluationPeriodsLocalServiceUtil
							.testBeforeDeleteCdsPeriod(id);

					StringBuffer xml = new StringBuffer();

					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<evaluationPeriods>\n");

					xml.append("<isNotUsed>");
					xml.append(isNotUsed.toString());
					xml.append("</isNotUsed>\n");

					xml.append("<id>");
					xml.append(eP.getPrimaryKey());
					xml.append("</id>\n");

					xml.append("<nameEP>");
					xml.append(eP.getName());
					xml.append("</nameEP>\n");

					xml.append("<fromDate>");
					xml.append(sdf.format(eP.getFromDate()));
					xml.append("</fromDate>\n");

					xml.append("<toDate>");
					xml.append(sdf.format(eP.getToDate()));
					xml.append("</toDate>\n");

					xml.append("<startDate>");
					xml.append(sdf.format(eP.getStartDate()));
					xml.append("</startDate>\n");

					xml.append("<endDate>");
					xml.append(sdf.format(eP.getEndDate()));
					xml.append("</endDate>\n");

					xml.append("<status>");
					xml.append(eP.getStatus());
					xml.append("</status>\n");

					xml.append("</evaluationPeriods>\n");

					output.print(xml.toString());

				} catch (Exception e) {
					e.printStackTrace();
					output.print("co loi xay ra khi lay dot cds");
				}
			} else if (action.equals("delete")) {
				try {
					int[] arrayId = ParamUtil.getIntegerValues(request,
							"arrayId");
					for (int i = 0; i < arrayId.length; i++) {
						Boolean isNotUsed = CdsEvaluationPeriodsLocalServiceUtil
								.testBeforeDeleteCdsPeriod(arrayId[i]);
						if (isNotUsed) {
							if (CdsEvaluationPeriodsLocalServiceUtil
									.deleteCdsPeriod(arrayId[i])) {
								// System.out.println("Xoa " + arrayId[i]);
								output.println("Ban da xoa thanh cong dot cds"
										+ arrayId[i]);
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					output.print("Co loi xay ra khi xoa dot cds");
				}
			} else if (action.equals("checkDateInRange")) {
				int id = ParamUtil.getInteger(request, "id");
				Date pre = CdsEvaluationPeriodsLocalServiceUtil.getToDateOfPreviousPeriod(id);
				Date next = CdsEvaluationPeriodsLocalServiceUtil.getFromDateOfNextPeriod(id);
				
				StringBuffer xml = new StringBuffer();
				xml.append("<?xml version=\"1.0\"?>\n");
				xml.append("<evaluationPeriods>\n");
				
				xml.append("<pre>");
				if( pre == null) {
					xml.append("null");
				} else {
					xml.append(sdf.format(pre));
				}
				xml.append("</pre>\n");
				//System.out.println(sdf.format(pre));
				
				xml.append("<next>");
				if( next == null) {
					xml.append("null");
				} else {
					xml.append(sdf.format(next));
				}
				xml.append("</next>\n");
				//System.out.println(sdf.format(next));
				
				xml.append("</evaluationPeriods>\n");
				
				output.print(xml.toString());
			}
			output.flush();
		}
	}

	private void sendMailToAllStaffs(ActionRequest request, int rootId,
			String periodName, int newStatus, Date fromDate, Date toDate)
			throws PortalException, SystemException {
		List<User> users = UserLocalServiceUtil.getUserInCompany(rootId);
		for (User user : users) {
			com.liferay.portal.model.User userLiferay = com.liferay.portal.service.UserLocalServiceUtil
					.getUser(user.getUserid());
			if (userLiferay != null) {
				StringBuffer subject = new StringBuffer();
				StringBuffer content = new StringBuffer();
				StringBuffer url = new StringBuffer();
				
				SendMailUtil mail = new SendMailUtil();

				String recipients[] = new String[1];
				recipients[0] = userLiferay.getEmailAddress();
				mail.setReceiver(recipients);
				
				url.append("http://");
				url.append(PortalUtil.getHost(request));
				url.append(":"); 
				url.append(PortalUtil.getPortalPort());
				url.append("/tochuc/ungdung/danhgia/cds?orgId=");
				url.append(rootId);
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				if (newStatus == 2) {
					subject.append("[LARION_CDS]Thông Báo: Hiện tại đang mở đợt CDS ");
					subject.append(periodName);
					
					content.append("<p>Chào bạn "); 
					content.append(userLiferay.getFullName());
					content.append(",</p>");
					content.append("<p>Hiện tại tổ chức <strong>");
					content.append(OrganizationLocalServiceUtil.getOrganization(rootId).getName());
					content.append("</strong> có đợt CDS<strong> ");
					content.append(periodName);
					content.append(" </strong>đang mở từ ngày<strong> ");
					content.append(sdf.format(fromDate));
					content.append("</strong> tới ngày<strong> ");
					content.append(sdf.format(toDate));
					content.append("</strong>.</p>");
					content.append("<p>Bạn có thể nhấp vào link bên dưới để vào ứng dụng và bắt đầu đánh giá CDS:<br /><a href='");
					content.append(url);
					content.append("'>");
					content.append(url);
					content.append("</a></p><p>Trân trọng cảm ơn! <br />ProGate Portal</p><p><hr /> <strong>Lưu ý: </strong> Đây là hệ thống email tự động, vui lòng không trả lời email này</p><p style='padding-top: 20px'>ProGate Portal phát triển bởi LARION Computing, 2011</p>");
				} else if (newStatus == 3) {
					subject.append("[LARION_CDS]Thông Báo: Hiện tại đã đóng đợt CDS ");
					subject.append(periodName);
					
					content.append("<p>Chào bạn "); 
					content.append(userLiferay.getFullName());
					content.append("<p>Hiện tại tổ chức <strong>");
					content.append(OrganizationLocalServiceUtil.getOrganization(rootId).getName());
					content.append("</strong> đã đóng đợt CDS<strong> ");
					content.append(periodName);
					content.append(" </strong></p><p><hr /> <strong>Lưu ý: </strong> Đây là hệ thống email tự động, vui lòng không trả lời email này</p><p style='padding-top: 20px'>ProGate Portal phát triển bởi LARION Computing, 2011</p>");
				}

				mail.setSubject(subject.toString());
				mail.setContent(content.toString());

				try {
					mail.postMail();
					System.out.println("Đã gửi mail thành công");
				} catch (javax.mail.SendFailedException f) {
					System.out.println("Địa chỉ email không tồn tại - " + f);
				} catch (Exception e) {
					System.out.println("Có lỗi khi gửi email - " + e);
				}
			}
		}

	}
}