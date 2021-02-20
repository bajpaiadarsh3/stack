FROM openjdk:8-jdk-alpine3.9

ARG group=ubuntu
ARG user=ubuntu
ARG version=0.0.1-SNAPSHOT

# Create a group
RUN addgroup -g 1000 $group

# Create an user
RUN adduser -u 1000 -G $group -h /home/$user -D $user

RUN mkdir -p /home/$user/deploy

RUN chown $group:$user /home/$user -R

USER $user

#set current work directory for the project
WORKDIR /home/$user

ADD ./target/stack-$version.jar ./deploy/stack.jar


# For a complete list of java options refer https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html
CMD java -jar deploy/stack.jar --spring.profiles.active=prod