import {Component, Input, OnInit} from '@angular/core';
import {Rating} from '../../../../models/Rating';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.scss']
})
export class RatingComponent implements OnInit {

  @Input() rating: Rating;

  constructor() {
  }

  ngOnInit() {
  }

  timestampToDate(timestamp) {
    return new Date(timestamp).toLocaleString();
  }

}
