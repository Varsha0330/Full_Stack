import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  
  users: User[] | undefined ;
  constructor(private userService:UserService,
    private router: Router ) {}

  ngOnInit(): void {
    this.getUser();
  }
  
  private getUser(): void {
    this.userService.getUserList().subscribe((data: User[]) =>{
      this.users=data;
      console.log(this.users);
    });
    
  }

  updateUser(id:number){
    this.router.navigate(["/updateuser",id]);
  }
  
  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe(data =>{
    console.log(data);
    this.getUser();
    })
  }
  
}


