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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="LmisDataImportsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisDataImportsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisDataImports lmisDataImports);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDataImports> lmisDataImportses);

	public void clearCache();

	public larion.progate.lmis.model.LmisDataImports create(
		java.lang.Integer lmisDataImportsId);

	public larion.progate.lmis.model.LmisDataImports remove(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports remove(
		larion.progate.lmis.model.LmisDataImports lmisDataImports)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports update(
		larion.progate.lmis.model.LmisDataImports lmisDataImports)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports update(
		larion.progate.lmis.model.LmisDataImports lmisDataImports, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports updateImpl(
		larion.progate.lmis.model.LmisDataImports lmisDataImports, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports findByPrimaryKey(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports fetchByPrimaryKey(
		java.lang.Integer lmisDataImportsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDataImportOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports findByDataImportOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports findByDataImportOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports[] findByDataImportOf_PrevAndNext(
		java.lang.Integer lmisDataImportsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByImportBy(
		int importBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports findByImportBy_First(
		int importBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports findByImportBy_Last(
		int importBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports[] findByImportBy_PrevAndNext(
		java.lang.Integer lmisDataImportsId, int importBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findByDateValue(
		java.util.Date dateValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImports findByDateValue_First(
		java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports findByDateValue_Last(
		java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public larion.progate.lmis.model.LmisDataImports[] findByDateValue_PrevAndNext(
		java.lang.Integer lmisDataImportsId, java.util.Date dateValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImports> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByDataImportOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByImportBy(int importBy)
		throws com.liferay.portal.SystemException;

	public void removeByDateValue(java.util.Date dateValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByDataImportOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByImportBy(int importBy)
		throws com.liferay.portal.SystemException;

	public int countByDateValue(java.util.Date dateValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> getLmisDataImportDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisDataImportDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisDataImportDetails(java.lang.Integer pk,
		java.lang.Integer lmisDataImportDetailsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisDataImportDetailses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}