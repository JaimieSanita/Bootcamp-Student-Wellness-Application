<template>
  <form class="box form" v-on:submit.prevent>
    <section>
      <b-field label="Name" type="is-primary">
        <b-select
          placeholder="Exercise"
          :expanded="true"
          class="exercise-input"
          v-model="newExercise.exerciseName"
        >
          <option value="running">Running</option>
          <option value="dancing">Dancing</option>
          <option value="swimming">Swimming</option>
          <option value="biking">Biking</option>
        </b-select>
      </b-field>

      <b-field label="Duration">
        <b-numberinput
          icon-pack="fas"
          class="duration-input"
          v-model="newExercise.exerciseLength"
          type="is-primary"
          value="times"
        ></b-numberinput>
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
      <b-field label="Exercise Descripiton">
        <b-input
          maxlength="200"
          type="textarea"
          v-model="newExercise.exerciseDescription"
        ></b-input>
      </b-field>
      <b-field label="Calories Burned">
        <b-numberinput v-model="newExercise.caloriesBurn"></b-numberinput>
      </b-field>
      <b-field label="Was Equipment Used">
        <b-radio v-model="newExercise.equipment" :native-value="false"
          >No</b-radio
        >
        <b-radio v-model="newExercise.equipment" :native-value="true"
          >Yes</b-radio
        >
      </b-field>
      <b-button v-on:click.prevent="saveExercise" type="is-primary"
        >{{ this.exisitingExercise ? "Edit" : "Add" }} Exercise Goal</b-button
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
  components: {},
  name: "add-flexibility-form",
  props: ["exisitingExercise"],
  mounted() {
    if (this.exisitingExercise) {
      //target    //source
      const gl = {};
      this.newExercise = Object.assign(gl, this.exisitingExercise); //enumerates over properties of existing goal and copy onto new goal
    }
  },
  data() {
    return {
      newExercise: {
        userExerciseId: "",
        userId: "",
        exerciseCategoryId: 4,
        exerciseCategory: "",
        exerciseName: "",
        date: new Date().toLocaleDateString(locale, dateFormat),
        exerciseLength: 0,
        exerciseDescription: "",
        caloriesBurn: 0,
        equipment: false,
      },
      showForm: true,
      leftLabel: false,
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
      if (this.exisitingExercise) {
        exerciseService.updateExercise(this.newExercise).then((response) => {
          if (response.status === 200) {
            this.$store.commit("UPDATE_EXERCISE", this.newExercise);
            this.$store.commit("SET_CURRENT_EDITING_EXERCISE", null);
          }
        });
      } else {
        exerciseService.add(this.newExercise).then((response) => {
          if (response.status === 201) {
            this.$store.commit("ADD_NEW_EXERCISE", response.data);
            this.$store.commit("SET_CURRENT_EDITING_EXERCISE", null);
            this.showForm = false;
            this.newExercise = {
              userExerciseId: "",
              userId: "",
              exerciseCategoryId: 4,
              exerciseName: "",
              date: new Date().toLocaleDateString(locale, dateFormat),
              exerciseLength: 0,
              exerciseDescription: "",
              caloriesBurn: 0,
              equipment: false,
            };
          }
        });
      }
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