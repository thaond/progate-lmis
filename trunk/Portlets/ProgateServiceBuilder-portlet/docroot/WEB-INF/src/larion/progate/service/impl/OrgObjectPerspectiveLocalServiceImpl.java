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

package larion.progate.service.impl;

import java.util.ArrayList;
import java.util.List;

import larion.progate.model.OrgObjectPerspective;
import larion.progate.service.base.OrgObjectPerspectiveLocalServiceBaseImpl;
import larion.progate.service.persistence.OrgObjectPerspectiveUtil;

/**
 * <a href="OrgObjectPerspectiveLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectiveLocalServiceImpl
	extends OrgObjectPerspectiveLocalServiceBaseImpl {

//	F11
	public List<OrgObjectPerspective> getListSetPers (int setId) {
		System.out.println("call function: getListSetPers");
		List<OrgObjectPerspective> result = new ArrayList<OrgObjectPerspective>();
		try {
			result = OrgObjectPerspectiveUtil.findByorgObjectListId(setId);
//			OrgObjectPerspective tmpPer;
//			int count = result.size();
//			for (int i = count - 1; i > 0; i--) {
//				for (int j = 0; j < i; j++) {
//					if (result.get(j).getPertype() > result.get(j+1).getPertype()) {
//						tmpPer = result.get(j);
//						result.set(j, result.get(j+1));
//						result.set(j+1, tmpPer);
//					}
//				}
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed: " + result.size() + " perspectives");
			// print result to check
			for (OrgObjectPerspective orgGetting : result) {
				System.out.println(orgGetting);
			}
			return result;
		}
		System.out.println("Get failed!");
		return null;
	}
	
//	F12
	public boolean editSetPer (OrgObjectPerspective orgObjectPerspective) {
		System.out.println("Call function: editSetPer");
		try {
			OrgObjectPerspectiveUtil.update(orgObjectPerspective);
			System.out.println("End function: editSetPer with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editSetPer with false return");
			e.printStackTrace();
		}
		return false;
	}
}