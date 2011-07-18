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
 * <a href="LmisViewEmailSettingDetailUserPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewEmailSettingDetailUserPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> lmisViewEmailSettingDetailUsers);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser create(
		java.lang.Integer userRelatedId);

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser remove(
		java.lang.Integer userRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser remove(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser updateImpl(
		larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByPrimaryKey(
		java.lang.Integer userRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser fetchByPrimaryKey(
		java.lang.Integer userRelatedId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailType(
		java.lang.String emailType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailType(
		java.lang.String emailType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailType(
		java.lang.String emailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByEmailType_First(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByEmailType_Last(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser[] findByEmailType_PrevAndNext(
		java.lang.Integer userRelatedId, java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser[] findByRootID_PrevAndNext(
		java.lang.Integer userRelatedId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByID(
		int id_) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByID(
		int id_, int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByID(
		int id_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByID_First(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByID_Last(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser[] findByID_PrevAndNext(
		java.lang.Integer userRelatedId, int id_,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByCategory(
		int category) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByCategory(
		int category, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByCategory(
		int category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByCategory_First(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByCategory_Last(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser[] findByCategory_PrevAndNext(
		java.lang.Integer userRelatedId, int category,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findByEmailName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByEmailName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser findByEmailName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public larion.progate.lmis.model.LmisViewEmailSettingDetailUser[] findByEmailName_PrevAndNext(
		java.lang.Integer userRelatedId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailUserException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> findAll(
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