import { Component } from '@angular/core';
import { Venue } from 'src/app/venue';
import { VenueService } from 'src/app/venue.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-venue',
  templateUrl: './update-venue.component.html',
  styleUrls: ['./update-venue.component.css']
})
export class UpdateVenueComponent {


  id!: number;
  venue: Venue=new Venue();
  constructor(private venueService:VenueService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.venueService.getVenueById(this.id).subscribe(data=>{
      this.venue=data;
    },error => console.log(error));
  }
 
  onSubmit(){
    this.venueService.updateVenue(this.id,this.venue).subscribe(data=>{
    this.goToVenueList();
    }, error => console.log(error));

  }

  goToVenueList(){
    this.router.navigate(['/admin']);
  } 
}
