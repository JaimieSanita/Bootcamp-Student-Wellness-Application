<template>
  <form class="box form">
    <section>
      <b-field label="ADD EXERCISE">
          <b-field label="Category" type="is-info">
        <b-select placeholder="Category" expanded=true>
          <option value="Endurance">Endurance</option>
          <option value="Endurance">Balance</option>
          <option value="Endurance">Strength</option>
          <option value="Endurance">Flexibility</option>
        </b-select>
          </b-field>
      </b-field>

        <b-field label="Name" type="is-info">
        <b-select placeholder="Name" expanded=true>
        <option value="Running">Running</option>
        <option value="Walking">Walking</option>
        <option value="Yoga">Yoga</option>
        <option value="Weight-Lifting">Weight Lifting</option>
        <option value="Swimming">Swimming</option>
        <option value="Meditation">Meditation</option>
        <option value="Stretching">Stretching</option>
        <option value="Pilates">Pilates</option>
        </b-select>
        </b-field>

           <b-field label="Duration">
      <b-numberinput v-model="number"  type="is-info"></b-numberinput>
    </b-field>

     <b-field label="Calories Burned">
      <b-numberinput v-model="number" type="is-info"></b-numberinput>
    </b-field>
 
    <b-button class="button is-link" type="is-info">Add Exercise</b-button>
    </section>
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.box{
   display: inline-flex;
   align-items: center;
}
</style>