package com.demoProject.notificationsreplica.dataModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter  //add all getter methods for all fields
@Setter //add setter method for all non-final fields
@EqualsAndHashCode
public class Action {
	public String getExecutedAction() {
		return executedAction;
	}
	public void setExecutedAction(String executedAction) {
		this.executedAction = executedAction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	String executedAction;
	String description;
	String remarks;
}
