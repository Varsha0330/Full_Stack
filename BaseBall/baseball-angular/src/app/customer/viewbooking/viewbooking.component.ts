import { Component,OnInit } from '@angular/core';
import { Event } from 'src/app/event';
import { EventService } from 'src/app/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewbooking',
  templateUrl: './viewbooking.component.html',
  styleUrls: ['./viewbooking.component.css']
})
export class ViewbookingComponent {

   events!: Event[];



  constructor(private eventService:EventService,
    private router: Router ) {}
    
  ngOnInit():void{
    this.getEvent();
  }
 
  
  private getEvent():void {
    this.eventService.getEventList().subscribe((data: Event[]) =>{
      this.events=data;
      console.log(this.events);
    });
    
  }

  updateEvent(id:number){
    this.router.navigate(["/updateEvent",id]);
  }
  
  deleteEvent(id:number){
    this.eventService.deleteEvent(id).subscribe(data =>{
    console.log(data);
    this.getEvent();
    })

}

}
