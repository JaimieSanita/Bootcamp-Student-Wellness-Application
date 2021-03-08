<template>
  <form class="box form">
    <b-field label="ADD FOOD ITEM"></b-field>
      <b-field label="Category" type="is-info">
      <b-select placeholder="Type of Meal" expanded="true">
        <option value="Breakfast">Breakfast</option>
        <option value="Lunch">Lunch</option>
        <option value="Dinner">Dinner</option>
        <option value="Snack">Snack</option>
        <option value="Dessert">Dessert</option>
      </b-select>
      </b-field>
    <b-field label="Name" type="is-info">
      <b-select placeholder="Name">
        <option value="Apple">Apple</option>
        <option value="Banana">Banana</option>
        <option value="Orange">Orange</option>
        <option value="Avocado">Avocado</option>
        <option value="Lime">Lime</option>
        <option value="Lemon">Lemon</option>
        <option value="Mango">Mango</option>
        <option value="Papaya">Papaya</option>
        <option value="Carrot">Carrot</option>
        <option value="Stawberry">Strawberry</option>
        <option value="Watermelon">Watermelon</option>
        <option value="Kiwi">Kiwi</option>
      </b-select>
    </b-field>
    <b-field label="Servings" type="is-info">
      <b-select placeholder="Number of Servings">
        <option value="0.5">0.5</option>
        <option value="1.0">1.0</option>
        <option value="1.5">1.5</option>
        <option value="2.0">2.0</option>
        <option value="2.5">2.5</option>
        <option value="3.0">3.0</option>
        <option value="3.5">3.5</option>
        <option value="4.0">4.0</option>
        <option value="4.5">4.5</option>
        <option value="5.0">5.0</option>
        <option value="5.5">5.5</option>
        <option value="6.0">6.0</option>
        <option value="6.5">6.5</option>
        <option value="7.0">7.0</option>
      </b-select>
    </b-field>

    <b-button class="button is-link" type="is-info">Add Food</b-button>
   
  </form>
</template>

<script>
export default {};
</script>

<style scoped>
.box {
  display: inline-block;
}
</style>