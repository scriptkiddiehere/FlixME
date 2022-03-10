# Flixme review/rating system

## Generatl instructions

1. Clone this repo
1. Create a branch with your llid_firstname_lastname
1. Checkout to your branch
1. Work on the project on a daily basis
1. Add/commit/push to your respective remote branch
1. **DO NOT PUSH TO MASTER BRANCH**

<pre>
Intro:

Flixme is a membership based OTT platform for watching latest movies and TV shows. People can do a self registration to access their favorite movies and shows. The platform is a pre-paid system, where in the user will deposite a fixed amount, and they will be charged for the amount of usage (in minutes) of the platform. Once the balance reaches a threshold, they will be notified for refilling the amount.

Scope:
Flixme want to provide a review and rating system for the movies and shows to be provided by the users.

Modules:
1. Users module
  a. There are two types of users - admin and customers
  b. Only customers do self registration
  c. In order to access the platform customers should login
  d. Customers may view/edit their details
  e. Customers may check/refill balance amount
2. Movies and shows module
  a. Customers should be able to search movies based on title
  b. Customers should be able to browse movies based on various parameters (e.g, genre, actors, year, ...)
3. Review and rating module
  a. Customers should be able to view the ratings and reviews by other customers
  b. Customers should be able to add/edit their own rating and/or review
4. Admin module
  a. First login as "admin" should ask for setting of password
  b. Admin should have provision for the following:
    i. Reset own's password
    ii. Add/edit movie/show details
    iii. View and moderate user reviews 

Iterative projects:
1. A console application, expected to be error proof (shouldn't break the app), to implement all of the above features using appropriate workflow.
2. A Spring MVC based web application, reusing all the entity, service, dao and exception classes from the console application.
3. A Spring boot based RESTful services, incorporating the micro service architecture.

</pre>
