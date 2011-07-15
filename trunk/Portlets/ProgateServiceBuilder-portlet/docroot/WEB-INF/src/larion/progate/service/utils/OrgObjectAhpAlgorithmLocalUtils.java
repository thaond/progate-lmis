package larion.progate.service.utils;

import java.io.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import org.apache.commons.collections.ListUtils;
import org.apache.tools.ant.types.resources.selectors.Compare;

import com.liferay.portal.SystemException;
import larion.progate.NoSuchOrgObjectListException;
import larion.progate.NoSuchOrgObjectMeasureException;
import larion.progate.NoSuchOrgObjectObjectiveException;
import larion.progate.NoSuchOrgObjectPerspectiveException;
import larion.progate.model.*;

import larion.progate.service.OrgObjectListLocalServiceUtil;
import larion.progate.service.OrgObjectMeasureLocalServiceUtil;
import larion.progate.service.OrgObjectObjectiveLocalServiceUtil;
import larion.progate.service.OrgObjectPerspectiveLocalServiceUtil;
import larion.progate.service.impl.OrgObjectPerspectiveLocalServiceImpl;
import larion.progate.service.persistence.OrgObjectListUtil;
import larion.progate.service.persistence.OrgObjectMeasureUtil;
import larion.progate.service.persistence.OrgObjectObjectiveUtil;
import larion.progate.service.persistence.OrgObjectPerspectiveUtil;

import larion.progate.service.utils.*;

