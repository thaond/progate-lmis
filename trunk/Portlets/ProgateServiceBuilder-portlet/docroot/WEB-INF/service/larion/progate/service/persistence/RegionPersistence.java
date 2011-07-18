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

package larion.progate.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="RegionPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface RegionPersistence extends BasePersistence {
	public void cacheResult(larion.progate.model.Region region);

	public void cacheResult(java.util.List<larion.progate.model.Region> regions);

	public void clearCache();

	public larion.progate.model.Region create(java.lang.Integer regionId);

	public larion.progate.model.Region remove(java.lang.Integer regionId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region remove(
		larion.progate.model.Region region)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region update(
		larion.progate.model.Region region)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region update(
		larion.progate.model.Region region, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region updateImpl(
		larion.progate.model.Region region, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region findByPrimaryKey(
		java.lang.Integer regionId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region fetchByPrimaryKey(
		java.lang.Integer regionId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region findByname_First(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region findByname_Last(java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region[] findByname_PrevAndNext(
		java.lang.Integer regionId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public java.util.List<larion.progate.model.Region> findByactive(
		boolean active) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region findByactive_First(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region findByactive_Last(boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region[] findByactive_PrevAndNext(
		java.lang.Integer regionId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public java.util.List<larion.progate.model.Region> findByregionCode(
		java.lang.String regionCode) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByregionCode(
		java.lang.String regionCode, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findByregionCode(
		java.lang.String regionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Region findByregionCode_First(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region findByregionCode_Last(
		java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public larion.progate.model.Region[] findByregionCode_PrevAndNext(
		java.lang.Integer regionId, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchRegionException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findAll(int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Region> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByactive(boolean active)
		throws com.liferay.portal.SystemException;

	public void removeByregionCode(java.lang.String regionCode)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByactive(boolean active)
		throws com.liferay.portal.SystemException;

	public int countByregionCode(java.lang.String regionCode)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}