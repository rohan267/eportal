package com.solactive.eportal.model;

public enum EventType
{
   BUY(1),
   SELL(2),
   QUERY(3),
   BLOG(4);

   private int eventType;

   EventType(int eventType)
   {
      this.eventType = eventType;
   }

   public int getEventType()
   {
      return eventType;
   }
}
