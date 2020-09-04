package com.demoProject.notificationsreplica.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationSourceTypeEnum {
    VEHICLE("VEHICLE"),
    SENSOR("SENSOR");
	
	@Getter private String value;

	
	
    NotificationSourceTypeEnum(String string) {
		// TODO Auto-generated constructor stub
    	this.value = string;
	}


}
