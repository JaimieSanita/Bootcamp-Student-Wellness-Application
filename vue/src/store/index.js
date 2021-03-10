import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

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
        id: 1,
        category: "Exercise",
        activity: "Walking",
        dayAssigned: "3/8/2021",
        perWeek: 5,
        duration: 10,
        complete: false,
      },
      {
        id: 2,
        category: "Nutrition",
        activity: "Banana",
        dayAssigned: "3/6/2021",
        perWeek: 5,
        duration: 0,
        complete: false,
      },
      {
        id: 3,
        category: "Wellness",
        activity: "Meditation",
        dayAssigned: "3/8/2021",
        perWeek: 3,
        duration: 20,
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
    ADD_NEW(state, goal){
      state.goals.push(goal);
    },
  }
})
