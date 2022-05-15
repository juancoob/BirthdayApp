# BirthdayApp
Chalkboard coding challenge. Contact: ja.cobos.obrero@gmail.com. StackOverflow: https://stackoverflow.com/users/2713403/jaco

## How it is done?

I have use a **Clean Architecture**. That means the project has some modules to separate their scope in that order:
- app is the Android module, and there are Android frameworks and data source implementations.
- usecases is a Kotlin module that stores use cases to be invoked from the Android module.
- data is a Kotlin module that stores repositories and datasources.
- domain is a Kotlin module that stores data classes to save the data the app is going to collect from the server.

The presentation pattern used is **MVVM** to survive configuration changes.

## Reasoning

- I have used a clean architecture to have a separation of layers to have an scalable project.
- I have used MVVM as design pattern because it is esasier to follow the UDF
- I have used Hilt as DI because it is the recommended by google

## Trade-offs
- I haven't added tests due to the time constraints
- I haven't collected the data to show it in the recyclerview due to time constraints
- I haven't created the user detail due to time constrains

## What can be improved?
- Add Unit, integration and UI tests to check the code quality
- Try to paginate with the library
- Add an UiStateHolder to separate the UI logic with the UI views
- (More to add)
