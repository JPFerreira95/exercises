import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideStore } from '@ngrx/store';
import { simpleReducer } from './redux/reducers/simple.reducer';
import { postReducer } from './redux/reducers/post.reducer';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),
    provideStore({ 
      post: postReducer,
      message: simpleReducer 
    })
  ]
};
