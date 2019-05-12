package projlabhazi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class ComInt { // interactive command interpreter for testing
	//private static PrintStream ki = System.out;
	
	public static void main(String[] args) {
		JFrame F = new JFrame();
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI G = new GUI();
		Timer timer = new Timer();
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for (int i = 0; i < 24; i++) {
			Tile tile = new Tile();
			tile.id = i;
			tiles.add(tile);
		}
		ArrayList<Entrance> entranceTiles = new ArrayList<Entrance>();
		int countPandas = 0;
		
		
		Game g = new Game(timer);
		g.newGame(tiles, entranceTiles, countPandas);
		G.setGame(g);
		F.add(G);
		F.setSize(800, 600);
		F.setVisible(true);
	}
	
	/*public static void StartComInt() {
		HashMap<Integer, Panda> Pandas = new HashMap<Integer, Panda>();
		HashMap<Integer, Tile> Tiles = new HashMap<Integer, Tile>();
		HashMap<Integer, Object> Objects = new HashMap<Integer, Object>();
		ArrayList<Entrance> entranceTiles = new ArrayList<Entrance>();
		Timer timer = new Timer();
		Game game = new Game(timer);

		int counter = 0;
		boolean canLoad = true;
		
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
			} catch (NullPointerException e) {
				ki.close();
				break;
			}
			if (input.length < 1)
				continue;
			switch (input[0].toLowerCase()) {
			case "load":
				if (canLoad) {
					if (input.length < 2)
						continue;
					try {
						br = new BufferedReader(new FileReader(input[1]));
						ki = new PrintStream(new FileOutputStream(input[1] + ".ki"));
					} catch (FileNotFoundException e) {
						System.out.println("A fájl nem található");
					}
				}
				break;
			case "exit":
				ki.close();
				return;
			case "newgame":
				ArrayList<Tile> tempTiles = new ArrayList<Tile>();
				for (Map.Entry<Integer, Tile> tile : Tiles.entrySet()) {
					tempTiles.add(tile.getValue());
				}
				game.newGame(tempTiles, entranceTiles, Pandas.size());
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
				entranceTiles.add((Entrance)Tiles.get(Integer.parseInt(input[1])));
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
			case "listall": // A teszteléshez inicializált listák tartalmát írja ki
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
			case "printtiles": // A játék elindítása után a csempéken álló objektumokat listázza ki
				game.printTiles();
				break;
			case "showscore":
				ComInt.println("Jelenlegi pontszám: " + game.getScore());
				break;
			case "liststeppables":
				timer.listAll();
				break;
			case "chooseorangutan":
				if (input.length < 2)
					continue;
				game.activateOrangutan(Integer.parseInt(input[1]));
				break;
			case "orangutanrealease":
				game.getOrangutan().release();
				break;
			case "setrandom":
				if (input.length < 3)
					return;
				switch (input[2]) {
				case "on":
					if (Objects.containsKey(Integer.parseInt(input[1])))
						Objects.get(Integer.parseInt(input[1])).setRandomState(0);
					if (Pandas.containsKey(Integer.parseInt(input[1])))
						Pandas.get(Integer.parseInt(input[1])).setRandomState(0);
					break;
				case "off":
					if (Objects.containsKey(Integer.parseInt(input[1])))
						Objects.get(Integer.parseInt(input[1])).setRandomState(1);
					if (Pandas.containsKey(Integer.parseInt(input[1])))
						Pandas.get(Integer.parseInt(input[1])).setRandomState(1);
					break;
				case "random":
					if (Objects.containsKey(Integer.parseInt(input[1])))
						Objects.get(Integer.parseInt(input[1])).setRandomState(2);
					if (Pandas.containsKey(Integer.parseInt(input[1])))
						Pandas.get(Integer.parseInt(input[1])).setRandomState(2);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
			canLoad = false; //Csak az elsõ parancs lehet load
		}
	}

	private static void listPandas(HashMap<Integer, Panda> Pandas) {
		ComInt.println("List of pandas:");
		for (Map.Entry<Integer, Panda> panda : Pandas.entrySet()) {
			ComInt.println(" - Id: " + panda.getKey() + " - panda");
		}
	}

	private static void listTiles(HashMap<Integer, Tile> Tiles) {
		ComInt.println("List of tiles:");
		for (Map.Entry<Integer, Tile> tile : Tiles.entrySet()) {
			ComInt.print(" - Id: " + tile.getKey()
					+ " - " + tile.getValue().getClass() + "\t");
			if (tile.getValue().getObject() == null) {
				ComInt.print("üres");
			} else {
				ComInt.print(tile.getValue().getObject().getClass().toString());
			}
			ComInt.print("\tNeighbours: ");
			for(int i=0; i<tile.getValue().getSides(); i++) 
				ComInt.print("\t" + i +": " + tile.getValue().getNeighbour(i).getClass());
			ComInt.println();
		}
	}

	private static void listObjects(HashMap<Integer, Object> Objects) {
		ComInt.println("List of objects:");
		for (Map.Entry<Integer, Object> object : Objects.entrySet()) {
			ComInt.println(" - Id: " + object.getKey() + " - object : " + object.getValue().getClass());
		}
	}
	
	public static void print(String s) {
		ki.print(s);
	}
	
	public static void println(String s) {
		ki.println(s);
	}
	public static void println() {
		ki.println();
	}*/
	
}
