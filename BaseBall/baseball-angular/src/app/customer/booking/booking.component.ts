import { Component ,OnInit} from '@angular/core';
import { Event } from 'src/app/event';
import { EventService } from 'src/app/event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

   event:Event=new Event();

  constructor(private eventService:EventService,
      private router:Router) { }

  ngOnInit(): void {
  }
 
  saveEvent(){
    this.eventService.createEvent(this.event).subscribe(data =>{
      console.log(data);
      this.goToEventList();
    },
    error => console.log(error));
  }
  
  goToEventList(){
    this.router.navigate(['/viewEvent']);
 }

  onSubmit(){
    console.log(this.event)
    this.saveEvent();
  }

}
