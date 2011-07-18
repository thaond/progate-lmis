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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="CdsEvaluationPeriodsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsEvaluationPeriodsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> cdsEvaluationPeriodses);

	public void clearCache();

	public larion.progate.cds.model.CdsEvaluationPeriods create(
		java.lang.Integer CdsEvaluationPeriodsId);

	public larion.progate.cds.model.CdsEvaluationPeriods remove(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods remove(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods update(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods update(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods updateImpl(
		larion.progate.cds.model.CdsEvaluationPeriods cdsEvaluationPeriods,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods findByPrimaryKey(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods fetchByPrimaryKey(
		java.lang.Integer CdsEvaluationPeriodsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods findBystatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods findBystatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods[] findBystatus_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods[] findByrootId_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findByisModified(
		boolean isModified, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsEvaluationPeriods findByisModified_First(
		boolean isModified, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods findByisModified_Last(
		boolean isModified, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public larion.progate.cds.model.CdsEvaluationPeriods[] findByisModified_PrevAndNext(
		java.lang.Integer CdsEvaluationPeriodsId, boolean isModified,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsEvaluationPeriodsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsEvaluationPeriods> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBystatus(int status)
		throws com.liferay.portal.SystemException;

	public void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByisModified(boolean isModified)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBystatus(int status)
		throws com.liferay.portal.SystemException;

	public int countByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByisModified(boolean isModified)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}