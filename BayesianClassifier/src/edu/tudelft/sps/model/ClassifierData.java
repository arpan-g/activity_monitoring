package edu.tudelft.sps.model;

public class ClassifierData {
	
	private double mean;
	private double sigma;
	private int blockID;
	private int beaconID;
	
	
	public int getBeaconID() {
		return beaconID;
	}
	public void setBeaconID(int beaconID) {
		this.beaconID = beaconID;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getSigma() {
		return sigma;
	}
	public void setSigma(double sigma) {
		this.sigma = sigma;
	}
	public int getBlockID() {
		return blockID;
	}
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
	

}
