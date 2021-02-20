# Stack
Sample Spring Boot and react implementation to showcase functionalities of a Stack.

## Purpose
- Get Idea of Spring boot and react integration
- providing some rest api using spring boot framework.
- To illustrate Stack Operations GET,POP and PUSH

## Features

- Spring boot apis for Push, Pop and Get Operation from stack.
- React UI to perform operation on a stack.
- Only one stack is supported and is stored in memory only.
- Build docker image to allow run as container



> Stack is a DataStructure thats maintains LIFO (Last In First Out) ordering
> Three operations are implemented here, PUSH, POP and GET

## Operations Explained

You can check the overview of stack operation from the following table.

| Operation Type |  Working |
| ------ | ------ |
| PUSH | [Stack PUSH](https://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29#Problem_Description) |
| POP | [Stack POP](https://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29#Problem_Description) |
| GET | [The Get Operation](https://www.geeksforgeeks.org/stack-get-method-in-java-with-example/) |



## Tech

Following technologies are involved in the development.

- [React Js] - For FrontEnd Logic
- [Node Js] - for React Js
- [maven] - for dependency management
- [Spring Boot] - Backend Logic


## Build

- **Development**
    ```sh
    mvn clean package
    ```
- **Production**
    Production build will package both frontend and backend in jar, 
    you can get production build by running following command
    ```sh
        mvn clean package -Pprod
    ```
  
## Development

For Development hot reloading is enabled for both react and spring boot

- #### Running backend server
    ```sh
    mvn spring-boot:run
    ```
    to enble debug mode
    ```sh
    mvn spring-boot:run --debug
    ```
- ### Running Frontend 
    ```sh
    cd webapp
    yarn start or npm run build
    ```
*Note: proxy is defined in package.json, so if you are running serever on port other than 8080 then change accordingly in package.json file as well.

## Production

Application generates docker image that can be then run as a container.
Seperate profile for production has been included in the application following environment variables need to be provided before runnning.

- **PORT** : Integer port of the system, on which application need to be run
- **STACK_SIZE**: Integer, Capacity of the stack.

### Building Docker Image
- Building Locally
    ```sh
    mvn clean package
    mvn dockerfile:build
    ```

### Running Docker Image
```sh
sudo docker run -d -t -i -e PORT=<CUSTOM_PORT> \ 
-e STACK_SIZE=<CUSTOM_STACK_SIZE> \
-p <CUSTOM_PORT>:<CUSTOM_PORT> --name container_name dockerhub_id/image_name
```



