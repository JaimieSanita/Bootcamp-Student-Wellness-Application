<template>
    <Tabs orientation="horizontal">
        <Tab name="Exercise History" :selected="true">
            <exercise-history></exercise-history>
        </Tab>
        <Tab name="Food History">
            <food-history></food-history>
        </Tab>
    </Tabs>
</template>

<script>
import { Tabs, Tab } from '@crow1796/vue-bulma-tabs'
import ExerciseHistory from '../components/ExerciseHistory.vue';

import FoodHistory from '../components/FoodHistory.vue';
export default {
    components: {
        Tabs,
        ExerciseHistory,
    FoodHistory,
        Tab
    }
}
</script>

<style>

</style>