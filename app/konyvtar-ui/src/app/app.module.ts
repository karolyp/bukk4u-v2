import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomModules} from './custom-modules';
import {MenubarComponent} from './menubar/menubar.component';
import {LoginModalComponent} from './menubar/login/loginmodal.component';
import {RegistrationModalComponent} from './menubar/registration/registration-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    LoginModalComponent,
    RegistrationModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomModules,

  ],
  providers: [],
  entryComponents: [
    LoginModalComponent,
    RegistrationModalComponent
    ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
