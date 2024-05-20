# Use a base image with Java installed
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /struts2

# Copy the Struts2 application WAR file to the container
COPY target/struts2.war /app/your-app.war

# Install Tomcat
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.56/bin/apache-tomcat-9.0.56.tar.gz && \
    tar xzvf apache-tomcat-9.0.56.tar.gz && \
    mv apache-tomcat-9.0.56 /usr/local/tomcat && \
    rm apache-tomcat-9.0.56.tar.gz

# Copy the WAR file to the Tomcat webapps directory
RUN cp /app/struts2.war /usr/local/tomcat/webapps/

# Expose the default Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
