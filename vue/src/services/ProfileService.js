import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/"
  });

export default {
    create(){
        return http.post('/profile/create')
    },
    update(username, profile){
        return http.put(`profile/${username}`, profile);
    }
   
    
}
 