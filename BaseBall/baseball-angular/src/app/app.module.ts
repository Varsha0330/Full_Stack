import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { CustomerComponent } from './customer/customer.component';
import { HompageComponent } from './customer/hompage/hompage.component';
import { CustomerRoutingModule } from './customer/customer-routing.module';
import { AdminRoutingModule } from './admin/admin-routing.module';
import { BookingComponent } from './customer/booking/booking.component';
import { ViewbookingComponent } from './customer/viewbooking/viewbooking.component';
import { VenuesComponent } from './admin/venues/venues.component';
import { ReferenceComponent } from './admin/reference/reference.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateVenueComponent } from './admin/update-venue/update-venue.component';
import { UpdateBookingComponent } from './customer/update-booking/update-booking.component';




@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AdminhomeComponent,
    CustomerComponent,
    HompageComponent,
    BookingComponent,
    ViewbookingComponent,
    VenuesComponent,
    ReferenceComponent,
    UpdateVenueComponent,
    UpdateBookingComponent,
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerRoutingModule,
    AdminRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
