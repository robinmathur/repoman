import { Component, OnInit } from '@angular/core';
import {Proforma} from '../model/proforma';

@Component({
  selector: 'app-performa',
  templateUrl: './proforma.component.html',
  styleUrls: ['./proforma.component.css']
})
export class ProformaComponent implements OnInit {
  proformas: Proforma[] = [];
  constructor() { }

  ngOnInit(): void {
    this.proformas.push(new Proforma('xyz.pdf', 'Demo xyz', new Date()));
    this.proformas.push(new Proforma('abc.xml', 'Demo abc', new Date()));
  }

  create(){

  }

  search(searchString: string) {

  }
}
