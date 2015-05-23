package edu.tudelft.sps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.tudelft.sps.model.BlockDataWithID;
import edu.tudelft.sps.model.BlueToothData;
import edu.tudelft.sps.model.ClassifierData;
import edu.tudelft.util.QueueUtil;

public class BlockDataReader {

	public List<ClassifierData> getData(String pathMean) {
		List<ClassifierData> classifierDataList = new ArrayList<ClassifierData>();
		String str;
		String[] strArrayMean;

		try {
			InputStream is = new FileInputStream(pathMean);

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			int lineCounter = 0;
			while ((str = reader.readLine()) != null) {
				strArrayMean = str.split("\t");
				int beaconCounter=0;
				for (int i = 0; i < strArrayMean.length; i = i + 2) {
					ClassifierData cd = new ClassifierData();
					cd.setMean(QueueUtil.getDoubleFromString(strArrayMean[i]));
					cd.setSigma(QueueUtil.getDoubleFromString(strArrayMean[i + 1]));
					cd.setBeaconID(beaconCounter);
					cd.setBlockID(lineCounter);
					classifierDataList.add(cd);
					beaconCounter++;
				}
				lineCounter++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classifierDataList;

	}

	public List<BlueToothData> getTestData(String path) {

		try {
			String str;
			String[] strArray;
			InputStream is = new FileInputStream(path);
			List<BlueToothData> blholderList = new ArrayList<BlueToothData>();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			while ((str = reader.readLine()) != null) {
				strArray = str.split("\t");
				for (int i = 0; i < strArray.length; i++) {
					
					BlueToothData bdh = new BlueToothData();
					bdh.setbeaconID(i);
					bdh.setRSSI((QueueUtil.getDoubleFromString(strArray[0])));
					blholderList.add(bdh);
				}
			}
			reader.close();
			return blholderList;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
