import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8081/"
  });

export default {
    create(){
        return http.post('/profile/create')
    },
    update(username, profile){
        return http.put(`profile/${username}`, profile);
    }
   
    
}
 