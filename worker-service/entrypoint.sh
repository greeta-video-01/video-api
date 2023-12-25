#!/bin/bash
set -eu # exit on first error, treat substitution of unset env vars as errors

# Modify newrelic agent property file
cd /opt/newrelic

if [ -n "${newrelic_license}" ]; then
    sed -i -e "s/'<%= license_key %>'/'${newrelic_license}'/" /opt/newrelic/newrelic.yml
    sed -i -e 's/app_name: My Application/app_name: SOH-Business-Processing-Engine/' /opt/newrelic/newrelic.yml
    java_opts=${java_opts}' -javaagent:/opt/newrelic/newrelic.jar'
    export java_opts
fi

exec java $java_opts -jar /app.jar
