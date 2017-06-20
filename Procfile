# web: cd build ; java $JAVA_OPTS -Dgrails.env=prod java -jar ../gradle/


web: cd build ; java $JAVA_OPTS -Xmx256m -Dgrails.env=prod -jar server/webapp-runner-*.jar --expand-war --port $PORT libs/*.war

# web: cd build ; java $JAVA_OPTS -Dgrails.env=prod -jar ../build/server/webapp-runner-.jar --expand-war --port $PORT libs/.war

# -jar server/webapp-runner.jar $RUNNER_OPTS --port 43849 target/*.war