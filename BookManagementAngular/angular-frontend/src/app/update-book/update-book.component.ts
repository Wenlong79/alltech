import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  book: Book = new Book();
  id!: number;

  constructor(private bookService: BookService, private route: ActivatedRoute, private router:Router) {

  }

  ngOnInit(): void {
    //throw new Error('Method not implemented.');
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBookById(this.id).subscribe(data => {
      this.book = data;
    }, error => console.log(error));
  }

  onSubmit() {
    //throw new Error('Method not implemented.');
    this.bookService.updateBook(this.id, this.book).subscribe(data => {
      this.goToBookList();
    }, error => console.log(error));
  }

  goToBookList() {
    this.router.navigate(['/books']);
  }


}
