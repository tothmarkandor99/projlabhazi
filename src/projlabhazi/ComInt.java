package projlabhazi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComInt { // interactive command interpreter for testing

	public static void main(String[] args) {
		HashMap<Integer, Panda> Pandas = new HashMap<Integer, Panda>();
		HashMap<Integer, Tile> Tiles = new HashMap<Integer, Tile>();
		HashMap<Integer, Object> Objects = new HashMap<Integer, Object>();
		Tile entranceTile = null;
		Timer timer = new Timer();
		Game game = new Game(timer);

		int counter = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		String[] input = new String[0];
		while (true) {
			try {
				line = br.readLine();
				input = line.split(" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (input.length < 1)
				continue;
			switch (input[0].toLowerCase()) {
			case "exit":
				return;
			case "newgame":
				// TODO: game-et inicializ�lni a Tiles-szal valahogy
				ArrayList<Tile> tempTiles = new ArrayList<Tile>();
				for (Map.Entry<Integer, Tile> tile : Tiles.entrySet()) {
					tempTiles.add(tile.getValue());
				}
				game.newGame(tempTiles, entranceTile, Pandas.size());
				break;
			case "createtile":
				if (input.length == 1) {
					Tiles.put(counter++, new Tile());
					Tiles.get(counter - 1).id = counter - 1;
				} else if (input[1].toLowerCase().equals("breaking")) {
					Tiles.put(counter++, new BreakingTile());
				}
				break;
			case "deletetile":
				Tiles.remove(Integer.parseInt(input[1]));
				break;
			case "addneighbour":
				Tiles.get(Integer.parseInt(input[1])).addNeighbour(Tiles.get(Integer.parseInt(input[2])));
				System.out.println("Tile " + input[1] + " has " + Tiles.get(Integer.parseInt(input[1])).getSides() + " neighbours");
				break;
			case "removeneighbour":
				Tiles.get(Integer.parseInt(input[1])).removeNeighbour(Tiles.get(Integer.parseInt(input[2])));
				break;
			case "createpanda":
				if (input.length < 2)
					continue;
				switch (input[1].toLowerCase()) {
				case "chocolate":
					Pandas.put(counter++, new ChocolatePanda(game));
					timer.addSteppable(Pandas.get(counter - 1));
					break;
				case "game":
					Pandas.put(counter++, new GamePanda(game));
					timer.addSteppable(Pandas.get(counter - 1));
				break;
				case "sleep":
					Pandas.put(counter++, new SleepPanda(game));
					timer.addSteppable(Pandas.get(counter - 1));
				break;
				default:
					break;
				}
				break;
			case "deletepanda":
				Pandas.remove(Integer.parseInt(input[1]));
				break;
			case "setentrance":
				entranceTile = (Tiles.get(Integer.parseInt(input[1])));
				break;
			case "createobject":
				switch (input[1].toLowerCase()) {
				case "armchair":
					Objects.put(counter++, new ArmChair());
					timer.addSteppable(Objects.get(counter - 1));
					break;
				case "chocolatemachine":
					Objects.put(counter++, new ChocolateMachine());
					timer.addSteppable(Objects.get(counter - 1));
					break;
				case "gamemachine":
					Objects.put(counter++, new GameMachine());
					timer.addSteppable(Objects.get(counter - 1));
					break;
				case "wardrobe":
					Objects.put(counter++, new Wardrobe());
					timer.addSteppable(Objects.get(counter - 1));
					break;
				case "exit":
					Objects.put(counter++, new Exit());
					timer.addSteppable(Objects.get(counter - 1));
					break;
				default:
					break;
				}
				break;
			case "deleteobject":
				Objects.remove(Integer.parseInt(input[1]));
				break;
			case "putpanda":
				Tiles.get(Integer.parseInt(input[2])).setObject(Pandas.get(Integer.parseInt(input[1])));
				Pandas.get(Integer.parseInt(input[1])).setTile(Tiles.get(Integer.parseInt(input[2])));
				break;
			case "putobject":
				Tiles.get(Integer.parseInt(input[2])).setObject(Objects.get(Integer.parseInt(input[1])));
				Objects.get(Integer.parseInt(input[1])).setTile(Tiles.get(Integer.parseInt(input[2])));
				break;
			case "listall": // A tesztel�shez inicializ�lt list�k tartalm�t �rja ki
				listPandas(Pandas);
				listTiles(Tiles);
				listObjects(Objects);
				break;
			case "tick":
				game.getTimer().tick();
				break;
			case "step":
				game.getOrangutan().step();
				break;
			case "turn":
				if (input.length < 2)
					return;
				game.simulateTurn(input[1].toLowerCase() == "left" ? true : false);
				break;
			case "printtiles": // A j�t�k elind�t�sa ut�n a csemp�ken �ll� objektumokat list�zza ki
				game.printTiles();
				break;
			case "showscore":
				System.out.println("Jelenlegi pontsz�m: " + game.getScore());
				break;
			case "liststeppables":
				timer.listAll();
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
			System.out.print(" - Id: " + tile.getKey()
					+ " - " + tile.getValue().getClass() + "\t");
			if (tile.getValue().getObject() == null) {
				System.out.print("�res");
			} else {
				System.out.print(tile.getValue().getObject().getClass());
			}
			System.out.print("\tNeighbours: ");
			for(int i=0; i<tile.getValue().getSides(); i++) 
				System.out.print("\t" + i +": " + tile.getValue().getNeighbour(i).getClass());
			System.out.println();
		}
	}

	private static void listObjects(HashMap<Integer, Object> Objects) {
		System.out.println("List of objects:");
		for (Map.Entry<Integer, Object> object : Objects.entrySet()) {
			System.out.println(" - Id: " + object.getKey() + " - object : " + object.getValue().getClass());
		}
	}
}
