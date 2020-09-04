package com.demoProject.notificationsreplica.dataModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMetadata {
    @ApiModelProperty(example = "Aggression detected", value = "notification reason")
    private String reason;
    @ApiModelProperty(example = "1 passenger", value = "notification affected")
    private String affected;
    @ApiModelProperty(example = "unknown", value = "expected result")
    private String expected;
    private String sensorType;
    private String sensorSubType;
    private String actionInfo;
    private String region;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAffected() {
		return affected;
	}
	public void setAffected(String affected) {
		this.affected = affected;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getSensorSubType() {
		return sensorSubType;
	}
	public void setSensorSubType(String sensorSubType) {
		this.sensorSubType = sensorSubType;
	}
	public String getActionInfo() {
		return actionInfo;
	}
	public void setActionInfo(String actionInfo) {
		this.actionInfo = actionInfo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
    
}
