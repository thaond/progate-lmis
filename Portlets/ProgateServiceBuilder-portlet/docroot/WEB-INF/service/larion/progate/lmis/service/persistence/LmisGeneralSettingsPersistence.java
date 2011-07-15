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
 * <a href="LmisGeneralSettingsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisGeneralSettingsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisGeneralSettings> lmisGeneralSettingses);

	public void clearCache();

	public larion.progate.lmis.model.LmisGeneralSettings create(
		java.lang.Integer lmisGeneralSettingId);

	public larion.progate.lmis.model.LmisGeneralSettings remove(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings remove(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings update(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings update(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings updateImpl(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings findByPrimaryKey(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings fetchByPrimaryKey(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings[] findByRootID_PrevAndNext(
		java.lang.Integer lmisGeneralSettingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisGeneralSettings findByConfType_First(
		int confType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings findByConfType_Last(
		int confType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public larion.progate.lmis.model.LmisGeneralSettings[] findByConfType_PrevAndNext(
		java.lang.Integer lmisGeneralSettingId, int confType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByConfType(int confType)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByConfType(int confType)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}