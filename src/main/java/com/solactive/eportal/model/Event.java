package com.solactive.eportal.model;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable
{
   private  Integer id;

   private  String title;

   private String description;

   private EventType eventType;

   private String photo;

   private Date createdAt;

   private Date updatedAt;


   public Event(Integer id, String name)
   {
      this.id = id;
      this.title = name;
   }

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
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

   public Date getUpdatedAt()
   {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt)
   {
      this.updatedAt = updatedAt;
   }
}
