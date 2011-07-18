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

package larion.progate.cds.service.impl;

import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.base.CdsTitleMinimumRequirementsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsUtil;

/**
 * <a href="CdsTitleMinimumRequirementsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsTitleMinimumRequirementsLocalServiceImpl extends
		CdsTitleMinimumRequirementsLocalServiceBaseImpl {
	public boolean addTitleMinimumRequirements(int titleId,
			int minimumRequirementId, int levelId) throws SystemException,
			PortalException {
		try {
			CdsTitleMinimumRequirements titleMinimumRequirements = createCdsTitleMinimumRequirements(null);
			titleMinimumRequirements.setTitleId(titleId);
			titleMinimumRequirements
					.setMinimumRequirementId(minimumRequirementId);
			titleMinimumRequirements.setMinimumRequirementLevelId(levelId);
			CdsTitleMinimumRequirements titleMinimumRequirements1 = addCdsTitleMinimumRequirements(titleMinimumRequirements);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in addTitleMinimumRequirements "
					+ e.toString());
			return false;
		}
	}

	// id - Primary key of Title Minimum Requirements table
	public boolean updateTitleMinimumRequirements(int id,
			int minimumRequirementId, int levelId) throws SystemException,
			PortalException {
		try {
			CdsTitleMinimumRequirements titleMinimumRequirements = getCdsTitleMinimumRequirements(id);
			titleMinimumRequirements
					.setMinimumRequirementId(minimumRequirementId);
			titleMinimumRequirements.setMinimumRequirementLevelId(levelId);
			CdsTitleMinimumRequirements titleMinimumRequirements1 = updateCdsTitleMinimumRequirements(titleMinimumRequirements);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in updateTitleMinimumRequirements "
					+ e.toString());
			return false;
		}
	}

	public boolean deleteTitleMinimumRequirements(int titleId)
			throws SystemException, PortalException {
		try {
			CdsTitleMinimumRequirementsUtil.removeByTitleId(titleId);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in deleteTitleMinimumRequirements "
					+ e.toString());
			return false;
		}
	}

	public List<CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementsListByMinimumRequirementId(
			int minimumRequirementId) throws SystemException, PortalException {
		return CdsTitleMinimumRequirementsUtil
				.findByMinimumRequirementId(minimumRequirementId);
	}

	public List<CdsTitleMinimumRequirements> getCdsTitleMinimumRequirementsListByMinimumRequirementLevelId(
			int minimumRequirementLevelId) throws SystemException,
			PortalException {
		return CdsTitleMinimumRequirementsUtil
				.findByMinimumRequirementLevelId(minimumRequirementLevelId);
	}

	public List<CdsTitleMinimumRequirements> loadListTitleMinimumRequirements(
			int titleId) throws SystemException, PortalException {
		return CdsTitleMinimumRequirementsUtil.findByTitleId(titleId);
	}
}