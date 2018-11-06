import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {LoginModalComponent} from './login/loginmodal.component';

@Component({
  selector: 'app-menubar',
  templateUrl: './menubar.component.html',
  styleUrls: ['./menubar.component.scss']
})
export class MenubarComponent implements OnInit {

  constructor(public dialog: MatDialog) {}


  ngOnInit() {
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LoginModalComponent);

  }

}


