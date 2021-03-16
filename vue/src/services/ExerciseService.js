import axios from 'axios';

const http = ()=>axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {
    listAll(){
        return http().get("user/exercise/")
    },
    add(exercise){
        return http().post("user/exercise", exercise);
    },
    update(exerciseId, exercise){
        return http().put(`user/exercise/${exerciseId}`, exercise)
    },
    delete(exerciseId){
        return http().delete(`user/goals/${exerciseId}`)
    }
    
    
}