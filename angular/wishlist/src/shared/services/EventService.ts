import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class EventService {
    // will allow us to pass messages from the Observable Object to the subscriber objects
    private subject = new Subject();

    /**
     * Emit function
     */
    emit(eventName: string, payload: any) {
        this.subject.next({eventName, payload});
    }

    /**
     * Listen method
     * 
     * @param eventName - the event name
     * @param callback - callback function that receives an event of type any and returns void
     */
    listen(eventName: string, callback: (event: any) => void) {
        this.subject.asObservable().subscribe((nextObj : any) => {
            if (eventName === nextObj.eventName) {
                callback(nextObj.payload);
            }
        });
    }

}