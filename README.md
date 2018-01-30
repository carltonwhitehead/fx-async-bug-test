# Async Bug Test

A simple app to demonstrate a bug I encountered with a TestFX test in a TornadoFX app.

I noticed while updating my TornadoFX version from 1.7.12 to 1.7.14 that one of my tests broke. Things seemed to go off the rails when a `runAsyncWithProgress` in the `View` under test was rejected by a `ThreadPoolExecutor` with status `Terminated`. I saw in the release notes for 1.7.13 there was a change  "internal thread pools are shut down on app exit". Setting the TornadoFX version to 1.7.13 resulted in the same failure, confirming my suspicion that it was related to the above change.

Run the test with `mvn clean test`.

I suspect there is an issue with my test's handling of the TestFX / TornadoFX app lifecycle.

