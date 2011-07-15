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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsCdp;
import larion.progate.cds.service.base.CdsCdpLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsCdpFinderUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsCdpLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsCdpLocalServiceImpl extends CdsCdpLocalServiceBaseImpl {
	public boolean addCdp(int rootId, int periodId, int userId, int writtenBy,
			String writtenContent) throws SystemException, PortalException {
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			CdsCdp cdp = createCdsCdp(null);
			cdp.setRootId(rootId);
			cdp.setPeriodId(periodId);
			cdp.setUserId(userId);
			cdp.setWrittenBy(writtenBy);
			cdp.setWrittenAt(date);
			cdp.setWrittenContent(writtenContent);
			CdsCdp succeed = addCdsCdp(cdp);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in CdsCdpLocalServiceImpl.addCdp "
					+ e.toString());
			return false;
		}
	}

	public List<CdsCdp> getCdp(int rootId, int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<CdsCdp> cdp = CdsCdpFinderUtil
					.getCdp(rootId, userId, periodId);
			if (cdp == null)
				cdp = new ArrayList<CdsCdp>();
			return cdp;
		} catch (Exception e) {
			System.out.println("ERROR in CdsCdpLocalServiceImpl.getCdp "
					+ e.toString());
			List<CdsCdp> cdpNull = new ArrayList<CdsCdp>();
			return cdpNull;
		}
	}

	// Kiem tra nhan vien co comment chua,chua thi ko cho hien ra trong luoi
	public boolean checkCdp(int rootId, int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<CdsCdp> cdps = getCdp(rootId, userId, periodId);
			for (CdsCdp cdp : cdps) {
				if (cdp.getWrittenContent() != null)
					return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("ERROR in CdsCdpLocalServiceImpl.checkCdp");
			return false;
		}
	}
}