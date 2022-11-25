import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { CustomerComponent } from './customer.component';
import { HompageComponent } from './hompage/hompage.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';

const routes: Routes = [
  {
    
    path:'',component:CustomerComponent,
    children:[
      {path:"hompage",component:HompageComponent},
      {path:"bookEvent",component:BookingComponent},
      {path:"viewEvent",component:ViewbookingComponent},
      {path:"updateEvent/:id",component:UpdateBookingComponent},
      {path:"",redirectTo:"hompage",pathMatch:"full"}
      
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
