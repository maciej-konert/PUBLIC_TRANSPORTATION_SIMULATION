# Public Transport Simulation

This project implements a comprehensive simulation of a public transport system, focusing on tram operations within an urban environment. The simulation allows for the analysis of transport efficiency, passenger flow, and system statistics.

## Project Overview

The Public Transport Simulation project models the behavior of tram lines and their interaction with passengers in a city environment. The system supports random events generation to ensure each simulation run produces unique results, providing valuable insights into transport system optimization.

## Language Note

The project is currently implemented with Polish naming conventions and documentation. A translation to English is planned for the future to enhance accessibility.

## Task Description

Complete task specifications can be found in:
- `task_en.pdf` (English version)
- `task_pl.pdf` (Polish version)

## Project Structure

### Documentation
- `ClassDiagram.dia`: Visual representation of the project's class hierarchy and relationships

### Main Directory
Contains support files for the simulation framework:
- `Losowanie.java`: Random event generator that ensures simulation variability
- `Main.java`: Entry point of the application that initiates the simulation
- `Skaner.java`: User input handler for simulation parameters
- `Statystyka.java`: Statistics collection module that tracks metrics such as average tram wait times
- `Symulacja.java`: Core simulation engine that coordinates the execution of events

### Zadanie Directory
Implements the core transportation elements:
- Tram vehicles and their behaviors
- Route definitions and scheduling
- Additional components necessary for the transport system simulation

### Zdarzenia Directory
Contains implementations of various simulation events:
- Tram arrival events
- Passenger boarding/alighting events
- Schedule-related events
- Queue management for chronological event processing

## Building and Running

To compile and execute the simulation, run the `main/Main.java` file using your preferred Java development environment.

## Input Format

The simulation requires input parameters via standard input. Below is an example of valid input:

```
3 
10
3 
Banacha 
Krakowskie 
Centrum 
15 
5 
1 
2 3 Banacha 3 Centrum 2 Krakowskie 10
```

The input defines parameters such as the number of stops, operation duration, stop names, passenger generation rates, and tram line configurations.

## Design Philosophy

The project was architected with extensibility as a primary concern. The modular design allows for easy addition of:
- Different vehicle types beyond trams
- New event categories
- Additional statistical measurements
- Enhanced passenger behaviors

This approach ensures the simulation can be adapted to model various transportation scenarios with minimal modifications to the core framework.

## Project Evaluation

The implementation received a score of 9.5/10 in official evaluation, demonstrating adherence to the specified requirements.
