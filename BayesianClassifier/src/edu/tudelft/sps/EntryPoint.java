package edu.tudelft.sps;

import java.util.List;

import edu.tudelft.sps.model.BlueToothData;
import edu.tudelft.util.Constants;

public class EntryPoint {

	public static void main(String[] args) {

		List<BlueToothData> bdhList ;
		BlockDataReader reader = new BlockDataReader();
		bdhList = reader.getTestData(Constants.TEST_FILE_PATH);
		BayesianDataBase.initInstance();
		BayesianClassifier bc = new BayesianClassifier();
		bc.classify(bdhList);
	}

}
