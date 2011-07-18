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

package larion.progate.cds.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="LevelLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LevelLocalService {
	public larion.progate.cds.model.Level addLevel(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level createLevel(java.lang.Integer levelId);

	public void deleteLevel(java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLevel(larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.cds.model.Level getLevel(java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.cds.model.Level> getLevels(int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLevelsCount() throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level updateLevel(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level updateLevel(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException;

	public boolean deleteCdsLevel(int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean addCdsLevel(int competencyId, java.lang.String name,
		int numberOrder, int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean setAliasNameOfSlots(int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean updateCdsLevel(int levelId, java.lang.String name,
		int numberOrder, int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.cds.model.Level> getLevelListByCompetencyId(
		int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.cds.model.Level> getLevelListByLevelName(
		java.lang.String levelName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public boolean checkLevelName(int rootId, java.lang.String levelName,
		int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}