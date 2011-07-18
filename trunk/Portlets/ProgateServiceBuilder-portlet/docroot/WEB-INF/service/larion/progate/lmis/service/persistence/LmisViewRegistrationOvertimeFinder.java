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
 * <a href="LmisViewRegistrationOvertimeFinder.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewRegistrationOvertimeFinder {
	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOtReqRoleSpecs(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> getListOtReqRoleUser(
		int rootId, int userId);

	public int countOtRequestPending(int rootId, int userId);

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabOther(
		int rootId, int orgId, int status);

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterTabManager(
		int rootId, int orgId, int userId, int status);

	public java.util.List<larion.progate.lmis.model.LmisViewRegistrationOvertime> filterByDateTabManager(
		int rootId, java.util.Date day, int userId, int status);
}