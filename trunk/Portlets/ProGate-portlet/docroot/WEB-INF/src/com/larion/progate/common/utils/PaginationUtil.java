package com.larion.progate.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.Pagination_RS;
import com.liferay.portal.kernel.util.ParamUtil;

public class PaginationUtil {

	public static void paging(PortletRequest request,
			PortletResponse response, Map<String, Object> bean,
			List listObject, String nameOfListObject) throws Exception{
		
		int pageSize = Integer.parseInt(ProGateUtil
				.getConfigValue(request, ConfigParams_RS.NUM_OF_ITEM));
		
		int totalRecord = listObject.size();

		int numOfPage = 1;
		if (totalRecord % pageSize == 0) {
			numOfPage = totalRecord / pageSize;
		} else {
			numOfPage = totalRecord / pageSize + 1;
		}

		int currentPage = ParamUtil.getInteger(request, Pagination_RS.CURRENT_PAGE, 1);

		int fromPage = 0;
		int toPage;

		if (totalRecord == 0) {
			fromPage = 1;
		} else {
			fromPage = 1 + (currentPage - 1) * pageSize;
		}

		toPage = fromPage + pageSize - 1;

		if (toPage > totalRecord) {
			toPage = totalRecord;
		}

		// Check when delete last line
		if (fromPage > toPage) {
			fromPage = fromPage - pageSize;
			currentPage = currentPage - 1;
			if (fromPage > 0) {
				toPage = fromPage + pageSize - 1;
				if (toPage > totalRecord) {
					toPage = totalRecord;
				}
			} else {
				fromPage = 0;
				toPage = 0;
			}
		}

		if (listObject.isEmpty()) {
			bean.put(nameOfListObject + "_listObject" , listObject.subList(0, 0));
		} else {
			bean.put(nameOfListObject + "_listObject", listObject.subList(fromPage - 1, toPage));
		}

		bean.put(nameOfListObject + "_pageSize", pageSize);
		bean.put(nameOfListObject + "_totalRecord", totalRecord);

		bean.put(nameOfListObject + "_numOfPage", numOfPage);
		bean.put(nameOfListObject + "_currentPage", currentPage);
		bean.put(nameOfListObject + "_fromPage", fromPage);
		bean.put(nameOfListObject + "_toPage", toPage);

		List<Integer> pageList = new ArrayList<Integer>();
		for (int i = 1; i <= numOfPage; i++)
			pageList.add(i);
		bean.put(nameOfListObject + "_pageList", pageList);
	}
}
