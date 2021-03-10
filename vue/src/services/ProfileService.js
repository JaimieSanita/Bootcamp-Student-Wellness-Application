import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {

    update(username, profile){
        return http.put(`profile/${username}`, profile);
    },
    get(username){
        return http.get(`profile/${username}`);
    }
   
    
}
 