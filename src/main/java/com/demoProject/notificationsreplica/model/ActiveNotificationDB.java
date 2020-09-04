package com.demoProject.notificationsreplica.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.demoProject.notificationsreplica.dataModel.Notification;

@Document(collection = "activeNotifications-replica")  //specifying this class is a document class , group of documents is collection , name of that
//collection will be activeNotifications-replica, this collection belongs to ActiveNotificationsRepository which was created as interface extended 
//to MongoRepository
public class ActiveNotificationDB extends Notification {

}
