# ggrosario
Sistema a presentar para el complemento de la cátedra Lenguaje de programación Java - UTN 2016

# 1. Deployment info

I'm using Maven to integrate the **Heroku Maven Plugin** (among others things) to easily deploy this Java Web Application. See the pom.xml file to see the dependencies and plugins used in this project.

## 1.1 Deployment method

The deployment method used for being able to use the Heroku Maven Plugin is the **Heroku Git (Heroku Toolbelt)**

## 1.2 Commands for deployment

Use the following command to upload and deploy a slug that will be executed on the cloud (it can take a while depending on the slug size)
```
"c:\Program Files\apache-maven-3.3.9\bin\mvn" clean heroku:deploy-war
```
Once the slug have uploaded and deployed successfuly, run the following two commands:
```
heroku restart --app ggrosario // Restarts the Heroku app

heroku open --app ggrosario // Browses the Heroku app
```

# To-Do list
- [x] Improve IU
- [x] Remove auto-generated comments
- [x] Rename packages from **rosariogaming** to **ggrosario**
- [x] Add client-side validation
- [x] Try to show server exception messages to client (server side validation)
- [x] Create and mantain a To-Do list
- [x] Add more items in the To-Do list
- [x] Client side validation
- [x] Change remote database credentials and not publish them :)
- [x] Reserve confirmation
