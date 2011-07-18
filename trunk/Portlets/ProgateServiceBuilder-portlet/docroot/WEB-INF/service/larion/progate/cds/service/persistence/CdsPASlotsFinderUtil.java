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
 * <a href="CdsPASlotsFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPASlotsFinderUtil {
	public static java.util.List<larion.progate.cds.model.CdsPASlots> getCdsPASlots(
		int userId, int periodId) throws com.liferay.portal.SystemException {
		return getFinder().getCdsPASlots(userId, periodId);
	}

	public static java.util.List<larion.progate.cds.model.CdsPASlots> getCdsPASlotsRatingByUser(
		int userId, int periodId, int ratingStatus)
		throws com.liferay.portal.SystemException {
		return getFinder()
				   .getCdsPASlotsRatingByUser(userId, periodId, ratingStatus);
	}

	public static java.util.List<larion.progate.cds.model.CdsPASlots> getCdsPASlotRatingByPM(
		int periodId, int userId) throws com.liferay.portal.SystemException {
		return getFinder().getCdsPASlotRatingByPM(periodId, userId);
	}

	public static CdsPASlotsFinder getFinder() {
		return _finder;
	}

	public void setFinder(CdsPASlotsFinder finder) {
		_finder = finder;
	}

	private static CdsPASlotsFinder _finder;
}