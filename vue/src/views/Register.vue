<template>
<body>
  <div id="register" class="text-center-container">
    <section class="form">
      <form class="form-container" @submit.prevent="register">
        <h3 class="title">Let's Get You an Account!</h3>
        <h1 class="subtitle">
          Please fill out the following fields to create your account
        </h1>
        <div class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>

        <b-field label="Username"></b-field>
        <b-input
          type="text"
          id="username"
          class="form-control"
          v-model="user.username"
          required
          autofocus
        ></b-input>

        <b-field label="Password"></b-field>
        <b-input
          type="password"
          id="password"
          class="form-control"
          v-model="user.password"
          required
        ></b-input>
        <b-field label=" Confirm Password"></b-field>
        <b-input
          type="password"
          id="confirmPassword"
          class="form-control"
          v-model="user.confirmPassword"
          required
        ></b-input>

       <create-profile :isEdit="false"/>

        <div class="btn">
          <b-button
            v-on:click="register"
            class="btn btn-lg btn-primary btn-block"
            type="is-primary"
            >Create Account</b-button
          >
        </div>
        <div class="link">
          <router-link :to="{ name: 'login' }" class="have-an-account"
            >Have an account?</router-link
          >
        </div>
      </form>
    </section>
  
  </div>
  </body>
</template>

<script>
import profileService from "../services/ProfileService";
import authService from "../services/AuthService";
import CreateProfile from '../components/CreateProfile.vue';

export default {
  name: "register",
  props: ["createProfile"],
  components: {
    CreateProfile
  },
  data() {
    return {
      isCreated: false,
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        //successful
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              return profileService.update(this.user.username, this.$store.state.profile);
            }
          })
          .then((response) => {                
            if (response.status == 200) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" }, //where to insert save profile
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
section {
  display: flex;
  justify-content: center;
}
.button is-link {
  display: flex;
  justify-content: center;

}
.link {
  display: block;
  justify-content: center;
}
.title,
.subtitle {
  margin-bottom: 1rem;
  justify-content: center;
  display: flex;
}
.link,
.btn {
  justify-content: center;
  display: flex;
}
.btn {
  margin-top: 2rem;
  margin-bottom: 1rem;
}
.have-an-account {
  color: rgb(28, 139, 230);
}

.text-center-container{
  background: url(../assets/colors.jpg);
  position:relative;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
.form-container{
  background-color: rgba(248, 248, 255, 0.75);
  position:relative;
  padding: 0 20px;
 
}
.title{
  margin-top: 20px;
}
* {
  box-sizing: border-box;
 
}

</style>
