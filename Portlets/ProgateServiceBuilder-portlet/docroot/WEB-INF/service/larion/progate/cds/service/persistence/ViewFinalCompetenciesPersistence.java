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
 * <a href="ViewFinalCompetenciesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewFinalCompetenciesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.ViewFinalCompetencies> viewFinalCompetencieses);

	public void clearCache();

	public larion.progate.cds.model.ViewFinalCompetencies create(
		java.lang.Integer competencyId);

	public larion.progate.cds.model.ViewFinalCompetencies remove(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewFinalCompetenciesException;

	public larion.progate.cds.model.ViewFinalCompetencies remove(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewFinalCompetencies update(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewFinalCompetencies update(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewFinalCompetencies updateImpl(
		larion.progate.cds.model.ViewFinalCompetencies viewFinalCompetencies,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewFinalCompetencies findByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewFinalCompetenciesException;

	public larion.progate.cds.model.ViewFinalCompetencies fetchByPrimaryKey(
		java.lang.Integer competencyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewFinalCompetencies> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewFinalCompetencies> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewFinalCompetencies> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}