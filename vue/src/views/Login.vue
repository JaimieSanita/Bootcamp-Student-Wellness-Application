<template>
  <body>
    <div id="page-container" class="all">
      <div class="container">
        
          <div
            class="box"
            box-shadow="0 0.5em 1em -0.125em rgba($scheme-invert, 0.1), 0 0px 0 1px rgba($scheme-invert, 0.02)"
          >
            <form class="form-signin" @submit.prevent="login">
              <h1 class="title">Log In</h1>
           
              <img class="logo-image" src="../assets/ElevateYourself.png" />
              <div
                class="alert alert-danger"
                role="alert"
                v-if="invalidCredentials"
              >
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
                <b-input
                  type="text"
                  id="username"
                  class="form-control"
                  placeholder="Username"
                  v-model="user.username"
                  required
                  autofocus
                />

                <b-input
                  type="password"
                  id="password"
                  class="form-control"
                  placeholder="Password"
                  v-model="user.password"
                  required
                />
              </div>

              <div class="login-button">
                <b-button
                  id="in"
                  class="button is-primary is-focused"
                  :expanded="true"
                  type="submit"
                  v-on:click.prevent="login"
                  >Sign in</b-button
                >
              </div>

              <div class="register-container">
                <p class="register-question">Don't have an account?</p>
                <router-link
                  style="color: #00adee"
                  class="sign-up"
                  :to="{ name: 'register' }"
                  >Sign Up</router-link
                >
              </div>
            </form>
          </div>
        </div>
      </div>
    
    <te-footer id="footer" />
  </body>
</template>

<script>
import TeFooter from "../components/TeFooter.vue";
import authService from "../services/AuthService";
import profileService from "../services/ProfileService";

export default {
  name: "login",
  components: { TeFooter },
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
            return profileService.get(this.user.username);
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
  text-align: center;
  background-color: rgba(248, 248, 255, 0.75);
  position:relative;
  
}


.box {
  margin-top: 150px;
  padding-top: 10px;
  background-color: rgba(248, 248, 255, 0.75);
  color: #3B3E42;
  display: flex;
  justify-content: center;
  font-family: proxima-nova;
  padding-bottom: 20px;


}
.page-container {
  background: url(../assets/backgroundRegister.jpg);
  position: relative;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
.title {
  color: #3B3E42;
  display: flex;
  position: relative;
  font-family: proxima-nova;
  padding-left: 37%;
  margin-bottom: 0px;
}
#submit {
  background-color: #00adee;
  font-family: proxima-nova;
}
.sign-up:hover {
  color: white;
  font-family: proxima-nova;
  font-weight: bold;
  text-decoration: underline;
}
.button {
  font-family: proxima-nova;
  margin: 2px;
}
#username {
  border-radius: 5px;
  font-family: proxima-nova;
}
#password {
  border-radius: 5px;
  font-family: proxima-nova;
}
body {
  background: url(../assets/colors.jpg);
  position: relative;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
 
}
.register-container {
  padding-top: 10px;
}

.login-buttons {
  text-decoration-color: white;
  display: flex;
  justify-content: center;
  padding-top: 15px;
  font-family: provima-nova;
}

#page-container {
  position: relative;
  min-height: 100vh;
}

#content-wrap {
  padding-bottom: 2.5rem;
}

#footer {
  font-size: small;
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 2.5rem;
}

</style>