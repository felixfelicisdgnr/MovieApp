# Movie App

This project is an application that offers features such as listing, searching, filtering, viewing detailed movie data, and adding movies to favorites. It is developed using modern software development approaches and tools.

## Features

### Movie List

- Users can view a list of available movies.
- Search movies by name or director.
- Sort movies by name, rating, or price.
- Navigate to the detailed page of a selected movie.
- Offers Dark Mode and Light Mode themes.
- Supports both Turkish and English languages.

### Movie Details

- View movie details.
- Place movie orders.
- Add or remove movies from favorites.

### Favorites Screen

- View movies added to favorites.
- Add or remove movies from favorites.

### Basket Screen

- Increase or decrease the quantity of items added to the cart.
- Remove items from the cart.

## Technologies Used

- **Jetpack Compose:** Modern and declarative UI building.
- **Retrofit:** API communication.
- **Dagger Hilt:** Dependency injection.
- **Coil:** Image loading.
- **Clean Architecture:** Application architecture.
- **Navigation:** Screen navigation.
- **Coroutines:** Managing data streams.
- **Room Database:** Local storage for user favorite movies.

## Architecture and Approaches

### Clean Architecture

The project follows Clean Architecture principles, providing a modular and scalable structure. The application consists of the following layers:

- **Domain Layer:**
  - Contains business rules and Use Cases.
  - Independent of UI or data layers.

- **Data Layer:**
  - Manages API and database operations.
  - Uses the Repository design pattern to provide data to the domain layer.

- **UI Layer:**
  - Builds the user interface.
  - Manages user experience using State, Event, and Effect patterns.

### Use Case

Each Use Case is designed to perform a specific function and can be tested independently. Examples include:

- Fetching the movie list.
- Adding a movie to favorites.
- Removing an item from the cart.

### State, Event, and Effect

- **State:** Represents the current state of the user interface, such as loading status or error messages.
- **Event:** Represents actions triggered by the user or system, such as button clicks.
- **Effect:** Represents one-time events that capture the user's attention, such as displaying an error message.

## API

This project uses the following APIs for fetching movie data and managing cart operations:

- **Fetch All Movies:** `http://kasimadalan.pe.hu/movies/getAllMovies.php`
- **Fetch Basket Movies:** `http://kasimadalan.pe.hu/movies/getMovieCart.php`
- **Add Movie to Basket:** `http://kasimadalan.pe.hu/movies/insertMovie.php`
- **Delete Movie from Basket:** `http://kasimadalan.pe.hu/movies/deleteMovie.php`
- **Fetch Movie Images:** `http://kasimadalan.pe.hu/movies/images`


## Testing

Follow these steps to test the application:

1. View the list of movies on the home page.
2. Navigate to the details page of a selected movie.
3. Add a movie to the cart from the details page. 
4. View the cart.
5. Add and view movies in the favorites screen.
6. Remove items from the cart one by one.

