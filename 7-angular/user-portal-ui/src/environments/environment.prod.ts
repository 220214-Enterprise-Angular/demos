export const environment = {
  production: true // when we run ng build --prod ... even though --prod is no longer necessary
};

// This will change when we deploy the Spring Boot API to the publicly accessible EC2 Remote server
export const url = `http://3.94.8.125:5000/api`;
