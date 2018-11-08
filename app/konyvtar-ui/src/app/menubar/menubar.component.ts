import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginModalComponent} from './login/loginmodal.component';
import {RegistrationModalComponent} from './registration/registration-modal.component';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.scss']
})
export class MenubarComponent implements OnInit {

  constructor(public dialog: MatDialog) {}


  ngOnInit() {
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginModalComponent);
  }

  openRegistrationDialog() {
    const dialogRef = this.dialog.open(RegistrationModalComponent,{
    });
  }
}


