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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

import org.apache.commons.collections.ListUtils;
import Jama.Matrix;

import com.liferay.portal.SystemException;
import larion.progate.NoSuchOrgObjectListException;
import larion.progate.model.OrgObjectList;
import larion.progate.model.OrgObjectPerspective;
import larion.progate.service.OrgObjectPerspectiveLocalServiceUtil;
import larion.progate.service.persistence.OrgObjectListUtil;
import larion.progate.service.persistence.OrgObjectPerspectiveUtil;

/**
 * 
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListLocalUtils {
	
	public static boolean createOrgObjectSetByYear (int orgIg, int yearValue){
		
		try {
			OrgObjectList newObjectList = OrgObjectListUtil.create(null);
			newObjectList.setOrg_id(orgIg);
			 
			String test = "Năm " + yearValue;
			String str = new String(test.getBytes() ,"UTF-8");
			System.out.println(str);
			newObjectList.setName(str);
			newObjectList.setDescription("");
			newObjectList.setCreated_date(new Date());
			newObjectList.setYear(yearValue);
			newObjectList.setObjtype(0);
			newObjectList.setEntering_percent(0.36);
			newObjectList.setCompletion_percent(0);
			newObjectList.setIsapproved(false);
			newObjectList.setMonth_hash(0);
			newObjectList.setValidweight(false);
			newObjectList.setCurrent_total_cost(0);
			newObjectList.setExpected_completion(1.2);
			newObjectList.setNext_total_cost(0);
			
			OrgObjectListUtil.update(newObjectList, false);
			
			createOrgObjectPerspective(newObjectList.getPrimaryKey());
			
			return true;
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static boolean createOrgObjectSetByQuarter (int orgIg, int yearValue, int quarter, int parentId){
		
		try {
			System.out.println("check parentID =" + parentId);
			OrgObjectList newObjectList = OrgObjectListUtil.create(null);
			newObjectList.setOrg_id(orgIg);
			newObjectList.setName("Quý " + quarter + " - Năm "+ yearValue);
			newObjectList.setDescription("");
			newObjectList.setCreated_date(new Date());
			newObjectList.setYear(yearValue);
			newObjectList.setObjtype(1);
			newObjectList.setEntering_percent(0.36);
			newObjectList.setCompletion_percent(0);
			newObjectList.setIsapproved(false);
			newObjectList.setMonth_hash(quarter*100);
			newObjectList.setValidweight(false);
			newObjectList.setCurrent_total_cost(0);
			newObjectList.setExpected_completion(1.2);
			newObjectList.setNext_total_cost(0);
			System.out.println("check lan 2 parentID =" + parentId);
			newObjectList.setParentid(parentId);
			
			OrgObjectListUtil.update(newObjectList, false);
			
			createOrgObjectPerspective(newObjectList.getPrimaryKey());
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

public static boolean createOrgObjectSetByMonth (int orgIg, int yearValue, int month, int parentId){
		
		try {
			int quarter = ((month - 1)/3) + 1;
			OrgObjectList newObjectList = OrgObjectListUtil.create(null);
			newObjectList.setOrg_id(orgIg);
			newObjectList.setName("Tháng " + month + " - Quý " + quarter + "- Năm " + yearValue);
			newObjectList.setDescription("");
			newObjectList.setCreated_date(new Date());
			newObjectList.setYear(yearValue);
			newObjectList.setObjtype(2);
			newObjectList.setEntering_percent(0.36);
			newObjectList.setCompletion_percent(0);
			newObjectList.setIsapproved(false);
			newObjectList.setMonth_hash(quarter*100 + month);
			newObjectList.setValidweight(false);
			newObjectList.setCurrent_total_cost(0);
			newObjectList.setExpected_completion(1.2);
			newObjectList.setNext_total_cost(0);
			newObjectList.setParentid(parentId);
			
			OrgObjectListUtil.update(newObjectList, false);
			createOrgObjectPerspective(newObjectList.getPrimaryKey());
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean checkExistedOrgSet (int orgId, int yearValue){
		
		try {
			List<OrgObjectList> orgObjectListByOrgId = OrgObjectListUtil.findByOrgId(orgId);
			List<OrgObjectList> orgObjectListByYear = OrgObjectListUtil.findByOrgObjYear(yearValue);
			
			List<OrgObjectList> checkOrgObjList = ListUtils.intersection(orgObjectListByOrgId, orgObjectListByYear);
			if ((checkOrgObjList != null) && (checkOrgObjList.size() > 0)) {
				System.out.println("Org Set Existed");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean createOrgObjectPerspective (int obj_id){
		
		try {
			Map<Integer, String> listPerName = new HashMap<Integer, String>();
			listPerName.put(0, "Financial");
			listPerName.put(1, "Customer");
			listPerName.put(2, "Internal Process");
			listPerName.put(3, "Learning & Growth");
			
			for (int i = 0; i < listPerName.size(); i++) {
				OrgObjectPerspective perspective = OrgObjectPerspectiveUtil.create(null);
				perspective.setOrgObjectListId(obj_id);
				perspective.setName(listPerName.get(i));
				perspective.setDescription(listPerName.get(i));
				perspective.setWeight_percent(0);
				perspective.setEntering_percent(0.2);
				perspective.setCompletion_percent(0);
				perspective.setObjective_count(0);
				perspective.setValidweight(false);
				
				perspective.setPertype(i);
				perspective.setCurrent_cost(0);
				perspective.setNext_cost(0);
				OrgObjectPerspectiveUtil.update(perspective, false);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	public static void costAlg( int setID){
		
		// Algorithm Variables
	    double CTC;
	    double NTC;
	    double NTCb;
	    double CF, NF, NFb, CF2, NF2, NFb2;
	    double CC, NC, NCb, CC2, NC2, NCb2;
	    double CP, NP, NPb, CP2, NP2, NPb2;
	    double CG, NG, NGb, CG2, NG2, NGb2;
	    double eCompletion;

	    // calculate matrixes
	    double[] u = {1, 1, 1, 1};
	    double m1, m2, m3, m4;
	    double c1, c2, c3, c4;
	    double c11, c12, c13, c14;
	    double c21, c22, c23, c24;
	    double c31, c32, c33, c34;
	    double c41, c42, c43, c44;
	    double rf1, rc1, rp1, rg1, rtotal1;
	    double rf2, rc2, rp2, rg2, rtotal2;
	    double[] r = new double[17];

	    // store data of matrixes and vectors
	    double[] m = new double[4];
	    double[] c = new double[4];
	    double[][] C = new double[4][4];
	    double[][] Ci = new double[4][4];
	    double[][] result1 = new double [4][4];
	    double[][] result2 = new double [4][4];
	    Matrix MC;
	    Matrix MCi;
	    NumberFormat formatter = new DecimalFormat("#0.00");

	    double det1, det11, det12, det13, det14;
	    double det2, det21, det22, det23, det24;
	    double det3, det31, det32, det33, det34;
	    double mci1, mci2, mci3, mci4;
	    double uci1, uci2, uci3, uci4;
	    
	    try {
			OrgObjectList orgList = OrgObjectListUtil.findByPrimaryKey(setID);
			List<OrgObjectPerspective> orgPer = OrgObjectPerspectiveLocalServiceUtil.getListSetPers(setID);
			
			// intialize value of variables
			CTC = orgList.getCurrent_total_cost();
			NTC = orgList.getNext_total_cost();
			NTCb = orgList.getNext_total_cost();
			eCompletion = orgList.getExpected_completion();
			CF2 = orgPer.get(0).getCurrent_cost();
			CC2 = orgPer.get(1).getCurrent_cost();
			CP2 = orgPer.get(2).getCurrent_cost();
			CG2 = orgPer.get(3).getCurrent_cost();
			// reading completion percent of perspective
			m1 = orgPer.get(0).getCompletion_percent();
			m2 = orgPer.get(1).getCompletion_percent();
			m3 = orgPer.get(2).getCompletion_percent();
			m4 = orgPer.get(3).getCompletion_percent();
			
			// calculate data for 2 algorithms
			// use alternate variable
			c1 = CF2;
			c2 = CC2;
			c3 = CP2;
			c4 = CG2;

			// calculate matrix C
	         c11 = m1;
	         c12 = (m1*c1/100 + m2*c2/100)-m1*m2;
	         c13 = (m1*c1/100 + m3*c3/100)-m1*m3;
	         c14 = (m1*c1/100 + m4*c4/100)-m1*m4;

	         c21 = (m2*c2/100 + m1*c1/100)-m2*m1;
	         c22 = m2;
	         c23 = (m2*c2/100 + m3*c3/100)-m2*m3;
	         c24 = (m2*c2/100 + m4*c4/100)-m2*m4;

	         c31 = (m3*c3/100 + m1*c1/100)-m3*m1;
	         c32 = (m3*c3/100 + m2*c2/100)-m3*m2;
	         c33 = m3;
	         c34 = (m3*c3/100 + m4*c4/100)-m3*m4;

	         c41 = (m4*c4/100 + m1*c1/100)-m4*m1;
	         c42 = (m4*c4/100 + m2*c2/100)-m4*m2;
	         c43 = (m4*c4/100 + m3*c3/100)-m4*m3;
	         c44 = m4;

	         //initialize matrix, be care of array number
	         C[0][0] = c11; C[1][0] = c21; C[2][0] = c31; C[3][0] = c41;
	         C[0][1] = c12; C[1][1] = c22; C[2][1] = c32; C[3][1] = c42;
	         C[0][2] = c13; C[1][2] = c23; C[2][2] = c33; C[3][2] = c43;
	         C[0][3] = c14; C[1][3] = c24; C[2][3] = c34; C[3][3] = c44;

	         // inverse Matrix C to get Matrix C-1
	         MC = new Jama.Matrix(C);
	         MCi = MC.inverse();
	         result1 = MCi.getArrayCopy();
	         r[1]  = result1[0][0];
	         r[2]  = result1[0][1];
	         r[3]  = result1[0][2];
	         r[4]  = result1[0][3];
	         r[5]  = result1[1][0];
	         r[6]  = result1[1][1];
	         r[7]  = result1[1][2];
	         r[8]  = result1[1][3];
	         r[9]  = result1[2][0];
	         r[10] = result1[2][1];
	         r[11] = result1[2][2];
	         r[12] = result1[2][3];
	         r[13] = result1[3][0];
	         r[14] = result1[3][1];
	         r[15] = result1[3][2];
	         r[16] = result1[3][3];
	         
	         // Matrix uCi
	         rf1 = r[1] + r[5] + r[9]  + r[13];
	         rc1 = r[2] + r[6] + r[10] + r[14];
	         rp1 = r[3] + r[7] + r[11] + r[15];
	         rg1 = r[4] + r[8] + r[12] + r[16];
	         rtotal1 = rf1 + rc1 + rp1 + rg1;
	         
	         // Algorithm 1
	         NF2 = rf1/rtotal1*100;
             NC2 = rc1/rtotal1*100;
             NP2 = rp1/rtotal1*100;
             NG2 = rg1/rtotal1*100;
             
             orgPer.get(0).setNext_cost(NF2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(0), true);
             orgPer.get(1).setNext_cost(NC2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(1), true);
             orgPer.get(2).setNext_cost(NP2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(2), true);
             orgPer.get(3).setNext_cost(NG2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(3), true);
					
             // Algorithm 2
             // calculate matrix mCi
             mci1 = m1*r[1] + m2*r[5] + m3*r[9]  + m4*r[13];
             mci2 = m1*r[2] + m2*r[6] + m3*r[10] + m4*r[14];
             mci3 = m1*r[3] + m2*r[7] + m3*r[11] + m4*r[15];
             mci4 = m1*r[4] + m2*r[8] + m3*r[12] + m4*r[16];
             // calculate matrix uCi
             uci1 = rf1;
             uci2 = rc1;
             uci3 = rp1;
             uci4 = rg1;
             // calculate for det 1
             det11 = 1.0;
             det12 = uci1*m1 + uci2*m2 + uci3*m3 + uci4*m4;
             det13 = eCompletion;
             det14 = mci1*m1 + mci2*m2 + mci3*m3 + mci4*m4;
             det1 = det11*det14 - det12*det13;
             // calculate for det 2, notice that det23 = det12
             det21 = uci1 + uci2 + uci3 + uci4;
             det22 = 1.0;
             det23 = mci1 + mci2 + mci3 + mci4;
             det24 = eCompletion;
             det2 = det21*det24 - det22*det23;
             // calculate for det 3
             det31 = det21;
             det32 = det12;
             det33 = det23;
             det34 = det14;
             det3 = det31*det34 - det32*det33;

             //calculate for result
             rf2 = uci1*det1 + mci1*det2;
             rc2 = uci2*det1 + mci2*det2;
             rp2 = uci3*det1 + mci3*det2;
             rg2 = uci4*det1 + mci4*det2;
             rtotal2 = det3;

             NFb2 = rf2/rtotal2*100;
             NCb2 = rc2/rtotal2*100;
             NPb2 = rp2/rtotal2*100;
             NGb2 = rg2/rtotal2*100;
             
             orgPer.get(0).setNext_cost2(NFb2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(0), true);
             orgPer.get(1).setNext_cost2(NCb2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(1), true);
             orgPer.get(2).setNext_cost2(NPb2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(2), true);
             orgPer.get(3).setNext_cost2(NGb2/100);
             OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer.get(3), true);
           
             // end of two algorithms with updated value for cost
			
		} catch (NoSuchOrgObjectListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}