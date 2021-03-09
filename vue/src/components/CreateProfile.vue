<template>
  <div class="container">
    <b-field label="Email">
      <b-input v-model="profile.email"></b-input>
    </b-field>
    <b-field label="First Name">
      <b-input v-model="profile.firstName"></b-input>
    </b-field>
    <b-field label="Last Name">
      <b-input v-model="profile.lastName"></b-input>
    </b-field>
    <b-field label="Age">
      <b-numberinput type="is-info" v-model="profile.age"> </b-numberinput>
    </b-field>
    <b-field label="Height"
      ><b-field class="height" type="is-info">
        <b-numberinput
          placeholder="Feet"
          type="is-info"
          controls-alignment="left"
          v-model="profile.feet"
        >
        </b-numberinput>
        <b-numberinput
          placeholder="Inches"
          type="is-info"
          controls-alignment="right"
          v-model="profile.inches"
        >
        </b-numberinput>
      </b-field>
    </b-field>

    <b-field label="Current Weight">
      <b-numberinput step="0.1" type="is-info" v-model="profile.weight">
      </b-numberinput>
    </b-field>
  </div>
</template>

<script>
export default {
    name:"create-profile",
  data() {
    return {
      profile: {
        firstName: "",
        lastName: "",
        email: "",
        age: 0,
        feet: 0,
        inches: 0,
        weight: 0,
      },
    };
  },
};
</script>

<style scoped>
</style>