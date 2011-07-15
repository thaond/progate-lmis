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

import java.util.*;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.OrgObjectList;
import larion.progate.service.base.OrgObjectListLocalServiceBaseImpl;
import larion.progate.service.persistence.OrgObjectListUtil;
import larion.progate.service.utils.OrgObjectListLocalUtils;


/**
 * <a href="OrgObjectListLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListLocalServiceImpl extends OrgObjectListLocalServiceBaseImpl {
	
	public boolean checkExistedOrgSet (int orgId) {
		System.out.println("call function: checkExistedOrgSet");
		try {
			List<OrgObjectList> orgs = OrgObjectListUtil.findByOrgId(orgId);
			System.out.println("call fuction: findByOrgId");
			if (orgs == null || orgs.size() == 0) {
				System.out.println("Not Existed!!!");
				return false;
			} else {
				System.out.println("Existed!!!");
				return true;
			}
		} catch (Exception e) {
		// TODO: handle exception
//			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean createOrgSet (int orgId, int yearValue, int typeValue) {
			// From orgId ==> check existed by year and Type==> 
			// 1. Existed ==> not create
			// 2. Not Existed ==> create
		try {
			
			boolean resultByYear = false;
			boolean resultByQuarter = true;
			boolean resultByMonth = true;
			boolean checkExistedOrgSet = OrgObjectListLocalUtils.checkExistedOrgSet(orgId, yearValue);
			if (checkExistedOrgSet) {
				System.out.println("Org Existed");
				return false;
			} else {
				//begin create org Object
				if (typeValue == 0) {
					//Case create orgObject for year
					resultByYear = OrgObjectListLocalUtils.createOrgObjectSetByYear(orgId, yearValue);
					return resultByYear;
				} else if(typeValue == 1){
					//Case create orgObject for quarter
					resultByYear = OrgObjectListLocalUtils.createOrgObjectSetByYear(orgId, yearValue);
					boolean temp1 = false;					
					for (int i = 1; i < 5; i++) {
						// looking for Id of the yearSet
						List<OrgObjectList> tempYear1 = OrgObjectListUtil.findByOrgObjYear(yearValue);
						List<OrgObjectList> tempYear2 = OrgObjectListUtil.findByOrgObjType(0);
						tempYear1 = ListUtils.intersection(tempYear1, tempYear2);
						int yearId = tempYear1.get(0).getPrimaryKey();
						System.out.println("check yearid" + yearId);
						// create set of quarter in this year
						temp1 = OrgObjectListLocalUtils.createOrgObjectSetByQuarter(orgId, yearValue, i, yearId);
						resultByQuarter = resultByQuarter && temp1;
					}
					return(resultByQuarter && resultByYear);
				}
				else if(typeValue == 2){
					//Case create orgObject for month
					resultByYear = OrgObjectListLocalUtils.createOrgObjectSetByYear(orgId, yearValue);
					boolean temp1 = false;					
					for (int i = 1; i < 5; i++) {
						// looking for Id of the yearSet
						List<OrgObjectList> tempYear1 = OrgObjectListUtil.findByOrgObjYear(yearValue);
						List<OrgObjectList> tempYear2 = OrgObjectListUtil.findByOrgObjType(0);
						tempYear1 = ListUtils.intersection(tempYear1, tempYear2);
						int yearId = tempYear1.get(0).getPrimaryKey(); 
						// create set of quarter in this year
						temp1 = OrgObjectListLocalUtils.createOrgObjectSetByQuarter(orgId, yearValue, i, yearId);
						// looking for Id of the quarterSet
						List<OrgObjectList> tempQuarter1 = OrgObjectListUtil.findByOrgObjYear(yearValue);
						List<OrgObjectList> tempQuarter2 = OrgObjectListUtil.findByOrgObjType(1);
						tempYear1 = ListUtils.intersection(tempQuarter1, tempQuarter2);
						int quarterId = tempQuarter1.get(i-1).getPrimaryKey();
						boolean temp2 = false;
						for (int j = 2; j >= 0; j--) {
							int currentMonth = 3*i-j;
							temp2 = OrgObjectListLocalUtils.createOrgObjectSetByMonth(orgId, yearValue, currentMonth, quarterId);
							resultByMonth = resultByMonth && temp2;
						}
						resultByQuarter = resultByQuarter && temp1;
					}
					
					return(resultByMonth && resultByQuarter && resultByYear);
				}
				else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OrgObjectList> getListOrgSetsByYear (int orgId) {
			
		List<OrgObjectList> result = new ArrayList<OrgObjectList>();
		try {			
			// Method 2: use list intersection
			 List<OrgObjectList> listByOrgId = OrgObjectListUtil.findByOrgId(orgId);  
			 List<OrgObjectList> listByType = OrgObjectListUtil.findByOrgObjType(0);
			 result = ListUtils.intersection(listByOrgId, listByType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed:" + result.size() + " Bo muc tieu");
			// print result to check
			for (OrgObjectList orgGetting : result) {
				System.out.println(orgGetting);
			}
		}
		System.out.println("Get failed!");
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<OrgObjectList> getListOrgSetsByQuarter (int orgId, int yearValue) {
			System.out.println("call function: getListOrgSetsByQuarter");
			List<OrgObjectList> result = new ArrayList<OrgObjectList>();
			try {
				// Method 2: use list intersection
				List<OrgObjectList> listByOrgId = OrgObjectListUtil.findByOrgId(orgId);
				List<OrgObjectList> listByListName = OrgObjectListUtil.findByOrgObjYear(yearValue);
				result = ListUtils.intersection(listByOrgId, listByListName);
				List<OrgObjectList> listByType = OrgObjectListUtil.findByOrgObjType(1);
				result = ListUtils.intersection(result, listByType);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (result != null) {
				System.out.println("Get completed:" + result.size() + " Bo muc tieu");
				// print result to check
				for (OrgObjectList orgGetting : result) {
					System.out.println(orgGetting);
				}
			}
			return result;
	}

	public List<OrgObjectList> getListOrgSetsByMonth (int orgId, int yearValue, int quaterValue) {
		
		System.out.println("call function: getListOrgSetsByMonth");
		List<OrgObjectList> result = new ArrayList<OrgObjectList>();
		try {
			List<OrgObjectList> listByOrgId = OrgObjectListUtil.findByOrgId(orgId);
			
			for (OrgObjectList orgGetting : listByOrgId) {
				int monthHash = orgGetting.getMonth_hash();
				int quarter = monthHash / 100;
				if ((orgGetting.getYear()==yearValue) && (quarter == quaterValue)) {
					if ((monthHash % 100) == 0) {	// remove the quarter OrgObjectList
						continue;
					}
					result.add(orgGetting);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed:" + result.size() + " Bo muc tieu");
			// print result to check
			for (OrgObjectList orgGetting : result) {
				System.out.println(orgGetting);
			}
		}
		System.out.println("Get failed!");
		return result;
	}

	public List<OrgObjectList> getAllListOrgSetsInYear (int orgId, int yearValue) {
		System.out.println("call function: getAllListOrgSetsInYear");
		List<OrgObjectList> result = new ArrayList<OrgObjectList>();
		try {
			List<OrgObjectList> listByOrgId = OrgObjectListUtil.findByOrgId(orgId);
			for (OrgObjectList orgGetting : listByOrgId) {
				if (orgGetting.getYear() == yearValue) {
	//				result.add(tempIndex, orgGetting);
	//				tempIndex++;
					result.add(orgGetting);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed:" + result.size() + " Bo muc tieu");
			// print result to check
			for (OrgObjectList orgGetting : result) {
				System.out.println(orgGetting);
			}
		}
		return result;
	}

	public List<OrgObjectList> getOrgSetsById (int setId) {
		
		System.out.println("call function: getOrgSetsById");
		OrgObjectList parentOrgSet;
		List<OrgObjectList> result = new ArrayList<OrgObjectList>();
		try {
			parentOrgSet = OrgObjectListUtil.findByPrimaryKey(setId);
			List<OrgObjectList> listByOrgId = OrgObjectListUtil.findByOrgId(parentOrgSet.getOrg_id());
			// get year of setId
			int currentYear = parentOrgSet.getYear();
			// currentQuarter = 0 if setYear, >0 if not setYear
			int currentQuarter = parentOrgSet.getMonth_hash()/100;
			// currentMonth = 0 if setQuarter, >0 if not setQuarter 
			int currentMonth = parentOrgSet.getMonth_hash() % 100;
			for (OrgObjectList orgGetting : listByOrgId) {
				if (orgGetting.getYear() == currentYear){
					if (currentMonth > 0){					// case setMonth, no children
						System.out.println("Day la bo muc tieu thang");
						System.out.println("Get completed: " + result.size() + " Bo muc tieu");
						return null;
					}
					else if (currentQuarter > 0){			
							// case setQuarter, only add monthChildren, exclude the current setQuarter
							if (orgGetting.getMonth_hash()/100 == currentQuarter 
									&& orgGetting.getMonth_hash()%100 != 0)
								result.add(orgGetting);
						}
					else{								
						// case setYear, add all children, exclude the current setYear
						if (orgGetting.getPrimaryKey() == setId)
							continue;
						result.add(orgGetting);
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed: " + result.size() + " Bo muc tieu");
			// print result to check
			for (OrgObjectList orgGetting : result) {
				System.out.println(orgGetting);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<OrgObjectList> getListOrgSets (int orgId, int offset, int count, String searchPhrase) {
		System.out.println("call function: getListOrgSets");
		List<OrgObjectList> result = new ArrayList<OrgObjectList>();
	//	int stringIndex;
	//	int countListFound = 0;
		List<OrgObjectList> listByOrgId = new ArrayList<OrgObjectList>();
		
		offset = offset -1;
		try {
			listByOrgId = OrgObjectListUtil.findByOrgId(orgId);
			if (searchPhrase != null) {
				searchPhrase = "%" + searchPhrase + "%";
				List<OrgObjectList> listBySetName = OrgObjectListUtil.findByOrgObjName(searchPhrase);
				
				listByOrgId = ListUtils.intersection(listByOrgId, listBySetName);
			}
			if (offset > listByOrgId.size()) {
				return null;
			} else if ((offset+ count) > listByOrgId.size()) {
				listByOrgId = listByOrgId.subList(offset, listByOrgId.size());
			} else {
				listByOrgId = listByOrgId.subList(offset, offset + count);
			}		
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
		if (result != null) {
			System.out.println("Get completed: " + listByOrgId.size() + " Bo muc tieu");
			// print result to check
			for (OrgObjectList orgGetting : listByOrgId) {
				System.out.println(orgGetting);
			}
		}
		return listByOrgId;
	}

	public boolean deleteOrgSets (List<Integer> listDeletedSetId) {
		System.out.println("Call function: deleteOrgSets");
		try {
			if (listDeletedSetId.size() != 0) { 
				for (Integer setId : listDeletedSetId) {
					System.out.println("Delete orgSetID:" + setId);
					OrgObjectListUtil.remove(setId);
				}
				System.out.println("End function: deleteOrgSets with true return");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("End function: deleteOrtSets with false return");
		return 	false;
	}
	
	public boolean editOrgSets (OrgObjectList orgObjectList) {
		System.out.println("Call function: editOrgSets");
		try {
			OrgObjectListUtil.update(orgObjectList);
			System.out.println("End function: editOrgSets with true return");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("End function: editOrgSets with false return");
			e.printStackTrace();
		}
		return 	false;
	}

	
	

}
