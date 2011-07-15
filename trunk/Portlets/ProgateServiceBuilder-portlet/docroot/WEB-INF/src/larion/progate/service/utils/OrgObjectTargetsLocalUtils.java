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

package larion.progate.service.utils;

import java.util.*;

import larion.progate.model.OrgObjectTargets;
import larion.progate.service.persistence.OrgObjectTargetsUtil;

/**
 * 
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsLocalUtils {
	 
	public static boolean createObjTargets(int msrId, String name, double tarValue, String description){

	try {
		System.out.println("Tao Target");
		OrgObjectTargets objectTargets = OrgObjectTargetsUtil.create(null);
		objectTargets.setOrgObjectMeasureId(msrId);
		objectTargets.setName(name);
		objectTargets.setDescription(description);
		objectTargets.setValue(tarValue);
		objectTargets.setCreated_date(new Date());
		objectTargets.setMinMax(false);
		
		OrgObjectTargetsUtil.update(objectTargets, false);
		
		System.out.println("Ket thuc tao target");
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
		}
	}


}