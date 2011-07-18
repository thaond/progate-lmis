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

import larion.progate.model.OrgObjectObjective;
import larion.progate.service.base.OrgObjectObjectiveLocalServiceBaseImpl;
import larion.progate.service.persistence.OrgObjectObjectiveUtil;
import larion.progate.service.utils.OrgObjectObjectiveLocalUtils;

/**
 * <a href="OrgObjectObjectiveLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveLocalServiceImpl
	extends OrgObjectObjectiveLocalServiceBaseImpl {
//	F13
	public List<OrgObjectObjective> getListObjObjs (int perId) {
		System.out.println("call function: getListPerObjs");
		List<OrgObjectObjective> result = new ArrayList<OrgObjectObjective>();
		try {
			result = OrgObjectObjectiveUtil.findByorgObjectPerspectiveId(perId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed: " + result.size() + " objectives");
			// print result to check
			for (OrgObjectObjective orgGetting : result) {
				System.out.println(orgGetting);
			}
			return result;
		}
		System.out.println("Get failed!");
		return null;
	}
	
//	F14
	public boolean editObjObj (OrgObjectObjective orgObjectObjective) {
		System.out.println("Call function: editPerObj");
		try {
			OrgObjectObjectiveUtil.update(orgObjectObjective);
			System.out.println("End function: editPerObj with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editPerObj with false return");
			e.printStackTrace();
		}
		return false;
	}
	
//	F15
	public boolean createObjObj (int perId, String objName, 
								 double objWeight, String description) {
		try {
			return OrgObjectObjectiveLocalUtils.createObjObjects(perId, objName, objWeight, description);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
//	F16
	public boolean deletePerObj (int objId) {
		System.out.println("Call function: deletePerObj");
		try {
			System.out.println("Delete orgObjID:" + objId);
			OrgObjectObjectiveUtil.remove(objId);
			System.out.println("End function: deletePerObj with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("End function: deletePerObj with false return");
		return false;
	}

	@Override
	public boolean createObjObj(int arg0, String arg1, int arg2, String arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}