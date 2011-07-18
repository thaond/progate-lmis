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

package larion.progate.lmis.service.persistence;

/**
 * <a href="LmisDataImportsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisDataImports lmisDataImports) {
		getPersistence().cacheResult(lmisDataImports);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDataImports> lmisDataImportses) {
		getPersistence().cacheResult(lmisDataImportses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisDataImports create(
		java.lang.Integer lmisDataImportsId) {
		return getPersistence().create(lmisDataImportsId);
	}

	public static larion.progate.lmis.model.LmisDataImports remove(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().remove(lmisDataImportsId);
	}

	public static larion.progate.lmis.model.LmisDataImports remove(
		larion.progate.lmis.model.LmisDataImports lmisDataImports)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisDataImports);
	}

	public static larion.progate.lmis.model.LmisDataImports update(
		larion.progate.lmis.model.LmisDataImports lmisDataImports)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDataImports);
	}

	public static larion.progate.lmis.model.LmisDataImports update(
		larion.progate.lmis.model.LmisDataImports lmisDataImports, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisDataImports, merge);
	}

	public static larion.progate.lmis.model.LmisDataImports updateImpl(
		larion.progate.lmis.model.LmisDataImports lmisDataImports, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisDataImports, merge);
	}

	public static larion.progate.lmis.model.LmisDataImports findByPrimaryKey(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByPrimaryKey(lmisDataImportsId);
	}

	public static larion.progate.lmis.model.LmisDataImports fetchByPrimaryKey(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisDataImportsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByDataImportOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDataImportOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDataImportOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByDataImportOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByDataImportOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByDataImportOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByDataImportOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports[] findByDataImportOf_PrevAndNext(
		java.lang.Integer lmisDataImportsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence()
				   .findByDataImportOf_PrevAndNext(lmisDataImportsId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByImportBy(importBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByImportBy(importBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByImportBy(importBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByImportBy_First(
		int importBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByImportBy_First(importBy, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByImportBy_Last(
		int importBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByImportBy_Last(importBy, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports[] findByImportBy_PrevAndNext(
		java.lang.Integer lmisDataImportsId, int importBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence()
				   .findByImportBy_PrevAndNext(lmisDataImportsId, importBy, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDateValue(dateValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDateValue(dateValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDateValue(dateValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByDateValue_First(
		java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByDateValue_First(dateValue, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports findByDateValue_Last(
		java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence().findByDateValue_Last(dateValue, obc);
	}

	public static larion.progate.lmis.model.LmisDataImports[] findByDateValue_PrevAndNext(
		java.lang.Integer lmisDataImportsId, java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException {
		return getPersistence()
				   .findByDateValue_PrevAndNext(lmisDataImportsId, dateValue,
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

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImports> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByDataImportOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDataImportOf(rootId);
	}

	public static void removeByImportBy(int importBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByImportBy(importBy);
	}

	public static void removeByDateValue(java.util.Date dateValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDateValue(dateValue);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByDataImportOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDataImportOf(rootId);
	}

	public static int countByImportBy(int importBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByImportBy(importBy);
	}

	public static int countByDateValue(java.util.Date dateValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDateValue(dateValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportDetailses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportDetailses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportDetailses(pk, start, end, obc);
	}

	public static int getLmisDataImportDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisDataImportDetailsesSize(pk);
	}

	public static boolean containsLmisDataImportDetails(java.lang.Integer pk,
		java.lang.Integer lmisDataImportDetailsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisDataImportDetails(pk, lmisDataImportDetailsPK);
	}

	public static boolean containsLmisDataImportDetailses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisDataImportDetailses(pk);
	}

	public static LmisDataImportsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisDataImportsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisDataImportsPersistence _persistence;
}