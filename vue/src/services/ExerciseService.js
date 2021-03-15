import axios from 'axios';

const http = ()=>axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {
    listAll(username){
        return http().get(`user/exercise/${username}`)
    },
    add(username, exercise){
        return http().post(`user/exercise/${username}`, exercise);
    },
    update(exerciseId, exercise){
        return http().put(`user/exercise/${exerciseId}`, exercise)
    },
    delete(exerciseId){
        return http().delete(`user/goals/${exerciseId}`)
    }
    
    
}