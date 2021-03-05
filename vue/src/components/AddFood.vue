<template>
  <form class="box form">
        <b-field label="Food">
            <b-input></b-input>
        </b-field>       
          <b-field label="Servings">
            <b-select placeholder="Number of Servings" >
                <option value="0.5">0.5</option>
                <option value="1">1</option>
                 <option value="1.5">1.5</option>
                <option value="2">2</option>
                <option value="2.5">2.5</option>
                <option value="3">3</option>
                <option value="3.5">3.5</option>
                <option value="4">4</option>
                <option value="4.5">4.5</option>
                <option value="5">5</option>
                <option value="5.5">5.5</option>
                <option value="6">6</option>
                <option value="6.5">6.5</option>
                <option value="7">7 </option>
            </b-select>
        </b-field>       
          <b-field label="Meal" >
            <b-select placeholder="Type of Meal" expanded=true>
                <option value="Breakfast">Breakfast</option>
                <option value="Lunch">Lunch</option>
                <option value="Dinner">Dinner</option>
                <option value="Snack">Snack</option>
                <option value="Dessert">Dessert</option>
            </b-select>
        </b-field>
        
        <button class="button is-link">ADD</button>
        <!-- Add sex? -->
       </form>

</template>

<script>
export default {

}
</script>

<style scoped>

.box{
   display: inline-block;
}
</style>