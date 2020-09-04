package com.demoProject.notificationsreplica.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.demoProject.notificationsreplica.NotificationsReplicaApplication;
import com.demoProject.notificationsreplica.dataModel.Notification;
import com.demoProject.notificationsreplica.exception.APIException;
import com.demoProject.notificationsreplica.model.ActiveNotificationDB;
import com.demoProject.notificationsreplica.model.GetNotificationsResponse;
import com.demoProject.notificationsreplica.model.NotificationDB;
import com.demoProject.notificationsreplica.repositories.ActiveNotificationsRepository;
import com.demoProject.notificationsreplica.repositories.NotificationsRepository;

import org.modelmapper.ModelMapper;




@Service   //It is used to mark the class as a service provider.
//this is service class , which is used to perform some operations , generally lengthy calculation code is kept in Service class
//instead of Controller class , @Service is specification of @Component
public class NotificationsService {

	
	@Autowired
	private GetNotificationsResponse response;
	
	 @Autowired
	 private NotificationsRepository notificationsRepository ;
	 
	 
	 @Autowired
	 private ActiveNotificationsRepository activeNotificationsRepository;
	 
	 

	    @Autowired
	    private ModelMapper modelMapper;
	 
	 Logger logger = LoggerFactory.getLogger(NotificationsService.class);
	
	
	 public GetNotificationsResponse getNotifications(Integer page, Integer size) {
	        final Pageable pageableRequest = PageRequest.of(page, size, Sort.by("createdTimestamp").descending());  //we need to pass 
	        //page no , size of data ,we pass to the repository a Page able object and we get Page from repository
	        logger.info(null ,pageableRequest);
	        Page<ActiveNotificationDB> pages = activeNotificationsRepository.findAll(pageableRequest);
	        logger.info(null, pages.getContent());
	        response.setDocs(pages.getContent());
	        response.setTotal(pages.getSize());
	        response.setPageable(pages.getPageable());
	        response.setLast(pages.isLast());
	        response.setTotalElements(pages.getTotalElements());
	        response.setTotalPages(pages.getTotalPages());
	        return response;
	    }
	  
	  
	   public Notification createNotification( Notification notification) {
	        if (notification.getNotificationId() != null) {
	            saveActiveNotification(notification);

	            NotificationDB createdNotification = saveNotification(notification);
	            return modelMapper.map(createdNotification, Notification.class);
	        } else {
	            throw new APIException("notification id is null", null);
	        }
	    }
	   
	   private ActiveNotificationDB saveActiveNotification(Notification notification) {
	        ActiveNotificationDB activeNotificationDB = modelMapper.map(notification, ActiveNotificationDB.class);
	        activeNotificationDB.setId(activeNotificationDB.getNotificationId());
	        return activeNotificationsRepository.save(activeNotificationDB);
	    }


	    private NotificationDB saveNotification(Notification notification) {
	        NotificationDB notificationDB = modelMapper.map(notification, NotificationDB.class);
	        notificationDB.setId(null);
	        return notificationsRepository.save(notificationDB);
	    }

}
