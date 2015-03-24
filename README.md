# teleopDraw
#Implementing the teleop application from rosjava, this app adds rostextviews to display velocity and pose information, as well as producing a live map that draws where the robot has traveled as it is currently traveling.  
The drawView of the map takes the place where the cameraView of the original application is held.
#Make sure you already have the official ros android_apps teleop code and gradle files to go with it downloaded before using this code.
Also, currently switching to other activities causes the program to crash, so the DrawingView.java and Odometry.java files that are referred to in MainActivity.java are not uploaded since they are still in development
