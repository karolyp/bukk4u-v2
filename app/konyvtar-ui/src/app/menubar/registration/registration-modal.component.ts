import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../services/user.service';
import {MatDialogRef, MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-registration-modal',
  templateUrl: './registration-modal.component.html',
  styleUrls: ['./registration-modal.component.scss']
})
export class RegistrationModalComponent {
  registrationGroup = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(4)]),
    fullName: new FormControl('', [Validators.required,]),
    password: new FormControl('', [Validators.required, Validators.minLength(8)]),
    passwordAgain: new FormControl('', Validators.required),
    passwordsMatch: new FormControl(''),
    privacyPolicy: new FormControl('', Validators.requiredTrue)
  });

  email = new FormControl('', [Validators.required, Validators.email]);


  isRegistrationInProgress = false;

  constructor(private userService: UserService, private snackBar: MatSnackBar,
              public dialogRef: MatDialogRef<RegistrationModalComponent>) {
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
      password: this.registrationGroup.value['password'],
      fullName: this.registrationGroup.value['fullName'],
      email: this.email.value,
    }).subscribe(data => {
      this.snackBar.open(`Sikeres regisztráció, ${this.registrationGroup.value['username']}!`, 'Bezár', {
        duration: 3000
      });
      this.isRegistrationInProgress = false;
      this.dialogRef.close();
    }, error => {
      console.log(error);

      let errorMsg = 'Hiba: ' + ((error.status === 400) ? error.error : 'Ismeretlen hiba történt!');
      this.snackBar.open(errorMsg, 'Close', {
        duration: 3000
      });

      this.isRegistrationInProgress = false;

    });
  }

  getErrorMessage() {
    return this.email.hasError('email') ? 'Nem valós az e-mail cím!' : '';
  }

  isFormValid() {
    return this.registrationGroup.valid && !this.email.hasError('valid') && !this.email.hasError('required');
  }
}
