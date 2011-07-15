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

package larion.progate.cds.service.persistence;

/**
 * <a href="CdsPointsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPointsUtil {
	public static void cacheResult(larion.progate.cds.model.CdsPoints cdsPoints) {
		getPersistence().cacheResult(cdsPoints);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPoints> cdsPointses) {
		getPersistence().cacheResult(cdsPointses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPoints create(
		java.lang.Integer pointId) {
		return getPersistence().create(pointId);
	}

	public static larion.progate.cds.model.CdsPoints remove(
		java.lang.Integer pointId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().remove(pointId);
	}

	public static larion.progate.cds.model.CdsPoints remove(
		larion.progate.cds.model.CdsPoints cdsPoints)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPoints);
	}

	public static larion.progate.cds.model.CdsPoints update(
		larion.progate.cds.model.CdsPoints cdsPoints)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPoints);
	}

	public static larion.progate.cds.model.CdsPoints update(
		larion.progate.cds.model.CdsPoints cdsPoints, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPoints, merge);
	}

	public static larion.progate.cds.model.CdsPoints updateImpl(
		larion.progate.cds.model.CdsPoints cdsPoints, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsPoints, merge);
	}

	public static larion.progate.cds.model.CdsPoints findByPrimaryKey(
		java.lang.Integer pointId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByPrimaryKey(pointId);
	}

	public static larion.progate.cds.model.CdsPoints fetchByPrimaryKey(
		java.lang.Integer pointId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(pointId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByrootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPoints findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByrootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPoints findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByrootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPoints[] findByrootId_PrevAndNext(
		java.lang.Integer pointId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByrootId_PrevAndNext(pointId, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByPointName(
		java.lang.String pointName) throws com.liferay.portal.SystemException {
		return getPersistence().findByPointName(pointName);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByPointName(
		java.lang.String pointName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPointName(pointName, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findByPointName(
		java.lang.String pointName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPointName(pointName, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPoints findByPointName_First(
		java.lang.String pointName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByPointName_First(pointName, obc);
	}

	public static larion.progate.cds.model.CdsPoints findByPointName_Last(
		java.lang.String pointName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence().findByPointName_Last(pointName, obc);
	}

	public static larion.progate.cds.model.CdsPoints[] findByPointName_PrevAndNext(
		java.lang.Integer pointId, java.lang.String pointName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPointsException {
		return getPersistence()
				   .findByPointName_PrevAndNext(pointId, pointName, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPoints> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrootId(rootId);
	}

	public static void removeByPointName(java.lang.String pointName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByPointName(pointName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrootId(rootId);
	}

	public static int countByPointName(java.lang.String pointName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByPointName(pointName);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPointsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsPointsPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPointsPersistence _persistence;
}