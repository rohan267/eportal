package com.solactive.eportal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.CollectionUtils;

@Entity
public class Event implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private  Long id;

   @Column(nullable = false, unique = true)
   private  String title;

   @Lob
   private String description;

   private EventType eventType;

   @OneToMany(cascade = CascadeType.ALL,
         fetch = FetchType.LAZY,
         mappedBy = "event")
   private List<EventReply> replies;

   @Column
   private String photo;

   @CreatedDate
   private Date createdAt;

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

   public List<EventReply> getReplies()
   {
      return replies;
   }

   public void setReplies(List<EventReply> replies)
   {
      this.replies = replies;
   }

   public void addReply(EventReply reply)
   {
      if (CollectionUtils.isEmpty(replies))
      {
         replies = new ArrayList<>();
      }

      replies.add(reply);
   }
}
