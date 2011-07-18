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
 * <a href="LmisDataInputsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisDataInputsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisDataInputs lmisDataInputs);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisDataInputs> lmisDataInputses);

	public void clearCache();

	public larion.progate.lmis.model.LmisDataInputs create(
		java.lang.Integer lmisDataInputsId);

	public larion.progate.lmis.model.LmisDataInputs remove(
		java.lang.Integer lmisDataInputsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs remove(
		larion.progate.lmis.model.LmisDataInputs lmisDataInputs)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs update(
		larion.progate.lmis.model.LmisDataInputs lmisDataInputs)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs update(
		larion.progate.lmis.model.LmisDataInputs lmisDataInputs, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs updateImpl(
		larion.progate.lmis.model.LmisDataInputs lmisDataInputs, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs findByPrimaryKey(
		java.lang.Integer lmisDataInputsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs fetchByPrimaryKey(
		java.lang.Integer lmisDataInputsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByUserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs[] findByUserID_PrevAndNext(
		java.lang.Integer lmisDataInputsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByDataInputOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByDataInputOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findByDataInputOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisDataInputs findByDataInputOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs findByDataInputOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public larion.progate.lmis.model.LmisDataInputs[] findByDataInputOf_PrevAndNext(
		java.lang.Integer lmisDataInputsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisDataInputsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisDataInputs> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByDataInputOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByDataInputOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}