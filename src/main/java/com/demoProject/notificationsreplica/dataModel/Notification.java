package com.demoProject.notificationsreplica.dataModel;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
@Data : creates getter for all fileds , setter for all non-final fields , creates a constructor , also creates toSTring method for the class

@Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class (except that 
no constructor will be generated if any explicitly written constructors already exist).


@NoArgsConstructor  : Creates a no args constructor
@AllArgsConstructor : creates all args constructor


@Builder : This annotation produces complex builder APIs for your classes.

@Builder lets you automatically produce the code required to have your class be instantiable with code such as:
Person.builder().name("Adam Savage").city("San Francisco").job("Mythbusters").job("Unchained Reaction").build();

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @ApiModelProperty(example = "5ca5c1adfab6e58c35ee7b7e", value = "unique id")
    private String id;
    @ApiModelProperty(example = "D01_Aggression", value = "unique id")
    private String notificationId;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdTimestamp;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedTimestamp;
    @ApiModelProperty(example = "ATMS_object", value = "map_object in ATMS terminology")
    private String source;
    @ApiModelProperty(example = "SENSOR", value = "device type")
    private NotificationSourceTypeEnum sourceType;
    @ApiModelProperty(example = "D01", value = "device unique id")
    private String sourceId;
    @ApiModelProperty(example = "CRITICAL", value = "priority of notification")
    private NotificationPriotityEnum priority;
    
    @ApiModelProperty(example = "NEW", value = "state of notification")
    private NotificationStateEnum state;
    @ApiModelProperty(example = "RUNNING", value = "service of notification")
    private NotificationServiceEnum service;
    @ApiModelProperty(example = "EVENTAGGRESSION", value = "type of the event")
    private String type;
    private String severity;
    private Report report;
    private NotificationMetadata metadata;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public NotificationSourceTypeEnum getSourceType() {
		return sourceType;
	}
	public void setSourceType(NotificationSourceTypeEnum sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public NotificationPriotityEnum getPriority() {
		return priority;
	}
	public void setPriority(NotificationPriotityEnum priority) {
		this.priority = priority;
	}
	public NotificationStateEnum getState() {
		return state;
	}
	public void setState(NotificationStateEnum state) {
		this.state = state;
	}
	public NotificationServiceEnum getService() {
		return service;
	}
	public void setService(NotificationServiceEnum service) {
		this.service = service;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public NotificationMetadata getMetadata() {
		return metadata;
	}
	public void setMetadata(NotificationMetadata metadata) {
		this.metadata = metadata;
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	

}
