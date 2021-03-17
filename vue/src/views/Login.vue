<template>
<div class="all">
  <div class="header">
    <div class="banner-container">
      <div style="position:relative; left:-780px;"        id="nav">
      <router-link id="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
   
      <h3 class="banner-title">Never forget, as you elevate, Wellovate!</h3>
    </div>
    <div class="welcome-container">
      <img class="logo-image" src="../assets/logo.png">
      <h1 class="title">
        Welcome to The Tech Elevator Wellovater!
      </h1>
    </div>
  </div>
<div class="container">
   <img class="background" src="https://media.istockphoto.com/photos/elevator-picture-id180821428?k=6&m=180821428&s=612x612&w=0&h=SLXASBb52_ekAmTp4qz5i2_VYehC4X2qA9DsuySCe7A=">
  <div id="login" class="text-center">
    <div class="banner-container">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In or Sign Up to Begin Your Wellness</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <div class="control">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
        
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      </div>
     
      <div>
      <router-link class="sign-up" :to="{ name: 'register' }">Sign Up</router-link>
     
      <button class="button is-primary is-small is-focused" type="submit">Sign in</button>
    </div>
    </form>
    </div>
 </div>
  </div>
  <te-footer></te-footer>
  
  </div>
</template>

<script>
import TeFooter from '../components/TeFooter.vue';
import authService from "../services/AuthService";
import profileService from "../services/ProfileService";

export default {
  name: "login",
  components: {TeFooter},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            //TODO return calling the profile api
           return profileService
              .get(this.user.username);
             
          }
        }) 
        .then((response) => {
                if (response.status === 200) {
                  //.then if valid profile call vuex mutation to set profile
                  this.$store.commit("UPDATE_PROFILE", response.data);
                  this.$router.push("/");
                }
              })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style scoped>

.container {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 30%;
  font-family: proxima-nova;
}
.welcome-container {
  background-color: #00adee;
  display: flex;
  justify-content: flex-start;
font-family: proxima-nova;
  height: 90px;
  margin: 10px;
}
.banner-container {
  background-color: #8cc63f;
  color: white;
  display: flex;
  justify-content: center;
 font-family: proxima-nova;
}
.title{
  color: white;
  display: flex;
  padding: 30px;
  position: relative;
  padding-left: 28%;
  font-family: proxima-nova;
}
#submit{
  background-color: #00adee;
  font-family: proxima-nova;
}
.sign-up{
  color: black;
  padding: 10px;
  font-family: proxima-nova;
}
.button{
  font-family: proxima-nova;
  margin: 2px;
}
#username{
  border-radius: 5px;
  font-family: proxima-nova;
}
#password{
  border-radius: 5px;
  font-family: proxima-nova;
}
.all{
  font-family: proxima-nova;
}
</style>