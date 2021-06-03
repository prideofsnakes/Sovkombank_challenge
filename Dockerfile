FROM openjdk:11
ARG STARTER_FILE=starter_kit/target/PhoneNumbers.jar
ARG WSDL_FILE=wsdlWS/target/wsdlWS-0.0.1-SNAPSHOT.jar
ARG REST_FILE=restWS/target/restWS-0.0.1-SNAPSHOT.jar
ARG SCHEMA=/wsdlWS/soapService.wsdl
COPY ${STARTER_FILE} /home/app/start.jar
COPY ${WSDL_FILE} /home/app/wsdl.jar
COPY ${REST_FILE} /home/app/rest.jar
COPY ${SCHEMA} /home/app/soapService.wsdl
CMD java -jar /home/app/start.jar & java -jar /home/app/wsdl.jar & java -jar /home/app/rest.jar