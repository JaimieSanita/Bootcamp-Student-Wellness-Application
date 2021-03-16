import axios from 'axios';

const http = ()=>axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {

    update(goal){
        return http().put(`user/goals/${goal.userGoalsId}`, goal);
    },
    getAll(){
        return http().get('user/goals/');
    },
    delete(goalId){
        return http().delete(`user/goals/${goalId}`);
    },
    add(goal){
        return http().post('user/goals', goal);
    },
    getGoalById(userGoalsId){
        return http().get(`user/goals/${userGoalsId}`);
    }
   
    
}
 