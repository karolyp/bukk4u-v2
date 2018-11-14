import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomModules} from './custom-modules';
import {MenubarComponent} from './menubar/menubar.component';
import {LoginModalComponent} from './menubar/login/login-modal.component';
import {RegistrationModalComponent} from './menubar/registration/registration-modal.component';
import {HttpClientModule} from '@angular/common/http';
import {UserService} from './services/user.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    LoginModalComponent,
    RegistrationModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomModules,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    UserService
  ],
  entryComponents: [
    LoginModalComponent,
    RegistrationModalComponent
    ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
