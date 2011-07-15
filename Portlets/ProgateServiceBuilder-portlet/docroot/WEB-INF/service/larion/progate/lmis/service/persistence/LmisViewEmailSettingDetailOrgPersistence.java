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
 * <a href="LmisViewEmailSettingDetailOrgPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewEmailSettingDetailOrgPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg create(
		java.lang.Integer orgRelatedId);

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg remove(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg remove(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg updateImpl(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByPrimaryKey(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg fetchByPrimaryKey(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailType_First(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailType_Last(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByEmailType_PrevAndNext(
		java.lang.Integer orgRelatedId, java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByRootID_PrevAndNext(
		java.lang.Integer orgRelatedId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_, int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByID_First(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByID_Last(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByID_PrevAndNext(
		java.lang.Integer orgRelatedId, int id_,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByCategory_First(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByCategory_Last(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByCategory_PrevAndNext(
		java.lang.Integer orgRelatedId, int category,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByEmailName_PrevAndNext(
		java.lang.Integer orgRelatedId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByID(int id_) throws com.liferay.portal.SystemException;

	public void removeByCategory(int category)
		throws com.liferay.portal.SystemException;

	public void removeByEmailName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByID(int id_) throws com.liferay.portal.SystemException;

	public int countByCategory(int category)
		throws com.liferay.portal.SystemException;

	public int countByEmailName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}