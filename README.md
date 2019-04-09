# Celestial-Body-Server
Backend for celestial body program



## Required functional components

* A client application&mdash;an Android app, a Java SE application, web pages constructed dynamically on the server side using a templating or component approach, etc.

* An application server, usually in the form of a REST service provider.

* A database server&mdash;typically&mdash;but not necessarily&mdash;a MySQL or Derby database server. (Note that the application server and database server may reside on different hosts or the same host; they may even be embedded in a single program.)

    The inclusion of a back-end database (which is required) doesn't preclude the use of a database on the client side&mdash;e.g. a SQLite database on Android. In fact, your client implementation will still be expected to include some kind of persistent data store.

* Communication between the client application and server application. Typically, this will consist of one or more REST (or REST-like) services published by the server application, and consumed by the client application. These services should allow the client application to create, read, and update (and optionally delete) objects stored on the server side, in accordance with the business logic of the server side.

* Support for multiple simultaneous client application users, connected as relevant to the server application.

* Automated pre-loading of any relevant base data sets (client- and server-side).

* User authentication (this may&mdash;and often does&mdash;leverage the services of an OAuth2 provider, such as Google).

## Current Development of Celestial Bodies

Celestial Bodies is close to being complete, the user is able to point their device towards an a star or planet in the sky and click the capture button and instantly get the top 10 stars, ordered by magnitude. The user is able to check their previous sky-searches in the history screen or retrieve more info about the current stars that the user captured. Capturing stars displays an image of the grouping of stars and also the current ascension and declination of the position of the users device.

### Unimplemented/Incomplete Elements of Celestial Bodies

+ The dashboard displays categories to search, but each categories do not diplay anything once clicked.
+ The search is currently no connected to backend server, therefore cannot make queries.
+ Info doesn't search when item is clicked
+ Need to make the app stay in profile orientation by disabling landscape view

### Known Issues/Bugs

+ App crashes if there is a duplicate star within a search.

## Android API Version and Hardware

for this application the following were used to test UI and function.
+ Andrid API 27
+ Nexus 5x emulator

## Third Party Libraries

+ [Retrofit](https://square.github.io/retrofit/) (includes OkHttp and Retrofit)

  Retrofit is designed to establish and perform requests to CoolClimate API web service.
  
+ [Stetho](https://github.com/facebook/stetho/blob/master/README.md)

  Stetho is a developmental tool that examines the local display resources and database contents.

+ [Deep Dive Android Utilities](https://github.com/deep-dive-coding-java/android-utilities/blob/master/README.md)

+ Room

+ [Sensor-fusion](https://bitbucket.org/apacha/sensor-fusion-demo)

  Sensor-fusion is a publicly-available demo that allows the user to access their phone's gyroscope and/or accelerometer
     in order to map out its spatial orientation.

## External Services
This app accesses has the HYG star database pre-loaded as well accesses the Wikisky XML API.

### WikiSky

WikiSky provided the ability information and the ability to search for stars.
+ [WikiSky.org](http://www.wikisky.org/)

+ [Wikisy XML API](http://server3.wikisky.org/XML_API_V1.0.html)

### HYG Database

HYG Star Database provided and managed 100,000+ star database that was used for our backend server.

+ [GitHub](https://github.com/astronexus/HYG-Database/blob/master/README.md)
+ [Background Information](http://www.astronexus.com/hyg)
+ [Version Control](http://www.astronexus.com/endeavour)

## Design Documentation

+ [ERD](docs/ERD_backend.pdf)

+ [User Stories](docs/User_Stories.md)

+ [DDL](docs/ddl.md)

## Javadoc Page

## Licenses/Copyright
[Copyright & Licenses](/docs/Copyright_&_Licenses.md)

## Instructions for Building Celestial Bodies

+ 1. [From the celestial-bodies github repository](https://github.com/celestial-bodies/Celestial-Body-Server)
        copy the SSH copy key
        
       ![screenshot1](https://user-images.githubusercontent.com/46542189/55815440-98264e00-5aad-11e9-9e26-ba008e776128.png)
        
+ 2. Open up your preferred IDE (Intellij in this example) and from the homepage, select "Check out from version Control."
        Select git and paste the SSH key into the url field, save it to a a directory of your choosing, and click "Clone."
        
        ![screenshot2](https://user-images.githubusercontent.com/46542189/55815521-bbe99400-5aad-11e9-903f-cb1f883a0b8d.png)
        
        ![screenshot3](https://user-images.githubusercontent.com/46542189/55815907-682b7a80-5aae-11e9-8d00-6eb324913b9d.png)
         
+ 3. Once the clone is finished, you'll be asked whether or not you want to open the project, and you may do so, no import needed.
       Once the project is open, it'll take a moment to build, but once finished, you can run the server.


## Instructions for Using Celestial Bodies

+ Once the program is cloned and ready to go, just allow it to build and launch the server before launching the app.

## Celestial Bodies, All Rights Reserved
