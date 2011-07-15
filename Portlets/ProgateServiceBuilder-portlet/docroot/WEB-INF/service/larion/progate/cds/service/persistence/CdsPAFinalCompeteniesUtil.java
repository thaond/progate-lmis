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
 * <a href="CdsPAFinalCompeteniesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPAFinalCompeteniesUtil {
	public static void cacheResult(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies) {
		getPersistence().cacheResult(cdsPAFinalCompetenies);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> cdsPAFinalCompetenieses) {
		getPersistence().cacheResult(cdsPAFinalCompetenieses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies create(
		java.lang.Integer cdsPAFinalCompeteniesId) {
		return getPersistence().create(cdsPAFinalCompeteniesId);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies remove(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().remove(cdsPAFinalCompeteniesId);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies remove(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(cdsPAFinalCompetenies);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies update(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPAFinalCompetenies);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies update(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(cdsPAFinalCompetenies, merge);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies updateImpl(
		larion.progate.cds.model.CdsPAFinalCompetenies cdsPAFinalCompetenies,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(cdsPAFinalCompetenies, merge);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies findByPrimaryKey(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().findByPrimaryKey(cdsPAFinalCompeteniesId);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies fetchByPrimaryKey(
		java.lang.Integer cdsPAFinalCompeteniesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(cdsPAFinalCompeteniesId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies[] findByRootId_PrevAndNext(
		java.lang.Integer cdsPAFinalCompeteniesId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence()
				   .findByRootId_PrevAndNext(cdsPAFinalCompeteniesId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.cds.model.CdsPAFinalCompetenies[] findByUserId_PrevAndNext(
		java.lang.Integer cdsPAFinalCompeteniesId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalCompeteniesException {
		return getPersistence()
				   .findByUserId_PrevAndNext(cdsPAFinalCompeteniesId, userId,
			obc);
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

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.CdsPAFinalCompetenies> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static CdsPAFinalCompeteniesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CdsPAFinalCompeteniesPersistence persistence) {
		_persistence = persistence;
	}

	private static CdsPAFinalCompeteniesPersistence _persistence;
}