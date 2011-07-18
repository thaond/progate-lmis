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

package larion.progate.service.persistence;

/**
 * <a href="OrganizationFinderUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationFinderUtil {
	public static java.util.List<larion.progate.model.Organization> getProjectOfPM(
		int rootId, int userId) throws com.liferay.portal.SystemException {
		return getFinder().getProjectOfPM(rootId, userId);
	}

	public static java.util.List<larion.progate.model.Organization> getProjectOfBOD(
		int rootId) throws com.liferay.portal.SystemException {
		return getFinder().getProjectOfBOD(rootId);
	}

	public static java.util.List<larion.progate.model.Organization> getCompany()
		throws com.liferay.portal.SystemException {
		return getFinder().getCompany();
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizationByRootId(
		int rootId) {
		return getFinder().getOrganizationByRootId(rootId);
	}

	public static OrganizationFinder getFinder() {
		return _finder;
	}

	public void setFinder(OrganizationFinder finder) {
		_finder = finder;
	}

	private static OrganizationFinder _finder;
}