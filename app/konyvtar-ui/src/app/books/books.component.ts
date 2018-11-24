import {Component, OnInit} from '@angular/core';
import {BookService} from '../services/book.service';
import {Book} from '../models/Book';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  private books: any[] = [];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.bookService.getBooks()
      .subscribe((res) => {
        res.forEach(e => {
          let b : Book = new Book();
          b.authors = e.authors;
          b.categories = e.categories;
          b.keywords = e.keywords;
          b.title = e.title;
          b.id = e.id;
          b.description = e.description;
          this.books.push(b);
        })
    });
  }

}
