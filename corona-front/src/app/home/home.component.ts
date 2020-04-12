import { Component, OnInit } from '@angular/core';
import { CovidService } from '../services/covidAPI/covid.service';
import { Observable } from 'rxjs';
import { Country } from '../model/country';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  data: Country[] = [];
  countries:Country[];
  page = 1;
  pageSize = 4;

  constructor(
    private covidService: CovidService
  ) { }

  ngOnInit(): void {
    this.getAllCountries();
  }

  getAllCountries(){
    this.covidService.getAllCountries()
    .subscribe(allCountries => {
      this.data = allCountries;
      this.data.shift();
    },err =>{
      console.log(err);
    })
  }

}
