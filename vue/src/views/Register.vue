<template>
  <div id="register" class="text-center">
    <section class="form">
      <form class="form-register" @submit.prevent="register">
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
        <b-field label="Email">
          <b-input v-model="profile.email"></b-input>
        </b-field>

        <b-field label="First Name">
          <b-input
          v-model="profile.firstName"></b-input>
        </b-field>
        <b-field label="Last Name">
          <b-input v-model="profile.lastName"></b-input>
        </b-field>

        <b-field label="Age">
          <b-numberinput type="is-info" v-model="profile.age"> </b-numberinput>
        </b-field>

        <b-field label="Height"
          ><b-field class="height" type="is-info">
            <b-numberinput placeholder="Feet" type="is-info" controls-alignment="left" v-model="profile.feet"> </b-numberinput>
           <b-numberinput placeholder="Inches" type="is-info" controls-alignment="right" v-model="profile.inches"> </b-numberinput>
          </b-field>
        </b-field>

        <b-field label="Current Weight">
          <b-numberinput step="0.1" type="is-info" v-model="profile.weight"> </b-numberinput>
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
          <b-button
            v-on:click="register"
            class="btn btn-lg btn-primary btn-block"
            type="is-info"
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
</template>

<script>
import profileService from "../services/ProfileService";
import authService from "../services/AuthService";

export default {
  name: "register",
  components: {},
  data() {
    return {
      isCreated: false,
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      profile: {
        firstName: "",
        lastName: "",
        email: "",
        age: "",
        feet: "",
        inches: "",
        weight: "",
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
              return profileService.update(this.user.username, this.profile)
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
</style>
