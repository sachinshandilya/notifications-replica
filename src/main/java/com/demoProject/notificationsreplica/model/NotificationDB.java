package com.demoProject.notificationsreplica.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.demoProject.notificationsreplica.dataModel.Notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection = "notifications-replica")  //specifying this class is a document class , group of documents is collection , name of that
//collection will be notifications-replica, this collection belongs to NotificationsRepository which was created as interface extended to MongoRepository
@ApiModel(description="details about Notifications")
public class NotificationDB extends Notification {
 
	 
}