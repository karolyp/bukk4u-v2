import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CustomModules} from './custom-modules';
import {MenubarComponent} from './menubar/menubar.component';
import {LoginModalComponent} from './menubar/login/login-modal.component';
import {RegistrationModalComponent} from './menubar/registration/registration-modal.component';
import {SearchComponent} from './menubar/search/search.component';
import {HttpClientModule} from '@angular/common/http';
import {UserService} from './services/user.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BooksComponent} from './books/books.component';
import {BookComponent} from './books/book/book.component';
import {BookService} from './services/book.service';
import {NotFoundComponent} from './not-found/not-found.component';
import {HomeComponent} from './home/home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ProfileComponent } from './profile/profile.component';
import { RatingsComponent } from './books/book/ratings/ratings.component';
import { RatingComponent } from './books/book/ratings/rating/rating.component';
import { RentalComponent } from './books/book/rental/rental.component';

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    LoginModalComponent,
    RegistrationModalComponent,
    SearchComponent,
    BooksComponent,
    BookComponent,
    NotFoundComponent,
    HomeComponent,
    ProfileComponent,
    RatingsComponent,
    RatingComponent,
    RentalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomModules,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [
    UserService,
    BookService
  ],
  entryComponents: [
    LoginModalComponent,
    RegistrationModalComponent,
    ProfileComponent
    ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
