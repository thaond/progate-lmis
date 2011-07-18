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
 * <a href="LmisAbsenceRequestsFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsFinderUtil {
	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getListAbsRequestApprovedBy(
		int rootId, int userId) throws java.lang.Exception {
		return getFinder().getListAbsRequestApprovedBy(rootId, userId);
	}

	public static int checkAbsenceTypeSpec(int rootId, int absenceId)
		throws java.lang.Exception {
		return getFinder().checkAbsenceTypeSpec(rootId, absenceId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> filterByStatusTabManager(
		int rootId, int userId, int status, java.util.ArrayList<Integer> lsArr) {
		return getFinder()
				   .filterByStatusTabManager(rootId, userId, status, lsArr);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> filterByStatusTabOther(
		int rootId, int status) {
		return getFinder().filterByStatusTabOther(rootId, status);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> filterByStatusAndUserTabManager(
		int rootId, int userId, int status, java.util.ArrayList<Integer> lsArr,
		java.util.ArrayList<Integer> lsUser) {
		return getFinder()
				   .filterByStatusAndUserTabManager(rootId, userId, status,
			lsArr, lsUser);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> filterTabManager(
		int rootId, int userId, int absType, int status) {
		return getFinder().filterTabManager(rootId, userId, absType, status);
	}

	public static int getAbsenceIdOfUnexpected(int rootId) {
		return getFinder().getAbsenceIdOfUnexpected(rootId);
	}

	public static java.lang.String getAbsenceNameOfUnexpected(int rootId) {
		return getFinder().getAbsenceNameOfUnexpected(rootId);
	}

	public static LmisAbsenceRequestsFinder getFinder() {
		return _finder;
	}

	public void setFinder(LmisAbsenceRequestsFinder finder) {
		_finder = finder;
	}

	private static LmisAbsenceRequestsFinder _finder;
}