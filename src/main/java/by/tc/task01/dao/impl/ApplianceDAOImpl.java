package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApplianceDAOImpl implements ApplianceDAO{

	public <E> Appliance find(Criteria<E> criteria) {
		// you may add your own code here
		List<String> criteaList = getCriteriaList(criteria);
		String applianceType = criteria.getApplianceType();
		Appliance foundedAppliance = searchInDatabase(applianceType, criteaList);
		return foundedAppliance;
	}
	
	// you may add your own code here

	private static <E> List<String> getCriteriaList(Criteria<E> criteria){
		List<String> criteriaList = new ArrayList<>();
		Map<E, Object> criteriaMap = criteria.getCriteria();
		for(Map.Entry<E, Object> pair : criteriaMap.entrySet()){
			String searchParam = pair.getKey().toString();
			String value = pair.getValue().toString();
			String result = (searchParam + "=" + value).toUpperCase();
			criteriaList.add(result);
		}
		return criteriaList;
	}
	private static Appliance searchInDatabase(String applianceType, List<String> criteriaList){
		final String DATABASE_PATH = "src\\main\\resources\\appliances_db.txt";
		String readedData;
		try(BufferedReader bfr = new BufferedReader(new FileReader(DATABASE_PATH))){
			while((readedData = bfr.readLine()) != null){
				readedData = readedData.toUpperCase();
				if(readedData.contains(applianceType.toUpperCase())){
					if (getMatch(readedData, criteriaList)){
						return createAppliance(applianceType, readedData);
					}
				}
			}

		} catch (IOException e){
		}
		return null;
	}
	private static boolean getMatch(String readedData, List<String> criteriaList){
		for(int i=0; i<criteriaList.size(); i++){
			if (!(readedData.contains(criteriaList.get(i)))){
				return false;
			} else {
				String fullValueString = "";
				int startSubstringIndex = readedData.indexOf(criteriaList.get(i));
				int endSubstringIndex = readedData.indexOf(",", startSubstringIndex);
				if (endSubstringIndex == -1){
					endSubstringIndex = readedData.indexOf(";");
				}
				fullValueString = readedData.substring(startSubstringIndex, endSubstringIndex);
				if (!(fullValueString.equalsIgnoreCase(criteriaList.get(i)))){
					return false;
				}
			}
		}
		return true;
	}
	private static Appliance createAppliance(String applianceType, String parameters){
		List<String> parametersList = getParametersArrayForFoundedAppliance(parameters);
		if(applianceType.equals("Oven")){
			Oven oven = new Oven();
			oven.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
			oven.setWeight(Double.parseDouble(parametersList.get(1)));
			oven.setCapacity(Double.parseDouble(parametersList.get(2)));
			oven.setDepth(Double.parseDouble(parametersList.get(3)));
			oven.setHeight(Double.parseDouble(parametersList.get(4)));
			oven.setWidth(Double.parseDouble(parametersList.get(5)));
			return oven;
		}
		if(applianceType.equals("Laptop")){
			Laptop laptop = new Laptop();
			laptop.setBatteryCapacity(Double.parseDouble(parametersList.get(0)));
			laptop.setOs(parametersList.get(1));
			laptop.setMemoryROM(Double.parseDouble(parametersList.get(2)));
			laptop.setSystemMemory(Double.parseDouble(parametersList.get(3)));
			laptop.setCpu(Double.parseDouble(parametersList.get(4)));
			laptop.setDisplayInchs(Double.parseDouble(parametersList.get(5)));
			return laptop;
		}
		if(applianceType.equals("Refrigerator")){
			Refrigerator refrigerator = new Refrigerator();
			refrigerator.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
			refrigerator.setWeight(Double.parseDouble(parametersList.get(1)));
			refrigerator.setFreezerCapacity(Double.parseDouble(parametersList.get(2)));
			refrigerator.setOverallCapacity(Double.parseDouble(parametersList.get(3)));
			refrigerator.setHeight(Double.parseDouble(parametersList.get(4)));
			refrigerator.setWidth(Double.parseDouble(parametersList.get(5)));
			return refrigerator;
		}
		if(applianceType.equals("Speakers")){
			Speakers speakers = new Speakers();
			speakers.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
			speakers.setNumberOfSpeakers(Double.parseDouble(parametersList.get(1)));
			speakers.setFrequencyRange(parametersList.get(2));
			speakers.setCordLength(Double.parseDouble(parametersList.get(3)));
			return speakers;
		}
		if(applianceType.equals("TabletPC")){
			TabletPC tabletPC = new TabletPC();
			tabletPC.setBatteryCapacity(Double.parseDouble(parametersList.get(0)));
			tabletPC.setDisplayInches(Double.parseDouble(parametersList.get(1)));
			tabletPC.setMemoryROM(Double.parseDouble(parametersList.get(2)));
			tabletPC.setFlashMemoryCapacity(Double.parseDouble(parametersList.get(3)));
			tabletPC.setColor(parametersList.get(4));
			return tabletPC;
		}
		if(applianceType.equals("VacuumCleaner")){
			VacuumCleaner vacuumCleaner = new VacuumCleaner();
			vacuumCleaner.setPowerConsumption(Double.parseDouble(parametersList.get(0)));
			vacuumCleaner.setFilterType(parametersList.get(1));
			vacuumCleaner.setBagType(parametersList.get(2));
			vacuumCleaner.setWandType(parametersList.get(3));
			vacuumCleaner.setMotorSpeedRegulation(Double.parseDouble(parametersList.get(4)));
			vacuumCleaner.setCleaningWidth(Double.parseDouble(parametersList.get(5)));
			return vacuumCleaner;
		}
		return null;
	}
	private static List<String> getParametersArrayForFoundedAppliance(String parameters){
		List<String> paramsList = new ArrayList<>();
		int currentPosition = 0;
		int currentStartIndex;
		while ((currentStartIndex = parameters.indexOf("=", currentPosition)) != -1){
			int indexOfEndMark = parameters.indexOf(",", currentStartIndex);
			if(indexOfEndMark == -1){
				indexOfEndMark = parameters.indexOf(";");
			}
			paramsList.add(parameters.substring(currentStartIndex+1, indexOfEndMark));
			currentPosition = currentStartIndex+1;
		}
		return paramsList;
	}

}


//you may add your own new classes