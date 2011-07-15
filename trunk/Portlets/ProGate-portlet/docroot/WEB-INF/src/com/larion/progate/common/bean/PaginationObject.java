package com.larion.progate.common.bean;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.Pagination_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.ParamUtil;

public class PaginationObject {

	private int numOfPage;
	private int currentPage;
	private int fromPage;
	private int toPage;
	private int startIndex;
	private int endIndex;
	private int pageSize = 10;
	private int totalRecord;
	private List<Integer> pageList = new ArrayList<Integer>();
	private String pagingObjectName;
	private String currentPageName;
	private String pageSizeName;
	private List listObject = new ArrayList();
	private List<Integer> itemsPerPage = new ArrayList<Integer>();

	private boolean isNextPaging = true;

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFromPage() {
		return fromPage;
	}

	public void setFromPage(int fromPage) {
		this.fromPage = fromPage;
	}

	public int getToPage() {
		return toPage;
	}

	public void setToPage(int toPage) {
		this.toPage = toPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public String getPagingObjectName() {
		return pagingObjectName;
	}

	public void setPagingObjectName(String pagingObjectName) {
		this.pagingObjectName = pagingObjectName;
	}

	public String getCurrentPageName() {
		return currentPageName;
	}

	public void setCurrentPageName(String currentPageName) {
		this.currentPageName = currentPageName;
	}

	public String getPageSizeName() {
		return pageSizeName;
	}

	public void setPageSizeName(String pageSizeName) {
		this.pageSizeName = pageSizeName;
	}

	public List getListObject() {
		return listObject;
	}

	public void setListObject(List listObject) {
		this.listObject = listObject;
	}

	public List<Integer> getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(List<Integer> itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public boolean isNextPaging() {
		return isNextPaging;
	}

	public void setNextPaging(boolean isNextPaging) {
		this.isNextPaging = isNextPaging;
	}

	public PaginationObject(String pagingObjectName, int totalRecord) {		
		this.itemsPerPage.add(20);
		this.itemsPerPage.add(30);
		this.itemsPerPage.add(50);
		this.itemsPerPage.add(75);
		this.itemsPerPage.add(100);
		
		this.pagingObjectName = pagingObjectName;

		this.currentPageName = Pagination_RS.CURRENT_PAGE
				+ this.pagingObjectName;
		this.pageSizeName = Pagination_RS.PAGE_SIZE + this.pagingObjectName;

		this.totalRecord = totalRecord;
	}

	public void paging(PortletRequest request) throws Exception {

		paging(ParamUtil.getInteger(request, this.currentPageName, 1),
				ParamUtil.getInteger(request, this.pageSizeName, 20));
	}

	public void paging(int currentPage, int pageSize) throws Exception {

		this.pageSize = pageSize;

		if (this.isNextPaging) {
			this.currentPage = currentPage;
		} else {
			this.currentPage = 1;
		}

		paging();
	}

	public void paging() {

		this.numOfPage = 1;
		if (this.totalRecord % this.pageSize == 0) {
			this.numOfPage = this.totalRecord / this.pageSize;
		} else {
			this.numOfPage = this.totalRecord / this.pageSize + 1;
		}

		if (this.currentPage > this.numOfPage) {
			this.currentPage = this.numOfPage;
		}

		this.fromPage = 1;

		if (this.totalRecord == 0) {
			this.fromPage = 1;
		} else {
			this.fromPage = 1 + (this.currentPage - 1) * this.pageSize;
		}

		this.toPage = this.fromPage + this.pageSize - 1;

		if (this.toPage > this.totalRecord) {
			this.toPage = this.totalRecord;
		}

		// Check when delete last line
		if (this.fromPage > this.toPage) {
			this.fromPage = this.fromPage - this.pageSize;
			this.currentPage = this.currentPage - 1;
			if (this.fromPage > 0) {
				this.toPage = this.fromPage + this.pageSize - 1;
				if (this.toPage > this.totalRecord) {
					this.toPage = this.totalRecord;
				}
			} else {
				this.fromPage = 0;
				this.toPage = 0;
			}
		}
		
		if (this.fromPage > 0) {
			this.startIndex = this.fromPage - 1;
		} else {
			this.startIndex = 0;
		}
		
		this.endIndex = this.toPage;
		/*
		if (this.listObject.isEmpty()) {
			this.listObject = this.listObject.subList(0, 0);
		} else {
			this.listObject = this.listObject.subList(this.fromPage - 1,
					this.toPage);
		}*/

		for (int i = 1; i <= this.numOfPage; i++) {
			this.pageList.add(i);
		}
	}
}
