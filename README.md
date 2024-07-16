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
- Room DataBase
- DataBinding
- Recycler view
- Glide for Image Loading
## Screen shot

<img src="https://github.com/user-attachments/assets/9daf6d35-ccb3-4f34-984d-b0e6b6ef3231" alt="loading products" width="250"/>

<img src="https://github.com/user-attachments/assets/745a9b91-6a5e-40f0-ae2f-c03945a08319" alt="the cached products" width="250"/>

## UseCases
GetProductsUseCase

## Test Cases
- when call getProducts from data source it should get data from api()
- verify when call getProducts it should call Products data source()



