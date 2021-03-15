import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import Buefy from 'buefy'

Vue.use(Vuex)
Vue.use(Buefy)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    profile: {
      firstName: "",
      lastName: "",
      email: "",
      age: 0,
      feet: 0,
      inches: 0,
      weight: 0,
    },
    goals: [
      {
        userGoalsId: "",
        userId: "",
        categoryId: 0,
        category: "",
        activity: "",
        date: "",
        perWeek: 0,
        duration: 0,
        complete: false,
      }
    
    ],
   
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    UPDATE_PROFILE(state, profile) {
      state.profile = profile;
    },

    FLIP_STATUS(state, goalToChange) {
      goalToChange.complete = !goalToChange.complete;
    },
    CHANGE_COLOR(state, goalToChange){
      if(goalToChange.category === 'Sanity'){
        goalToChange.classList.add("sanity-goal");
      } else if (goalToChange.category === 'Exercise'){
        goalToChange.classList.add("exercise-goal");
      } else {
        goalToChange.classList.add("nutrition-goal");
      }
    },
    ADD_NEW(state, goal){
      state.goals.push(goal);
    },
    DELETE_GOAL(state, id){
     state.goals = state.goals.filter((goal)=>{
       return goal.userGoalsId !=    id;
        });
      
    },
    UPDATE_GOAL(state, goal) {
      state.goals = state.goals.map((currentGoal)=>{
       if(currentGoal.userGoalsId === goal.userGoalsId){
         return goal;
       }
        return currentGoal;
      })
    },
  }
})
