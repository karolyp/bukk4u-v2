import {Component, Input, OnInit} from '@angular/core';
import {BookService} from '../../../services/book.service';
import {UserService} from '../../../services/user.service';
import {FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.scss']
})
export class RatingsComponent implements OnInit {

  @Input() bookId;
  ratings: any;
  userRated = false;
  ratingText = new FormControl('', [Validators.required]);
  rate = 5;

  constructor(private bookService: BookService,
              private userService: UserService) {
  }

  ngOnInit() {
    this.getBookRatings();
  }

  sendRating() {
    let rating = {
      username: this.userService.getUsernameFromLocalStorage(),
      stars: this.rate,
      textRating: this.ratingText.value,
      date: new Date().toISOString(),
      bookId: this.bookId
    };
    this.bookService.saveRating(rating).subscribe(res => {
      if (res.status === 200) {
        this.ngOnInit();
      }
    });
  }

  getBookRatings() {
    this.bookService.getBookRatings(this.bookId).subscribe((res) => {
      this.ratings = [];
      res.forEach(e => this.ratings.push(e));
      console.log(this.ratings);
      let username = this.userService.getUsernameFromLocalStorage();
      for (let r in this.ratings) {
        if (this.ratings[r].username === username) {
          this.userRated = true;
          break;
        }
      }
    });
  }

}
