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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsTitleCompetencies;
import larion.progate.cds.service.CdsTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.base.CdsTitleCompetenciesLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsTitleCompetenciesUtil;

/**
 * <a href="CdsTitleCompetenciesLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsTitleCompetenciesLocalServiceImpl extends
		CdsTitleCompetenciesLocalServiceBaseImpl {
	public boolean addTitleCompetencies(int titleId, int competencyId,
			int pointHash, String pointValue) throws SystemException,
			PortalException {
		try {
			CdsTitleCompetencies titleCompetencies = createCdsTitleCompetencies(null);
			titleCompetencies.setCdsTitleId(titleId);
			titleCompetencies.setCompetencyId(competencyId);
			titleCompetencies.setPointHash(pointHash);
			titleCompetencies.setPointValue(pointValue);

			CdsTitleCompetencies titleCompetencies1 = addCdsTitleCompetencies(titleCompetencies);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in addTitleCompetencies " + e.toString());
			return false;
		}
	}

	// id - Primary key of Title Competencies table
	public boolean updateTitleCompetencies(int id, int pointHash,
			String pointValue) throws SystemException, PortalException {
		try {
			CdsTitleCompetencies titleCompetencies = getCdsTitleCompetencies(id);
			titleCompetencies.setPointHash(pointHash);
			titleCompetencies.setPointValue(pointValue);
			CdsTitleCompetencies titleCompetencies1 = updateCdsTitleCompetencies(titleCompetencies);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in updateTitleCompetencies "
					+ e.toString());
			return false;
		}
	}

	public boolean deleteTitleCompetencies(int titleId) throws SystemException,
			PortalException {
		try {
			CdsTitleCompetenciesUtil.removeByCdsTitleId(titleId);
			return true;
		} catch (Exception e) {
			System.out.println("ERROR in deleteTitleCompetencies "
					+ e.toString());
			return false;
		}
	}

	public List<CdsTitleCompetencies> loadListTitleCompetencies(int titleId)
			throws SystemException, PortalException {
		return CdsTitleCompetenciesUtil.findByCdsTitleId(titleId);
	}

	public List<CdsTitleCompetencies> getCdsTitleCompetenciesListByCompetencyId(
			int competencyId) throws SystemException, PortalException {
		return CdsTitleCompetenciesUtil.findByCompetencyId(competencyId);
	}
}