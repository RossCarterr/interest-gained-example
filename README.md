# Interest Gained Example - By Ross Carter
This is a demo specifically for Yodel.
Start Date: Monday 28/07/2020
Finish Date: Tuesday 29/07/2020

## Task: Write a solution that will output the total interest gained
1.	The first 1000 gains 1%
2.	Between 1000 and 5000 gains 2%
3.	Greater than 5000 gains 3%

Example: 6400 would gain an interest of 132

This should be a full stack solution:

•	Back-End: A Spring-Boot service to calculate the interest that does basic validation on inputs. Persist the information in mongo and have an endpoint to retrieve the saved information.

•	Front-End: In React or ideally react-native, a simple app to enter interest rates and amount in the format above. A save button and a screen with recently saved transactions. Input validation is not required. Submit this to the backend service and display with the results or appropriate failure message.

Please submit your solution in 3 stages as separate zip files. This is for us to assess how your solution evolves. Please do not include any build configuration such as gradle wrapper in the zip files you submit.

## My Example: API
So currently my application is running on port 8080, with two GET requests.
1. getInterestRates - finds all the list within the database.
2. postAmounts - saved the amount calculated to the database using a post method.

The app also has 80% coverage of tests, and the extra 20% is from the model not being used, which would be increased if you wanted to improve this there would be hit via other tests within a controller/service/doa.

Unfortunately I wasn't able to put time in to using MongoDB as I haven't had much experience with it, but I still wanted to show my skills. So I used h2 database instead.

## My Example: Web
From me only having 2 nights to complete the task I spent most of my time creating and testing the api making this front-end incomplete. Due to this the web app has a table and form set up but unfortunately it is missing a complete axios request which should save the data and update the table.

## Improvement I could have made
•	I of course could have used MongoDB but with the time I had available with being in work in the day I had to use my own knowledge to complete this in the time limit.

•	Also, the next thing would be to improve the UI so that the requests work with the submit button and get the table to show the correct amounts that have been persisted into the DB.This would be done by making a fancier ES6 features like with lamba expersions for the App function, then also making the promise axios request into an async/await, so the app looks cleaners.

## Enhancements and scaling up
•	Of course this could be scaled with more requests and set up to use all CRUD requests.

•	Next would be to put on a Cloud base application or on to a server with a loadbalancer so the api can handle more and more requests depending on the traffic the API/UI is getting. 

•	Finally would be to make the application more robust by increasing testing and improving test cases.
