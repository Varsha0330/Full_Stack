import { Component } from '@angular/core';
import { Event } from 'src/app/event';
import { EventService } from 'src/app/event.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent {

  id!: number;
  event: Event=new Event();
  constructor(private eventservice:EventService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.eventservice.getEventById(this.id).subscribe(data=>{
      this.event=data;
    },error => console.log(error));
  }
 
  onSubmit(){
    this.eventservice.updateEvent(this.id,this.event).subscribe(data=>{
    this.goToVenueList();
    }, error => console.log(error));

  }

  goToVenueList(){
    this.router.navigate(['/viewEvent']);
  } 

}
