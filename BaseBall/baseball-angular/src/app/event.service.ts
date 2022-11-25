import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Event } from './event';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private baseUrl='http://localhost:8085/event';

  constructor(private httpClient:HttpClient) { }



  getEventList(): Observable<Event[]>{
    return this.httpClient.get<Event[]>(`${this.baseUrl}`);
  }


  createEvent(event:Event):Observable<object>{
    return this.httpClient.post(`${this.baseUrl}`,event);
  }

  getEventById(id:number):Observable<Event>{
    return this.httpClient.get<Event>(`${this.baseUrl}/${id}`);
  }

  updateEvent(id:number,event:Event):Observable<object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,event);
  }

  deleteEvent(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`)
  }
}
