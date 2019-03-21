package projlabhazi;

import java.util.HashMap;
import java.util.Map;

public class ComInt { //interactive command interpreter for testing

	public static void main(String[] args) {
		HashMap<Integer, Panda> Pandas = new HashMap<Integer, Panda>();
		HashMap<Integer, Tile> Tiles = new HashMap<Integer, Tile>();
		HashMap<Integer, Object> Objects = new HashMap<Integer, Object>();
		Entrance entrance = null;
		Game game = null;
		
		int counter = 0;
		
		String line = System.console().readLine();
		String[] input = line.split(" ");
		while (true) {
			if (input.length < 1)
				continue;
			switch (input[0].toLowerCase()) {
			case "exit":
				return;
			case "newgame":
				//TODO: game-et inicializálni a Tiles-szal valahogy
				break;
			case "createtile":
				if (input.length < 2)
					Tiles.put(counter++, new Tile());
				else if (input[1].toLowerCase() == "breaking")
					Tiles.put(counter++, new BreakingTile());
				break;
			case "deletetile":
				Tiles.remove(Integer.parseInt(input[1]));
				break;
			case "addneighbour":
				Tiles.get(Integer.parseInt(input[1]))
					.addNeighbour(Tiles.get(Integer.parseInt(input[2])));
				break;
			case "removeneighbour":
				Tiles.get(Integer.parseInt(input[1]))
				.removeNeighbour(Tiles.get(Integer.parseInt(input[2])));
				break;
			case "createpanda":
				if (input.length < 2)
					continue;
				switch (input[1].toLowerCase()) {
				case "chocolate":
					Pandas.put(counter++, new ChocolatePanda());
					break;
				case "game":
					Pandas.put(counter++, new GamePanda());
					break;
				case "sleep":
					Pandas.put(counter++, new SleepPanda());
					break;
				default:
					break;
				}
				break;
			case "deletepanda":
				Pandas.remove(Integer.parseInt(input[1]));
				break;
			case "setentrance":
				entrance = new Entrance();
				entrance.setTile(Tiles.get(Integer.parseInt(input[1])));
				break;
			case "createobject":
				switch (input[1].toLowerCase()) {
				case "armchair":
					Objects.put(counter++, new ArmChair());
					break;
				case "chocolatemachine":
					Objects.put(counter++, new ChocolateMachine());
					break;
				case "gamemachine":
					Objects.put(counter++, new GameMachine());
					break;
				case "wardrobe":
					Objects.put(counter++, new Wardrobe());
					break;
				case "exit":
					Objects.put(counter++, new Exit());
					break;
				default:
					break;
				}
				break;
			case "deleteobject":
				Objects.remove(Integer.parseInt(input[1]));
				break;
			case "putpanda":
				Tiles.get(Integer.parseInt(input[1]))
					.setObject(Pandas.get(Integer.parseInt(input[2])));
				break;
			case "putobject":
				Tiles.get(Integer.parseInt(input[1]))
					.setObject(Objects.get(Integer.parseInt(input[2])));
				break;
			case "listall":
				listPandas(Pandas);
				listTiles(Tiles);
				listObjects(Objects);
				break;
			case "step":
				game.getTimer().tick();
				break;
			default:
				break;
			}
		}
		
	}
	
	private static void listPandas(HashMap<Integer, Panda> Pandas) {
		System.out.println("List of pandas:");
		for (Map.Entry<Integer, Panda> panda : Pandas.entrySet()) {
			System.out.println(" - Id: " + panda.getKey() + " - panda");
		}
	}
	private static void listTiles(HashMap<Integer, Tile> Tiles) {
		System.out.println("List of tiles:");
		for (Map.Entry<Integer, Tile> tile : Tiles.entrySet()) {
			System.out.println(" - Id: " + tile.getKey() + " - tile " /*+ tile.getValue().getObject() == null ? "" : tile.getValue().getObject()*/);
		}
	}
	private static void listObjects(HashMap<Integer, Object> Objects) {
		System.out.println("List of objects:");
		for (Map.Entry<Integer, Object> object : Objects.entrySet()) {
			System.out.println(" - Id: " + object.getKey() + " - object : " + object.getClass());
		}
	}
}



