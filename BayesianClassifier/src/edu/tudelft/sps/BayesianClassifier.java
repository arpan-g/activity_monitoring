package edu.tudelft.sps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.tudelft.sps.model.BlueToothData;
import edu.tudelft.sps.model.ClassifierData;
import edu.tudelft.sps.model.ProbabilityData;
import edu.tudelft.util.Constants;
import edu.tudelft.util.QueueUtil;

public class BayesianClassifier {

	public void classify(List<BlueToothData> bdhList) {
		List<ClassifierData> classifierDataList = BayesianDataBase
				.getClassifierDataList();
		List<ProbabilityData> probabilityList = getPrioriProbability();
		List<ProbabilityData>currentProbabilityList = new ArrayList<ProbabilityData>();
		/*training data sorted according to beacon ID*/
		Map<Integer, List<ClassifierData>> beaconIDMap = QueueUtil.toMap(
				classifierDataList, true);
		Set<Integer> keySet = beaconIDMap.keySet();
		/*iterate our each beacon Id*/
		for (Integer beaconID : keySet) {
			/*the current data to be classified*/
			for (BlueToothData blueToothData : bdhList) {
				/*perform operations on each beacon ID*/
				if (blueToothData.getbeaconID() == beaconID) {
					/*RSSI values of that beacon in all the blocks*/
					List<ClassifierData> blockRSSIValueList = beaconIDMap
							.get(beaconID);
					/*calculate the probability of the beacon being in each block*/
					for (ClassifierData classifierData : blockRSSIValueList) {
						int blockID = classifierData.getBlockID();
						for (ProbabilityData probabilityData : probabilityList) {
							if (probabilityData.getBlockID()==blockID){
								
								ProbabilityData currentProbability= new ProbabilityData();
								currentProbability.setProbability(QueueUtil.getProbability(
										blueToothData.getRSSI(),
										classifierData.getMean(),
										classifierData.getSigma()));
								currentProbability.setBlockID(blockID);
								currentProbabilityList.add(currentProbability);
								break;
							}
						}
					}
					probabilityList = updateProbability(probabilityList,
							currentProbabilityList);
					break;
				}
			}
		}
		for (ProbabilityData pd : probabilityList) {
			
			System.out.println("blockid : "+pd.getBlockID()+" probability "+pd.getProbability()+"\n");
		}
	}

	private List<ProbabilityData> updateProbability(List<ProbabilityData> previousProbabilityList,
			List<ProbabilityData> currentProbabilityList) {
		List<ProbabilityData> tempProbabilityList= new ArrayList<ProbabilityData>();
		double normalize=0.0;
		for (int i = 0; i < previousProbabilityList.size(); i++) {
			ProbabilityData previousProbabilityData = previousProbabilityList.get(i);
			ProbabilityData currentProbabilityData = currentProbabilityList.get(i);
			normalize+=currentProbabilityData.getProbability()*previousProbabilityData.getProbability();
		}
		for (int i = 0; i < previousProbabilityList.size(); i++) {
			ProbabilityData pd = new ProbabilityData();
			pd.setBlockID(currentProbabilityList.get(i).getBlockID());
			if(normalize!=0.0){
			double probability = currentProbabilityList.get(i).getProbability()*previousProbabilityList.get(i).getProbability()/normalize;
			pd.setProbability(probability);
			}
			tempProbabilityList.add(pd);
		}
		return tempProbabilityList;
		
	}

	public List<ProbabilityData> getPrioriProbability() {

		List<ProbabilityData> prioriProbability = new ArrayList<ProbabilityData>();
		double init = 1.0 /(double)(Constants.NUMBER_OF_BLOCKS);
		for (int i = 0; i < Constants.NUMBER_OF_BLOCKS; i++) {
			ProbabilityData pd = new ProbabilityData();
			pd.setProbability(init);
			pd.setBlockID(i);
			prioriProbability.add(pd);
		}
		return prioriProbability;

	}

}
