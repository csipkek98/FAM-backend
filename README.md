# FAM-backend

This is the backend side for my interesting PET project.  
For the other parts, please use the following links:

## About the project
The project is meant to be a "home page" for my friend group. It contains a News page, where we can find news related to gaming and a "Free game" page, where I use an API to get data from games that are free to play.

## Project structure

Presentation flowchart with a simple request on the backend
```mermaid
graph LR
A(( Client 'Frontend')) -- API endpoint call. --> B[Backend]
B -- Get Data about not saved games --> E['Freetogame' API]
B -- Get Data about saved games--> C[PSQL Database]
B -- Get Data about Gaming news --> D[Python  Scraper]
```

## Backend structure

I use Java Spring-boot to manage my backend side. It's a relatively fast and reliable framework for this purpose. Here I tried to follow the Spring Architecture norms, like layers to be a bit more structured.
<hr>
    
### Controller layer

![image](https://user-images.githubusercontent.com/90270578/236260895-82d5f8a4-b5ae-4353-9dbf-70953f712dfd.png)<br>

Here are the endpoints for the API in the backend, like the "FreeGameController", where we can reach all games, filtered games or just one specific game<br><br>
<img src="https://user-images.githubusercontent.com/90270578/236261158-7dd19f9c-5c3c-4320-b7f8-31ad051bb131.png" width="700px"><br>
All the endpoints start with "/api/" to better fit for the best practices
<hr>

### Service layer

![image](https://user-images.githubusercontent.com/90270578/236266212-d27616b4-be04-4a00-8d41-93615aaf131d.png)


Here we can find the "Business logic" for the different endpoints in the application.  
In the following example we get a game by ID
First, we try to get it from the Database and send it if it is saved. If not, then we get it from the 'Freetogame' API with the correct url form, then we save it, parse it to JSON and send it back to the client<br><br>
![image](https://user-images.githubusercontent.com/90270578/236265518-08a639c9-4de7-4ed1-bd1f-e648e324b4b2.png)
<hr>

### Repository layer

![image](https://user-images.githubusercontent.com/90270578/236266153-c5b6295b-eb55-4071-82bf-7e8c63055d30.png)


Because we only save games currently to the Database, therefor we only have a "FreeGameDetailedRepository" to get data from the Database with the help of Hibernate

We transfer data with the help of DTOs ( or Models) and Entitys, like "FreeGame", where we store the short form of the different games until we send it away or process it

![image](https://user-images.githubusercontent.com/90270578/236268399-a6575cec-d528-4684-a5f1-abc55dd1793b.png)
![image](https://user-images.githubusercontent.com/90270578/236268362-77ef90bf-9885-4f84-b53f-6f9a1f82408d.png)
