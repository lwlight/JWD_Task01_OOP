package by.tc.task01.entity;

import java.io.Serializable;

public abstract class Appliance implements Serializable{
	// you may add your own code here

    @Override
    public Appliance clone() throws CloneNotSupportedException {
        return (Appliance)super.clone();
    }
}
