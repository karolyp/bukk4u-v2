import {AfterViewInit, Component, OnInit} from '@angular/core';
import {Book} from '../../models/Book';
import {BookService} from '../../services/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  private book: Book = new Book();
  private currentRate: any;
  private nextId: any;
  private previousId: any;

  constructor(private bookService: BookService,
              public userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.bookService.getBook(params['id']).subscribe(res => {
        this.book.authors = [];
        this.book.categories = [];
        this.book.keywords = [];
        res.authors.forEach(e => this.book.authors.push(e.name));
        res.categories.forEach(e => this.book.categories.push(e.name));
        res.keywords.forEach(e => this.book.keywords.push(e.value));
        this.book.title = res.title;
        this.book.id = res.id;
        this.book.description = res.description;
        this.book.date = new Date(res.date).getFullYear();
        this.book.publisher = res.publisher;
        this.book.language = res.language;
        this.book.numberOfPages = res.numberOfPages;
        this.book.coverUrl = res.coverUrl;
      }, error => {
        this.router.navigate(['/404']);
      });

      this.bookService.getBookRatingAverage(params['id']).subscribe(res => {
        this.currentRate = res.average;
      }, error => {
        this.router.navigate(['/404']);
      });

      this.bookService.getNextBook(params['id']).subscribe(res => {
        this.nextId = res.id;
      });

      this.bookService.getPreviousBook(params['id']).subscribe(res => {
        this.previousId = res.id;
      });

    });

  }


}
