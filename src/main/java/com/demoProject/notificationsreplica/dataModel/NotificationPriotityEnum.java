package com.demoProject.notificationsreplica.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationPriotityEnum {
    CRITICAL("CRITICAL"),
    HIGH("HIGH"),
    LOW("LOW");
	
	@Getter private String value;

	
    NotificationPriotityEnum(String string) {
		// TODO Auto-generated constructor stub
    	this.value = string ;
	}


}
