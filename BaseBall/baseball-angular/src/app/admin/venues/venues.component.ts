import { Component ,OnInit} from '@angular/core';
import { Venue } from 'src/app/venue';
import { Router } from '@angular/router';
import { VenueService } from 'src/app/venue.service';

@Component({
  selector: 'app-venues',
  templateUrl: './venues.component.html',
  styleUrls: ['./venues.component.css']
})
export class VenuesComponent implements OnInit {
  venue: Venue=new Venue();

  constructor(private venueService:VenueService,
      private router:Router) { }

  ngOnInit(): void {
  }
 
  saveVenue(){
    this.venueService.createVenue(this.venue).subscribe(data =>{
      console.log(data);
      this.goToVenueList();
    },
    error => console.log(error));
  }
  
  goToVenueList(){
     this.router.navigate(['/admin']);
  }

  onSubmit(){
    console.log(this.venue)
    this.saveVenue();
  }

}
