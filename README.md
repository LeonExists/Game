# Game

A 2D tile-based game engine written from scratch in Java using Swing for rendering.

## Features

- **Tile-based rendering system**: Efficient grid-based world rendering with 64x64 pixel tiles
- **Map loading**: Load game maps from text files with neighbor-aware tile selection
- **Game object system**: Manage sprites and game entities with automatic rendering
- **Canvas system**: Custom JPanel-based rendering with synchronized object management

## Project Structure

```
Game/
├── src/
│   ├── Main.java           # Entry point and game loop
│   ├── Canvas.java         # JFrame/JPanel rendering canvas
│   ├── GameObject.java     # Sprite/entity class with position and image
│   ├── Map.java            # Map loading and tile-based world builder
│   ├── Game.java           # Utility functions (sleep, etc.)
│   ├── images/             # Sprite assets
│   │   ├── player.png
│   │   └── ground_1.png
│   └── maps/               # Map data files
│       └── map_1.txt
└── README.md
```

## How It Works

### Map System
Maps are loaded from text files where `0` represents tiles and spaces represent empty cells. The system uses neighbor detection to automatically select appropriate tile sprites based on surrounding tiles (supporting 16 different configurations for seamless tiling).

### Game Objects
Each GameObject has:
- Position (x, y) in tile coordinates
- Image sprite (64x64 pixels)
- Automatic rendering through the Canvas

### Game Loop
The main game loop runs at 2 FPS (500ms delay) and currently moves the player sprite horizontally across the screen.

## Running the Game

```bash
cd Game/src
javac *.java
java Main
```

## Requirements

- Java 8 or higher
- No external dependencies (uses Java Swing)
