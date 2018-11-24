import {Component, Input, OnInit} from '@angular/core';
import {Book} from '../../models/Book';
import {BookService} from '../../services/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  private book: Book = new Book();

  constructor(private bookService: BookService,
              private route: ActivatedRoute,
              private router:Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.bookService.getBook(params['id']).subscribe(res => {
        console.log(res);
        this.book.authors = res.authors;
        this.book.categories = res.categories;
        this.book.keywords = res.keywords;
        this.book.title = res.title;
        this.book.id = res.id;
        this.book.description = res.description;
      }, error => {
          this.router.navigate(['/404']);
      });
    });
  }

}
