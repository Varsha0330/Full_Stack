import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Venue } from './venue';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VenueService {
  private baseUrl='http://localhost:8085/venue';

  constructor(private httpClient:HttpClient) { }

  getVenueList(): Observable<Venue[]>{
    return this.httpClient.get<Venue[]>(`${this.baseUrl}`);
  }


  createVenue(venue:Venue):Observable<object>{
    return this.httpClient.post(`${this.baseUrl}`,venue);
  }

  getVenueById(id:number):Observable<Venue>{
    return this.httpClient.get<Venue>(`${this.baseUrl}/${id}`);
  }

  updateVenue(id:number,venue:Venue):Observable<object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,venue);
  }

  deleteVenue(id:number):Observable<object>{
    return this.httpClient.delete(`${this.baseUrl}/${id}`)
  }

}
