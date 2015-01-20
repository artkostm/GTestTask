# GTestTask
Simple console application

Please, create simple java console application which accepts csv file with locations on the earth and for each location finds time zone via google time zone service then writes results to output file.
FUNCTIONAL SPECIFICATION
Input params:
Path to csv file with locations.
Location is a comma-separated lat,lng tuple (eg. location=-33.86,151.20)
File format: lat,lng
Example
33.86,151.20
45.86,151.20
33.86,44.20
11.86,25.20
33.86,151.20 ...
Output params:
Path to csv file with results
File format: lat,lng,dstOffset,rawOffset,timeZoneId,timeZoneName,status
Example
33.86,151.20,0.0,-28800.0,America/Los_Angeles,Pacific Standard Time,OK
33.86,151666.20,,,,,FAILED ...
Please see all necessary documentation here - https://developers.google.com/maps/documentation/timezone/
Technical requirements:
*Build system is gradle
