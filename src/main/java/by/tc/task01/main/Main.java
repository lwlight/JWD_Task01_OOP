package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<Oven>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.CAPACITY, 3);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.HEIGHT, 200);
		criteriaOven.add(Oven.DEPTH, 300);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
		criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 4);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();
		criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.HEIGHT, 45.5);
		criteriaOven.add(Oven.DEPTH, 60);
		criteriaOven.add(Oven.CAPACITY, 32);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<>();
		criteriaVacuumCleaner.setApplianceType("VacuumCleaner");
		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE, "aa-89");
		criteriaVacuumCleaner.add(VacuumCleaner.MOTOR_SPEED_REGULATION, 2900);
		criteriaVacuumCleaner.add(VacuumCleaner.FILTER_TYPE, "b");

		appliance = service.find(criteriaVacuumCleaner);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaVacuumCleaner = new Criteria<>();
		criteriaVacuumCleaner.setApplianceType("VacuumCleaner");
		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE, "xx00");
		criteriaVacuumCleaner.add(VacuumCleaner.MOTOR_SPEED_REGULATION, 2950);
		criteriaVacuumCleaner.add(VacuumCleaner.FILTER_TYPE, "c");
		criteriaVacuumCleaner.add(VacuumCleaner.POWER_CONSUMPTION, 90);
		criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE, "ALL-IN-ONE");
		criteriaVacuumCleaner.add(VacuumCleaner.CLEANING_WIDTH, "30");

		appliance = service.find(criteriaVacuumCleaner);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaTabletPC = new Criteria<>();
		criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "RED");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 15);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, "8000");

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<Speakers> criteriaSpeakers = new Criteria<>();
		criteriaSpeakers.setApplianceType("Speakers");
		criteriaSpeakers.add(Speakers.POWER_CONSUMPTION, 17);
		criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-3.5");
		criteriaSpeakers.add(Speakers.NUMBER_OF_SPEAKERS, "4");

		appliance = service.find(criteriaSpeakers);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<Refrigerator> criteriaRefrigerator = new Criteria<>();
		criteriaRefrigerator.setApplianceType("Refrigerator");
		criteriaRefrigerator.add(Refrigerator.POWER_CONSUMPTION, "200");
		criteriaRefrigerator.add(Refrigerator.WEIGHT, 30);
		criteriaRefrigerator.add(Refrigerator.HEIGHT, 180);

		appliance = service.find(criteriaRefrigerator);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<Laptop> criteriaLaptop = new Criteria<>();
		criteriaLaptop.setApplianceType("Laptop");
		criteriaLaptop.add(Laptop.OS, "linux");
		criteriaLaptop.add(Laptop.CPU, 2.2);

		appliance = service.find(criteriaLaptop);

		PrintApplianceInfo.print(appliance);
	}

}
