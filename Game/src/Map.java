import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    private final String mapSource = "maps/";
    private static char[][] map;

    public static String[] tilemap = {
        "ground_1.png",  // 0:  none
        "ground_1.png",  // 1:  up
        "ground_1.png",  // 2:  down
        "ground_1.png",  // 3:  up + down
        "ground_1.png",  // 4:  left
        "ground_1.png",  // 5:  up + left
        "ground_1.png",  // 6:  down + left
        "ground_1.png",  // 7:  up + down + left
        "ground_1.png",  // 8:  right
        "ground_1.png",  // 9:  up + right
        "ground_1.png", // 10: down + right
        "ground_1.png", // 11: up + down + right
        "ground_1.png", // 12: left + right
        "ground_1.png", // 13: up + left + right
        "ground_1.png", // 14: down + left + right
        "ground_1.png"  // 15: all neighbors (up + down + left + right)
    };

    public Map(Canvas canvas, String filename) throws IOException {
        map = loadMapFromFile(filename);
        build(canvas);
    }

    public char[][] loadMapFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(mapSource + filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        if (lines.isEmpty()) {
            return new char[0][0];
        }

        int rows = lines.size();
        int cols = lines.get(0).length();
        char[][] mapArray = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < Math.min(line.length(), cols); j++) {
                mapArray[i][j] = line.charAt(j);
            }
        }

        return mapArray;
    }

    public char getCell(int x, int y) {
        if ((y >= 0 && y < map.length && x >= 0 && x < map[y].length)) {
            char cell = map[y][x];
            return cell;
        }

        return 0;
    }

    public int getNeighbors(int x, int y) {
        int index = 0;

        // up (bit 0)
        if(getCell(x, y + 1) != ' ') {
            index += 1;
        }

        // down (bit 1)
        if(getCell(x, y - 1) != ' ') {
            index += 2;
        }

        // left (bit 2)
        if(getCell(x - 1, y) != ' ') {
            index += 4;
        }

        // right (bit 3)
        if(getCell(x + 1, y) != ' ') {
            index += 8;
        }

        return index;
    }

    public void build(Canvas canvas) {
        for (int y = 0; y < map.length; y += 2) {
            for (int x = 0; x < map[y].length; x += 2) {
                char cell = getCell(x, y);

                // skip empty cells
                if (cell == ' ') {
                    continue;
                }

                int index = getNeighbors(x, y);

                // create tiles
                GameObject newTile = new GameObject(canvas, x/2, y/2, tilemap[index]);
                canvas.addGameObject(newTile);
            }
        }
    }
}
