package edu.tudelft.sps;

import java.util.List;

import edu.tudelft.sps.model.BlockDataWithID;
import edu.tudelft.sps.model.ClassifierData;
import edu.tudelft.util.Constants;

public class BayesianDataBase {

	
	private static BayesianDataBase instance;
	private static List<ClassifierData> classifierDataList;
	
	public static void initInstance()
	{
		if(instance == null){
			instance = new BayesianDataBase();
			BlockDataReader reader = new BlockDataReader();
			List<ClassifierData> data = reader.getData(Constants.PATH_BAYESIAN_DATA);
			setClassifierDataList(data);
		}
	}
	public static BayesianDataBase getInstance(){
		return instance;
	}
	public static List<ClassifierData> getClassifierDataList() {
		return classifierDataList;
	}
	public static void setClassifierDataList(List<ClassifierData> data) {
		BayesianDataBase.classifierDataList = data;
	}
	
}
