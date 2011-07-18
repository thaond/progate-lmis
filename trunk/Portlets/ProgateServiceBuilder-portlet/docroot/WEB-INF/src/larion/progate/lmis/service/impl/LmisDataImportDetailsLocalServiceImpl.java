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

package larion.progate.lmis.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisDataImportDetails;
import larion.progate.lmis.service.base.LmisDataImportDetailsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisDataImportDetailsUtil;

/**
 * <a href="LmisDataImportDetailsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDataImportDetailsLocalServiceImpl
	extends LmisDataImportDetailsLocalServiceBaseImpl {
	public List<LmisDataImportDetails> findByRootId(int rootId) throws PortalException,SystemException{
		return LmisDataImportDetailsUtil.findByDataImportDetailsOf(rootId);
	}
	public List<LmisDataImportDetails> findByImportID(int importId) throws PortalException,SystemException{
		return LmisDataImportDetailsUtil.findByImportID(importId);
	}
	public List<LmisDataImportDetails> findByScanerId(String scannerId) throws PortalException,SystemException{
		return LmisDataImportDetailsUtil.findByScannerID(scannerId);
	}
}