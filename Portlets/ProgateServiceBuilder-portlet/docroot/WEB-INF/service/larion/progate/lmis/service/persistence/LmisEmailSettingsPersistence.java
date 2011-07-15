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
 * <a href="LmisEmailSettingsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisEmailSettingsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisEmailSettings> lmisEmailSettingses);

	public void clearCache();

	public larion.progate.lmis.model.LmisEmailSettings create(
		java.lang.Integer lmisEmailSettingId);

	public larion.progate.lmis.model.LmisEmailSettings remove(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings remove(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings update(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings update(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings updateImpl(
		larion.progate.lmis.model.LmisEmailSettings lmisEmailSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings findByPrimaryKey(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings fetchByPrimaryKey(
		java.lang.Integer lmisEmailSettingId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailSettingOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings findByEmailSettingOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings findByEmailSettingOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings[] findByEmailSettingOf_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByCategoryId(
		int category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings findByCategoryId_First(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings findByCategoryId_Last(
		int category, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings[] findByCategoryId_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, int category,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findByEmailType(
		java.lang.String emailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisEmailSettings findByEmailType_First(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings findByEmailType_Last(
		java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public larion.progate.lmis.model.LmisEmailSettings[] findByEmailType_PrevAndNext(
		java.lang.Integer lmisEmailSettingId, java.lang.String emailType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisEmailSettingsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByEmailSettingOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByCategoryId(int category)
		throws com.liferay.portal.SystemException;

	public void removeByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByEmailSettingOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByCategoryId(int category)
		throws com.liferay.portal.SystemException;

	public int countByEmailType(java.lang.String emailType)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisEmailSettingDetails> getLmisEmailSettingDetailses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisEmailSettingDetailsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisEmailSettingDetails(java.lang.Integer pk,
		java.lang.Integer lmisEmailSettingDetailsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisEmailSettingDetailses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}