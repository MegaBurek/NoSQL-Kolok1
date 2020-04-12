import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CovidService {

  private covidUrl = 'http://localhost:8080/covid/'

  constructor() { }
}
