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
 * <a href="LmisViewAttInfoFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoFinderUtil {
	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> getListAttManageByPM(
		int rootId, int pmId, java.util.Date dayValue, java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getFinder().getListAttManageByPM(rootId, pmId, dayValue, name);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> getListAttManageByBOD(
		int rootId, int bodId, java.util.Date dayValue, java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getFinder().getListAttManageByBOD(rootId, bodId, dayValue, name);
	}

	public static LmisViewAttInfoFinder getFinder() {
		return _finder;
	}

	public void setFinder(LmisViewAttInfoFinder finder) {
		_finder = finder;
	}

	private static LmisViewAttInfoFinder _finder;
}