package com.demoProject.notificationsreplica.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoProject.notificationsreplica.model.NotificationDB;


/*
 * Now we extended a interface to MongoRepository which is a helper class provided by spring-data-monogoDb to create a Repository
 * named as NotificationsRepository , it will have a document of NotificationDB and its documents data will have unique id of String
 */

@Repository  //this is a Repository class
public interface NotificationsRepository extends MongoRepository<NotificationDB, String> {

//    Optional<List<NotificationDB>> findByNotificationId(String notificationId);
//
//    Optional<List<NotificationDB>> findBySourceId(String sourceId);
//
//    Long deleteByNotificationId(String notificationId);
//    
//    Optional<List<NotificationDB>> findByCreatedTimestampLessThan(LocalDateTime createdTimestamp);
//
//    Long deleteByCreatedTimestampBefore(LocalDateTime timestamp);

}
