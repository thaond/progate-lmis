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
 * <a href="LmisViewEmailSettingDetailOrgUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewEmailSettingDetailOrgUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg) {
		getPersistence().cacheResult(lmisViewEmailSettingDetailOrg);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> lmisViewEmailSettingDetailOrgs) {
		getPersistence().cacheResult(lmisViewEmailSettingDetailOrgs);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg create(
		java.lang.Integer orgRelatedId) {
		return getPersistence().create(orgRelatedId);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg remove(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().remove(orgRelatedId);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg remove(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewEmailSettingDetailOrg);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewEmailSettingDetailOrg);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg update(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewEmailSettingDetailOrg, merge);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg updateImpl(
		larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewEmailSettingDetailOrg, merge);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByPrimaryKey(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByPrimaryKey(orgRelatedId);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg fetchByPrimaryKey(
		java.lang.Integer orgRelatedId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgRelatedId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType) throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailType(
		java.lang.String emailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailType(emailType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailType_First(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByEmailType_First(emailType, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailType_Last(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByEmailType_Last(emailType, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByEmailType_PrevAndNext(
		java.lang.Integer orgRelatedId, java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence()
				   .findByEmailType_PrevAndNext(orgRelatedId, emailType, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByRootID_PrevAndNext(
		java.lang.Integer orgRelatedId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence()
				   .findByRootID_PrevAndNext(orgRelatedId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_) throws com.liferay.portal.SystemException {
		return getPersistence().findByID(id_);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_, int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findByID(id_, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByID(
		int id_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByID(id_, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByID_First(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByID_First(id_, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByID_Last(
		int id_, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByID_Last(id_, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByID_PrevAndNext(
		java.lang.Integer orgRelatedId, int id_,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByID_PrevAndNext(orgRelatedId, id_, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category) throws com.liferay.portal.SystemException {
		return getPersistence().findByCategory(category);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCategory(category, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByCategory(
		int category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByCategory(category, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByCategory_First(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByCategory_First(category, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByCategory_Last(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByCategory_Last(category, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByCategory_PrevAndNext(
		java.lang.Integer orgRelatedId, int category,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence()
				   .findByCategory_PrevAndNext(orgRelatedId, category, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailName(name);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailName(name, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findByEmailName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByEmailName(name, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByEmailName_First(name, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg findByEmailName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence().findByEmailName_Last(name, obc);
	}

	public static larion.progate.lmis.model.LmisViewEmailSettingDetailOrg[] findByEmailName_PrevAndNext(
		java.lang.Integer orgRelatedId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewEmailSettingDetailOrgException {
		return getPersistence()
				   .findByEmailName_PrevAndNext(orgRelatedId, name, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByEmailType(emailType);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByID(int id_)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByID(id_);
	}

	public static void removeByCategory(int category)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByCategory(category);
	}

	public static void removeByEmailName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByEmailName(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByEmailType(emailType);
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByID(int id_)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByID(id_);
	}

	public static int countByCategory(int category)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByCategory(category);
	}

	public static int countByEmailName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByEmailName(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewEmailSettingDetailOrgPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewEmailSettingDetailOrgPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewEmailSettingDetailOrgPersistence _persistence;
}