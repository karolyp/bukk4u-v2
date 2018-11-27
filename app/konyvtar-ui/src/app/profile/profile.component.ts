import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {User} from '../models/User';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  user: User = new User();

  constructor(public dialogRef: MatDialogRef<ProfileComponent>,
              private userService: UserService) {
  }

  ngOnInit() {
    this.userService.getUser(localStorage.getItem('username')).subscribe(res => {
      this.user = res;
    });
  }

}
