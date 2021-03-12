import axios from 'axios';

const http = ()=>axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {

    update(username, goal){
        return http().put(`user/goals/${username}`, goal);
    },
    get(username){
        return http().get(`user/goals/${username}`);
    },
    delete(goalId){
        return http().delete(`user/goals/${goalId}`);
    },
    add(goal){
        return http().post('user/goals', goal);
    }
   
    
}
 