# Test app
This app help in all Machine Learning ops.
 1. Registering new data source.
 2. Updating already registered data source.
 3. Getting an already registered data source.


## Gradle tasks

Simple build (includes checks and tests)
```
./gradlew clean build
```

## Running the application

Using gradle
```
SPRING_PROFILES_ACTIVE=local ./gradlew -DRAPID_CONFIG_PROFILE=local clean bootRun
```

Running from IntelliJ
* Set the following VM Options
```
-DRAPID_CONFIG_PROFILE=local -Dspring.profiles.active=local
```

* As this is a spring boot project, then simply run the BpeMergerApplication.java file.

Using Spring Boot fat jar
```
./gradlew clean build
java -DRAPID_CONFIG_PROFILE=local -Dspring.profiles.active=local -jar build/libs/test_app.jar
```


## Check Application works
```

