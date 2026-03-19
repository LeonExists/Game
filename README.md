# Game

A 2D tile-based game engine written from scratch in Java using Swing for rendering.

## Features

- **Tile-based rendering system**: Efficient grid-based world rendering with 64x64 pixel tiles
- **Map loading**: Load game maps from text files with neighbor-aware tile selection
- **Game object system**: Manage sprites and game entities with automatic rendering
- **Canvas system**: Custom JPanel-based rendering with synchronized object management
- **Input management**: Singleton-based keyboard input handler supporting both arrow keys and WASD
- **Player controls**: Real-time keyboard-driven player movement with configurable speed

## Project Structure

```
Game/
├── src/
│   ├── Main.java           # Entry point and game loop
│   ├── Canvas.java         # JFrame/JPanel rendering canvas
│   ├── GameObject.java     # Sprite/entity class with position and image
│   ├── Player.java         # Player entity with movement logic
│   ├── InputManager.java   # Singleton keyboard input handler
│   ├── Map.java            # Map loading and tile-based world builder
│   ├── Game.java           # Utility functions (sleep, etc.)
│   ├── images/             # Sprite assets
│   │   ├── player.png
│   │   └── ground_*.png    # Tile sprites (16 variations)
│   └── maps/               # Map data files
│       └── map_1.txt
└── README.md
```

## How It Works

### Map System
Maps are loaded from text files where `0` represents tiles and spaces represent empty cells. The system uses neighbor detection to automatically select appropriate tile sprites based on surrounding tiles (supporting 16 different configurations for seamless tiling).

### Game Objects
Each GameObject has:
- Position (x, y) in pixel coordinates
- Image sprite (64x64 pixels by default)
- Robust image loading with classpath and filesystem fallbacks
- Automatic rendering through the Canvas

### Input System
The InputManager uses the Singleton pattern to handle keyboard input globally:
- Supports both arrow keys and WASD for movement
- Tracks key states using a HashMap for efficient lookup
- Provides utility methods for clearing states and querying pressed keys

### Player
The Player class extends GameObject with:
- Configurable movement speed (default 8 pixels per frame)
- Integrated movement logic that responds to InputManager
- Smooth directional movement in the game loop

### Game Loop
The main game loop runs at 30 FPS (1000/30 ms delay) and handles:
- Player input and movement updates
- Canvas repaint for smooth rendering

## Running the Game

```bash
cd Game/src
javac *.java
java Main
```

## Requirements

- Java 8 or higher
- No external dependencies (uses Java Swing)
