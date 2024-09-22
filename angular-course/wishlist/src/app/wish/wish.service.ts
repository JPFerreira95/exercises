import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { WishItem } from '../../shared/models/wishitem';
import { catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WishService {

  URI = 'assets/wishes.json';

  constructor(private http: HttpClient) {
  }

  private getStandardOptions() : any {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
  }

  getWishes(): Observable<any> {
    let options = this.getStandardOptions();

    // this is the same as adding ?format=json to the URI
    options.params = new HttpParams({
      fromObject: {
        format: 'json'
      }
    })

    return this.http.get(this.URI, options).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if(error.status === 0) {
      console.error(`There is a issue with the client of network: ${error.error}`);
    } else {
      console.error('Server-side error', error.error);
    }

    return throwError(() => new Error('Cannot retrieve wishes from the server. Please try again.'));
  }

  private addWish(wish: WishItem) {
    let options = this.getStandardOptions();
    // The headers are always overritten, so the options.headers.set does a copy of the exiting and adds the new params
    options.headers = options.headers.set('Authorization', 'value-needed-for-authorization')
    this.http.post(this.URI, wish, options);
  }

}
