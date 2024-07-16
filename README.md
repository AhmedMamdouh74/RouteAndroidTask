# RouteAndroidTask
Android Application consisting of only 1 Activity when the user opens the app should check the network connectivity and if the device is connected to the internet then get the products and if it's not connected it will get the products from Room database.

## Tech Stack
- Clean Architecture with MVVM
- Modularity
- Coroutines
- Unit test
- Handle Configuration Changes
- Dependency injection design pattern
- Repository design pattern
- flow, ViewModel
- Retrofit
- DataBinding
- Recycler view
- Glide for Image Loading
## Screen shot
<img src="https://github.com/user-attachments/assets/7ec5cf38-3c59-489e-b826-990d1fe457e4" alt="loading products" width="250"/>
<img src="https://github.com/user-attachments/assets/a1e1c6f4-09d1-43a0-9cd2-b0cb7501e203" alt="the cached products" width="250"/>

## UseCases
GetProductsUseCase

## Test Cases
- when call getProducts from data source it should get data from api()
- verify when call getProducts it should call Products data source()



