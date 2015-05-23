package edu.tudelft.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.tudelft.sps.model.ClassifierData;

;

public class QueueUtil {

	public static double getDoubleFromString(String str) {

		if (!str.trim().isEmpty()) {
			return Double.parseDouble(str.trim());
		}
		return 0.0;
	}

	/* normal curve */

	public static double getProbability(double x, double mean, double sigma) {

		double oneOverSqrt2TimePITimesSigma = 1 / (Math.sqrt(2 * Math.PI) * sigma);
		double order1 = Math.pow(x - mean, 2);
		double sigmaPow2 = Math.pow(sigma, 2);
		double order2 = 2 * sigmaPow2;
		double order = order1 / order2;
		double ePower = Math.pow(Math.E, -order);
		double probability = oneOverSqrt2TimePITimesSigma * ePower;

		return probability;

	}
	
	public static Map<Integer,List<ClassifierData>> toMap(List<ClassifierData> cdList, boolean sortBeaconID){
		
		Map<Integer, List<ClassifierData>>sortedMap= new HashMap<Integer, List<ClassifierData>>();
		
		for (ClassifierData classifierData : cdList) {
			int sortElement;
			if(sortBeaconID){
				sortElement = classifierData.getBeaconID();
			}else{
				sortElement = classifierData.getBlockID();
			}
			if( sortedMap.containsKey(sortElement)){
				sortedMap.get(sortElement).add(classifierData);
			}else
			{
				List<ClassifierData>clList = new ArrayList<ClassifierData>();
				clList.add(classifierData);
				sortedMap.put(sortElement, clList);
			}
		}
		
		return sortedMap;
	}

}
