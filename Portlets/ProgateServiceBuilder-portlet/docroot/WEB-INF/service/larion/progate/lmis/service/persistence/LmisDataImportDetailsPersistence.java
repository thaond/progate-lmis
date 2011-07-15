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
 * <a href="LmisDataImportDetailsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisDataImportDetailsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDataImportDetails> lmisDataImportDetailses);

	public void clearCache();

	public larion.progate.lmis.model.LmisDataImportDetails create(
		java.lang.Integer lmisDataImportDetailsId);

	public larion.progate.lmis.model.LmisDataImportDetails remove(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails remove(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails update(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails update(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails updateImpl(
		larion.progate.lmis.model.LmisDataImportDetails lmisDataImportDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails findByPrimaryKey(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails fetchByPrimaryKey(
		java.lang.Integer lmisDataImportDetailsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByDataImportDetailsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails findByDataImportDetailsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails findByDataImportDetailsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails[] findByDataImportDetailsOf_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByScannerID(
		java.lang.String scannerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails findByScannerID_First(
		java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails findByScannerID_Last(
		java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails[] findByScannerID_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, java.lang.String scannerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findByImportID(
		int importId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataImportDetails findByImportID_First(
		int importId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails findByImportID_Last(
		int importId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public larion.progate.lmis.model.LmisDataImportDetails[] findByImportID_PrevAndNext(
		java.lang.Integer lmisDataImportDetailsId, int importId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataImportDetailsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataImportDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByDataImportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByScannerID(java.lang.String scannerId)
		throws com.liferay.portal.SystemException;

	public void removeByImportID(int importId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByDataImportDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByScannerID(java.lang.String scannerId)
		throws com.liferay.portal.SystemException;

	public int countByImportID(int importId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}