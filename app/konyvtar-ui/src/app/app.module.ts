import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomModules} from './custom-modules';
import {MenubarComponent} from './menubar/menubar.component';
import {LoginModalComponent} from './menubar/login/loginmodal.component';

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    LoginModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomModules,

  ],
  providers: [],
  entryComponents: [
    LoginModalComponent
    ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
