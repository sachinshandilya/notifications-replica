package com.demoProject.notificationsreplica.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationServiceEnum {
    RUNNING("RUNNING"),
    PARTIAL("PARTIAL"),
    OUTOFORDER("OUTOFORDER"),
    READY("READY"),
    OK("OK"),
    NOT_OK("NOT_OK"),
    NEEDS_SERVICE("NEEDS_SERVICE");
	
	
	@Getter private String value;

	
    NotificationServiceEnum(String string) {
		// TODO Auto-generated constructor stub
    	this.value = string ;
	}


}
