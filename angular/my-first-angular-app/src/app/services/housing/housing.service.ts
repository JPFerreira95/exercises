import { Injectable } from '@angular/core';
import { HousingLocation } from '../../interfaces/housing-location/housingLocation';

@Injectable({
  providedIn: 'root'
})
export class HousingService {

  constructor() { }

  url = 'http://localhost:3000/locations';

  /**
   * Method to get data via http.
   * For this to work it needs to run ```npx json-server --watch db.json``` on cmd.
   * It will create a JSON server with the data present in the root file ```db.json```.
   * 
   * @returns list of {@link HousingLocation}
   */
  async getAllHousingLocations(): Promise<HousingLocation[]> {
    const data = await fetch(this.url);
    return await data.json() ?? [];
  }

  /**
   * Method to get data via http.
   * For this to work it needs to run ```npx json-server --watch db.json``` on cmd.
   * It will create a JSON server with the data present in the root file ```db.json```.
   * 
   * @returns the {@link HousingLocation}
   */
  async getHousingLocationById(id: number): Promise<HousingLocation | undefined> {
    const data = await fetch(`${this.url}/${id}`);
    return await data.json() ?? {};
  }

  submitApplication(firstName: string, lastName: string, email: string) {
    console.log(`Homes application received: firstName: ${firstName}, lastName: ${lastName}, email: ${email}.`);
  }

}
