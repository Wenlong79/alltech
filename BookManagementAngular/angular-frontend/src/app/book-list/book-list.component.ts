import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books!: Book[];

  constructor(private bookService: BookService, private router: Router) {

  }

  ngOnInit(): void {
    //throw new Error('Method not implemented.');
    this.getBooks();
  }

  getBooks() {
    this.bookService.getBookList().subscribe(data => {
      this.books = data;
    });
  }

  updateBook(id: number) {
    //throw new Error('Method not implemented.');
    this.router.navigate(['update-book', id]);
  }

  deleteBook(id: number) {
    //throw new Error('Method not implemented.');
    this.bookService.deleteBook(id).subscribe(data => {
      console.log(data);
      this.getBooks();
    });
  }

  bookDetails(id: number) {
    this.router.navigate(['book-details', id]);
  }

}
