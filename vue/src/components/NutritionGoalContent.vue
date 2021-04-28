<template>
  <div class="content-container">
    <img src="../assets/543-apple-outline.gif" class="nutritionIcon" />
    <p>
      You're <strong>{{ goal.activity }}</strong>
    </p>
    <p>is set to
      <strong> {{ goal.duration }}</strong> calories today!
    </p>
  </div>
</template>

<script>
export default {
  name: "nutrition-goal-content",
  props: ["goal"],
  data() {
    return {
      selectedCategory: "",
      isComplete: false,
    };
  },
};
</script>

<style scoped>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  height: 50px;
  width: 50px;
}
.content-container{
 
}
</style>