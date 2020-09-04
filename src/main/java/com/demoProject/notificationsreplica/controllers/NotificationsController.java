package com.demoProject.notificationsreplica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demoProject.notificationsreplica.dataModel.Notification;
import com.demoProject.notificationsreplica.exception.APIException;
import com.demoProject.notificationsreplica.model.GetNotificationsResponse;
import com.demoProject.notificationsreplica.model.NotificationDB;
import com.demoProject.notificationsreplica.repositories.ActiveNotificationsRepository;
import com.demoProject.notificationsreplica.repositories.NotificationsRepository;
import com.demoProject.notificationsreplica.service.NotificationsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



/*
ResponseEntity represents an HTTP response, including headers, body, and status. 
While @ResponseBody puts the return value into the body of the response, ResponseEntity also allows us to add headers and status code.


Code example :-
ResponseEntity<String> entity = template.getForEntity("https://example.com", String.class);   
String body = entity.getBody();
MediaType contentType = entity.getHeaders().getContentType();
HttpStatus statusCode = entity.getStatusCode();
 */



@RestController  //it is a controller class , Rest controller means it will handle REST api calls , REST is a architectural style 
//tells spring boot that this is a controller class , @RestController is a specialization of @Controller and that is specialization of @Component 
@Api(value = "Notifications", tags = { "Notifications" })  //name of this endpoint in swagger will be seen as Notifications as a tag
public class NotificationsController {

	
	    @Autowired
	    private NotificationsService notificationsService;
	 
	    @Autowired
	    private NotificationsRepository notificationsRepository;

	    @Autowired
	    private ActiveNotificationsRepository activeNotificationsRepository;
	
	   @ApiOperation(value = "List all latest notifications", notes = "Returns a specific number of notifications using the paginator pattern", response = Object.class, tags = {
	            "Notifications", })
	    @ApiResponses(value = { @ApiResponse(code = 200, message = "An array of notifications", response = Object.class),
	            @ApiResponse(code = 400, message = "Unexpected error", response = Object.class) })
	    @GetMapping(value = "/notifications", produces = { "application/json" })
	   public ResponseEntity<Object> notificationsGet(
	            @ApiParam(value = "Number of pages", required = true, defaultValue = "0") @RequestParam("page") Integer page,
	            @ApiParam(value = "Number of objects per page", required = true, defaultValue = "10") @RequestParam("size") Integer size) {
	        GetNotificationsResponse listOfNotifications = notificationsService.getNotifications(page, size);
	        return new ResponseEntity<>(listOfNotifications, HttpStatus.OK);
	    }
	
	   
	   @ApiOperation(value = "Create notification", notes = "Creates a notification", response = Notification.class)
	    @ApiResponses(value = { @ApiResponse(code = 201, message = "Notification created", response = Notification.class),
	            @ApiResponse(code = 400, message = "Unexpected error", response = Notification.class) })
	    @PostMapping(value = "/notifications", produces = { "application/json" })
	    public ResponseEntity<Notification> notificationsPost(
	            @ApiParam(value = "notification object", required = true) @RequestBody Notification notification) {
	        System.out.println("notification event received with details as notificationId: {}, sourceType: {} and sourceId: {}" + 
	                notification.getNotificationId() + notification.getSourceType() + notification.getSourceId());
	        Notification createdNotification = null;
	        try {
	            createdNotification = notificationsService.createNotification(notification);
	        } catch (APIException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Notification Id not found ", e);
	        }
	        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
	    }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	
}
