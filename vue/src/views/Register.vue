<template>
  <div id="register" class="text-center">
     <section class="form">
    <form class="box-form" @submit.prevent="register">
      <h3 class="title">Let's Get You an Account!</h3>
      <h1 class="subtitle">Please fill out the following fields to create your account</h1>
      
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      
      </div>

      <b-field label="Username" ></b-field>
      <b-input
        type="text"
        id="username"
        class="form-control"
        
        v-model="user.username"
        required
        autofocus
      ></b-input>

      <b-field label="Password" ></b-field>
      <b-input
        type="password"
        id="password"
        class="form-control"
        
        v-model="user.password"
        required
      ></b-input>
      <b-field label=" Confirm Password" ></b-field>
      <b-input
        type="password"
        id="confirmPassword"
        class="form-control"
     
        v-model="user.confirmPassword"
        required
      ></b-input>

        <b-field label="First Name">
        <b-input ></b-input>
      </b-field>
       <b-field label="Last Name">
        <b-input></b-input>
      </b-field>

      <b-field label="Age">
        <b-numberinput min="13" type="is-info"> </b-numberinput>
      </b-field>

      <b-field label="Height" 
        ><b-field class="height" type="is-info">
        <b-select placeholder="Feet" expanded=true >
          <option value="1">1 ft</option>
          <option value="2">2 ft</option>
          <option value="3">3 ft</option>
          <option value="4">4 ft</option>
          <option value="5">5 ft</option>
          <option value="6">6 ft</option>
          <option value="7">7 ft</option>
        </b-select>
        <b-select placeholder="Inches" expanded=true>
          <option value="1">1 in</option>
          <option value="2">2 in</option>
          <option value="3">3 in</option>
          <option value="4">4 in</option>
          <option value="5">5 in</option>
          <option value="6">6 in</option>
          <option value="7">7 in</option>
          <option value="8">8 in</option>
          <option value="9">9 in</option>
          <option value="10">10 in</option>
          <option value="11">11 in</option>
        </b-select>
      </b-field>
      </b-field>

      <b-field label="Current Weight">
        <b-numberinput step="0.1" type="is-info"> </b-numberinput>
      </b-field>
 
 
      <!--
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      -->
     <div class="btn">
      <b-button class="button is-link" type="is-info">Create Account</b-button>
      </div>
      <div class="link">
       <router-link :to="{ name: 'login' }" class="have-an-account">Have an account?</router-link>
      </div>
      
    </form>
     </section>
  </div>
</template>

<script>

import authService from '../services/AuthService';

export default {
  name: 'register',
  components: {


  },
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else { //successful
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' }, //where to insert save profile
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

section {
  display: flex;
  justify-content: center;
}
.button is-link{
  display: flex;
  justify-content: center;
}
.link{
  display: block;
  justify-content: center;
}
.title, .subtitle{
  margin-bottom: 1.0rem;
  justify-content: center;
  display: flex;
}
.link, .btn {
  justify-content: center;
  display: flex;
}
.btn{
  margin-top: 2.0rem;
  margin-bottom: 1.0rem;
}
.have-an-account{
  color:rgb(28, 139, 230);
}


</style>
