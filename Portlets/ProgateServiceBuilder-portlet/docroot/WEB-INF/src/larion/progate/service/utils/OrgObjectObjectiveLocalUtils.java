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

import larion.progate.model.OrgObjectObjective;
import larion.progate.service.persistence.OrgObjectObjectiveUtil;

/**
 * 
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveLocalUtils {
	public static boolean createObjObjects (int perId, String objName, 
			 double objWeight, String description){

	try {
		System.out.println("create Object");
		OrgObjectObjective objectObj = OrgObjectObjectiveUtil.create(null);
		System.out.println("create Object");
		System.out.println(objectObj);
		System.out.println(objectObj.getPrimaryKey());
		objectObj.setOrgObjectPerspectiveId(perId);
		objectObj.setName(objName);
		objectObj.setDescription(description);
		objectObj.setCreated_date(new Date());
		objectObj.setWeight_percent(objWeight);
		objectObj.setEntering_percent(0.2);
		objectObj.setCompletion_percent(0);
		objectObj.setMeasure_count(0);
		objectObj.setValidweight(false);
		
		OrgObjectObjectiveUtil.update(objectObj, false);
		
		
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	}

}