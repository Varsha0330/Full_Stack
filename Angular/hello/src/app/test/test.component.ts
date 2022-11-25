import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  template:  '<input disabled="true" [id]="name" type="text" value="varsha" >',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
   public name="varsha"
  constructor() { }

  ngOnInit(): void {
  }

}
