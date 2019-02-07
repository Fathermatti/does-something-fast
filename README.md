# does-something-fast

#### Run using docker

```docker run -p 8080:8080 fathermatti/does-something-fast```


#### Or just build and run using Gradle

``` gradle build && java -jar build/libs/does-something-fast-1.0.0.jar```


####

Then maybe fire some requests at it:

``` curl localhost:8080/do-something/{integer}```


