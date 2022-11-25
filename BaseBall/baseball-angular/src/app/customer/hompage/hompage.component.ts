import { Component } from '@angular/core';
import { Venue } from 'src/app/venue';
import { VenueService } from 'src/app/venue.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hompage',
  templateUrl: './hompage.component.html',
  styleUrls: ['./hompage.component.css']
})
export class HompageComponent {



  venues!: Venue[];
  constructor(private venueService:VenueService,
    private router: Router ) {}
    
  ngOnInit():void{
    this.getVenue();
  }
 
  
  private getVenue():void {
    this.venueService.getVenueList().subscribe((data: Venue[]) =>{
      this.venues=data;
      console.log(this.venues);
    });
    
  }


}
