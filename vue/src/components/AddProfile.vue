<template>
  <section>
    <form class="box form">
      <b-field label="First Name">
        <b-input></b-input>
      </b-field>
       <b-field label="Last Name">
        <b-input></b-input>
      </b-field>

      <b-field label="Email">
        <b-input></b-input>
      </b-field>
      <b-field label="Age">
        <b-numberinput min="13"> </b-numberinput>
      </b-field>

      <b-field label="Height" 
        ><b-field class="height" >
        <b-select placeholder="Feet" expanded=true>
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

      <b-field label="Birthday">
        <b-datepicker
          placeholder="Click to select..."
          :min-date="minDate"
          :max-date="maxDate"
        >
        </b-datepicker>
      </b-field>

      <b-field label="Current Weight">
        <b-numberinput step="0.1"> </b-numberinput>
      </b-field>

      <button class="button is-link">Submit</button>
      <!-- Add sex? -->
    </form>
  </section>
</template>

<script>
export default {
  data() {
    const today = new Date();

    return {
      date: new Date(),
      minDate: new Date(
        today.getFullYear() - 80,
        today.getMonth(),
        today.getDate()
      ),
      maxDate: new Date(
        today.getFullYear() + 18,
        today.getMonth(),
        today.getDate()
      ),
    };
  },
};
</script>

<style scoped>
.box {
  display: inline-block;
}

</style>