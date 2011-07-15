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

package larion.progate.cds.service.persistence;

/**
 * <a href="CdsSlotStatisticalReportFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsSlotStatisticalReportFinderUtil {
	public static java.util.List<larion.progate.cds.model.CdsSlotStatisticalReport> getCdsSlotStatisticalReport(
		int rootId, int userId, int periodId, int levelId)
		throws com.liferay.portal.SystemException {
		return getFinder()
				   .getCdsSlotStatisticalReport(rootId, userId, periodId,
			levelId);
	}

	public static CdsSlotStatisticalReportFinder getFinder() {
		return _finder;
	}

	public void setFinder(CdsSlotStatisticalReportFinder finder) {
		_finder = finder;
	}

	private static CdsSlotStatisticalReportFinder _finder;
}