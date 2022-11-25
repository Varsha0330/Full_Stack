import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';

import { ReferenceComponent } from './reference/reference.component';
import { TeamComponent } from './team/team.component';
import { UpdateVenueComponent } from './update-venue/update-venue.component';
import { VenuesComponent } from './venues/venues.component';

const routes: Routes = [
  {
    path:'admin',component:AdminComponent,
    children:[
      {path:"home",component:AdminhomeComponent},
      {path:"addVenue",component:VenuesComponent},
      {path:"addReference",component:ReferenceComponent},
      {path:"addTeam",component:TeamComponent},
      {path:"updateVenue/:id",component:UpdateVenueComponent},
      {path:"",redirectTo:"home",pathMatch:"full"}
     
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class   AdminRoutingModule { }
