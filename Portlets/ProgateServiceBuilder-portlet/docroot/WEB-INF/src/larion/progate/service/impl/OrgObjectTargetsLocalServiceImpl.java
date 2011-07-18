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

import larion.progate.service.base.OrgObjectTargetsLocalServiceBaseImpl;

import java.util.*;

import larion.progate.model.OrgObjectTargets;
import larion.progate.service.persistence.OrgObjectTargetsUtil;

import larion.progate.service.utils.OrgObjectTargetsLocalUtils;

/**
 * <a href="OrgObjectTargetsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsLocalServiceImpl
	extends OrgObjectTargetsLocalServiceBaseImpl {
	
//	F21
	public List<OrgObjectTargets> getListMsrTars (int msrId) {
		System.out.println("call function: getListMsrTars");
		try {
			List<OrgObjectTargets> result = new ArrayList<OrgObjectTargets>();
			result = OrgObjectTargetsUtil.findByorgObjectMeasureId(msrId);
			if (result != null) {
				System.out.println("Get completed:" + result.size() + " Targets");
				// print result to check
				for (OrgObjectTargets orgGetting : result) {
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
	
//	F22
	public boolean editMsrTar (OrgObjectTargets orgObjectTargets) {
		System.out.println("Call function: editMsrTar");
		try {
			OrgObjectTargetsUtil.update(orgObjectTargets);
			System.out.println("End function: editMsrTar with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editMsrTar with false return");
			e.printStackTrace();
		}
		return false;
	}
	
//	F23
	public boolean createMsrTar (int msrId, String name, double tarValue, String description) {
		try {
			return OrgObjectTargetsLocalUtils.createObjTargets(msrId, name, tarValue, description);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
//	F24
	public boolean deleteMsrTar (int tarId) {
		System.out.println("Call function: deleteMsrTar");
		try {
			System.out.println("Delete orgTarID:" + tarId);
			OrgObjectTargetsUtil.remove(tarId);
			System.out.println("End function: deleteMsrTar with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("End function: deleteMsrTar with false return");
		return false;
	}

	@Override
	public boolean createMsrTar(int arg0, String arg1, int arg2, String arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}