<template>
  <form class="box form" v-on:submit.prevent>
    <section>
      <b-field label="ADD EXERCISE"> </b-field>

      <b-field label="Name">
        <b-input v-model="name"></b-input>
      </b-field>

      <b-field label="Select a date">
        <b-datepicker
          :focused-date="date"
          :first-day-of-week="1"
          placeholder="Click to select..."
          v-model="assignDate"
        >
          <b-field>
            <b-autocomplete
              open-on-focus
              readonly
              v-model="month"
              :data="months"
              field="name"
              @select="selectMonth"
            >
            </b-autocomplete>
            <p class="control">
              <span class="button is-static">{{ date.getFullYear() }}</span>
            </p>
          </b-field>
        </b-datepicker>
      </b-field>
      <b-field label="Duration">
      <b-numberinput v-model="number"></b-numberinput>
    </b-field>
      <b-field label="Exercise Descripiton">
        <b-input maxlength="200" type="textarea"></b-input>
      </b-field>
      <b-field label="Calories Burned">
      <b-numberinput v-model="number"></b-numberinput>
    </b-field>
    <b-field label="Was Equipment Used">
            <b-radio v-model='leftLabel' :native-value='false'>No</b-radio>
            <b-radio v-model='leftLabel' :native-value='true'>Yes</b-radio>
        </b-field>

      <b-button v-on:click="saveExercise" class="button is-link" type="is-info"
        >Add Exercise</b-button
      >
    </section>
  </form>
</template>

<script>
import exerciseService from "../services/ExerciseService.js";
const dateFormat = {
  year: "numeric",
  month: "2-digit",
  day: "2-digit",
};
const locale = "en-US";
export default {
  name:"add-exercise",
  data() {
    return {
      newExercise: {
        userExerciseId: "",
        userId: "",
        exerciseCategoryId: "",
        exerciseName: "",
        date: new Date().toLocaleDateString(locale, dateFormat),
        duration: 0,
        caloriesBurned: 0,
        equipmentUsed: false,
      },
      leftLabel:false,
      date: new Date(),
      month: null,
      months: [
        { name: "January", value: 0 },
        { name: "February", value: 1 },
        { name: "March", value: 2 },
        { name: "April", value: 3 },
        { name: "May", value: 4 },
        { name: "June", value: 5 },
        { name: "July", value: 6 },
        { name: "August", value: 7 },
        { name: "September", value: 8 },
        { name: "October", value: 9 },
        { name: "November", value: 10 },
        { name: "December", value: 11 },
      ],
    };
  },
  computed: {
    assignDate: {
      get: function () {
        return new Date(this.newExercise.date);
      },
      set: function (dt) {
        this.newExercise.date = dt.toLocaleDateString(locale, dateFormat);
      },
    },
  },
  methods: {
    selectMonth(option) {
      if (option) {
        this.date = new Date(this.date);
        this.date.setMonth(option.value);
      }
    },

    mounted() {
      this.month = this.months.filter(
        (item) => item.value == this.date.getMonth()
      )[0].name;
    },
    saveExercise() {
      this.newExercise.complete = false;
      exerciseService.add(this.newExercise).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_NEW", response.data);
          this.newExercise = {
            userExerciseId: "",
            userId: "",
            exerciseCategoryId: "",
            exerciseName: "",
            date: new Date().toLocaleDateString(locale, dateFormat),
            duration: "",
            caloriesBurned: "",
            equipmentUsed: false,
          };
        }
      });
    },
  },
};
</script>

<style scoped>
.box {
  display: inline-flex;
  align-items: center;
}
</style>