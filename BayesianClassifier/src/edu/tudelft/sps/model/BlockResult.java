package edu.tudelft.sps.model;

import java.util.ArrayList;
import java.util.List;

public class BlockResult {
	
	private List<BlueToothData> bldataHolderList;
	private int blockID;

	
	public void addBlData(BlueToothData blData){
		if (this.bldataHolderList==null) {
			this.bldataHolderList = new ArrayList<BlueToothData>();
		}
		this.bldataHolderList.add(blData);
	}
	
	public List<BlueToothData> getBldataHolderList() {
		return bldataHolderList;
	}
	
	public void setBldataHolderList(List<BlueToothData> bldataHolderList) {
		this.bldataHolderList = bldataHolderList;
	}
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
}
