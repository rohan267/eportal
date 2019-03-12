package com.solactive.eportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Event implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private  Long id;

   @Column(nullable = false, unique = true)
   private  String title;

   @Column
   private String description;

   private EventType eventType;

   @Column
   private String photo;

   @Column(nullable = false)
   private Date createdAt = new Date();

   public Event(Long id, String name)
   {
      this.id = id;
      this.title = name;
   }

   public Event()
   {
   }

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public EventType getEventType()
   {
      return eventType;
   }

   public void setEventType(EventType eventType)
   {
      this.eventType = eventType;
   }

   public String getPhoto()
   {
      return photo;
   }

   public void setPhoto(String photo)
   {
      this.photo = photo;
   }

   public Date getCreatedAt()
   {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt)
   {
      this.createdAt = createdAt;
   }
}
