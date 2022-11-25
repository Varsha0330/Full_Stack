import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
{path:'userlists',component:UserListComponent},
{path:'createuser',component:CreateUserComponent},
{path:'updateuser/:id',component:UpdateUserComponent},
{path:'',redirectTo:'userlists',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
