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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.ViewSlotInformation;
import larion.progate.cds.service.base.ViewSlotInformationLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.ViewSlotInformationFinderUtil;

/**
 * <a href="ViewSlotInformationLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewSlotInformationLocalServiceImpl extends
		ViewSlotInformationLocalServiceBaseImpl {
	public List<ViewSlotInformation> getSlotInformationListBySlotIdAndUserId(
			int slotId, int userId) throws PortalException, SystemException {
		try {
			List<ViewSlotInformation> slotInformation = ViewSlotInformationFinderUtil
					.getViewSlotInformationListBySlotIdAndUserId(slotId, userId);
			if (slotInformation == null)
				slotInformation = new ArrayList<ViewSlotInformation>();
			return slotInformation;

		} catch (Exception e) {
			System.out
					.println("ViewSlotInformationLocalServiceImpl.getSlotInformationListBySlotIdAndUserId() "
							+ e.toString());
			List<ViewSlotInformation> tmp = new ArrayList<ViewSlotInformation>();
			return tmp;
		}
	}
}