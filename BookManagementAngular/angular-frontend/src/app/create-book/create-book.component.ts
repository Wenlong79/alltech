import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book();

  constructor(private bookService: BookService, private router: Router) {

  }

  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

  saveBook() {
    this.bookService.createBook(this.book).subscribe(data => {
      console.log(data);
      this.goToBookList();
    }, error => console.log(error));
  }

  goToBookList() {
    this.router.navigate(['/books']);
  }

  onSubmit() {
    //throw new Error('Method not implemented.');
    console.log(this.book);
    this.saveBook();
  }




}
