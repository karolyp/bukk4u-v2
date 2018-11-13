import {Component, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../services/user.service';
import {MatDialogRef, MatSnackBar} from '@angular/material';

@Component({
  selector: 'registration-modal',
  templateUrl: './registration-modal.component.html',
  styleUrls: ['./registration-modal.component.scss']
})
export class RegistrationModalComponent {
  registrationGroup = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(4)]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)]),
    passwordAgain: new FormControl('', Validators.required),
    passwordsMatch: new FormControl(''),
    privacyPolicy: new FormControl('', Validators.requiredTrue)
  });

  isRegistrationInProgress = false;

  constructor(private userService: UserService, private snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<RegistrationModalComponent>,) {
  }


  onInput() {
    if (this.registrationGroup.get('password').value === this.registrationGroup.get('passwordAgain').value) {
      this.registrationGroup.get('passwordsMatch').setErrors(null);
    } else {
      this.registrationGroup.get('passwordsMatch').setErrors({'invalid': true});
    }
  }

  onSubmit() {
    this.isRegistrationInProgress = true;
    this.userService.saveUser({
      username: this.registrationGroup.value['username'],
      password: this.registrationGroup.value['password']
    }).subscribe(data => {
      this.snackBar.open('You have been successfully registered!', 'Close', {
        duration: 3000
      });
      this.isRegistrationInProgress = false;
      this.dialogRef.close();
    }, error => {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
      this.snackBar.open('Error: ' + error.error, 'Close', {
        duration: 3000
      });
      this.isRegistrationInProgress = false;

    });
  }


}
