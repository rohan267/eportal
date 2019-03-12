package com.solactive.eportal.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class EventReply
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "event_id", nullable = false)
   private Event event;

   @Lob
   private String message;

   @CreatedDate
   private Date createdAt;

   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public Event getEvent()
   {
      return event;
   }

   public void setEvent(Event event)
   {
      this.event = event;
   }

   public String getMessage()
   {
      return message;
   }

   public void setMessage(String message)
   {
      this.message = message;
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
