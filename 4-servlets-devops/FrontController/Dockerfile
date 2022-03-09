# The first line is always FROM - this defines a base image: i need tomcat and java 8
FROM tomcat:8.0-jre8

# Adding info about who created this image
LABEL maintainer="Sophia Gavrila"

# let's imagine that the WAR file already exists...
# we want to pass the WAR file to tomcat's webapps directory
ADD target/FrontController.war /usr/local/tomcat/webapps

# The EXPOSE command informs Docker that the container listens on the 
# specified port at runtime
EXPOSE 8080

# The CMD instruction specifies what to run when the container is run
# In our case the tomcat server is started by runnning this shell script
CMD ["catalina.sh", "run"]
