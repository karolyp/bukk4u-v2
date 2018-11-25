import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginModalComponent} from './login/login-modal.component';
import {RegistrationModalComponent} from './registration/registration-modal.component';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.scss']
})
export class MenubarComponent implements OnInit {

  constructor(public dialog: MatDialog) {
  }

  isUserLoggedIn;
  username

  ngOnInit() {
    this.isUserLoggedIn = localStorage.getItem('token') !== null;
    this.username = localStorage.getItem('username');
    if(this.username === null){
      this.username = 'Profilom'
    }

  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginModalComponent);
  }

  openRegistrationDialog() {
    const dialogRef = this.dialog.open(RegistrationModalComponent, {});
  }

  logOut() {
    if(localStorage.getItem('token') !== null){
      localStorage.removeItem('token');
      localStorage.removeItem('username');
      window.location.reload();
    }
  }

}


