lombok-compile-test
===============

This is a PoC that only setting lombok annotation
processor in `pluginManagement -> plugin ->
maven-compiler-plugin -> configuration` is enough.

test scenarios
-----------

The maven-compile-plugin is never added directly under
`build -> plugins`, but only its configuration is managed
by `build -> pluginManagement`.

There is the default configuration, which does not add
any annotation processor. It shall fail ugly when
compiling the project.

And there is the `lombok` profile. This only adds the
lombok annotation processor in the maven-compiler-plugin
configuration, it shall work nicely and beatifully.

And also there is the `internal-lombok` that is equals
to `lombok` profile, but only defined in the module that
uses lombok.

This shall fail:

```bash
./mvnw clean compile # always keeping it clean, it shall fail
./mvnw clean compile -P lombok # this shall succeed
./mvnw clean compile -P internal-ombok # this shall also succeed
```

why maven modules? why not simpler?
--------------

For some reason that I cannot explain, a simple, non
nested layout for maven project got everything compiling.
It could even be some mistake of my part.

Creating the modules was a way to check that the
compilation would be fine only if the annotation
processor is present.