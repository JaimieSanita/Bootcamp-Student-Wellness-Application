<template>
  <div class="container">
    <b-field label="Email">
      <b-input v-model="email"></b-input>
    </b-field>
    <b-field label="First Name">
      <b-input v-model="firstName"></b-input>
    </b-field>
    <b-field label="Last Name">
      <b-input v-model="lastName"></b-input>
    </b-field>
    <b-field label="Age">
      <b-numberinput type="is-primary" v-model="age"> </b-numberinput>
    </b-field>
    <b-field label="Height"
      ><b-field class="height" type="is-primary">
        <b-numberinput
          placeholder="Feet"
          type="is-primary"
          controls-alignment="left"
          v-model="feet"
        >
        </b-numberinput>
        <b-numberinput
          placeholder="Inches"
          type="is-primary"
          controls-alignment="right"
          v-model="inches"
        >
        </b-numberinput>
      </b-field>
    </b-field>

    <b-field label="Current Weight">
      <b-numberinput step="0.1" type="is-primary" v-model="weight">
      </b-numberinput>
    </b-field>
  </div>
</template>

<script>
export default {
  name: "create-profile",
  props: ["isEdit"],
  created(){
    if(this.isEdit){
    //todo 
    //load profile from api (call)
    //set profile onto vuex
    } else{
    this.$store.commit('UPDATE_PROFILE', {
      firstName: "",
      lastName: "",
      email: "",
      age: 0,
      feet: 0,
      inches: 0,
      weight: 0,
    });
    }
  },
  computed: {
    weight: {
      get() {
        return this.$store.state.profile.weight;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.weight = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    feet: {
      get() {
        return this.$store.state.profile.feet;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.feet = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    inches: {
      get() {
        return this.$store.state.profile.inches;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.inches = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    age: {
      get() {
        return this.$store.state.profile.age;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.age = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    lastName: {
      get() {
        return this.$store.state.profile.lastName;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.lastName = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    firstName: {
      get() {
        return this.$store.state.profile.firstName;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.firstName = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
    email: {
      get() {
        return this.$store.state.profile.email;
      },
      set(value) {
        const profile = this.$store.state.profile;
        profile.email = value;
        this.$store.commit("UPDATE_PROFILE", profile);
      },
    },
  },
};
</script>

<style scoped>
*{
  color: #3B3E42;
}
</style>