public class OrgObjectAhpAlgorithmLocalUtils {
	public static void ahpAlgorithm (int listID, String filePathString, String randomIndexFileString, 
			String outputFileString) {
		int i;
    	int numberRI; // So luong cac random index
    	String[] B;
    	int numberOfPerspectives = 0; //So luong cac perspectives
    	int numberOfObjectives = 0; //So luong cac objectives
    	int numberOfMeasures = 0; //So luong cac measures
    	double[] randomIndex; //Mang chua cac random index
    	
        File inputFilePath = new File(filePathString);
        File RIFilePath = new File (randomIndexFileString);
        File outputFilePath = new File(outputFileString);
        
        int perSize = 0;
        int objSize = 0;
        int meaSize = 0;
        int countPer = 0;
        int countObj = 0;
        int countMea = 0;
        int j = 0;
        int[] perIDs;
        int[] objIDs;
        int[] objSeeks;
        int[] meaIDs;
        int[] meaSeeks;
        int[] objIDList;
        int[] meaIDList;
        
        List<OrgObjectPerspective> listPer = OrgObjectPerspectiveLocalServiceUtil.getListSetPers(listID);
        perSize = listPer.size();
        perIDs = new int[perSize]; //Mang chua ID cua perspective
        for (OrgObjectPerspective perTmp : listPer) {
			perIDs[countPer] = perTmp.getPrimaryKey();
			countPer++;
		}
        
        objSeeks = new int[perSize];
        for (j = 0; j < perSize; j++) {
        	List<OrgObjectObjective> listObj = OrgObjectObjectiveLocalServiceUtil.getListObjObjs(perIDs[j]);
        	objSize += listObj.size();
        	objSeeks[j] = listObj.size();
        }
        objIDs = new int[objSize]; //Mang chua ID cua objective
        for (j = 0; j < perSize; j++) {
        	List<OrgObjectObjective> listObj1 = OrgObjectObjectiveLocalServiceUtil.getListObjObjs(perIDs[j]);
        	for (OrgObjectObjective objTmp : listObj1) {
				objIDs[countObj] = objTmp.getPrimaryKey();
				countObj++;
			}
        }
        
        meaSeeks = new int[objSize];
        for (j = 0; j < objSize; j++) {
        	List<OrgObjectMeasure> listMea = OrgObjectMeasureLocalServiceUtil.getListObjMsrs(objIDs[j]);
        	meaSize += listMea.size();
        	meaSeeks[j] = listMea.size();
        }
        meaIDs = new int[meaSize]; //Mang chua ID cua measure
        for (j = 0; j < objSize; j++) {
        	List<OrgObjectMeasure> listMea1 = OrgObjectMeasureLocalServiceUtil.getListObjMsrs(objIDs[j]);
        	for (OrgObjectMeasure meaTmp : listMea1) {
				meaIDs[countMea] = meaTmp.getPrimaryKey();
				countMea++;
			}
        }
        
        countPer = 0;
        countObj = 0;
        countMea = 0;

        try {
            FileInputStream inputFile = new FileInputStream(inputFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFile));
            FileInputStream inputRI = new FileInputStream(RIFilePath);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(inputRI));
            String s = new String();
            try {
            	//Doc file chua cac random index va luu vao mang 1 chieu
           	 	s = br2.readLine().trim();
           	 	numberRI = Integer.parseInt(s);
           	 	randomIndex = new double[numberRI];
           	 	s = br2.readLine().trim();
           	 	B = s.split("\t");
           	 	for (i = 0; i < numberRI; i++) {
           	 		randomIndex[i] = Double.parseDouble(B[i]);
           	 	}
           	 
           	 	//Mo file output output.txt
           	 	FileOutputStream outputFile = new FileOutputStream(outputFilePath);
           	 	Writer out = new OutputStreamWriter(outputFile,"UTF8");
           	 	
           	 	//Lay du lieu tu file input, tra ve mot doi tuong chua du lieu can thiet
           	 	readFileObject RFO;
           	 	RFO = getReadFileObject(br);
           	 	
            	//Tinh toan trong so va do khong dong nhat cho 4 perspectives
           	 	numberOfPerspectives += RFO.numberOfRatio;
            	calculateAndPrint(RFO.obj, RFO.numberOfRatio, RFO.pairwiseComparison, randomIndex, out, listID, perIDs);
            	 
            	//Tinh toan trong so va do khong dong nhat cho cac objectives cua moi perspective
            	for (i = 0; i < RFO.numberOfRatio; i++) {
            		RFO = getReadFileObject(br);
            		numberOfObjectives += RFO.numberOfRatio;
            		objIDList = new int[objSeeks[i]];
            		for (j = 0; j < objSeeks[i]; j++) {
            			objIDList[j] = objIDs[countObj+j];
            		}
                	calculateAndPrint(RFO.obj, RFO.numberOfRatio, RFO.pairwiseComparison, randomIndex, out, perIDs[i], objIDList);
                	countObj += objSeeks[i];
            	}            	
            	countObj = 0;
            	
            	//Tinh toan trong so va do khong dong nhat cho cac measures cua moi object
            	for (i = 0; i < numberOfObjectives; i++) {
            		RFO = getReadFileObject(br);
            		numberOfMeasures += RFO.numberOfRatio;
            		meaIDList = new int[meaSeeks[i]];
            		for (j = 0; j < meaSeeks[i]; j++) {
            			meaIDList[j] = meaIDs[countMea+j];
            		}
                	calculateAndPrint(RFO.obj, RFO.numberOfRatio, RFO.pairwiseComparison, randomIndex, out, objIDs[i], meaIDList); 
                	countMea += meaSeeks[i];
            	}
            	countMea = 0;
           
            	out.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
	}
	
	//Ham lam tron so (lam tron 2 chu so thap phan)
    public static double round( double value, int fractionDigits) {
        double d = Math.pow( 10, fractionDigits ) ;

        return( Math.round( value * d ) / d ) ;
    }
    
