package com.demoProject.notificationsreplica.config;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;


@Configuration
@EnableMongoRepositories(basePackages = {"com.demoProject.notificationsreplica.repositories"})  //enable mongo repositories in this project
//it is very necessary to provide the base package else it will throw an error
public class MongoConfiguration {
  
	
	 @Bean
	  public MongoCustomConversions customConversions(){
	    List<Converter<?,?>> converters = new ArrayList<>();
	    converters.add(DateToZonedDateTimeConverter.INSTANCE);
	    converters.add( ZonedDateTimeToDateConverter.INSTANCE);
	    return new MongoCustomConversions(converters);
	  }

	  enum DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {

	    INSTANCE;

	    @Override
	    public ZonedDateTime convert(Date source) {
	      return ZonedDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
	    }
	  }

	  enum ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {

	    INSTANCE;

	    @Override
	    public Date convert(ZonedDateTime source) {
	      return Date.from(source.toInstant());
	    }
	  }
	  
	@Bean
	  public ModelMapper mapper(){
	    ModelMapper contactModelMapper = new ModelMapper();
	    
	    contactModelMapper.createTypeMap(ZonedDateTime.class, OffsetDateTime.class);
	    contactModelMapper.createTypeMap(OffsetDateTime.class, ZonedDateTime.class);
	    contactModelMapper.createTypeMap(Date.class, OffsetDateTime.class);
	    contactModelMapper.addConverter((MappingContext<ZonedDateTime, OffsetDateTime> mappingContext) -> mappingContext.getSource().toOffsetDateTime());
	    contactModelMapper.addConverter((MappingContext<OffsetDateTime, ZonedDateTime> mappingContext) -> mappingContext.getSource().toZonedDateTime());
	    contactModelMapper.addConverter((MappingContext<Date, OffsetDateTime> mappingContext) -> OffsetDateTime.from(mappingContext.getSource().toInstant()));

	    return contactModelMapper;
	  }
	  
	
}
