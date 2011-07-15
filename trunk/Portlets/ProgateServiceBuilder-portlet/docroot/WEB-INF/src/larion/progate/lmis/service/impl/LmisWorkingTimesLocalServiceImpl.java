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

import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.lmis.service.base.LmisWorkingTimesLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisWorkingTimesUtil;

/**
 * <a href="LmisWorkingTimesLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisWorkingTimesLocalServiceImpl extends LmisWorkingTimesLocalServiceBaseImpl {
	@Override
	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findByWorkingTimeOf(
			int rootId) throws com.liferay.portal.SystemException {
		return LmisWorkingTimesUtil.findByWorkingTimeOf(rootId);
	}
	@Override
	public java.util.List<larion.progate.lmis.model.LmisWorkingTimes> findBySession(
			java.lang.String sessionName) throws com.liferay.portal.SystemException {
			return LmisWorkingTimesUtil.findBySession(sessionName);
		}
	
	@Override
	public boolean editLmisWorkingTimes (LmisWorkingTimes lmisWorkingTime) {
		System.out.println("Call function: editLmisWorkingTimes");
		try {
			LmisWorkingTimesUtil.update(lmisWorkingTime);
			System.out.println("End function: editLmisWorkingTimes with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editLmisWorkingTimes with false return");
			e.printStackTrace();
		}
		return 	false;
	}
}