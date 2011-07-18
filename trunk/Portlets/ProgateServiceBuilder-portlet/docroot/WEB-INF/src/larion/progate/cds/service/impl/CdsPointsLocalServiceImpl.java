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

import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.cds.service.base.CdsPointsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsPointsUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsPointsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsPointsLocalServiceImpl extends CdsPointsLocalServiceBaseImpl {
	public boolean addCdsPoint(int rootId, String name, int value, String des,
			int createBy) throws PortalException, SystemException {
		try {
			CdsPoints point = createCdsPoints(null);
			point.setRootId(rootId);
			point.setPointName(name);
			point.setPointValue(value);
			point.setDescription(des);
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			point.setCreatedAt(date);
			point.setCreatedBy(createBy);
			CdsPoints cp = addCdsPoints(point);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPointsLocalServiceImpl.addCdsPoint "
							+ e.toString());
			return false;
		}
	}

	public boolean updateCdsPoint(int pointId, int rootId, String name,
			int value, String des, int updateBy) throws PortalException,
			SystemException {
		try {
			CdsPoints point = getCdsPoints(pointId);
			point.setRootId(rootId);
			point.setPointName(name);
			point.setPointValue(value);
			point.setDescription(des);
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);//Gio lay ra bi cham 7 tieng nen phai cong them
			point.setUpdatedAt(date);
			point.setUpdatedBy(updateBy);
			CdsPoints cp = addCdsPoints(point);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPointsLocalServiceImpl.updateCdsPoint "
							+ e.toString());
			return false;
		}
	}

	public List<CdsPoints> getCdsPointListByRootId(int rootId)
			throws PortalException, SystemException {
		try {
			return CdsPointsUtil.findByrootId(rootId);
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPointsLocalServiceImpl.getCdsPointListByRootId "
							+ e.toString());
			List<CdsPoints> list = new ArrayList<CdsPoints>();
			return list;
		}

	}

	public CdsPoints getCdsPointMax(int rootId) throws PortalException,
			SystemException {
		try {
			List<CdsPoints> pointList = getCdsPointListByRootId(rootId);
			if (pointList.size() > 0)
				return pointList.get(pointList.size() - 1);
			return null;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPointsLocalServiceImpl.getCdsPointMax "
							+ e.toString());
			return null;
		}
	}

	public int getPointValueByPointName(String pointName)
			throws SystemException, PortalException {
		try {
			List<CdsPoints> pointValue = CdsPointsUtil
					.findByPointName(pointName);
			if (pointValue.size() == 0)
				return 0;
			return pointValue.get(0).getPointValue();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPointsLocalServiceImpl.getPointValueByPointName "
							+ e.toString());
			return 0;
		}
	}
}