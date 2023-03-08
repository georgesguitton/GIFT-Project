FROM quay.io/wildfly/wildfly:latest-jdk17

# Deploy the GIFT web-app
COPY ./target/GIFT.war /opt/jboss/wildfly/standalone/deployments/

# Deploy and set up of Postgresql Datasource
# source: https://marco.dev/use-postgresql-with-wildfly
COPY ./docker/postgresql-42.5.4.jar /opt/jboss/wildfly/modules/org/postgresql/main/
COPY ./docker/module.xml /opt/jboss/wildfly/modules/org/postgresql/main/
COPY ./docker/standalone.xml /opt/jboss/wildfly/standalone/configuration/
