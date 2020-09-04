package com.demoProject.notificationsreplica.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoProject.notificationsreplica.model.ActiveNotificationDB;

/*
 * Now we extended a interface to MongoRepository which is a helper class provided by spring-data-monogoDb to create a Repository
 * named as ActiveNotificationsRepository , it will have a document of ActiveNotificationDB and its documents data will have unique id of String
 */

@Repository 
public interface ActiveNotificationsRepository extends MongoRepository<ActiveNotificationDB, String> {

//	Optional<List<ActiveNotificationDB>> findByNotificationId(String notificationId);
//	Optional<List<ActiveNotificationDB>> findBySourceIdOrderByUpdatedTimestampDesc(String sourceId);
//	Long deleteByNotificationId(String notificationId);
//	Long deleteByCreatedTimestampBefore(LocalDateTime timestamp);
}
