package by.tc.task01.entity;

import java.io.Serializable;

public class TabletPC extends Appliance implements Serializable{
	// you may add your own code here
    private String name = "TabletPC";
    private double batteryCapacity;
    private double displayInches;
    private double memoryROM;
    private double flashMemoryCapacity;
    private String color;

    public TabletPC() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " : ");
        sb.append("BATTERY_CAPACITY=" + batteryCapacity + ", ");
        sb.append("DISPLAY_INCHES=" + displayInches + ", ");
        sb.append("MEMORY_ROM=" + memoryROM + ", ");
        sb.append("FLASH_MEMORY_CAPACITY=" + flashMemoryCapacity + ", ");
        sb.append("COLOR=" + color + ";");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(tabletPC.displayInches, displayInches) != 0) return false;
        if (Double.compare(tabletPC.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) != 0) return false;
        if (!name.equals(tabletPC.name)) return false;
        return color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flashMemoryCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public TabletPC clone() throws CloneNotSupportedException {
        TabletPC clonedTabletPC = new TabletPC();
        clonedTabletPC.setBatteryCapacity(this.batteryCapacity);
        clonedTabletPC.setDisplayInches(this.displayInches);
        clonedTabletPC.setMemoryROM(this.memoryROM);
        clonedTabletPC.setFlashMemoryCapacity(this.flashMemoryCapacity);
        clonedTabletPC.setColor(this.color);
        return clonedTabletPC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
