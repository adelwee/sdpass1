# Cinema Management System

## Introduction
This project is a Cinema Management System that I developed to demonstrate my understanding of several creational design patterns in Java. Throughout the process, I applied patterns like Singleton, Factory Method, Abstract Factory, Builder, and Prototype to address different requirements within the system. The system is designed to manage various aspects of a cinema, such as movies, ticket bookings, and schedules.

My main goal in this project was to build a flexible and organized system that adheres to solid software design principles, making it both scalable and easy to maintain.

## Design Patterns Used
Here’s a breakdown of the design patterns I used and why they were chosen for each part of the system:

1. **Singleton Pattern**: I used this pattern to manage the global configuration of the cinema system, such as the cinema name and number of screens. This ensures that only one instance of the configuration class exists throughout the entire application.

2. **Factory Method Pattern**: This pattern is responsible for creating different types of movies (regular, IMAX, etc.). It allows the system to create specific types of movies based on user input or system needs.

3. **Abstract Factory Pattern**: This pattern generates user interface components for different themes (e.g., dark and light themes). By using this pattern, I ensured that the UI elements are consistent across different parts of the application depending on the selected theme.

4. **Builder Pattern**: I applied the Builder pattern to simplify the ticket booking process. It allows the user to select a movie, seat, and even snacks in a step-by-step manner, and then the system builds a ticket based on those selections.

5. **Prototype Pattern**: For managing movie schedules, I used the Prototype pattern, which allows the system to easily clone and modify existing schedule templates without needing to recreate them from scratch each time.

## Code Explanation

### 1. **Singleton Pattern: Cinema Configuration**
The `CinemaConfig` class is where I applied the **Singleton** pattern. This class manages the global settings of the cinema, like the cinema’s name and the number of screens. By using Singleton, I ensure that the configuration is consistent across the entire application and that there is only one instance of the `CinemaConfig`.

```java
public class CinemaConfig {
    private static CinemaConfig instance;
    private String cinemaName;
    private int numberOfScreens;

    private CinemaConfig() {}

    public static CinemaConfig getInstance() {
        if (instance == null) {
            instance = new CinemaConfig();
        }
        return instance;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public int getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(int numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }
}
```

- **Why Singleton?**: I chose Singleton here because it’s important to have a single, consistent source of truth for the system’s settings, preventing the creation of multiple conflicting instances.

### 2. **Factory Method Pattern: Movie Creation**
For the creation of different movie types, I used the **Factory Method** pattern. I created a `MovieFactory` class that is responsible for producing movies like regular movies or IMAX movies. This way, the creation process is encapsulated, making it easy to extend the system if new movie types are introduced.

```java
public abstract class MovieFactory {
    public abstract Movie createMovie(String title);
}

public class RegularMovieFactory extends MovieFactory {
    @Override
    public Movie createMovie(String title) {
        return new RegularMovie(title);
    }
}

public class IMAXMovieFactory extends MovieFactory {
    @Override
    public Movie createMovie(String title) {
        return new IMAXMovie(title);
    }
}
```

- **Why Factory Method?**: I used the Factory Method because it allows the system to decide which movie type to create based on specific needs or input, keeping the creation logic flexible and reusable.

### 3. **Abstract Factory Pattern: UI Theme Generation**
I applied the **Abstract Factory** pattern to create user interface components like buttons. Depending on the selected theme (light or dark), the system generates the corresponding UI elements. This ensures that all UI components are consistent with the chosen theme, providing a cohesive user experience.

```java
public interface UIFactory {
    Button createButton();
}

public class DarkThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }
}

public class LightThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightThemeButton();
    }
}
```

- **Why Abstract Factory?**: By using Abstract Factory, I ensured that the creation of UI elements is abstracted, allowing the system to switch between themes easily, without modifying the underlying code for each UI component.

### 4. **Builder Pattern: Ticket Booking**
To simplify the creation of complex ticket bookings, I used the **Builder** pattern. The user can specify details like the movie title, seat number, and snack combo in a step-by-step fashion, and the system builds the complete ticket at the end.

```java
public class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    public TicketBooking(String movieTitle, String seatNumber, String snackCombo) {
        this.movieTitle = movieTitle;
        this.seatNumber = seatNumber;
        this.snackCombo = snackCombo;
    }

    @Override
    public String toString() {
        return "Movie: " + movieTitle + ", Seat: " + seatNumber + ", Snacks: " + snackCombo;
    }
}
```

```java
public class TicketBookingBuilder {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    public TicketBookingBuilder setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
        return this;
    }

    public TicketBookingBuilder setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public TicketBookingBuilder setSnackCombo(String snackCombo) {
        this.snackCombo = snackCombo;
        return this;
    }

    public TicketBooking build() {
        return new TicketBooking(movieTitle, seatNumber, snackCombo);
    }
}
```

- **Why Builder?**: The Builder pattern allows me to construct ticket bookings in a more readable and organized way. It makes the process of setting up different booking options much more intuitive, especially when there are multiple fields to configure.

### 5. **Prototype Pattern: Movie Schedule**
The **Prototype** pattern is used in the `MovieSchedule` class to create and clone schedules for movies. Instead of creating a new schedule from scratch each time, I can clone an existing schedule and make small adjustments (like changing the time).

```java
public class StandardSchedule implements MovieSchedule {
    private Movie movie;
    private String time;

    @Override
    public MovieSchedule clone() {
        try {
            return (MovieSchedule) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie: " + movie.getTitle() + ", Time: " + time;
    }
}
```

- **Why Prototype?**: This pattern saves time when creating new schedules that are similar to existing ones. Instead of repeating the same setup, I can simply clone and modify.

## How to Run the Project
### Requirements:
- You need to have **Java 8** or higher installed on your machine.

### Steps:
1. Clone or download the project files.
2. Navigate to the `src` directory and compile all Java files:
   ```bash
   javac src/*.java
   ```
3. Run the project:
   ```bash
   java -cp src CinemaManagementApp
   ```

## Project Structure
The structure of the project is as follows:

```
/project
    /src
        CinemaConfig.java           // Singleton Pattern for configuration management
        Movie.java                  // Movie Interface
        RegularMovie.java           // Regular Movie implementation
        IMAXMovie.java              // IMAX Movie implementation
        MovieFactory.java           // Abstract Factory for creating movies
        RegularMovieFactory.java    // Factory for Regular Movies
        IMAXMovieFactory.java       // Factory for IMAX Movies
        Button.java                 // Button Interface for UI components
        DarkThemeButton.java        // Button for Dark Theme
        LightThemeButton.java       // Button for Light Theme
        UIFactory.java              // Abstract Factory for UI Theme components
        TicketBooking.java          // Class for managing ticket bookings
        TicketBookingBuilder.java   // Builder for Ticket Booking creation
        MovieSchedule.java          // Interface for Movie Schedules
        StandardSchedule.java       // Prototype implementation for Movie Schedules
        CinemaManagementApp.java    // Main application entry point
```