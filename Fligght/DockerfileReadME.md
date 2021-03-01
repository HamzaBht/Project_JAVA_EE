# TO TEST THE PROJECT USING DOCKER

## YOU NEED TO PULL THE IMAGE AND RUN IT

## to pull the image :

`docker pull hamzabht/flight-comparator:latest`

## TO RUN THE APPLICATION LOOK AT THE [3TH STEP ](#step3)

# TO DOCKERIZE THE PROJECT

## 1- YOU NEED TO BUILD AND PACKAGE THE PROJECT (HERE ALREADY BUILT) USING THE COMMAND :

`docker run -it --rm -v ${PWD}:/app -w /app maven:3.6.3-openjdk-17 mvn clean install`

## PS : you need to be in your project dir (here Fligght)

## ps 2 : if you are using windows run the cmd in powershell if your using linux change ${PWD} to "$PWD"

## 2- BUILD THE DOCKERFILE :

`docker build -f Dockerfile -t {IMAGENAME}:{TAG}`

## EXEMPLE :

`docker build -f Dockerfile -t myapp:1`

## <h4 id="step3"> 3- RUN THE APPLICATION : </h4>

`docker run --rm -p {PORT}:8080 {IMAGENAME}:{TAG}`

## EXEMPLE :

`docker run --rm -p 8080:8080 myapp:1`

## NOW YOU CAN ACCESS YOUR WEB APPLICATION AT THE FOLLOWING URL IN THE BROWSER

`http://localhost:{PORT}/{PROJECT*NAME}*{PROJECT_VERSION}/`

## PS : the project name and version exist in pom.xml

## EXEMPLE :

`http://localhost:9000/Fligght-1.0-SNAPSHOT/`
