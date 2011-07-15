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

import larion.progate.service.base.OrgObjectMeasureLocalServiceBaseImpl;

import java.util.*;

import larion.progate.model.OrgObjectMeasure;
import larion.progate.service.persistence.OrgObjectMeasureUtil;

import larion.progate.service.utils.OrgObjectMeasureLocalUtils;

/**
 * <a href="OrgObjectMeasureLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectMeasureLocalServiceImpl
	extends OrgObjectMeasureLocalServiceBaseImpl {
	
//	F17
	public List<OrgObjectMeasure> getListObjMsrs (int objId) {
		System.out.println("call function: getListObjMsrs");
		try {
			List<OrgObjectMeasure> result = new ArrayList<OrgObjectMeasure>();
			result = OrgObjectMeasureUtil.findByOrgObjectObjectiveId(objId);
			if (result != null) {
				System.out.println("Get completed:" + result.size() + " Measures");
				// print result to check
				for (OrgObjectMeasure orgGetting : result) {
					System.out.println(orgGetting);
				}
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		System.out.println("Get failed!");
		return null;
	}
	
//	F18
	public boolean editObjMsr (OrgObjectMeasure orgObjectMeasure) {
		System.out.println("Call function: editObjMsr");
		try {
			OrgObjectMeasureUtil.update(orgObjectMeasure);
			System.out.println("End function: editObjMsr with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editObjMsr with false return");
			e.printStackTrace();
		}
		return false;
	}
	
//	F19
	public boolean createObjMsr (int objId, String msrName, double msrWeight, double result, 
								 String formula, String description) {
		
		try {			
			return OrgObjectMeasureLocalUtils.createObjMeasure(objId, msrName, msrWeight, result, formula, description);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
//	F20
	public boolean deleteObjMsr (int msrId) {
		System.out.println("Call function: deleteObjMsr");
		try {
			System.out.println("Delete orgMsrID:" + msrId);
			OrgObjectMeasureUtil.remove(msrId);
			System.out.println("End function: deleteObjMsr with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("End function: deleteObjMsr with false return");
		return false;
	}

@Override
public boolean createObjMsr(int arg0, String arg1, int arg2, String arg3,
		String arg4) {
	// TODO Auto-generated method stub
	return false;
}
}