import { Component ,OnInit} from '@angular/core';
import { Venue } from 'src/app/venue';
import { VenueService } from 'src/app/venue.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent {

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

  updateVenue(id:number){
    this.router.navigate(["/admin/updateVenue",id]);
  }
  
  deleteVenue(id:number){
    this.venueService.deleteVenue(id).subscribe(data =>{
    console.log(data);
    this.getVenue();
    })

}
}