    //Doc file input va tra ve doi tuong thuoc lop readFileObject chua cac du lieu can thiet
    public static readFileObject getReadFileObject (BufferedReader br) {
    	readFileObject tmp = new readFileObject();
    	String s = new String();
    	String[] B;
    	int i, j;
    	double comparisonNumber; //Cac con so tuong quan giua cac cap danh gia
    	try {
    		//Doc kieu doi tuong can tinh trong so va kich thuoc ma tran
	    	s = br.readLine().trim(); 
	    	B = s.split("\t");
	    	tmp.obj = B[0];
	    	tmp.numberOfRatio = Integer.parseInt(B[1]);
	    	
	    	//Doc ma tran va luu ket qua vao mang 2 chieu tmp.pairwiseComparison
	    	if (tmp.numberOfRatio != 1) {
		    	tmp.pairwiseComparison = new double[tmp.numberOfRatio][tmp.numberOfRatio];
		    	for (i = 0; i < tmp.numberOfRatio; i++) {
		    		s = br.readLine().trim();
		            B = s.split("\t");
		            for(j = 0; j < tmp.numberOfRatio; j++)
		            {
		                comparisonNumber = new Double(B[j].trim());
		                tmp.pairwiseComparison[i][j] = comparisonNumber;
		            }
		    	}
	    	}
	    	
	    	//Bo doc mot dong trong file text
	    	s = br.readLine();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return tmp;
    }
    
    //Tinh toan trong so, do khong dong nhat va xuat ket qua ra file output.txt
    public static void calculateAndPrint(String obj, int numberOfRatio, double[][] pairwiseComparison, 
    		double[] randomIndex, Writer out, int ID, int[] IDs) {  		
		try {
			int i, j;
			double[][] tmpArray = new double[numberOfRatio][numberOfRatio];
			//Tinh toan cac trong so
			out.write("Bo trong so cua " + obj + ": ");
			if (numberOfRatio == 1) {
				out.write("1.0\n");
				writeWeightPercentSuggested(obj, IDs[0], 1.0);
//    				System.out.println("Test ham writeWeightPercentSuggested");
//    				System.out.println(obj);
//    				System.out.println(IDs[0]);
//    				System.out.println("1.0");
//    				System.out.println("Ket thuc ham writeWeightPercentSuggested");
				
				out.write("Do khong dong nhat cua bo trong so nay la: ");
				out.write("0.0\n\n");
				writeConsistency(obj, ID, 0.0);
//    				System.out.println("Test ham writeConsistency");
//    				System.out.println(obj);
//    				System.out.println(ID);
//    				System.out.println("0.0");
//    				System.out.println("Ket thuc ham writeConsistency");
			}
			else {
    			double[] columnSum = new double[numberOfRatio];
    			for (i = 0; i < numberOfRatio; i++) {
    				columnSum[i] = 0;
    			}
    			double[] average = new double[numberOfRatio];
    			for (i = 0; i < numberOfRatio; i++) {
    				average[i] = 0;
    			}
    			
    			for (j = 0; j < numberOfRatio; j++) {
    				for (i = 0; i < numberOfRatio; i++) {
    					columnSum[j] += pairwiseComparison[i][j];
    				}
    			}
    			for (j = 0; j < numberOfRatio; j++) {
    				for (i = 0; i < numberOfRatio; i++) {
    					tmpArray[i][j] = pairwiseComparison[i][j]/columnSum[j];
    				}
    			}
    			for (i = 0; i < numberOfRatio; i++) {
    				for (j = 0; j < numberOfRatio; j++) {
    					average[i] += tmpArray[i][j];
    				}
    				average[i] = average[i]/numberOfRatio;
    				average[i] = round (average[i], 2);
    				
    				writeWeightPercentSuggested(obj, IDs[i], average[i]);
    				
    				out.write(average[i] + "  ");
    			}
    			out.write("\n");
    			
    			//Tinh toan do khong dong nhat
    			out.write("Do khong dong nhat cua bo trong so nay la: ");
    			if (numberOfRatio > 2) {
	    			double[] rootOfProduct = new double[numberOfRatio];
	    			for (i = 0; i < numberOfRatio; i++) {
	    				rootOfProduct[i] = 1;
	    			}
	    			double[] priorityVector = new double[numberOfRatio];
	    			double sumRootOfProduct = 0;
	    			double[] priorityRow = new double[numberOfRatio];
	    			double lambdaMax = 0;
	    			double consistencyIndex;
	    			double consistencyRatio; //Do khong dong nhat
	    			for (i = 0; i < numberOfRatio; i++) {
	    				for (j = 0; j < numberOfRatio; j++) {
	    					rootOfProduct[i] *= pairwiseComparison[i][j];
	    					
	    				}
	    				rootOfProduct[i] = Math.pow(rootOfProduct[i], (double)1/numberOfRatio);
	    				sumRootOfProduct += rootOfProduct[i];
	    			}
	    			for (i = 0; i < numberOfRatio; i++) {
	    				priorityVector[i] = rootOfProduct[i] / sumRootOfProduct;
	    			}
	    			for (i = 0; i < numberOfRatio; i++) {
	    				priorityRow[i] = priorityVector[i] * columnSum[i];
	    				lambdaMax += priorityRow[i];
	    			}    			
	    			consistencyIndex = (lambdaMax - numberOfRatio) / (numberOfRatio - 1);	
    				consistencyRatio = round (consistencyIndex/randomIndex[numberOfRatio - 1], 2);
    				
	    			writeConsistency(obj, ID, consistencyRatio);
    				
    				out.write(consistencyRatio + "\n\n");
    			} else {
    				writeConsistency(obj, ID, 0.0);
    				out.write("0.0\n\n");
    			}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    public static void writeWeightPercentSuggested (String obj, int ID, double value) {
    	if (obj.compareTo("ObjectiveSet") == 0) {
			OrgObjectPerspective orgPerspective;
			try {
				orgPerspective = OrgObjectPerspectiveUtil.findByPrimaryKey(ID);
				orgPerspective.setWeight_percent_suggested(value);
				OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPerspective, true);
			} catch (NoSuchOrgObjectPerspectiveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
    	
		else if (obj.compareTo("F")==0 || obj.compareTo("C")==0 || obj.compareTo("P")==0 || obj.compareTo("G")==0) {    						
			OrgObjectObjective orgObjective;
			try {
				orgObjective = OrgObjectObjectiveUtil.findByPrimaryKey(ID);
				orgObjective.setWeight_percent_suggested(value);
				OrgObjectObjectiveLocalServiceUtil.updateOrgObjectObjective(orgObjective, false);
			} catch (NoSuchOrgObjectObjectiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			OrgObjectMeasure orgMeasure;
			try {
				orgMeasure = OrgObjectMeasureUtil.findByPrimaryKey(ID);
				orgMeasure.setWeight_percent_suggested(value);
				OrgObjectMeasureLocalServiceUtil.updateOrgObjectMeasure(orgMeasure, false);
			} catch (NoSuchOrgObjectMeasureException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 	
    }
    
    public static void writeConsistency (String obj, int ID, double value) {
    	if (obj.compareTo("ObjectiveSet") == 0) {
			try {
				OrgObjectList orgList = OrgObjectListUtil.findByPrimaryKey(ID);
				orgList.setConsistency_ratio(value);
				OrgObjectListLocalServiceUtil.updateOrgObjectList(orgList, true);
			} catch (NoSuchOrgObjectListException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
    	else if (obj.compareTo("F")==0 || obj.compareTo("C")==0 || obj.compareTo("P")==0 || obj.compareTo("G")==0) {    						
			OrgObjectPerspective orgPer;
			try {
				orgPer = OrgObjectPerspectiveUtil.findByPrimaryKey(ID);
				orgPer.setConsistency_ratio(value);
				OrgObjectPerspectiveLocalServiceUtil.updateOrgObjectPerspective(orgPer, false);
			} catch (NoSuchOrgObjectPerspectiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    					
		}
		else {
			OrgObjectObjective orgObj;
			try {
				orgObj = OrgObjectObjectiveUtil.findByPrimaryKey(ID);
				orgObj.setConsistency_ratio(value);
				OrgObjectObjectiveLocalServiceUtil.updateOrgObjectObjective(orgObj, false);
			} catch (NoSuchOrgObjectObjectiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
}