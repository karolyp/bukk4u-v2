import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../services/user.service';
import {MatDialogRef, MatSnackBar} from '@angular/material';

@Component({
  selector: 'login-modal',
  templateUrl: './login-modal.html',
  styleUrls: ['./login-modal.scss']
})
export class LoginModalComponent {

  loginGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  duration3Sec = {
    duration: 3000
  };

  constructor(private userService: UserService, private snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<LoginModalComponent>,) {
  }

  onSubmit() {
    this.userService.loginUser(this.loginGroup.value).subscribe(data => {
      localStorage.setItem('token', JSON.stringify(data));
      localStorage.setItem('username', this.loginGroup.value['username']);
      this.snackBar.open(`Sikeres bejelentkezés, ${this.loginGroup.value['username']}!`, 'Bezár', this.duration3Sec);
      window.location.reload();
    }, error => {
      if (error.status === 400) {
        this.snackBar.open(error.error, 'Bezár', this.duration3Sec);
      } else {
        this.snackBar.open('Ismeretlen hiba történt, próbáld újra!', 'Bezár', this.duration3Sec);
        console.error(
          `Backend returned code ${error.status}, ` +
          `body was: ${error.error}`);
      }
    });
  }

}
