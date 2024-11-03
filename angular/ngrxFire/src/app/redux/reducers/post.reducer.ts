import * as PostActions from '../actions/post.actions';
import { Post } from '../models/post.model';

export type Action = PostActions.All;

// default app state
const defaultState: Post = {
    text: 'Hello. I am the default post',
    likes: 0
}

// each state object is immutable
// helper function to create new state object
const newState = (state: any, newData: any) => {
    // this object.assign will build the new object from left to right, so the data on the righ will override the data from the left
    return Object.assign({}, state, newData)
}


export function postReducer(state: Post = defaultState, action: Action) {
    console.log(action.type, state);

    switch(action.type) {
        case PostActions.EDIT_TEXT:
            return newState(state, { text: action.payload });

        case PostActions.UPVOTE:
            return newState(state, { likes: state.likes + 1 });

        case PostActions.DOWNVOTE:
            return newState(state, { likes: state.likes - 1 });

        case PostActions.RESET:
            return defaultState;
        
        default:
            return state;
    }
}