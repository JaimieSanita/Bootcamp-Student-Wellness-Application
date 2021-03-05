<template>
    <section>
       <form class="box form">
        <b-field label="Name">
            <b-input></b-input>
        </b-field>

        <b-field label="Email">
            <b-input ></b-input>
        </b-field>
         <b-field label="Age">
            <b-numberinput min="13">
            </b-numberinput>
        </b-field>
         <b-field label="Height">
            <b-numberinput step="0.1" min="3.0">
            </b-numberinput>
        </b-field>
        
        
         <b-field label="Current Weight">
            <b-numberinput step="0.1">
            </b-numberinput>
        </b-field>
        
        <button class="button is-link">Submit</button>
        <!-- Add sex? -->
       </form>


    </section>
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