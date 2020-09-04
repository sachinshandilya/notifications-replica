package com.demoProject.notificationsreplica.dataModel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NotificationStateEnum {
    NEW("NEW"),
    INPROGRESS("INPROGRESS"),
    REPORTREQUIRED("REPORTREQUIRED"),
    CLOSED("CLOSED");
	
    NotificationStateEnum(String string) {
		// TODO Auto-generated constructor stub
    	this.value = string;
	}

	@Getter private String value;

}
