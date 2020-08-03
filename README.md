"# AltiBusBooking" 

Configuration: 
--------------
  >> application.properties:
    spring.datasource.url=jdbc:h2:file:G:/Web/Data/busbooking
Change the directory to appropriate folder in your system

Steps:
------
1. Import Bus Booking postman collection in POSTMAN
2. Run admin/addBus api for adding Bus - pls find the sample Bus data below
3. Run admin/addSeat by changing the busNumber as 1, 2, 3 so on.
4. Access localhost:8080 to go to search bus page
5. From: Chennai, To: Theni, Date: Any data - Search

Screenshot:

![alt text](https://github.com/prasathraj92/AltiBusBooking/blob/master/booking-scrshot.png?raw=true) 


Add Bus Sample Data:
--------------------

TAT:
----
{
"busNumber" : "1",   
"operatorName" : "TAT",
"departure" : "2020-08-02 20:30:33.578", 
"arrivalTime" : "2020-08-03 08:30:33.578", 
"duration" : 10,    
"price" : 1200,        
"totalSeats" : 40,  
"availableSeats" : 30, 
"source" : "Chennai",  
"destination" : "Theni"
}

KPN:
---
{
"busNumber" : "2",   
"operatorName" : "KPN",
"departure" : "2020-08-02 20:10:33.578", 
"arrivalTime" : "2020-08-03 08:10:33.578", 
"duration" : 10,    
"price" : 1000,        
"totalSeats" : 40,  
"availableSeats" : 39, 
"source" : "Chennai",  
"destination" : "Theni"
}

Vignesh:
--------
{
"busNumber" : "3",   
"operatorName" : "Vignesh",
"departure" : "2020-08-02 19:10:33.578", 
"arrivalTime" : "2020-08-03 07:10:33.578", 
"duration" : 10,    
"price" : 1100,        
"totalSeats" : 40,  
"availableSeats" : 30, 
"source" : "Chennai",  
"destination" : "Theni"
}
