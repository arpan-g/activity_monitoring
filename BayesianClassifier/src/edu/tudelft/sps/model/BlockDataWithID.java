package edu.tudelft.sps.model;

import java.util.List;

public class BlockDataWithID {
	
	private int blockID;
	private List<ClassifierData>classifierDataList;
	
	
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	public List<ClassifierData> getClassifierDataList() {
		return classifierDataList;
	}
	public void setClassifierDataList(List<ClassifierData> classifierDataList) {
		this.classifierDataList = classifierDataList;
	}

}
