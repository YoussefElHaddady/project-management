FROM ubuntu-jdk

ENV jdbcurl=jdbc:postgresql://project-management-db-aws.c9rt4qtdzhft.us-east-2.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=rootroot
ENV version=aws-db-usage

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]